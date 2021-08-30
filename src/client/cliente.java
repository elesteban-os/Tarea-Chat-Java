package client;
import java.net.Socket;
import java.io.*;
import product.*;
import ui.interfaza;

/**
 * Clase que se conecta al servidor y envía mensajes.
 * @author: Kevin Esteban Chinchilla Rodríguez
 * @versión: 1.0
 */

public class Cliente {

    private Socket socket;
    private DataOutputStream sendMessageDOS;
    threadCliente clienteCorrer;
    private interfaza interfaz;

    /**
    * Constructor que integra la interfaz en el cliente.
    * @param interfaaz Recibe una interfaz para que se pueda controlar desde cliente.
    */

    public Cliente(interfaza interfaaz){
        this.interfaz = interfaaz;
    }

    /**
     * Función que inicializa el socket y abre las fuentes de entrada y salida de mensajes.
     * @param ip Recibe la dirección IP del cliente.
     * @param port Recibe el puerto del cliente.
     * @throws IOException 
     */

    public void init(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        this.sendMessageDOS = new DataOutputStream(this.socket.getOutputStream());
    } 

    /**
     * Función que realiza la inicialización del cliente y hace un hilo de ejecución para la recibida de mensajes.
     * @param ip Direción IP del cliente.
     * @param port Puerto del cliente.
     * @throws IOException
     */

    public void start(String ip, int port) throws IOException {
        init(ip, port);
        clienteCorrer = new threadCliente(socket.getInputStream(), this.interfaz);
        new Thread(clienteCorrer).start();
    }

    /**
     * Función que envía un mensaje al servidor.
     * @param product Recibe características de un producto.
     */
        
    public void sendMessage(Product product){
        try{
        this.sendMessageDOS.writeUTF(product.getStringTockenProduct());
        this.sendMessageDOS.flush();

        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }        
    }
}