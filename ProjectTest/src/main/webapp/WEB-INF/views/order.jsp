<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.acorn.testing.KakaoUserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// session 내장객체 
		     // request.getSession X
	        
	       //   String    nickname = (String) session.getAttribute("nickname");
	         // String    userCode = (String) session.getAttribute("userCode");user
	         
	         
	             KakaoUserDTO    user = (KakaoUserDTO) session.getAttribute("user");
	      
			if (user == null) {

				System.out.println("null " + user);
			} else {
				System.out.println(user);
			}
	%>


	<form id="orderForm" method="post" action="/order">  
        <label for="nickname">닉네임:</label><br>
        <input type="text" id="nickname" name="nickname" value="<%=user.getNickname()%>"><br><br>
        <label for="userCode">유저 코드:</label><br>
        <input type="text" id="userCode" name="userCode" value="${user.nickname}"><br><br>
        <label for="phoneNum">전화번호:</label><br>
        <input type="text" id="phoneNum" name="phoneNum"><br><br>
        <!-- 다른 필요한 정보들을 추가하십시오 -->
        <input type="submit" value="주문하기">
    </form>

</body>
</html>