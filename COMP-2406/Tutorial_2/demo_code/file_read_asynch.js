
/*
Example of ASYNCHRONOUS file read.
Function readFile does not block (wait) for the file to be read. 

Instead its argument function(err,data) will be called once the file has been read. 
function(err,data) is the "call back" function that will be called when readFile's task is done.
*/


var fs = require('fs'); 

var lyrics = fs.readFileSync('songs/sister_golden_hair.txt').toString().split("\n");
var tArray = [];
var chord = [];

for(var i = 0; i < lyrics.length; i++) {
	chord.push("");
	while (lyrics[i].indexOf("[") != -1 ){
		for (var j = chord[i].length; j<lyrics[i].indexOf("["); j++){
			chord[i] +=" ";
		}
		
		chord[i] += lyrics[i].substr(lyrics[i].indexOf("[")+1, lyrics[i].indexOf("]")-lyrics[i].indexOf("[")-1);
		
		if (chord[i].charAt(chord[i].length-1) != " "){
			chord[i] += "  ";
		}
		
		lyrics[i] = lyrics[i].substr(0, lyrics[i].indexOf("[")) + lyrics[i].substr(lyrics[i].indexOf("]")+1, lyrics[i].length);
	}
	tArray.push(chord[i]);
	tArray.push(lyrics[i]);
	fs.writeFile('chords.txt', chord, function (err) {
		if (err) 
			return console.log(err);
		//console.log('Wrote Hello World in file helloworld.txt, just check it');
	});
}

for(var x=0;x<tArray.length;x++){
	console.log(tArray[x]);
}
console.log("DONE")

