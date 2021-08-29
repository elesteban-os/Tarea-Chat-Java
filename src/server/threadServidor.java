package server;

import java.io.*;
import java.net.Socket;
import java.util.*;

import java.io.IOException;
import product.Product;

public class threadServidor extends Thread {

    private final Socket socket;
    private ArrayList<threadServidor> listaHilos;
    private DataInputStream input;
    private DataOutputStream output;

    public threadServidor(Socket socket, ArrayList<threadServidor> hilos){
        this.socket = socket;
        this.listaHilos = hilos;
    }

    private void init() throws IOException {
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());

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
                String msgBuffer = this.input.readUTF();

                Product prduct = bufferConverter(msgBuffer);

                prduct.setTotal(calculaTotal(prduct.getPrecio(),prduct.getImpuesto(),prduct.getPeso()));
                System.out.println("SEVIDOR: ");
                System.out.println("MSG: "+prduct.getString());

                String total = String.valueOf(prduct.getTotal());
                    
                for (threadServidor socketA : listaHilos){
                    socketA.output.writeUTF(total);;
                }
                
            
            }
            //kill();
        } catch (IOException e) {
            System.out.println("<Se desconectó el usuario>");
        }
    }
//
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


public double calculaTotal (int precioA, int impuestoA, int PesoA){
    //Calcula Precio
    double total = ((precioA * impuestoA) / 100) + (PesoA * 0.15);
    return total;
}


}