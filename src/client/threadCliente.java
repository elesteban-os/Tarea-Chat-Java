package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class threadCliente implements Runnable {

    private final BufferedReader input;

    public threadCliente(InputStream socketE) throws IOException {
        input = new BufferedReader(new InputStreamReader(socketE));
    }

    @Override
    public void run(){
        try {
            while (true) {
                String mensaje = input.readLine();
                if (mensaje.equalsIgnoreCase("EXIT")) {
                    break;
                }
                System.out.println(mensaje);
                System.out.println(">> ");
            }
            } catch (IOException e) {
                System.out.println("Caido desde thread Cliente");
            } finally {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("Caido desde thread Cliente 2");
                }
        }
    }

}
