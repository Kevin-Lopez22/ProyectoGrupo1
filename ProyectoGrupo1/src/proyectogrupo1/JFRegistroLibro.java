
package proyectogrupo1;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectogrupo1.Negocio.GestorLibros;
import proyectogrupo1.Negocio.Libro;

public class JFRegistroLibro extends javax.swing.JFrame {
    
    Libro libro;
    GestorLibros gestorLibro;
    
    public JFRegistroLibro() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(this);
        libro = new Libro();
        gestorLibro = new GestorLibros();
        //jCBPais.setModel(reservaCliente.llenarComboboxCli("SELECT PAIS FROM PAIS"));        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFIDLIbro = new javax.swing.JTextField();
        jTFPaginas = new javax.swing.JTextField();
        jBIngresarClienteRes = new javax.swing.JButton();
        jBRegresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTFTituloLibro = new javax.swing.JTextField();
        jTFAutorLibro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTFIsbnLibro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTFStock = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REGISTRO DE CLIENTES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE LIBROS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 510, 40));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id_Libro:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 270, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Titulo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 300, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Autor:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 380, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("N Páginas ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 350, -1));
        getContentPane().add(jTFIDLIbro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 220, -1));

        jTFPaginas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFPaginasActionPerformed(evt);
            }
        });
        getContentPane().add(jTFPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 220, -1));

        jBIngresarClienteRes.setBackground(new java.awt.Color(153, 153, 153));
        jBIngresarClienteRes.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jBIngresarClienteRes.setForeground(new java.awt.Color(102, 102, 102));
        jBIngresarClienteRes.setText("Ingresar");
        jBIngresarClienteRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngresarClienteResActionPerformed(evt);
            }
        });
        getContentPane().add(jBIngresarClienteRes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 200, -1));

        jBRegresar.setBackground(new java.awt.Color(153, 153, 153));
        jBRegresar.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jBRegresar.setForeground(new java.awt.Color(102, 102, 102));
        jBRegresar.setText("Regresar");
        jBRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(jBRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 210, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo2REGISTRO.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 470));
        getContentPane().add(jTFTituloLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 220, -1));
        getContentPane().add(jTFAutorLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 220, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ISBN");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 350, -1));
        getContentPane().add(jTFIsbnLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 220, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Stock");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 350, -1));

        jTFStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFStockActionPerformed(evt);
            }
        });
        getContentPane().add(jTFStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 220, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBIngresarClienteResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIngresarClienteResActionPerformed
        int idLibro = Integer.parseInt(jTFIDLIbro.getText());
        String titulo = jTFTituloLibro.getText();
        String autor = jTFAutorLibro.getText();
        String isbn = jTFIsbnLibro.getText();
        int stock = Integer.parseInt(jTFStock.getText());
        int paginas = Integer.parseInt(jTFPaginas.getText());
       
        libro = new Libro(idLibro, titulo, autor, isbn, paginas, stock);
        boolean respuesta = gestorLibro.agregarLibro(libro);
        if(respuesta == false){
            JOptionPane.showMessageDialog(null, "¡Libro agregado exitosamente!");
            this.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "** Error ** ¡Este libro no puede ser agregado!");
        }
    }//GEN-LAST:event_jBIngresarClienteResActionPerformed

    private void jBRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jBRegresarActionPerformed

    private void jTFPaginasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFPaginasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFPaginasActionPerformed

    private void jTFStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFStockActionPerformed

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
            java.util.logging.Logger.getLogger(JFRegistroLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFRegistroLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFRegistroLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRegistroLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFRegistroLibro().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFRegistroLibro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBIngresarClienteRes;
    private javax.swing.JButton jBRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTFAutorLibro;
    private javax.swing.JTextField jTFIDLIbro;
    private javax.swing.JTextField jTFIsbnLibro;
    private javax.swing.JTextField jTFPaginas;
    private javax.swing.JTextField jTFStock;
    private javax.swing.JTextField jTFTituloLibro;
    // End of variables declaration//GEN-END:variables
}
