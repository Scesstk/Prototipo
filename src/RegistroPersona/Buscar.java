/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistroPersona;

import ConnectBD.Pconnection;
import ConnectBD.Persona;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import prototipo.Principal;
import static prototipo.Principal.Escritorio;

/**
 *
 * @author SENA
 */
public class Buscar extends javax.swing.JInternalFrame {
    private String varSel="";
    private String nom="";
    private int doc;
    private int fic;
    private int id;

    
    
    Pconnection busca = new Pconnection();
    //Persona buscaP = new Persona(id);
    /**
     * Creates new form Buscar
     */
    public Buscar() {
        initComponents();
        //CargarTablaUsuarios();
        
        
        
    }
    
    
    DefaultTableModel  modeloTablau;
    DefaultTableModel modelou;
    
    public void CargarTablaUsuarios(){        
        String[] titulos = {"Doc. Identidad","Nombre(s) Apellido(s)","Ficha Formación"};
        Object[][] data={
                            {doc,nom,fic}
                        };
        modelou= new DefaultTableModel(data, titulos);
        tblListaUsuarios.setModel(modelou);         
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        inf = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jcbxBusca = new javax.swing.JComboBox<>();
        jtxtBusca = new javax.swing.JTextField();
        jbtnBusca = new javax.swing.JButton();
        jPresult = new javax.swing.JPanel();
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

        jcbxBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doc. Identidad", "Nombre", "Apellido", "Ficha F." }));

        jbtnBusca.setText("Buscar");
        jbtnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscaActionPerformed(evt);
            }
        });

        jPresult.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Resultados"));
        jPresult.setFocusTraversalPolicyProvider(true);

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
        jScrollPane1.setViewportView(tblListaUsuarios);

        javax.swing.GroupLayout jPresultLayout = new javax.swing.GroupLayout(jPresult);
        jPresult.setLayout(jPresultLayout);
        jPresultLayout.setHorizontalGroup(
            jPresultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPresultLayout.setVerticalGroup(
            jPresultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPresultLayout.createSequentialGroup()
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
                .addComponent(jcbxBusca, 0, 133, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jtxtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnBusca)
                .addContainerGap())
            .addComponent(jPresult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbxBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBusca))
                .addGap(18, 18, 18)
                .addComponent(jPresult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscaActionPerformed
        switch (jcbxBusca.getSelectedIndex()){
            case 0: 
                varSel="Num_documento";
                break;
            case 1:
                varSel="Nombre_1";
                break;
            case 2:
                varSel="Apellido_1";
                break;
            case 3:
                varSel="Num_ficha";
                break;
        }
        
        
             
        busca.setSelectInt("Select Id_persona from persona where "+varSel+" = '"+jtxtBusca.getText()+"'", "Id_persona");
        id=busca.getSelectInt();
        
        
        
       
            busca.setSelectStr("Select concat(Nombre_1,' ',Nombre_2,' ',Apellido_1,' ',Apellido_2) as Nombre from persona where "+varSel+" = '"+jtxtBusca.getText()+"'","Nombre");
            nom=busca.getSelectStr();

            busca.setSelectInt("Select Num_documento from persona where "+varSel+" = '"+jtxtBusca.getText()+"'","Num_documento");
            doc=busca.getSelectInt();

            busca.setSelectInt("Select Num_ficha from ficha as f join persona as "
                    + "p on f.id_ficha = p.id_ficha where "+varSel+" = '"+jtxtBusca.getText()+"'","Num_ficha");
            fic=busca.getSelectInt();

        
        busca.cerrarConexion();
        
        CargarTablaUsuarios();
        
        
        
    }//GEN-LAST:event_jbtnBuscaActionPerformed

    private void infActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infActionPerformed
        Pconnection con = new Pconnection();
        int id2,centro,Id_tipo_persona,Id_rh,genero, rol, tipUser;
        String Num_documento, nombre_1,nombre_2, ape_1,ape_2,Id_ficha ,correo,celular,Telfono,direccion;
        //doc=Integer.parseInt(jtxtBusca.getText());
        con.setSelectInt(("SELECT Num_documento FROM persona WHERE Id_persona='"+id+"'"),"Num_documento");
                
             id2=con.getSelectInt();
            
             
        
        if (id2==doc){
            
            con.setSelectStr("SELECT Nombre_1 FROM persona WHERE Num_documento='"+doc+"'","nombre_1");
            nombre_1 = con.getSelectStr();
            
            con.setSelectStr(("SELECT Nombre_2  FROM persona WHERE Num_documento='"+doc+"'"),"nombre_2");
            nombre_2 = con.getSelectStr();
            
            con.setSelectStr(("SELECT Apellido_1  FROM persona WHERE Num_documento='"+doc+"'"),"Apellido_1");
            ape_1 = con.getSelectStr();
            
            con.setSelectStr(("SELECT Apellido_2 FROM persona WHERE Num_documento='"+doc+"'"),"Apellido_2");
            ape_2 = con.getSelectStr();
            
            
               con.setSelectStr(("SELECT Num_ficha \n" +
                              "FROM ficha as f JOIN persona as p on f.Id_ficha=p.Id_ficha\n" +
                              "WHERE Num_documento='"+doc+"'"),"Num_ficha");
                                   Id_ficha = con.getSelectStr();
                          
           con.setSelectStr(("SELECT Num_documento  FROM persona WHERE Num_documento='"+doc+"'"),"Num_documento");
           Num_documento = con.getSelectStr();
            
            con.setSelectInt("select id_tipo_persona from persona where num_documento='"+doc+"'","id_tipo_persona");
            Id_tipo_persona=con.getSelectInt();
            
           con.setSelectInt(("SELECT Id_centros  FROM persona WHERE Num_documento='"+doc+"'"),"Id_centros");
           centro = con.getSelectInt();
            
           con.setSelectInt(("SELECT Id_rh FROM persona WHERE Num_documento='"+doc+"'"),"Id_rh");
            Id_rh = con.getSelectInt();
            
            
           
           con.setSelectStr(("SELECT correo FROM persona WHERE Num_documento='"+doc+"'"),"correo");
           correo = con.getSelectStr();
           
           con.setSelectStr(("SELECT Telfono_fijo  FROM persona WHERE Num_documento='"+doc+"'"),"Telfono_fijo");
           Telfono = con.getSelectStr();
           
           con.setSelectStr(("SELECT celular  FROM persona WHERE Num_documento='"+doc+"'"),"celular");
           celular = con.getSelectStr();
           
           con.setSelectStr(("SELECT Direccion  FROM persona WHERE Num_documento='"+doc+"'"),"Direccion");
           direccion = con.getSelectStr();
           
           con.setSelectInt(("SELECT Id_genero  FROM persona WHERE Num_documento='"+doc+"'"),"Id_genero");
           genero = con.getSelectInt();
           
           con.setSelectInt(("SELECT Id_rol  FROM persona WHERE Num_documento='"+doc+"'"),"Id_rol");
           rol = con.getSelectInt();
           
            
           con.setSelectInt(("SELECT Id_tipo_persona  FROM persona WHERE Num_documento='"+doc+"'"),"Id_tipo_persona");
           tipUser = con.getSelectInt();
           
    
            RegistroPersona obj= new RegistroPersona();
            Principal.Escritorio.add(obj);
            
            Dimension desktopSize = Principal.Escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            obj.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            obj.show();
            
            //Rol.txtnombre1.setText(String.valueOf(id));
            obj.cbxTipUser.setSelectedIndex(tipUser);
            obj.txtNombre1.setText(nombre_1);
            obj.txtNombre2.setText(nombre_2);
            obj.txtApellido1.setText(ape_1);
            obj.txtApellido2.setText(ape_2);
            obj.cbxFicha.setSelectedItem(Id_ficha);
            obj.txtDocumento.setText(Num_documento);
            obj.cbxRh.setSelectedItem(Id_rh);
            obj.cbxCentro.setSelectedIndex(centro+1);
            obj.txtEmail.setText(correo);
            obj.txtTelefono.setText(Telfono);
            obj.txtCelular.setText(celular);
            obj.txtDireccion.setText(direccion);
            obj.cbxTipoDoc.setSelectedIndex(Id_tipo_persona+1);
            obj.cbxGenero.setSelectedIndex(genero);
            obj.cbxRh.setSelectedIndex(Id_rh);
            obj.cbxRol.setSelectedIndex(rol);
            String r="C:/Program Files/SCESS/Images/"+Num_documento+".png";
            obj.actfoto(r);
            dispose();
        }else{
            mensajes.Nousuario obj= new mensajes.Nousuario();
            Principal.Escritorio.add(obj);
            Dimension desktopSize = Principal.Escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            obj.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            obj.show();
            jtxtBusca.setText(null);
        }
        
    }//GEN-LAST:event_infActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem inf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPanel jPresult;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnBusca;
    private javax.swing.JComboBox<String> jcbxBusca;
    private javax.swing.JTextField jtxtBusca;
    private javax.swing.JTable tblListaUsuarios;
    // End of variables declaration//GEN-END:variables
}
