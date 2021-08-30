package product;

/** 
 * @version 1.0
 * Clase producto para llevar el objeto en la comunicación.
 * @since 1.0
 */

public class Product{

    private int precio;
    private int impuesto;
    private int peso;
    private double total = 0.0;

    /**
     * Método constructor para inicializar variables.
     * Recibe:
     * @param precioA
     * @param impuestoA
     * @param pesoA
     * @param totalA
     * 
     *  @since 1.0
     */

    public Product(int precioA, int impuestoA, int pesoA, int totalA){
        this.total = totalA;
        this.impuesto = impuestoA;
        this.peso = pesoA;
        this.precio = precioA;
    }
    /**
    * Método constructor default.
    *
    *  @since 1.0
    */

    public Product() {
        
    }

    /**
     * Método get de acceso al precio.
     *
     *  @since 1.0
     */

    public int getPrecio(){
        return this.precio;
    }
    /**
     * Método get de acceso al impuesto.
     *
     *  @since 1.0
     */

    public int getImpuesto(){
        return this.impuesto;
    }
    /**
     * Método get de acceso al peso.
     *
     *  @since 1.0
     */

    public int getPeso(){
        return this.peso;
    }
    /**
     * Método get de acceso al total.
     *
     *  @since 1.0
     */
    
    public double getTotal(){
        return this.total;
    }

    /**
     * Método set de inicializacion al total.
     *
     *  @since 1.0
     */

    public void setTotal(double totalA){
        this.total = totalA;
    }

    /**
     * Método set de inicializacion al precio.
     *
     *  @since 1.0
     */

    public void setPrecio(int precioA){
        this.precio = precioA;
    }

    /**
     * Método set de inicializacion al peso.
     *
     *  @since 1.0
     */

    public void setPeso(int pesoA){
        this.peso = pesoA;
    }
    /**
     * Método set de inicializacion al impuesto.
     *
     *  @since 1.0
     */

    public void setImpuesto(int impuestoA){
        this.impuesto = impuestoA;
    }

    /**
     * Método para imprimir objeto.
     *
     *  @since 1.0
     */

    public String getString(){
        return " Precio: " + String.valueOf(this.precio) + 
        " Peso: " + String.valueOf(this.peso) + 
        " Impuesto: " + String.valueOf(this.impuesto) + " " +
        " Total: " + String.valueOf(this.total);
    }
    /**
     * Método para crear un string con token - como objeto.
     *
     *  @since 1.0
     */

    public String getStringTockenProduct(){
        return String.valueOf(this.precio) + 
        "-" + String.valueOf(this.peso) + 
        "-" + String.valueOf(this.impuesto) +
        "-" + String.valueOf(this.total);
    }

}
