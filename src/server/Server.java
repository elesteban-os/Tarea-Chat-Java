package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Clase que inicializa el server y hace hilos para cada cliente que se intente introducir.
 */
public class Server {

    private ServerSocket serverSocket;
    private final ArrayList<threadServidor> listaClientes;

    /**
     * Función que crea la lista de clientes conectados, crea el socket del servidor y espera nuevos clientes para que
     * luego los pueda integrar en el hilo del servidor.
     * @param puerto Puerto del cliente que se conecta.
     * @throws IOException
     */

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
    
    /**
     * Método main que inicializa todo el servidor.
     * @param args
     */

    public static void main(String[] args){
        try {
            Server server = new Server(2121);
        } catch (IOException e) {
            System.out.println("<No se pudo hacer el servidor>");
        }
    }
}
