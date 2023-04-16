<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<?php
session_start();	//avvio sessione
require 'function.php';
?>
<html>
<head>
<title>ITCS Erasmo da Rotterdam</title>
</head>
<body>  
<?php

if(!isset($_POST['login']))
{
	if(!isset($_POST['Login'])){?>
  		<form name="frmLogin" action="login.php" method="POST">
		<h3>Inserisci le tue credenziali</h3>
		Username: <input type="text" name="username"><br><br>
   		Password: <input type="password" name="password"><br><br>
   		<input type="submit" name="Login">
 		</form><br>
		<a href='index.jsp'>Home page</a><br>
		<a href='sondaggi.jsp'>Sondaggi disponibili</a><br><?php
	}	
}
?>
</body>
</html>
