from pyDatalog import pyDatalog as pdl

# Schulungsfirma
pdl.create_terms('A,B,C,D,E,F,G,H,I,J,K,L,M,N,U,V,W,X,Y,Z, person, referent, kurs, geeignet, setztvor, younger, temp, kveranst, besucht')

+ person(101, 'Bach',       'Johann Sebastian', 'Leipzig',  'D')
+ person(102, 'Haendel',    'Georg Friedrich',  'London',   'GB')
+ person(103, 'Haydn',      'Joseph',           'Wien',     'A')
+ person(104, 'Mozart',     'Wolfgang Amadeus', 'Salzburg', 'A')
+ person(105, 'Beethoven',  'Ludwig van',       'Wien',     'A')
+ person(106, 'Schubert',   'Franz',            'Wien',     'A')
+ person(107, 'Berlioz',    'Hector',           'Paris',    'F')
+ person(108, 'Liszt',      'Franz',            'Wien',     'A')
+ person(109, 'Wagner',     'Richard',          'Muenchen', 'D')
+ person(110, 'Verdi',      'Giuseppe',         'Busseto',  'I')
+ person(111, 'Bruckner',   'Anton',            'Linz',     'A')
+ person(112, 'Brahms',     'Johannes',         'Wien',     'A')
+ person(113, 'Bizet',      'Georges',          'Paris',    'F')
+ person(114, 'Tschaikowskij', 'Peter',         'Moskau',   'RUS')
+ person(115, 'Puccini',    'Giacomo',          'Mailand',  'I')
+ person(117, 'Schoenberg', 'Arnold',           'Wien',     'A')
+ person(116, 'Strauss',    'Richard', 'Muenchen','D')

+ referent(101, '21.3.1935',    '1.1.1980', None)
+ referent(103, '1.4.1932',     '1.1.1991', None)
+ referent(104, '27.1.1956',    '1.7.1985', None)
+ referent(111, '4.9.1924',     '1.7.1990', 'Mag')
+ referent(114, '25.4.1940',    '1.7.1980', None)
+ referent(116, '11.6.1964',    '1.7.1994', 'Dr')

+ kurs(1, 'Notenkunde',         2, 1400)
+ kurs(2, 'Harmonielehre',      3, 2000)
+ kurs(3, 'Rhythmik',           1, 700)
+ kurs(4, 'Instrumentenkunde',  2, 1500)
+ kurs(5, 'Dirigieren',         3, 100)
+ kurs(6, 'Musikgeschichte',    2, 1400)
+ kurs(7, 'Komposition',        4, 3000)

+ geeignet(1, 103)
+ geeignet(1, 114)
+ geeignet(2, 104)
+ geeignet(2, 111)
+ geeignet(3, 103)
+ geeignet(4, 104)
+ geeignet(5, 101)
+ geeignet(5, 114)
+ geeignet(6, 111)
+ geeignet(7, 103)
+ geeignet(7, 116)

+ setztvor(2, 1)
+ setztvor(3, 1)
+ setztvor(5, 2)
+ setztvor(5, 3)
+ setztvor(5, 4)
+ setztvor(7, 5)
+ setztvor(7, 6)

+ kveranst(1, 1, '7.4.2003',    '8.4.2003',     'Wien',     3, 103)
+ kveranst(1, 2, '23.6.2004',   '24.6.2004',    'Moskau',   4, 114)
+ kveranst(1, 3, '10.4.2005',   '11.4.2005',    'Paris',    3, None)
+ kveranst(2, 1, '9.10.2003',   '11.10.2003',   'Wien',     4, 104)
+ kveranst(3, 1, '17.11.2003',   '17.11.2003',   'Moskau',  3, 103)
+ kveranst(4, 1, '12.1.2004',   '13.1.2004',   'Wien',  2, 116)
+ kveranst(4, 2, '28.3.2004',   '29.3.2004',   'Wien',  4, 104)

+ kveranst(5, 1, '18.5.2004',   '20.5.2004',   'Paris', 3, 101)
+ kveranst(5, 2, '23.9.2004',   '26.9.2004',   'Wien',  2, 101)
+ kveranst(5, 3, '30.3.2005',   '1.4.2005',   'Rom',  3, None)
+ kveranst(7, 1, '9.3.2005',   '13.3.2005',   'Wien',  5, 103)
+ kveranst(7, 2, '14.9.2005',   '18.9.2005',   'Muenchen',  4, 116)

+ besucht(1, 1, 108, '1.5.2003')
+ besucht(1, 1, 109, None)
+ besucht(1, 1, 114, None)
+ besucht(1, 2, 110, '1.7.2004')

# 1. alle kurse
print ("Alle Kurse")
#print (kurs(U, V, W, X))
print

# 2. kursname mit pnr 1
#print("Kursname mit pnr1")
#print(kurs(1, V, W, X))
print

# 3. Kurse mit < 1500
print("Kurse mit < 1500")
(temp(V)) <= kurs(U, V, W, X) & (X < 1500) 
#print (temp(V))
print

# 4. Alle Personen aus Oesterreich
print("Alle Personen aus Oesterreich")
pdl.create_terms('pers')
(pers(V)) <= person(U, V, W, X, 'A')
#print(pers(V))
print

