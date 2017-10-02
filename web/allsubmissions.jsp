<%-- 
    Document   : approval
    Created on : Jun 4, 2016, 12:07:36 AM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title id="Description">Approved transactions</title>
    <meta name="description" content="This table shows the transactions that are be approved">
    <link rel="stylesheet" href="jqwidgets/styles/jqx.base.css" type="text/css" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>

    <script type="text/javascript" src="scripts/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxcore.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxdata.js"></script> 
    <script type="text/javascript" src="jqwidgets/jqxbuttons.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxscrollbar.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxdatatable.js"></script> 
    <script type="text/javascript" src="jqwidgets/jqxinput.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxlistbox.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxdropdownlist.js"></script>  
    <script type="text/javascript" src="scripts/demos.js"></script>
    
    
    <script type="text/javascript">
        $(document).ready(function () {
            // prepare the data
            var source =
            {
                dataType: "json",
                dataFields: [
                    { name: 'Name', type: 'string' },
                    { name: 'email', type: 'string' },
                    { name: 'iImageID', type: 'int' },
                    { name: 'description', type: 'string' }
                ],
                
                url: "http://52.91.188.107/api/v2/expense/_table/Userentry?fields=Name,Email,iImageID,description&api_key=5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8&filter=(Email=%27<%=session.getAttribute("useremail")%>%27)"
            };
            var dataAdapter = new $.jqx.dataAdapter(source, 
                {
                    formatData: function (data) {
                        $.extend(data, {
                            featureClass: "P",
                            style: "full",
                            
                            maxRows: 50
                        });
                        return data;
                    }
                }
            );
            $("#table").jqxDataTable(
            {
                width: 800,
                
                pageable: true,
                pagerButtonsCount: 10,
                source: dataAdapter,
                columnsResize: true,
                columns: [
                    { text: 'Name', dataField: 'Name', width: 200 },
                    { text: 'Email', dataField: 'email', width: 250 },
                    { text: 'Transaction', dataField: 'iImageID', cellsFormat: 'f', width: 100 },
                    { text: 'Description', dataField: 'description', width: 250 }
                ]
            });
        
        //start trial
         // create jqxInput.
            $("#rowInput").jqxInput({ height: 30, width: 60 });
            // create jqxButton.
            $("#rowSelect").jqxButton({ height: 30, width: 60 });
            $("#clearSelection").jqxButton({ height: 30 });
            // create jqxDropDownList.
            $("#selectionMode").jqxDropDownList({ autoDropDownHeight: true, selectedIndex: 0, source: ['Single Row', 'Multiple Rows'], height: 30 });
            $("#selectionMode").on('change', function (event) {
                switch (event.args.index) {
                    case 0:
                        // disable multiple rows selection with Shift or Ctrl.
                        $("#table").jqxDataTable({ 'selectionMode': 'singleRow' });
                        break;
                    case 1:
                        // enable multiple rows selection with Shift or Ctrl.
                        $("#table").jqxDataTable({ 'selectionMode': 'multipleRows' });
                        break;
                }
            });
            // selects a row by index.
            
            $("#rowSelect").click(function () {
                var index = parseInt($("#rowInput").val());
                $("#table").jqxDataTable('selectRow', index);
            });
            // clear selection.
            $("#clearSelection").click(function () {
                $("#table").jqxDataTable('clearSelection');
            });
            var selectionInfo = function () {
                // gets selected row indexes. The method returns an Array of indexes.
               
                var selection = $("#table").jqxDataTable('getSelection');
                var selectedRows = "<br/>Selected Row Indexes:<br/>";
                var selectedRows1 = "";
                if (selection && selection.length > 0) {
                    var rows = $("#table").jqxDataTable('getRows');
                    for (var i = 0; i < selection.length; i++) {
                        var rowData = selection[i];
                        selectedRows += rows.indexOf(rowData);
                        selectedRows1 += rows.indexOf(rowData);
                        if (i < selection.length - 1) {
                            selectedRows += ", ";
                          
                        }
                        if (i > 1 && i % 8 === 0) {
                            selectedRows += "<br/>";
                           
                        }
                    }
                    $("#selectedRows").html(selectedRows);
                   document.getElementById('selectedRows1').value = selectedRows1;
                }
                else $("#selectedRows").html(selectedRows);
            };
            $("#table").on('rowSelect', function (event) {
                // event arguments
                
                    var args = event.args;
                var row = event.args.rowindex;
                      // var datarow = $("#table").jqxDataTable('getrowdata',row);
                        //  $("#selectedData").html(datarow);
                // row index
                var index = args.index;
                // row data
                var rowData = args.row;
                // row key
                var rowKey = args.key;
                selectionInfo();
                
                
            });
            $("#table").on('rowUnselect', function (event) {
                // event arguments
                var args = event.args;
                // row index
                var index = args.index;
                // row data
                var rowData = args.row;
                // row key
                var rowKey = args.key;
                selectionInfo();
            });
        
          $("input[type='radio']").change(function(){
                 $("#notify").show();
                 $("#t4").show();
                 $("#t5").show(); 
                 $("#t6").show(); 
                 if($(this).val()==='reassigned'){
                   $("#reassignemail").show();   
                   $("#t7").show(); 
                 }
                 else{
                    $("#reassignemail").hide();   
                   $("#t7").hide(); 
                 }
           }); 
         
        });
       
       
        function senddata() {
            if (!document.getElementById("selectedRows1").value)
            {
                alert('Please select a transaction by clicking at the row');
            }
            else if (!$("input[name=load]:checked").val()) 
            {
                alert('Please select an action');
            }
            else if($("input[name=load]:checked").val()==='reassigned' && $("#t7").val()===''){
             alert('Please enter reassigner email address');
            }
            else{
                 document.getElementById('submitbutton').click();             
            }                     
        }   
        
        function viewdoc(){
         if (!document.getElementById("selectedRows1").value)
            {
                alert('Please select a transaction by clicking at the row');
            }
            else{
                document.getElementById('submitbutton2').click();  
            }
                                      
        }
        
        function showmessage(){
              $("#t3").show();
setTimeout(function() { $("#t3").hide(); }, 10000);
        }
        
    </script>
