#include <iostream>
#include <fstream>
#include <algorithm>
#include <map>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

class Converter {
    private:
        string schema{};
        string input{};
        unordered_set<string> floatCol;
    public:
        Converter() {
            floatCol.insert("Longitude");
            floatCol.insert("Latitude");
            floatCol.insert("Agriculture");
            floatCol.insert("Service");
            floatCol.insert("Inflation");
            floatCol.insert("Unemployment");
            floatCol.insert("Population_Growth");
            floatCol.insert("Infant_Mortality");
            floatCol.insert("Percentage");
        }
        void createSchema(string tablename, vector<pair<string, string>> tables) {
            schema += "(def " + tablename + "-schema [\n";
            for(pair<string, string> s : tables) {

                schema += "     {:db/ident " + s.first + "\n";
                schema += "     :db/valueType " + s.second + "\n";
                schema += "     :db/cardinality :db.cardinality/one}\n\n";

            }
            schema += "])\n";

            schema += "@(d/transact conn " + tablename + "-schema)\n\n";
        }

        string getSchema() {
            return schema;
        }

        string getConnString() {
            // db zeug und inputs
            string conn{};

            conn += "(ns mondial.core)\n";
            conn += "(require '[datomic.api :as d])\n\n";
            conn += "(def db-uri \"datomic:mem://mondial\")\n";
            conn += "(d/create-database db-uri)\n";
            conn += "(def conn (d/connect db-uri))\n\n";

            return conn;
        }

        void createInput(string tablename, string values) {
            input += "(def " + tablename + "-input [\n";
            input += values;
            input += "])\n";

            input += "@(d/transact conn " + tablename + "-input)\n\n";
        }

        string getInput() {
            return input;
        }

        unordered_set<string> getFloat() {
            return floatCol;
        }

        string getMain() {
            string main = "(defn -main\n";
            main +=  "[] (println \"Hello World\"))\n";
            return main;
        }

};

class Helper {
    public:
        // gibt Anzahl der Parameter eines DS zurück
        int getParameterCount(string& line) {
            int cnt{};

            for (auto& c : line) {
                if (static_cast<unsigned char>(c) == ',') {
                    cnt++;
                }
            }

            // bei jedem GeoCoord cnt - 1
            string::size_type pos = 0;
            string target = "GeoCoord";
            while ((pos = line.find(target, pos)) != string::npos) {
                cnt--;
                pos += target.length();
            }

            // Anzahl der Parameter ist Anzahl Beistriche + 1
            return cnt+1;
        }

        vector<string> split(const string& str, const string& delim) {
            vector<string> tokens;
            size_t prev = 0, pos = 0;
            do
            {
                pos = str.find(delim, prev);
                if (pos == string::npos) pos = str.length();
                string token = str.substr(prev, pos-prev);
                if (!token.empty()) tokens.push_back(token);
                prev = pos + delim.length();
            }
            while (pos < str.length() && prev < str.length());
            return tokens;
        }

        bool startsWith(string& s, string element) {
            return (s.rfind(element, 0) == 0);
        }

        void ltrim(string &s) {
            s.erase(s.begin(), find_if(s.begin(), s.end(), [](int ch) {
                return !isspace(ch);
            }));
        }

        void rtrim(string &s) {
            s.erase(find_if(s.rbegin(), s.rend(), [](int ch) {
                return !isspace(ch);
            }).base(), s.end());
        }

        void toLower(string& s) {
            transform(s.begin(), s.end(), s.begin(),
            [](unsigned char c){ return std::tolower(c); });
        }

        bool endsWith (string const &fullString, string const &ending) {
            if (fullString.length() >= ending.length()) {
                return (0 == fullString.compare (fullString.length() - ending.length(), ending.length(), ending));
            } else {
                return false;
            }
        }

        bool hasComma(const string& s) {
            for(char c : s) {
                if(c == '.') { return true;}
            }

            return false;
        }
};

