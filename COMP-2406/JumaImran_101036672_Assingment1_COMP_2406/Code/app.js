//Imran Juma 101036672
//Assignment 1.0
//Javascript Single Page App
// Find Me In Terminal At cd Desktop/A1_101036672/Single-Page-App/Assignment_Code
// Run Me At http://127.0.0.1:3000/index.html
// Newest Version 10/10/2018 12:55PM
// Submitted By Imran Juma SN:101036672, and Partner Jonathan Shubat SN:
//-----------------------------------------------------------------------Citations-----------------------------------------------------------------------#

//Book Citation: 

//Website Citation

//Tutorial Citation 
  //Tutorial:3 Posting JSON Data. (2017-10-02) Reterived from http://people.scs.carleton.ca/~comp2406/tutorials/Tutorial03-posting-JSON-data/

//----------------------------------------------------------------------Program Begins-------------------------------------------------------------------------#

//----------------------------------------------------------------------Code Below is Code Given By Professor Lou Nel -------------------------------------------------------------------------#
var http = require('http'); //need to http
var fs = require('fs'); //need to read static files
var url = require('url');  //to parse url strings

var counter = 1000; //to count invocations of function(req,res)

var ROOT_DIR = 'html'; //dir to serve static files from

var MIME_TYPES = {
    'css': 'text/css',
    'gif': 'image/gif',
    'htm': 'text/html',
    'html': 'text/html',
    'ico': 'image/x-icon',
    'jpeg': 'image/jpeg',
    'jpg': 'image/jpeg',
    'js': 'text/javascript', //should really be application/javascript
    'json': 'application/json',
    'png': 'image/png',
    'txt': 'text/plain'
};

var get_mime = function(filename) {
    var ext, type;
    for (ext in MIME_TYPES) {
        type = MIME_TYPES[ext];
        if (filename.indexOf(ext, filename.length - ext.length) !== -1) {
            return type;
        }
    }
    return MIME_TYPES['txt'];
};

