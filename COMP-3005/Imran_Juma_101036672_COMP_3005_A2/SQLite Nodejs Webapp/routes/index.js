const url = require('url')
const sqlite3 = require('sqlite3').verbose() //verbose provides more detailed stack trace

//connect to sqlite database
const db = new sqlite3.Database('data/fakebooks3005fall2018.db')

db.serialize(function() {
  //make sure a couple of users exist in the database.
  //user: ldnel password: secret
  //user: frank password: secret2
  let sqlString = "CREATE TABLE IF NOT EXISTS users (userid TEXT PRIMARY KEY, password TEXT)"
  db.run(sqlString)
  sqlString = "INSERT OR REPLACE INTO users VALUES ('ldnel', 'secret')"
  db.run(sqlString)
  sqlString = "INSERT OR REPLACE INTO users VALUES ('frank', 'secret2')"
  db.run(sqlString)
  sqlString = "INSERT OR REPLACE INTO users VALUES ('imran', 'secret3')"
  db.run(sqlString)
})

exports.authenticate = function(request, response, next) {
  /*
  Middleware to do BASIC HTTP 401 authentication
  The function will check that an userid/password authentication record
  is contained in the request header from the brower. If not the response
  will result in the browser asking the client user to supply a userid/password.

  If the userid/password record is present it will used to verify that
  the user is among those in the users table of the sqlite database.

  You can bypass this authentication altogether by removing the
  app.use(routes.authenticate) statement in the server code
  */
  let auth = request.headers.authorization
  // auth is a base64 representation of (username:password)
  //so we will need to decode the base64
  if (!auth) {
    //note here the setHeader must be before the writeHead
    response.setHeader('WWW-Authenticate', 'Basic realm="need to login"')
    response.writeHead(401, {
      'Content-Type': 'text/html'
    })
    console.log('No authorization found, send 401.')
    response.end()
  } else {
    console.log("Authorization Header: " + auth)
    //decode authorization header
    // Split on a space, the original auth
    //looks like  "Basic Y2hhcmxlczoxMjM0NQ==" and we need the 2nd part
    let tmp = auth.split(' ')

    // create a buffer and tell it the data coming in is base64
    let buf = new Buffer(tmp[1], 'base64')

    // read it back out as a string
    //should look like 'ldnel:secret'
    let plain_auth = buf.toString();
    console.log("Decoded Authorization ", plain_auth)

    //extract the userid and password as separate strings
    let credentials = plain_auth.split(':') // split on a ':'
    let username = credentials[0]
    let password = credentials[1]
    console.log("User: ", username)
    console.log("Password: ", password)

    let authorized = false
    //check database users table for user
    db.all("SELECT userid, password FROM users", function(err, rows) {
      for (let i = 0; i < rows.length; i++) {
        if (rows[i].userid == username & rows[i].password == password) authorized = true
      }
      if (authorized == false) {
        //we had an authorization header by the user:password is not valid
        response.setHeader('WWW-Authenticate', 'Basic realm="need to login"')
        response.writeHead(401, {
          'Content-Type': 'text/html'
        })
        console.log('No authorization found, send 401.')
        response.end()
      } else
        next()
    })
  }
  //notice no call to next() here
}


function parseURL(request, response) {
  let parseQuery = true //parseQueryStringIfTrue
  let slashHost = true //slashDenoteHostIfTrue
  let urlObj = url.parse(request.url, parseQuery, slashHost)
  console.log('path:')
  console.log(urlObj.path)
  console.log('query:')
  console.log(urlObj.query)
  //for(x in urlObj.query) console.log(x + ': ' + urlObj.query[x]);
  return urlObj
}


exports.index = function(request, response) {
  // /index.html
  //Example rendering without templates -build html response directly
  //write header with HTTP success code and MIME type
  response.writeHead(200, {
    'Content-Type': 'text/html'
  })
  response.write(`<!DOCTYPE html>
<html>
<head>
<title>Songs R Us</title>
</head>
<body>
<h1>Hello World</h1>
<h2>rendered WITHOUT templates</h2>
</body>
</html>`)
 //end response and send to client
  response.end()
}

exports.users = function(request, response) {
  // /users
  //without template rendering -create webpage in the code
    db.all("SELECT userid, password FROM users", function(err, rows) {
      response.writeHead(200, {'Content-Type': 'text/html'})
      response.write(`<!DOCTYPE html>
    <html>
    <head>
    <title>USERS</title>
    </head>
    <body>
    <h1>USERS</h1><ul>`)
    for (let i = 0; i < rows.length; i++) {
        response.write(`<li>userid: ${rows[i].userid} password: ${rows[i].password}</li>`)
      }
    response.write(`</ul></body></html>`)
    //write end send response to client
    response.end()
    })
}

exports.songs = function(request, response) {
  // /songs?title=Girl
  console.log("RUNNING GET SONGS")

  let urlObj = parseURL(request, response)
  let sql = "SELECT rowid, title FROM songs"

  if (urlObj.query['title']) {
    console.log("finding title: " + urlObj.query['title'])
    sql = "SELECT rowid, title FROM songs WHERE title LIKE '%" +
      urlObj.query['title'] + "%'"
  }

  db.all(sql, function(err, rows) {
    response.writeHead(200, {'Content-Type': 'text/html'})
    response.write(`<!DOCTYPE html>
  <html>
  <head>
  <title>SONGS</title>
  </head>
  <body>
  <h1>SONGS</h1>`)
  for (let i = 0; i < rows.length; i++) {
     response.write(`<p><a href='song/${rows[i].rowid}'>${rows[i].rowid} ${rows[i].title}</a></p>`)
    }
  response.write(`</body></html>`)
  //write end send response to client
  response.end()
  })
}

exports.songDetails = function(request, response) {
// /song/235
  let urlObj = parseURL(request, response);
  let songID = urlObj.path; //expected form: /song/235
  songID = songID.substring(songID.lastIndexOf("/") + 1, songID.length)

  let sql = "SELECT rowid, title, composer, bookcode, page, length, studentnum FROM songs WHERE rowid=" + songID
  console.log("GET SONG DETAILS: " + songID)

  db.all(sql, function(err, rows) {
    response.writeHead(200, {'Content-Type': 'text/html'})
    response.write(`<!DOCTYPE html>
  <html>
  <head>
  <title>SONG DETAILS</title>
  </head>
  <body>
  <h1>SONG DETAILS</h1>`)
  for (let i = 0; i < rows.length; i++) {
    response.write(`<h1>${rows[i].rowid}:  ${rows[i].title}</h1>`)
    response.write(`<p>composer: ${rows[i].composer}</p>`)
    response.write(`<p>bookcode: ${rows[i].bookcode}: </p>`)
    response.write(`<p>page: ${rows[i].page}: </p>`)
    response.write(`<p>length: ${rows[i].length}: </p>`)
    response.write(`<p>studentnum: ${rows[i].studentnum}: </p>`)
    }
  response.write(`</body></html>`)
  //write end send response to client
  response.end()
  })
}