</head>
<body class='default'>
    <form name="sel" id="selection-form" action="Selection" method="GET"> <br>
    &nbsp;&nbsp;<b> User: <input type="text" id="user" style="border:none;width:600px;margin-left: 5px;" value="<%=session.getAttribute("username")%>" ></b>
    <input type="button" value="Logout" name="logout" style="height:10%;width:40%;max-width:150px " onclick="document.location.href='index.html'" /> <br></br>

    <div id="table" style="margin-left: 10px;"></div> 
     <div style="float: left; margin-left: 10px;">
   
        <input value="6" id="rowInput" hidden/>        
        <button id="rowSelect" hidden>Select</button>
        <button id="clearSelection" hidden>Clear Selection</button>
        
        <div id="selectedRows" hidden></div>
        <input type="text" id="selectedRows1" name="selection" hidden />
      
         <div id="selectionMode" hidden></div>
         
         <br>
        
         
         
         <div class="form-group" hidden>
            <label class="col-sm-16 control-label">Select one action</label>
        <div class="col-sm-16">
            <div class="radio">
                <label> <input type="radio" name="load" id="load1" value="approved"> Final Approval </label>
            </div>
            <div class="radio">
                <label> <input type="radio" name="load" id="load2" value="rejected"> Reject </label>
            </div>
            <div class="radio">
                <label> <input type="radio" name="load" id="load3" value="reassigned" > Approve and Reassign </label>
            </div>
        </div>
        </div> 
                
         <input type="submit" id="submitbutton" value="Submit" hidden>
         <input type="text" id="t3" style="width:600px;border:none" value="<%=session.getAttribute("selector")%>" hidden>
         <p id="reassignemail" hidden><b>Enter email address of the person to whom transaction is to be reassigned</b></p>
         <input type="text" id="t7" name="t7" style="width:250px" hidden>
         <p id="notify" hidden><b>If you want other users to get notification enter their email addresses</b></p>
         <input type="text" id="t4" name="t4" style="width:250px" hidden>
         <input type="text" id="t5" name="t5" style="width:250px" hidden>
         <input type="text" id="t6" name="t6" style="width:250px" hidden>
         <br></br>
         <input type="button" id="submitselection" value="Submit" onclick="senddata()" hidden>
         <input type="button" id="view" value="Click to view document" style="height:10%;width:75%;max-width:300px" onclick="viewdoc()">
         <input type="button" value="Back" name="back" style="height:10%;width:22%;max-width:150px" onclick="document.location.href='submission.jsp'" />

         <input type="submit" id="submitbutton2" name="allsubmissions" value="Click to view document" hidden>
    </div>
</form>   
</body>
</html>
