<%-- 
    Document   : hashGenerate
    Created on : 2022-01-08, 23:11:27
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Hash generate</title>
    </head>
    
<body>
 <center>
  <h1>Generate new hash</h1>
        <h2>
         <a href="new">Generate new hash</a>
         &nbsp;&nbsp;&nbsp;
         <a href="listHash">List all generated hashes</a>
        </h2>
 </center>
<div align="center">
    <c:if test="${newHash != null}">
    <form action="add" method="post">
    </c:if>
    <c:if test="${newHash == null}">
    <form action="calculate" method="post">
    </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
               Generate hash
             </h2>
            </caption>          
            <tr>
                <th>Input string: </th>
                <td>
                 <input type="text" name="input" size="128"
                   value="<c:out value='${newHash.input}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>SHA3-512 hash: </th>
                <td>
                    <input type="text" name="hash" size="128" readonly
                   value="<c:out value='${newHash.hash}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
                <c:if test="${newHash == null}">
                <input type="submit" value="Calculate" />
                </c:if>
                <c:if test="${newHash != null}">
                <input type="submit" value="Save" />
                <input type="button" onclick="location.href='new';" value="Reset" />
                </c:if>
             </td>
            </tr>
        </table>
    </form>
</div>
</html>
