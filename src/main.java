import ui.interfaza;
import client.Cliente;
import java.io.IOException;

public class main {

    public static void main(String[] args){

        interfaza usuario = new interfaza();

        try{
            Cliente cliente = new Cliente(usuario);
            cliente.start("localhost", 2121);
            usuario.setCliente(cliente);
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
        
        System.out.print("comit?");
        

    }
}
