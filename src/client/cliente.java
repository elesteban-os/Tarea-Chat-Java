package client;

import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import java.io.*;
import java.io.BufferedReader;

import ui.interfaza;

import product.*;
public class Cliente {

    private Socket socket;
    private PrintWriter output;
    private Scanner lector;
    private BufferedReader input;
    private DataOutputStream sendMessageDOS;

    public void init(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.sendMessageDOS = new DataOutputStream(this.socket.getOutputStream());
    } 

    public void kill() throws IOException {
        socket.close();
        output.close();
    }

    public void start(String ip, int port) throws IOException {
        init(ip, port);
        threadCliente clienteCorrer = new threadCliente(socket.getInputStream());
        
        new Thread(clienteCorrer).start();
        
        
        lector = new Scanner(System.in);
        System.out.println("aa");
        //String usrInput;

        while (true) {
            /*
            usrInput = product.getStringTockenProduct();
            output.println(usrInput);

            if (usrInput.equalsIgnoreCase("EXIT")){
                output.println("Cliente fuera de linea");
                output.println("EXIT");
                break;                

            }
                */
        }

        //kill();

    }

    public static void main(String[] args) {
        /*
        Cliente client1 = new Cliente();
        interfaza interfaz = new interfaza();
        try {
            client1.start("localhost",2121, interfaz);
        } catch (IOException e) {
            System.out.println("No se pudo iniciar");
        }
        */
    } 

    public void sendMessage(Product product){
        try{
        this.sendMessageDOS.writeUTF(product.getStringTockenProduct());
        this.sendMessageDOS.flush();

        //this.sendMessageDOS.close();
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}

