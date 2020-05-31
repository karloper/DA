
 INSERT INTO country VALUES ('Albania, Oh yeah','AL','Tirana','Albania',28750,2821977);
 INSERT INTO country VALUES ('Greece (yes)','GR','Athina','Attikis',131940,10816286);

COMMIT;


 INSERT INTO city VALUES ('Tirana','AL','Albania',418495,41.33,19.82,110);
 INSERT INTO city VALUES ('Shkodër','AL','Albania',77075,42.07,19.5,13);
  
COMMIT;


 INSERT INTO province VALUES ('Albania','AL',2821977,28750,'Tirana','Albania');
 INSERT INTO province VALUES ('Anatolikis Makedonias kai Thrakis','GR',608182,14157,'Komotini','Anatolikis Makedonias kai Thrakis'); 
COMMIT;


 INSERT INTO economy VALUES ('AL',12800,19.5,68.5,12,1.7,16.9);
 INSERT INTO economy VALUES ('GR',243300,3.5,80.5,16,-0.8,27.9); 
COMMIT;

 INSERT INTO population VALUES ('AL',0.3,13.19); 
COMMIT;


 INSERT INTO politics VALUES ('AL','1912-11-28','Ottoman Empire',NULL,'parliamentary democracy');
 INSERT INTO politics VALUES ('GR','1829-01-01','Ottoman Empire',NULL,'parliamentary republic');
 
COMMIT;


 INSERT INTO language VALUES ('AL','Albanian',98.8);
 INSERT INTO language VALUES ('AL','Greek',0.5); 
COMMIT;


 INSERT INTO religion VALUES ('AL','Muslim',70);
 INSERT INTO religion VALUES ('AL','Roman Catholic',10); 
COMMIT;


 INSERT INTO ethnicGroup VALUES ('AL','Albanian',95);
 INSERT INTO ethnicGroup VALUES ('AL','Greek',3);
 
COMMIT;


 INSERT INTO countrypops VALUES ('AL',1950,1214489);
 INSERT INTO countrypops VALUES ('AL',1960,1618829);
 
COMMIT;

 INSERT INTO countryothername VALUES ('MYA','Burma');
 INSERT INTO countryothername VALUES ('SD','Swaziland');
 
COMMIT;


 INSERT INTO countrylocalname VALUES ('AL','Shqipëri');
 INSERT INTO countrylocalname VALUES ('GR','Ελληνική Δημοκρατία');
 
COMMIT;


 INSERT INTO provpops VALUES ('Anatolikis Makedonias kai Thrakis','GR',1991,570197);
 INSERT INTO provpops VALUES ('Anatolikis Makedonias kai Thrakis','GR',1994,574308); 
COMMIT;

INSERT INTO provinceothername VALUES ('Euskadi','E','País Vasco');
 INSERT INTO provinceothername VALUES ('Catalunya','E','Cataluña');
 
COMMIT;


 INSERT INTO provincelocalname VALUES ('Anatolikis Makedonias kai Thrakis','GR','Ανατολικής Μακεδονίας και Θράκης');
 INSERT INTO provincelocalname VALUES ('Attikis','GR','Αττικής');
 
COMMIT;


 INSERT INTO citypops VALUES ('Tirana','AL','Albania',1987,192000);
 INSERT INTO citypops VALUES ('Tirana','AL','Albania',1990,244153);
 
COMMIT;

INSERT INTO cityothername VALUES ('Tirana','AL','Albania','Tirane');
 INSERT INTO cityothername VALUES ('Athina','GR','Attikis','Athens');
 
 
COMMIT;

INSERT INTO citylocalname VALUES ('Athina','GR','Attikis','Αθήνα');
 INSERT INTO citylocalname VALUES ('Peiraias','GR','Attikis','Πειραιάς');
 
COMMIT;

 INSERT INTO continent VALUES ('Europe',9938000);
 INSERT INTO continent VALUES ('Asia',44579000);
 
COMMIT;

INSERT INTO borders VALUES ('AL','GR',282);
 INSERT INTO borders VALUES ('AL','MK',151);
 
COMMIT;

INSERT INTO encompasses VALUES ('AL','Europe',100);
 INSERT INTO encompasses VALUES ('GR','Europe',100);
 
 
COMMIT;

INSERT INTO organization VALUES ('AfDB','African Development Bank Group','Abidjan','CI','Abidjan','1964-09-09');
 INSERT INTO organization VALUES ('AU','African Union','Addis Ababa','ETH','Addis Ababa','1963-05-25');
 
COMMIT;

INSERT INTO isMember VALUES ('ET','AfDB','regional member');
 INSERT INTO isMember VALUES ('DZ','AfDB','regional member');
 
COMMIT;


 INSERT INTO mountain VALUES ('Gunnbjørn Fjeld',NULL,3694,NULL,GeoCoord(68.92,-29.9));
 INSERT INTO mountain VALUES ('Newtontoppen',NULL,1713,NULL,GeoCoord(79.0,17.3));
 
COMMIT;

 INSERT INTO desert VALUES ('Kalahari',1200000,GeoCoord(-22,21));
 INSERT INTO desert VALUES ('Namib',95000,GeoCoord(-25,15));
 
 
