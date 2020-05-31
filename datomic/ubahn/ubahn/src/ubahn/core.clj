(ns ubahn.core)
(require '[datomic.api :as d])

(def db-uri "datomic:mem://ubahn")
(d/create-database db-uri)
(def conn (d/connect db-uri))


(defn incr [c]
    (+ c 1)
)

(def rule '[
  [(direkt ?v ?n ?l)
    [?e :direkt/von ?v]
    [?e :direkt/nach ?n]
    [?e :direkt/linie ?l]
  ]

  [(bidirekt ?v ?n ?l)
    (direkt ?v ?n ?l)
  ]

  [(bidirekt ?v ?n ?l)
    (direkt ?n ?v ?l)
  ]

  [(line ?v ?n ?l)
    (bidirekt ?v ?n ?l)
  ]

  [(line ?v ?n ?l)
    (line ?v ?x ?l)
    (line ?x ?n ?l)
  ]

  [(reachableCnt ?v ?n ?c)
    (direkt ?v ?n ?a)  
    (1 ?c)
  ]

  [(reachableCnt ?v ?n ?c)
    (reachableCnt ?v ?x ?cntX)
    (direkt ?x, ?n, ?a)
    [(ubahn.core/incr ?cntX) ?c]
  ]

  ])

(def direkt-schema [
     {:db/ident :direkt/von
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}

     {:db/ident :direkt/nach
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}

     {:db/ident :direkt/linie
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}
])
@(d/transact conn direkt-schema)

