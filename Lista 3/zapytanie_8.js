printjson(db.people.find({"location.city":"Moscow"}).forEach(function(obj) {
    obj.location.city = obj.location.city.replace("Moscow","Moskwa");
    db.people.save(obj);
})
)
printjson(db.people.find({"location.city":"Moscow"}).toArray())
printjson(db.people.find({"location.city":"Moskwa"}).toArray())