<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.acorn.testing.KakaoUserDTO"%>
<%@ page import="com.sh.saveUser.UserDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li onclick="kakaoLogin();"><a href="javascript:void(0)"> <span>카카오
					회원가입</span>
		</a></li>
		<li onclick="kakaoLogout();"><a href="javascript:void(0)"> <span>카카오
					로그아웃</span>
		</a></li>
		<form id="myForm12" method="post" action="/testing/myForm12">
			<a href="/testing/logintest1111">
				<li>우리거 회원가입</li>
			</a>
		</form>
	</ul>
	<!-- 카카오 스크립트 -->
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script>
      Kakao.init("c56a5ac8208747818bdaee7eb60e05ea");
      console.log(Kakao.isInitialized());
      
      function kakaoLogin() {
        Kakao.Auth.login({
          success: function (response) {
            Kakao.API.request({
              url: "/v2/user/me",
              success: function (response) {
                document.getElementById("user_kakao").value = response.id;
                document.getElementById("nickname").value =
                  response.properties.nickname;
                document.getElementById("profile_image").value =
                  response.properties.profile_image;      
                document.getElementById("myForm").submit();
               
               
              },
              fail: function (error) {
                console.log(error);
              },
            });
          },
          fail: function (error) {
            console.log(error);
          },
        });
      }
      
      function kakaoLogout() {
        if (Kakao.Auth.getAccessToken()) {
          Kakao.API.request({
            url: "/v1/user/unlink",
            success: function (response) {
              logout();
              console.log(response);
            },
            fail: function (error) {
              console.log(error);
            },
          });
          Kakao.Auth.setAccessToken(undefined);
        }
      }
      
      function logout() {
        fetch('/logout', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
        }).then(response => {
          location.reload();
        }).catch(error => console.error('Error:', error));
      }
    </script>
	<form id="myForm" method="post" action="/testing/myForm">
		<input type="hidden" id="user_kakao" name="user_kakao" value="" /> <input
			type="hidden" id="nickname" name="nickname" value="" /> <input
			type="hidden" id="profile_image" name="profile_image" value="" />
	</form>

	<br>
	<form action="/testing/login" method="post">
		<div>
			<label for="user_id">Username:</label> <input type="text"
				id="user_id" name="user_id">
		</div>
		<div>
			<label for="user_pw">Password:</label> <input type="password"
				id="user_pw" name="user_pw">
		</div>
	
		<button type="submit">Login</button>


		<c:if test="${ not empty param.error}">
			<p style="color: red;">
				잘못된 아이디/비밀번호입니다.<br>다시 입력해주세요.
			</p>
		</c:if>
	</form>


</body>
</html>