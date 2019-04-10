/*
Basic node.js server with express-based middleware and SQLite database.
Here rendering is done without templates -that is, the javascript
code builds the web page html tags directly.
This is not good in that the web page struture is not isolated and
easily maintained -but it keeps the code simple for now.

The server allows client to find songs, including their chord progressions, in
its SQLite database. The database provided has chord progressions
of some 1200 popular jazz standards.

This example uses server-side web page rendering that is done directly by the
the javacript routing code.

Here we use a routes module, or file. We put our route handling javascript functions in
a separate module that is "required" by the main app.
This keeps things clean and modularized.

We use the exported route functions in the 'use' and 'get' express
routes below. Typically 'use' calls functions that invoke next() whereas
get and post routes send responses to the client -but these are not enforced rules.

To launch:
node.js and npm must be installed on your computer.

Install the required modules (listed in package.json file) by executing:
>npm install

Run the application by executing:
>node server.js

Testing: (user: ldnel password: secret)
http://localhost:3000/index.html
http://localhost:3000/users
http://localhost:3000/songs?title=Love
http://localhost:3000/song/372
*/

const http = require('http') //needed for http server
const express = require('express') //routing framework
const path = require('path') //helps assemble file paths
const favicon = require('serve-favicon') //serves favicon icon for browser tabs
const logger = require('morgan') //console logger for dubugging

const  app = express() //create express middleware dispatcher

const PORT = process.env.PORT || 3000

app.locals.pretty = true //to generate pretty view-source code in browser

//read our routes modules javascript file
const routes = require('./routes/index')

//some logger middleware functions for debugging
function methodLogger(request, response, next){
		   console.log("METHOD LOGGER")
		   console.log("================================")
		   console.log("METHOD: " + request.method)
		   console.log("URL:" + request.url)
		   next(); //call next middleware registered
}
function headerLogger(request, response, next){
		   console.log("HEADER LOGGER:")
		   console.log("Headers:")
       for(let k in request.headers) console.log(k)
		   next(); //call next middleware registered
}

//register middleware with dispatcher
//ORDER MATTERS HERE
//middleware
app.use(routes.authenticate) //authenticate user
app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')))
app.use(logger('dev'))
//app.use(methodLogger)

//routes
app.get('/index.html', routes.index)
app.get('/users', routes.users)
app.get('/songs', routes.songs)
app.get('/song/*', routes.songDetails)

//start server
app.listen(PORT, err => {
  if(err) console.log(err)
  else {
		console.log(`Server listening on port: ${PORT} CNTL:-C to stop`)
		console.log(`Testing:`)
		console.log(`hardcoded user: ldnel, password: secret`)
		console.log(`http://localhost:3000/index.html`)
		console.log(`http://localhost:3000/users`)
		console.log(`http://localhost:3000/songs?title=Girl`)
		console.log(`http://localhost:3000/song/372`)
		}
})
