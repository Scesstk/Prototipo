/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistroE_S;

import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import prototipo.Principal;

/**
 *
 * @author Axelshade
 */
public class MREntradaSalida extends javax.swing.JInternalFrame {

    private int prueba, cedula;
    
    public MREntradaSalida() {
        initComponents();
        
    }
    
    public void CentrarJFrame(){
    
  }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("CAPID");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(89, 181, 72), 2, true), "Registro Entrada/Salida de Personal", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 12))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N

        txtid.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        txtid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtidFocusLost(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingrese ID");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidFocusLost
        
    }//GEN-LAST:event_txtidFocusLost

    private void txtidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyTyped
       
    }//GEN-LAST:event_txtidKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConnectBD.Pconnection objc= new ConnectBD.Pconnection();
        //Getset medio= new Getset();
        
        int id;
        String nombre,Ficha,centro,cargo,rh;
        cedula=Integer.parseInt(txtid.getText());
        objc.setSelectInt(("SELECT Num_documento FROM persona WHERE Num_documento='"+cedula+"'"),"Num_documento");
                
             id=objc.getSelectInt();
            
             
        
        if (id==cedula){
            
            objc.setSelectStr(("SELECT concat(`Nombre_1`,' ', `Nombre_2`,' ', `Apellido_1`,' ', `Apellido_2`) AS Nombre FROM persona WHERE Num_documento='"+cedula+"'"),"Nombre");
            nombre = objc.getSelectStr();
            
            objc.setSelectStr(("SELECT Descripcion_ficha \n" +
                              "FROM ficha as f JOIN persona as p on f.Id_ficha=p.Id_ficha\n" +
                              "WHERE Num_documento='"+cedula+"'"),"Descripcion_ficha");
            Ficha = objc.getSelectStr();
            
            objc.setSelectStr(("SELECT Nom_centro \n" +
                              "FROM centros as c JOIN persona as p on c.Id_centros=p.Id_centros\n" +
                              "WHERE Num_documento='"+cedula+"'"),"Nom_centro");
            centro = objc.getSelectStr();
            
            objc.setSelectStr(("SELECT Descripcion_tipo_persona \n" +
                              "FROM tipo_persona as t JOIN persona as p on t.Id_tipo_persona=p.Id_tipo_persona\n" +
                              "WHERE Num_documento='"+cedula+"'"),"Descripcion_tipo_persona");
            cargo = objc.getSelectStr();
            
            objc.setSelectStr(("SELECT Descripcion_rh \n" +
                              "FROM rh as r JOIN persona as p on r.Id_rh=p.Id_rh\n" +
                              "WHERE Num_documento='"+cedula+"'"),"Descripcion_rh");
            rh = objc.getSelectStr();
            
            
           
            
            
            MEntrada obj= new MEntrada();
            Principal.Escritorio.add(obj);
            
            Dimension desktopSize = Principal.Escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            obj.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            obj.show();
            
            MEntrada.txtdoc.setText(String.valueOf(id));
            MEntrada.txtnom.setText(nombre);
            MEntrada.txtficha.setText(Ficha);
            MEntrada.txtcentro.setText(centro);
            MEntrada.txtcargo.setText(cargo);
            MEntrada.txtrh.setText(rh);
            txtid.setText(null);
            String ruta="C:/Program Files/SCESS/Images/"+txtid.getText()+".png";
            MEntrada.actfoto(ruta);
            dispose();
        }else{
            mensajes.Nousuario obj= new mensajes.Nousuario();
            Principal.Escritorio.add(obj);
            Dimension desktopSize = Principal.Escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            obj.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            obj.show();
            txtid.setText(null);
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
