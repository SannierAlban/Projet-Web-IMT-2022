# Projet-Web-IMT-2022

```
https://bitbucket.org/imt-mobisyst/hackagames/src/master/
```

Enregistrement d’un utilisateur
Get : http://localhost:8080/user/register ( {“userName”:”oui,userPassword”:”non} )
```
{“userId”:1,“userName”:”oui”,”userPassword”:”non}
```

Lancement d’une partie IA vs IA.
Get : http://localhost:8080/user/server/confront
```
{"Id":14,"ia1":0,"totalWinIa1":6,"ia2":8,"totalWinIa2":1,”date”:”2022-04-28T08:53:54.611+88:33”}
```

Obtenir l’historique des parties
Get : http://localhost:8080/user/server/getHistory
```
[{"Id":14,"ia1":0,"totalWinIa1":6,"ia2":8,"totalWinIa2":1,”date”:”2022-04-28T08:53:54.611+88:33”},
{"Id":15,"ia1":1,"totalWinIa1":2,"ia2":2,"totalWinIa2":5,”date”:”2022-04-29T09:23:74.511+87:33”}]
```

Obtenir les informations de connexion d’un joueur
Get : http://localhost:8080/user/authentification
```
{“userId”:1,“userName”:”oui”,”userPassword”:”non}
```

Obtenir les informations d’un utilisateur
Get : http://localhost:8080/user/
```
{“userId”:1,“userName”:”oui”,”userPassword”:”non}
```

Obtenir les informations d’une IA
Get : http://localhost:8080/server/getIas
```
[{“id”:1,“name”:”oui”,”path”:”,”C:\\Users\\Desktop\\ProjetWebIMT\\hackagames\\games-risky\\simpleplayer.py},{“id”:1,“name”:”oui”,”path”:”,”C:\\Users\\Desktop\\ProjetWebIMT\\hackagames\\games-risky\\simpleplayer2.py}]
```

Création d'un endpoint pour récupérer l'id d'un utilisateur en fonction de son pseudo et de son mot de passe. Elle fera office de connexion ( pour récupérer l'id et effectuer les actions suivantes)
http://localhost:8080/user/authentication?user_name=Alban&user_password=P@$$w0rd
```
{"userId":0,"userName":"Alban","userPassword":"P@$$w0rd"}
```
