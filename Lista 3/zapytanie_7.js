printjson(db.people.remove({"height":{$gt: 190}}
	))
printjson(db.people.find({"height":{$gt: 190}}
	).toArray())
//Mialam error przy wczesniejszej probie zapisu, ale najwyrazniej mimo to elementy sie
//usunely dlatego wynik pokazuje brak usunietych elementow, ale find zwraca pusta macierz