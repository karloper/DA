(ns dat.core)

(require '[datomic.api :as d])
(def uri "datomic:free://localhost:4334/mbrainz-1968-1973")
(def conn (d/connect uri))

(def db (d/db conn))

(def rule '[
  [(track-release ?t ?r)  ;; t = track, r = release
  [?m :medium/tracks ?t]  ;; joined übergegebenen track mit medium track
  [?r :release/media ?m]] ;; joined medium track mit release medium
  
  [(track-info ?t ?track-name ?artist-name ?album ?year)
  [?t :track/name    ?track-name]
  [?t :track/artists ?a]
  [?a :artist/name   ?artist-name]
  (track-release ?t ?r)
  [?r :release/name  ?album]
  [?r :release/year  ?year]]

  [(track-search ?q ?track)
  [(fulltext $ :track/name ?q) [[?track ?tname]]]]

  [(collab ?artist-name-1 ?artist-name-2)
  [?a1 :artist/name ?artist-name-1]
  (transitive-net-1 :track/artists ?a1 ?a2)
  [?a2 :artist/name ?artist-name-2]]

   [(transitive-net-1 ?attr ?e1 ?e2)
  [?x ?attr ?e1]
  [?x ?attr ?e2]
  [(!= ?e1 ?e2)]]
  ])

;; 1. Alle Namen der Kuenstler
(def all_artists 
  '[:find ?n 
      :where 
      [?e :artist/name ?n]
])

;; 2. Land aus dem John Lennon stammt
(def jl_country 
  '[:find ?c 
      :where 
      [?a :artist/name "John Lennon"]
      [?e :country/name ?c]
      [?a :artist/country ?e]
])

;; 3. Alle Namen der Kuenstler die mit 'Jo' beginnen
(def all_artists2 
  '[:find ?n 
      :where 
      [?e :artist/name ?n]
      [(.startsWith ?n "Jo")]
])

;; 4. Titel bei denen John Lennon mitgespielt hat
(def jl_titles 
  '[:find ?t 
      :where 
      [?a :artist/name "John Lennon"]
      [?e :track/artists ?a]
      [?e :track/name ?t]
])

;; 5. Titel bei denen der über Parameter übergebene
;;    Künstler mitgespielt hat
(def gen_titles 
  '[:find ?t
      :in $ ?artist-name
      :where 
      [?a :artist/name ?artist-name]
      [?e :track/artists ?a]
      [?e :track/name ?t]
])

;; 6. Alle Alben, die 1969 veröffentlicht wurden
(def album_spec_year 
  '[:find ?album
      :where 
      [?r :release/name  ?album]
      [?r :release/year  1969]
])

;; 7. Alle Alben, die vor 1969 veröffentlicht wurden
(def album_spec_year2 
  '[:find ?album 
      :where 
      [?r :release/name  ?album]
      [?r :release/year ?year]
      [(< ?year 1969)]
])

;; 8. Alben von John Lennon, die 1973 veröffentlicht wurden
(def jl_album_spec_year 
  '[:find ?album
      :where 
      [?a :artist/name   "John Lennon"]
      [?t :track/artists ?a]
      [?m :medium/tracks ?t]
      [?r :release/media ?m]
      [?r :release/name  ?album]
      [?r :release/year  1973]
])

;; 9. Titel, Alben und Veröffentlichungsjahr von John Lennons Liedern
(def jl_title_album_year 
  '[:find ?title ?album ?year
      :in $ 
      :where
      [?a :artist/name   "John Lennon"]
      [?t :track/artists ?a]
      [?t :track/name    ?title]
      [?m :medium/tracks ?t] 
      [?r :release/media ?m]
      [?r :release/name  ?album]
      [?r :release/year  ?year]
])

(def jl_title_album_year2 
  '[:find ?title ?album ?year
      :in $ % 
      :where
      [?a :artist/name   "John Lennon"]
      [?t :track/artists ?a]
      [?t :track/name    ?title]
      (track-release ?t ?r)
      [?r :release/name  ?album]
      [?r :release/year  ?year]
])

;; 10. Wer hat mit John Lennon zusammengearbeitet
(def jl_collab 
  '[:find ?aname ?aname2
      :in $ % ?aname
      :where (collab ?aname ?aname2)
])

;; 11. Alle Titel, Sprache, Jahr von John Lennon
(def titles_jl2 
  '[:find ?t ?y ?l
      :where 
      [?a :artist/name "John Lennon"]
      [?e :track/artists ?a]
      [?e :track/name ?t]
      [?b :medium/tracks ?e]
      [?x :release/media ?b]
      [?x :release/year ?y]
      [?z :language/name ?l	]
      [?x :release/language	?z]
])

;; 12.  mit wort always   idk1 db rule "Together"
(def idk1 
  '[:find ?title ?artist ?album ?year
 :in $ % ?search
 :where
 (track-search ?search ?track)
 (track-info ?track ?title ?artist ?album ?year)
])

;; 13. Anzahl aller Kuenstler
(def all_artists_cnt 
  '[:find (count ?n) 
      :where 
      [?e :artist/name ?n]
])

;; 14. Anzahl aller Lieder
(def track_count 
  '[:find (count ?t) 
      :where 
      [?e :track/name ?t]
])

;; 15. Alle alben von Johne Lennon sortiert
(def album_jl
  '[:find (sort ?album)
      :where
      [?a :artist/name   "John Lennon"]
      [?t :track/artists ?a]
      [?m :medium/tracks ?t] 
      [?r :release/media ?m]
      [?r :release/name  ?album]
])

;; 16. Veröffentlichungs Jahr von John Lennons letztem Album
(def album_jl2
  '[:find (max ?year)
      :where
      [?a :artist/name   "John Lennon"]
      [?t :track/artists ?a]
      [?m :medium/tracks ?t] 
      [?r :release/media ?m]
      [?r :release/year ?year]
])

(println "Ergebnis ")
(println(d/q jl_collab db rule "John Lennon"))
(println "")

(defn -main
  "I can say 'Hello World'."
  []
  (println ""))

