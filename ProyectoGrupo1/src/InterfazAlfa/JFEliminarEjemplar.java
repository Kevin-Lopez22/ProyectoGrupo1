/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazAlfa;

import java.awt.event.MouseEvent;

/**
 *
 * @author Valery-PC
 */
public class JFEliminarEjemplar extends javax.swing.JFrame {

    /**
     * Creates new form JFEliminarEjemplar
     */
    public JFEliminarEjemplar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBEliminarLibro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTEjemplarPorLibros = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFTituloLibroEjemplar = new javax.swing.JTextField();
        jBEliminarEjemplar = new javax.swing.JButton();
        jBRegresarEliminarejemplares = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblEjemplaresPorLibro = new javax.swing.JTable();

        jBEliminarLibro.setBackground(new java.awt.Color(153, 153, 153));
        jBEliminarLibro.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jBEliminarLibro.setForeground(new java.awt.Color(102, 102, 102));
        jBEliminarLibro.setText("Eliminar");
        jBEliminarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarLibroActionPerformed(evt);
            }
        });

        JTEjemplarPorLibros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTEjemplarPorLibros);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel4.setText("ELIMINACIÓN DE EJEMPLARES");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel5.setText("Filtrar por Libro:");

        jTFTituloLibroEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTituloLibroEjemplarActionPerformed(evt);
            }
        });
        jTFTituloLibroEjemplar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTituloLibroEjemplarKeyTyped(evt);
            }
        });

        jBEliminarEjemplar.setBackground(new java.awt.Color(153, 153, 153));
        jBEliminarEjemplar.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jBEliminarEjemplar.setForeground(new java.awt.Color(102, 102, 102));
        jBEliminarEjemplar.setText("Eliminar");
        jBEliminarEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarEjemplarActionPerformed(evt);
            }
        });

        jBRegresarEliminarejemplares.setBackground(new java.awt.Color(153, 153, 153));
        jBRegresarEliminarejemplares.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jBRegresarEliminarejemplares.setForeground(new java.awt.Color(102, 102, 102));
        jBRegresarEliminarejemplares.setText("Regresar");
        jBRegresarEliminarejemplares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegresarEliminarejemplaresActionPerformed(evt);
            }
        });

        jtblEjemplaresPorLibro.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblEjemplaresPorLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblEjemplaresPorLibroMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtblEjemplaresPorLibroMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtblEjemplaresPorLibro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFTituloLibroEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBEliminarEjemplar)
                .addGap(18, 18, 18)
                .addComponent(jBRegresarEliminarejemplares, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTFTituloLibroEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBEliminarEjemplar)
                            .addComponent(jBRegresarEliminarejemplares))
                        .addGap(16, 16, 16))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFTituloLibroEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTituloLibroEjemplarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTituloLibroEjemplarActionPerformed

    private void jTFTituloLibroEjemplarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTituloLibroEjemplarKeyTyped

       
    }//GEN-LAST:event_jTFTituloLibroEjemplarKeyTyped

    private void jBEliminarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarLibroActionPerformed
       
    }//GEN-LAST:event_jBEliminarLibroActionPerformed

    private void jBEliminarEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarEjemplarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBEliminarEjemplarActionPerformed

    private void jBRegresarEliminarejemplaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarEliminarejemplaresActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBRegresarEliminarejemplaresActionPerformed

    private void jtblEjemplaresPorLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblEjemplaresPorLibroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtblEjemplaresPorLibroMouseClicked

    private void jtblEjemplaresPorLibroMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblEjemplaresPorLibroMouseReleased
        if (evt.getButton() == MouseEvent.BUTTON3) {
            if (evt.isPopupTrigger()) {
             //   jpopmMenuEliminar.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_jtblEjemplaresPorLibroMouseReleased

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
            java.util.logging.Logger.getLogger(JFEliminarEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEliminarEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEliminarEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEliminarEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFEliminarEjemplar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTEjemplarPorLibros;
    private javax.swing.JButton jBEliminarEjemplar;
    private javax.swing.JButton jBEliminarLibro;
    private javax.swing.JButton jBRegresarEliminarejemplares;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFTituloLibroEjemplar;
    private javax.swing.JTable jtblEjemplaresPorLibro;
    // End of variables declaration//GEN-END:variables
}
