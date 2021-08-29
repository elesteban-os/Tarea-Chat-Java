package client;
//
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ui.interfaza;


public class threadCliente implements Runnable {

    private final DataInputStream reaad;
    private String total;
    private interfaza interfazA;

    public threadCliente(InputStream socketE, interfaza interfaz) throws IOException {
        reaad = new DataInputStream(socketE);
        this.interfazA = interfaz;

    }

    @Override
    public void run(){
        try {
            while (true){
            String mensaje = reaad.readUTF();
            this.interfazA.cambiarTotal(mensaje);
            System.out.println(mensaje); 
            this.total = mensaje;
            } 
            
        } catch (Exception e) {
            //TODO: handle exception
        }

    }

}
