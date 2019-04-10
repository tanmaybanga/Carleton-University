/*
***************************************************************
(c) Louis D. Nel 2018
***************************************************************

Basic node.js express-based server with middleware,
SQLite database, and CLIENT-SIDE rendering (server just serves JSON data).

This example allows browser clients to update data in the database
by implementing an /api/update/song_id HTTP POST route

The example makes use of the express.js built in body-parser module
to parse the JSON data sent from the client in the body of the HTTP POST message.

The server allows client to find songs, including their chord progressions, in
its SQLite database. The database provided has chord progressions
of some 1200 popular jazz standards.

This example uses client-side rendering: the data obtained from the server
is just JSON data which the client-side javascript can render as it wants.

Here there is no explicit template rendering engine. The client side
javascript is just inserting appropriate html elements and setting their contents

This is an Express 4.x application.
Here we use a routes module. We put our route handling functions in
a separate module that is "required" by the main app. This keeps things
clean and modularized.

We use the exported route functions in the 'use', 'get', and 'post'
routes below. Typically 'use' calls middleware functions that invoke next() whereas
get responds with JSON data for the client whereas post expects JSON data from
the client.

Testing: (user: ldnel password: secret)
http://localhost:3000/index.html

*/

//Cntl+C to stop server

const http = require('http')
const express = require('express')
const path = require('path')
const favicon = require('serve-favicon')
const bodyParser = require('body-parser') //parses bodies of POST messsages
const logger = require('morgan') //console logger for dubugging

const app = express() //create express middleware dispatcher

const PORT = process.env.PORT || 3000

app.locals.pretty = true //to generate pretty view-source code in browser

//read routes modules javascript file
const routes = require('./routes/index')

//Some logger middleware functions
//here you can write your own logging functions for
//whatever debugging you want to do.

function methodLogger(request, response, next) {
  console.log("METHOD LOGGER")
  console.log("================================")
  console.log("METHOD: " + request.method)
  console.log("URL:" + request.url)
  next() //call next middleware registered
}

function headerLogger(request, response, next) {
  console.log("HEADER LOGGER:")
  console.log("Headers:")
  for (let k in request.headers) console.log(k)
  next() //call next middleware registered
}

//register middleware with dispatcher
//ORDER MATTERS HERE
//middleware
app.use(routes.authenticate) //authenticate user
app.use(favicon(path.join(__dirname,  'public',  'favicon.ico')))
app.use(logger('dev'))
//app.use(methodLogger);
//app.use(headerLogger);
app.use(bodyParser.json()) //parse JSON in POST bodies.
app.use(express.static(__dirname + '/public')) //static server to serve files in public folder

/*
JSON API routes returns JSON data to clients so client can render
CRUD (Create,Read,Update,Delete) style API
CRUD to HTTP mapping:
Create = POST (some prefer PUT)
Read = GET 
Update = PUT (some prefer POST, PATCH)
Delete = DELETE
*/
app.get('/api/users', routes.api_users) //get users
app.get('/api/songs', routes.api_songs) //get songs
app.get('/api/song/*', routes.api_songDetails) //get song details
app.post('/api/song/*', routes.api_update_song) //update data for a song

//start server
app.listen(PORT, function(err){
  if (err) console.log(err)
  else {
    console.log(`Server listening on port: ${PORT} CNTL:-C to stop`)
    console.log(`Testing:`)
    console.log(`hardcoded user: ldnel, password: secret`)
    console.log(`http://localhost:3000/index.html`)
  }
})
