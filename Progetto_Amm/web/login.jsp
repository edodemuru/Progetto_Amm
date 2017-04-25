<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    
    <head>
        <title>NerdBook - Login</title>
        <meta charset="UTF-8">
        <meta name="author" content="Edoardo Demuru">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Nerdbook Social Network sogni login nome password">
        <meta name="description" content="Login Social Network">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        <header id="title">
            Nerdbook - Il Social Network dei Sogni
        </header>
        
        
        
        <div id="lateral4">
        <nav id="link">
            <h2>Dove vuoi andare?</h2>
            <ol>
                <li><a href="descrizione.html">Informazioni sul Social Network</a></li>
                <li><a href="profilo.html">Profilo</a></li>
                <li><a href="bacheca.html">Bacheca Personale</a></li>
            </ol>
            
        </nav>
        </div>
        
      
        
        
        <div id="formboxLogin">
        <form action="Login" method="post">
            <div id="loginContent">
              <h2 id="idtitleLogin">Login</h2>
              <div id="usernameBox">
              <label for="username">Username</label>
              <input type="text" name="username" id="username">
              </div>
              <div id="passwordBox">
              <label for="passw">Password</label>
              <input type="password" name="password" id="passw">
              </div>
              <button type="submit" name="Submit" value="Login" id="buttonacc">Accedi</button>
            </div>
        </form>
        </div>
        
        <c:if test="${!empty errore}">
             <div id="loginError">
                 <p>Errore nell'inserimento dell'username o della password!</p>
             </div>           
        </c:if>
        
        
         
        
        
        
        
        
    </body>
    
    
    
    
</html>
