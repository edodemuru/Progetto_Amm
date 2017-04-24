<%-- 
    Document   : nav
    Created on : 23-apr-2017, 19.21.06
    Author     : Edoardo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:choose>
    <c:when test="${page==0}">
        
        <div id="lateral">
            <form id="searchsection" action="bacheca.jsp">
                <input type="search" id="search" name="search" value="cerca">
                
            </form>
            <div id="peoplesection">
            <h2 class="lateraltitle">Persone</h2>
            <div class="fotoProfilo2">
            <img title="fotoProfilo" alt="Foto del Profilo" src="../img/user-icon.png" >
            <p>Pinco Pallino</p>
            </div>
            <div class="fotoProfilo2">
            <img title="fotoProfilo" alt="Foto del Profilo" src="../img/user-icon.png" >
            <p>Riccardo Rossi</p>
            </div>
            <div class="fotoProfilo2">
            <img title="fotoProfilo" alt="Foto del Profilo" src="../img/user-icon.png" >
            <p>Edoardo Demuru</p>
            </div>
            </div>
            
            <div id="groupsection">
            <h2 class="lateraltitle" id="groups">Gruppi</h2>            
            <div class="fotoProfilo2">
            <img title="fotoGruppo" alt="Foto di un Gruppo" src="../img/groupimg.png" >
            <p class="group">Informatici</p>
            </div>
            <div class="fotoProfilo2">
            <img title="fotoGruppo" alt="Foto di un Gruppo" src="../img/groupimg.png" >
            <p class="group">Ingegneri</p>
            </div>
            </div>
            
          <nav id="linksbacheca">
              <h2 class="lateraltitle">Link</h2>
            <p class="link"><a href="descrizione.jsp">Informazioni sul Social Network</a></p>     
          </nav>
            
        </div>       

    </c:when>
    
    <c:when test="${page==1}">
        
        <div id="lateral2">
            <form id="searchsection" action="bacheca.jsp">
                <input type="search" id="search" name="search" value="cerca">     
            </form>
            
            <div id="peoplesection">
            <h2 class="lateraltitle">Persone</h2>
            <div class="fotoProfilo2">
            <img title="fotoProfilo" alt="Foto del Profilo" src="../img/user-icon.png" >
            <p>Pinco Pallino</p>
            </div>
            <div class="fotoProfilo2">
            <img title="fotoProfilo" alt="Foto del Profilo" src="../img/user-icon.png" >
            <p>Riccardo Rossi</p>
            </div>
            <div class="fotoProfilo2">
            <img title="fotoProfilo" alt="Foto del Profilo" src="../img/user-icon.png" >
            <p>Edoardo Demuru</p>
            </div>            
            </div>
            
            <div id="groupsection">
            <h2 class="lateraltitle" id="groups">Gruppi</h2>
            
            <div class="fotoProfilo2">
            <img title="fotoGruppo" alt="Foto di un Gruppo" src="../img/groupimg.png" >
            <p class="group">Informatici</p>
            </div>
            <div class="fotoProfilo2">
            <img title="fotoGruppo" alt="Foto di un Gruppo" src="../img/groupimg.png" >
            <p class="group">Ingegneri</p>
            </div>
            </div>
            
          <nav id="linksbacheca">
              <h2 class="lateraltitle">Link</h2>
            <p class="link"><a href="descrizione.jsp">Informazioni sul Social Network</a></p>     
          </nav>
            
        </div>
        
        
    </c:when>
    
    <c:when test="${page==2}">
        
        <div id="lateral5">
             <form id="searchsection" action="bacheca.jsp">
                <input type="search" id="search" name="search" value="cerca">
                
            </form>             
            <div id="peoplesection">
            <h2 class="lateraltitle">Persone</h2>
            <div class="fotoProfilo2">
            <img title="fotoProfilo" alt="Foto del Profilo" src="../img/user-icon.png" >
            <p>Pinco Pallino</p>
            </div>
            <div class="fotoProfilo2">
            <img title="fotoProfilo" alt="Foto del Profilo" src="../img/user-icon.png" >
            <p>Riccardo Rossi</p>
            </div>
            <div class="fotoProfilo2">
            <img title="fotoProfilo" alt="Foto del Profilo" src="../img/user-icon.png" >
            <p>Edoardo Demuru</p>
            </div>
            </div>
            
            <div id="groupsection">
            <h2 class="lateraltitle" id="groups">Gruppi</h2>            
            <div class="fotoProfilo2">
            <img title="fotoGruppo" alt="Foto di un Gruppo" src="../img/groupimg.png" >
            <p>Informatici</p>
            </div>
            <div class="fotoProfilo2">
            <img title="fotoGruppo" alt="Foto di un Gruppo" src="../img/groupimg.png" >
            <p>Ingegneri</p>
            </div>
            </div>
            
          <nav id="linksbacheca">
              <h2 class="lateraltitle">Entra in Nerdbook</h2>
            <p class="link" id="loginid"><a href="login.jsp">Login</a></p>     
          </nav>
             
           
          
        </div>
        
        
    </c:when>
    
</c:choose>