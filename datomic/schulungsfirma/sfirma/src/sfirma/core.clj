(ns sfirma.core)
(require '[datomic.api :as d])

(def db-uri "datomic:mem://schulungsfirma")
(d/create-database db-uri)
(def conn (d/connect db-uri))


(def rule '[
  [(setztvor ?k)
  [?e :setztvor/kid ?k]]

  ])

(def person-schema [
     {:db/ident :person/pid
     :db/valueType :db.type/long
     :db/cardinality :db.cardinality/one}

     {:db/ident :person/nname
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}

     {:db/ident :person/vname
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}

     {:db/ident :person/ort
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}
     
     {:db/ident :person/land
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}
])
@(d/transact conn person-schema)

(def person-input [
     {:person/pid 101 :person/nname "Bach" :person/vname "Johann Sebastian" :person/ort "Leipzig" :person/land "D"}
     {:person/pid 102 :person/nname "Händel" :person/vname "Georg Friedrich" :person/ort "London" :person/land "GB"}
     {:person/pid 103 :person/nname "Haydn" :person/vname "Joseph" :person/ort "Wien" :person/land "A"}
     {:person/pid 104 :person/nname "Mozart" :person/vname "Wolfgang Amadeus" :person/ort "Salzburg" :person/land "A"}
     {:person/pid 105 :person/nname "Beethoven" :person/vname "Ludwig van" :person/ort "Wien" :person/land "A"}
     {:person/pid 106 :person/nname "Schubert" :person/vname "Franz" :person/ort "Wien" :person/land "A"}
     {:person/pid 107 :person/nname "Berlioz" :person/vname "Hector" :person/ort "Paris" :person/land "F"}
     {:person/pid 108 :person/nname "Liszt" :person/vname "Franz" :person/ort "Wien" :person/land "A"}
     {:person/pid 109 :person/nname "Wagner" :person/vname "Richard" :person/ort "München" :person/land "D"}
     {:person/pid 110 :person/nname "Verdi" :person/vname "Giuseppe" :person/ort "Busseto" :person/land "I"}
     {:person/pid 111 :person/nname "Bruckner" :person/vname "Anton" :person/ort "Linz" :person/land "A"}
     {:person/pid 112 :person/nname "Brahms" :person/vname "Johannes" :person/ort "Wien" :person/land "A"}
     {:person/pid 113 :person/nname "Bizet" :person/vname "Georges" :person/ort "Paris" :person/land "F"}
     {:person/pid 114 :person/nname "Tschaikowskij" :person/vname "Peter" :person/ort "Moskau" :person/land "RUS"}
     {:person/pid 115 :person/nname "Puccini" :person/vname "Giacomo" :person/ort "Mailand" :person/land "I"}
     {:person/pid 116 :person/nname "Strauss" :person/vname "Richard" :person/ort "München" :person/land "D"}
     {:person/pid 117 :person/nname "Schönberg" :person/vname "Arnold" :person/ort "Wien" :person/land "A"}
])
@(d/transact conn person-input)

(def kurs-schema [
     {:db/ident :kurs/kid
     :db/valueType :db.type/long
     :db/cardinality :db.cardinality/one}

     {:db/ident :kurs/name
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}

     {:db/ident :kurs/tage
     :db/valueType :db.type/long
     :db/cardinality :db.cardinality/one}

     {:db/ident :kurs/preis
     :db/valueType :db.type/long
     :db/cardinality :db.cardinality/one}
])

@(d/transact conn kurs-schema)

(def kurs-input [
     {:kurs/kid 1 :kurs/name "Notenkunde" :kurs/tage 2 :kurs/preis 1400}
     {:kurs/kid 2 :kurs/name "Harmonielehre" :kurs/tage 3 :kurs/preis 2000}
     {:kurs/kid 3 :kurs/name "Rhythmik" :kurs/tage 1 :kurs/preis 700}
     {:kurs/kid 4 :kurs/name "Instrumentenkunde" :kurs/tage 2 :kurs/preis 1500}
     {:kurs/kid 5 :kurs/name "Dirigieren" :kurs/tage 3 :kurs/preis 1900}
     {:kurs/kid 6 :kurs/name "Musikgeschichte" :kurs/tage 2 :kurs/preis 1400}
     {:kurs/kid 7 :kurs/name "Komposition" :kurs/tage 4 :kurs/preis 3000}
])
@(d/transact conn kurs-input)

(def setztvor-schema [
     {:db/ident :setztvor/kid
     :db/valueType :db.type/long
     :db/cardinality :db.cardinality/one}

     {:db/ident :setztvor/kidvor
     :db/valueType :db.type/long
     :db/cardinality :db.cardinality/one}
])
@(d/transact conn setztvor-schema)

(def setztvor-input [
     {:setztvor/kid 2 :setztvor/kidvor 1}
     {:setztvor/kid 3 :setztvor/kidvor 1}
     {:setztvor/kid 5 :setztvor/kidvor 2}
     {:setztvor/kid 5 :setztvor/kidvor 3}
     {:setztvor/kid 5 :setztvor/kidvor 4}
     {:setztvor/kid 7 :setztvor/kidvor 5}
     {:setztvor/kid 7 :setztvor/kidvor 6}
])
@(d/transact conn setztvor-input)

