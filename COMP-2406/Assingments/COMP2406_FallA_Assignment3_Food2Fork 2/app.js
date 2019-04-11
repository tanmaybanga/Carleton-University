//Imran Juma 101036672
//Assignment 3.0
// Food2Fork express
// Run Me At "http://localhost:3000" By typing "http://localhost:3000" Into your selected web-address  
// Newest Version 11/20/2018 3:30PM
// Submitted By Imran Juma SN:101036672, and Partner Jonathan Shubat SN: 101035236
//-----------------------------------------------------------------------Citations-----------------------------------------------------------------------#

//Book Citation: 

//Website Citation
    // http://www.food2fork.com

//Tutorial Citation 
  //Tutorial04: Browser Events & AJAX -- http://people.scs.carleton.ca/~comp2406/tutorials/Tutorial04-browser-events-and-AJAX/
  //Tutorial05: Assignment2 Code & Progress Demo -- http://people.scs.carleton.ca/~comp2406/tutorials/Tutorial05-Assignment2-code-progress-demo/
  //Tutorial06: Food2ForkAPI -- http://people.scs.carleton.ca/~comp2406/tutorials/Tutorial06-Food2ForkAPI/

//----------------------------------------------------------------------Program Begins-------------------------------------------------------------------------#

// Here is all the .JS File that we need for out program, this includes the framework, the npm module 
// These will be userd for our HTTP Request
// Aswell, this will also include what port we are using to run the program, this means that the user can just type in 
// Localhost:3000 into the webaddress into Safari, Chrome or webservice and the program will work no problem 


const express = require('express') 
const foodRequest = require('request') 
const PORT = process.env.PORT || 3000

// Here is my API Key that I was able to get for free from our website 
const API_KEY = '5d83cd07caadf39d1ffd6ba1408dc68e' 

const app = express()

// Here is our Middleware and Routs that we will be usig. this also includes our static server
app.use(express.static(__dirname + '/public')) //static server


app.get('/', (findMe, responseFromUser) => {
  responseFromUser.sendFile(__dirname + '/views/index.html')
})

app.get('/recipe', (request, responseFromUser) => {
  let userRequest = request.query.userRequest
  if(!userRequest) {
    return responseFromUser.json({message: 'Please enter an ingrediant for query'})
  }

  // <-- THis is our like that the user will be lollecting the data from
  const url = `http://www.food2fork.com/api/search?q=${userRequest}&key=${API_KEY}` 
	foodRequest.get(url, (err, res, data) => {
	console.log(JSON.parse(data));
    return responseFromUser.contentType('application/json').json(JSON.parse(data))
  })
})

// Here we will be able to start our server and get everything going 
app.listen(PORT, err => {
  if(err) console.log(err)
  else {
    console.log(`Server listening on port: ${PORT}`)
  }
})