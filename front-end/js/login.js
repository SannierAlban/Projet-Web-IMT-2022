function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
};

function checkRegister(){
    pseudo = document.getElementById("pseudo-login");
    mdp = document.getElementById("mdp-login");
    console.log(pseudo.value+mdp.value);
    //Link to RegisterUser();
}

function RegisterUser(){
    var xhr = new XMLHttpRequest(),
    method = "GET";
    var url = "/user/register/userName="+pseudo.value+"&userPassword="+mdp.value;  
    xhr.open(method, url, true);
    xhr.setRequestHeader("Accept", "application/json; charset=UTF-8");
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200) {
            showMessage(2);
        } else {
            showMessage(3);
        }
    };
    xhr.send();
}


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

function checkUserExist(){
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
        
        document.getElementById("message-login-box").innerHTML = "Login mot de passe incorrect";
    } else if (type == 1) {
        sessionStorage.setItem('userID','4');
        document.getElementById("message-login-box").innerHTML = "Connexion réussi ...";
        await sleep(1000);
        window.location.href = "menu/index.html"; 
    } else if (type == 2) {
        document.getElementById("message-login-box").innerHTML = "Enregistrement réussi";
        await sleep(3000);
        document.getElementById("message-login-box").innerHTML = "";
    } else if (type == 3) {
        document.getElementById("message-login-box").innerHTML = "Enregistrement fail";
    }

}