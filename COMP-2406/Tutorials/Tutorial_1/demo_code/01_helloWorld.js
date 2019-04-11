/*
Hello World example to serving string to client
*/
//To test use browser to view http://localhost:3000
//Cntl+C to stop server

var http = require('http');
var counter = 1000; 


http.createServer(function (request,response){
   var urlString = request.url;
   var index = urlString.indexOf("?name=");

	//respond to client
   console.log("request: " + request);
   console.log("\nREQUEST OBJECT KEYS (own property):");
   for(k in request) if(request.hasOwnProperty(k)) console.log("key: " + k);
   console.log("url: " + request.url);
   console.log("method: " + request.method);
   console.log("request headers");
   console.log(request.headers);
   
   response.writeHead(200, {'Content-Type': 'text/plain'});
   response.write('Hello\n');
   if (index>0) {
	   var name = urlString.substring(index + "?name=".length, urlString.length);
	   response.write(name + "\n");
   }
   else response.write("World\n");
	   
   
   //end HTTP response and provide final data to send
   response.end("["+ counter++ + "]\n");
}).listen(3000);
console.log('Server Running at http://127.0.0.1:3000  CNTL-C to quit');
console.log('To test with browser visit: http://localhost:3000');
