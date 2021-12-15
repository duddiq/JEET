<%-- 
    Document   : logout
    Created on : 2021-12-10, 13:30:28
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
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Logout page</title>
        </head>
        <body>
            <h:form id="formularz_logout">
                <h1><h:outputText value="Pomyślnie wylogowano użytkownika"/></h1>
                <h:commandButton value="Zaloguj ponownie" action="login"/>
            </h:form>
        </body>
    </html>
</f:view>