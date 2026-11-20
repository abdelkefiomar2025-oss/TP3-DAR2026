package activite31.clientPackage;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String adresse = args.length > 0 ? args[0] : "localhost";
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(InetAddress.getByName(adresse), 1234));

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        System.out.println(in.readLine());

        Scanner clavier = new Scanner(System.in);
        while (true) {
            String texte = clavier.nextLine();
            out.println(texte);
            if (texte.equals("quit")) break;
            System.out.println(in.readLine());
        }
        socket.close();
    }
}