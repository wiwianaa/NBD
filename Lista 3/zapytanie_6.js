printjson(db.people.insert({
	"sex": "Female",
	"first_name": "Wiwiana",
	"last_name": "Lebiodzik",
	"job": "Data Analyst",
	"email": "s23685@pjwstk.edu.pl",
	"location": [{
		"city": "Wroclaw",
		"adress": {
			"streetname": "Nowa",
			"streetnumber": "8"
		}
	}
	],
	"description" : "some interesting information",
	"height" : "173",
	"weight" : "62",
	"birth_date" : new Date("1996-06-04"),
	"nationality" : "Poland",
	"credit" : [
		{
			"type" : "visa",
			"number" : "3518932899259699111",
			"currency" : "PLN",
			"balance" : "10117.06"
		}
		]
	}
	))