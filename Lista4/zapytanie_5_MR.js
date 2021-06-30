printjson(db.people.mapReduce(
   function() {	
   	for (var i = 0; i < this.credit.length; i++) {
   		var info = this.credit[i]
   		emit(info.currency, info.balance);
   	}
   },
   function(key, values) { return {avg: Array.avg(values), sum: Array.sum(values)} },
   {
   	query: {sex: "Female", nationality: "Poland"},
   	out: "TotalBalance"
   },
   function(err, result) {
   	callback(err, result)
   }
   ))

printjson(db.TotalBalance.find().toArray())