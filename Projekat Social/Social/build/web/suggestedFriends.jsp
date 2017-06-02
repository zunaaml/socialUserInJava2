<%-- 
    Document   : suggestedFriends
    Created on : Jun 1, 2017, 11:55:25 PM
    Author     : Nikola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>
            ${friendUser.firstName}
            ${friendUser.surname}'s suggested friends
        </h3>
            <c:forEach items="${suggestedFriends}" var="suggestedFriend">
                <div style="border: 1px solid red;padding: 4px;margin: 4px">
                    
                    Name: ${suggestedFriend.firstName}<br>
                    Surname: ${suggestedFriend.surname}<br>
                    Age: ${SuggestedFriend.age}<br>
                    Gender: ${suggestedFriend.gender}<br>
                </div>
            </c:forEach>
    </body>
</html>
