package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySql {

    // Librería de MySQL
    public String driver = "com.mysql.cj.jdbc.Driver";

    public String url = "jdbc:mysql://localhost/sistemafinal?use"
            + "Unicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "*sisazmon22*";

    ;

    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("CONEXION EXITOSA");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

}
