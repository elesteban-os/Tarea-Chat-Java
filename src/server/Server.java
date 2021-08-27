package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private ServerSocket serverSocket;
    private final ArrayList<threadServidor> listaClientes;

    public Server(int puerto) throws IOException {
        listaClientes = new ArrayList<threadServidor>();

        serverSocket = new ServerSocket(puerto);
        System.out.println("<Server abierto en el puerto>" + puerto);

        while (true) {
            Socket socketCliente = serverSocket.accept();
            threadServidor threServer = new threadServidor(socketCliente, listaClientes);
            listaClientes.add(threServer);
            threServer.start();

            System.out.println("<Nuevo usuario conectado>");

        }
        
    }

    public void stop() throws IOException {
        serverSocket.close();
    }
    
    public static void main(String[] args){
        try {
            Server server = new Server(2121);
        } catch (IOException e) {
            System.out.println("<No se pudo hacer el servidor>");
        }
    }
}
