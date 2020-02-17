<html>

	<head>
		<!-- Web page title -->
    	<title>Top Trumps</title>
    	
    	<!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
    	<script src="https://code.jquery.com/jquery-2.1.1.js"></script>
    	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">

		<!-- Optional Styling of the Website, for the demo I used Bootstrap (see https://getbootstrap.com/docs/4.0/getting-started/introduction/) -->
		<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/TREC_IS/bootstrap.min.css">
    	<script src="http://dcs.gla.ac.uk/~richardm/vex.combined.min.js"></script>
    	<script>vex.defaultOptions.className = 'vex-theme-os';</script>
    	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex.css"/>
    	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex-theme-os.css"/>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">      
    </div>

 
   <body onload="initalize()"> <!-- Call the initalize method when the page loads -->
      <header>
          <div class="header">
          <center><h1 style="background-color:#000FFF; font-size:40px; color:#FFFFFF; text-align:center; padding:20px">Top Trumps Game</h1></center>
      </header>
</div>

<body>
        <style>
          
              body {
                  background-color: lightblue; 
              }

              .roundInfo{
                position: absolute;
                  right: 300;
                  top:300;

              }

              .footer {
                  position: absolute;
                  right: 0;
                  bottom: 0;
                  left: 0;
                  width: 100%;
                  padding: 1rem;
                  background-color: #4d4d4d;
                  color: #ffffff;
                  font-family: Arial;
                  font-size: 14px;
              }
</style>
        <body>
    	       <style>

              .categoryButtons { 
                  position: absolute;
                  center: 300;
                  font: bold;
                  text-align: center;
                  color: white;
                   
              .nxtButton {
                  position: absolute;
                  right: 0;
                  bottom: 300;
                  left: 1000;
                  font: bold;
                  text-align: center;
              }            
      </style>
  </div>

<div class = "container">

  <br>  <div  class="categoryButtons" id="categoryButtons">      <!-- category buttons called from API method -->     
        <div><br><button id="sizeBtn" onclick="selectCategory('1');">Size</button></div></br>
        <div><button id="speedBtn" onclick="selectCategoty('2');">Speed</button></div>
        <br><button id="rangeBtn" onclick="selectCategory('3');">Range</button></br>
        <br><button id="fireBtn" onclick="selectCategory('4');">Firepower</button></br>
        <br><button id="cargoBtn" onclick="selectCategory('5');">Cargo</button></br>
    </div>  </div></br>

      <div id="roundInfo">
      <div class="mx-auto" style="width: 200px;">
        <div class="card border-danger mb-3" style="width: 20rem;">
                <div class="card-header text-black text-center bg-danger mb-3" style="max-width: 20rem;">
                    <h5 id=>Player Info</h5>
                    <p id="currentPlayer"></p>  <!--calls on currentPlayer method in API to show player picking category -->
                    <p id="roundNumber"></p>  <!-- displays the round number -->
                    <p id="communalPile"></p>  <!-- shows how much is in the communal pile --> 
                </div>

                <div class="card-body">
                        <p id="A"></p><br/> <!-- this should be where the info for the round is displayed and changed with each round - to be implemented with method from API-->
                        <p id="B"></p>
                        <p id="C"></p>
                    </div>
   
                 </div><br/><br/>
      
    </div>

    
		<div class="container">
    <div class="card-deck">
    <div  class="card header-warning" id="card1" style="width: 18rem;">
            <div class="card-header text-black text-center bg-warning mb-3" style="max-width: 18rem;">
                <h5>Player 1: Human</h5>
            </div>
            <div class="card-id">
                </div>
                
                <div class="card-body">
                  <p class="cardContainer"> <!--method in API -->
                    <ul>
                        <p id="Size1"></p> <!-- player 1 card attributes given from method within API -->
                        <p id="Speed1"></p>
                        <p id="Range1"></p>
                        <p id="Fire1"></p>
                        <p id="Cargo1"></p>
                      </ul>
                  </p>
                </div>
              </div>
		
              <div class="card border-warning" id="card2" style="width: 18rem;">
                    <div class="card-header text-black text-center bg-warning mb-3" style="max-width: 18rem;">
                        <h5>Player 2</h5>
                    </div>
                    <div class="card-id text-center id="card">
                        </div>
                        <div class="card-body">
                          <p class="cardContainer">
                              <ul>
                        <p id="Size2"></p> <!-- player 2 card attributes given from method within API -->
                        <p id="Speed2"></p>
                        <p id="Range2"></p>
                        <p id="Fire2"></p>
                        <p id="Cargo2"></p>
                              </ul>
                          </p>
                        </div>
                      </div>

                      <div class="card border-warning" style="width: 18rem;">
                            <div class="card-header text-center text-black bg-warning mb-2" id="card3" style="max-width: 18rem;">
                                <h5>Player 3</h5>
                            </div>
                            <div class="card-id">
                                </div>
                                <div class="card-body">
                                  <p class="cardContainer">
                                      <ul>
                                          <p id="Size3"></p> <!-- player 3 card attributes given from method within API -->
                                          <p id="Speed3"></p>
                                          <p id="Range3"></p>
                                          <p id="Fire3"></p>
                                          <p id="Cargo3"></p>
                                      </ul>
                                  </p>
                                </div>
                              </div>

                              <div class="card border-warning" style="width: 18rem;">
                                    <div class="card-header text-center text-black bg-warning mb-3" id="card4" style="max-width: 18rem;">
                                        <h5>Player 4</h5>
                                    </div>
                                    <div class="card-id">
                                        </div>
                                        <div class="card-body">
                                          <p class="cardContainer">
                                              <ul>
                                              <p id="Size4"></p>  <!-- player 4 card attributes given from method within API -->
                                              <p id="Speed4"></p>
                                              <p id="Range4"></p>
                                              <p id="Fire4"></p>
                                              <p id="Cargo4"></p>
                                              </ul>
                                          </p>
                                        </div>
                                      </div>

                                      <div class="card border-warning" style="width: 18rem;">
                                            <div class="card-header text-center text-black bg-warning mb-3"  style="max-width: 18rem;">
                                                <h5>Player 5</h5>
                                            </div>
                                            <div class="card-id">
                                                </div>
                                                <div class="card-body">
                                                  
                                                  <p class="cardContainer">
                                                      <ul>
                                                          <p id="Size5"></p> <!-- player 5 card attributes given from method within API -->
                                                          <p id="speed5"></p>
                                                          <p id="Range5"></p>
                                                          <p id="Fire5"></p>
                                                          <p id="Cargo5"></p>
                                                      </ul>
                                                  </p>
                                                </div>
                                              </div>
  </div>  


<center><br><button type="button" id="nxtButton" onclick="nextGame();" class="btn btn-white text-black">Next Round</button></center><br> </center> <!-- next button method to play next round when round complete -->
      
<div class="footer"><center>
            Presented by Javamir Putin </br>Shannen Harper 2095119H - Calum Paterson 2040455P - Fara Stringfellow 2131715S - Rija Fatima 2229772F - Xiaoxu Mo 2425782M </center>
        </div>

<script type="text/javascript">
    
      // Method that is called on page load
      function initalize() {
      
        // --------------------------------------------------------------------------
        // You can call other methods you want to run when the page first loads here
        // --------------------------------------------------------------------------
        
        // For example, lets call our sample methods
        //helloJSONList();
        //helloWord(1);
  
        
        
      }
      
      // -----------------------------------------
      // Add your other Javascript methods Here
      // -----------------------------------------
    
      // This is a reusable method for creating a CORS request. Do not edit this.
      function createCORSRequest(method, url) {
          var xhr = new XMLHttpRequest();
          if ("withCredentials" in xhr) {
            // Check if the XMLHttpRequest object has a "withCredentials" property.
            // "withCredentials" only exists on XMLHTTPRequest2 objects.
            xhr.open(method, url, true);
          } else if (typeof XDomainRequest != "undefined") {
            // Otherwise, check if XDomainRequest.
            // XDomainRequest only exists in IE, and is IE's way of making CORS requests.
            xhr = new XDomainRequest();
            xhr.open(method, url);
         } else {
            // Otherwise, CORS is not supported by the browser.
            xhr = null;
           }
           return xhr;
      }
    
    </script>
    
    <!-- Here are examples of how to call REST API Methods -->
    <script type="text/javascript">
    
      // This calls the helloJSONList REST method from TopTrumpsRESTAPI
      function helloJSONList() {
      
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloJSONList"); // Request type and URL
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }
        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var responseText = xhr.response; // the text of the response
          alert(responseText); // lets produce an alert
        };
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }
      
      // This calls the helloJSONList REST method from TopTrumpsRESTAPI
      
      
      function helloWord(word) {
      
        // First create a CORS request, this is the message we are going to send (a get request in this case)
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloWord?Word="+word); // Request type and URL+parameters
        
        // Message is not sent yet, but we can check that the browser supports CORS
        if (!xhr) {
            alert("CORS not supported");
        }
        // CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
        // to do when the response arrives 
        xhr.onload = function(e) {
          var responseText = xhr.response; // the text of the response
          alert(responseText); // lets produce an alert
        };
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }
      
      
      
      
    function  currPlayerCards() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/currentcards"); // Request type and URL
        
        
        if (!xhr) {
            alert("CORS not supported");
        }
        
        xhr.onload = function(e) {
          var responseText = hr.response; // the text of the response
          alert(responseText); // lets produce an alert
          document.getElementById('cardName1').innerHTML="The active card is" + JSON.parse(responseText);
        };
        
        // We have done everything we need to prepare the CORS request, so send it
        xhr.send();   
      }
      
    
      function  currentPlayer() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/currentPlayer"); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function(e) {
          var responseText = hr.response; // the text of the response
        alert(responseText); // lets produce an alert
          document.getElementById('currentPlayer').innerHTML="The active player is" + JSON.parse(responseText);
        };
        
        xhr.send();   
      }
    
      
    </script>
    
    </body>
</html>