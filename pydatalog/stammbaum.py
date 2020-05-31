from pyDatalog import pyDatalog as pdl
pdl.create_terms('parent, male, female')

+ parent('pam', 'bob')
+ parent('bob', 'ann')
+ parent('tom', 'bob')
+ parent('bob', 'pat')
+ parent('tom', 'liz')
+ parent('pat', 'jim')
+ parent('liz', 'paul')

+ male('tom')
+ male('bob')
+ male('jim')

+ female('pam')
+ female('liz')
+ female('ann')
+ female('pat')

pdl.create_terms('X, Y, Z')

# Kinder von Bob
#print(parent('bob', X))

# Alle Kinder mit Elternteil
#print(parent(X, Y))

# Alle Kinder mit Vater
pdl.create_terms('maleParent')

(maleParent(Y)) <= parent(X, Y) & male(X)
#print(maleParent(X))

# Alle Muetter mit Kinder
pdl.create_terms('mother')

(mother(X, Y)) <= parent(X, Y) & female(X)
print(mother(X, Y))

# Alle Vaeter mit Kinder
pdl.create_terms('father')

(father(X, Y)) <= parent(X, Y) & male(X)
print(father(X, Y))


pdl.create_terms('brother')

(brother(X, Y)) <= parent(Z, X) & parent(Z, Y) & male(X) & (X != Y)
#print(brother(X, Y))

pdl.create_terms('sister')

(sister(X, Y)) <= parent(Z, X) & parent(Z, Y) & female(X) & (X != Y)
#print(sister(X, Y))


pdl.create_terms('sibling')

(sibling(X, Y)) <= parent(Z, X) & parent(Z, Y) & (X != Y)
#print(sibling(X, Y))

pdl.create_terms('uncle')

(uncle(X, Y)) <= brother(X, Z) & parent(Z, Y)
#print(uncle(X, Y))