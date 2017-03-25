//use cs548_Movies

//Create movieDetails document: 
db.createCollection("moviedetails")

//Create comments collection
db.createCollection("comments")

//Insert query for movie details
db.moviedetails.insert( { name : "Mission Impossible" , rating: "9" , year : "1998" })
  						
//Insert query for comments  							
db.comments.insert( { user: "Mani", review: "Not so great", movieName: "Mission Impossible" , date : Date.now() } )
 
 
 
