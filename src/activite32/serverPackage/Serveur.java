package activite32.serverPackage;

import activite32.clientPackage.ClientProcess;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    private static int compteur = 0;

    public static synchronized int incrementer() {
        compteur++;
        return compteur;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serveur = new ServerSocket(1234);
        System.out.println("Calculatrice lancee sur le port 1234");
        int numero = 0;
        while (true) {
            Socket socket = serveur.accept();
            numero++;
            System.out.println("Client n" + numero + " : " + socket.getRemoteSocketAddress());
            new ClientProcess(socket, numero).start();
        }
    }
}