auto(opel, czerwony, 2011, 10000).
auto(bmw, czarny, 2010, 0).
auto(bmw, zielony, 1999,20000).
auto(fiat, bialy, 1988,100000).
auto(fiat, czerwony, 2000,200000).
auto(nissan, czarny, 2014, 10000).
auto(jaguar, srebrny, 2014, 10000).
auto(opel, czarny,2000, 150000).

student(kowalski, jan, psychologia,1994).
student(kowalski, adam, psychologia, 1994).
student(kowalska, ada, socjologia, 1993).
student(kowalska, ala, fizyka, 1993).
student(kowalski, andrzej, informatyka, 1994).
student(nowak, adam, psychologia, 1994).
student(nowak, jacek, fizyka, 1993).
student(lasowski, jerzy, psychologia, 1994).

marka(X) :- auto(X, _, Z, _), Z > 2000.
tescik(X) :- auto(X, _, Z, _), Z > 2000, Z < 2005.
info(Y, X) :- student(Y,X, informatyka, _).

# asserta(autko(ford, czarny, 2012, 25000)).
# asserta(studenciak(nowacki, roman, kognitywistyka, 1995)).

beta(X) :- Marka(X)-> write('Formula '), write( X ), write('jest formułą typu beta.'); write('Formula'), write( X ), write(' nie jest formułą typu beta.').
