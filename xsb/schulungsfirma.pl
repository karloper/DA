person(101,'Bach','Johann Sebastian','Leipzig','D').
person(102,'Händel','Georg Friedrich','London','GB').
person(103,'Haydn','Joseph','Wien','A').
person(104,'Mozart','Wolfgang Amadeus','Salzburg','A').
person(105,'Beethoven','Ludwig van','Wien','A').
person(106,'Schubert','Franz','Wien','A').
person(107,'Berlioz','Hector','Paris','F').
person(108,'Liszt','Franz','Wien','A').
person(109,'Wagner','Richard','München','D').
person(110,'Verdi','Giuseppe','Busseto','I').
person(111,'Bruckner','Anton','Linz','A').
person(112,'Brahms','Johannes','Wien','A').
person(113,'Bizet','Georges','Paris','F').
person(114,'Tschaikowskij','Peter','Moskau','RUS').
person(115,'Puccini','Giacomo','Mailand','I').
person(116,'Strauss','Richard','München','D').
person(117,'Schönberg','Arnold','Wien','A').
  
referent(101,'1935-3-21','1980-1-1',null).
referent(103,'1932-4-1','1991-1-1',null).
referent(104,'1956-1-27','1985-7-1',null).
referent(111,'1924-9-4','1990-7-1','Mag').
referent(114,'1940-4-25','1980-7-1',null).
referent(116,'1964-6-11','1994-1-1','Dr').
  
kurs(1,'Notenkunde',2,1400).
kurs(2,'Harmonielehre',3,2000).
kurs(3,'Rhythmik',1,700).
kurs(4,'Instrumentenkunde',2,1500).
kurs(5,'Dirigieren',3,1900).
kurs(6,'Musikgeschichte',2,1400).
kurs(7,'Komposition',4,3000).
 
setztvor(2,1).
setztvor(3,1).
setztvor(5,2).
setztvor(5,3).
setztvor(5,4).
setztvor(7,5).
setztvor(7,6).
  
geeignet(1,103).
geeignet(1,114).
geeignet(2,104).
geeignet(2,111).
geeignet(3,103).
geeignet(4,104).
geeignet(5,101).
geeignet(5,114).
geeignet(6,111).
geeignet(7,103).
geeignet(7,116).
 
kveranst(1,1,'2003-4-7','2003-4-8','Wien',3,103).
kveranst(1,2,'2004-6-23','2004-6-24','Moskau',4,114).
kveranst(1,3,'2005-4-10','2005-4-11','Paris',3,null).
kveranst(2,1,'2003-10-9','2003-10-11','Wien',4,104).
kveranst(3,1,'2003-11-17','2003-11-17','Moskau',3,103).
kveranst(4,1,'2004-1-12','2004-1-13','Wien',2,116).
kveranst(4,2,'2004-3-28','2004-3-29','Wien',4,104).
kveranst(5,1,'2004-5-18','2004-5-20','Paris',3,101).
kveranst(5,2,'2004-9-23','2004-9-26','Wien',2,101).
kveranst(5,3,'2005-3-30','2005-4-1','Rom',3,null).
kveranst(7,1,'2005-3-9','2005-3-13','Wien',5,103).
kveranst(7,2,'2005-9-14','2005-9-18','München',4,116).
  
besucht(1,1,108,'2003,5,1').
besucht(1,1,109,null).
besucht(1,1,114,null).
besucht(1,2,110,'2004,7,1').
besucht(1,2,112,'2004,7,3').
besucht(1,2,113,'2004,7,20').
besucht(1,2,116,null).
besucht(1,3,110,null).
besucht(2,1,105,'2003,10,15').
besucht(2,1,109,'2003,11,3').
besucht(2,1,112,'2003,10,28').
besucht(2,1,116,null).
besucht(3,1,101,null).
besucht(3,1,109,null).
besucht(3,1,117,'2003,11,20').
besucht(4,1,102,'2004,1,20').
besucht(4,1,107,'2004,2,1').
besucht(4,1,111,null).
besucht(4,2,106,'2004,4,7').
besucht(4,2,109,'2004,4,15').
besucht(5,1,103,null).
besucht(5,1,109,'2004,6,7').
besucht(5,2,115,'2004,10,7').
besucht(5,2,116,null).
besucht(7,1,109,'2005,3,20').
besucht(7,1,113,null).
besucht(7,1,117,'2005,4,8').

% Alle Kurse
%kurs(A,B,C,D).

% Kurse mit < 1500
% kurs(A, B, C, D), D < 1500.

% Alle Personen aus Oesterreich
% person(U, V, W, X, 'A')


% Welche Kurse (KNr) haben einen Kurs als Voraussetzung? 
kVor(K, X) 
    :- setztvor(K, X).


% Welche Kurse (Name) haben einen Kurs als Voraussetzung? 
kVorN(K, N) 
    :-  setztvor(K, X),
        kurs(K, N, Y, Z).

% Alle Referenten die einen Titel haben
refTitel(W)
    :-  referent(W, X, Y, Z), 
        Z \= null.

% Kurse zwischen 2 und 4 Tagen mit max durschn. Tagespreis 700:
kursAgg(B)
    :-  kurs(A, B, C, D), 
        C > 1, 
        C < 5, 
        (D / C) < 701.