<%-- 
    Document   : listaUtentiCercati
    Created on : 30-mag-2017, 12.01.11
    Author     : Edoardo
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:array>
    <c:forEach var="utente" items="${userFound}">
        <json:object>
            <json:property name="id" value="${utente.id}"/>
            <json:property name="nome" value="${utente.nome}"/>
            <json:property name="cognome" value="${utente.cognome}"/>
            <json:property name="urlFotoProfilo" value="${utente.urlFotoProfilo}"/>
            
        </json:object>
    
    
    
    </c:forEach>
    
    
</json:array>