<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Front Verfication Back</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
<div id="affichage">
	<hr>
		<p>Proposez votre iban à la vérification : </p>
	<hr/>
</div>
<input type="text" id="iban" class="form-control" />

<input type="submit" id="replaceContent" value="Go !"></input>
<script type="text/Javascript"> 
	$(document).ready(function() {
		$("#replaceContent").click(function() {
			var iban =$("#iban").val();
			$.getJSON("../../TBBackEndIban/IbanCheck?iban=" + iban, 
			function (data) {
				console.log(data);
				var resultat = data.isValid;
				$("#affichage p").html("<p>" + "Validité de votre iban : " + resultat
				+ "</p>");
			}); 
		});
	});
</script>
</body>
</html>