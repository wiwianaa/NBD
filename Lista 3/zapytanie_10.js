printjson(db.people.update(
   { job: "Editor" },
   { $unset:
      {
        email: ""
      }
   }
))
printjson(db.people.find(
   { job: "Editor" },
).toArray())