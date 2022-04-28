function getRandomInt(max) {
    return Math.floor(Math.random() * max);
}

const allIAs = [["1","1simplePlayer.py"],["2","2simplePlayer.py"],["3","3simplePlayer.py"],["4","4simplePlayer.py"],["5","5simplePlayer.py"]];
// Au dessus ça simule le fait que je récup les ia du endpoint

function getIas(){
    var xhr = new XMLHttpRequest(),
    method = "GET";
    var url = "/server/getIas"; 
    xhr.open(method, url, true);
    xhr.setRequestHeader("Accept", "application/json; charset=UTF-8");
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200) {
            ResponseIA = xhr.responseText;
            TranformIAs(ResponseIA);
        } else {
            console.log("nope");
        }
    };
    xhr.send();
}
/* getIas(); */

function TransformIA(){

}


//insert into right choice
var containerLeft = document.getElementById("container-left");
for (let i = 0; i < allIAs.length; i++) {
    divIA = document.createElement('div');
    divIA.setAttribute("id", "ia");
    for (let y = 1; y < allIAs[i].length; y++) {
        inputIA = document.createElement('input');
        inputIA.setAttribute("type","radio");
        inputIA.setAttribute("name","ia1");
        inputIA.setAttribute("id","radioIA");
        inputIA.setAttribute("value",allIAs[i][1]);
        divIA.appendChild(inputIA);
        labelIA = document.createElement('label');
        labelIA.setAttribute("for","radioIA");
        labelIA.innerHTML = allIAs[i][y];
        divIA.appendChild(labelIA);
    }   
    containerLeft.appendChild(divIA);
}

//insert into right choice
var containerRight = document.getElementById("container-right");
for (let i = 0; i < allIAs.length; i++) {
    divIA = document.createElement('div');
    divIA.setAttribute("id", "ia");
    for (let y = 1; y < allIAs[i].length; y++) {
        inputIA = document.createElement('input');
        inputIA.setAttribute("type","radio");
        inputIA.setAttribute("name","ia2");
        inputIA.setAttribute("id","radioIA");
        inputIA.setAttribute("value",allIAs[i][1]);
        divIA.appendChild(inputIA);
        labelIA = document.createElement('label');
        labelIA.setAttribute("for","radioIA");
        labelIA.innerHTML = allIAs[i][y];
        divIA.appendChild(labelIA);
    }   
    containerRight.appendChild(divIA);
}

var fightButton = document.getElementById("fightButton");
fightButton.addEventListener("click", checkBeforeFight);
function checkBeforeFight() {
    player1 = document.querySelector('input[name="ia1"]:checked');
    player2 = document.querySelector('input[name="ia2"]:checked');
    nbrCombat = document.getElementById("nbrCombat");
    if (player1==null || player2==null || nbrCombat.value=="") {
        console.log('do nothing');
    } else {
        displayResults(player1.value,player2.value,nbrCombat.value);
    }
}

function displayResults(p1,p2,nbrC) {
    players = [p1,"Vainqueur",p2]
    scorep1 = getRandomInt(nbrC);
    scorep2 = nbrC-scorep1;
    if (scorep1>scorep2){
        winner = p1;
    }  else if (scorep1<scorep2){
        winner = p2;
    } else {
        winner = "Égalité"
    }
    scores= [scorep1,winner,scorep2];
    divResult = document.getElementById("wrapper-results");
    while(divResult.firstChild){
        divResult.removeChild(divResult.firstChild);
    }
    h1Result = document.createElement('h1');
    h1Result.innerHTML = "Résultats";
    divResult.appendChild(h1Result);
    containerResults = document.createElement('div');
    containerResults.setAttribute("class","container-results");
    divResult.appendChild(containerResults);
    for (let i = 0; i <players.length; i++) {
        containerInfo = document.createElement('div');
        containerInfo.setAttribute("class","container-result-info");
        h1Info = document.createElement('h1');
        h1Info.innerHTML = players[i];
        pInfo = document.createElement('p');
        pInfo.innerHTML = scores[i];
        containerInfo.appendChild(h1Info);
        containerInfo.appendChild(pInfo);
        containerResults.appendChild(containerInfo);
    }
    divResult.appendChild(containerResults);
}