(def referent-schema [
     {:db/ident :referent/rid
     :db/valueType :db.type/long
     :db/cardinality :db.cardinality/one}

     {:db/ident :referent/geb
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}

     {:db/ident :referent/bis
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}

     {:db/ident :referent/titel
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}
])
@(d/transact conn referent-schema)

(def referent-input [
     {:referent/rid 101 :referent/geb "1935-3-21" :referent/bis "1980-1-1"}
     {:referent/rid 103 :referent/geb "1932-4-1" :referent/bis "1991-1-1"}
     {:referent/rid 104 :referent/geb "1956-1-27" :referent/bis "1985-7-1"}
     {:referent/rid 111 :referent/geb "1924-9-4" :referent/bis "1990-7-1" :referent/titel "Mag"}
     {:referent/rid 114 :referent/geb "1940-4-25" :referent/bis "1980-7-1"}
     {:referent/rid 116 :referent/geb "1964-6-11" :referent/bis "1994-1-1" :referent/titel "Dr"}
])
@(d/transact conn referent-input)


; Alle Kurse
(def alleKurse 
    '[:find ?a ?b ?c ?d
        :where
        [?e :kurs/kid ?a]
        [?e :kurs/name ?b]
        [?e :kurs/tage ?c]
        [?e :kurs/preis ?d]
      ])

; (println(d/q alleKurse (d/db conn)))

; Kurse mit < 1500
; kurs(A, B, C, D), D < 1500.
(def alleKurse_Preiseinschraenkung 
    '[:find ?a ?b ?c ?d
        :where
        [?e :kurs/kid ?a]
        [?e :kurs/name ?b]
        [?e :kurs/tage ?c]
        [?e :kurs/preis ?d]
        [(< ?d 1500)]
      ])

;(println(d/q alleKurse_Preiseinschraenkung (d/db conn)))

; Alle Personen aus Oesterreich
(def PersOE 
    '[:find ?u ?v ?w ?x
        :where
        [?e :person/pid ?u]
        [?e :person/nname ?v]
        [?e :person/vname ?w]
        [?e :person/ort ?x]
        [?e :person/land "A"]
      ])

;(println(d/q PersOE (d/db conn)))


(def testt 
    '[:find ?k ?x
        :where
        [?e :setztvor/kid ?k]
        [?e :setztvor/kidvor ?x]
      ])

(println(d/q testt (d/db conn)))

; Welche Kurse (KNr) haben einen Kurs als Voraussetzung? 
(def kursmitVor 
    '[:find ?k
        :in $ %
        :where
        [?a :kurs/kid ?k]
        (setztvor ?k)
      ])

(println(d/q kursmitVor (d/db conn) rule))

;Welche Kurse (Name) haben einen Kurs als Voraussetzung? 
(def kursnamemitVor 
    '[:find ?n
        :in $ %
        :where
        [?a :kurs/name ?n]
        [?a :kurs/kid ?k]
        (setztvor ?k)
      ])

(println(d/q kursnamemitVor (d/db conn) rule))

; Alle Referenten die einen Titel haben
(def refmitTitel 
    '[:find ?r
        :where
        [?a :referent/rid ?r]
        [?a :referent/titel _]
      ])

(println(d/q refmitTitel (d/db conn)))

; Kurse zwischen 2 und 4 Tagen mit max durschn. Tagespreis 700:

(def Kurse_mitBeschraenkung_Fehler
    '[:find ?a ?b ?c ?d (?d / ?c)
        :where
        [?e :kurs/kid ?a]
        [?e :kurs/name ?b]
        [?e :kurs/tage ?c]
        [?e :kurs/preis ?d]
        [(> ?c 1)]
        [(< ?c 5)]
        ;[(< (/ ?d ?c) 701)]
      ])

(defn div [preis tage]
    (/ preis tage)
)

(def Kurse_mitBeschraenkung 
    '[:find ?a ?b ?c ?d
        :where
        [?e :kurs/kid ?a]
        [?e :kurs/name ?b]
        [?e :kurs/tage ?c]
        [?e :kurs/preis ?d]
        [(> ?c 1)]
        [(< ?c 5)]
        [(sfirma.core/div ?d ?c) ?avg]
        [(< ?avg 701)]
      ])

;(println(d/q Kurse_mitBeschraenkung (d/db conn)))

(def billigsterKurs 
    '[:find ?b ?mpreis
        :where
        [(datomic.api/q '[:find (min ?d)
                :where [_ :kurs/preis ?d]]
                $) [[?mpreis]]]

        [?e :kurs/kid ?a]
        [?e :kurs/name ?b]
        [?e :kurs/tage ?c]
        [?e :kurs/preis ?mpreis]
      ])

(println(d/q billigsterKurs (d/db conn)))

(defn -main
[] (println "Hello World"))