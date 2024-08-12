package Ventanas;

import Clases.Actualizar;
import Clases.Datos;
import Clases.Cliente;
import Clases.ConexionMySql;
import Clases.Insertar;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class VentanaClientes extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    Insertar insertarEnBase = new Insertar();
    int clienteActual = 0;
    private boolean btnModificarAccionado = false;

    public VentanaClientes() {
        initComponents();
        llenarTabla();

        miTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (miTabla.getSelectedRow() != -1) {
                    int fila = miTabla.getSelectedRow();
                    campoIDcliente.setText(miTabla.getValueAt(fila, 0).toString());
                    campoCedulaCliente.setText(miTabla.getValueAt(fila, 1).toString());
                    campoNombreCliente.setText(miTabla.getValueAt(fila, 2).toString());
                    campoApellidoCliente.setText(miTabla.getValueAt(fila, 3).toString());
                    campoDirCliente.setText(miTabla.getValueAt(fila, 4).toString());
                    campoTlfCliente.setText(miTabla.getValueAt(fila, 5).toString());
                    campoEmailCliente.setText(miTabla.getValueAt(fila, 6).toString());
                    combo_Genero.setEditable(true);
                    combo_Genero.setSelectedItem(miTabla.getValueAt(fila, 7));
                    campoOtrosDetalles.setText(miTabla.getValueAt(fila, 8).toString());

                }

            }

        });
        combo_Genero.setEditable(false);

    }

    public Cliente dar_valores() {
        Cliente nCliente = null;
        int idCliente = Integer.parseInt(campoIDcliente.getText());
        int cedulaCliente = Integer.parseInt(campoCedulaCliente.getText());
        String nombreCliente = campoNombreCliente.getText();
        String apellidoCliente = campoApellidoCliente.getText();
        String dirCliente = campoDirCliente.getText();
        int tlfCliente = Integer.parseInt(campoTlfCliente.getText());
        String emailCliente = campoEmailCliente.getText();
        char generoCliente = seleccionGenero();
        String otrosDetalles = campoOtrosDetalles.getText();

        nCliente = new Cliente(idCliente, cedulaCliente, nombreCliente, apellidoCliente, dirCliente, tlfCliente, emailCliente, generoCliente, otrosDetalles);
        return nCliente;
    }

    public char seleccionGenero() {
        String itemSeleccionado = (String) combo_Genero.getSelectedItem();

        System.out.println("selecciono " + itemSeleccionado);
        switch (itemSeleccionado) {
            case "Hombre":
                return 'H';
            case "Mujer":
                return 'M';
        }
        return 'O';
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_IdCliente = new javax.swing.JLabel();
        campoIDcliente = new javax.swing.JTextField();
        lbl_Cedula = new javax.swing.JLabel();
        campoCedulaCliente = new javax.swing.JTextField();
        lbl_NombreCliente = new javax.swing.JLabel();
        lbl_ApellidoCliente = new javax.swing.JLabel();
        campoNombreCliente = new javax.swing.JTextField();
        campoApellidoCliente = new javax.swing.JTextField();
        lbl_DirCliente = new javax.swing.JLabel();
        campoDirCliente = new javax.swing.JTextField();
        lbl_tlfCliente = new javax.swing.JLabel();
        campoTlfCliente = new javax.swing.JTextField();
        lbl_emailCliente = new javax.swing.JLabel();
        campoEmailCliente = new javax.swing.JTextField();
        campoNota = new javax.swing.JLabel();
        lbl_DetallesCliente = new javax.swing.JLabel();
        campoOtrosDetalles = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        btn_primero = new javax.swing.JButton();
        btn_ultimo = new javax.swing.JButton();
        btn_anterior = new javax.swing.JButton();
        btn_siguiente = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        miTabla = new javax.swing.JTable();
        btn_actualizar = new javax.swing.JButton();
        lbl_tlfCliente1 = new javax.swing.JLabel();
        combo_Genero = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");
        setEnabled(false);

        lbl_IdCliente.setText("ID del Cliente:*");

        campoIDcliente.setEnabled(false);
        campoIDcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoIDclienteKeyPressed(evt);
            }
        });

        lbl_Cedula.setText("Cédula:*");

        campoCedulaCliente.setEnabled(false);
        campoCedulaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoCedulaClienteKeyPressed(evt);
            }
        });

        lbl_NombreCliente.setText("Nombre:*");

        lbl_ApellidoCliente.setText("Apellido:*");

        campoNombreCliente.setEnabled(false);
        campoNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNombreClienteKeyPressed(evt);
            }
        });

        campoApellidoCliente.setEnabled(false);
        campoApellidoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoApellidoClienteKeyPressed(evt);
            }
        });

        lbl_DirCliente.setText("Dirección Domicilio:");

        campoDirCliente.setEnabled(false);
        campoDirCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoDirClienteKeyPressed(evt);
            }
        });

        lbl_tlfCliente.setText("Teléfono:");

        campoTlfCliente.setEnabled(false);
        campoTlfCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTlfClienteKeyPressed(evt);
            }
        });

        lbl_emailCliente.setText("E-mail:");

        campoEmailCliente.setEnabled(false);
        campoEmailCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoEmailClienteKeyPressed(evt);
            }
        });

        campoNota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        campoNota.setForeground(new java.awt.Color(0, 102, 204));
        campoNota.setText("* Campos Obligatorios");

        lbl_DetallesCliente.setText("Otros Detalles:");

        campoOtrosDetalles.setEnabled(false);

        lblCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/IngresoClientes.png"))); // NOI18N

        btn_primero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/primero.png"))); // NOI18N
        btn_primero.setToolTipText("Ir al primer registro");

        btn_ultimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ultimo.png"))); // NOI18N
        btn_ultimo.setToolTipText("Ir al ultimo registro");
        btn_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ultimoActionPerformed(evt);
            }
        });

        btn_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/anterior.png"))); // NOI18N
        btn_anterior.setToolTipText("Ir al registro anterior");

        btn_siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/siguiente.png"))); // NOI18N
        btn_siguiente.setToolTipText("Ir al registro siguiente");

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/nuevo.png"))); // NOI18N
        btn_nuevo.setToolTipText("Crear nuevo registro");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/modificar.png"))); // NOI18N
        btn_modificar.setToolTipText("Modificar registro");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/guardar.png"))); // NOI18N
        btn_guardar.setToolTipText("Guardar registro");
        btn_guardar.setEnabled(false);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/borrar.png"))); // NOI18N
        btn_borrar.setToolTipText("Borrar registro");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscar.png"))); // NOI18N
        btn_buscar.setToolTipText("Buscar registro");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancelar.png"))); // NOI18N
        btn_cancelar.setToolTipText("Cancelar");
        btn_cancelar.setEnabled(false);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        miTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(miTabla);

        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/actualizar.png"))); // NOI18N
        btn_actualizar.setToolTipText("Actualizar registro");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        lbl_tlfCliente1.setText("Género:");

        combo_Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Genero", "Hombre", "Mujer", "Otro" }));
        combo_Genero.setEnabled(false);
        combo_Genero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_GeneroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_IdCliente)
                            .addComponent(lbl_Cedula)
                            .addComponent(lbl_NombreCliente)
                            .addComponent(lbl_ApellidoCliente)
                            .addComponent(lbl_DirCliente)
                            .addComponent(lbl_emailCliente)
                            .addComponent(lbl_DetallesCliente))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoNombreCliente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoApellidoCliente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoDirCliente)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(campoCedulaCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(campoIDcliente, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoOtrosDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_tlfCliente1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(combo_Genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)
                                        .addComponent(lbl_tlfCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoTlfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(31, 31, 31)
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoNota)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_primero, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_IdCliente)
                            .addComponent(campoIDcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Cedula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_NombreCliente)
                            .addComponent(campoNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_ApellidoCliente)
                            .addComponent(campoApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_DirCliente)
                            .addComponent(campoDirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_emailCliente)
                    .addComponent(campoEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTlfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_tlfCliente))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_Genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_tlfCliente1)
                    .addComponent(lbl_DetallesCliente)
                    .addComponent(campoOtrosDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(campoNota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_siguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_primero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ultimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_anterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        //validaciones
        validacionesCampos();

        btn_primero.setEnabled(true);
        btn_anterior.setEnabled(true);
        btn_siguiente.setEnabled(true);
        btn_ultimo.setEnabled(true);
        btn_nuevo.setEnabled(true);

        btn_modificar.setEnabled(true);
        btn_guardar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        btn_borrar.setEnabled(true);
        btn_buscar.setEnabled(true);

        //para deshabilitar campos
        campoIDcliente.setEnabled(false);
        campoCedulaCliente.setEnabled(false);
        campoNombreCliente.setEnabled(false);
        campoApellidoCliente.setEnabled(false);
        campoDirCliente.setEnabled(false);
        campoEmailCliente.setEnabled(false);
        campoTlfCliente.setEnabled(false);
        campoOtrosDetalles.setEnabled(false);
        combo_Genero.setEnabled(false);

        //Para guardar los valores
        if (btnModificarAccionado == true) {
        
        Actualizar metodo = new Actualizar();
        int idCliente,cedulaCliente,tlfCliente;
        String nombreCliente,apellidoCliente,dirCliente,emailCliente,otrosDetalles;
        char generoCliente;
        
        idCliente=Integer.parseInt(campoIDcliente.getText());
        tlfCliente=Integer.parseInt(campoTlfCliente.getText());
        cedulaCliente=Integer.parseInt(campoCedulaCliente.getText());
        nombreCliente=campoNombreCliente.getText();
        apellidoCliente=campoApellidoCliente.getText();
        dirCliente=campoDirCliente.getText();
        emailCliente=campoEmailCliente.getText();
        otrosDetalles=campoOtrosDetalles.getText();
        generoCliente=seleccionGenero();
        metodo.actualizarRegistroCliente(idCliente, cedulaCliente, nombreCliente, apellidoCliente, dirCliente, tlfCliente, emailCliente, generoCliente, otrosDetalles);
        
        } else {
            //agrega nuevo cliente
            Cliente nuevoCliente = null;
            nuevoCliente = dar_valores();
            insertarEnBase.guardarDatos(nuevoCliente);
        }


        llenarTabla();

        btnModificarAccionado = false;
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed

        //doy foco en el primer campo
        campoIDcliente.requestFocusInWindow();

        //para habilitar botones
        btn_primero.setEnabled(false);
        btn_anterior.setEnabled(false);
        btn_siguiente.setEnabled(false);
        btn_ultimo.setEnabled(false);
        btn_nuevo.setEnabled(false);

        btn_modificar.setEnabled(false);
        btn_guardar.setEnabled(true);
        btn_cancelar.setEnabled(true);
        btn_borrar.setEnabled(false);
        btn_buscar.setEnabled(false);
        //para habilitar campos
        campoIDcliente.setEnabled(true);
        campoCedulaCliente.setEnabled(true);
        campoNombreCliente.setEnabled(true);
        campoApellidoCliente.setEnabled(true);
        campoDirCliente.setEnabled(true);
        campoEmailCliente.setEnabled(true);
        campoTlfCliente.setEnabled(true);
        campoOtrosDetalles.setEnabled(true);
        combo_Genero.setEditable(false);
        combo_Genero.setEnabled(true);

        //para limpiar los campos
        campoIDcliente.setText("");
        campoCedulaCliente.setText("");
        campoNombreCliente.setText("");
        campoApellidoCliente.setText("");
        campoDirCliente.setText("");
        campoEmailCliente.setText("");
        campoTlfCliente.setText("");
        campoOtrosDetalles.setText("");


    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        btn_primero.setEnabled(true);
        btn_anterior.setEnabled(true);
        btn_siguiente.setEnabled(true);
        btn_ultimo.setEnabled(true);
        btn_nuevo.setEnabled(true);

        btn_modificar.setEnabled(true);
        btn_guardar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        btn_borrar.setEnabled(true);
        btn_buscar.setEnabled(true);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

        //doy foco en el primer campo
        campoCedulaCliente.requestFocusInWindow();

        //para habilitar botones
        btn_primero.setEnabled(false);
        btn_anterior.setEnabled(false);
        btn_siguiente.setEnabled(false);
        btn_ultimo.setEnabled(false);
        btn_nuevo.setEnabled(false);

        btn_modificar.setEnabled(false);
        btn_guardar.setEnabled(true);
        btn_cancelar.setEnabled(true);
        btn_borrar.setEnabled(false);
        btn_buscar.setEnabled(false);
        //para habilitar campos
        campoIDcliente.setEnabled(false);  //id cliente modificar
        campoCedulaCliente.setEnabled(true);
        campoNombreCliente.setEnabled(true);
        campoApellidoCliente.setEnabled(true);
        campoDirCliente.setEnabled(true);
        campoEmailCliente.setEnabled(true);
        campoTlfCliente.setEnabled(true);
        campoOtrosDetalles.setEnabled(true);
        combo_Genero.setEditable(false);
        combo_Genero.setEnabled(true);
        JOptionPane.showMessageDialog(this, "Es obligatorio seleccionar un género para cliente", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        btnModificarAccionado = true;
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ultimoActionPerformed
        //OJOJOJOJOJOJO

//        Consulta consultarEnBase= new Consulta();
//       clienteActual=consultarEnBase.numeroClientes()-1;
//       
//       llenarTabla();

    }//GEN-LAST:event_btn_ultimoActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        VentanaBuscar vtnBuscar = new VentanaBuscar(null, closable);
        vtnBuscar.setLocationRelativeTo(null);
        vtnBuscar.setVisible(true);

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        VentanaBuscar vtnBuscarEliminar = new VentanaBuscar(null, closable);
        vtnBuscarEliminar.setLocationRelativeTo(null);
        vtnBuscarEliminar.setVisible(true);
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        llenarTabla();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void campoIDclienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoIDclienteKeyPressed
        campoIDcliente.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            campoCedulaCliente.requestFocus();
        }
    }//GEN-LAST:event_campoIDclienteKeyPressed

    private void campoCedulaClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCedulaClienteKeyPressed
        campoCedulaCliente.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            campoNombreCliente.requestFocus();
        }

    }//GEN-LAST:event_campoCedulaClienteKeyPressed

    private void campoNombreClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreClienteKeyPressed
        campoNombreCliente.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            campoApellidoCliente.requestFocus();
        }

    }//GEN-LAST:event_campoNombreClienteKeyPressed

    private void campoApellidoClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoApellidoClienteKeyPressed
        campoApellidoCliente.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            campoDirCliente.requestFocus();
        }
    }//GEN-LAST:event_campoApellidoClienteKeyPressed

    private void campoDirClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDirClienteKeyPressed
        campoDirCliente.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            campoEmailCliente.requestFocus();
        }
    }//GEN-LAST:event_campoDirClienteKeyPressed

    private void campoEmailClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoEmailClienteKeyPressed
        campoEmailCliente.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            campoTlfCliente.requestFocus();
        }
    }//GEN-LAST:event_campoEmailClienteKeyPressed

    private void campoTlfClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTlfClienteKeyPressed
        campoTlfCliente.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            campoOtrosDetalles.requestFocus();
        }
    }//GEN-LAST:event_campoTlfClienteKeyPressed

    private void combo_GeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_GeneroActionPerformed

    }//GEN-LAST:event_combo_GeneroActionPerformed

    private void llenarTabla() {
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        String consulta = "SELECT * FROM clientes";
        String datos[] = new String[10];

        Statement sentencia;

        String titulos[] = {"ID Cliente", "Cédula", "Nombres", "Apellidos", "Dirección", "Teléfono",
            "Email", "Género", "Otros Detalles"};

        modelo = new DefaultTableModel(null, titulos);
        miTabla.setModel(modelo);
        try {
            sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

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

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void validacionesCampos() {
        Datos metodo = new Datos();
        String itemSeleccionado = (String) combo_Genero.getSelectedItem();

        if (campoIDcliente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Digite una identificación para el cliente");
            campoIDcliente.requestFocusInWindow();
            return;
        } else if (metodo.esNumero(campoIDcliente.getText()) == false) {
            JOptionPane.showMessageDialog(this, "El id del cliente debe de ser numérico ");
            campoIDcliente.requestFocusInWindow();
            return;
        } else if (campoIDcliente.getText().length() != 6) {
            JOptionPane.showMessageDialog(this, "El id del cliente debe tener una longitud de 6 números");
            campoIDcliente.requestFocusInWindow();
            return;
        }

        if (campoCedulaCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese un numero de cédula");
            campoCedulaCliente.requestFocusInWindow();
            return;
        } else if (metodo.esNumero(campoCedulaCliente.getText()) == false) {
            JOptionPane.showMessageDialog(this, "La cédula debe de ser un número ");
            campoCedulaCliente.requestFocusInWindow();
            return;
        } else if (campoCedulaCliente.getText().length() != 10) {
            JOptionPane.showMessageDialog(this, "La cédula ingresada no tiene 10 números, es inválida");
            campoCedulaCliente.requestFocusInWindow();
            return;
        }

        if (campoNombreCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del cliente");
            campoNombreCliente.requestFocusInWindow();
            return;
        }

        if (campoApellidoCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese el apellido del cliente");
            campoApellidoCliente.requestFocusInWindow();
            return;
        }

        if (campoDirCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese la dirección del cliente");
            campoDirCliente.requestFocusInWindow();
            return;
        }

        if (campoEmailCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese el email del cliente");
            campoEmailCliente.requestFocusInWindow();
            return;
        }

        if (campoTlfCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese el número de teléfono del cliente");
            campoTlfCliente.requestFocusInWindow();
            return;
        } else if (metodo.esNumero(campoTlfCliente.getText()) == false) {
            JOptionPane.showMessageDialog(this, "El teléfono ingresado es incorrecto ");
            campoTlfCliente.requestFocusInWindow();
            return;
        } else if (campoTlfCliente.getText().length() < 6) {
            JOptionPane.showMessageDialog(this, "El teléfono ingresado es incorrecto ");
            campoTlfCliente.requestFocusInWindow();
            return;
        }

        if ("Seleccione Genero".equals(itemSeleccionado)) {
            JOptionPane.showMessageDialog(this, "Seleccione el género del cliente");
            combo_Genero.requestFocusInWindow();
            return;

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_anterior;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_primero;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.JButton btn_ultimo;
    private javax.swing.JTextField campoApellidoCliente;
    private javax.swing.JTextField campoCedulaCliente;
    private javax.swing.JTextField campoDirCliente;
    private javax.swing.JTextField campoEmailCliente;
    private javax.swing.JTextField campoIDcliente;
    private javax.swing.JTextField campoNombreCliente;
    private javax.swing.JLabel campoNota;
    private javax.swing.JTextField campoOtrosDetalles;
    private javax.swing.JTextField campoTlfCliente;
    private javax.swing.JComboBox<String> combo_Genero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lbl_ApellidoCliente;
    private javax.swing.JLabel lbl_Cedula;
    private javax.swing.JLabel lbl_DetallesCliente;
    private javax.swing.JLabel lbl_DirCliente;
    private javax.swing.JLabel lbl_IdCliente;
    private javax.swing.JLabel lbl_NombreCliente;
    private javax.swing.JLabel lbl_emailCliente;
    private javax.swing.JLabel lbl_tlfCliente;
    private javax.swing.JLabel lbl_tlfCliente1;
    private javax.swing.JTable miTabla;
    // End of variables declaration//GEN-END:variables
}
