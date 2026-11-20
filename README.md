# TP3 - Serveur multi-threads (sockets TCP)



## Activité 3-1
Le serveur accepte plusieurs clients grâce à un thread par client. Il affiche
l'adresse IP et le numéro d'ordre de chaque client et le renvoie au client.

Tests :
- Clients Telnet : ![client4.png](images/client4.png)
- Clients Java : ![client1.png](images/client1.png)
![client2.png](images/client2.png)
![client3.png](images/client3.png)
- Serveur : 
![serveur31.png](images/serveur31.png)

## Activité 3-2
Calculatrice avec échange d'objets (classe Operation sérialisable).
Un compteur global synchronisé compte les opérations de tous les clients.

Tests : ![client32.png](images/client32.png)![serveur32.png](images/serveur32.png)
![serveur32t.png](images/serveur32t.png)
## Synthèse
(3-4 sentences: server creates one thread per client; accept() in a loop;
synchronized avoids two threads modifying the counter at the same time;
telnet and Java clients both work; what you observed on the network test.)

## Lancer le projet
Lancer Serveur puis Client (java activite31.Client <ip du serveur>).