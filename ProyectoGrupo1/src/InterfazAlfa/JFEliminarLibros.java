/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazAlfa;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import proyectogrupo1.Negocio.GestorLibros;
import proyectogrupo1.Negocio.Libro;

/**
 *
 * @author marcelinne
 */
public class JFEliminarLibros extends javax.swing.JFrame {

    Libro libro;
    GestorLibros gestorLibro;
    DefaultTableModel dtmModelo;

    public static DefaultTableModel cargarTitulosTabla(DefaultTableModel dtmModelo) {
        dtmModelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false; //Con esto conseguimos que la tabla no se pueda editar
            }
        };
        
        dtmModelo.addColumn("ID");
        dtmModelo.addColumn("Titulo");
        dtmModelo.addColumn("ISBN");
        dtmModelo.addColumn("Autor");
        dtmModelo.addColumn("Stock");
        dtmModelo.addColumn("Página");
        return dtmModelo;
    }
    
    
    

    public JFEliminarLibros() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(this);
        libro = new Libro();
        gestorLibro = new GestorLibros();
        dtmModelo=cargarTitulosTabla(dtmModelo);
        this.jtblLibros.setModel(dtmModelo);
        gestorLibro.buscarLibro(this.jtblLibros, "SELECT * FROM LIBRO");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpopmMenuEliminar = new javax.swing.JPopupMenu();
        optEliminar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFTituloLibro = new javax.swing.JTextField();
        jBEliminarLibro = new javax.swing.JButton();
        jBRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblLibros = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        optEliminar.setText("Eliminar");
        optEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optEliminarActionPerformed(evt);
            }
        });
        jpopmMenuEliminar.add(optEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel1.setText("ELIMINACIÓN DE LIBROS");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel3.setText("Filtrar por título:");

        jTFTituloLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTituloLibroActionPerformed(evt);
            }
        });
        jTFTituloLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTituloLibroKeyTyped(evt);
            }
        });

        jBEliminarLibro.setBackground(new java.awt.Color(153, 153, 153));
        jBEliminarLibro.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jBEliminarLibro.setForeground(new java.awt.Color(102, 102, 102));
        jBEliminarLibro.setText("Eliminar");
        jBEliminarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarLibroActionPerformed(evt);
            }
        });

        jBRegresar.setBackground(new java.awt.Color(153, 153, 153));
        jBRegresar.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jBRegresar.setForeground(new java.awt.Color(102, 102, 102));
        jBRegresar.setText("Regresar");
        jBRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegresarActionPerformed(evt);
            }
        });

        jtblLibros.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblLibrosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtblLibrosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtblLibros);

        jMenu2.setText("Edit");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBEliminarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jBRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jTFTituloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFTituloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminarLibro)
                    .addComponent(jBRegresar))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }//GEN-LAST:event_formKeyPressed

    private void jTFTituloLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTituloLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTituloLibroActionPerformed

    private void jBEliminarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarLibroActionPerformed
        String IDLibro = (String)jtblLibros.getValueAt(jtblLibros.getSelectedRow(), 0);
        int opcion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el libro seleccionado?", 
                    "** ADVERTENCIA **",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        System.out.println(IDLibro);
        
        boolean respuesta = gestorLibro.eliminarLibro(IDLibro);
        
        if(opcion == JOptionPane.YES_OPTION){
            if (respuesta == false) {
                JOptionPane.showMessageDialog(null, "¡Libro eliminado exitosamente!");
                this.setVisible(true);
                try {
                    gestorLibro.buscarLibro(this.jtblLibros, "SELECT * FROM LIBRO");
                } catch (SQLException ex) {
                    Logger.getLogger(JFEliminarLibros.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "** Error ** ¡Este libro no puede ser eliminado debido a que no existe!");
            }
        }
    }//GEN-LAST:event_jBEliminarLibroActionPerformed

    private void jBRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBRegresarActionPerformed

    private void jtblLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblLibrosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtblLibrosMouseClicked

    private void jtblLibrosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblLibrosMouseReleased
        if (evt.getButton() == MouseEvent.BUTTON3) {
            if (evt.isPopupTrigger()) {
                jpopmMenuEliminar.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_jtblLibrosMouseReleased

    private void optEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optEliminarActionPerformed
        String IDLibro = (String)jtblLibros.getValueAt(jtblLibros.getSelectedRow(), 0);
        int opcion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el libro seleccionado?", 
                    "** ADVERTENCIA **",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        System.out.println(IDLibro);
        
        boolean respuesta = gestorLibro.eliminarLibro(IDLibro);
        
        if(opcion == JOptionPane.YES_OPTION){
            if (respuesta == false) {
                JOptionPane.showMessageDialog(null, "¡Libro eliminado exitosamente!");
                this.setVisible(true);
                try {
                    gestorLibro.buscarLibro(this.jtblLibros, "SELECT * FROM LIBRO");
                } catch (SQLException ex) {
                    Logger.getLogger(JFEliminarLibros.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "** Error ** ¡Este libro no puede ser eliminado debido a que no existe!");
            }
        }
    }//GEN-LAST:event_optEliminarActionPerformed
    TableRowSorter trs=null;
    private void jTFTituloLibroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTituloLibroKeyTyped
        
        
        jTFTituloLibro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+jTFTituloLibro.getText(), 1));
            }
        });
        trs= new TableRowSorter(this.dtmModelo);
        jtblLibros.setRowSorter(trs);
    }//GEN-LAST:event_jTFTituloLibroKeyTyped

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
            java.util.logging.Logger.getLogger(JFEliminarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEliminarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEliminarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEliminarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFEliminarLibros().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFEliminarLibros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEliminarLibro;
    private javax.swing.JButton jBRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFTituloLibro;
    private javax.swing.JPopupMenu jpopmMenuEliminar;
    private javax.swing.JTable jtblLibros;
    private javax.swing.JMenuItem optEliminar;
    // End of variables declaration//GEN-END:variables
}
