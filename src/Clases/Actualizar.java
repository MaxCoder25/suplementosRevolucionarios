package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Actualizar {

    //REVISAR ESTA CLASE
    // Instancias la clase que hemos creado anteriormente
    ConexionMySql con_mySql = new ConexionMySql();
// Llamas al método que tiene la clase y te devuelve una conexión
    Connection conn = con_mySql.conectarMySQL();
    Statement sentencia;
    PreparedStatement ps = null;

    String consulta;
    
public void actualizarFactura(int id_producto, String detalles, int cantidad, double precio){
      int resultante = 0;
 consulta = "UPDATE detalle_factura SET "
                + "detalles = ?"
                + ",cantidad= ?"
                + ",precio= ?"
                + ",DESCUENTOS_cod_descuento = ? "
                + ",IMPUESTOS_cod_descuento= ?"
                + ",CABECERA_FACTURA_num_factura= ?"
                + "WHERE CABECERA_FACTURA_num_factura= ?";
 try {
            ps = conn.prepareStatement(consulta);

            ps.setInt(1, id_producto);            
            ps.setString(2, detalles);
            ps.setInt(3, cantidad);
            ps.setDouble(4, precio);
            
            resultante = ps.executeUpdate();
        
         } catch (SQLException ex) {
            ex.printStackTrace();
            
            System.out.println("Excepcion de actualizar factura "+ ex);
        }

        if (resultante != 0) {
            JOptionPane.showMessageDialog(null, "REGISTRO DE DETALLE_FACTURA ACTUALIZADO!", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        }
}





    public void actualizarRegistroCliente(int idCliente, int cedulaCliente, String nombreCliente, String apellidoCliente, String dirCliente, int tlfCliente, String emailCliente, char generoCliente, String otrosDetalles) {
        int resultante = 0;
        String genero = String.valueOf(generoCliente);
        consulta = "UPDATE clientes SET "
                + "ced_cliente = ?"
                + ",nomb_cliente = ?"
                + ",apell_cliente = ?"
                + ",dir_cliente = ? "
                + ",tlf_cliente= ?"
                + ",email_cliente= ?"
                + ",genero_cliente= ?"
                + ",otros_detalles = ?"
                + "WHERE id_cliente= ?";

        try {
            ps = conn.prepareStatement(consulta);

            ps.setInt(1, cedulaCliente);
            ps.setString(2, nombreCliente);
            ps.setString(3, apellidoCliente);
            ps.setString(4, dirCliente);
            ps.setInt(5, tlfCliente);
            ps.setString(6, emailCliente);
            ps.setString(7, genero);
            ps.setString(8, otrosDetalles);
            ps.setInt(9, idCliente);
            resultante = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (resultante != 0) {
            JOptionPane.showMessageDialog(null, "REGISTRO DE CLIENTE ACTUALIZADO!", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void actualizarRegistroProducto(int idProducto, String descripcionProducto, double precioProducto, String categoriaProducto) {
        int resultante = 0;
        consulta = "UPDATE producto SET "
                + "descripcion = ?"
                + ",precio_producto = ?"
                + ",categoria_producto = ?"
                + "WHERE id_producto= ?";

        try {
            ps = conn.prepareStatement(consulta);

            ps.setString(1, descripcionProducto);
            ps.setDouble(2, precioProducto);
            ps.setString(3, categoriaProducto);
            ps.setInt(4, idProducto);
            resultante = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (resultante != 0) {
            JOptionPane.showMessageDialog(null, "REGISTRO DE PRODUCTO ACTUALIZADO!", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
