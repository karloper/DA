from pyDatalog import pyDatalog as pdl
pdl.create_terms('direkt')

# U1
+ direkt('olympia_einkaufszentrum','georg_brauchle_ring','u1')
+ direkt('georg_brauchle_ring','westfriedhof','u1')
+ direkt('westfriedhof','gern','u1')
+ direkt('gern','rotkreuzplatz','u1')
+ direkt('rotkreuzplatz','maillingerstrasse','u1')
+ direkt('maillingerstrasse','stiglmaierplatz','u1')
+ direkt('stiglmaierplatz', 'hauptbahnhof','u1')
+ direkt('hauptbahnhof','sendlinger_tor','u1')
+ direkt('sendlinger_tor','fraunhoferstrasse','u1')
+ direkt('fraunhoferstrasse','kolumbusplatz','u1')
+ direkt('kolumbusplatz','candidplatz','u1')
+ direkt('candidplatz','wettersteinplatz','u1')
+ direkt('wettersteinplatz','st_quirin_platz','u1')
+ direkt('st_quirin_platz','mangfallplatz','u1')

+ direkt('feldmoching','hasenbergl','u2')
+ direkt('hasenbergl','duelferstrasse','u2')
+ direkt('duelferstrasse','harthof','u2')
+ direkt('harthof','am_hart','u2')
+ direkt('am_hart','frankfurter_ring','u2')
+ direkt('frankfurter_ring','milbertshofen','u2')
+ direkt('milbertshofen','scheidplatz','u2')
+ direkt('scheidplatz','hohenzollernplatz','u2')
+ direkt('hohenzollernplatz','josephsplatz','u2')
+ direkt('josephsplatz','theresienstrasse','u2')
+ direkt('theresienstrasse','koenigsplatz','u2')
+ direkt('koenigsplatz','hauptbahnhof','u2')
+ direkt('hauptbahnhof','sendlinger_tor','u2')
+ direkt('sendlinger_tor','fraunhoferstrasse','u2')
+ direkt('fraunhoferstrasse','kolumbusplatz','u2')
+ direkt('kolumbusplatz','silberhornstrasse','u2')
+ direkt('silberhornstrasse','unterbergstrasse','u2')
+ direkt('unterbergstrasse','giesing','u2')
+ direkt('giesing','karl_preis_platz','u2')
+ direkt('karl_preis_platz','innsbrucker_ring','u2')
+ direkt('innsbrucker_ring','josephsburg','u2')
+ direkt('josephsburg','kreillerstrasse','u2')
+ direkt('kreillerstrasse','trudering','u2')
+ direkt('trudering','moosfeld','u2')
+ direkt('moosfeld','messestadt_west','u2')
+ direkt('messestadt_west','messestadt_ost','u2')

+ direkt('moosach','moosacher_st_martins_platz','u3')
+ direkt('moosacher_st_martins_platz','olympia_einkaufszentrum','u3')
+ direkt('olympia_einkaufszentrum','oberwiesenfeld','u3')
+ direkt('oberwiesenfeld','olympiazentrum','u3')
+ direkt('olympiazentrum','petuelring','u3')
+ direkt('petuelring','scheidplatz','u3')
+ direkt('scheidplatz','bonner_platz','u3')
+ direkt('bonner_platz','muenchner_freiheit','u3')
+ direkt('muenchner_freiheit','giselastrasse','u3')
+ direkt('giselastrasse','universitaet','u3')
+ direkt('universitaet','odeonsplatz','u3')
+ direkt('odeonsplatz','marienplatz','u3')
+ direkt('marienplatz','sendlinger_tor','u3')
+ direkt('sendlinger_tor','goetheplatz','u3')
+ direkt('goetheplatz','poccistrasse','u3')
+ direkt('poccistrasse','implerstrasse','u3')
+ direkt('implerstrasse','brudermuehlstrasse','u3')
+ direkt('brudermuehlstrasse','thalkirchen','u3')
+ direkt('thalkirchen','obersendling','u3')
+ direkt('obersendling','aidenbachstrasse','u3')
+ direkt('aidenbachstrasse','machtlfinger_strasse','u3')
+ direkt('machtlfinger_strasse','forstenrieder_allee','u3')
+ direkt('forstenrieder_allee','basler_str','u3')
+ direkt('basler_str','forstenried_west','u3')

+ direkt('westendstrasse','heimeranplatz','u4')
+ direkt('heimeranplatz','schwanthalerhoehe','u4')
+ direkt('schwanthalerhoehe','theresienwiese','u4')
+ direkt('theresienwiese','hauptbahnhof','u4')
+ direkt('hauptbahnhof','karlsplatz','u4')
+ direkt('karlsplatz','odeonsplatz','u4')
+ direkt('odeonsplatz','lehel','u4')
+ direkt('lehel','max_weber_platz','u4')
+ direkt('max_weber_platz','prinzregentenplatz','u4')
+ direkt('prinzregentenplatz','boehmerwaldplatz','u4')
+ direkt('boehmerwaldplatz','richard_strauss_strasse','u4')
+ direkt('richard_strauss_strasse','arabellapark','u4')

