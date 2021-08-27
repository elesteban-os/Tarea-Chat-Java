package server;

import java.io.*;
import java.net.Socket;
import java.util.*;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import product.*;
public class threadServidor extends Thread {

    private Socket socket;
    private ArrayList<threadServidor> listaHilos;
    private PrintWriter output;
    private BufferedReader input;
    private DataInputStream sendMessageDIS;

    public threadServidor(Socket socket, ArrayList<threadServidor> hilos){
        this.socket = socket;
        this.listaHilos = hilos;
    }

    private void init() throws IOException {
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);
        sendMessageDIS = new DataInputStream(socket.getInputStream());
    }

    private void notificarTodosClientes(String msg) {
        if (msg.equalsIgnoreCase("EXIT")) {
            this.output.println("EXIT");
        } else {
            for (threadServidor socket : listaHilos) {
                if (!socket.equals(this))
                socket.output.println("[Desde otro usuario]: " + msg);
            }
        }
    }

    private void kill() throws IOException {
        input.close();
        output.close();
        socket.close();
    }


    @Override
    public void run() {
        try {
            init();
            while (true) {
                //String msg = input.readLine();
                //if (msg.equalsIgnoreCase("EXIT")) {
                //    break;
                //}
                //Logica
                //System.out.println("log: "+msg); // Imprime texto desde cliente
                //this.output.println("uyyy" + msg); // Manda el texto hacia cliente
                //notificarTodosClientes(msg); // Notifica a los demás clientes conectador y reinicia

                String msgBuffer= this.sendMessageDIS.readUTF();

                Product prduct = bufferConverter(msgBuffer);

                prduct.setTotal(calculaTotal(prduct.getPrecio(),prduct.getImpuesto(),prduct.getPeso()));
                System.out.println("SEVIDOR: ");
                System.out.println("MSG: "+prduct.getString());

                //sendMessageDIS.close();
            }
            //kill();
        } catch (IOException e) {
            System.out.println("<Se desconectó el usuario>");
        }
    }
//procesa el mensaje a una lista y transforma a un objeto producto
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


public int calculaTotal (int precioA, int imuestoA, int PesoA){
    //Calcula Precio
    int total = 0;
    return total;
}


}