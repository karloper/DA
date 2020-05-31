parent(pam, bob).
parent(bob, ann).
parent(tom, bob).
parent(bob, pat).
parent(tom, liz).
parent(pat, jim).
parent(liz, paul).

parent(herbert, laura).
parent(sophia, laura).
	
male(tom).
male(bob).
male(jim).

female(pam).
female(liz).
female(ann).
female(pat).

% Kinder von Bob
% parent(bob, X).

% Alle Kinder mit Elternteil
% parent(X, Y).

% Alle Kinder mit Vater
% parent(X, Y), male(X).

% parent(X, Y), parent(Y, Z).

% mother(X, Y).
mother(X, Y) :-
    parent(X, Y),
    female(X).

father(X, Y) :-
    parent(X, Y),
    male(X).

brother(X, Y) :- 
    parent(P, X), 
    parent(P, Y), 
    male(X), 
    X \= Y.

sister(X, Y) :- 
    parent(Z, X), 
    parent(Z, Y), 
    female(X), 
    X \= Y.

sibling(X, Y) :-
    parent(Z, X),
    parent(Z, Y),
    X \= Y.

uncle(X, Y) :-
    brother(X, Z),
    parent(Z, Y).

% cousin(X, Y).
cousin(X, Y) :-
    parent(Z, X),
    parent(T, Y),
    sibling(Z, T).

grandparent(X, Y) :-
    parent(X, Z),
    parent(Z, Y).

% ancestor(X, ann).
% findall(X, ancestor(X, ann), L).

ancestor(X, Y) :-
    parent(X, Y).

ancestor(X, Z) :-
    parent(X, Y),
    ancestor(Y, Z).