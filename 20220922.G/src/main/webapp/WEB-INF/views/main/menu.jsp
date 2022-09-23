<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcomm to Gini♡</title>
<link rel="stylesheet" href="test.css/menu.css">
</head>
<body>

<nav id="topMenu">
		<ul>
		<!-- href="#" : 주소를 막아놓은 상태-->
			<li><a class="menuLink" href="memberInsert.yd">회원가입</a></li>
			<li><a class="menuLink" href="main.yd">홈</a></li>
			<li><a class="menuLink" href="memberSelectList.yd">회원목록</a></li>
			<li><a class="menuLink" href="#"></a>회원탈퇴</li>
			<li><a class="menuLink" href="#">정보수정</a></li>
			
			<!-- test="" : 조건식이 들어간다 -->
			<c:choose>
				<c:when test="${empty id}">
					<li><a class="menuLink" href="memberLoginForm.yd">로그인</a></li>
				</c:when>
				<c:otherwise>
					<li><a class="menuLink" href="memberLogout.yd">로그아웃</a></li>
					<li>${name}님 환영합니다~!!</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>

</body>
</html>