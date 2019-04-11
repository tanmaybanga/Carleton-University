var fs = require('fs');
//var colour = require('colour');  //npm install colour

var array = fs.readFileSync('songs/sister_golden_hair.txt').toString().split("\n");
var chords = [];
for(i = 0; i < array.length; i++) {
	chords.push("");
	while (array[i].indexOf("[") != -1)
	{ 
		for(var x = chords[i].length; x < array[i].indexOf("["); x++)
			chords[i] += " ";
		chords[i] += array[i].substr(array[i].indexOf("[")+1, array[i].indexOf("]") - array[i].indexOf("[")-1);
		if (chords[i].charAt(chords[i].length-1) != " ")
			chords[i] += "  ";
		array[i] = array[i].substr(0, array[i].indexOf("[")) + array[i].substr(array[i].indexOf("]")+1, array[i].length);
	}
	if (chords[i] != "")
		console.log(chords[i]);
	console.log(array[i]);
}
console.log("DONE");