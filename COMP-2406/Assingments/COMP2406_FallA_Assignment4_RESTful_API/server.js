//Imran Juma 101036672
//Assignment 4.0
// Express Server with Database
// Run Me At "http://localhost:3000" By typing "http://localhost:3000" Into your selected web-address  
// Newest Version 12/7/2018 11:39PM
// Submitted By Imran Juma SN:101036672, and Partner Jonathan Shubat SN: 101035236
//-----------------------------------------------------------------------Citations-----------------------------------------------------------------------#

//Book Citation: 

//Website Citation
    // http://www.food2fork.com

//Tutorial Citation 
	//Tutorial07:  Express Setup And Middleware  -- http://people.scs.carleton.ca/~comp2406/tutorials/Tutorial07_Express_Setup_And_Middleware/
	//Tutorial08:  Using Mongo With NodeJS -- http://people.scs.carleton.ca/~comp2406/tutorials/Tutorial08_Using_Mongo_With_NodeJS/
	//Tutorial09:  Express With SQLite -- http://people.scs.carleton.ca/~comp2406/tutorials/Tutorial09_Express_with_SQLite/
	//Tutorial010: Interaction & Design Principles -- http://people.scs.carleton.ca/~comp2406/tutorials/Tutorial10-interaction-design-principles/
   

//----------------------------------------------------------------------Program Begins-------------------------------------------------------------------------#

/************************************************************************/
// Here we have our different requirements, these will inlude the various itmes
// that must be included to get the server up and going, these will include the http, express server, and the different paths
// that are all needed. 

var http = require('http'); 
var express = require('express'); 
var path = require('path'); 
var favicon = require('serve-favicon');
var logger = require('morgan');
/************************************************************************/


/************************************************************************/
// Here we will create the express middleware, this will launch the dispacher to launche
// the application allowing us to acess it at localhost:3000
var  app = express(); 
const PORT = process.env.PORT || 3000
/************************************************************************/


/************************************************************************/
// Here we will be able to load the engine setup this will create our format, but 
// with will also allow us to have handlebars and differernt wrappers, the bowwom line will also
// allow us to generate a uniqe cource code witin the browser 
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'hbs'); 
app.locals.pretty = true; 
/************************************************************************/

/************************************************************************/
//Here we will be reading the different modules, once this is done, we have a few items that will log 
// in the colnsol the different things that are going on.
var routes = require('./routes/index');


function methodLogger(request, response, next){
		   console.log("METHOD LOGGER");
		   console.log("================================");
		   console.log("METHOD: " + request.method);
		   console.log("URL:" + request.url);
		   next(); //call next middleware registered
}
function headerLogger(request, response, next){
		   console.log("HEADER LOGGER:")
		   console.log("Headers:")
           for(k in request.headers) console.log(k);
		   next(); //call next middleware registered
}
/************************************************************************/

/************************************************************************/
// Here we will register the middleware with the dispacher that we are working with, here this is where 
// the order really comes to the most import state, and then we have more middleware functions 
// below this we willl have all of our get methods, as well as our autheniticaion for the user that 
// has been selected
app.use(routes.authenticate); 
app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.get('/index.html', routes.index);
app.get('/', routes.index);
app.get('/recipes', routes.getRecipes);
app.get('/recipeDetails', routes.recipeDetails);
/************************************************************************/

/************************************************************************/
// Here we will have the code that will get the server going and launch it. 
app.listen(PORT, err => {
  if(err) console.log(err)
  else {console.log(`Server listening on port: ${PORT} CNTL:-C to stop`)}
})
/************************************************************************/

