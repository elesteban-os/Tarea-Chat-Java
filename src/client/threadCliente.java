package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import ui.interfaza;

/**
 * Clase que queda dispuesta a recibir peticiones de el servidor y mostrarlos en la interfaz gráfica.
 * @author: Kevin Esteba Chinchilla Rodríguez.
 * @version: 1.0
 */

public class threadCliente implements Runnable {

    private final DataInputStream reaad;
    private interfaza interfazA;

    /**
     * Contructor que implementa los atributos del DataInputStream y de la interfaz.
     * @param socketE Recibe el las escrituras desde otros clientes.
     * @param interfaz Recibe la interfaz de un solo cliente.
     * @throws IOException
     */

    public threadCliente(InputStream socketE, interfaza interfaz) throws IOException {
        reaad = new DataInputStream(socketE);
        this.interfazA = interfaz;
    }

    /**
     * Función que queda a la espera de nuevos mensajes de otros clientes para luego mostrarlo en la interfaz del
     * cliente principal.
     */

    public void run(){
        try {
            while (true){
            String mensaje = reaad.readUTF();
            this.interfazA.cambiarTotal(mensaje);
            } 
            
        } catch (Exception e) {
            
        }

    }

}
