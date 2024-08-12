package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta {
    // Instancias la clase que hemos creado anteriormente

    ConexionMySql con_mySql = new ConexionMySql();
// Llamas al método que tiene la clase y te devuelve una conexión
    Connection conn = con_mySql.conectarMySQL();
// Query que usarás para hacer lo que necesites
    String consulta = "";

    public int contarClientes() {

        consulta = "";
        try {
            consulta = "SELECT COUNT(*) from clientes";
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            if (resultado.next()) {
                return resultado.getInt("COUNT(*)");  //nombre de la columna

            } else {
                return 0;
            }
        } catch (SQLException ex) {
            return 0;
        }
    }

    public boolean existeCliente(int id_cliente) {
        consulta = "";

        try {
            consulta = "SELECT id_cliente from clientes WHERE id_cliente='" + id_cliente + "'";
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {
                if (resultado.getString(1) != null) {
                    return true;

                }
                break;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
