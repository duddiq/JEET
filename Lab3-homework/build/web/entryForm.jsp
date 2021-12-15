<%-- 
    Document   : entryForm
    Created on : 2021-12-15, 17:53:41
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Entry data</title>
        </head>
        <body>
            <%--<h:form id="formularz_srednia" rendered="#{logowanie.sprawdź()}">--%>
                <h:form id="formularz_srednia">
                <h3><h:outputText value="Zalogowano użytkownika: #{logowanie.nazwa}" /></h3>
                <h:outputText value="Podaj liczbę losowych elementów (domyślnie 5)"/><br/>
                <h:inputText id="number" value="#{GeometricMean.number}" maxlength="3" converter="javax.faces.Integer" /><br/><br/>
                <h:commandButton value="Oblicz" action="calculate"/>
            </h:form>
            <%--<h:form id="niezalogowany" rendered="#{!logowanie.sprawdź()}">
                <h1>You are not logged in</h1>
                <h:commandButton value="Zaloguj" action="login"/>
            </h:form>--%>
        </body>
    </html>
</f:view>