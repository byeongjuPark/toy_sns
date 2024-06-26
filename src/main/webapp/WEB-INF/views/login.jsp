<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <link rel="stylesheet" href="../css/component.css">
    <link rel="stylesheet" href="../css/login.css">
    
    <script src="../js/login.js"></script>
</head>
<body>
    <%@ include file="./common/top_menu.jsp" %>
    <H1>로그인</H1>
    <div class="register-container">
        <div class="register-list-container">
            <div class="register-list-text">아이디</div>
            <div class="register-list-input"><input type="text" name="id" id="id"></div>
        </div>
        <div class="register-list-container">
            <div class="register-list-text">비밀번호</div>
            <div class="register-list-input"><input type="password" name="pw" id="pw"></div>
        </div>
        <div class="register-complete">
            <div class="register-complete-button"><button class="button" id="loginBtn" type="button">로그인</button></div>
        </div>
    </div>
</body>
</html>