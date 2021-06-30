printjson(db.people.aggregate(
{
	$addFields: {
		height2: {"$pow": ["$height", 2]}
	}
},
{
		$addFields: {
		BMI: {"$divide": ["$weight", "$height2"]}
	}
},
   { $group:
      {
        _id: "$nationality",
        minBMI: {"$min": "$BMI"},
        maxBMI: {"$max": "$BMI"},
        avgBMI: {"$avg": "$BMI"}
      }
   }
).toArray())
