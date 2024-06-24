function handleClick() {
    var id = document.getElementById('id').value;
    
    var pw = document.getElementById('pw').value;
    var cpw = document.getElementById('cpw').value;
    var gener = document.getElementsByName('gener');
    var generSelectedValue = '';
    var check = false;
    
    for (var i = 0; i < gener.length; i++) {
        if (gener[i].checked) {
            generSelectedValue = gener[i].value;
            break;
        }
    }
    
    if (id == "" || pw == "" || cpw == "" || generSelectedValue == "") {
        alert("빈칸을 확인해주세요.");
        return;
    }
    
    if (id.length < 5) {
        alert("아이디가 너무 짧아요.");
        return;
    }
    
    if (pw != cpw || pw == "" || cpw == "") {
        alert("비밀번호를 확인해주세요.");
        return;
    }
    if (pw.length < 8) {
        alert("비밀번호가 너무 짧아요.");
        return;
    }
    
    alert("회원가입 검사 로직 성공");
    check = true;
    // 통신부

    // 아이디 중복 검삭 로직
    if(check){
        $.ajax({
            url: "/api/duplicateCheck",
            type: "POST",
            data: {
                "id": id,
                "pw": pw,
            },
            success: function(res) {
                if(res.code === "fa"){
                    alert("중복되는 아이디입니다.");
                } else {
                    $.ajax({
                        url: "/api/register",
                        type: "POST",
                        data: {
                            "id": id,
                            "pw": pw,
                            "gener" : gener,
                        },
                        success: function(res) {
                            console.log(res);
                            //alert(res.code);
                        }
                    });
                }
            }
        });
    }

    
    
    



}

// registerBtn 클릭 리스너
document.addEventListener('DOMContentLoaded', function () {
    var registerButton = document.getElementById('registerBtn');

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

