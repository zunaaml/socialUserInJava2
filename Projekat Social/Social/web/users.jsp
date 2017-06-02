

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${users}" var="user">
            <div style="border: 1px solid red;padding: 4px;margin: 4px">
                
                    Name: ${user.firstName}<br>
                    Surname: ${user.surname}<br>
                    Age: ${user.age}<br>
                    Gender: ${user.gender}<br>
                    <a href="friends?id=${user.user_id}">
                    ${user.firstName}'s friends
                    </a><br>
                    <a href="suggestedFriends?id=${user.user_id}">
                    ${user.firstName}'s suggested friends
                    </a><br>
            </div>
            
        </c:forEach>
    </body>
</html>
