package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private ServerSocket serverSocket;
    private final ArrayList<threadServidor> listaClientes;

    public Server() {
        listaClientes = new ArrayList<threadServidor>();
    }

    public void start(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
        System.out.println("<Server abierto en el puerto>" + puerto);

        while (true) {
            Socket socketCliente = serverSocket.accept();
            threadServidor threadServidor = new threadServidor(socketCliente, listaClientes);
            listaClientes.add(threadServidor);
            threadServidor.start();

            System.out.println("<Nuevo usuario conectado>");

        }

    }

    public void stop() throws IOException {
        serverSocket.close();
    }
    
    public static void main(String[] args){
        Server server = new Server();
        try {
            server.start(2121);
        } catch (IOException e) {
            System.out.println("<No se pudo hacer el servidor>");
        }
    }
}
