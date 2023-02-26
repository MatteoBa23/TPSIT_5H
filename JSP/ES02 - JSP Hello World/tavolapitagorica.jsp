<!DOCTYPE html>
<html>
<head>
	<title>Tavola Pitagorica</title>
	<style>
		table, th, td {
			border: 1px solid black;	<!-- BORDO DELLE CELLE -->
			padding: 5px;	<!-- SPAZIO TRA LE CELLE -->
		}
	</style>
</head>
<body>
	<h1>Tavola Pitagorica</h1>
	<table>
		<body>
			<%
				// Genero le righe della tabella con i numeri da 1 a 10
				for (int i = 1; i <= 10; i++) {
					out.println("<tr>");
					for (int j = 1; j <= 10; j++) {
						out.println("<td>" + (i * j) + "</td>");
					}
					out.println("</tr>");
				}
			%>
		</body>
	</table>
</body>
</html>
