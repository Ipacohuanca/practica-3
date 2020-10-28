
package com.emergentes.modelo;

public class Aviso {
    
    private int id;
    private String producto;
    private String precio;
    private String cantidad;
    
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    } 
    
    public String tosString(){
    return "Aviso{" + "id=" +id + ",producto=" + producto + ", precio="+ precio + ",cantidad=" + cantidad + '}';
    }
}
