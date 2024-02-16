package Ventanas;

import Clases.ConexionMySql;
import Clases.Datos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class VentanaBuscarProductos extends javax.swing.JDialog {

    private DefaultTableModel modelo;
    public ImageIcon icono = new ImageIcon(getClass().getResource("../Recursos/facturaIcon.png"));

    int idProductoBuscado;
    String descripProdBuscado, catProdBuscado;
    double precioProdBuscado;

    public VentanaBuscarProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setIconImage(icono.getImage());

        initComponents();
        String datos[] = new String[4];
        String titulos[] = {"ID Producto", "Descripción", "Precio", "Categoria",};
        modelo = new DefaultTableModel(null, titulos);
        miTabla2.setModel(modelo);

        miTabla2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (miTabla2.getSelectedRow() != -1) {
                    int fila = miTabla2.getSelectedRow();
                    setIdProductoBuscado(Integer.parseInt(miTabla2.getValueAt(fila, 0).toString()));
                    setDescripProdBuscado(miTabla2.getValueAt(fila, 0).toString());
                    setPrecioProdBuscado(Double.valueOf(miTabla2.getValueAt(fila, 2).toString()));
                    setCatProdBuscado(miTabla2.getValueAt(fila, 3).toString());
                }

            }
        });
    }

    public int getIdProductoBuscado() {
        return idProductoBuscado;
    }

    public void setIdProductoBuscado(int idProductoBuscado) {
        this.idProductoBuscado = idProductoBuscado;
    }

    public String getDescripProdBuscado() {
        return descripProdBuscado;
    }

    public void setDescripProdBuscado(String descripProdBuscado) {
        this.descripProdBuscado = descripProdBuscado;
    }

    public String getCatProdBuscado() {
        return catProdBuscado;
    }

    public void setCatProdBuscado(String catProdBuscado) {
        this.catProdBuscado = catProdBuscado;
    }

    public double getPrecioProdBuscado() {
        return precioProdBuscado;
    }

    public void setPrecioProdBuscado(double precioProdBuscado) {
        this.precioProdBuscado = precioProdBuscado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBusqueda = new javax.swing.ButtonGroup();
        radBot_idProducto = new javax.swing.JRadioButton();
        lblResultados = new javax.swing.JLabel();
        radBot_catProducto = new javax.swing.JRadioButton();
        campoBusqueda = new javax.swing.JTextField();
        lblBuscar1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        miTabla2 = new javax.swing.JTable();
        btn_buscar = new javax.swing.JButton();
        btn_eliminarRegistro = new javax.swing.JButton();
        btn_nuevaBusqueda = new javax.swing.JButton();
        lbl_TipBusqueda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BÚSQUEDA DE PRODUCTOS");

        grupoBusqueda.add(radBot_idProducto);
        radBot_idProducto.setText("ID del Producto");
        radBot_idProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radBot_idProductoMouseClicked(evt);
            }
        });
        radBot_idProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBot_idProductoActionPerformed(evt);
            }
        });

        lblResultados.setText("Resultados:");

        grupoBusqueda.add(radBot_catProducto);
        radBot_catProducto.setText("CATEGORIA");
        radBot_catProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radBot_catProductoMouseClicked(evt);
            }
        });
        radBot_catProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBot_catProductoActionPerformed(evt);
            }
        });

        lblBuscar1.setText("Buscar por:");

        miTabla2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(miTabla2);

        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_eliminarRegistro.setText("Eliminar Registro");
        btn_eliminarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarRegistroActionPerformed(evt);
            }
        });

        btn_nuevaBusqueda.setText("Nueva Busqueda");
        btn_nuevaBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevaBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblResultados)
                            .addComponent(lblBuscar1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radBot_idProducto)
                                .addGap(18, 18, 18)
                                .addComponent(radBot_catProducto)))
                        .addGap(0, 230, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_TipBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btn_eliminarRegistro)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_nuevaBusqueda)
                        .addGap(65, 65, 65)
                        .addComponent(btn_buscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblBuscar1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radBot_idProducto)
                    .addComponent(radBot_catProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addComponent(lbl_TipBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_buscar)
                    .addComponent(btn_nuevaBusqueda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResultados)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_eliminarRegistro)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Ventana para buscar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radBot_idProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBot_idProductoActionPerformed

    }//GEN-LAST:event_radBot_idProductoActionPerformed

    private void radBot_catProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBot_catProductoActionPerformed

    }//GEN-LAST:event_radBot_catProductoActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        buscarProducto();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_eliminarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarRegistroActionPerformed
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        Statement sentencia;
        ResultSet resultado;
        Datos metodo = new Datos();
        String sql;
        int respuesta;
        int id_producto = getIdProductoBuscado();
        double precio_producto = getPrecioProdBuscado();
        String descripProducto = getDescripProdBuscado();
        String categoriaProducto = "";

        if (radBot_idProducto.isSelected() == true) {
            lbl_TipBusqueda.setText("Digite el id del producto");

            if ("".equals(campoBusqueda.getText())) {
                JOptionPane.showMessageDialog(null, "Proporcione un ID");
                campoBusqueda.requestFocusInWindow();
                return;
            } else if (metodo.esNumero(campoBusqueda.getText()) == false) {
                JOptionPane.showMessageDialog(null, "ID inválido (solo se aceptan números)");
                campoBusqueda.requestFocusInWindow();
                return;
            } else {
                respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar al producto con id: " + id_producto);
                if (respuesta == JOptionPane.YES_OPTION) {
                    sql = "DELETE FROM producto WHERE id_producto='" + id_producto + "'";

                    try {
                        sentencia = conexion.createStatement();
                        sentencia.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "El registro con id " + id_producto + " fue borrado");

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    campoBusqueda.requestFocusInWindow();
                    return;
                }

            }

        } else if (radBot_catProducto.isSelected() == true) {
            if ("".equals(campoBusqueda.getText())) {
                JOptionPane.showMessageDialog(null, "Digite una categoria");
                campoBusqueda.requestFocusInWindow();
                return;
            } else if (comprobarCategoria()==false) {
                 JOptionPane.showMessageDialog(null, "Ingreso incorrecto\n" + "Digite una de las categorias válidas");
                campoBusqueda.requestFocusInWindow();
                return;
            } else {
                categoriaProducto = getCatProdBuscado().toUpperCase();
                respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar este productos perteneciente a: " + categoriaProducto);
                if (respuesta == JOptionPane.YES_OPTION) {
                    sql = "DELETE FROM producto WHERE id_producto='" + id_producto + "'";

                    try {
                        sentencia = conexion.createStatement();
                        sentencia.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "El registro con id " + id_producto + "perteneciente a" + categoriaProducto + "\nfue borrado");

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    campoBusqueda.requestFocusInWindow();
                    return;
                }
            }

        }
        String consulta2 = "SELECT * FROM producto WHERE id_producto='" + id_producto + "'";
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(consulta2);
            llenarTabla(resultado);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_btn_eliminarRegistroActionPerformed

    private void btn_nuevaBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevaBusquedaActionPerformed
        campoBusqueda.setText("");
        modelo.setColumnCount(0);

    }//GEN-LAST:event_btn_nuevaBusquedaActionPerformed

    private void radBot_idProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radBot_idProductoMouseClicked
    lbl_TipBusqueda.setText("Digite el ID del producto:");

    }//GEN-LAST:event_radBot_idProductoMouseClicked

    private void radBot_catProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radBot_catProductoMouseClicked

        lbl_TipBusqueda.setText("Categorias:ANABOLICOS, CARBOHIDRATOS,CREATINA, VITAMINAS,PROTEINAS");
    }//GEN-LAST:event_radBot_catProductoMouseClicked

    private void buscarProducto() {
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        Statement sentencia;
        ResultSet resultado;

        Datos metodo = new Datos();
        String consulta;
        int id_producto;
        double precioProducto;
        String descripProducto, catProducto;

        if (radBot_idProducto.isSelected() == true) {
            if ("".equals(campoBusqueda.getText())) {
                JOptionPane.showMessageDialog(null, "Proporcione un ID");
                campoBusqueda.requestFocusInWindow();
                return;
            } else if (metodo.esNumero(campoBusqueda.getText()) == false) {
                JOptionPane.showMessageDialog(null, "ID inválido (solo se aceptan números)");
                campoBusqueda.requestFocusInWindow();
                return;
            } else {
                id_producto = Integer.parseInt(campoBusqueda.getText());
                consulta = "SELECT * FROM producto" + " WHERE id_producto='" + id_producto + "'";

                try {
                    sentencia = conexion.createStatement();
                    resultado = sentencia.executeQuery(consulta);
                    llenarTabla(resultado);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }

        } else if (radBot_catProducto.isSelected() == true) {

            if ("".equals(campoBusqueda.getText())) {
                JOptionPane.showMessageDialog(null, "Digite una categoria");
                campoBusqueda.requestFocusInWindow();
                return;
            } else if (comprobarCategoria()==false) {
                JOptionPane.showMessageDialog(null, "Ingreso incorrecto\n" + "Digite una de las categorias válidas");
                campoBusqueda.requestFocusInWindow();
                return;
            } else {
                catProducto = campoBusqueda.getText().toUpperCase();
                consulta = "SELECT * FROM producto" + " WHERE categoria_producto='" + catProducto + "'";
                try {
                    sentencia = conexion.createStatement();
                    resultado = sentencia.executeQuery(consulta);
                    llenarTabla(resultado);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }

        } else {
            campoBusqueda.requestFocusInWindow();
            return;
        }

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaBuscarProductos dialog = new VentanaBuscarProductos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminarRegistro;
    private javax.swing.JButton btn_nuevaBusqueda;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.ButtonGroup grupoBusqueda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar1;
    private javax.swing.JLabel lblResultados;
    private javax.swing.JLabel lbl_TipBusqueda;
    private javax.swing.JTable miTabla2;
    private javax.swing.JRadioButton radBot_catProducto;
    private javax.swing.JRadioButton radBot_idProducto;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla(ResultSet resultado) {

        String datos[] = new String[5];

        Statement sentencia;

        String titulos[] = {"ID Producto", "Descripción", "Precio", "Categoría"};

        modelo = new DefaultTableModel(null, titulos);
        miTabla2.setModel(modelo);
        try {

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
    
    private boolean comprobarCategoria(){
     switch (campoBusqueda.getText()) {
            case "ANABOLICOS":
                return true;
            case "CARBOHIDRATOS":
                return true;
            
            case "CREATINA":
                return true;
            case "VITAMINAS":
                return true;
            case "PROTEINAS":
                return true;
        }
        return false;
    
    }
}
