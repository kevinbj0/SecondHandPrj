<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="com.sh.login.LoginDTO"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="/testing/login" method="post">
        <div>
            <label for="user_id">Username:</label>
            <input type="text" id="user_id" name="user_id" >
        </div>
        <div>
            <label for="user_pw">Password:</label>
            <input type="password" id="user_pw" name="user_pw" >
        </div>
        <button type="submit">Login</button>
         
         
         <c:if test="${ not empty param.error}">
        	<p style="color: red;">잘못된 아이디/비밀번호입니다.<br>다시 입력해주세요.</p>
   		</c:if>
    </form>

</body>
</html>