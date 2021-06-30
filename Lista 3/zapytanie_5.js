printjson(db.people.find({"birth_date":{"$gte":new Date("2001-01-01")}},
	{"first_name": 1, "last_name":1, "location.city":1, "_id":0}
	).toArray())