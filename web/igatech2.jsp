<%-- 
    Document   : igatech2
    Created on : Apr 12, 2016, 1:11:19 AM
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
    <h3> Daily Service Report </h3>
Date 
<input type="text" name="date" > 
    Serial No  
<input type="text" name="serial"> <br>
<p> Caller ID No</p>
<input type="text" name="caller"> <br>

<p> Work Details </p> 
<input type="text" name="work" > <br>

<p> Customer Details with Phone No</p> 
<input type="text" name="cust" style="height:30px" > <br> 
<p> Equipment Details with Battery Amt,Sl No </p> 
<input type="text" name="battery" style="height:30px"  > <br> 
<p> Warranty Details </p> 
<input type="text" name="warranty" > <br> 
<p> Billing Details </p> 
<input type="text" name="billing" > <br> 
<p>Complaint details</p> 
<input type="text" name="complaint" > <br> 
<p>Action taken </p> 
<input type="text" name="action" > <br> 
<p>Spare Used</p> 
<input type="text" name="spare" > <br> 
<p>Status</p> 
<input type="text" name="complaint" > <br> 
<p>Bus/Auto/Bike </p> 
<input type="text" name="action" > <br> 
<p>From</p> 
<input type="text" name="spare" > <br> 
<p>To</p> 
<input type="text" name="spare" > <br> 
<p>Km</p> 
<input type="text" name="complaint" > <br> 
<p>Rs </p> 
<input type="text" name="rs" > <br> 
<h3> Points </h3>
<p>LO</p> 
<input type="text" name="lo" > <br> 
<p>OS</p> 
<input type="text" name="os" > <br> 
<p>Addl.Travel</p> 
<input type="text" name="addl" > <br>
<p>Total points</p> 
<input type="text" name="addl" > <br>

<br>
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