(def direkt-input [
     {:direkt/von "olympia_einkaufszentrum" :direkt/nach "georg_brauchle_ring" :direkt/linie "u1"}
     {:direkt/von "georg_brauchle_ring" :direkt/nach "westfriedhof" :direkt/linie "u1"}
     {:direkt/von "westfriedhof" :direkt/nach "gern" :direkt/linie "u1"}
     {:direkt/von "gern" :direkt/nach "rotkreuzplatz" :direkt/linie "u1"}
     {:direkt/von "rotkreuzplatz" :direkt/nach "maillingerstrasse" :direkt/linie "u1"}
     {:direkt/von "maillingerstrasse" :direkt/nach "stiglmaierplatz" :direkt/linie "u1"}
     {:direkt/von "stiglmaierplatz" :direkt/nach "hauptbahnhof" :direkt/linie "u1"}
     {:direkt/von "hauptbahnhof" :direkt/nach "sendlinger_tor" :direkt/linie "u1"}
     {:direkt/von "sendlinger_tor" :direkt/nach "fraunhoferstrasse" :direkt/linie "u1"}
     {:direkt/von "fraunhoferstrasse" :direkt/nach "kolumbusplatz" :direkt/linie "u1"}
     {:direkt/von "kolumbusplatz" :direkt/nach "candidplatz" :direkt/linie "u1"}
     {:direkt/von "candidplatz" :direkt/nach "wettersteinplatz" :direkt/linie "u1"}
     {:direkt/von "wettersteinplatz" :direkt/nach "st_quirin_platz" :direkt/linie "u1"}
     {:direkt/von "st_quirin_platz" :direkt/nach "mangfallplatz" :direkt/linie "u1"}

     ;u2
     {:direkt/von "feldmoching" :direkt/nach "hasenbergl" :direkt/linie "u2"}
     {:direkt/von "hasenbergl" :direkt/nach "duelferstrasse" :direkt/linie "u2"}
     {:direkt/von "duelferstrasse" :direkt/nach "harthof" :direkt/linie "u2"}
     {:direkt/von "harthof" :direkt/nach "am_hart" :direkt/linie "u2"}
     {:direkt/von "am_hart" :direkt/nach "frankfurter_ring" :direkt/linie "u2"}
     {:direkt/von "frankfurter_ring" :direkt/nach "milbertshofen" :direkt/linie "u2"}
     {:direkt/von "milbertshofen" :direkt/nach "scheidplatz" :direkt/linie "u2"}
     {:direkt/von "scheidplatz" :direkt/nach "hohenzollernplatz" :direkt/linie "u2"}
     {:direkt/von "hohenzollernplatz" :direkt/nach "josephsplatz" :direkt/linie "u2"}
     {:direkt/von "josephsplatz" :direkt/nach "theresienstrasse" :direkt/linie "u2"}
     {:direkt/von "theresienstrasse" :direkt/nach "koenigsplatz" :direkt/linie "u2"}
     {:direkt/von "koenigsplatz" :direkt/nach "hauptbahnhof" :direkt/linie "u2"}
     {:direkt/von "hauptbahnhof" :direkt/nach "sendlinger_tor" :direkt/linie "u2"}
     {:direkt/von "sendlinger_tor" :direkt/nach "fraunhoferstrasse" :direkt/linie "u2"}
     {:direkt/von "fraunhoferstrasse" :direkt/nach "kolumbusplatz" :direkt/linie "u2"}
     {:direkt/von "kolumbusplatz" :direkt/nach "silberhornstrasse" :direkt/linie "u2"}
     {:direkt/von "silberhornstrasse" :direkt/nach "unterbergstrasse" :direkt/linie "u2"}
     {:direkt/von "unterbergstrasse" :direkt/nach "giesing" :direkt/linie "u2"}
     {:direkt/von "giesing" :direkt/nach "karl_preis_platz" :direkt/linie "u2"}
     {:direkt/von "karl_preis_platz" :direkt/nach "innsbrucker_ring" :direkt/linie "u2"}
     {:direkt/von "innsbrucker_ring" :direkt/nach "josephsburg" :direkt/linie "u2"}
     {:direkt/von "josephsburg" :direkt/nach "kreillerstrasse" :direkt/linie "u2"}
     {:direkt/von "kreillerstrasse" :direkt/nach "trudering" :direkt/linie "u2"}
     {:direkt/von "trudering" :direkt/nach "moosfeld" :direkt/linie "u2"}
     {:direkt/von "moosfeld" :direkt/nach "messestadt_west" :direkt/linie "u2"}
     {:direkt/von "messestadt_west" :direkt/nach "messestadt_ost" :direkt/linie "u2"}

      ;u3
     {:direkt/von "moosach" :direkt/nach "moosacher_st_martins_platz" :direkt/linie "u3"}
     {:direkt/von "moosacher_st_martins_platz" :direkt/nach "olympia_einkaufszentrum" :direkt/linie "u3"}
     {:direkt/von "olympia_einkaufszentrum" :direkt/nach "oberwiesenfeld" :direkt/linie "u3"}
     {:direkt/von "oberwiesenfeld" :direkt/nach "olympiazentrum" :direkt/linie "u3"}
     {:direkt/von "olympiazentrum" :direkt/nach "petuelring" :direkt/linie "u3"}
     {:direkt/von "petuelring" :direkt/nach "scheidplatz" :direkt/linie "u3"}
     {:direkt/von "scheidplatz" :direkt/nach "bonner_platz" :direkt/linie "u3"}
     {:direkt/von "bonner_platz" :direkt/nach "muenchner_freiheit" :direkt/linie "u3"}
     {:direkt/von "muenchner_freiheit" :direkt/nach "giselastrasse" :direkt/linie "u3"}
     {:direkt/von "giselastrasse" :direkt/nach "universitaet" :direkt/linie "u3"}
     {:direkt/von "universitaet" :direkt/nach "odeonsplatz" :direkt/linie "u3"}
     {:direkt/von "odeonsplatz" :direkt/nach "marienplatz" :direkt/linie "u3"}
     {:direkt/von "marienplatz" :direkt/nach "sendlinger_tor" :direkt/linie "u3"}
     {:direkt/von "sendlinger_tor" :direkt/nach "goetheplatz" :direkt/linie "u3"}
     {:direkt/von "goetheplatz" :direkt/nach "poccistrasse" :direkt/linie "u3"}
     {:direkt/von "poccistrasse" :direkt/nach "implerstrasse" :direkt/linie "u3"}
     {:direkt/von "implerstrasse" :direkt/nach "brudermuehlstrasse" :direkt/linie "u3"}
     {:direkt/von "brudermuehlstrasse" :direkt/nach "thalkirchen" :direkt/linie "u3"}
     {:direkt/von "thalkirchen" :direkt/nach "obersendling" :direkt/linie "u3"}
     {:direkt/von "obersendling" :direkt/nach "aidenbachstrasse" :direkt/linie "u3"}
     {:direkt/von "aidenbachstrasse" :direkt/nach "machtlfinger_strasse" :direkt/linie "u3"}
     {:direkt/von "machtlfinger_strasse" :direkt/nach "forstenrieder_allee" :direkt/linie "u3"}
     {:direkt/von "forstenrieder_allee" :direkt/nach "basler_str" :direkt/linie "u3"}
     {:direkt/von "basler_str" :direkt/nach "forstenried_west" :direkt/linie "u3"}

      ;u4
     {:direkt/von "westendstrasse" :direkt/nach "heimeranplatz" :direkt/linie "u4"}
     {:direkt/von "heimeranplatz" :direkt/nach "schwanthalerhoehe" :direkt/linie "u4"}
     {:direkt/von "schwanthalerhoehe" :direkt/nach "theresienwiese" :direkt/linie "u4"}
     {:direkt/von "theresienwiese" :direkt/nach "hauptbahnhof" :direkt/linie "u4"}
     {:direkt/von "hauptbahnhof" :direkt/nach "karlsplatz" :direkt/linie "u4"}
     {:direkt/von "karlsplatz" :direkt/nach "odeonsplatz" :direkt/linie "u4"}
     {:direkt/von "odeonsplatz" :direkt/nach "lehel" :direkt/linie "u4"}
     {:direkt/von "lehel" :direkt/nach "max_weber_platz" :direkt/linie "u4"}
     {:direkt/von "max_weber_platz" :direkt/nach "prinzregentenplatz" :direkt/linie "u4"}
     {:direkt/von "prinzregentenplatz" :direkt/nach "boehmerwaldplatz" :direkt/linie "u4"}
     {:direkt/von "boehmerwaldplatz" :direkt/nach "richard_strauss_strasse" :direkt/linie "u4"}
     {:direkt/von "richard_strauss_strasse" :direkt/nach "arabellapark" :direkt/linie "u4"}

      ;u5
     {:direkt/von "laimer_platz" :direkt/nach "friedenheimer_strasse" :direkt/linie "u5"}
     {:direkt/von "friedenheimer_strasse" :direkt/nach "westendstrasse" :direkt/linie "u5"}
     {:direkt/von "westendstrasse" :direkt/nach "heimeranplatz" :direkt/linie "u5"}
     {:direkt/von "heimeranplatz" :direkt/nach "schwanthalerhoehe" :direkt/linie "u5"}
     {:direkt/von "schwanthalerhoehe" :direkt/nach "theresienwiese" :direkt/linie "u5"}
     {:direkt/von "theresienwiese" :direkt/nach "hauptbahnhof" :direkt/linie "u5"}
     {:direkt/von "hauptbahnhof" :direkt/nach "karlsplatz" :direkt/linie "u5"}
     {:direkt/von "karlsplatz" :direkt/nach "odeonsplatz" :direkt/linie "u5"}
     {:direkt/von "odeonsplatz" :direkt/nach "lehel" :direkt/linie "u5"}
     {:direkt/von "lehel" :direkt/nach "max_weber_platz" :direkt/linie "u5"}
     {:direkt/von "max_weber_platz" :direkt/nach "ostbahnhof" :direkt/linie "u5"}
     {:direkt/von "ostbahnhof" :direkt/nach "innsbrucker_ring" :direkt/linie "u5"}
     {:direkt/von "innsbrucker_ring" :direkt/nach "michelibad" :direkt/linie "u5"}
     {:direkt/von "michelibad" :direkt/nach "quiddestrasse" :direkt/linie "u5"}
     {:direkt/von "quiddestrasse" :direkt/nach "neuperlach_zentrum" :direkt/linie "u5"}
     {:direkt/von "neuperlach_zentrum" :direkt/nach "therese_giehse_allee" :direkt/linie "u5"}
     {:direkt/von "therese_giehse_allee" :direkt/nach "neuperlach_sued" :direkt/linie "u5"}

      ;u6 
     {:direkt/von "garching_forschungszentrum" :direkt/nach "garching" :direkt/linie "u6"}
     {:direkt/von "garching" :direkt/nach "garching_hochbrueck" :direkt/linie "u6"}
     {:direkt/von "garching_hochbrueck" :direkt/nach "froettmanning" :direkt/linie "u6"}
     {:direkt/von "froettmanning" :direkt/nach "kieferngarten" :direkt/linie "u6"}
     {:direkt/von "kieferngarten" :direkt/nach "freimann" :direkt/linie "u6"}
     {:direkt/von "freimann" :direkt/nach "studentenstadt" :direkt/linie "u6"}
     {:direkt/von "studentenstadt" :direkt/nach "alte_heide" :direkt/linie "u6"}
     {:direkt/von "alte_heide" :direkt/nach "nordfriedhof" :direkt/linie "u6"}
     {:direkt/von "nordfriedhof" :direkt/nach "dietlindenstrasse" :direkt/linie "u6"}
     {:direkt/von "dietlindenstrasse" :direkt/nach "muenchner_freiheit" :direkt/linie "u6"}
     {:direkt/von "muenchner_freiheit" :direkt/nach "giselastrasse" :direkt/linie "u6"}
     {:direkt/von "giselastrasse" :direkt/nach "universitaet" :direkt/linie "u6"}
     {:direkt/von "universitaet" :direkt/nach "odeonsplatz" :direkt/linie "u6"}
     {:direkt/von "odeonsplatz" :direkt/nach "marienplatz" :direkt/linie "u6"}
     {:direkt/von "marienplatz" :direkt/nach "sendlinger_tor" :direkt/linie "u6"}
     {:direkt/von "sendlinger_tor" :direkt/nach "goetheplatz" :direkt/linie "u6"}
     {:direkt/von "goetheplatz" :direkt/nach "poccistrasse" :direkt/linie "u6"}
     {:direkt/von "poccistrasse" :direkt/nach "implerstrasse" :direkt/linie "u6"}
     {:direkt/von "implerstrasse" :direkt/nach "harras" :direkt/linie "u6"}
     {:direkt/von "harras" :direkt/nach "partnachplatz" :direkt/linie "u6"}
     {:direkt/von "partnachplatz" :direkt/nach "westpark" :direkt/linie "u6"}
     {:direkt/von "westpark" :direkt/nach "holzapfelkreuth" :direkt/linie "u6"}
     {:direkt/von "holzapfelkreuth" :direkt/nach "haderner_stern" :direkt/linie "u6"}
     {:direkt/von "haderner_stern" :direkt/nach "grosshadern" :direkt/linie "u6"}
     {:direkt/von "grosshadern" :direkt/nach "klinikum_grosshadern" :direkt/linie "u6"}
])

