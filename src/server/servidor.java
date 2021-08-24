package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class servidor {

    public static void main(String args[]){
        ServerSocket server = null;
        Socket sc = null;

        DataInputStream in;
        DataOutputStream out;

        final int puerto = 12000;

        try {
            server = new ServerSocket(puerto);

            System.out.print("Server xd");

            while(true){
                
                sc = server.accept();
                System.out.println("Conectado");

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String mensaje = in.readUTF();

                System.out.print(mensaje);

                out.writeUTF("Holaaa");

                sc.close();
                System.out.println("Desconectado");


            }


        } catch (IOException ex) {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
