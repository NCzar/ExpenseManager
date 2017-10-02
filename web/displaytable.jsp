<%-- 
    Document   : displaytable
    Created on : Mar 1, 2016, 7:26:38 PM
    Author     : nikhilv85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title id="Description">My transactions</title>
    <meta name="description" content="This table shows transactions submitted by the user">
    <link rel="stylesheet" href="jqwidgets/styles/jqx.base.css" type="text/css" />
    <script type="text/javascript" src="scripts/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxcore.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxdata.js"></script> 
    <script type="text/javascript" src="jqwidgets/jqxbuttons.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxscrollbar.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxdatatable.js"></script> 
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
                    { name: 'amount', type: 'float' },
                    { name: 'manageremail', type: 'string' }
                ],
                url: "http://52.91.188.107/api/v2/expense/_table/Userentry?fields=Name,email,amount,manageremail&api_key=5a2d2152fecdb383a9c736304c927f9683fc3de4d66184d0feb4c5bd3e59b7d8&filter=email%20like%20%27<%=session.getAttribute("useremail")%>%27"
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
            $("#dataTable").jqxDataTable(
            {
                width: 850,
                pageable: true,
                pagerButtonsCount: 10,
                source: dataAdapter,
                columnsResize: true,
                columns: [
                    { text: 'Name', dataField: 'Name', width: 200 },
                    { text: 'Email', dataField: 'email', width: 250 },
                    { text: 'Amount', dataField: 'amount', cellsFormat: 'f', width: 150 },
                    { text: 'Manager Email', dataField: 'manageremail', width: 300 }
                ]
            });
        });
    </script>
</head>
<body class='default'>
    User: 
    <input type="label" name="approver" value="<%= session.getAttribute("useremail")%>" readonly /> <br></br>
    <div id="dataTable"></div><br></br>
    <input type="button" value="Back to Submission Page" name="getsubmission" onclick="document.location.href='submission.jsp'" /> 
            
</body>
</html>
