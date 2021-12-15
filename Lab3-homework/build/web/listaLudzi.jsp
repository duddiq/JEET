<%-- 
    Document   : listaLudzi
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
        <title>JSP Page</title>
    </head>
    <body>
    <h:form id="formularz_logout" rendered="#{logowanie.sprawdź()}">
        <c:import url="ludzie.xml" var="baza"/>
        <x:parse doc="${baza}" var="wynik"/>
        
        <%-- punkt dodatkowy zad 3.2
        <h1>Pracownik o id <%=request.getParameter ("numer")%></h1>
        <%-- it doesn't work yet --%>
        <%--<x:forEach select="$wynik/ludzie/czlowiek" var="zasob">
            <c:if test="${zasob[id] == 3}">
                <x:out select="nazwisko"/></b>  
                <x:out select="imie"/>
            </c:if>
        </x:forEach>--%>
        
        <h:outputText value="Zalogowano użytkownika: #{logowanie.nazwa}" />
        <h1>Zatrudnieni pracownicy</h1>
        <ol>
            <x:forEach select="$wynik/ludzie/czlowiek" var="zasob"> 
                <li><b><x:out select="nazwisko"/></b>  
                    <x:out select="imie"/>
                </li>
            </x:forEach>
        </ol>
    
        <h:commandButton value="Wyloguj" action="#{logowanie.logout}"/>
    </h:form>
    <h:form id="niezalogowany" rendered="#{!logowanie.sprawdź()}">
         <h1>You are not logged in</h1>
         <h:commandButton value="Zaloguj" action="login"/>
    </h:form>
    </body>
</html>
</f:view>
