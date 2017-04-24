<%-- 
    Document   : header
    Created on : 23-apr-2017, 12.17.09
    Author     : Edoardo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:choose>
    <c:when test="${page==0}">
<header id="titleBac">
            <h1 id="titleNet">Nerdbook</h1>
            <div id="linkdif">
                <h1 id="linkProf"><a href="profilo.jsp" class="buttlink">Profilo</a></h1>
                <h1 id="linkBach"><a href="bacheca.jsp" class="buttlink">Bacheca</a></h1>
            </div>
            <nav id="logout">
            <h2>${utente.nome}</h2>
             <div class="fotoProfiloLogout">
            <img title="fotoProfilo" alt="Foto del Profilo" src="${utente.urlFotoProfilo}" >
             </div>
            <a href="login.jsp">Logout</a>   
            </nav>
        </header>
    </c:when>
    
    <c:when test="${page==1}">
        <header id="titleBac">
            <h1 id="titleNet">Nerdbook</h1>
            <div id="linkdif">
            <h1 id="linkProf2"><a href="profilo.jsp" class="buttlink">Profilo</a></h1>
            <h1 id="linkBach2"><a href="bacheca.jsp" class="buttlink">Bacheca</a></h1>
            </div>
            <nav id="logout">
            <h2>${utente.nome}</h2>
             <div class="fotoProfiloLogout">
            <img title="fotoProfilo" alt="Foto del Profilo" src="${utente.urlFotoProfilo}" >
             </div>
            <a href="login.jsp">Logout</a>   
        </nav>
        </header>
        
    </c:when>
    
    <c:when test="${page==2}">
        <header id="titleBac">
            <h1 id="titleNet">Nerdbook</h1>
            <div id="linkdif">
                <h1 id="linkProf"><a href="profilo.jsp" class="buttlink">Profilo</a></h1>
            <h1 id="linkBach2"><a href="bacheca.jsp" class="buttlink">Bacheca</a></h1>
            </div>
            <nav id="logout">
            <h2>${utente.nome}</h2>
            <div class="fotoProfiloLogout">
            <img title="fotoProfilo" alt="Foto del Profilo" src="${utente.urlFotoProfilo}" >
            </div>
            <a href="login.jsp">Logout</a>   
            </nav>
        </header>  
        
    </c:when>

</c:choose>

