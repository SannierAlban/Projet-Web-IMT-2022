function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
};

function checkUser(){
    pseudo = document.getElementById("pseudo-login");
    mdp = document.getElementById("mdp-login");
    console.log(pseudo.value+mdp.value);
    if (pseudo.value=="b" && mdp.value=="5") {
        showMessage(1);
    } else {
        showMessage(0);
    }
}

function checkUser1(){
    var xhr = new XMLHttpRequest(),
    method = "GET";
    var url = "user_name="+pseudo.value+"&user_password="+mdp.value;  
    xhr.open(method, url, true);
    xhr.setRequestHeader("Accept", "application/json; charset=UTF-8");
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200) {
            var responseUser = xhr.responseText;
        }
    };
    xhr.send();
}

async function showMessage(type){
    let messageToReturn;
    if (type == 0) {
        var title = "Login mot de passe incorrect";
        document.getElementById("message-login-box").innerHTML = title;
    } else if (type == 1) {
        var title = "Connexion réussi ...";
        sessionStorage.setItem('userID','4');
        document.getElementById("message-login-box").innerHTML = title;
        await sleep(1000);
        window.location.href = "menu/index.html"; 
    }

}