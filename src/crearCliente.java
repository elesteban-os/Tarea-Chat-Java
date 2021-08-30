import ui.interfaza;
import client.Cliente;
import server.Server;

import java.io.IOException;

/** 
 * Clase que hace una llamada de las demás funciones.
 * @author Kevin Esteban Chinchilla Rodríguez.
 * @version 1.0
 * @since 1.0
 */

public class crearCliente {

    /**
     * Función que inicializa la interfaaz y el cliente y se implementan entre ellos.
     * @param args
     */

    public static void main(String[] args){

        interfaza usuario = new interfaza();

        try{
            Cliente cliente = new Cliente(usuario);
            cliente.start("localhost", 2121);
            usuario.setCliente(cliente);
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
             

    }
}
