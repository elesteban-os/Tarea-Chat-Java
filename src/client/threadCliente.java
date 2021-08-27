package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class threadCliente implements Runnable {

    private final DataInputStream reaad;

    public threadCliente(InputStream socketE) throws IOException {
        reaad = new DataInputStream(socketE);
    }

    @Override
    public void run(){
        try {
            while (true){
            String mensaje = reaad.readUTF();
            System.out.println(mensaje); 
            } 
            
        } catch (Exception e) {
            //TODO: handle exception
        }
            
        
        

    }

    

}
