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
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"
          
    </div>

      <body onload="initalize()"> <!-- Call the initalize method when the page loads -->
<header>
    <div class="header">
        <center><h1>Top Trumps Game</h1></center>
    </header>
</div>

<body>
        <style>
          .header{
                  background-color:#000FFF
                  font-size:40px                
                  color:#FFFFFF              
                  text-align:center;
                  padding:20px
            }

          body {
                  background-color: lightblue;
            }

            .footer {
                  position: absolute;
                  right: 0;
                  bottom: 0;
                  left: 0;
                  width: 100%;
                  padding: 2rem;
                  background-color: #4d4d4d;
                  color: #ffffff;
                  font-family: Arial;
                  font-size: 14px;
        }

    </style>

<center><div style="float:center; margin: 30px; padding: 20px; height: 400px; width: 400px;background: #FAF55A; class="table">
    <div class="text-center text-black mb-3">
                <p><h5 style="Font-size:20px; text-align:center;"> Your game statistics are:</h5></p>
                <p><h7>Average Number of Draws:</h7><h7 id="drawNumber"></h7></p> <!-- pulls stats from methods within API -->
                <p><h7>Number of Human Wins:</h7><h7 id="humanWin"></h7></p>
                <p><h7>Number of AI Wins:</h7><h7 id="aiWin"></h7></p>
                <p><h7>Number of Rounds in Longest Game:</h7><h7 id="rounds"></h7></p>
                <p><h7>Total number of games played:</h7><h7 id="maxGame"></h7></p></br>
                <button id="MenuBtn" onclick="location.href='http://localhost:7777/toptrumps/'">Back to Main Menu</button></center>
            </div>
    
        </div>
    



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
        //helloWord("Student");
        
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
    </script>
    
    </body>
</html>