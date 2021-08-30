package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import java.io.IOException;
import product.Product;

/**
 * Clase que realiza el servidor para el chat, proceda el texto recibido desde los productos, crea entradas y 
   salidas de escritura para los sockets y realiza el cálculo de los precios de los productos.
 * @author: Kevin Esteban Chinchilla Rodríguez
 * @version: 1.0
 */

public class threadServidor extends Thread {

    private final Socket socket;
    private ArrayList<threadServidor> listaHilos;
    private DataInputStream input;
    private DataOutputStream output;

    /**
     * Constructor que recibe los nuevos clientes y los inicializa.
     * @param socket Socket del nuevo cliente-
     * @param hilos Hilo dónde se encuentan los demás clientes conectados.
     */

    public threadServidor(Socket socket, ArrayList<threadServidor> hilos){
        this.socket = socket;
        this.listaHilos = hilos;
    }

    /**
     * Función que inicializa las fuentes de lectura y escritura del servidor.
     * @throws IOException
     */

    private void init() throws IOException {
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());

    }

    /**
     * Función que espera a nuevas escrituras de algún cliente para luego procesar el texto
     * recibido y mostrar el texto para todos los clientes conectados.
     */

    @Override
    public void run() {
        try {
            init();
            while (true) {
                String msgBuffer = this.input.readUTF();
                Product prduct = bufferConverter(msgBuffer);
                prduct.setTotal(calculaTotal(prduct.getPrecio(),prduct.getImpuesto(),prduct.getPeso()));
                System.out.println("Mensaje de un cliente: "+prduct.getString());
                String total = String.valueOf(prduct.getTotal());
                    
                for (threadServidor socketA : listaHilos){
                    socketA.output.writeUTF(total);;
                }
            }
        } catch (IOException e) {
            System.out.println("<Se desconectó el usuario>");
        }
    }
    
    /**
     * Función que procesa el texto desde el producto realizado, lo convierte en números enteros y lo procesa en
     * un nuevo producto.
     * @param msg Mensaje recibido.
     * @return Retorna el producto realizado desde el mensaje recibido.
     */
    public Product bufferConverter (String msg){
        
        StringTokenizer stringTokens = new StringTokenizer(msg,"-");
        Product product = new Product();
        ArrayList<String> objProduct = new ArrayList<String> ();
        
        while(stringTokens.hasMoreTokens()){
            objProduct.add(stringTokens.nextToken());
        }

        product.setPrecio(Integer.parseInt(objProduct.get(0)));
        product.setPeso(Integer.parseInt(objProduct.get(1)));
        product.setImpuesto(Integer.parseInt(objProduct.get(2)));

        return product;
    }

    /**
     * Función que calcula el total de un producto.
     * @param precio Precio deel producto.
     * @param impuesto Impuestos del producto.
     * @param Peso Peso del producto.
     * @return Retorna el total del cálculo.
     */

    public double calculaTotal (int precio, int impuesto, int Peso){
        double total = ((precio * impuesto) / 100) + (Peso * 0.15);
        return total;
    }


}