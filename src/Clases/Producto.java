
package Clases;


public class Producto {
    int id_producto;
    String descripcion;
    double precio_producto;
    String categoria_producto;

    public Producto(int id_producto, String descripcion, double precio_producto, String categoria_producto) {
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.precio_producto = precio_producto;
        this.categoria_producto = categoria_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public String getCategoria_producto() {
        return categoria_producto;
    }

    public void setCategoria_producto(String categoria_producto) {
        this.categoria_producto = categoria_producto;
    }

   
}
