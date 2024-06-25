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
    <link rel="stylesheet" href="../css/register.css">
    
    <script src="../js/register.js"></script>
</head>
<body>
    <%@ include file="./common/top_menu.jsp" %>
    <H1>등록</H1>
    <div class="register-container">
        <div class="register-list-container">
            <div class="register-list-text">아이디</div>
            <div class="register-list-input"><input type="text" name="id" id="id"></div>
        </div>
        <div class="register-list-container">
            <div class="register-list-text">비밀번호</div>
            <div class="register-list-input"><input type="password" name="pw" id="pw"></div>
        </div>
        <div class="register-list-container">
            <div class="register-list-text">비밀번호 확인</div>
            <div class="register-list-input"><input type="password" name="cpw" id="cpw"></div>
        </div>
        <div class="register-list-container">
            <div class="register-list-text" id="cpw">성별</div>
            <div class="register-list-radio">
                <input type="radio" name="gener" id="checkMale" value="male"><div>남성</div>
                <input type="radio" name="gener" id="checkFemale" value="female"><div>여성</div>
            </div>
        </div>
        <div class="register-complete">
            <div class="register-complete-button"><button class="button" id="registerBtn" type="button">가입하기</button></div>
        </div>
    </div>
</body>
</html>