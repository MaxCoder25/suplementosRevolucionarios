package Clases;

public class Factura {
private int num_factura;
private String fecha;
private int ruc_empresa;
private int id_cliente;


private String detalles;
private int cantidad;
private double precio;
private int descuento;
private int impuesto;
private int id_producto;
private int id_empleado;

    public Factura(int num_factura, String fecha, int ruc_empresa, int id_cliente, int id_empleado, String detalles, int cantidad, double precio, int descuento, int impuesto, int id_producto) {
        this.num_factura = num_factura;
        this.fecha = fecha;
        this.ruc_empresa = ruc_empresa;
        this.id_cliente = id_cliente;
        this.id_empleado=id_empleado;
        this.detalles = detalles;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.impuesto = impuesto;
        this.id_producto = id_producto;
    }

    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getRuc_empresa() {
        return ruc_empresa;
    }

    public void setRuc_empresa(int ruc_empresa) {
        this.ruc_empresa = ruc_empresa;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
    

}