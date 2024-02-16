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

public class VentanaBuscar extends javax.swing.JDialog {

    private DefaultTableModel modelo;
    public ImageIcon icono = new ImageIcon(getClass().getResource("../Recursos/facturaIcon.png"));

    int idClientebuscado;
    String nombreClientebuscado, apellClientebuscado;
    int cedulaClientebuscado;

    public VentanaBuscar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setIconImage(icono.getImage());

        initComponents();

        String datos[] = new String[4];
        String titulos[] = {"ID Cliente", "Cédula", "Nombres", "Apellidos",};
        modelo = new DefaultTableModel(null, titulos);
        miTabla2.setModel(modelo);

        miTabla2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (miTabla2.getSelectedRow() != -1) {
                    int fila = miTabla2.getSelectedRow();
                    setIdClientebuscado(Integer.parseInt(miTabla2.getValueAt(fila, 0).toString()));
                    setCedulaClientebuscado(Integer.parseInt(miTabla2.getValueAt(fila, 1).toString()));
                    setNombreClientebuscado(miTabla2.getValueAt(fila, 2).toString());
                    setApellClientebuscado(miTabla2.getValueAt(fila, 3).toString());
                }

            }
        });

    }

    public int getIdClientebuscado() {
        return idClientebuscado;
    }

    public void setIdClientebuscado(int idClientebuscado) {
        this.idClientebuscado = idClientebuscado;
    }

    public String getNombreClientebuscado() {
        return nombreClientebuscado;
    }

    public void setNombreClientebuscado(String nombreClientebuscado) {
        this.nombreClientebuscado = nombreClientebuscado;
    }

    public String getApellClientebuscado() {
        return apellClientebuscado;
    }

    public void setApellClientebuscado(String apellClientebuscado) {
        this.apellClientebuscado = apellClientebuscado;
    }

    public int getCedulaClientebuscado() {
        return cedulaClientebuscado;
    }

    public void setCedulaClientebuscado(int cedulaClientebuscado) {
        this.cedulaClientebuscado = cedulaClientebuscado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBusqueda = new javax.swing.ButtonGroup();
        radBot_idCliente = new javax.swing.JRadioButton();
        lblResultados = new javax.swing.JLabel();
        radBot_cedCliente = new javax.swing.JRadioButton();
        radBot_nombreCliente = new javax.swing.JRadioButton();
        campoBusqueda = new javax.swing.JTextField();
        lblBuscar1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        miTabla2 = new javax.swing.JTable();
        btn_buscar = new javax.swing.JButton();
        btn_eliminarRegistro = new javax.swing.JButton();
        btn_nuevaBusqueda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BÚSQUEDA DE CLIENTES");

        grupoBusqueda.add(radBot_idCliente);
        radBot_idCliente.setText("ID del Cliente");
        radBot_idCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBot_idClienteActionPerformed(evt);
            }
        });

        lblResultados.setText("Resultados:");

        grupoBusqueda.add(radBot_cedCliente);
        radBot_cedCliente.setText("Cedula ");
        radBot_cedCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBot_cedClienteActionPerformed(evt);
            }
        });

        grupoBusqueda.add(radBot_nombreCliente);
        radBot_nombreCliente.setText("Nombre ");
        radBot_nombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBot_nombreClienteActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblResultados))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblBuscar1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(radBot_idCliente)
                                .addGap(18, 18, 18)
                                .addComponent(radBot_cedCliente)
                                .addGap(18, 18, 18)
                                .addComponent(radBot_nombreCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_nuevaBusqueda)
                                        .addGap(65, 65, 65)
                                        .addComponent(btn_buscar))
                                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_eliminarRegistro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblBuscar1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radBot_idCliente)
                    .addComponent(radBot_cedCliente)
                    .addComponent(radBot_nombreCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_buscar)
                    .addComponent(btn_nuevaBusqueda))
                .addGap(11, 11, 11)
                .addComponent(lblResultados)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_eliminarRegistro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Ventana para buscar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radBot_idClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBot_idClienteActionPerformed

    }//GEN-LAST:event_radBot_idClienteActionPerformed

    private void radBot_cedClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBot_cedClienteActionPerformed

    }//GEN-LAST:event_radBot_cedClienteActionPerformed

    private void radBot_nombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBot_nombreClienteActionPerformed

    }//GEN-LAST:event_radBot_nombreClienteActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        buscarCliente();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_eliminarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarRegistroActionPerformed
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        Statement sentencia;
        ResultSet resultado;
        Datos metodo = new Datos();
        String sql;
        int respuesta;
        int id_cliente = getIdClientebuscado();
        int cedulaCliente = getCedulaClientebuscado();
        String nombreCliente = getNombreClientebuscado();

        if (radBot_idCliente.isSelected() == true) {
            if ("".equals(campoBusqueda.getText())) {
                JOptionPane.showMessageDialog(null, "Proporcione un ID");
                campoBusqueda.requestFocusInWindow();
                return;
            } else if (metodo.esNumero(campoBusqueda.getText()) == false) {
                JOptionPane.showMessageDialog(null, "ID inválido (solo se aceptan números)");
                campoBusqueda.requestFocusInWindow();
                return;
            } else {
                //id_cliente = Integer.parseInt(campoBusqueda.getText());
                respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar al cliente con id: " + id_cliente);
                if (respuesta == JOptionPane.YES_OPTION) {
                    sql = "DELETE FROM clientes WHERE id_cliente='" + id_cliente + "'";

                    try {
                        sentencia = conexion.createStatement();
                        sentencia.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "El registro con id " + id_cliente + " fue borrado");

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    campoBusqueda.requestFocusInWindow();
                    return;
                }

            }

        } else if (radBot_cedCliente.isSelected() == true) {

            if ("".equals(campoBusqueda.getText())) {
                JOptionPane.showMessageDialog(null, "Proporcione un cédula de identidad");
                campoBusqueda.requestFocusInWindow();
                return;
            } else if (metodo.esNumero(campoBusqueda.getText()) == false) {
                JOptionPane.showMessageDialog(null, "Cédula inválida (solo se aceptan números)");
                campoBusqueda.requestFocusInWindow();
                return;
            } else {
                respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar al cliente con cedula: " + cedulaCliente);
                if (respuesta == JOptionPane.YES_OPTION) {
                    sql = "DELETE FROM clientes WHERE ced_cliente='" + cedulaCliente + "'";

                    try {
                        sentencia = conexion.createStatement();
                        sentencia.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "El registro con cedula: " + cedulaCliente + " fue borrado");

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    campoBusqueda.requestFocusInWindow();
                    return;
                }
            }

        } else if (radBot_nombreCliente.isSelected() == true) {

            if ("".equals(campoBusqueda.getText())) {
                JOptionPane.showMessageDialog(null, "Proporcione el nombre del cliente");
                campoBusqueda.requestFocusInWindow();
                return;
            } else {
                respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar al cliente de nombre: " + nombreCliente);
                if (respuesta == JOptionPane.YES_OPTION) {
                    sql = "DELETE FROM clientes WHERE nomb_cliente='" + nombreCliente + "'";

                    try {
                        sentencia = conexion.createStatement();
                        sentencia.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "El registro de: " + nombreCliente + " fue borrado");

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    campoBusqueda.requestFocusInWindow();
                    return;
                }

            }

        }
        String consulta2 = "SELECT * FROM clientes WHERE id_cliente='" + id_cliente + "'";

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

    private void buscarCliente() {
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        Statement sentencia;
        ResultSet resultado;

        Datos metodo = new Datos();
        String consulta;
        int id_cliente;
        int cedulaCliente;
        String nombreCliente;

        if (radBot_idCliente.isSelected() == true) {
            if ("".equals(campoBusqueda.getText())) {
                JOptionPane.showMessageDialog(null, "Proporcione un ID");
                campoBusqueda.requestFocusInWindow();
                return;
            } else if (metodo.esNumero(campoBusqueda.getText()) == false) {
                JOptionPane.showMessageDialog(null, "ID inválido (solo se aceptan números)");
                campoBusqueda.requestFocusInWindow();
                return;
            } else {
                id_cliente = Integer.parseInt(campoBusqueda.getText());
                consulta = "SELECT * FROM clientes" + " WHERE id_cliente='" + id_cliente + "'";

                try {
                    sentencia = conexion.createStatement();
                    resultado = sentencia.executeQuery(consulta);
                    llenarTabla(resultado);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }

        } else if (radBot_cedCliente.isSelected() == true) {

            if ("".equals(campoBusqueda.getText())) {
                JOptionPane.showMessageDialog(null, "Proporcione un cédula de identidad");
                campoBusqueda.requestFocusInWindow();
                return;
            } else if (metodo.esNumero(campoBusqueda.getText()) == false) {
                JOptionPane.showMessageDialog(null, "Cédula inválida (solo se aceptan números)");
                campoBusqueda.requestFocusInWindow();
                return;
            } else {
                cedulaCliente = Integer.parseInt(campoBusqueda.getText());
                consulta = "SELECT * FROM clientes" + " WHERE ced_cliente='" + cedulaCliente + "'";

                try {
                    sentencia = conexion.createStatement();
                    resultado = sentencia.executeQuery(consulta);
                    llenarTabla(resultado);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }

        } else if (radBot_nombreCliente.isSelected() == true) {

            if ("".equals(campoBusqueda.getText())) {
                JOptionPane.showMessageDialog(null, "Proporcione el nombre del cliente");
                campoBusqueda.requestFocusInWindow();
                return;
            } else {
                nombreCliente = campoBusqueda.getText();
                consulta = "SELECT * FROM clientes" + " WHERE nomb_cliente='" + nombreCliente + "'";

                try {
                    sentencia = conexion.createStatement();
                    resultado = sentencia.executeQuery(consulta);
                    llenarTabla(resultado);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }

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
            java.util.logging.Logger.getLogger(VentanaBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaBuscar dialog = new VentanaBuscar(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable miTabla2;
    private javax.swing.JRadioButton radBot_cedCliente;
    private javax.swing.JRadioButton radBot_idCliente;
    private javax.swing.JRadioButton radBot_nombreCliente;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla(ResultSet resultado) {

        String datos[] = new String[4];

        String titulos[] = {"ID Cliente", "Cédula", "Nombres", "Apellidos",};

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
}
