/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Actualizar;
import Clases.Cliente;
import Clases.ConexionMySql;
import Clases.Consulta;
import Clases.Datos;
import Clases.Factura;
import Clases.Insertar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KevinMac
 */
public class VentanaFactura extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaFactura
     */
    /* cambio 1: aqui ingrese estos metodos setters
     */
    private Datos misDatos;
    
    private DefaultTableModel modelo;
    
    Insertar insertarEnBase = new Insertar();
    int productoActual = 0;
    public int contNumFac = comprobarNumFactura() + 1;
    
    public boolean btn_restarAccionado = false;

//     public  void comprobarQuitarTotal() {
//        if (btn_restarAccionado==true) {
//            String producto = (String) combo_producto.getSelectedItem();
//            totalFactura-=Integer.parseInt(producto); 
//
//        }
    // return totalFactura;
//    }
    public void setDatos(Datos misDatos) {
        this.misDatos = misDatos;
    }
    
    private Consulta miConsulta;
    
    public VentanaFactura() {
        initComponents();
        llenarTabla();
        campo_numFactura.setEnabled(false);
        campo_fecha.setEnabled(false);
        campo_RUC.setEnabled(false);
        campo_empleado.setEnabled(false);
        campo_subTotal.setEnabled(false);
        campo_impuestos.setEnabled(false);
        campo_descuentos.setEnabled(false);
        campo_total.setEnabled(false);
        
        combo_categoria.addItem("Seleccione categoria");
        combo_categoria.addItem("Proteinas");
        combo_categoria.addItem("Carbohidratos");
        combo_categoria.addItem("Creatina");
        combo_categoria.addItem("Anabólicos");
        combo_categoria.addItem("Vitaminas");
        
        campo_numFactura.setText(Integer.toString(contNumFac));
        
        Date myDate = new Date();

        //System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(myDate));
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(myDate);
        campo_fecha.setText(fecha);
        campo_RUC.setText("1738492748");
        
        miTablaF.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (miTablaF.getSelectedRow() != -1) {
                    int fila = miTablaF.getSelectedRow();
                    miTablaF.getValueAt(fila, 0).toString();
                    
                }
            }
            
        });
        
    }
    
    private int comprobarNumFactura() {
        Factura nFactura = null;
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        Statement sentencia;
        ResultSet resultado;
        
        String consulta;
        
        int maximo = 0;
        
        consulta = "SELECT MAX(num_factura) FROM cabecera_factura";
        
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(consulta);
            
            while (resultado.next()) {
                
                maximo = resultado.getInt(1);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return maximo;
        
    }
    
    public Factura dar_valores() {
        Factura nFactura = null;
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        Statement sentencia;
        ResultSet resultado;
        
        String consulta;
        String producto = (String) combo_producto.getSelectedItem();
        double precio = 0;
        int PRODUCTO_id_producto = 0;
        
        consulta = "SELECT id_producto, precio_producto FROM producto WHERE descripcion='" + producto + "'";
        
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(consulta);
            
            String categorias;
            
            while (resultado.next()) {
                
                PRODUCTO_id_producto = resultado.getInt(1);
                precio = resultado.getDouble(2);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //esto es de cabecera factura ******
        //*************************************
        int num_factura = Integer.parseInt(campo_numFactura.getText());
        int EMPRESA_ruc_empresa = Integer.parseInt(campo_RUC.getText());
        int CLIENTES_id_cliente = Integer.parseInt(campo_IdCliente.getText());
        int EMPLEADO_id_empleado = Integer.parseInt(campo_IdEmpleado.getText());
        String fecha_emision = campo_fecha.getText();

        //Esto es de detalle factura *****************
        //********************************************
        String detalles = (String) combo_producto.getSelectedItem();
        int cantidad = Integer.parseInt(campo_cantidad.getText());
        // precio; arriba de la consulta de producto lo saco
        int DESCUENTOS_cod_descuento = 0;
        int IMPUESTOS_cod_impuesto = 2;
        int CABECERA_FACTURA_num_factura = Integer.parseInt(campo_numFactura.getText());
        //PRODUCTO_id_producto; arriba de la consulta de producto lo saco

        nFactura = new Factura(num_factura, fecha_emision, EMPRESA_ruc_empresa, CLIENTES_id_cliente, EMPLEADO_id_empleado, detalles, cantidad, precio, DESCUENTOS_cod_descuento, IMPUESTOS_cod_impuesto, PRODUCTO_id_producto);
        return nFactura;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        miTablaFac = new javax.swing.JTable();
        lbl_fecha = new javax.swing.JLabel();
        lbl_cliente = new javax.swing.JLabel();
        campo_fecha = new javax.swing.JTextField();
        combo_producto = new javax.swing.JComboBox<>();
        lbl_producto = new javax.swing.JLabel();
        btn_buscaCliente = new javax.swing.JButton();
        btn_selecCategoria = new javax.swing.JButton();
        campo_cantidad = new javax.swing.JTextField();
        lbl_cantidad = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JButton();
        btn_restar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        campo_subTotal = new javax.swing.JTextField();
        campo_total = new javax.swing.JTextField();
        lbl_total = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        miTablaF = new javax.swing.JTable();
        campo_numFactura = new javax.swing.JTextField();
        lbl_numFactura = new javax.swing.JLabel();
        lbl_ruc = new javax.swing.JLabel();
        campo_RUC = new javax.swing.JTextField();
        campo_NombreCliente = new javax.swing.JTextField();
        campo_cedula = new javax.swing.JTextField();
        lbl_cedula = new javax.swing.JLabel();
        lbl_IdCliente = new javax.swing.JLabel();
        campo_IdCliente = new javax.swing.JTextField();
        lbl_IDEmpleado = new javax.swing.JLabel();
        campo_IdEmpleado = new javax.swing.JTextField();
        btn_empleado = new javax.swing.JButton();
        combo_categoria = new javax.swing.JComboBox<>();
        campo_empleado = new javax.swing.JTextField();
        lbl_Empleado = new javax.swing.JLabel();
        lbl_subtotal = new javax.swing.JLabel();
        lbl_impuestos = new javax.swing.JLabel();
        lbl_descuentos = new javax.swing.JLabel();
        campo_impuestos = new javax.swing.JTextField();
        campo_descuentos = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();

        miTablaFac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(miTablaFac);

        setClosable(true);
        setIconifiable(true);
        setTitle("Nueva Factura");
        setEnabled(false);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        lbl_fecha.setText("Fecha:");

        lbl_cliente.setText("Nombre cliente:");

        campo_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_fechaActionPerformed(evt);
            }
        });

        lbl_producto.setText("Producto:");

        btn_buscaCliente.setText("Buscar cliente");
        btn_buscaCliente.setToolTipText("Busca un cliente");
        btn_buscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscaClienteActionPerformed(evt);
            }
        });

        btn_selecCategoria.setText("Seleccionar Categoría");
        btn_selecCategoria.setToolTipText("Busca un producto");
        btn_selecCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selecCategoriaActionPerformed(evt);
            }
        });

        campo_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_cantidadActionPerformed(evt);
            }
        });

        lbl_cantidad.setText("Cantidad: ");

        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/agregar.png"))); // NOI18N
        btn_agregar.setToolTipText("Agrega producto a la factura");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_restar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/quitar.png"))); // NOI18N
        btn_restar.setToolTipText("Elimina producto de la factura");
        btn_restar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restarActionPerformed(evt);
            }
        });

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/reciclar.png"))); // NOI18N
        btn_eliminar.setToolTipText("Elimina Factura");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/guardar.png"))); // NOI18N
        btn_aceptar.setToolTipText("Guarda la factura");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        campo_subTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_subTotalActionPerformed(evt);
            }
        });

        campo_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_totalActionPerformed(evt);
            }
        });

        lbl_total.setText("Total:");

        miTablaF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(miTablaF);

        campo_numFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_numFacturaActionPerformed(evt);
            }
        });

        lbl_numFactura.setText("Número de Factura");

        lbl_ruc.setText("R.U.C. empresa");

        campo_NombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_NombreClienteActionPerformed(evt);
            }
        });

        campo_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_cedulaActionPerformed(evt);
            }
        });

        lbl_cedula.setText("Cédula cliente");

        lbl_IdCliente.setText("Id cliente");

        campo_IdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_IdClienteActionPerformed(evt);
            }
        });

        lbl_IDEmpleado.setText("Id empleado");

        campo_IdEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_IdEmpleadoActionPerformed(evt);
            }
        });

        btn_empleado.setText("Seleccionar empleado");
        btn_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_empleadoActionPerformed(evt);
            }
        });

        campo_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_empleadoActionPerformed(evt);
            }
        });

        lbl_Empleado.setText("Empleado");

        lbl_subtotal.setText("SubTotal");

        lbl_impuestos.setText("Impuestos");

        lbl_descuentos.setText("Descuentos");

        campo_impuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_impuestosActionPerformed(evt);
            }
        });

        campo_descuentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_descuentosActionPerformed(evt);
            }
        });

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancelar.png"))); // NOI18N
        btn_cancelar.setToolTipText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_cantidad, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_IdCliente, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_cliente))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_producto)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campo_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(162, 162, 162))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_restar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btn_selecCategoria)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_fecha, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_ruc, javax.swing.GroupLayout.Alignment.TRAILING)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campo_IdCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_buscaCliente)
                                .addGap(116, 116, 116))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campo_NombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(combo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_IDEmpleado)
                                        .addComponent(lbl_cedula))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(combo_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(95, 95, 95)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campo_IdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_Empleado))
                                    .addComponent(btn_empleado)
                                    .addComponent(campo_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_numFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(campo_numFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(campo_empleado)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campo_RUC, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campo_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_subtotal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_impuestos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_descuentos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_total, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_subTotal)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(campo_descuentos, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                    .addComponent(campo_impuestos)
                                    .addComponent(campo_total))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_IdCliente)
                                        .addComponent(campo_IdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_buscaCliente))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_IDEmpleado)
                                        .addComponent(campo_IdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campo_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_Empleado)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_empleado)
                                    .addComponent(lbl_numFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campo_numFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campo_NombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_cliente)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_cedula)
                            .addComponent(campo_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_producto)
                        .addComponent(combo_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campo_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_fecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_ruc)
                                    .addComponent(campo_RUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(campo_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_cantidad))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_agregar)
                                            .addComponent(btn_restar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btn_selecCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_subtotal)
                            .addComponent(campo_subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_impuestos)
                            .addComponent(campo_impuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_descuentos)
                            .addComponent(campo_descuentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_total)
                            .addComponent(campo_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campo_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_fechaActionPerformed

    private void campo_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_cantidadActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        
        campo_impuestos.setText("10.32");
        campo_descuentos.setText("0");
        
        String datos[] = new String[6];
        String id_cliente = campo_IdCliente.getText();
        String producto = (String) combo_producto.getSelectedItem();
        Actualizar metodo = new Actualizar();
        String cantidad = campo_cantidad.getText();
        
        Factura nuevaFactura = null;
        nuevaFactura = dar_valores();
        insertarEnBase.guardarDatos(nuevaFactura);
        llenarTabla();
        
        consultaTotal();
        

    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_restarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restarActionPerformed
        btn_restarAccionado = true;
        Factura nFactura = null;
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        Statement sentencia;
        ResultSet resultado;
        
        String consulta;
        String producto = (String) combo_producto.getSelectedItem();
        int numfac =Integer.parseInt(campo_numFactura.getText());
        double precio = 0;
        int PRODUCTO_id_producto = 0;
        String auxSub = campo_subTotal.getText();
        
        try {
            consulta = "DELETE FROM totalfacturas WHERE idtotalFacturas = '" + contNumFac + "'" ;
            
          PreparedStatement  preparState = conexion.prepareStatement(consulta);
            
            preparState.executeUpdate();
            
            System.out.println("Eliminado de la Tabla totalFacturas");
           
            
            
            
//            consulta = "DELETE FROM cabecera_factura WHERE num_factura = '" + contNumFac + "'";
//
//            preparState = conexion.prepareStatement(consulta);
//
//            preparState.executeUpdate();
//
//            System.out.println("Eliminado de la Tabla cabecera_factura");

            consulta = "Delete FROM detalle_factura WHERE detalles='" + producto + "' AND CABECERA_FACTURA_num_factura ='"+ numfac +"'";

            preparState = conexion.prepareStatement(consulta);

            preparState.executeUpdate();
            System.out.println("Eliminado de la Tabla totalFacturas");
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        llenarTabla();
        
        consulta = "SELECT precio_producto FROM producto WHERE descripcion='" + producto + "'";
        
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(consulta);
            double precio_producto = 0.0;
            while (resultado.next()) {
                
                precio_producto = resultado.getDouble(1);
                
            }
            
            consulta = "INSERT INTO totalFacturas (DETALLE_FACTURA_CABECERA_FACTURA_num_factura, subtotal,total) VALUES (?,?,?)";
            PreparedStatement preparState = conexion.prepareStatement(consulta);
            
            preparState.setInt(1, contNumFac);
            preparState.setDouble(2, Double.parseDouble(auxSub) - precio_producto);
            preparState.setDouble(3, Double.parseDouble(auxSub) - precio_producto);
            
            preparState.executeUpdate();
            
            campo_subTotal.setText(String.valueOf((Double.parseDouble(auxSub) - precio_producto)));
            campo_total.setText(String.valueOf((Double.parseDouble(auxSub) - precio_producto)));
            
        } catch (Exception ex) {
            System.out.println("Error no se pudieron guardar los datos de totalFacturas 9");
            System.out.println(ex);
        }
        
        btn_restarAccionado = false;
        // consultaTotal();
    }//GEN-LAST:event_btn_restarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        
        contNumFac += 1;
        
        System.out.println("Factura guardada; num factura mas uno ");
        llenarTabla();
        campo_numFactura.setText(Integer.toString(contNumFac));
        campo_IdCliente.setText("");
        campo_IdEmpleado.setText("");
        campo_NombreCliente.setText("");
        campo_cedula.setText("");
        campo_empleado.setText("");
        campo_cantidad.setText("");
        campo_subTotal.setText("");
        campo_total.setText("");
        combo_producto.removeAllItems();
        
        campo_IdCliente.setEnabled(true);
        campo_IdEmpleado.setEnabled(true);
        

    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void campo_subTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_subTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_subTotalActionPerformed

    private void campo_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_totalActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void campo_numFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_numFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_numFacturaActionPerformed

    private void btn_buscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscaClienteActionPerformed
        Consulta consultas = new Consulta();
        
        if (consultas.existeCliente(Integer.parseInt(campo_IdCliente.getText())) == true) {
            try {
                ResultSet resultado;
                Statement sentencia;
                
                String datos[] = new String[10];
                int idCliente = Integer.parseInt(campo_IdCliente.getText());
                ConexionMySql conec = new ConexionMySql();
                Connection conexion = conec.conectarMySQL();
                String consulta = "SELECT * FROM clientes where id_cliente='" + idCliente + "'";
                sentencia = conexion.createStatement();
                resultado = sentencia.executeQuery(consulta);
                
                while (resultado.next()) {
                    datos[0] = resultado.getString(1);
                    datos[1] = resultado.getString(2);
                    datos[2] = resultado.getString(3);
                    datos[3] = resultado.getString(4);
                    datos[4] = resultado.getString(5);
                    datos[5] = resultado.getString(6);
                    datos[6] = resultado.getString(7);
                    datos[7] = resultado.getString(8);
                    datos[8] = resultado.getString(9);
                    
                }
                
                campo_NombreCliente.setText(datos[2] + " " + datos[3]);
                campo_cedula.setText(datos[1]);
                
                campo_IdCliente.setEnabled(false);
                campo_NombreCliente.setEnabled(false);
                campo_cedula.setEnabled(false);
                
                campo_NombreCliente.setText(datos[2] + " " + datos[3]);
                campo_NombreCliente.setText(datos[2] + " " + datos[3]);
                campo_NombreCliente.setText(datos[2] + " " + datos[3]);
                
            } catch (SQLException ex) {
                Logger.getLogger(VentanaFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
            JOptionPane.showMessageDialog(this, "El CLIENTE NO EXISTE, INGRESE OTRO ID", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            campo_IdCliente.setText("");
            
        }
        

    }//GEN-LAST:event_btn_buscaClienteActionPerformed

    private void campo_NombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_NombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_NombreClienteActionPerformed

    private void campo_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_cedulaActionPerformed

    private void campo_IdEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_IdEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_IdEmpleadoActionPerformed

    private void btn_selecCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selecCategoriaActionPerformed
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        Statement sentencia;
        ResultSet resultado;
        
        String consulta;
        String categoria = (String) combo_categoria.getSelectedItem();
        
        combo_producto.removeAllItems();
        
        consulta = "SELECT descripcion FROM producto WHERE categoria_producto='" + categoria + "'";
        
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(consulta);
            
            String categorias;
            
            while (resultado.next()) {
                
                categorias = resultado.getString(1);
                combo_producto.addItem(categorias);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btn_selecCategoriaActionPerformed

    private void btn_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_empleadoActionPerformed
        
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        Statement sentencia;
        ResultSet resultado;
        
        String consulta;
        int id_empleado = Integer.parseInt(campo_IdEmpleado.getText());
        String nombre_empleado = null;
        consulta = "SELECT nombre_empleado FROM empleado WHERE id_empleado='" + id_empleado + "'";
        
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(consulta);
            
            while (resultado.next()) {
                
                nombre_empleado = resultado.getString(1);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        campo_empleado.setText(nombre_empleado);
        campo_IdEmpleado.setEnabled(false);
    }//GEN-LAST:event_btn_empleadoActionPerformed

    private void campo_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_empleadoActionPerformed

    private void campo_impuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_impuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_impuestosActionPerformed

    private void campo_descuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_descuentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_descuentosActionPerformed

    private void campo_IdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_IdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_IdClienteActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        campo_IdCliente.setEnabled(true);
         campo_IdCliente.setText("");
        campo_NombreCliente.setText("");
        campo_IdEmpleado.setEnabled(true);
        campo_IdEmpleado.setText("");
        campo_empleado.setText("");
        campo_cantidad.setText("");  
        campo_cedula.setText("");  
        combo_producto.removeAllItems();

    }//GEN-LAST:event_btn_cancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_aceptar;
    public javax.swing.JButton btn_agregar;
    public javax.swing.JButton btn_buscaCliente;
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_empleado;
    public javax.swing.JButton btn_restar;
    public javax.swing.JButton btn_selecCategoria;
    public javax.swing.JTextField campo_IdCliente;
    public javax.swing.JTextField campo_IdEmpleado;
    public javax.swing.JTextField campo_NombreCliente;
    public javax.swing.JTextField campo_RUC;
    public javax.swing.JTextField campo_cantidad;
    public javax.swing.JTextField campo_cedula;
    public javax.swing.JTextField campo_descuentos;
    public javax.swing.JTextField campo_empleado;
    public javax.swing.JTextField campo_fecha;
    public javax.swing.JTextField campo_impuestos;
    public javax.swing.JTextField campo_numFactura;
    public javax.swing.JTextField campo_subTotal;
    public javax.swing.JTextField campo_total;
    public javax.swing.JComboBox<String> combo_categoria;
    public javax.swing.JComboBox<String> combo_producto;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lbl_Empleado;
    public javax.swing.JLabel lbl_IDEmpleado;
    public javax.swing.JLabel lbl_IdCliente;
    public javax.swing.JLabel lbl_cantidad;
    public javax.swing.JLabel lbl_cedula;
    public javax.swing.JLabel lbl_cliente;
    public javax.swing.JLabel lbl_descuentos;
    public javax.swing.JLabel lbl_fecha;
    public javax.swing.JLabel lbl_impuestos;
    public javax.swing.JLabel lbl_numFactura;
    public javax.swing.JLabel lbl_producto;
    public javax.swing.JLabel lbl_ruc;
    public javax.swing.JLabel lbl_subtotal;
    public javax.swing.JLabel lbl_total;
    public javax.swing.JTable miTablaF;
    public javax.swing.JTable miTablaFac;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        
        String datos[] = new String[5];
        
        Statement sentencia;
        
        String titulos[] = {"ID", "Descripcion", "Cantidad", "Precio Unitario", "Precio Total"};
        modelo = new DefaultTableModel(null, titulos);
        miTablaF.setModel(modelo);
        
        try {
            String consulta = "SELECT *, cantidad * precio PrecioTotal FROM detalle_factura WHERE CABECERA_FACTURA_num_factura='" + contNumFac + "'";
            sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            
            while (resultado.next()) {
                datos[0] = resultado.getString(7);
                datos[1] = resultado.getString(1);
                datos[2] = resultado.getString(2);
                datos[3] = resultado.getString(3);
                datos[4] = resultado.getString(8);
                modelo.addRow(datos);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    private void consultaTotal() {
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        Statement sentencia;
        ResultSet resultado;
        
        String consulta;
        String subtotal = null;
        String total = null;
        
        consulta = "SELECT subtotal, total FROM totalfacturas WHERE DETALLE_FACTURA_CABECERA_FACTURA_num_factura='" + contNumFac + "'";
        
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(consulta);
            
            while (resultado.next()) {
                
                subtotal = resultado.getString(1);
                total = resultado.getString(2);
                
            }
            campo_subTotal.setText(subtotal);
            campo_total.setText(total);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
