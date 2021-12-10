<%-- 
    Document   : prostaStrona
    Created on : 2021-12-10, 10:36:57
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="5;url=./index.html" />
        <title>Lab3 - Bean w JSP</title>    
    </head>    
    <body>        
        <jsp:useBean id="dBean"class="Lab3.DataBean" scope="session" />        
        <jsp:setProperty name="dBean" property="przykladowaDana" value="<%=request.getParameter("wartosc")%>" />        
        Zapisałem dane do Beana.<br>        
        Wyprowadzam dane z Beana:         
        <i><jsp:getProperty name="dBean" property="przykladowaDana" /></i><br>
        Wywołuję inną metodą Beana:        
        <i><%= dBean.Dopisz(" zł")%></i>
    </body>
</html>
