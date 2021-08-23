package ui; // Paquete de pertenencia

// Importación de elementos para el chat.
import javax.swing.*;
import java.awt.*;

// Clase de la interfaz de usuario.
public class interfaz {

    // Creación objetos de la interfaz.
    JFrame ventanaChat = null;
    JButton botonEnviar = null;
    JTextField escribirTexto = null;
    JTextArea verTexto = null;

    // Paneles para el botón y textos para la interfaz.
    JPanel anadirBotonEnviar = null;
    JPanel anadirCampoTexto = null;
    JPanel anadirVerTexto = null;

    // Método que abre los objetos de la interfaz.
    public interfaz(){
        abririnterfaz();
    }

    // Método que configura los elementos de la interfaz.
    public void abririnterfaz(){

        // Ventana del chat
        ventanaChat = new JFrame("Chat");
        
        // Botón de enviar
        botonEnviar = new JButton("Enviar"); // Boton
        escribirTexto = new JTextField(4);   // Campo de texto
        anadirBotonEnviar = new JPanel();
        anadirBotonEnviar.add(escribirTexto);
        anadirBotonEnviar.add(botonEnviar);
        anadirBotonEnviar.setLayout(new GridLayout(1,2));
        ventanaChat.add(anadirBotonEnviar, BorderLayout.SOUTH);
        
        //botonEnviar.addActionListener(this);

        // Ver texto
        verTexto = new JTextArea(20, 34);
        anadirVerTexto = new JPanel();
        anadirVerTexto.add(verTexto);
        anadirBotonEnviar.setLayout(new GridLayout(1, 1));
        ventanaChat.add(anadirVerTexto, BorderLayout.NORTH);
        
        // Atributos de la ventana del chat
        ventanaChat.setSize(400, 400);
        ventanaChat.setResizable(false);
        ventanaChat.setVisible(true);
        //ventanaChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }

    /*class pulsar implements ActionListener {
        public void actionPerformed(ActionEvent ae){
    
        }
    }*/

}
