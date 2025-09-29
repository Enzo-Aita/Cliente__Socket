package principal;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import java.util.Scanner;

public class Principal {

    public static void main(String args[]) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Digite o IP do servidor: ");
            String ip = sc.nextLine();

            System.out.print("Digite a porta do servidor: ");
            int porta = sc.nextInt();
            sc.nextLine(); 

            Socket servidor = new Socket(ip, porta);
            PrintWriter out = new PrintWriter(servidor.getOutputStream(), true);

            String mensagem = "";
            while (!mensagem.equalsIgnoreCase("fim")) {
                System.out.print("Digite a mensagem (ou 'fim' para sair): ");
                mensagem = sc.nextLine();
                out.println(mensagem);
            }

            servidor.close();
        } catch (IOException io) {
            System.err.println("Problemas de IO: " + io.getMessage());
        }
    }
}


