<%-- 
    Document   : wynik
    Created on : 2021-12-10, 11:05:07
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wynik</title>
    </head>
    <body>
    <%--<h:form id="formularz_logout" rendered="#{logowanie.sprawdź()}">--%>
    <h:form id="formularz_logout">
        <c:import url="results.xml" var="baza"/>
        <x:parse doc="${baza}" var="wynik"/>
        
        <%--<h:outputText value="Zalogowano użytkownika: #{logowanie.nazwa}" />--%>
        
        <h1>Obliczona średnia geometryczna</h1>
        <h3><h:outputText value="Średnia geometryczna z #{GeometricMean.number} losowych liczb z zakresu [0; 10) wynosi #{GeometricMean.mean}" /></h3>
        
        <h:commandButton value="Powrót" action="return"/>
        <h:commandButton value="Wyloguj" action="#{logowanie.logout}"/>
        
        <h1>Recent results</h1>
        <ol>
            <x:forEach select="$wynik/results/wynik" var="zasob"> 
                <li>
                    <b><x:out select="result"/></b>  
                </li>
            </x:forEach>
        </ol>
    </h:form>
    <%--<h:form id="niezalogowany" rendered="#{!logowanie.sprawdź()}">
         <h1>You are not logged in</h1>
         <h:commandButton value="Zaloguj" action="login"/>
    </h:form>--%>
    </body>
</html>
</f:view>
