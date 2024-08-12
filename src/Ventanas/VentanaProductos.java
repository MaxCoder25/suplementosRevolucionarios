package Ventanas;

import Clases.Actualizar;
import Clases.ConexionMySql;
import Clases.Datos;
import Clases.Insertar;
import Clases.Producto;
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

public class VentanaProductos extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo;
    Insertar insertarEnBase = new Insertar();
    private boolean btnModificarAccionado = false;
    
    public VentanaProductos() {
        initComponents();
        llenarTabla();
        
        miTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (miTabla.getSelectedRow() != -1) {
                    int fila = miTabla.getSelectedRow();
                    campoIDproducto.setText(miTabla.getValueAt(fila, 0).toString());
                    campoDescripProd.setText(miTabla.getValueAt(fila, 1).toString());
                    campoPrecioProd.setText(miTabla.getValueAt(fila, 2).toString());
                    combo_Categorias.setEditable(true);
                    combo_Categorias.setSelectedItem(miTabla.getValueAt(fila, 3));
                }
                
            }
            
        });
        combo_Categorias.setEditable(false);
        
    }
    
    private void llenarTabla() {
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        String consulta = "SELECT * FROM producto";
        String datos[] = new String[5];
        
        Statement sentencia;
        
        String titulos[] = {"ID Producto", "Descripción", "Precio", "Categoría"};
        
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
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void validacionesCampos() {
        Datos metodo = new Datos();
        String itemSeleccionado = (String) combo_Categorias.getSelectedItem();
        
        if (campoIDproducto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Digite una identificación para el producto");
            campoIDproducto.requestFocusInWindow();
            return;
        } else if (metodo.esNumero(campoIDproducto.getText()) == false) {
            JOptionPane.showMessageDialog(this, "El id del producto debe de ser numérico ");
            campoIDproducto.requestFocusInWindow();
            return;
        } else if (campoIDproducto.getText().length() != 5) {
            JOptionPane.showMessageDialog(this, "El id del producto debe tener una longitud de 5 números");
            campoIDproducto.requestFocusInWindow();
            return;
        }
        
        if (campoDescripProd.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese alguna descripción del producto");
            campoDescripProd.requestFocusInWindow();
            return;
        }
        
        if (campoPrecioProd.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese el precio del producto");
            campoPrecioProd.requestFocusInWindow();
            return;
        } else if (metodo.esNumeroDoble(campoPrecioProd.getText()) == false) {
            JOptionPane.showMessageDialog(this, "El precio ingresado es incorrecto");
            campoDescripProd.requestFocusInWindow();
            return;
        } else if (Double.valueOf(campoPrecioProd.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Ingrese un precio para el producto");
            campoPrecioProd.requestFocusInWindow();
            return;
        }
        
        if ("Seleccione Categoría".equals(itemSeleccionado)) {
            JOptionPane.showMessageDialog(this, "Seleccione una categoria para el producto");
            combo_Categorias.requestFocusInWindow();
            return;
            
        }
    }
    
    public String seleccionCategoria() {
        String itemSeleccionado = (String) combo_Categorias.getSelectedItem();
        
        System.out.println("selecciono " + itemSeleccionado);
        switch (itemSeleccionado) {
            case "1) ANABÓLICOS":
                return "ANABÓLICOS";
            case "2) CARBOHIDRATOS":
                return "CARBOHIDRATOS";
            
            case "3) CREATINA":
                return "CREATINA";
            case "4) VITAMINAS":
                return "VITAMINAS";
            case "5) PROTEINAS":
                return "PROTEINAS";
        }
        return "N";
    }
    
    public Producto dar_valores() {
        Producto nProducto = null;
        int idProducto = Integer.parseInt(campoIDproducto.getText());
        String descripProducto = campoDescripProd.getText();
        double precioProducto = Double.valueOf(campoPrecioProd.getText());
        String categoriaProducto = seleccionCategoria();
        nProducto = new Producto(idProducto, descripProducto, precioProducto, categoriaProducto);
        return nProducto;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_IdProducto = new javax.swing.JLabel();
        lbl_Descripcion = new javax.swing.JLabel();
        lbl_Categoria = new javax.swing.JLabel();
        campoIDproducto = new javax.swing.JTextField();
        campoDescripProd = new javax.swing.JTextField();
        lbl_NombreCliente = new javax.swing.JLabel();
        campoPrecioProd = new javax.swing.JTextField();
        combo_Categorias = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        lblNota = new javax.swing.JLabel();
        btn_primero = new javax.swing.JButton();
        btn_anterior = new javax.swing.JButton();
        btn_siguiente = new javax.swing.JButton();
        btn_ultimo = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        miTabla = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ventana de Productos");
        setEnabled(false);

        lbl_IdProducto.setText("ID del Producto:*");

        lbl_Descripcion.setText("Descripción del producto:*");

        lbl_Categoria.setText("Seleccione Categoria:*");

        campoIDproducto.setEnabled(false);
        campoIDproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoIDproductoKeyPressed(evt);
            }
        });

        campoDescripProd.setEnabled(false);
        campoDescripProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoDescripProdKeyPressed(evt);
            }
        });

        lbl_NombreCliente.setText("Precio:*");

        campoPrecioProd.setEnabled(false);
        campoPrecioProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoPrecioProdKeyPressed(evt);
            }
        });

        combo_Categorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Categoría", "1) ANABÓLICOS", "2) CARBOHIDRATOS", "3) CREATINA", "4) VITAMINAS", "5) PROTEINAS", " " }));
        combo_Categorias.setEnabled(false);
        combo_Categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_CategoriasActionPerformed(evt);
            }
        });

        jLabel1.setText("$");

        lblProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Ingreso_Productos.png"))); // NOI18N

        lblNota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNota.setForeground(new java.awt.Color(0, 102, 204));
        lblNota.setText("* Campos Obligatorios");

        btn_primero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/primero.png"))); // NOI18N
        btn_primero.setToolTipText("Ir al primer registro");

        btn_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/anterior.png"))); // NOI18N
        btn_anterior.setToolTipText("Ir al registro anterior");

        btn_siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/siguiente.png"))); // NOI18N
        btn_siguiente.setToolTipText("Ir al registro siguiente");

        btn_ultimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ultimo.png"))); // NOI18N
        btn_ultimo.setToolTipText("Ir al ultimo registro");
        btn_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ultimoActionPerformed(evt);
            }
        });

        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/actualizar.png"))); // NOI18N
        btn_actualizar.setToolTipText("Actualizar registro");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

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

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancelar.png"))); // NOI18N
        btn_cancelar.setToolTipText("Cancelar");
        btn_cancelar.setEnabled(false);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_Categoria)
                                        .addComponent(lbl_IdProducto))
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lbl_Descripcion)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoIDproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblNota)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(combo_Categorias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(campoDescripProd, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbl_NombreCliente)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoPrecioProd, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(24, 24, 24)
                            .addComponent(lblProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btn_primero, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_IdProducto)
                            .addComponent(campoIDproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Descripcion)
                            .addComponent(campoDescripProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_NombreCliente)
                            .addComponent(campoPrecioProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Categoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(lblNota)
                        .addGap(38, 38, 38)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_ultimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_siguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_anterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_primero)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_CategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_CategoriasActionPerformed

    }//GEN-LAST:event_combo_CategoriasActionPerformed

    private void btn_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ultimoActionPerformed

    }//GEN-LAST:event_btn_ultimoActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        llenarTabla();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed

        //doy foco en el primer campo
        campoIDproducto.requestFocusInWindow();

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
        campoIDproducto.setEnabled(true);
        campoDescripProd.setEnabled(true);
        campoPrecioProd.setEnabled(true);
        combo_Categorias.setEditable(false);
        combo_Categorias.setEnabled(true);

        //para limpiar los campos
        campoIDproducto.setText("");
        campoDescripProd.setText("");
        campoPrecioProd.setText("");

    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

        //doy foco en el primer campo
        campoIDproducto.requestFocusInWindow();

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
        campoIDproducto.setEnabled(false);
        campoDescripProd.setEnabled(true);
        campoPrecioProd.setEnabled(true);
        combo_Categorias.setEditable(false);
        combo_Categorias.setEnabled(true);
        
        JOptionPane.showMessageDialog(this, "Es obligatorio seleccionar una cateogira para el producto", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        
        btnModificarAccionado = true;
    }//GEN-LAST:event_btn_modificarActionPerformed

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
        campoIDproducto.setEnabled(false);
        campoDescripProd.setEnabled(false);
        campoPrecioProd.setEnabled(false);
        combo_Categorias.setEnabled(false);

        //Para guardar los valores
        if (btnModificarAccionado == true) {
            Actualizar metodo = new Actualizar();
            int idProducto;
            String descripProducto, categoriaProducto;
            double precioProducto;
            
            idProducto = Integer.parseInt(campoIDproducto.getText());
            descripProducto = campoDescripProd.getText();
            categoriaProducto = seleccionCategoria();
            precioProducto = Double.parseDouble(campoPrecioProd.getText());
            metodo.actualizarRegistroProducto(idProducto, descripProducto, precioProducto, categoriaProducto);
            
        } else {
            Producto nuevoProducto = null;
            nuevoProducto = dar_valores();
            insertarEnBase.guardarDatos(nuevoProducto);
            
        }
        
        llenarTabla();

    }//GEN-LAST:event_btn_guardarActionPerformed

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

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        VentanaBuscarProductos vtnBuscarEliminar = new VentanaBuscarProductos(null, closable);
        vtnBuscarEliminar.setLocationRelativeTo(null);
        vtnBuscarEliminar.setVisible(true);
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        VentanaBuscarProductos vtnBuscar = new VentanaBuscarProductos(null, closable);
        vtnBuscar.setLocationRelativeTo(null);
        vtnBuscar.setVisible(true);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void campoIDproductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoIDproductoKeyPressed
        campoIDproducto.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            campoDescripProd.requestFocus();
        }
    }//GEN-LAST:event_campoIDproductoKeyPressed

    private void campoDescripProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDescripProdKeyPressed
        campoDescripProd.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            campoPrecioProd.requestFocus();
        }
    }//GEN-LAST:event_campoDescripProdKeyPressed

    private void campoPrecioProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPrecioProdKeyPressed
        campoPrecioProd.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            combo_Categorias.requestFocus();
        }
    }//GEN-LAST:event_campoPrecioProdKeyPressed


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
    private javax.swing.JTextField campoDescripProd;
    private javax.swing.JTextField campoIDproducto;
    private javax.swing.JTextField campoPrecioProd;
    private javax.swing.JComboBox<String> combo_Categorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lbl_Categoria;
    private javax.swing.JLabel lbl_Descripcion;
    private javax.swing.JLabel lbl_IdProducto;
    private javax.swing.JLabel lbl_NombreCliente;
    private javax.swing.JTable miTabla;
    // End of variables declaration//GEN-END:variables
}
