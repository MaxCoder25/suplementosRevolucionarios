package Ventanas;

import Clases.DesktopConFondo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class VentanaPrincipal extends javax.swing.JFrame {

    public ImageIcon icono = new ImageIcon(getClass().getResource("../Recursos/facturaIcon.png"));

    public VentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(icono.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpaneEscritorio = new DesktopConFondo();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuArchivoClientes = new javax.swing.JMenuItem();
        mnuArchivoProductos = new javax.swing.JMenuItem();
        mnuArchivoUsuarios = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuArchivoSalir = new javax.swing.JMenuItem();
        mnuMovimientos = new javax.swing.JMenu();
        mnuMovimientosNFactura = new javax.swing.JMenuItem();
        mnuMovimientosReportFactura = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mnuAyudaAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facturación =>SUPLEMENTOS REVOLUCIONARIOS<=");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        dpaneEscritorio.setBackground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout dpaneEscritorioLayout = new javax.swing.GroupLayout(dpaneEscritorio);
        dpaneEscritorio.setLayout(dpaneEscritorioLayout);
        dpaneEscritorioLayout.setHorizontalGroup(
            dpaneEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        dpaneEscritorioLayout.setVerticalGroup(
            dpaneEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        mnuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/menuArchivo.png"))); // NOI18N
        mnuArchivo.setText("Archivo");
        mnuArchivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mnuArchivoClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/clientes.png"))); // NOI18N
        mnuArchivoClientes.setText("Clientes");
        mnuArchivoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoClientesActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoClientes);

        mnuArchivoProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/productos.png"))); // NOI18N
        mnuArchivoProductos.setText("Productos");
        mnuArchivoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoProductosActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoProductos);

        mnuArchivoUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/usuarios.png"))); // NOI18N
        mnuArchivoUsuarios.setText("Usuarios");
        mnuArchivoUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoUsuariosActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoUsuarios);
        mnuArchivo.add(jSeparator1);
        mnuArchivo.add(jSeparator2);

        mnuArchivoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancelarIcon.png"))); // NOI18N
        mnuArchivoSalir.setText("Salir");
        mnuArchivoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoSalirActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoSalir);

        jMenuBar1.add(mnuArchivo);

        mnuMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/menuMovimientos.png"))); // NOI18N
        mnuMovimientos.setText("Movimientos");
        mnuMovimientos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mnuMovimientosNFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/nuevaFactura.png"))); // NOI18N
        mnuMovimientosNFactura.setText("Nueva Factura");
        mnuMovimientosNFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientosNFacturaActionPerformed(evt);
            }
        });
        mnuMovimientos.add(mnuMovimientosNFactura);

        mnuMovimientosReportFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/reportesFacturas.png"))); // NOI18N
        mnuMovimientosReportFactura.setText("Reporte de Facturas");
        mnuMovimientosReportFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientosReportFacturaActionPerformed(evt);
            }
        });
        mnuMovimientos.add(mnuMovimientosReportFactura);

        jMenuBar1.add(mnuMovimientos);

        mnuAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/menuAyuda.png"))); // NOI18N
        mnuAyuda.setText("Ayuda");
        mnuAyuda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mnuAyudaAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/acercaDe.png"))); // NOI18N
        mnuAyudaAcerca.setText("Acerca de");
        mnuAyudaAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAyudaAcercaActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAyudaAcerca);

        jMenuBar1.add(mnuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpaneEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpaneEscritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuArchivoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoClientesActionPerformed
        VentanaClientes vtnClientes = new VentanaClientes();
        dpaneEscritorio.add(vtnClientes);   //anado la ventana clientes al desktop pane
        vtnClientes.show();                //hago visible la ventana clientes
    }//GEN-LAST:event_mnuArchivoClientesActionPerformed

    private void mnuArchivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuArchivoSalirActionPerformed

    private void mnuArchivoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoProductosActionPerformed

        VentanaProductos vtnProductos = new VentanaProductos();
        dpaneEscritorio.add(vtnProductos);   //anado la ventana productos al desktop pane
        vtnProductos.show();                 //hago visible la ventana producots

    }//GEN-LAST:event_mnuArchivoProductosActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ((DesktopConFondo) dpaneEscritorio).setImagen("../Recursos/fondo.jpg");


    }//GEN-LAST:event_formWindowOpened

    private void mnuAyudaAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAyudaAcercaActionPerformed
     
          VentanaAcercaDe vtnAcercade = new VentanaAcercaDe();
        dpaneEscritorio.add(vtnAcercade );   //anado la ventana clientes al desktop pane
        vtnAcercade .show();                //hago visible la ventana clientes
        
    }//GEN-LAST:event_mnuAyudaAcercaActionPerformed

    private void mnuMovimientosNFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientosNFacturaActionPerformed
        VentanaFactura vtnFactura = new VentanaFactura();
        dpaneEscritorio.add(vtnFactura);   //anado la ventana productos al desktop pane
        vtnFactura.show(); 
        
        
    }//GEN-LAST:event_mnuMovimientosNFacturaActionPerformed

    private void mnuMovimientosReportFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientosReportFacturaActionPerformed
        boolean closable = false;
        
         VentanaBuscarFactura vtnBuscarFactura = new VentanaBuscarFactura(null, closable);
        vtnBuscarFactura.setLocationRelativeTo(null);
        vtnBuscarFactura.setVisible(true);
        

        
    }//GEN-LAST:event_mnuMovimientosReportFacturaActionPerformed

    private void mnuArchivoUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoUsuariosActionPerformed
        JOptionPane.showMessageDialog(this,"Usuarios Activos: \n*Matt\n*Mac");
        
    }//GEN-LAST:event_mnuArchivoUsuariosActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpaneEscritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenuItem mnuArchivoClientes;
    private javax.swing.JMenuItem mnuArchivoProductos;
    private javax.swing.JMenuItem mnuArchivoSalir;
    private javax.swing.JMenuItem mnuArchivoUsuarios;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenuItem mnuAyudaAcerca;
    private javax.swing.JMenu mnuMovimientos;
    private javax.swing.JMenuItem mnuMovimientosNFactura;
    private javax.swing.JMenuItem mnuMovimientosReportFactura;
    // End of variables declaration//GEN-END:variables
}
