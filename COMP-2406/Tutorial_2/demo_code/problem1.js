/* Example of javascript functions

Example adapted from:
 "Elequent Javascript" 2nd ed. by Marijn Haverbeke
http://eloquentjavascript.net/03_functions.html


Exercise 1: 

Modify the code given below so that the hill function makes use of the 
underscore character, just like the flat function does, 
expect the mountain tops will have to be drawn on the previous line of the output.

Also modify the code so that the following script portion will 
result in the terrain shown.

  //BUILD SCRIPT
  flat(3)
  hill(5);
  flat(2);
  hill(3);
  flat(4);
  hill(0);
  flat(2);
  //END SCRIPT


function and the program produces the following terrain.

    _____    ___
___/     \__/   \____/\__


Exercise 2: 

Modify the code from exercise 1 so you can have both hills and mountains. 
Mountains are require two output lines. 

After completing exercise 2 the following BUILD SCRIPT portion should produce the output shown. 

  //BUILD SCRIPT
  flat(3)
  mountain(3);
  flat(2);
  mountain(0);
  flat(4);
  hill(1);
  flat(1);
  //END SCRIPT


function and the program produces the following terrain.

     ___  
    /   \    /\      _
___/     \__/  \____/ \_


*/

let landscape = function() {
  let result1 = "";
  let result2 = "";
  let result3 = "";
  let flat = function(size) {
    for (let count = 0; count < size; count++){
	  result1 += " ";		
      result2 += "_";
	  result3 += " ";
	}
  };
  let hill = function(size) {
	result1 += " ";
	result2 += "/";
	result3 += " ";
    for (let count = 0; count < size; count++){
      result1 += "_";
	  result2 += " "; 
	  result3 += " ";
	}
	result1 += " ";
    result2 += "\\";
	result3 += " ";
  };
  
  let mountain = function(size){
	result1 += " /";
	result2 += "/ ";
	result3 += "  ";
	for (let count = 0; count < size; count++){
	  result1 += " ";
	  result2 += " ";
      result3 += "_";	  
	}
	result1 += "\\ ";
	result2 += " \\";
	result3 += "   ";
  
  
  };


  //BUILD SCRIPT
  flat(3)
  mountain(3);
  flat(2);
  mountain(0);
  flat(4);
  hill(1);
  flat(1);
  //END SCRIPT
  console.log(result3);
  console.log(result1);
  console.log(result2);
 // return result2;


};

console.log("");
console.log(landscape());
//  ___/''''\______/'\_
