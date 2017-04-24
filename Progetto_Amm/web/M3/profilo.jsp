<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>NerdBook - Profilo</title>
        <meta charset="UTF-8">
        <meta name="author" content="Edoardo Demuru">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Nerdbook Social Network sogni profilo personale post">
        <meta name="description" content="Profilo personale utente">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        <c:set var="page" value="1" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <div id="contentPage">     
        <jsp:include page="nav.jsp"/>  
        
        <div id="formProfilo">
           <img title="fotoProfilo" alt="Foto del Profilo" src="${utente.urlFotoProfilo}" id="Profilepic">
           <form action="profilo.html" method="post" id="Profiloform">
                <div id="formContent">                  
                  <h3>Inserisci o modifica i tuoi dati</h3>
                  
                  <div class="formitem">
                  <label for="nome">Nome</label>
                  <input type="text" name="nome" value="${utente.nome}" id="nome">
                  </div>
                  
                  <div class="formitem">
                  <label for="cognome">Cognome</label>
                  <input type="text" name="cognome" value="${utente.cognome}" id="cognome">
                  </div>
                  
                  <div class="formitem">
                  <label for="url">Url foto profilo</label>
                  <input type="url" name="url" value="${utente.urlFotoProfilo}" id="url">
                  </div>
                  
                  <div class="formitem">
                  <label for="frase">Frase di presentazione</label>
                  <textarea rows="4" cols="20" name="frase" id="frase">${utente.frasePres}</textarea>
                  </div>
                  
                  <div class="formitem">
                  <label for="data">Data di nascita</label>
                  <input type="date" id="data" name="data" value="1995-06-18">
                  
                  </div>
                  
                  <div class="formitem">
                  <label for="passw">Password</label>
                  <input type="password" name="password" value="${post.password}" id="passw">
                  </div>
                  
                  <div class="formitem">
                  <label for="confpassw">Conferma Password</label>
                  <input type="password" name="password" value="${post.password}" id="confpassw">
                  </div>
                  <button type="submit" name="modifica" id="modifica">Modifica i dati</button>
                </div>
            </form>
            
        </div>
        
        <!--<div id="formProfilo">  
            <img title="fotoProfilo" alt="Foto del Profilo" src="../img/user-icon2.png" id="Profilepic">
            <form action="profilo.html" method="post" id="Profiloform">
                <div id="formContent">                  
                  <h3>Inserisci o modifica i tuoi dati</h3>
                  
                  <div class="formitem" id="firstformitem">
                  <label for="nome">Nome</label>
                  <input type="text" name="nome" value="Luigi" id="nome">
                  </div>
                  
                  <div class="formitem">
                  <label for="cognome">Cognome</label>
                  <input type="text" name="cognome" value="Puddu" id="cognome">
                  </div>
                  
                  <div class="formitem">
                  <label for="url">Url foto profilo</label>
                  <input type="url" name="url" id="url">
                  </div>
                  
                  <div class="formitem">
                  <label for="frase">Frase di presentazione</label>
                  <textarea rows="4" cols="20" name="frase" id="frase">Ciò che non ti uccide ti rende più forte</textarea>
                  </div>
                  
                  <div class="formitem">
                  <label for="data">Data di nascita</label>
                  <input type="date" id="data" name="data">
                  </div>
                  
                  <div class="formitem">
                  <label for="passw">Password</label>
                  <input type="password" name="password" value="abcd" id="passw">
                  </div>
                  
                  <div class="formitem">
                  <label for="confpassw">Conferma Password</label>
                  <input type="password" name="password" value="abcd" id="confpassw">
                  </div>
                  <button type="submit" name="modifica" id="modifica">Modifica i dati</button>
                </div>
            </form>
            
            
        </div>-->
            
        </div>
        
        
    </body>
</html>
