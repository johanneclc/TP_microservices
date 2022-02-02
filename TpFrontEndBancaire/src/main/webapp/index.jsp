<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Temperatures</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<h1> Show, modify and delete Account</h1>
	
	<div id="affichage">
	<table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>ID</th>
                <th>Iban</th>
                <th>Money</th>
            </tr>
        </thead>
        <tbody id="tbody">
					           
        </tbody>
    </table>
	</div>
	<script type="text/Javascript"> 
		$(document).ready(function() {
				$.getJSON("../../TpBackEndBancaire/account", 
				function (data) {
					console.log(data);
					data.foreach(account => $("#tbody").html("<tr >"+
	                	"<td>"+ account.id +"</td>"+
	                	"<td>"+ account.iban +"</td>"+
	                	"<td>"+account.somme+"</td>"+
	            "</tr>"))
					
			});
		});
	</script>


</body>
</html>