http.createServer(function (request,response){
  var urlObj = url.parse(request.url, true, false);
  console.log('\n============================');
  console.log("PATHNAME: " + urlObj.pathname);
  console.log("REQUEST: " + ROOT_DIR + urlObj.pathname);
  console.log("METHOD: " + request.method);

  var receivedData = '';


  //attached event handlers to collect the message data
  request.on('data', function(chunk) {
    receivedData += chunk;
  });

  //event handler for the end of the message
  request.on('end', function(){
    console.log('received data: ', receivedData);
    console.log('type: ', typeof receivedData);
    
    //if it is a POST request then echo back the data.
    if(request.method == "POST"){
      var dataObj = JSON.parse(receivedData);
      console.log('received data object: ', dataObj);
      console.log('type: ', typeof dataObj);


      var lyricsOfSongs = {};

      var sectionsOfSong = [];
      console.log("User requested: " + dataObj.text);
      fs.readFile('songs/' + dataObj.text + '.txt', function(err, data) {
        console.log("Reading File");

//----------------------------------------------------------------------Code Above is Code Given By Professor Lou Nel -------------------------------------------------------------------------#

//                                                                          ** Assingment Code Begins **

  // This function here, will seperate the different data that we have 
  // Into different line that can be orgnized in lyrics

        if(err) throw err;
        var listOfSongs = data.toString().split("\n");

  // For loop created to store the string in a temporary value then  
  //creating an empty string that can be used and then setting a flag.

        for(i in listOfSongs) {
          let tempChord = listOfSongs[i];
          let topChord = "";
          let currentChord = true;

    // This will take the index of the first instance, and recognize that
    // if there is an open bracket being used, take our the current cord
    // however if no open bracket is found than we know we must exit the loop

          while (currentChord) {
            let songBegining = tempChord.indexOf('[');
            let songEnding = tempChord.indexOf(']');

      // This "If Statement" will recoginze that if we need to make a cut
      // here we will cut out and remove the substring that was created 
      // once cut, we will add a space to the string and place the chord in the middle
      // of the string, once completed we will add this to the topChord and confrim
      // to confirm we will make sure the temporary string only includes the remainder of what 
      // was supposed to be in the brackets 

            if (songBegining >= 0){
              let addToSong = tempChord.substr(songBegining+1, songEnding-songBegining-1);
              listOfSongs[i] = listOfSongs[i].replace('[' + addToSong + ']', "");
              for (let j=0; j<songBegining-(addToSong.length/2); j++) {
                topChord += " ";
              }
              topChord += addToSong;
              tempChord = tempChord.substr(songEnding+1);
            }
            else {
              currentChord = false;
            }
          }


    // Here we will be making sure all the correct information has been 
    // added and correctly placed into our list

          if (topChord != '') {
            sectionsOfSong.push(topChord);
          }
          sectionsOfSong.push(listOfSongs[i]);
        }

        // Here we have created a new object called 'chordsandLyricsList' that will contain all of the lines from the songs
        // Below we als have a counter, this counter will be used to track the width. DOing this we need to keep in mind 
        // that the canvas must be less than the width of 600, here we will also create the list of words 
        var chordsandLyricsList = [];
        var horizontalXCounter = 20;
        var verticalYCounter = 20;

        // Here we put a consol log that way we can keep track of whats going on and we will know when we are entering the 
        // loop, as well we have a for statment that will look at each line, one line at a time, once seening the line, we 
        // will analize the line to see the length of the line, if the string has a space than we know that we must add a 
        // value of 10 to the counter and if the string does not have a space than we know that we can now extract the word
        // and create the word object. 

        console.log("Entering loop");
        for (j=0; j<sectionsOfSong.length; j++) {
          console.log(sectionsOfSong[j]);
          var portion = sectionsOfSong[j];
          for (var k = 0; k<portion.length; k++) {
            if (portion[k] == ' ') {
              horizontalXCounter = horizontalXCounter + 12
            }

            // However, if the word is going to be transformed from something that doesnt have a space to something that will 
            // have a space then we know that we need to check and see what the last word in the string contained. Once we hace
            // check the word we must make sure that it will fit the canvas, if confirmed than we know we are okay, but if we don't
            // fit the canvas than we know we need to start a new line. This operations are done though the if - else - if - else 
            // loops that have been presented below 
            else {
              var checkForChordOrWord = '';
              if (portion.substr(k).indexOf(' ') == -1) {
                checkForChordOrWord = portion.substr(k);
                k = k + checkForChordOrWord.length-1;
              }
              else {
                checkForChordOrWord = portion.substr(k, portion.substr(k).indexOf(' '));
                k = k + checkForChordOrWord.length-1;
              }
              if ((horizontalXCounter + (10 * checkForChordOrWord.length)) <= 850) {
                chordsandLyricsList.push({word : checkForChordOrWord, x : horizontalXCounter, y : verticalYCounter});
                horizontalXCounter = horizontalXCounter + (13 * checkForChordOrWord.length);
              }
              else {
                horizontalXCounter = 20
                verticalYCounter = verticalYCounter + 40;
                chordsandLyricsList.push({word : checkForChordOrWord, x : horizontalXCounter, y : verticalYCounter});
                horizontalXCounter = horizontalXCounter + (13 * checkForChordOrWord.length);
              }
            }
          }


          //From here we know that we must start a new line after each line that has been created 
          horizontalXCounter = 20;
          verticalYCounter = verticalYCounter + 40;
        }

        lyricsOfSongs.wordArray = chordsandLyricsList;

        //This will confrm the song that has been sent out, the message below is just a confrimation within the consol that will double 
        // check that everyhtng has been working, as well we can also use this to return an object to the client. Once this is done, 
        // the code provided from professor NEL can be used to output the server and make sure everything is working okay 

        console.log("Above is the lyrics that you have requested ");
        response.writeHead(200, {'Content-Type': MIME_TYPES["text"]}); 
        response.end(JSON.stringify(lyricsOfSongs)); 
      });
    }
  });

//                                                                          ** Assingment Code Ends **

//----------------------------------------------------------------------Code Below is Code Given By Professor Lou Nel -------------------------------------------------------------------------#
  if(request.method == "GET"){
    //handle GET requests as static file requests
    var filePath = ROOT_DIR + urlObj.pathname;
    if(urlObj.pathname === '/') filePath = ROOT_DIR + '/index.html';
    fs.readFile(filePath, function(err,data){
    if(err){
      //report error to console
      console.log('ERROR: ' + JSON.stringify(err));
      //respond with not found 404 to client
      response.writeHead(404);
      response.end(JSON.stringify(err));
      return;
    }
    response.writeHead(200, {'Content-Type': get_mime(filePath)});
    response.end(data);
    });
  }
}).listen(3000);

console.log('Server Running at http://127.0.0.1:3000  CNTL-C to quit');
//----------------------------------------------------------------------Code Above is Code Given By Professor Lou Nel -------------------------------------------------------------------------#