COMMIT;

 INSERT INTO island VALUES ('Svalbard','Svalbard',39044,1713,NULL,GeoCoord(78.9,18.2));
 INSERT INTO island VALUES ('Te Ika-a-Maui North Island','New Zealand',114597,2797,NULL,GeoCoord(-38.4,175.7));
 INSERT INTO island VALUES ('Te Waka-a-Maui South Island','New Zealand',151757,3754,NULL,GeoCoord(-44,170.4));
 
COMMIT;


 INSERT INTO lake VALUES ('Inarijärvi','Paatsjoki',1040,119,92,NULL,NULL,GeoCoord(68.95,27.7));
 INSERT INTO lake VALUES ('Oulujärvi','Oulujoki',928,123,35,NULL,NULL,GeoCoord(64.3,27.25));
 
COMMIT;



 INSERT INTO sea VALUES ('Atlantic Ocean',NULL,9219);
 INSERT INTO sea VALUES ('Mediterranean Sea',2500000,5267);
 
COMMIT;


 INSERT INTO river VALUES ('Thjorsa',NULL,NULL,'Atlantic Ocean',230,7530,GeoCoord(65,-18),NULL,NULL,GeoCoord(63.9,-20.8),0);
 INSERT INTO river VALUES ('Jökulsa a Fjöllum',NULL,NULL,'Greenland Sea',206,7380,GeoCoord(64.8,-16.5),NULL,NULL,GeoCoord(66.2,-16.6),0);
 
COMMIT;

INSERT INTO riverthrough VALUES ('Bann','Lough Neagh');
 INSERT INTO riverthrough VALUES ('Lågen','Mjoesa-See');
 
COMMIT;

INSERT INTO geo_mountain VALUES ('Gunnbjørn Fjeld','GROX','Greenland');
 INSERT INTO geo_mountain VALUES ('Newtontoppen','SVAX','Svalbard');


COMMIT;

 INSERT INTO geo_desert VALUES ('Kalahari','ANG','Moxico');
 INSERT INTO geo_desert VALUES ('Kalahari','ANG','Cuando Cubango');
 
COMMIT;

 INSERT INTO geo_island VALUES ('Svalbard','SVAX','Svalbard');
 INSERT INTO geo_island VALUES ('Greenland','GROX','Greenland');
 

COMMIT;

 INSERT INTO geo_river VALUES ('Thjorsa','IS','Iceland');
 INSERT INTO geo_river VALUES ('Jökulsa a Fjöllum','IS','Iceland');

COMMIT;

 

 INSERT INTO geo_sea VALUES ('Atlantic Ocean','F','Nouvelle-Aquitaine');
 INSERT INTO geo_sea VALUES ('Atlantic Ocean','F','Bretagne');

COMMIT;

 INSERT INTO geo_lake VALUES ('Inarijärvi','SF','Lappia');
 INSERT INTO geo_lake VALUES ('Oulujärvi','SF','Kainuu');

COMMIT;


 INSERT INTO geo_source VALUES ('Thjorsa','IS','Iceland');
 INSERT INTO geo_source VALUES ('Jökulsa a Fjöllum','IS','Iceland');
COMMIT;

 INSERT INTO geo_estuary VALUES ('Thjorsa','IS','Iceland');
 INSERT INTO geo_estuary VALUES ('Jökulsa a Fjöllum','IS','Iceland');
 
COMMIT;

 INSERT INTO mergesWith VALUES ('Atlantic Ocean','Mediterranean Sea');
 INSERT INTO mergesWith VALUES ('Atlantic Ocean','The Channel');
 
COMMIT;

INSERT INTO located VALUES ('Shkodër','Albania','AL',NULL,'Lake Skutari',NULL);
 INSERT INTO located VALUES ('Durrës','Albania','AL',NULL,NULL,'Mediterranean Sea');
 
COMMIT;


 INSERT INTO locatedOn VALUES ('Kerkyra','Ionion Nison','GR','Korfu');
 INSERT INTO locatedOn VALUES ('Iraklio','Kritis','GR','Crete');
COMMIT;

INSERT INTO islandIn VALUES ('Svalbard','Norwegian Sea',NULL,NULL);
 INSERT INTO islandIn VALUES ('Svalbard','Greenland Sea',NULL,NULL);
 
COMMIT;

INSERT INTO mountainOnIsland VALUES ('Gunnbjørn Fjeld','Greenland');
 INSERT INTO mountainOnIsland VALUES ('Newtontoppen','Svalbard');
 
COMMIT;


 INSERT INTO lakeOnIsland VALUES ('Arresø','Seeland');
 INSERT INTO lakeOnIsland VALUES ('Lough Neagh','Ireland');
 
 
COMMIT;


 INSERT INTO riverOnIsland VALUES ('Thames','Great Britain');
 INSERT INTO riverOnIsland VALUES ('Severn','Great Britain');
 
COMMIT;

INSERT INTO airport VALUES ('HEA','Herat','AFG','Herat','Afghanistan',NULL,34.210017,62.2283,977,5);
 INSERT INTO airport VALUES ('KBL','Kabul Intl','AFG','Kabul','Afghanistan',NULL,34.565853,69.212328,1792,5); 
COMMIT;
