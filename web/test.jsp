<%-- 
    Document   : test
    Created on : Feb 25, 2016, 1:41:51 AM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Image</title>
    
        <style>
		/* styles unrelated to zoom */
		* { border:0; margin:0; padding:0; }
		p { position:absolute; top:3px; right:28px; color:#555; font:bold 13px/1 sans-serif;}

		/* these styles are for the demo, but are not required for the plugin */
		.zoom {
			display:inline-block;
			position: relative;
		}
		
		/* magnifying glass icon */
		.zoom:after {
			content:'';
			display:block; 
			width:33px; 
			height:33px; 
			position:absolute; 
			top:0;
			right:0;
			background:url(icon.png);
		}

		.zoom img {
			display: block;
		}

		.zoom img::selection { background-color: transparent; }

		#ex2 img:hover { cursor: url(grab.cur), default; }
		#ex2 img:active { cursor: url(grabbed.cur), default; }
	</style>
	<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
	<script src='zoom-master/jquery.zoom.js'></script>
	<script>
		$(document).ready(function(){
			$('#ex1').zoom();
			
		});
                
                function ImagetoPrint(source) {
    return "<html><head><script>function step1(){\n" +
            "setTimeout('step2()', 10);}\n" +
            "function step2(){window.print();window.close()}\n" +
            "</scri" + "pt></head><body onload='step1()'>\n" +
            "<img src='" + source + "' /></body></html>";
}
function PrintImage(source) {
    Pagelink = "about:blank";
    var pwa = window.open(Pagelink, "_new");
    pwa.document.open();
    pwa.document.write(ImagetoPrint(source));
    pwa.document.close();
}
	</script>
    </head>
    <body>
        <form id="docform" action="Getdocid" method="GET">
         <br>
         &nbsp;&nbsp;&nbsp;&nbsp; Document
        
         <input type="text" name="docno" readonly value='<%=session.getAttribute("myId")%>' style="border:1px solid black;margin-left:20px" /> 
         <input type="submit" name="submit" value="Enter" hidden style="border:1px solid black;margin-left:20px;width:100px"/>
         
         <br></br>
        
        <span class='zoom' id='ex1'>
		<img src='display.jsp?iImageID=<%=session.getAttribute("myId")%>' height ="500" width="500"  style="border:1px solid black;margin-left:20px" />		
	</span>      
                <br></br>
                &nbsp;&nbsp;&nbsp;&nbsp; <a href="#" onclick="PrintImage('display.jsp?iImageID=<%= session.getAttribute("myId")%>'); return false;">Print Image</a>
      &nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="Back to Approval Page" style="width:150px;height:30px" name="back" onclick="openPage('approval.jsp')"/>
    <br>
    </form>
     <script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
 
</script>
    </body>
</html>
