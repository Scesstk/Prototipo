/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HerramientasAdmin;

import RegistroE_S.MEntrada;
import RegistroPersona.*;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JOptionPane;
import static prototipo.Principal.Escritorio;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import login.login;
import prototipo.Principal;
import RegistroPersona.RegistroPersona;
import static RegistroPersona.RegistroPersona.txtDocumento;


public class BuscarRol extends javax.swing.JInternalFrame {
    
    ConnectBD.Pconnection con= new ConnectBD.Pconnection();
    public BuscarRol() {
        initComponents();
        
        //btnmodificar.setVisible(false);
       // otrouno.setVisible(false);
        
        //otrodos.setVisible(false);

    }
    
    public String id_documento, nombre_1, ape_1, id_ficha, txt, busquedasrt;
    public int id;
    public String busq = "";
      private int cedula;
    
    DefaultTableModel modeloe;

   
    public void CargarTablaUsuarios(){        
 
    
        try{
            obtener();
        
   
          String tipo_documento, num_documento, nombre_1, ape_1, rol, ape_2, nombre_2; 
            Statement buscar = con.getConexion().createStatement();
                
            if(eleccionbox.getSelectedIndex()== 0){
                con.setSelectInt("SELECT Id_persona FROM persona WHERE Num_documento='"+busq+"'","Id_persona");
                id = con.getSelectInt();
                ResultSet mostrar=buscar.executeQuery("select descripcion_tip_documento, num_documento, nombre_1, nombre_2, apellido_1, apellido_2, descripcion_rol "
                    + "from persona per "
                    + "inner join rol ro on per.id_rol =ro.id_rol "
                    + "inner join documento doc on per.id_documento = doc.id_documento "
                    + "where id_persona='"+id+"';");
                
                String[] titulos = {"Identificación","numero de documento","Nombres","Apellidos","Rol"};
        DefaultTableModel modeloe=new DefaultTableModel();
        modeloe.setColumnIdentifiers(titulos);
      
        while(mostrar.next()){
            tipo_documento=mostrar.getString("descripcion_tip_documento");
                   num_documento=mostrar.getString("num_documento");
                   nombre_1=mostrar.getString("nombre_1");
                   nombre_2=mostrar.getString("nombre_2");
                   ape_1=mostrar.getString("apellido_1");
                   ape_2=mostrar.getString("apellido_2");
                   rol=mostrar.getString("descripcion_rol");
                   
                   modeloe.addRow(new Object[]{tipo_documento,num_documento,nombre_1+" "+nombre_2,ape_1+" "+ape_2,rol});
                   
                   tblListaUsuarios.setModel(modeloe);
                   
        }
       
            }else{
                
                con.setSelectStr("SELECT Id_persona FROM persona WHERE nombre_1='"+busquedasrt+"' or  apellido_1='"+busquedasrt+"'","Id_persona");
                txt = con.getSelectStr();
                id = Integer.parseInt(txt);
                
                
                ResultSet mostrar=buscar.executeQuery("select descripcion_tip_documento, num_documento, nombre_1, nombre_2, apellido_1, apellido_2, descripcion_rol "
                    + "from persona per "
                    + "inner join rol ro on per.id_rol =ro.id_rol "
                    + "inner join documento doc on per.id_documento = doc.id_documento "
                    + "where id_persona='"+id+"';");
                
                String[] titulos = {"Identificación","numero de documento","Nombres","Apellidos","Rol"};
        DefaultTableModel modeloe=new DefaultTableModel();
        modeloe.setColumnIdentifiers(titulos);
        
         
     
        while(mostrar.next()){
            tipo_documento=mostrar.getString("descripcion_tip_documento");
                   num_documento=mostrar.getString("num_documento");
                   nombre_1=mostrar.getString("nombre_1");
                   nombre_2=mostrar.getString("nombre_2");
                   ape_1=mostrar.getString("apellido_1");
                   ape_2=mostrar.getString("apellido_2");
                   rol=mostrar.getString("descripcion_rol");
                   
                   modeloe.addRow(new Object[]{tipo_documento,num_documento,nombre_1+nombre_2,ape_1+ape_2,rol});
                   int variable = tblListaUsuarios.getSelectedRow();
                   tblListaUsuarios.setModel(modeloe);
        }
        
            }   
                
       
       
       
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error de MySql");
            }catch(Exception err){
                
        }
       
    
    }
    
    public void otros(){
     
    }
    
