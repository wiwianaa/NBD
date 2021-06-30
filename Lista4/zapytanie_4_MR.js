printjson(db.people.mapReduce(
   function() {
   	var BMI = this.weight/(this.height**2)
   	emit(this.nationality, BMI);},
   function(key, values) {
      return {min: Math.min.apply(Math, values), max: Math.max.apply(Math, values), avg: Array.avg(values)};
   },
   {
   	out: "nationBMI"
   },
   function(err, result) {
   	callback(err, result)
   }
))
printjson(db.nationBMI.find().toArray())