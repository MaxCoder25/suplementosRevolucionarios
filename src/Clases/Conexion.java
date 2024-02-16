
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Librería de MySQL
    public static String driver = "com.mysql.cj.jdbc.Driver";

    public static String url = "jdbc:mysql://localhost/sistemafinal?use"
            + "Unicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // Nombre de usuario
    public static String username = "root";

    // Clave de usuario
    public static String password = "*sisazmon22*";

    ;

    public static Connection conectar() {
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


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
	public static Connection conectar() {
		Connection con = null;
 
		try {
			String url = "jdbc:mysql://localhost:3306/facturacionsuplementosfinal?user=root&password=*sisazmon22*"+
             "Unicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conexion Satisfactoria");
			}
 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
}*/