int main() {
    Converter c;
    Helper h;

    // ColumnName with column type
    vector<pair<string, string>> tables;
    vector<string> allNames;

    ifstream schemaFile ("mondial-schema.sql");

    string line{};
    bool inBody = false;
    string tablename{};
    bool firstline = true;

    if (schemaFile.is_open()) {
        while (getline (schemaFile,line)) {
            if(line.length() > 10) {
                bool invalid = false;
                
                if(h.startsWith(line, "CREATE")){
                    if(firstline)  {
                        tablename = line.substr(line.rfind("TABLE ") + 6);
                        firstline = false;
                    } else {
                        c.createSchema(tablename, tables);
                        tables.clear();
                        tablename = line.substr(line.rfind("TABLE ") + 6);
                    }
                    
                } else {
                    h.ltrim(line);
                    if(line[0] == '(') {

                        if(inBody) invalid = true;
                        else inBody = true;
                    } else if(line[line.length()-1] == ';') {
                        inBody = false;
                    }
                    
                    if(!h.startsWith(line, "CHECK") && !(h.startsWith(line, "CONSTRAINT"))) {
                        if(!invalid && !(h.startsWith(line, "OR"))){
                            vector<string> t = h.split(line, " ");
                            string colname = t.at(0);
                            string type = t.at(1);

                            if(colname[0] == '(') { colname = colname.substr(1, colname.length()); }

                            if(h.startsWith(type, "NUMBER")) {
                                type = ":db.type/float";
                            } else if(h.startsWith(type, "VARCHAR") || type == "GeoCoord") {
                                type = ":db.type/string";
                            } else if(h.startsWith(type, "DATE")) {
                                type = ":db.type/instant";
                            }

                            h.toLower(colname);
                            h.toLower(tablename);
                            if(!h.endsWith(line, "AND")) {
                                colname = ":" + tablename + "/" + colname;
                                tables.push_back(make_pair(colname, type)); 
                                allNames.push_back(colname);
                            }
                        }
                    }

                }
            }
        }

        schemaFile.close();
    }
    c.createSchema(tablename, tables);

    ifstream inputFile ("mondial-inputs.sql");
    string input{};
    int idx{};
    int columns{};
    string tname{};

    if (inputFile.is_open()) {
        while (getline (inputFile,line)) {
            if(line.length() > 3) {
                if(h.startsWith(line, "COMMIT;")) {
                    c.createInput(tname, input);
                    input = "";
                    idx += columns;
                } else {
                tname = h.split(h.split(line, "INTO ").at(1), " VALUES").at(0);
                string values = h.split(line, "VALUES (").at(1);  // remove first (
                h.rtrim(values);
                values = values.substr(0, values.size()-2); // remove );

                
                vector<string> v = h.split(values, ",");
                columns = h.getParameterCount(line);

                input += "     {\n";
                for(int i = 0; i < v.size(); i++) {
                    if(v.at(i) != "NULL") {
                        if(h.startsWith(v.at(i), "'")){
                            if(!h.endsWith(v.at(i), "'")) {
                                v.at(i) = v.at(i) + v.at(i+1);
                                v.erase (v.begin()+i+1);
                            }

                            v.at(i)[0] = '"';
                            v.at(i)[v.at(i).length()-1] = '"';
                            
                        } else {
                            if(!h.startsWith(v.at(i), "GeoCoord")) {
                                if(!h.hasComma(v.at(i))) {
                                    v.at(i) += ".0";
                                }
                            } else {
                                string temp = "\"";
                                temp += v.at(i) + "," +  v.at(i+1) + "\"";
                                v.erase (v.begin()+i+1);

                                v.at(i) = temp;
                            }
                        }

                        if((tname == "organization" &&  i == 5) ||
                           (tname == "politics" && i == 1)) {
                               v.at(i) = "#inst " + v.at(i);
                        }

                        input += "     " + allNames.at(i+idx) + " " + v.at(i) + "\n";
                    }
                }

                input += "     }\n\n"; }
            }
        }

        inputFile.close();
    }
    
    ofstream ofs ("mondial.clj", std::ofstream::out);

    ofs << c.getConnString();
    ofs << c.getSchema();
    ofs << c.getInput();
    ofs << c.getMain();
    ofs.close(); 
    
}