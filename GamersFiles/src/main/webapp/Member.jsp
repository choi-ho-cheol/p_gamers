<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 및 회원가입 페이지</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
	border: none;
	text-align: center;
}

body {
	font-size: 14px;
	font-family: 'Roboto', sans-serif;
}

.login-wrapper {
	display: inline-block;
	width: 400px;
	height: 350px;
	padding: 40px;
	box-sizing: border-box;
	width: 400px;
}

.login-wrapper>h2 {
	font-size: 24px;
	color: #6A24FE;
	margin-bottom: 20px;
}

#login-form>input {
	width: 100%;
	height: 48px;
	padding: 0 10px;
	box-sizing: border-box;
	margin-bottom: 16px;
	border-radius: 6px;
	background-color: #F8F8F8;
}

#login-form>input::placeholder {
	color: #D2D2D2;
}

#login-form>input[type="submit"] {
	color: #fff;
	font-size: 16px;
	background-color: #6A24FE;
	margin-top: 20px;
}

#login-form>input[type="checkbox"] {
	display: none;
}

#login-form>label {
	color: #999999;
}

#login-form input[type="checkbox"]+label {
	cursor: pointer;
	padding-left: 26px;
	background-image: url("checkbox.png");
	background-repeat: no-repeat;
	background-size: contain;
}

#login-form input[type="checkbox"]:checked+label {
	background-image: url("checkbox-active.png");
	background-repeat: no-repeat;
	background-size: contain;
}

.join-wrapper {
	display: inline-block;
	width: 400px;
	height: 350px;
	padding: 40px;
	box-sizing: border-box;
	width: 400px;
}

.join-wrapper>h2 {
	font-size: 24px;
	color: #6A24FE;
	margin-bottom: 20px;
}

#join-form>input {
	width: 100%;
	height: 48px;
	padding: 0 10px;
	box-sizing: border-box;
	margin-bottom: 16px;
	border-radius: 6px;
	background-color: #F8F8F8;
}

#join-form>input::placeholder {
	color: #D2D2D2;
}

#join-form>input[type="submit"] {
	color: #fff;
	font-size: 16px;
	background-color: #6A24FE;
	margin-top: 20px;
}

#join-form>input[type="checkbox"] {
	display: none;
}

#join-form>label {
	color: #999999;
}

#join-form input[type="checkbox"]+label {
	cursor: pointer;
	padding-left: 26px;
	background-image: url("checkbox.png");
	background-repeat: no-repeat;
	background-size: contain;
}

#join-form input[type="checkbox"]:checked+label {
	background-image: url("checkbox-active.png");
	background-repeat: no-repeat;
	background-size: contain;
}
</style>
</head>
<body>
	<div class="member_container">
		<div class="main_top">
			<div class="login-wrapper">
				<h2>로그인</h2>
				<form method="post" action="LoginService.do" id="login-form">
					<input type="text" name="login_email" placeholder="이메일"> <input
						type="password" name="login_pw" placeholder="비밀번호"> <input
						type="submit" value="로그인">
				</form>
			</div>
		</div>
		<div class="member_bottom">
			<div class="join-wrapper">
				<h2>회원가입</h2>
				<form method="post" action="JoinService.do" id="join-form">
					<input type="text" name="join_email" placeholder="이메일">
					<input type="password" name="join_pw" placeholder="비밀번호">
					<input type="text" name="join_nick" placeholder="닉네임">
					<input type="text" list="positions" name="join_position" placeholder="역할">
						<datalist id="positions">
							<option value="탱커"></option>
							<option value="딜러"></option>
							<option value="힐러"></option>
						</datalist>
					<input type="text" list="classes" name="join_class" placeholder="직업">
					<input type="submit" value="회원가입">
				</form>
			</div>
		</div>
	</div>
</body>
</html>