function handleClick() {
    var id = document.getElementById('id').value;
    var pw = document.getElementById('pw').value;

    if (id == "" || pw == "") {
        alert("빈칸을 확인해주세요.");
        return;
    }

    alert("로그인 검사 로직 성공");
    // 통신부

    $.ajax({
        url: "/api/login",
        type: "POST",
        data: {
            "id": id,
            "pw": pw,
        },
        success: function(result) {
            $("#message").text(result);
            alert("ss");
        }
    });

}

// registerBtn 클릭 리스너
document.addEventListener('DOMContentLoaded', function () {
    var registerButton = document.getElementById('loginBtn');

    if (registerButton) {
        registerButton.addEventListener('click', handleClick);
    }
});

// id 입력 영문만 허용
document.addEventListener('DOMContentLoaded', function() {
    var idInput = document.getElementById('id');

    idInput.addEventListener('input', function() {
        var currentValue = idInput.value;
        var pattern = /^[a-zA-Z0-9]*$/;
        if (!pattern.test(currentValue)) {
            idInput.value = currentValue.replace(/[^a-zA-Z0-9]/g, '');
        }
    });
});

