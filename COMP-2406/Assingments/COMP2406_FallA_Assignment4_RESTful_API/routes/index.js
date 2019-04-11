var url = require('url');
var fs = require('fs'); //built in node file system module
var lineReader = require('line-reader'); //npm install line-reader
var sqlite3 = require('sqlite3').verbose(); //verbose provides more detailed stack trace
var db = new sqlite3.Database('data/recipes.db');

/************************************************************************/
// Here we have our required information, this will include the url, the file system ,module, as well as the 
// npm install line reafer and lastly the tracing track for the final result. We also have the file reader 
// for the data base that is being used.
function condense(arr) {
  // the naming here is vague, needs to be fixed later
  let response = '';
  for(let i = 0; i < arr.length; i++) {
    response += " " + arr[i];
  }

  return response;

}
/************************************************************************/

/************************************************************************/
// Here we have a portion of our authentication system, here we will have the different possible logins 
// that can be used to acess our program, I have made one for my self (Imran Juma), one for my partner (Jonatham Shubat),
// As well we have created one for the guest, AKA the marking TA to use.
db.serialize(function(){
      var serverStringNeeded = "CREATE TABLE IF NOT EXISTS users (userid TEXT PRIMARY KEY, password TEXT)";
      db.run(serverStringNeeded);
      serverStringNeeded = "INSERT OR REPLACE INTO users VALUES ('imranjuma', 'testcase1')";
      db.run(serverStringNeeded);
	  serverStringNeeded = "INSERT OR REPLACE INTO users VALUES ('jonathanshubat', 'testcase2')";
      db.run(serverStringNeeded);
	  serverStringNeeded = "INSERT OR REPLACE INTO users VALUES ('guestuser', 'markingta')";
      db.run(serverStringNeeded);
  });
/************************************************************************/

/************************************************************************/
// Here we have some authentication prices that will be used by the user, as well as some more middleware that 
// will be included below

  exports.authenticate = function (request, response, next){

	// Here we have some more of our middleware that will be used as part of our authentication process
      var loginKey = request.headers.authorization;
	
	// here we have the authentication that is based upon the representation 
	// of a system that works on username and a password, however this all comes form a base64 format
  	if(!loginKey){
  		response.setHeader('WWW-Authenticate', 'Basic realm="need to login"');
          response.writeHead(401, {'Content-Type': 'text/html'});
  		console.log('No authorization found, send 401.');
   		response.end();
  	}
  	else{
		// here we have our authentication header 
  	    console.log("Authorization Header: " + loginKey);
          var tmp = loginKey.split(' ');

  		//creating a buffe for the base64 system 
          var buf = new Buffer(tmp[1], 'base64');

          //giving the string back out 
  		var plain_auth = buf.toString();
          console.log("Decoded Authorization ", plain_auth);

          //extraction profess begins
          var userKeys = plain_auth.split(':');     
          var username = userKeys[0];
          var password = userKeys[1];
          console.log("User: ", username);
          console.log("Password: ", password);

  		var letMeLogin = false;
  		//Here we see if you are a user in the system 
  		db.all("SELECT userid, password FROM users", function(err, rows){
        
    		for(var i=0; i<rows.length; i++){
    		      if(rows[i].userid == username & rows[i].password == password) letMeLogin = true;
    		}
  		if(letMeLogin == false){
   	 	   //Here you have been found not to be a user within our system
  		   response.setHeader('WWW-Authenticate', 'Basic realm="need to login"');
             response.writeHead(401, {'Content-Type': 'text/html'});
  		   console.log('No authorization found, send 401.');
   		   response.end();
  		}
          else
  		  next();
  		});
  	}
  }
/************************************************************************/

/************************************************************************/
  exports.index = function (request, response){
          // index.html
  	     response.render('recipes', { title: 'COMP 2406 - ASSIGNMENT4', body: 'rendered with handlebars'});
  }
/************************************************************************/

/************************************************************************/
// Here we will parse and then slash
  function parseURL(request, response){
  	var parseQuery = true; 
      var badHost = true; 
      var urlObj = url.parse(request.url, parseQuery , badHost );
      console.log('path:');
      console.log(urlObj.path);
      console.log('query:');
      console.log(urlObj.query);
  	return urlObj;
  }
/************************************************************************/

/************************************************************************/
function writeRecipesToFile(recipes){
  var filePath = 'data/recipes.txt';
  var fileGoingOut = fs.createWriteStream(filePath);
  for (i in recipes) {
    fileGoingOut.write(`${i}: ${recipes[i].recipe_name}\n`);
  }
  fileGoingOut.end();
  fileGoingOut.on('finish', function() {
    console.log('Writing to ' + filePath + ' complete');
  });
}
/************************************************************************/

// 							Here we will be working with the database
/************************************************************************/

function writeRecipesToDatabase(recipes){
  db.serialize(function() {

     //Here we will drop the current files in the database and work with the new ones that we are creating now
     var serverStringNeeded = "DROP TABLE IF EXISTS recipes";
     db.run(serverStringNeeded);

	 //this will create a new table within the database
     serverStringNeeded = "CREATE TABLE IF NOT EXISTS recipes (id INTEGER PRIMARY KEY, recipe_name TEXT, contributor TEXT, category TEXT, description TEXT, spices TEXT, source TEXT, rating TEXT, ingredients TEXT, directions TEXT)";

     db.run(serverStringNeeded);

     var stmt = db.prepare("INSERT INTO recipes (recipe_name,contributor,category,description,spices,source,rating,ingredients,directions) VALUES (?,?,?,?,?,?,?,?,?)");
     for (var i = 0; i < recipes.length; i++) {
   	    recipe = recipes[i];
        stmt.run(recipe.recipe_name, recipe.contributor, recipe.category, recipe.description, recipe.spices, recipe.source, recipe.rating, recipe.ingredients, recipe.directions);
     }
     stmt.finalize();
  });
}
/************************************************************************/

