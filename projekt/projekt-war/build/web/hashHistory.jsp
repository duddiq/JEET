<%-- 
    Document   : hashHistory
    Created on : 2022-01-08, 18:12:53
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <title>Hash history</title>
</head>
<body>
 <center>
  <h1>History of User generated hash</h1>
        <h2>
         <a href="new">Generate new hash</a>
         &nbsp;&nbsp;&nbsp;
         <a href="listHash">List all generated hashes</a>
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of generated hashes</h2></caption>
            <tr>
                <th>ID</th>
                <th>SHA3-512 hash</th>
                <th>Action</th>
            </tr>
            <c:forEach var="hash" items="${listHash}">
                <tr>
                    <td><c:out value="${hash.id}" /></td>
                    <td><c:out value="${hash.hash}" /></td>
                    <td>
                        <a href="delete?id=<c:out value='${hash.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>
