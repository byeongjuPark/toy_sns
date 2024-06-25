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
    <link rel="stylesheet" href="../css/index.css">

    <script src="../js/index.js"></script>

</head>
<body>
    <%@ include file="./common/top_menu.jsp" %>
    <H1>Only login user can be accepted</H1>
    ${user} 님 환영합니다.

</body>
</html>