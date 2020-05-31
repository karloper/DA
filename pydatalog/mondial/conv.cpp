#include <iostream>
#include <fstream>
#include <unordered_set>
#include <algorithm>

using namespace std;

void toAscii(string& str) {
    for (auto& c: str) {
        if (static_cast<unsigned char>(c) > 127) {
            c = ' ';
        }
    }
}

inline void ReplaceAll(std::string &str, const std::string& from, const std::string& to) {
    size_t start_pos = 0;
    while((start_pos = str.find(from, start_pos)) != std::string::npos) {
        str.replace(start_pos, from.length(), to);
        start_pos += to.length(); // Handles case where 'to' is a substring of 'from'
    }
}

int main() {
    unordered_set<string> tables;

    ifstream myfile ("mondial.P");
    
    string line{};
    // get table name
    if (myfile.is_open()) {
        while (getline (myfile,line)) {
            if(line.length() > 2) {
                //ofs << "+ " + line.substr(0, line.length()-1) + "\n";
                tables.insert(line.substr(0, line.find("(")));
            }
        }
        myfile.clear();             //clear the buffer
        myfile.seekg(0, ios::beg);  //reset the reading position to beginning
        myfile.close();
    }

    ofstream ofs ("mondialPy.py", std::ofstream::out);
    ofs << "from pyDatalog import pyDatalog as pdl\n\n";
    ofs << "pdl.create_terms('"; 
    
    int cnt = 0;
    for(string s : tables) {
        cnt++;

        if(cnt != tables.size()) {
            ofs << s << ", ";
        } else {
            ofs << s << "')\n\n";
        }
    }

    myfile.open ("mondial.P", std::ifstream::in);
    if (myfile.is_open()) {
        while (getline (myfile,line)) {
            if(line.length() > 2) {
                string insert = line.substr(0, line.length()-1);
                ReplaceAll(insert, "null", "None");
                toAscii(insert);
                ofs << "+ " + insert + "\n";
            }
        }
        myfile.clear();             //clear the buffer
        myfile.seekg(0, ios::beg);  //reset the reading position to beginning
        myfile.close();
    }    

    

    ofs.close();


}