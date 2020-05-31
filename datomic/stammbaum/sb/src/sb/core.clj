(ns sb.core)
(require '[datomic.api :as d])

(def db-uri "datomic:mem://stammbaum")
(d/create-database db-uri)
(def conn (d/connect db-uri))

(def rule '[
  [(ismale ?x)
  [?e :male/male ?x]]

  [(isfemale ?x)
  [?e :female/female ?x]]

  [(isparent ?x ?y)
  [?e :parent/par ?x]
  [?e :parent/child ?y]]

  [(isbrother ?x ?y)
  (isparent ?z ?x)
        (isparent ?z ?y)
        (ismale ?x)
        [(!= ?x ?y)]]
  ])

(def parent-schema [
     {:db/ident :parent/par
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}

     {:db/ident :parent/child
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}
])

@(d/transact conn parent-schema)

(def male-schema [
     {:db/ident :male/male
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}
])

@(d/transact conn male-schema)

(def female-schema [
     {:db/ident :female/female
     :db/valueType :db.type/string
     :db/cardinality :db.cardinality/one}
])

@(d/transact conn female-schema)

(def parent-input [
     {:parent/par "pam" :parent/child "bob"}
     {:parent/par "bob" :parent/child "ann"}
     {:parent/par "tom" :parent/child "bob"}
     {:parent/par "bob" :parent/child "pat"}
     {:parent/par "tom" :parent/child "liz"}
     {:parent/par "pat" :parent/child "jim"}
     {:parent/par "liz" :parent/child "paul"}
])

@(d/transact conn parent-input)

(def male-input [
     {:male/male "tom"}
     {:male/male "bob"}
     {:male/male "jim"}
])
@(d/transact conn male-input)

(def female-input [
     {:female/female "pam"}
     {:female/female "liz"}
     {:female/female "ann"}
     {:female/female "pat"}
])
@(d/transact conn female-input)

; Kinder von Bob
(def kinderVonBob 
    '[:find ?c
        :where
        [?x :parent/par "bob"]
        [?x :parent/child ?c]
      ])

;(println(d/q kinderVonBob (d/db conn)))

; Alle Kinder mit Elternteil
(def alleKindermitEltern 
    '[:find ?x ?y
        :where
        [?e :parent/par ?x]
        [?e :parent/child ?y]
      ])

;(println(d/q alleKindermitEltern (d/db conn)))

; Alle Kinder mit Vater
; parent(X, Y), male(X).
(def alleKindermitVater 
    '[:find ?c
        :in $ %
        :where
        [?e :parent/child ?c]
        [?e :parent/par ?x]
        (ismale ?x) 
      ])

;(println(d/q alleKindermitVater (d/db conn) rule))

(def MuttermitKind 
    '[:find ?m ?c
        :in $ %
        :where
        [?e :parent/child ?c]
        [?e :parent/par ?m]
        (isfemale ?m) 
      ])

;(println(d/q MuttermitKind (d/db conn) rule))

(def VatermitKind 
    '[:find ?v ?c
        :in $ %
        :where
        [?e :parent/child ?c]
        [?e :parent/par ?v]
        (ismale ?m) 
      ])

;(println(d/q VatermitKind (d/db conn) rule))

;; alle Kombinationen mit Bruder
(def BrudermitSchwester 
    '[:find ?x ?y
        :in $ %
        :where
        (isparent ?z ?x)
        (isparent ?z ?y)
        (ismale ?x)
        [(!= ?x ?y)]
      ])

;(println(d/q BrudermitSchwester (d/db conn) rule))

;; alle Kombinationen mit Schwester

(def SchwestermitBruder 
    '[:find ?x ?y
        :in $ %
        :where
        (isparent ?z ?x)
        (isparent ?z ?y)
        (isfemale ?x)
        [(!= ?x ?y)]
      ])

;(println(d/q SchwestermitBruder (d/db conn) rule))

;; alle Geschwister
;; (sibling(X, Y)) <= parent(Z, X) & parent(Z, Y) & (X != Y)

(def alleGeschwister 
    '[:find ?x ?y
        :in $ %
        :where
        (isparent ?z ?x)
        (isparent ?z ?y)
        [(!= ?x ?y)]
      ])

;; (println(d/q alleGeschwister (d/db conn) rule))

;; Onkel ausgeben

(def Onkel 
    '[:find ?x ?y
        :in $ %
        :where
        (isbrother ?x ?z)
        (isparent ?z ?y)
      ])

(println(d/q Onkel (d/db conn) rule))

(defn -main
[] (println "Hello World"))