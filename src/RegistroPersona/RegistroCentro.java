/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistroPersona;

import ConnectBD.Pconnection;


/**
 *
 * @author FGALLARDO
 */
public class RegistroCentro extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistroCentro
     */
    Pconnection carga = new Pconnection();
    
    public RegistroCentro() {
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

        jLabel5 = new javax.swing.JLabel();
        cbxDepartamento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxCiudad = new javax.swing.JComboBox<>();
        jbtnCentro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtxtCodCentro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtNombreCentro = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Registro Centro");

        jLabel5.setText("Departamento");

        cbxDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Amazonas", "Antioquia", "Arauca", "Atlántico", "Bolívar", "Boyacá", "Caldas", "Caquetá", "Casanare", "Cauca", "Cesar", "Chocó", "Córdoba", "Cundinamarca", "Guainía", "Guaviare", "Huila", "La Guajira", "Magdalena", "Meta", "Nariño", "Norte de Santander", "Putumayo", "Quindío", "Risaralda", "San Andrés y Providencia", "Santander", "Sucre", "Tolima", "Valle del Cauca", "Vaupés", "Vichada" }));
        cbxDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDepartamentoActionPerformed(evt);
            }
        });

        jLabel4.setText("Ciudad");

        cbxCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        jbtnCentro.setText("Guardar");
        jbtnCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCentroActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo Centro:");

        jLabel2.setText("Nombre del Centro:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(jtxtCodCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtNombreCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnCentro))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtCodCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtNombreCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cbxDepartamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jbtnCentro)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDepartamentoActionPerformed
        cbxCiudad.removeAllItems();

        carga.getConexion();
        if(cbxDepartamento.getSelectedIndex()>0){
            carga.setLlenaCombo(("Select Nom_ciudad from ciudad where id_departamento "
                + "= '"+cbxDepartamento.getSelectedIndex()+"'"),"Nom_ciudad");

        }
        
    }//GEN-LAST:event_cbxDepartamentoActionPerformed

    private void jbtnCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCentroActionPerformed
        String ciudad = cbxCiudad.getSelectedItem().toString();
        
        carga.setSelectInt("Select Id_ciudad from ciudad where Nom_ciudad = '"+ciudad+"'", "Id_ciudad");
        int idCiudad = carga.getSelectInt();
                   
        carga.setInsert("INSERT INTO centros (Nom_centro, Cod_sena_centro, Id_ciudad) VALUES"
                +"('"+jtxtNombreCentro.getText()+"','"+jtxtCodCentro.getText()+"',"+idCiudad+")");
        carga.cerrarConexion();
        dispose();
    }//GEN-LAST:event_jbtnCentroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> cbxCiudad;
    public static javax.swing.JComboBox<String> cbxDepartamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbtnCentro;
    private javax.swing.JTextField jtxtCodCentro;
    private javax.swing.JTextField jtxtNombreCentro;
    // End of variables declaration//GEN-END:variables
}
