/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectogrupo1.cliente;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @usuario
 */
public class GUIActualizar extends javax.swing.JFrame {

    /* Variables para la actualizacion del cliente */
    Cliente clientePorModificar;    // Variable auxiliar para modificar y enviar al CRUD
    private SqlCrudClienteByCI sqlCrudCliente;  // Handler para el crud
    private Consumer<String> consumerUpdateCliente = (t)->{};
    
    public GUIActualizar(SqlCrudClienteByCI sqlCrudCliente) {
        initComponents();
        this.sqlCrudCliente = sqlCrudCliente;
        consumerUpdateCliente = t->clientePorModificar.setNombre(t);

    }

    GUIActualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaInformacion = new javax.swing.JTextArea();
        cmbEditar = new javax.swing.JComboBox<>();
        lblEditar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEditar = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setText("Cédula");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txaInformacion.setEditable(false);
        txaInformacion.setColumns(20);
        txaInformacion.setRows(5);
        jScrollPane1.setViewportView(txaInformacion);

        cmbEditar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellido", "Telefono", "Dirección", "Correo" }));
        cmbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEditarActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione el dato a editar");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("ACTUALIZAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(btnRegresar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(jLabel3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAceptar))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnAceptar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        GUIGestorCliente gestor = new GUIGestorCliente(sqlCrudCliente);
        gestor.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String cedula = "";
     
        
        cedula = txtCedula.getText();
            try {
            List<Cliente> clientes = sqlCrudCliente.read(cedula);
            
            if(clientes.isEmpty()){
                JOptionPane.showMessageDialog(null, "No se ha encontrado el cliente especificado" ); // Ahi le cambian
                clientePorModificar = null;
                return;
                }
            if(clientes.size()==1){
                JOptionPane.showMessageDialog(null, "Cliente encontrado!"); // Ahi le cambian
                clientePorModificar = clientes.get(0);
                txaInformacion.setText(clientePorModificar.toString());
                }
            }
            catch (SQLException ex) {
            // TODO: Control de excepciones
            Logger.getLogger(GUIActualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*Aplicar logica para ingresar a la base de datos e imprimir en el textArea*/

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cmbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEditarActionPerformed
        if (cmbEditar.getSelectedItem() == "Nombre"){
            lblEditar.setText("Nombre");
            consumerUpdateCliente = t->clientePorModificar.setNombre(t);
        }
        if (cmbEditar.getSelectedItem() == "Apellido"){
            lblEditar.setText("Apellido");
            consumerUpdateCliente = t->clientePorModificar.setApellido(t);
        }
        if (cmbEditar.getSelectedItem() == "Telefono"){
            lblEditar.setText("Telefono");
            consumerUpdateCliente = t->clientePorModificar.setTelefono(t);
        }
        if (cmbEditar.getSelectedItem() == "Dirección"){
            consumerUpdateCliente = t->clientePorModificar.setDireccion(t);
            lblEditar.setText("Dirección");
        }
        if (cmbEditar.getSelectedItem() == "Correo"){
            consumerUpdateCliente = t->clientePorModificar.setCorreo(t);
            lblEditar.setText("Correo");
        }
    }//GEN-LAST:event_cmbEditarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String variableString = "";
        
        
        variableString = txtEditar.getText(); //Esto tambien que se actualice en la base de datos y se cambie el textArea pilas mateo
        consumerUpdateCliente.accept(variableString);
        try {

            sqlCrudCliente.update(clientePorModificar);
            JOptionPane.showMessageDialog(null, "Información actualizada"); // Ahi le cambian

        } catch (SQLException ex) {
            // TODO: Control de excepciones
            Logger.getLogger(GUIActualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JTextArea txaInformacion;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtEditar;
    // End of variables declaration//GEN-END:variables
}