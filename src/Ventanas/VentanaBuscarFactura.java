package Ventanas;

import Clases.ConexionMySql;
import Clases.Datos;
import Clases.Factura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

public class VentanaBuscarFactura extends javax.swing.JDialog {

    private DefaultTableModel modelo;
    public ImageIcon icono = new ImageIcon(getClass().getResource("../Recursos/facturaIcon.png"));

    int num_factura;

    int num_facturaPar;
    public int contNumFac = comprobarNumFactura() + 1;

    public VentanaBuscarFactura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setIconImage(icono.getImage());

        initComponents();

        // String datos[] = new String[4];
        // String titulos[] = {"Número de factura", "Total"};
        //   modelo = new DefaultTableModel(null, titulos);
//       miTabla2.setModel(modelo);
//
//        miTabla2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent lse) {
//                if (miTabla2.getSelectedRow() != -1) {
//                    int fila = miTabla2.getSelectedRow();
//                  num_facturaPar= Integer.parseInt(miTabla2.getValueAt(fila, 0).toString());
        /*setCedulaClientebuscado(Integer.parseInt(miTabla2.getValueAt(fila, 1).toString()));
                    setNombreClientebuscado(miTabla2.getValueAt(fila, 2).toString());
                    setApellClientebuscado(miTabla2.getValueAt(fila, 3).toString());*/
        campoBusqueda.requestFocusInWindow();
    }

    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBusqueda = new javax.swing.ButtonGroup();
        campoBusqueda = new javax.swing.JTextField();
        lblBuscar1 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        btn_nuevaBusqueda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BÚSQUEDA DE CLIENTES");
        setResizable(false);

        campoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBusquedaActionPerformed(evt);
            }
        });

        lblBuscar1.setText("Busqueda por Numero de la factura:");

        btn_buscar.setText("Buscar y Generar factura");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_nuevaBusqueda.setText("Nueva Busqueda");
        btn_nuevaBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevaBusquedaActionPerformed(evt);
            }
        });

        jLabel1.setText("Digite el número:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_nuevaBusqueda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscar))
                    .addComponent(lblBuscar1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nuevaBusqueda)
                    .addComponent(btn_buscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Ventana para buscar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        /*  if (resultadoV == true) {
        try {
                resultadoV = conexion.prepareCall("SELECT DETALLE_FACTURA_CABECERA_FACTURA_num_factura FROM totalFacturas" + " WHERE DETALLE_FACTURA_CABECERA_FACTURA_num_factura='" + num_factura + "'").execute();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaBuscarFactura.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        Statement sentencia;
        ResultSet resultado;

        Datos metodo = new Datos();

        String consulta;
        int num_factura;

        boolean resultadoV = false;

        if ("".equals(campoBusqueda.getText())) {
            JOptionPane.showMessageDialog(null, "Proporcione un Número entero");
            campoBusqueda.requestFocusInWindow();
            return;
        } else if (metodo.esNumero(campoBusqueda.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Valor inválido (solo se aceptan números)");
            campoBusqueda.requestFocusInWindow();
            return;
        } else {

            num_factura = Integer.parseInt(campoBusqueda.getText());

            if (num_factura > contNumFac) {
                JOptionPane.showMessageDialog(this, " Error no existe ese numero de factura, ingrese otro", "Notificación", JOptionPane.INFORMATION_MESSAGE);

            } else {
                try {
                    reportes.DemoReporte.llamarReporte(num_factura);
                } catch (JRException ex) {
                    Logger.getLogger(VentanaBuscarFactura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            
//            consulta = "SELECT DETALLE_FACTURA_CABECERA_FACTURA_num_factura FROM totalFacturas" + " WHERE DETALLE_FACTURA_CABECERA_FACTURA_num_factura='" + num_factura + "'";
//
//            try {
//                sentencia = conexion.createStatement();
//                resultado = sentencia.executeQuery(consulta);
//
//                while (resultado.next()) {
//
//                    num_factura = resultado.getInt(1);
//
//                }
//
//            } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }

        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_nuevaBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevaBusquedaActionPerformed
        campoBusqueda.setText("");
        modelo.setColumnCount(0);

    }//GEN-LAST:event_btn_nuevaBusquedaActionPerformed

    private void campoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBusquedaActionPerformed

    /*private void buscarCliente() {
        ConexionMySql conec = new ConexionMySql();
        Connection conexion = conec.conectarMySQL();
        Statement sentencia;
        ResultSet resultado;

        Datos metodo = new Datos();
        
        
        
        String consulta;
        int num_factura;
        

        if (radBot_idCliente.isSelected() == true) {
            if ("".equals(campoBusqueda.getText())) {
                JOptionPane.showMessageDialog(null, "Proporcione un Número entero");
                campoBusqueda.requestFocusInWindow();
                return;
            } else if (metodo.esNumero(campoBusqueda.getText()) == false) {
                JOptionPane.showMessageDialog(null, "Valor inválido (solo se aceptan números)");
                campoBusqueda.requestFocusInWindow();
                return;
            } else {
                num_factura = Integer.parseInt(campoBusqueda.getText());
                consulta = "SELECT DETALLE_FACTURA_CABECERA_FACTURA_num_factura FROM totalFacturas" + " WHERE DETALLE_FACTURA_CABECERA_FACTURA_num_factura='" + num_factura + "'";
//                if (consulta=) {
//                    
//                }
System.out.println(consulta);
                try {
                    sentencia = conexion.createStatement();
                    resultado = sentencia.executeQuery(consulta);
                    //llenarTabla(resultado);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }


    }
        
   }*/
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
            java.util.logging.Logger.getLogger(VentanaBuscarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                VentanaBuscarFactura dialog = new VentanaBuscarFactura(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_nuevaBusqueda;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.ButtonGroup grupoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBuscar1;
    // End of variables declaration//GEN-END:variables

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

    /* private void llenarTabla(ResultSet resultado) {

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

    }*/
}
