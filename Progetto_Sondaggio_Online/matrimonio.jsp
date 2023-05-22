<!-- PROGETTO FINALE SVOLTO DA:
		  BALLABIO MATTEO
		          &
		   VUOLO SAMUELE 		-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/matrimonio.css">
<meta charset="ISO-8859-1">
<title>ITCS Erasmo da Rotterdam</title>
</head>
<body>
<h2>Questionario sulla qualità dei nostri prodotti</h2><br><br>
<h4>Informazioni sul questionario</h4>
<div class="info_que">
<p>In questo questionario verranno chieste alcune informazioni inerenti l'utente che sta svolgendo il sondaggio.<br>
Ci saranno tipi diversi di domande:<br>
1) Domande a risposta chiusa;<br>
2) Domande a risposta aperta.<br>
</div>
<a href="index.jsp">Torna alla home page</a>
<br><br>
<div class="info_utente">
<p>--------------- INFORMAZIONI UTENTE ---------------<br></p>
</div>

<div class="info_user">
<h3>Nome:</h3>
<input type="text">
<h3>Cogome:</h3>
<input type="text">
<h3>Città:</h3>
<input type="text">
<br><br><br>
</div>
<div class="start_que">
<p>--------------- INIZIO QUESTIONARIO ---------------<br></p>
</div>
<div class="questionario">
<h4>Quale tipologia di cucina vorresti mangiare al tuo prossimo matrimonio?</h4>
<input type="text">
<h4>Vorresti un buffet?</h4>
<input type="checkbox">Si<br>
<input type="checkbox">No<br>
<h4>Scrivi due cibi che vorresti mangiare durante la cena del matrimonio</h4>
<input type="text"> e 
<input type="text">
<h4>Scrivi due cibi che non vorresti mangiare durante la cena del matrimonio</h4>
<input type="text"> e 
<input type="text">
<h4>Con che mezzo andrai al matrimonio?</h4>
<input type="checkbox">Macchina<br>
<input type="checkbox">Treno<br>
<input type="checkbox">Bicicletta<br>
<input type="checkbox">Bombardiere B2<br>
<h4>Che regalo porterai al matrimonio?</h4>
<input type="checkbox">Anello<br>
<input type="checkbox">Soldi<br>
<input type="checkbox">Barca a vela<br>
<input type="checkbox">Cocktail di gamberi<br>
</div>
<br><br>
<input type="submit">
</body>
</html>
