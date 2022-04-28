if (sessionStorage.getItem('userID')==null){
    console.log("Il faut renvoyer la personne au login");
} else {
    console.log(sessionStorage.getItem('userID'));
}