@(d/transact conn direkt-input)

; Stationen neben Westfriedhof
(def stationenNebenWestfriedhof 
    '[:find ?v ?n
        :where
        [?x :direkt/von "westfriedhof" ]
        [?x :direkt/nach ?n]
        [?y :direkt/nach "westfriedhof"]
        [?y :direkt/von ?v]
      ])

;(println(d/q stationenNebenWestfriedhof (d/db conn)))

; Stationen neben der über Parameter übergebenen Station
(def stationenNebenX
    '[:find ?v ?n
        :in $ ?station
        :where
        [?x :direkt/von ?station ]
        [?x :direkt/nach ?n]
        [?y :direkt/nach ?station]
        [?y :direkt/von ?v]
      ])

;(println(d/q stationenNebenX (d/db conn) "westfriedhof"))
;(println(d/q stationenNebenX (d/db conn) "hauptbahnhof"))

(def stationenDerU1
    '[:find ?x
        :where
        [?e :direkt/von ?x]
        [?e :direkt/nach ?y]
        [?e :direkt/linie "u1"]
      ])

;(println(d/q stationenDerU1 (d/db conn)))

; 1) Erstellen Sie den Stationsplan fuer den U-Bahnhof Froettmanning, 
;    der alle Station, die ohne umsteigen erreichbar sind, auflistet.

(def stationsplan_froettmanning
    '[:find ?n ?l
        :in $ %
        :where
          (line "froettmanning" ?n ?l)
])

(println(d/q stationsplan_froettmanning (d/db conn) rule))

; 2) Formulieren Sie ein Datalog-Prädikat, das Ihnen von Garching-Forschungszentrum aus 
;    kommend die erreichbaren Stationen inklusiver der Anzahl der Stationen angibt.

(def erreichbarVonGarching
    '[:find ?n ?c
        :in $ %
        :where
          (reachableCnt "garching_forschungszentrum" ?n ?c)
])

;(println(d/q erreichbarVonGarching (d/db conn) rule)) ;f

(defn -main
[] (println "Hello World"))