    public void obtener(){
        
     busquedasrt = txtconsulta.getText();
     busq = txtconsulta.getText();
     
   
 
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        inf = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        eleccionbox = new javax.swing.JComboBox<String>();
        txtconsulta = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaUsuarios = new javax.swing.JTable();

        inf.setText("Informacion");
        inf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infActionPerformed(evt);
            }
        });
        jPopupMenu1.add(inf);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Buscar por:");

        eleccionbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Doc. Identidad", "Nombre", "Apellido", "Ficha F." }));
        eleccionbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eleccionboxActionPerformed(evt);
            }
        });

        txtconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconsultaActionPerformed(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Resultados"));
        jPanel1.setFocusTraversalPolicyProvider(true);

        tblListaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblListaUsuarios.setComponentPopupMenu(jPopupMenu1);
        tblListaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblListaUsuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblListaUsuarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(eleccionbox, 0, 133, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnbuscar)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(eleccionbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
       
        CargarTablaUsuarios();
        
        
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void infActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infActionPerformed
      
        
        int id,centro,Id_tipo_persona,gener,tphr,tipo_persona,usrol,Tdoc,acceso=0;
        String Num_documento, nombre_1,nombre_2, ape_1,ape_2,Id_ficha ,correo,celular,Telfono,direccion, accesos;
        cedula=Integer.parseInt(txtconsulta.getText());
        con.setSelectInt(("SELECT Num_documento FROM persona WHERE Num_documento='"+busq+"'"),"Num_documento");
                
             id=con.getSelectInt();
            
             
        
        if (id==cedula){
            
            con.setSelectStr("SELECT Nombre_1 FROM persona WHERE Num_documento='"+cedula+"'","nombre_1");
            nombre_1 = con.getSelectStr();
            
            con.setSelectStr(("SELECT Nombre_2  FROM persona WHERE Num_documento='"+cedula+"'"),"nombre_2");
            nombre_2 = con.getSelectStr();
            
            con.setSelectStr(("SELECT Apellido_1  FROM persona WHERE Num_documento='"+cedula+"'"),"Apellido_1");
            ape_1 = con.getSelectStr();
            
            con.setSelectStr(("SELECT Apellido_2 FROM persona WHERE Num_documento='"+cedula+"'"),"Apellido_2");
            ape_2 = con.getSelectStr();
            
            
               con.setSelectStr(("SELECT Num_ficha \n" +
                              "FROM ficha as f JOIN persona as p on f.Id_ficha=p.Id_ficha\n" +
                              "WHERE Num_documento='"+cedula+"'"),"Num_ficha");
                                   Id_ficha = con.getSelectStr();
                          
           con.setSelectStr(("SELECT Num_documento  FROM persona WHERE Num_documento='"+cedula+"'"),"Num_documento");
           Num_documento = con.getSelectStr();
           
           con.setSelectInt("select Id_documento from persona where num_documento='"+cedula+"'","Id_documento");
            Tdoc=con.getSelectInt();
            
            con.setSelectInt("select id_tipo_persona from persona where num_documento='"+cedula+"'","id_tipo_persona");
            Id_tipo_persona=con.getSelectInt();
            
           con.setSelectInt(("SELECT Id_centros  FROM persona WHERE Num_documento='"+cedula+"'"),"Id_centros");
           centro = con.getSelectInt();
            
           con.setSelectStr(("SELECT Id_rh from persona where Num_documento='"+cedula+"'"),"Id_rh");
                  tphr=con.getSelectInt();
                  
            con.setSelectInt("select id_genero from persona where num_documento='"+cedula+"'","id_genero");
            gener=con.getSelectInt();
            
           con.setSelectStr(("SELECT correo FROM persona WHERE Num_documento='"+cedula+"'"),"correo");
           correo = con.getSelectStr();
           
           con.setSelectStr(("SELECT Telfono_fijo  FROM persona WHERE Num_documento='"+cedula+"'"),"Telfono_fijo");
           Telfono = con.getSelectStr();
           
           con.setSelectStr(("SELECT celular  FROM persona WHERE Num_documento='"+cedula+"'"),"celular");
           celular = con.getSelectStr();
           
           con.setSelectStr(("SELECT Direccion  FROM persona WHERE Num_documento='"+cedula+"'"),"Direccion");
           direccion = con.getSelectStr();
           
           con.setSelectInt("select id_tipo_persona from persona where num_documento='"+cedula+"'","id_tipo_persona");
           tipo_persona=con.getSelectInt();
            
           con.setSelectStr(("select activo \n" +
                          "from persona pr \n" +
                       "inner join acceso ac \n" +
                         "on pr.Id_persona=ac.Id_persona\n" +
                   "where num_documento='"+cedula+"';"),"activo");
                        accesos = con.getSelectStr();
            switch (accesos){
                case "SI":
                    acceso=1;
                    break;
                case "NO":
                    acceso=2;
                    break;
            }
      
            con.setSelectInt("select id_rol  from persona where num_documento='"+cedula+"'","id_rol");
            usrol=con.getSelectInt() ;
            
            RegistroPersona obj= new RegistroPersona();
            Principal.Escritorio.add(obj);
            
            Dimension desktopSize = Principal.Escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            obj.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            obj.show();
            
           
            obj.txtNombre1.setText(nombre_1);
            obj.txtNombre2.setText(nombre_2);
            obj.txtApellido1.setText(ape_1);
            obj.txtApellido2.setText(ape_2);
            obj.cbxFicha.setSelectedItem(Id_ficha);
            obj.txtDocumento.setText(Num_documento);
            obj.cbxRh.setSelectedIndex(tphr+1);
            obj.cbxCentro.setSelectedIndex(centro+1);
            obj.txtEmail.setText(correo);
            obj.txtTelefono.setText(Telfono);
            obj.txtCelular.setText(celular);
            obj.txtDireccion.setText(direccion);
            obj.cbxGenero.setSelectedIndex(gener);
            obj.cbxTipUser.setSelectedIndex(tipo_persona);
            obj.cbxUsuario.setSelectedIndex(acceso);
            obj.cbxRol.setSelectedIndex(usrol);
            obj.cbxTipoDoc.setSelectedIndex(Tdoc);
            String r="C:/temp/"+Num_documento+".png";
            obj.actfoto(r);
            dispose();
        }else{
            mensajes.Nousuario obj= new mensajes.Nousuario();
            Principal.Escritorio.add(obj);
            Dimension desktopSize = Principal.Escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            obj.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            obj.show();
            txtconsulta.setText(null);
        }
    }//GEN-LAST:event_infActionPerformed

    private void txtconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconsultaActionPerformed

    private void eleccionboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eleccionboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eleccionboxActionPerformed

    private void tblListaUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaUsuariosMousePressed
        // TODO add your handling code here:
                                          
       

    }//GEN-LAST:event_tblListaUsuariosMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JComboBox<String> eleccionbox;
    private javax.swing.JMenuItem inf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaUsuarios;
    private javax.swing.JTextField txtconsulta;
    // End of variables declaration//GEN-END:variables
}
