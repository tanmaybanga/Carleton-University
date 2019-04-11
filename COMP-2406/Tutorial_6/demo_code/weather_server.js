/*
Interacting with external services

Simple example of node.js app serving contents based 
on an available internet service. 
In this case api.openweathermap.org

***IMPORTANT NOTE***
As of 2015 openweather requires that you provide an APPID
with your HTTP requests. You can get on by creating a
free account at: http://openweathermap.org/appid

To Test: Use browser to view http://localhost:3000/
*/

let http = require('http')
let url = require('url')
let qstring = require('querystring')

const PORT = process.env.PORT || 3000
//Please register for your own key replace this with your own.
const API_KEY = '0489b0f2640cc5a0f4a19fa7cfb2e4d1'

function sendResponse(weatherData, res){
  var page = '<html><head><title>API Example</title></head>' +
    '<body>' +
    '<form method="post">' +
    'City: <input name="city"><br>' +
    '<input type="submit" value="Get Weather">' +
    '</form>'
  if(weatherData){
    page += '<h1>Weather Info for ' + JSON.parse(weatherData).name + '</h1><p>' + weatherData +'</p>'
  }
 //console.log(weatherData);
  page += '</body></html>'    
  res.end(page);
}

function parseWeather(weatherResponse, res) {
  let weatherData = ''
  weatherResponse.on('data', function (chunk) {
    weatherData += chunk
  })
  weatherResponse.on('end', function () {
    sendResponse(weatherData, res)
  })
}

function getWeather(city, res){

//New as of 2015: you need to provide an appid with your request.
//Many API services now require that clients register for an app id.

//Make an HTTP GET request to the openweathermap API
  let options = {
    host: 'api.openweathermap.org',
    path: '/data/2.5/weather?q=' + city + 
	'&appid=' + API_KEY
  }
  http.request(options, function(apiResponse){
    parseWeather(apiResponse, res)
  }).end()
}

http.createServer(function (req, res) {
  let requestURL = req.url
  let query = url.parse(requestURL).query //GET method query parameters if any
  let method = req.method
  console.log(`${method}: ${requestURL}`)
  console.log(`query: ${query}`) //GET method query parameters if any
  
  if (req.method == "POST"){
    let reqData = ''
    req.on('data', function (chunk) {
      reqData += chunk
    })
    req.on('end', function() {
	  console.log(reqData);
      var queryParams = qstring.parse(reqData)
	  console.log(queryParams)
      getWeather(queryParams.city, res)
    })
  }else if (method == "GET") {
	  var para = qstring.parse(query);
	console.log(para);
	getWeather(para.city, res);
  } else {
    sendResponse(null, res)
  }
  
}).listen(PORT, (error) => {
  if (error)
    return console.log(error)
  console.log(`Server is listening on PORT ${PORT} CNTL-C to quit`)
})