//Here we will have the code for when we are parcing the file 
/************************************************************************/
function isTag(input){
	return input.startsWith("<");
}
function isOpeningTag(input){
	return input.startsWith("<") && !input.startsWith("</");
}
function isClosingTag(input){
	return input.startsWith("</");
}
/************************************************************************/

/************************************************************************/
// Here we will be looking at the data between the different tags 
// once this is done we will be opening the XML tags
// Then we will parce and then parse again 
// Fianlly we will read the AlaCarteData but this will go indivually section by section 
// taking this informaion into the JSON object 
// However before this can be done we must seek validation and make sure
// that we are correctly validating the .XML file 

/************************************************************************/
var dataArray = [];
var dataString = ''; 
var openingTag = ''; 
var recipes = []; 
var recipe = {};  
recipe.spices = [];
recipe.ingredients = [];
/************************************************************************/


/************************************************************************/
lineReader.eachLine(

    'data/aLaCarteData_rev3.xml',
    function(line, last) {
	    str = line.trim();
		if(isOpeningTag(str)){
			openingTag = str;
      dataArray = [];
			dataString = '' 
		} else if(isClosingTag(str)){

		   if(str === '</recipe_name>') {
			   recipe.recipe_name = condense(dataArray);

		   } else if(str === '</contributor>'){
			   recipe.contributor = condense(dataArray);

		   }else if(str === '</category>'){
			   recipe.category = condense(dataArray);

		   }else if(str === '</description>'){
			   recipe.description = condense(dataArray);

		   }else if(str === '</spices>'){
			   recipe.spices = dataArray.toString();

		   }else if(str === '</source>'){
			   recipe.source = condense(dataArray);

		   }else if(str === '</rating>'){
			   recipe.rating = condense(dataArray);

		   }else if(str=== '</ingredients>') {
         recipe.ingredients = dataArray.toString();

       } else if(str=== '</directions>') {
         recipe.directions = condense(dataArray);

       } else if(str === '</recipe>'){
			   recipes.push(recipe);
			   recipe = {};

		   }
           openingTag = '';

/************************************************************************/

/************************************************************************/
		} else {
			dataArray.push(str);
		}
/************************************************************************/

		// Here we have the data for when we are done reading the file, and when we need 
		// to stop reading the file 
        if (last) {
          console.log("DONE");
           //writeRecipesToFile(recipes);
           writeRecipesToDatabase(recipes);
           return false; 
           }
});
/************************************************************************/


/************************************************************************/
// Here we will have the information for where we can get the recipe
exports.getRecipes = function (request, response){
  console.log('ingredients happened');
	var urlObj = parseURL(request, response);
/************************************************************************/

/************************************************************************/
// Here we will have our information for when we want to serch by the ingrediant
  if(urlObj.query.ingredients) {
    console.log('ingredient search');
    var sql = "SELECT id, recipe_name, ingredients FROM recipes";
    let IngredientsFinder = urlObj.query.ingredients.split(',');
    db.all(sql, function(err, rows){
/************************************************************************/

/************************************************************************/
      let userReponseLog = [];
      for(let i=0; i<rows.length; i++) {
        let row = rows[i];
        let ingredients = row.ingredients;
        ingredients = ingredients.split(',');
        for (let k = 0; k<IngredientsFinder.length; k++) {
            for(let j = 0; j<ingredients.length; j++) {
              if(ingredients[j].toLowerCase().includes(IngredientsFinder[k].toLowerCase())) {
                userReponseLog.push(row);
                j = ingredients.length;
                k = IngredientsFinder.length;
              }

          }
        }
      };
       response.render('recipes', {title: 'Recipe Search', Name: userReponseLog});
    });
/************************************************************************/

/************************************************************************/
  } else if (urlObj.query.spices) {
    console.log('search via spice');
    var sql = "SELECT id, recipe_name, spices FROM recipes";
    let spiceFinder = urlObj.query.spices.split(',');
    db.all(sql, function(err, rows){

      let userReponseLog = [];
      for(let i=0; i<rows.length; i++) {
        let row = rows[i];
        let spices = row.spices
        spices = spices.split(',');
        for (let k = 0; k<spiceFinder.length; k++) {
          for(let j = 0; j<spices.length; j++) {
            if(spices[j].toLowerCase().includes(spiceFinder[k].toLowerCase())) {
              userReponseLog.push(row);
              j = spices.length;
              k = spiceFinder.length;
            }
          }
        }
      };
       response.render('recipes', {title: 'Recipe Search', Name: userReponseLog});
    });
  /************************************************************************/

/************************************************************************/
  } else {
      response.render('recipes', { title: 'Recipe Search', body: 'rendered with handlebars'});
  }
}
/************************************************************************/


/************************************************************************/
// Here we will have our different selection options 
exports.recipeDetails = function(request, response) {
  var urlObj = parseURL(request, response);
	var sql = "SELECT recipe_name, spices, ingredients, directions FROM recipes WHERE id=" + urlObj.query['id'];


  db.all(sql, function(err, rows){
    //  recipeObj.spices = spices.split(',');
    rows[0].spices = rows[0].spices.split(',');
    rows[0].ingredients = rows[0].ingredients.split(',');
    
       response.render('recipeDetails', {title: rows[0].recipe_name, Recipe: rows});
		});
}
/************************************************************************/
