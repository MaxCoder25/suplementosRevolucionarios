package Clases;

public class Cliente {

    private int id_cliente;
    private int ced_cliente;
    private String nomb_cliente;
    private String apell_cliente;
    private String dir_cliente;
    private int tlf_cliente;
    private String email_cliente;
    private char genero_cliente;
    private String otros_detalles;

    public Cliente(int id_cliente, int ced_cliente, String nomb_cliente, String apell_cliente, String dir_cliente, int tlf_cliente, String email_cliente, char genero_cliente, String otros_detalles) {
        this.id_cliente = id_cliente;
        this.ced_cliente = ced_cliente;
        this.nomb_cliente = nomb_cliente;
        this.apell_cliente = apell_cliente;
        this.dir_cliente = dir_cliente;
        this.tlf_cliente = tlf_cliente;
        this.email_cliente = email_cliente;
        this.genero_cliente = genero_cliente;
        this.otros_detalles = otros_detalles;
    }

    public Cliente(int id_cliente, int cedula_cliente, String nombre, String apellido) {

        this.id_cliente = id_cliente;
        this.ced_cliente = cedula_cliente;
        this.nomb_cliente = nombre;
        this.apell_cliente = apellido;

    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCed_cliente() {
        return ced_cliente;
    }

    public void setCed_cliente(int ced_cliente) {
        this.ced_cliente = ced_cliente;
    }

    public String getNomb_cliente() {
        return nomb_cliente;
    }

    public void setNomb_cliente(String nomb_cliente) {
        this.nomb_cliente = nomb_cliente;
    }

    public String getApell_cliente() {
        return apell_cliente;
    }

    public void setApell_cliente(String apell_cliente) {
        this.apell_cliente = apell_cliente;
    }

    public String getDir_cliente() {
        return dir_cliente;
    }

    public void setDir_cliente(String dir_cliente) {
        this.dir_cliente = dir_cliente;
    }

    public int getTlf_cliente() {
        return tlf_cliente;
    }

    public void setTlf_cliente(int tlf_cliente) {
        this.tlf_cliente = tlf_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public char getGenero_cliente() {
        return genero_cliente;
    }

    public void setGenero_cliente(char genero_cliente) {
        this.genero_cliente = genero_cliente;
    }

    public String getOtros_detalles() {
        return otros_detalles;
    }

    public void setOtros_detalles(String otros_detalles) {
        this.otros_detalles = otros_detalles;
    }

}
