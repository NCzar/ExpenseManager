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
    <h3> Order Submission ---          IGAMD/F22A </h3>
    
<input type="text" style="width:40%;height:30px" name="order" value="IGA Order Ref No " >
<input type="text" style="width:10%;height:30px" name="workorder" value="W.O No " >
<input type="text" style="width:20%;height:30px" name="date" value="Date " >
<br></br>
<input type="text" style="width:51%;height:30px" name="exec" value="Name of Sales Exec/manager " >
<input type="text" style="width:20%;height:30px" name="branch" value="Branch " >
<br></br>


<input type="text" style="width:40%;height:30px" name="cust1" value="Customer Details " ><br>
<input type="text" style="width:40%;height:30px" name="cust2" value="" ><br></br>
<input type="text" style="width:20%;height:30px" name="tin" value="TIN " >
<input type="text" style="width:19%;height:30px" name="cst" value="CST " ><br>
</br>
<input type="text" style="width:51%;height:30px" name="pono" value="P.O No" >
<input type="text" style="width:20%;height:30px" name="date2" value="Date" >
<br></br>
<h4>Item Details</h4>
Item &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Qty 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rating
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DC Voltage
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Input Phase
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Input Voltage Range <br></br>
<input type="text" name="item" style="width:3%"> &nbsp;&nbsp;
<input type="text" name="qty" style="width:3%"> &nbsp;&nbsp;&nbsp;
<input type="text" name="rating" style="width:3%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="dcv" style="width:6%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="inputph" style="width:5%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="ivr" style="width:5%"> &nbsp;&nbsp;&nbsp;

<h4>Output &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Warranty Details </h4>  
Phase &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Voltage/Range 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Frequency
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Equipment
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Battery
<br></br>
<input type="text" name="ph1" style="width:3%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="volt1" style="width:5%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="freq1" style="width:6%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="eq1" style="width:6%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="batt1" style="width:5%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<h4>Battery Details</h4>
Make &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Ah
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Qty
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Battery Rack/Stand/Cabinet
<br></br>
<input type="text" name="make" style="width:5%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="ah" style="width:3%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="type" style="width:6%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="qty" style="width:3%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="battrack" style="width:15%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<p> Buyback(If Any) </p> 
<textarea rows="3" cols="50">
</textarea> <br> 

<h4>Amount Details</h4>
Unity price &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Qty
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;S.T
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;E.D
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Freight
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Buyback Discount(If any)

<br></br>
<input type="text" name="qty3" style="width:6%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="at" style="width:5%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="ed" style="width:4%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="total3" style="width:4%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="fre3" style="width:6%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="buyback3" style="width:5%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="buyback3" style="width:5%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<br></br>Payment Terms &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="pay3" style="width:20%"> &nbsp;Against Delivery/Commissioning/After 30 days
<br></br>Payment till pending&nbsp;&nbsp;&nbsp;
<input type="text" name="pay4" style="width:32%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br></br><br></br>Delivery Address &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="del1" style="width:32%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br></br>Delivery terms &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="del2" style="width:32%"> &nbsp;&nbsp;&nbsp;
<br></br>Required delivery date
<input type="text" name="del3" style="width:32%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<br></br>
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
