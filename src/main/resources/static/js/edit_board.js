

function handleClick() {
    alert("전송버튼 클릭");
    document.getElementById('uploadForm').submit();

}

// registerBtn 클릭 리스너
document.addEventListener('DOMContentLoaded', function () {
    var registerButton = document.getElementById('completeBtn');

    if (registerButton) {
        registerButton.addEventListener('click', handleClick);
    }
});


function setThumbnail(event) {
    for (var image of event.target.files) {
        var reader = new FileReader();

        reader.onload = function (event) {
            var span = document.createElement("span");
            var img = document.createElement("img");

            span.textContent = image.name;

            img.setAttribute("src", event.target.result);
            img.setAttribute("width", '30px');
            img.setAttribute("height", '30px');
            if (document.querySelector("div#image_container").firstElementChild !== null) {
                var deleteImg = document.querySelector("div#image_container img");
                var deleteSpan = document.querySelector("div#image_container span");
                document.querySelector("div#image_container").removeChild(deleteImg);
                document.querySelector("div#image_container").removeChild(deleteSpan);
            }

            document.querySelector("div#image_container").appendChild(img);
            document.querySelector("div#image_container").appendChild(span);
            // imageContainer.appendChild(img);
            // imageContainer.appendChild(span);

            $(".edit_board-container").css("height", "200px");
        };

        console.log(image);
        reader.readAsDataURL(image);
    }
}