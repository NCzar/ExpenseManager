<%-- 
    Document   : geoloc
    Created on : Feb 27, 2016, 10:31:34 PM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta name="viewport" content="width=device-width, initial-scale=1"/> 

   
    
        <link rel="stylesheet" href="css/home.css">  
    
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
   
var x,y;  
x=41.689844;  

var origin = new google.maps.LatLng(x,-74.044874),
    destination = new google.maps.LatLng(42.2569387,-71.0043555),
    
    service = new google.maps.DistanceMatrixService();

var str1,str2,str3,str4;

function showlocation(){
    navigator.geolocation.watchPosition(callback1);
    delay(2000);
}

function rel(){
     location.reload(true);
     
}
function showlocation2(){
    
    navigator.geolocation.watchPosition(callback2);
}

function callback1(position){
   // document.getElementById('latitude').innerHTML=position.coords.latitude;
   // document.getElementById('longitude').innerHTML=position.coords.longitude;
    
   /* var str = 'Latitude: '  + position.coords.latitude      + '<br>' +
                  'Longitude: ' + position.coords.longitude     + '<br>' +
                  'Timestamp: ' + position.timestamp     + '<br>\r\n' ;
        document.getElementById('result').value += str;
    */
   
    str1=position.coords.latitude;
    str2=position.coords.longitude;
    document.getElementById('result1').value += str1;
    document.getElementById('result2').value += str2;
    document.getElementById('originatt').value = ".";
    document.getElementById('destatt').value = ".";
    document.getElementById('distatt').value = ".";
    
    document.getElementById('message1').innerHTML ="Trip Recording has started"+"<br>"+"Click Get Origin Address";
}


function callback2(position){
  //document.getElementById('latitude').innerHTML=position.coords.latitude;
   //document.getElementById('longitude').innerHTML=position.coords.longitude;
    
   /* var str = 'Latitude: '  + position.coords.latitude      + '<br>' +
                  'Longitude: ' + position.coords.longitude     + '<br>' +
                  'Timestamp: ' + position.timestamp     + '<br>\r\n' ;
        document.getElementById('result').value += str;
    */
    str3=position.coords.latitude;
    str4=position.coords.longitude;
    document.getElementById('result3').value += str3;
    document.getElementById('result4').value += str4;
    document.getElementById('originatt').value = ".";
    document.getElementById('destatt').value = ".";
    document.getElementById('distatt').value = ".";
    
    
    document.getElementById('message1').innerHTML ="Trip Recording has stopped"+"<br>"+"Click to Get Destination Address";
    
}

service.getDistanceMatrix(
    {
        origins: [origin],
        destinations: [destination],
        travelMode: google.maps.TravelMode.DRIVING,
        avoidHighways: false,
        avoidTolls: false
    }, 
    callback
);

function callback(response, status) {
    var orig = document.getElementById("orig"),
        dest = document.getElementById("dest"),
        dist = document.getElementById("dist");

     
   

    if(status=="OK") {
        orig.value = response.destinationAddresses[0];
        dest.value = response.originAddresses[0];
        dist.value = response.rows[0].elements[0].distance.text;
    } else {
        alert("Error: " + status);
    }
}

function delay(ms) {
   ms += new Date().getTime();
   while (new Date() < ms){}
}
</script>
</head>
<body>
    <div id="img1">
    <img src="images/home/logo1.jpg"  style="width:80%;">
    </div>
    <div id="main">
    <form name="myform" action="ComputeDistance" method="POST">
        <h4>   Click Start to record Origin and Stop to record Destination </h4>


    
<!--<span id="latitude" name="latit" hidden> </span>

 <span id="longitude" hidden> </span>
<br>-->
<span id="message1" name="msg1"> </span>
</br></br>

 <input type="button" name="start" value="Start Trip" onclick="showlocation()"/> 
 <!--<button id="d" onclick="showlocation()">Start Trip</button><br><br/> -->
<br><br/>   
      




     <input id="originatt" type="text"  value="<%=request.getAttribute("origin5")%>"  ><br><br>
     
     <textarea id="result1"  name="res1" value="str1" cols="10" rows="1" hidden></textarea>
      <textarea id="result2" name="res2" value="str2" cols="10" rows="1" hidden></textarea>
      <input class="one" id="s1" type="submit" name="submit1" value="Get Origin Address"  /> <br> <br/>
     
      
      
    </form>
     <br>
      <form name="myform2" action="ComputeDistance" method="GET">
          <input type="button" name="stop" value="Stop Trip" onclick="showlocation2()"/> <br></br>
          
          <input id="destatt" type="text" value="<%=request.getAttribute("origin6")%>"  ><br><br>
          <input class="two" id="s2" type="submit" name="submit2" value="Get Destination Address" /> <br> <br/>
          <h4> Distance: </h4>
          <input id="distatt" type="text" value="<%=request.getAttribute("distance1")%>" ><br><br>
           <textarea id="result3" name="res3" value="str3" cols="10" rows="1"hidden ></textarea>
      <textarea id="result4" name="res4" value="str4" cols="10" rows="1" hidden></textarea>
          
      </form>
   
            <input type="button" value="Back to Submission Page" name="back" onclick="document.location.href='submission.jsp'" /> <br> <br/>
        <h5>Check distance using Google Maps</h5>
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3929.1219514911336!2d76.32904011409968!3d10.006784275664728!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3b08729de9da66b7%3A0x3ede9e0d7ae9f2fa!2sIGA+TECH+Industrial+Electronics+Pvt+Ltd!5e0!3m2!1sen!2sus!4v1456591588301" width="100" height="100" frameborder="0" style="border:0" allowfullscreen></iframe>
       
        <br>  
         </div>
</body>
</html>

<script type="text/javascript">
   

function showvalue(){
 //var someValue = $('#lat span').text();
 var div = document.getElementById("test");
var spans = div.getElementsByTagName("span");

for(i=0;i<spans.length;i++)
{
  alert(spans[i].innerHTML);
}
 }

function submitForm() {
        document.getElementById("myform").submit();
    }

    document.getElementById('submit1').onclick = function() {
        setTimeout(submitForm, 3000); 
    };


 </script>