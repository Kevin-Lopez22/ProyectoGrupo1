/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectogrupo1;

/**
 *
 * @author Steven
 */
public class GUIBiblioteca extends javax.swing.JFrame {

    /**
     * Creates new form GUIBiblioteca
     */
    
    //CREACIÓN DE CADA GESTOR
    InterfazPrestamos gestorPrestamos;
    
    
    public GUIBiblioteca() {
        initComponents();
        this.setLocationRelativeTo(null);
        gestorPrestamos = new InterfazPrestamos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGestionClientes = new javax.swing.JButton();
        btnGestionLibros = new javax.swing.JButton();
        btnGestionPrestamos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGestionClientes.setBackground(new java.awt.Color(204, 204, 204));
        btnGestionClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        btnGestionClientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnGestionClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        btnGestionLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/books.png"))); // NOI18N
        btnGestionLibros.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnGestionLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        btnGestionPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/loan.png"))); // NOI18N
        btnGestionPrestamos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGestionPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionPrestamosActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, 64));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 16)); // NOI18N
        jLabel4.setText("Gestión de préstamos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 121, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 16)); // NOI18N
        jLabel3.setText("Gestión de libros");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 121, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 16)); // NOI18N
        jLabel2.setText("Gestión de clientes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 121, -1));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel1.setText("SISTEMA DE GESTIÓN DE BIBLIOTECA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 340, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/b2.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionPrestamosActionPerformed
        //Mostrar el gestor de préstamos
        gestorPrestamos.setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_btnGestionPrestamosActionPerformed

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
            java.util.logging.Logger.getLogger(GUIBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGestionClientes;
    private javax.swing.JButton btnGestionLibros;
    private javax.swing.JButton btnGestionPrestamos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblFondo;
    // End of variables declaration//GEN-END:variables
}
