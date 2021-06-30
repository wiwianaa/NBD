printjson(db.people.aggregate([
	{ $unwind: "$credit" },
	{ $match:
		{
			sex: "Female",
			nationality: "Poland"
		}
	},
    { $group:
      {
        _id: "$credit.currency",
        totalBalance: {"$sum": "$credit.balance"},
        avgBalance: {"$avg": "$credit.balance"}
      }
    }
    ]
).toArray())