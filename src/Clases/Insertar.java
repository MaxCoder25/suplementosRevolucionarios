package Clases;

import Ventanas.VentanaFactura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Insertar {

    // Instancias la clase que hemos creado anteriormente
    ConexionMySql con_mySql = new ConexionMySql();
// Llamas al método que tiene la clase y te devuelve una conexión
    Connection conn = con_mySql.conectarMySQL();
// Query que usarás para hacer lo que necesites
    String consulta = "";
     double subTotalFactura[]= new double [20];
     double subTotal=0;
     public double TotalFacturas = 0;
      int cont=0;
    
    
    
  
public void guardarDatos (Factura nuevaFactura){
     consulta = "";
     
    int num_factura=nuevaFactura.getNum_factura(); 
    int EMPRESA_ruc_empresa= nuevaFactura.getRuc_empresa();
    int CLIENTES_id_cliente=nuevaFactura.getId_cliente();
    int EMPLEADO_id_empleado=nuevaFactura.getId_empleado();
    
    
    
    int CABECERA_FACTURA_num_factura = nuevaFactura.getNum_factura();
    String fecha_emision = nuevaFactura.getFecha();
    int ruc_empresa = nuevaFactura.getRuc_empresa();
    int id_cliente = nuevaFactura.getId_cliente();
    
    String detalles = nuevaFactura.getDetalles();
    int cantidad = nuevaFactura.getCantidad();
    double precio = nuevaFactura.getPrecio();
    int DESCUENTOS_cod_descuento = nuevaFactura.getDescuento();
    int IMPUESTOS_cod_impuesto = nuevaFactura.getImpuesto();
    int PRODUCTO_id_producto = nuevaFactura.getId_producto();
    
      
   
    int contSub=nuevaFactura.getNum_factura();
    
    
    int DETALLE_FACTURA_CABECERA_FACTURA_num_factura=nuevaFactura.getNum_factura();
    
      int idtotalFacturas =nuevaFactura.getNum_factura(); 
       
       
       
       
       
       
       
       
    
    try {
            consulta = "INSERT INTO cabecera_factura (num_factura, fecha_emision, EMPRESA_ruc_empresa, CLIENTES_id_cliente, EMPLEADO_id_empleado ) VALUES (?,?,?,?,?)";
            PreparedStatement preparState = conn.prepareStatement(consulta);
            preparState.setInt(1, num_factura);
            preparState.setString(2, fecha_emision);
            preparState.setInt(3, EMPRESA_ruc_empresa);
            preparState.setInt(4, CLIENTES_id_cliente);
            preparState.setInt(5, EMPLEADO_id_empleado);
            preparState.executeUpdate();
          //   JOptionPane.showMessageDialog(null, "cabecera_factura agregada exitosamente!", "Notificación", JOptionPane.INFORMATION_MESSAGE);
           System.out.println("Agregado a la Tabla cabecera_factura");
        } catch (Exception ex) {
           System.out.println("Error no se pudieron guardar los datos de cabecera");
           System.out.println(ex);
        }
     try {
            consulta = "INSERT INTO detalle_factura (detalles, cantidad, precio, DESCUENTOS_cod_descuento, IMPUESTOS_cod_impuesto, CABECERA_FACTURA_num_factura, PRODUCTO_id_producto) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparState = conn.prepareStatement(consulta);
            preparState.setString(1, detalles);
            preparState.setInt(2, cantidad);
            preparState.setDouble(3, precio);
            preparState.setInt(4, DESCUENTOS_cod_descuento);
            preparState.setInt(5, 2);//aqui pongo el codigo de impuesto 2 que corresponde a 10.32
            preparState.setInt(6, CABECERA_FACTURA_num_factura);
            preparState.setInt(7, PRODUCTO_id_producto);
            preparState.executeUpdate();
         //   JOptionPane.showMessageDialog(null, "detalle_factura agregada exitosamente!", "Notificación", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Agregado a la Tabla detalle_factura");
       
        
        
     } catch (Exception ex) {
           System.out.println("Error no se pudieron guardar los datos de detalle");
           System.out.println(ex);
        }
    subTotalFactura [contSub]=cantidad * precio;
     
    
    for (int i = 0; i < subTotalFactura.length; i++) {
        subTotal+=subTotalFactura [i];
    }
   
    
      TotalFacturas=subTotal;
   
    
   
    
    
    
     try {
            consulta = "DELETE FROM totalfacturas WHERE DETALLE_FACTURA_CABECERA_FACTURA_num_factura = '"+ num_factura +"'" ;
            PreparedStatement preparState = conn.prepareStatement(consulta);

            preparState.executeUpdate();
            System.out.println("Eliminado de la Tabla totalFacturas");
            
        
        
     } catch (Exception ex) {
           System.out.println("Error no se pudieron borrar los datos de totalFacturas");
           System.out.println(ex);
        }
    
    
      try {
            consulta = "INSERT INTO totalfacturas (idtotalFacturas,DETALLE_FACTURA_CABECERA_FACTURA_num_factura, subtotal,total) VALUES (?,?,?,?)";
            PreparedStatement preparState = conn.prepareStatement(consulta);
           
            preparState.setInt(1, idtotalFacturas);
            preparState.setInt(2, DETALLE_FACTURA_CABECERA_FACTURA_num_factura);
            preparState.setDouble(3, subTotal);
            preparState.setDouble(4, TotalFacturas+10.32);
            
            preparState.executeUpdate();
           // JOptionPane.showMessageDialog(null, "total agregado exitosamente!", "Notificación", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Agregado a la Tabla totalfacturas");
            
        
        
     } catch (Exception ex) {
           System.out.println("Error no se pudieron guardar los datos de totalFacturas");
           System.out.println(ex);
        }
    
     
     
     
     
     
     
     
     
     
     
     
     
     
    
}
    public void guardarDatos(Cliente nuevoCliente) {
        consulta = "";
        int id_cliente = nuevoCliente.getId_cliente();
        int ced_cliente = nuevoCliente.getCed_cliente();
        String nombreCliente = nuevoCliente.getNomb_cliente();
        String apellidoCliente = nuevoCliente.getApell_cliente();
        String dirCliente = nuevoCliente.getDir_cliente();
        int tlfCliente = nuevoCliente.getTlf_cliente();
        String emailCliente = nuevoCliente.getEmail_cliente();
        String generoCliente = String.valueOf(nuevoCliente.getGenero_cliente()); //ojojojoj
        String otrosDetalles = nuevoCliente.getOtros_detalles();

        try {
            consulta = "INSERT INTO clientes (id_cliente, ced_cliente, nomb_cliente, apell_cliente, dir_cliente, tlf_cliente, email_cliente, genero_cliente, otros_detalles) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparState = conn.prepareStatement(consulta);
            preparState.setInt(1, id_cliente);
            preparState.setInt(2, ced_cliente);
            preparState.setString(3, nombreCliente);
            preparState.setString(4, apellidoCliente);
            preparState.setString(5, dirCliente);
            preparState.setInt(6, tlfCliente);
            preparState.setString(7, emailCliente);
            preparState.setString(8, generoCliente);
            preparState.setString(9, otrosDetalles);
            preparState.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente agregado exitosamente!", "Notificación", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Agregado a la Tabla clientes");
        } catch (Exception ex) {
//            System.out.println("codugos de parroquia, canton, provincia " + cod_Parroquia + " " + cod_Canton + " " + cod_Provincia);
            System.out.println("Error no se pudieron guardar los datos");
            System.out.println(ex);
        }

    }

    public void guardarDatos(Producto nuevoProducto) {
        consulta = "";
        int id_producto = nuevoProducto.getId_producto();
        String descrip_producto = nuevoProducto.getDescripcion();
        double precioProducto = nuevoProducto.getPrecio_producto();
        String categoriaProducto = nuevoProducto.getCategoria_producto();

        try {
            consulta = "INSERT INTO producto (id_producto, descripcion, precio_producto, categoria_producto) VALUES (?,?,?,?)";
            PreparedStatement preparState = conn.prepareStatement(consulta);
            preparState.setInt(1, id_producto);
            preparState.setString(2, descrip_producto);
            preparState.setDouble(3, precioProducto);
            preparState.setString(4, categoriaProducto);
            preparState.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto agregado exitosamente!", "Notificación", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Agregado a la Tabla Producto");
        } catch (Exception ex) {
            System.out.println("Error no se pudieron guardar los datos");
            System.out.println(ex);
        }

    }

}
