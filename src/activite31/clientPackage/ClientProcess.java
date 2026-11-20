package activite31.clientPackage;

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
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Bienvenue, vous etes le client n" + numero);
            String ligne;
            while ((ligne = in.readLine()) != null) {
                if (ligne.equals("quit")) break;
                out.println("Client n" + numero + " a dit : " + ligne);
            }
            socket.close();
            System.out.println("Client n" + numero + " deconnecte");
        } catch (IOException e) {
            System.out.println("Erreur avec le client n" + numero);
        }
    }
}