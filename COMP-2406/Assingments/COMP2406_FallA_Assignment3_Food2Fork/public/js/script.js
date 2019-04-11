//Imran Juma 101036672
//Assignment 3.0
// Food2Fork quickRequest
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

// This is our function that will collect our recipes, 
// Includin taking the value of what the user will type and translating that to the possible options 
function findFoods() {

// userRequest will taken in the client information and ask them to type in what they are serching for 
    let userRequest = document.getElementById('userRequest').value
    if(userRequest === '') {
        return alert('Please enter an userRequest')
    }

    // Here we are delivering what we have found from the WebService
    // All Possible options that have been listed ae what we are able to get from the API 
    // The API Has been provided in the assingment document files 
    let RequestRecipe = document.getElementById('recipes')
    RequestRecipe.innerHTML = ''

// Here we loggining into our documents what we have done 
    document.getElementById('userRequest').value = '';
    
    // Here we are completing our HTTP Request
    // We are seeing if the responce is valid 
    // If the responce if valid we are giving the client the correct information 
    // Our for loop will complete all of this 
    let myRequest = new XMLHttpRequest()
    myRequest.onreadystatechange = () => {
        if (myRequest.readyState == 4 && myRequest.status == 200) {
            let response = JSON.parse(myRequest.responseText)             
            let recipes = response.recipes;

                // Here we are making sure that we are not over working the server, this was one of the major assingment requirments 
                // We are also making sure that we arent requestig too much data at one instatance 
            for(let i = 0; i < recipes.length; i++){
                RequestRecipe.innerHTML = RequestRecipe.innerHTML + `
                <ul>
                <li><a href="${recipes[i].f2f_url}" target="_blank"> <img src="${recipes[i].image_url}"> </a></li>
                <li>${recipes[i].title}</li>
                </ul>
                `
            }
        }
    }

    // Here we are getting the reponce and making sure that all the correct content has been delivered 
    myRequest.open('GET', `/recipe?userRequest=${userRequest}`, true)
    myRequest.send()
}

// Here is where we are making sure that the user is able to use the enter key to ccmplete their task
// Once the user types in what item they are looking for, insted of hittig the submit button they can 
// Just click the Enter button 
const ENTER=13
document.getElementById("userRequest")
    .addEventListener("keyup", function(event) {
    event.preventDefault();
    if (event.keyCode === ENTER) {
        document.getElementById("takeAway").click();
    }
});