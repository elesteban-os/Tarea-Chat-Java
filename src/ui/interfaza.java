package ui; // Paquete de pertenencia

// Importación de elementos para el chat.
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import product.Product;

import client.Cliente;

// Clase de la interfaz de usuario.
public class interfaza {

    private JFrame window = new JFrame("Chat");
    private JButton calcular = new JButton("Calcular");
    
    private JTextField precio = new JTextField();
    private JTextField peso = new JTextField();
    private JTextField impuestos = new JTextField();

    private JLabel lPrecio = new JLabel("Precio");
    private JLabel lPeso = new JLabel("Peso");
    private JLabel lImpuestos = new JLabel("Impuestos");

    private String precioS = "e";
    private String pesoS = "" ;
    private String impuestosS;

    private Cliente cliente;
    private Product product;
   

    // Escuchador para el botón de enviar
    ActionListener escuchador = new ActionListener(){

        
        
        @Override
        public void actionPerformed(ActionEvent event){
            try {

                 product = new Product();

                if(precio.getText().isBlank()) {
                    System.out.println("Ingrese un precio");
                }else{
                    product.setPrecio(Integer.parseInt(precio.getText()));
                }
                
                if(peso.getText().isBlank()) {
                    System.out.println("Ingrese un peso");
                }else{
                    product.setPeso(Integer.parseInt(peso.getText()));
                }

                if(impuestos.getText().isBlank()) {
                    System.out.println("Ingrese un impuesto");
                }else{
                    product.setImpuesto(Integer.parseInt(impuestos.getText()));
                }

                
                System.out.println(product.getString());

                cliente.sendMessage(product);

            } catch (NumberFormatException nfe){
                System.out.println("Debe ser entero");
            }

            precio.setText("");
            peso.setText("");
            impuestos.setText("");

            precioS = null;
            pesoS = null;
            impuestosS = null;
            
        }

    };

    public interfaza(){

        // Botón
        calcular.setBounds(50, 300, 100, 30);
        calcular.addActionListener(escuchador);

        // Cuadros de texto
        precio.setBounds(50, 100, 100, 30);
        peso.setBounds(50, 175, 100, 30);
        impuestos.setBounds(50, 250, 100, 30);

        // Labels
        lPrecio.setBounds(50, 80, 50, 10);
        lPeso.setBounds(50, 155, 50, 10);
        lImpuestos.setBounds(50, 230, 120, 10);
    

        window.add(precio);
        window.add(peso);
        window.add(impuestos);
        window.add(calcular);
        window.add(lPrecio);
        window.add(lPeso);
        window.add(lImpuestos);

        window.setSize(400, 400);
        window.setLayout(null);
        window.setResizable(false);
        window.setVisible(true);
    try{
        this.cliente = new Cliente();
        this.cliente.start("localhost", 2121);
    }catch(IOException ioe){
        System.out.println(ioe.getMessage());
    }
    }

    public String returnPrecio() {
        return this.precioS;
    }

    public String returnPeso() {
        return this.pesoS;
    }

    public String returnImpuestos() {
        return this.impuestosS;
    }
        
           
}

