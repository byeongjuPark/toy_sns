$("#file").on('change',function(){
    var fileName = $("#file").val();
    $(".upload-name").val(fileName);
  });

function handleClick() {


}

// registerBtn 클릭 리스너
document.addEventListener('DOMContentLoaded', function () {
    var registerButton = document.getElementById('uploadImage');

    if (registerButton) {
        registerButton.addEventListener('click', handleClick);
    }
});
