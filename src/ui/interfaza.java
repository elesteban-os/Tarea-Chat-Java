package ui; // Paquete de pertenencia

// Importación de elementos para el chat.
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import product.Product;
import client.Cliente;

/**
 * Esta clase realiza e implementa todos los elementos de una interfaz.
 * @author: Kevin Esteban Chinchilla Rodríguez.
 * @version: 1.0
 */

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

    private JLabel lTotal = new JLabel("Resultado");
    private JLabel lResultado = new JLabel("Resultado:");

    private Cliente cliente;
    private Product product = new Product();;

    
    // Escuchador para el botón de enviar
    ActionListener escuchador = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent event){
            if (precio.getText().isBlank() || 
                peso.getText().isBlank() ||
                impuestos.getText().isBlank()){

                    lTotal.setText("¡Llena todos los espacios!");     
                }
            else{
                try {
                    String precioo = precio.getText();
                    String pesoo = peso.getText();
                    String impuestoos = impuestos.getText();

                    precio.setText("");
                    peso.setText("");
                    impuestos.setText("");

                    product.setPrecio(Integer.parseInt(precioo));
                    product.setPeso(Integer.parseInt(pesoo));
                    product.setImpuesto(Integer.parseInt(impuestoos));

                    System.out.println("desde interfaza" +product.getString());

                    cliente.sendMessage(product);
        
                    } catch (NumberFormatException nfe){
                        lTotal.setText("¡Deben ser números enteros!");
                    }
            }
                 
        }

    };

    /**
     * Constructor que implementa todas las características de la interfaz.
     */

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
        lTotal.setBounds(180, 185, 190, 10);    
        lResultado.setBounds(180, 165, 190, 10); 

        window.add(lResultado);
        window.add(precio);
        window.add(peso);
        window.add(impuestos);
        window.add(calcular);
        window.add(lPrecio);
        window.add(lPeso);
        window.add(lImpuestos);
        window.add(lTotal);

        window.setSize(400, 400);
        window.setLayout(null);
        window.setResizable(false);
        window.setVisible(true);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        
    }

    /**
     * Función que cambia el texto que tiene el label dónde se muestra el resultado total.
     * @param mensaje Recibe el mensaje de lo que se quiere indicar en el label.
     */

    public void cambiarTotal(String mensaje) {
        this.lTotal.setText(mensaje);
    }

    /**
     * Función que identifica la interfaz gráfica que tiene el cliente.
     * @param client Recibe el cliente.
     */
    
    public void setCliente(Cliente client){
        this.cliente = client;
    }
           
}

