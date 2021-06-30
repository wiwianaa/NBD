printjson(db.people.mapReduce(
   function() {	emit(this.sex, this.weight);},
   function(key, values) { return Array.avg(values) },
   {
   	out: "AvgWeight"
   },
   function(err, result) {
   	callback(err, result)
   }
))
printjson(db.AvgWeight.find().toArray())

printjson(db.people.mapReduce(
   function() {	emit(this.sex, this.height);},
   function(key, values) { return Array.avg(values) },
   {
   	out: "AvgHeight"
   },
   function(err, result) {
   	callback(err, result)
   }
))
printjson(db.AvgHeight.find().toArray())