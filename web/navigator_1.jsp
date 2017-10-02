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
    <meta http-equiv="refresh" content="60" />  
   
    
        <link rel="stylesheet" href="css/home.css">  
        <link rel="stylesheet" href="css/checknet.css" media="all" />
<script type="text/javascript" src="js/jquery.checknet-1.6.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>    
<script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyCkLFeq4D1Cowxwd4ZSBAmiU-Dv8eyLrzQ"></script>
<script type="text/javascript">
   
var str1,str2,str3,str4;

function showlocation(){
    
    navigator.geolocation.watchPosition(callback1);
    
     var x = "<%=session.getAttribute("status")%>";
    
     if(x === "Trip recording in progress" ){
           
             document.getElementById('start1').style.visibility="hidden";
             document.getElementById('tr').style.visibility="hidden";
             document.getElementById('message2').innerHTML = "Trip recording in progress";
        }
        
        else{
            document.getElementById('stop1').style.visibility="hidden";
            //document.getElementById('message2').innerHTML = "Trip recording has stopped";
        }
   
}

function rel(){
     location.reload(true);
          
}
function showlocation2(){
    
    navigator.geolocation.watchPosition(callback2);
}

function callback1(position){

    str1=position.coords.latitude;
    str2=position.coords.longitude;

    document.getElementById('result1').value = str1;
    document.getElementById('result2').value = str2; 
    
    document.getElementById('message1').innerHTML = "<%=session.getAttribute("status")%>";    
    document.getElementById('originatt').value = ".";
       
    var latlon = position.coords.latitude + "," + position.coords.longitude;

    var img_url = "http://maps.googleapis.com/maps/api/staticmap?center="
    +latlon+"&zoom=14&size=300x200&js?key=AIzaSyCkLFeq4D1Cowxwd4ZSBAmiU-Dv8eyLrzQ";
    document.getElementById("mapholder").innerHTML = "<img src='"+img_url+"'>";

}

function delay(ms) {
   ms += new Date().getTime();
   while (new Date() < ms){}
}

$("myform").submit(function() {
    $(this).submit(function() {
        return false;
    });
    return true;
});
</script>
</head>
<body onload="setTimeout(function() { document.myform.submit() }, 10000)">
    <div id="img1">
    <img src="images/home/logo1.jpg"  style="width:80%;">
    </div>
    <div id="main">
    <form name="myform" action="TripRecorder" method="GET">
        <h4> Click Start Trip to start recording and Stop Trip to stop recording </h4>
   
<!--<span id="latitude" name="latit" hidden> </span>

 <span id="longitude" hidden> </span>
<br>-->
<span id="message1" hidden name="msg1"> </span>
<span id="message2" > </span>
</br></br>

 <input type="button" name="start" class="st1" id="st" value="Start" hidden onclick="showlocation()"/> 
 <input id="start1" type="button" id="start1"  name="starttrip" style="width:40%;height:30px;max-width:200px" value="Start Trip" onclick="showtracking1()" /> <br> <br/>

 <input class="one" id="s1" type="submit" name="submit1" style="width:40%;height:30px;max-width:200px" hidden value="Start"  /> 
 <input id="stop1" type="button" id="stop1" name="stoptrip" style="width:40%;height:30px;max-width:200px" value="Stop Trip " onclick="showtracking2()" /> <br> <br/> 

 <input class="two" id="s2" type="submit" name="submit2" style="width:40%;height:30px;max-width:200px" hidden value="Stop"  />    
 
 <input type="button" name="trip" class="trip" id="tr" style="width:40%;height:30px;max-width:200px" value="Get Trip Details" onclick="document.location.href='tripdetails.jsp'" /> <br> <br/> 
  
     <input id="originatt" type="text" hidden  value="<%=request.getParameter("origin5")%>"  ><br><br> 
     <input type="button" style="width:40%;height:30px;max-width:200px" hidden value="Back to Submission Page" name="back" onclick="document.location.href='submission.jsp'" /> <br> <br/>
  
     <textarea id="result1"  name="res1" value="str1" cols="20" rows="1" hidden ></textarea> 
      <textarea id="result2" name="res2" value="str2" cols="20" rows="1" hidden ></textarea>
      <input class="one" id="s1" type="submit" name="submit1" hidden value="Get Distance"  /> 
     
     <!-- <input class="one" id="s1" type="submit" name="submit" value="Submit"  /> <br> <br/> -->

    </form>
     <br>
     
           
        <h5>Powered by Google Maps</h5>
        <div id="mapholder"></div>
        <br> 
        <br>  
         </div>
</body>
</html>

<script type="text/javascript">

window.setTimeout(function() {
  
  repeat();
}, 10);


    function repeat(){
    
   document.getElementById("st").click();
  
    }

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

function showtracking1() {
        document.getElementById('message1').innerHTML = "Trip recording in progress";
        document.getElementById('s1').click();
        
         document.getElementById('start1').disabled=true; 
    }   

function showtracking2() {
        document.getElementById('message1').innerHTML = "Trip recording has stopped";
        
        document.getElementById('s2').click();
        
        document.getElementById('stop1').disabled=true;   
    } 

    document.getElementById('submit1').onclick = function() {
        setTimeout(submitForm, 3000); 
    };

$(document).ready(function(){
    $.fn.checknet();
    checknet.config.checkInterval = 1000;
checknet.config.warnMsg = "There is no connection!!";
  });

 </script>