+ direkt('laimer_platz','friedenheimer_strasse','u5')
+ direkt('friedenheimer_strasse','westendstrasse','u5')
+ direkt('westendstrasse','heimeranplatz','u5')
+ direkt('heimeranplatz','schwanthalerhoehe','u5')
+ direkt('schwanthalerhoehe','theresienwiese','u5')
+ direkt('theresienwiese','hauptbahnhof','u5')
+ direkt('hauptbahnhof','karlsplatz','u5')
+ direkt('karlsplatz','odeonsplatz','u5')
+ direkt('odeonsplatz','lehel','u5')
+ direkt('lehel','max_weber_platz','u5')
+ direkt('max_weber_platz','ostbahnhof','u5')
+ direkt('ostbahnhof','innsbrucker_ring','u5')
+ direkt('innsbrucker_ring','michelibad','u5')
+ direkt('michelibad','quiddestrasse','u5')
+ direkt('quiddestrasse','neuperlach_zentrum','u5')
+ direkt('neuperlach_zentrum','therese_giehse_allee','u5')
+ direkt('therese_giehse_allee','neuperlach_sued','u5')

+ direkt('garching_forschungszentrum','garching','u6')
+ direkt('garching','garching_hochbrueck','u6')
+ direkt('garching_hochbrueck','froettmanning','u6')
+ direkt('froettmanning','kieferngarten','u6')
+ direkt('kieferngarten','freimann','u6')
+ direkt('freimann','studentenstadt','u6')
+ direkt('studentenstadt','alte_heide','u6')
+ direkt('alte_heide','nordfriedhof','u6')
+ direkt('nordfriedhof','dietlindenstrasse','u6')
+ direkt('dietlindenstrasse','muenchner_freiheit','u6')
+ direkt('muenchner_freiheit','giselastrasse','u6')
+ direkt('giselastrasse','universitaet','u6')
+ direkt('universitaet','odeonsplatz','u6')
+ direkt('odeonsplatz','marienplatz','u6')
+ direkt('marienplatz','sendlinger_tor','u6')
+ direkt('sendlinger_tor','goetheplatz','u6')
+ direkt('goetheplatz','poccistrasse','u6')
+ direkt('poccistrasse','implerstrasse','u6')
+ direkt('implerstrasse','harras','u6')
+ direkt('harras','partnachplatz','u6')
+ direkt('partnachplatz','westpark','u6')
+ direkt('westpark','holzapfelkreuth','u6')
+ direkt('holzapfelkreuth','haderner_stern','u6')
+ direkt('haderner_stern','grosshadern','u6')
+ direkt('grosshadern','klinikum_grosshadern','u6')

# Stationen neben Westfriedhof
pdl.create_terms('nachbarStat, V, N, X')

nachbarStat(V, N) <= direkt(V, N, X)    # V = westfriedhof; N = gern
nachbarStat(V, N) <= direkt(N, V, X)   # N = georg_brauchle_ring; V = westfriedhof

# print(nachbarStat('westfriedhof', X))


# Alle Stationen der U1
pdl.create_terms('verbunden, bidirekt, Y, Z, L, A, stationen')

verbunden(X, Y) <= direkt(X, Y, A)
verbunden(X, Z) <= direkt(X, Y, A) & verbunden(Y, Z)

bidirekt(V,N,L) <= direkt(V,N,L)
bidirekt(V,N,L) <= direkt(N,V,L)
stationen(V) <= direkt(V,X,'u1')
#print(verbunden('olympia_einkaufszentrum', X))
print(stationen(V))
# 1) Erstellen Sie den Stationsplan fuer den U-Bahnhof Froettmanning, 
#    der alle Station, die ohne umsteigen erreichbar sind, auflistet.
pdl.create_terms('line, B, N, X')

line(A,B,L) <= bidirekt(A,B,L)
line(A,B,L) <= line(A,X,L) & line(X,B,L)

#print(line('froettmanning',B,L))



# 2) Formulieren Sie ein Datalog-Praedikat, das Ihnen von Garching-Forschungszentrum aus 
#    kommend die erreichbaren Stationen inklusiver der Anzahl der Stationen angibt.
pdl.create_terms('reachableCnt, V, N, X, C, CntX')

reachableCnt(V, B, C) <= direkt(V, B, A) & (C == 1)
reachableCnt(V, B, C) <= reachableCnt(V, X, CntX) & direkt(X, B, A) & (C == (CntX + 1))

#print(reachableCnt('garching_forschungszentrum', B, C))

# 3. Erstellen Sie fuer Garching-Forschungszentrum einen Plan, der alle erreichbaren Stationen, 
#    die minimale Anzahl an Umstiegen und Stops auflistet.
pdl.create_terms('aufwand, U, S, S2, L1, L2, Umst, Umst2')

aufwand(V, B, L, U, S) <= direkt(V, B, L) & (U == 0) & (S == 0)

aufwand(V, B, L, U, S) <= aufwand(V, X, L, U, S2) & direkt(X, B, L) & (S == (S2 + 1))

aufwand(V, B, L, U, S) <= aufwand(V, X, L1, Umst2, S2) & direkt(X, B, L2) & (S == (S2 + 1)) & (L1 != L2) & (L == L2) & (Umst == (Umst2 + 1))

#print(aufwand('garching_forschungszentrum', B, L, U, S))


