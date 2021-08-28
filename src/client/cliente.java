package client;

import java.net.Socket;
import java.io.*;

import product.*;
import client.threadCliente;



public class Cliente {

    private Socket socket;
    private DataOutputStream sendMessageDOS;
    private DataInputStream receiveMessageDIS;

    public void init(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        this.sendMessageDOS = new DataOutputStream(this.socket.getOutputStream());
        this.receiveMessageDIS = new DataInputStream(this.socket.getInputStream());
    } 

    public void kill() throws IOException {
        socket.close();
    }

    public void start(String ip, int port) throws IOException {
        init(ip, port);
        threadCliente clienteCorrer = new threadCliente(socket.getInputStream());
        new Thread(clienteCorrer).start();
        System.out.println("aa");

    }
        
    public void sendMessage(Product product){
        try{
        this.sendMessageDOS.writeUTF(product.getStringTockenProduct());
        this.sendMessageDOS.flush();

        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }

        
    }
}

//