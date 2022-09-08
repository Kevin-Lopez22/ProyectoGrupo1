/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectogrupo1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Wellinton
 */
public class LoginBibliotecario extends javax.swing.JFrame {

    /**
     * Creates new form LoginBibliotecario
     */
    //INTERFAZ BIBLIOTECA
    GUIBiblioteca biblioteca;

    public LoginBibliotecario() {
        initComponents();
        biblioteca = new GUIBiblioteca();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIDbibliotecario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblFondoB = new javax.swing.JLabel();
        lblFondoBlanco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Inicio de Sesión");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 180, -1));

        jLabel3.setText("ID Bibliotecario :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 103, 20));

        jLabel4.setText("Contraseña :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 103, 20));
        getContentPane().add(txtIDbibliotecario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 153, 30));
        getContentPane().add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 153, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 112, 30));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 106, 30));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Sistema de Gestión");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("de Biblioteca");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/biblioteca.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 70, 70));

        lblFondoB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/7.jpg"))); // NOI18N
        lblFondoB.setText(" ");
        getContentPane().add(lblFondoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 310));

        lblFondoBlanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/b2.jpg"))); // NOI18N
        getContentPane().add(lblFondoBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String contraseña = new String(txtContrasenia.getPassword());
        String usuario = txtIDbibliotecario.getText();
        boolean existe = false;

        if (usuario.equals("") || contraseña.equals("")) {
            JOptionPane.showMessageDialog(null, "Credenciales equivocadas", "ERROR!", 0);
            txtContrasenia.setText("");
            txtIDbibliotecario.setText("");
            return;
        } else {
            try {
                Statement sql = ConexionSQL.getConexion().createStatement();

                String consulta = "Select * from baseBiblioteca.dbo.BIBLIOTECARIOS where IDBIBLIOTECARIO = '"
                        + usuario + "'";

                ResultSet rs = sql.executeQuery(consulta);
                rs.next();

                if (rs.getString("CONTRASENIA").equals(contraseña)) {
                    existe = true;
                    System.out.println("hola");
                } else {
                    System.out.println("----");
                }

                /*
                while (rs.next()) {
                    if (rs.getString("CONTRASENIA").equals(contraseña)) {
                        existe = true;
                        System.out.println("hola");
                    }
                }*/
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            }

        }
        if (existe) {
            biblioteca.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(EXIT_ON_CLOSE);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginBibliotecario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblFondoB;
    private javax.swing.JLabel lblFondoBlanco;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtIDbibliotecario;
    // End of variables declaration//GEN-END:variables
}
