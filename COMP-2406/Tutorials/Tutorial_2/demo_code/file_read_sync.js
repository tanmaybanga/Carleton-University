
/*
Example of a SYNCHRONOUS file read.
the readFileSync() function blocks (waits) and only returns once the file is read.

See
http://nodejs.org/api/fs.html
and more specifically: http://nodejs.org/api/fs.html#fs_fs_readfilesync_filename_options

*/

var fs = require('fs'); 

var lyrics = fs.readFileSync('songs/sister_golden_hair.txt').toString().split("\n"); 
var tArray = [];
var chord = [];
	
for(var i = 0; i < lyrics.length; i++) {
	chord.push("");
	while (lyrics[i].indexOf("[") != -1 ){
		//console.log(lyrics.indexOf("["));
		
		for (var j = chord[i].length; j<lyrics[i].indexOf("["); j++){
			chord[i] +=" ";
		}
		chord[i] += lyrics[i].substr(lyrics[i].indexOf("[")+1, lyrics[i].indexOf("]")-lyrics[i].indexOf("[")-1);
		if (chord[i].charAt(chord[i].length-1) != " "){
			chord[i] += "  ";
		}
		lyrics[i] = lyrics[i].substr(0, lyrics[i].indexOf("[")) + lyrics[i].substr(lyrics[i].indexOf("]")+1, lyrics[i].length);
		//lyrics[i] = lyrics[i].replace(lyrics[i].substr(lyrics[i].indexOf("["),lyrics[i].indexOf("]")), "");
		/*for(var j = chord[i].length; j < lyrics[i].indexOf("["); j++){
			chord[i] += " ";
		}
		chord[i] += lyrics[i].substr(lyrics[i].indexOf("[")+1, lyrics[i].indexOf("]")-lyrics[i].indexOf("[")-1);
		if (chord[i].charAt(chord[i].length-1) != " "){
			chord[i] += "  ";
		}
		lyrics[i] = lyrics[i].substr(0, lyrics[i].indexOf("[")) + lyrics[i].substr(lyrics[i].indexOf("]")+1, lyrics[i].length);
		//console.log(lyrics[i]);*/
	}
	//console.log(lyrics[i])
	//console.log("\n");
	tArray.push(chord[i]);
	tArray.push(lyrics[i]);
}
for(var x=0;x<tArray.length;x++){
		console.log(tArray[x]);
}
console.log("DONE");	
