package activite32.clientPackage;

import activite32.commonPackage.Operation;
import activite32.serverPackage.Serveur;

import java.io.*;
import java.net.Socket;

public class ClientProcess extends Thread {
    private Socket socket;
    private int numero;

    public ClientProcess(Socket socket, int numero) {
        this.socket = socket;
        this.numero = numero;
    }

    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            while (true) {
                Operation op = (Operation) in.readObject();
                Object reponse;
                switch (op.getOperateur()) {
                    case '+': reponse = op.getA() + op.getB(); break;
                    case '-': reponse = op.getA() - op.getB(); break;
                    case '*': reponse = op.getA() * op.getB(); break;
                    case '/':
                        if (op.getB() == 0) reponse = "Erreur : division par zero";
                        else reponse = op.getA() / op.getB();
                        break;
                    default: reponse = "Erreur : operateur inconnu";
                }
                int total = Serveur.incrementer();
                System.out.println("Client n" + numero + " -> operation n" + total);
                out.writeObject(reponse);
                out.flush();
            }
        } catch (EOFException e) {
            System.out.println("Client n" + numero + " deconnecte");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur client n" + numero);
        }
    }
}