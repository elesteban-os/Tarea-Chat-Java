package server;

import product.Product;

public class botonMonto {

    boolean bool = false;
    String mensaje = null;

    public botonMonto(Product product){
        while (bool == false){
            if (product.getTotal() != 0.0){
                this.bool = true;
                this.mensaje = String.valueOf(product.getTotal());
            } 
        }
    }

    public String getMensaje(){
        return this.mensaje;
    }

    public void setMensaje(){
        this.mensaje = null;
    }
}
