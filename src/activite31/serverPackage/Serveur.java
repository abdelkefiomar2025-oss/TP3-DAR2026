package activite31.serverPackage;

import activite31.clientPackage.ClientProcess;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) throws IOException {
        ServerSocket serveur = new ServerSocket(1234);
        System.out.println("Serveur lance sur le port 1234");
        int numero = 0;
        while (true) {
            Socket socket = serveur.accept();
            numero++;
            System.out.println("Client n" + numero + " connecte : " + socket.getRemoteSocketAddress());
            new ClientProcess(socket, numero).start();
        }
    }
}