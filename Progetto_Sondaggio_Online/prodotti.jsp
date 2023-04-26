<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/prodotti.css">
<title>ITCS Erasmo da Rotterdam</title>
</head>
<body>
<div class="inte_que">
<h2>Questionario sui prodotti offerti</h2><br><br>
</div>
<div class="info_que">
<h4>Informazioni sul questionario</h4>
<p>In questo questionario sono presenti tre tipi di domande:<br>
1) Domande a risposta chiusa con numeri: 1 = Pessimo | 5 = Ottimo;<br>
2) Domande a risposta chiusa con range di numeri.<br>
3) Domande a risposta aperta dove dovrai scrivere tu la risposta.</p><br>
</div>
<a href="index.jsp">Torna alla home page</a>
<div class="inte_que">
<h2>--------------- INIZIO QUESTIONARIO ---------------</h2>
</div>
<div class="questionario">
<h4>Prodotto che hai acquistato</h4>
<input type="text">
<h4>Valutazione della qualita' del nostro prodotto</h4>
<input type="checkbox" id="checkbox">1<br>
<input type="checkbox" id="checkbox">2<br>
<input type="checkbox" id="checkbox">3<br>
<input type="checkbox" id="checkbox">4<br>
<input type="checkbox" id="checkbox">5<br>
<h4>Quanto e' stato facile usare il prodotto offerto?</h4>
<input type="checkbox" id="checkbox">1<br>
<input type="checkbox" id="checkbox">2<br>
<input type="checkbox" id="checkbox">3<br>
<input type="checkbox" id="checkbox">4<br>
<input type="checkbox" id="checkbox">5<br>
<h4>Prezzo totale degli acquisti sul nostro sito</h4>
<input type="checkbox">0 euro - 49.99 euro<br>
<input type="checkbox">50 euro - 99.99 euro<br>
<input type="checkbox">100 euro - 149.99 euro<br>
<input type="checkbox">150 euro - 199.99 euro<br>
<input type="checkbox">>= 200 euro<br>
</div>
<br>
<input type="submit">
</body>
</html>
