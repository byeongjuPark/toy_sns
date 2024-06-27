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
    <link rel="stylesheet" href="../css/edit_board.css">
    
    <script src="../js/edit_board.js"></script>
</head>
<body class="all">
    <H1>글 작성</H1>
    <%@ include file="./common/top_menu.jsp" %>
    <div class="edit_board-container">
        <form id="uploadForm" action="/board" method="POST" enctype="multipart/form-data" >
            <div class="edit_board-list-container">
                <div class="edit_board-list-input"><textarea type="text" name="content" id="content"></textarea></div>
            </div>
            <div id="image_container"></div>
            <div class="edit_board-complete">
                <div class="edit_board-complete-button">
                    <label for="file">
                        <div class="btn-upload">💾 사진첨부</div>
                    </label>
                    <input type="file" name="file" id="file" onchange="setThumbnail(event);">
                </div>
                <div class="edit_board-complete-button"><button class="button" id="completeBtn" type="button">✅ 작성완료</button></div>
            </div>
        </form>
    </div>
</body>
</html>