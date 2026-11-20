package activite32.clientPackage;

import activite32.commonPackage.Operation;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String adresse = args.length > 0 ? args[0] : "localhost";
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(adresse, 1234));

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.flush();
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        Scanner clavier = new Scanner(System.in);
        while (true) {
            System.out.print("Premier nombre (q pour quitter) : ");
            String saisie = clavier.next();
            if (saisie.equals("q")) break;
            double a = Double.parseDouble(saisie);
            System.out.print("Operateur (+ - * /) : ");
            char op = clavier.next().charAt(0);
            System.out.print("Deuxieme nombre : ");
            double b = clavier.nextDouble();

            out.writeObject(new Operation(a, op, b));
            out.flush();
            System.out.println("Resultat : " + in.readObject());
        }
        socket.close();
    }
}