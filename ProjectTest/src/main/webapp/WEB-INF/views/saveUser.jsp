<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.sh.saveUser.UserDTO"%>
<%@ page import="com.sh.address.AddressDTO"%>
<%@ page import="com.acorn.testing.KakaoUserDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function findAddr() {
		new daum.Postcode({
			oncomplete : function(data) {
				console.log(data);
				var roadAddr = data.roadAddress;
				var jibunAddr = data.jibunAddress;
				document.getElementById('member_post').value = data.zonecode;
				if (roadAddr !== '') {
					document.getElementById("member_addr").value = roadAddr;
				} else if (jibunAddr !== '') {
					document.getElementById("member_addr").value = jibunAddr;
				}
			}
		}).open();
	}
</script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
    $(document).ready(function () {
        let isPasswordShown = false;

        $("#showPasswordCheckbox").on("change", function () {
            isPasswordShown = !isPasswordShown;
            if (isPasswordShown) {
                $("input[type='password']").attr("type", "text");
            } else {
                $("input[type='password']").attr("type", "password");
            }
        });

        $("#validatePassword").on("click", function () {
            let pass1 = $("#user_pw").val();
            let pass2 = $("#user_pw_confirm").val();

            if (pass1 !== "" || pass2 !== "") {
                if (
                    pass1.length >= 8 &&
                    /[a-z]/.test(pass1) &&
                    /[0-9]/.test(pass1) &&
                    /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/.test(pass1) &&
                    /^\S*$/.test(pass1)
                ) {
                    if (pass1 === pass2) {
                        $("#checkPw").html("비밀번호가 일치합니다.");
                        $("#checkPw").css("color", "green");
                    } else {
                        let message = "비밀번호가 일치하지 않습니다.";
                        $("#checkPw").html(message);
                        $("#checkPw").css("color", "red");
                        alert(message);
                    }
                } else {
                    let message = "비밀번호는 영어, 숫자, 특수문자를 포함해 총 8글자 이상이어야 합니다. 단, 공백은 안됩니다.";
                    $("#checkPw").html(message);
                    $("#checkPw").css("color", "red");
                }
            }
        });
    });
    </script>
	
	
	
<style>
#member_post {
	width: 400px;
}

#member_addr {
	width: 400px;
}
</style>
</head>
<body>


	<form id="myForm12" method="post" action="/testing/myForm12">
        <input type="hidden" id="user_kakao" name="user_kakao" value="${user_kakao}">
        
        <label for="user_id">아이디:</label>
        <input type="text" id="user_id" name="user_id" value="아이디"><br>
        
        <label for="user_pw">비밀번호:</label>
        <input type="password" id="user_pw" name="user_pw" value=""><br>
        <label for="user_pw_confirm">비밀번호 재확인:</label>
        <input type="password" id="user_pw_confirm" name="user_pw_confirm" value=""><br>
        <div id="checkPw"></div><br>
        <input type="checkbox" id="showPasswordCheckbox">
        <label for="showPasswordCheckbox">비밀번호 보기</label><br>


        
        <label for="address">이메일:</label>
        <input type="text" id="address" name="address" value="이메일">
        
        <label for="phone_num">폰번호:</label>
        <input type="text" id="phone_num" name="phone_num" value="폰번호"><br>
        <input id="member_post" name="member_post" type="text" placeholder="Zip Code" readonly>
        <input id="member_addr" name="member_addr" type="text" placeholder="Address" readonly><br>
        <label for="detailed_address">상세 주소:</label>
        <input id="detailed_address" name="detailed_address" type="text" placeholder="Detailed Address"><br>
        <button type="button" onclick="findAddr()">주소찾기</button><br>
        
        <label for="user_birth">생일:</label>
        <input type="text" id="user_birth" name="user_birth" value="생일"><br>
        
        <label for="user_nickname">닉네임:</label>
        <input type="text" id="user_nickname" name="user_nickname" value="${nickname}"><br>
        
        <label for="user_image">사용자 이미지:</label>
        <input type="text" id="user_image" name="user_image" value="${profile_image}"><br>
        
        <label for="user_heat" ></label>
        <input type="hidden" id="user_heat" name="user_heat" value="평점"><br>
        <button type="submit" form="myForm12">제출하기</button>
    </form>
<!-- 
	<div>Address</div>
	<form id="addressForm" method="post" action="/testing/addressForm">
	</form>

 -->
</body>
</html>