# 5 Alle Personen aus Oesterreich oder Russland
pdl.create_terms('persAuRu')
print("Alle Personen aus Oesterreich oder Russland")
# (persAuRu(V)) <= person(U, V, W, X, Z) & ((Z == 'RUS') or (Z == 'A')) Z Kann nicht gleichzeitig 2 Werte haben
(persAuRu(V)) <= (person(U, V, W, X, 'A'))
(persAuRu(V)) <= person(U, V, W, X, 'RUS')
print(persAuRu(V))
print


# 6) print("Alle Personen aus Oesterreich, die mit B beginnen")
#(pers(V)) <= person(U, V, W, X, 'A') & (V.startswith('B'))
#print (pers(V))
#print("asd".startswith('a'))


# 7) Welche Kurse (KNr) haben einen Kurs als Voraussetzung? 
print("Kurse, die einen Kurs als Voraussetzung haben:")
pdl.create_terms('kursvor')
(kursvor(X)) <= setztvor(X, Y)
#print(kursvor(X))
print

# 8) Namen der Kurse die einen Kurs als Voraussetzung haben
print("Namen der Kurse, die einen Kurs als Voraussetzung haben:")
pdl.create_terms('kursname')

(kursname(U)) <= (setztvor(X, Z) & kurs(X, U, V, Y))
#print(kursname(U))
print

# 9) Alle Referenten die einen Titel haben
print("Alle Referenten die einen Titel haben:")
pdl.create_terms('ref')

(ref(W)) <= (referent(W, X, Y, Z) & (Z != None))
#print(ref(W))
print

# 10) Namen der Referenten die einen Titel haben
print("Namen der Referenten die einen Titel haben:")
pdl.create_terms('refName, Q, R, S, T')

(refName(Q, R)) <= (referent(W, X, Y, Z) & (Z != None) & person(W, Q, R, S, T))
#print(refName(Q, R))
print

# 11) Kurs mit dem billigsten Preis
print("Kurs mit dem billigsten Preis: ")
pdl.create_terms('kmin,kname')

(kmin[0] == min_(Z, order_by=Z)) <= kurs(W, X, Y, Z) 
#print(kmin[0] == Y) # liefert 100 

(kname(X)) <= (kurs(W, X, Y, kmin[0]))
#print(kname(X))
print

# 12) Alle Namen der Referenten aus Oesterreich Aufsteigend sortiert
print("Namen der Referenten aus Oesterreich aufsteigend sortiert: ")
pdl.create_terms('ref')

(ref[0] == tuple_(Y, order_by=Y)) <= (referent(U, V, W, X) & person(U, Y, Z, A, B))
#print(ref[0] == X)
print

# 13) Welche Personen halten oder besuchen eine Kveranst?
print("Welche Personen halten oder besuchen eine Kveranst?")
pdl.create_terms('haltenbesucht, pers, sorthaltbes')

(haltenbesucht(A)) <= (person(A, B, C, D, E) & kveranst(F,G,H,I,J,K,A) & (A != None))
(haltenbesucht(A)) <= (person(A, B, C, D, E) & besucht(L,M,A,N))

(sorthaltbes[0] == tuple_(A, order_by=A)) <= (haltenbesucht(A) & person(A, B, C, D, E)) # kann hier auch aufgerufen werden
(pers[0] == tuple_(B, order_by=B)) <= (haltenbesucht(A) & person(A, B, C, D, E))

#print(sorthaltbes[0] == X)
#print(pers[0] == X)

# 14) Welche Kurse (Bezeichnung) dauern zwischen 2 und 4 Tagen und haben einen durchschnittlichen Tagespreis
#     von hoechstens 700,--? (aufsteigend nach Bezeichnung sortiert)
print("Kurse zwischen 2 und 4 Tagen mit max durschn. Tagespreis 700:")
(temp[0] == tuple_(X, order_by=X)) <= kurs(W, X, Y, Z) & ((Y >= 2) & (Y <= 4) & (Z / Y <= 700))
#print(temp[0] == X)
print

# 15) Zeitspanne der Kursveranstaltungen, die in Wien stattfinden und von Referent 103 oder 104
#    gehalten werden (KNr, KNrLfnd, Tage - danach absteigend)
print("Zeitspanne der Kveranst in Wien mit Referent 103 oder 104")
pdl.create_terms('days')
(days(C, D) ) <= kveranst(A, B, C, D, 'Wien', F, G) & ((G >= 103) & (G <= 104))
#print(days(C, D))
print

# 16) Welche Referenten (PNr, Alter) sind aelter als 75 Jahre? 
print("Aelter als 75: ")

def diff_dates_h(date1, date2):
    return abs(date2-date1).days

def diff_dates(d1, d2):
    #print(d1)
    
    date1 = date( int(d1.split('.')[2]), int(d1.split('.')[1]), int(d1.split('.')[0]))
    date2 = date( int(d2.split('.')[2]), int(d2.split('.')[1]), int(d2.split('.')[0]))
    return diff_dates_h(date2, date1)

#print(diff_dates('12.1.2004', '15.1.2004'))   

pdl.create_terms('refdate')

#(refdate[A] == (diff_dates(C, B))) <= referent(A, B, C, D)
#print(refdate[A] == X)