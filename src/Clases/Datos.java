package Clases;

public class Datos {

    public boolean validarUsuario(String usuario, String password) {
        if (usuario.equals("Matt") && password.equals("system5")||usuario.equals("Mac") && password.equals("system4")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esNumero(String cadena) {
        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException ex) {
            resultado = false;
        }
        return resultado;
    }

    public boolean esNumeroDoble(String cadena) {
        boolean resultado;

        try {
            Double.valueOf(cadena);
            resultado = true;
        } catch (NumberFormatException ex) {
            resultado = false;
        }
        return resultado;
    }

}
