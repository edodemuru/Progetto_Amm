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
            <form id="searchsection" action="bacheca.html">
                <input type="search" id="search" name="search" value="cerca">
                
            </form>
             
            <div id="peoplesection">
            <h2 class="lateraltitle">Persone</h2>
            
            <c:forEach var="amico" items="${amici}">
                <div class="fotoProfilo2">
                   <img title="fotoProfilo" alt="Foto del Profilo" src="${amico.urlFotoProfilo}" >
                   <p><a href="bacheca.html?idAmico=${amico.id}">${amico.nome} ${amico.cognome}</a></p>
                </div>                                       
            </c:forEach>
            </div>
            
            <div id="groupsection">
                <h2 class="lateraltitle" id="groups">Gruppi</h2>
                <c:forEach var="gruppo" items="${gruppi}">
                    <div class="fotoProfilo2">
                        <img title="fotoGruppo" alt="Foto di un Gruppo" src="${gruppo.urlFotoGruppo}" >
                        <p class="group">${gruppo.name}</p>
                    </div>
                    
                </c:forEach>
            </div>
            
          <nav id="linksbacheca">
              <h2 class="lateraltitle">Link</h2>
            <p class="link"><a href="descrizione.html">Informazioni sul Social Network</a></p>     
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
            <c:forEach var="amico" items="${amici}">
                <div class="fotoProfilo2">
                   <img title="fotoProfilo" alt="Foto del Profilo" src="${amico.urlFotoProfilo}" >
                   <p><a href="bacheca.html?idAmico=${amico.id}">${amico.nome} ${amico.cognome}</a></p>
                </div>                                       
            </c:forEach>
                        
            </div>
            
            <div id="groupsection">
            <h2 class="lateraltitle" id="groups">Gruppi</h2>
            <c:forEach var="gruppo" items="${gruppi}">
                    <div class="fotoProfilo2">
                        <img title="fotoGruppo" alt="Foto di un Gruppo" src="${gruppo.urlFotoGruppo}" >
                        <p class="group">${gruppo.name}</p>
                    </div>
                    
                </c:forEach>            
            </div>
           <c:if test="${loggedIn==false}"> 
          <nav id="linksbacheca">
              <h2 class="lateraltitle">Link</h2>
            <p class="link"><a href="descrizione.html">Informazioni sul Social Network</a></p>     
          </nav>
           </c:if>
            
        </div>
        
        
    </c:when>
    
            
    <c:when test="${page==2}">
        
        <div id="lateral5">
            <c:if test="${loggedIn==true}">
             <form id="searchsection" action="bacheca.jsp">
                <input type="search" id="search" name="search" value="cerca">
                
            </form>             
            <div id="peoplesection">
            <h2 class="lateraltitle">Persone</h2>
            
            <c:forEach var="amico" items="${amici}">
                <div class="fotoProfilo2">
                   <img title="fotoProfilo" alt="Foto del Profilo" src="${amico.urlFotoProfilo}" >
                   <p><a href="bacheca.html?idAmico=${amico.id}">${amico.nome} ${amico.cognome}</a></p>
                </div>                                       
            </c:forEach>
            </div>
            
            <div id="groupsection">
            <h2 class="lateraltitle" id="groups">Gruppi</h2>            
            <c:forEach var="gruppo" items="${gruppi}">
                    <div class="fotoProfilo2">
                        <img title="fotoGruppo" alt="Foto di un Gruppo" src="${gruppo.urlFotoGruppo}" >
                        <p>${gruppo.name}</p>
                    </div>
                    
                </c:forEach>
            </div>
            </c:if>
            
            <c:if test="${loggedIn==false}">
          <nav id="linksbacheca">
              <h2 class="lateraltitle">Entra in Nerdbook</h2>
            <p class="link" id="loginid"><a href="login.html">Login</a></p>     
          </nav>
            </c:if>
             
           
          
        </div>
        
        
    </c:when>
    
</c:choose>