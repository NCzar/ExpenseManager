<%-- 
    Document   : igatech1
    Created on : Apr 11, 2016, 9:43:06 PM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/grabzit.min.js"></script>
</head>
<body onload="loadFromQueryString()">
<form id="myForm" action="ImageRecorder" method="POST">
    <h3> Daily Sales Report </h3>
<p> Date </p>
    <input type="text" name="date" required> <br>
    <p>Customer details and phone number</p>
    
<input type="text" name="cust" required> <br>
<p> Contact person</p>
<input type="text" name="person" required> <br>

<p> Contact Number </p> 
<input type="text" name="number" > <br>

<p> Email ID </p> 
<input type="text" name="email" > <br> 
<p> Sales potential </p> 
<input type="text" name="sales" > <br> 
<p> Next Action </p> 
<input type="text" name="next" > <br> 
<p> Travel Mode </p> 
<input type="text" name="travel" > <br> 
<p> Km </p> 
<input type="text" name="km" > <br> 
<p> Expense </p> 
<input type="text" name="exp" > <br> 
<p> DA </p> 
<input type="text" name="da" > <br> <br>

<textarea id="result1"  name="res1"  cols="10" rows="1" hidden ></textarea> <br>
<input type="button" value="Take Screenshot" onclick="createScreenshot();"/><br></br>

<button id="d" onclick="myfunc()">Save and Submit</button><br>

<input type="submit" name="Submit" hidden> <br> 
</form>
    
<div id="divResult" ></div>
<script type="text/javascript">

/*
*  This populates the form from the query string
*/
function loadFromQueryString()
{
    var query = document.location.search.replace('?', '');
    query = query.split('&');

    for (var i = 0; i < query.length; i++)
    {
      var field = query[i].split("=");

      if (field == null)
      {
          continue;
      }

      //assumes there is only one matching form name
      var formElement = document.getElementsByName(field[0]);

      if (formElement != null && formElement.length >= 1)
      {
          formElement[0].value = decodeURIComponent(field[1]);
      }
    }
    
    Data.saveToFile(Page.getHtml(), "source1.html");
}

/*
* This makes a query string from the form value name pairs and
* sends it along with the current URL to grabzit.
*/
function createScreenshot()
{
	var kvpairs = [];
	var form = document.getElementById('myForm');
	for ( var i = 0; i < form.elements.length; i++ ) {
	   var e = form.elements[i];
           var formVal = e.value;
           if (formVal != null)
           {
               //fixes issues by double encoding hashes
               formVal = formVal.replace("#","%2523");
           }
	   kvpairs.push(encodeURIComponent(e.name) + "=" + encodeURIComponent(formVal));
	}
	var queryString = kvpairs.join("&");

	var url = document.location.href;

	if (url.indexOf('?') == -1)
	{
		url += '?' + queryString;
	}
	else
	{
		url += '&' + queryString;
	}

    var div = document.getElementById('divResult');
    
    //clear old screenshots
    div.innerHTML = '';

    //add grabzit javascript dynamically with this pages URL.
    GrabzIt("YWE1YTViZjIzZjFlNDE3Yzk2ZGU1YTVjYWEzZjIyN2I=").AddTo(div, url,{"delay": 1000, "format": "png","bheight":-1});
    
    return false;
}

function myfunc(){
     var x = document.images[0].src;
   
    document.getElementById("result1").innerHTML = x;
 }
</script>

</body>
</html>
