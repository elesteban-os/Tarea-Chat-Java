package client;

import java.net.Socket;

import javax.swing.JLabel;

import java.io.*;

import product.*;
import ui.interfaza;
import client.threadCliente;



public class Cliente {

    private String resultado;
    private Socket socket;
    private DataOutputStream sendMessageDOS;
    private DataInputStream receiveMessageDIS;
    threadCliente clienteCorrer;
    private interfaza interfaz;

    public Cliente(interfaza interfaaz){
        this.interfaz = interfaaz;
    }

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
        clienteCorrer = new threadCliente(socket.getInputStream(), this.interfaz);
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

    public String recibePrecio() throws IOException{
        this.resultado = this.receiveMessageDIS.readUTF();
        
        return this.resultado;
    }

}

//