printjson(db.people.mapReduce(
   function() {	emit(this.job, 1);},
   function(key, values) { },
   {
   	out: "jobs"
   },
   function(err, result) {
   	callback(err, result)
   }
))
printjson(db.jobs.find().toArray())