
package EquiposVehiculos;

import ConnectBD.Pconnection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CrudEquipo extends javax.swing.JInternalFrame {

   
    Pconnection con= new Pconnection();
    public CrudEquipo() throws IOException {
        initComponents();
        btnmodificar.setVisible(false);
        cancelarm.setVisible(false);
        otrouno.setVisible(false);
        
        otrodos.setVisible(false);

    }
    
            
    public String modelo, serial,prueba,desc,cod;
    public int tipo,marca,id;
    private int pers,perso,equip,cedula;
    
            
    
    
   // DefaultTableModel  modeloTablae;
    DefaultTableModel modeloe;
    
    
    public void CargarTablaMisEquipos(){        
       
       
       
        
        try{
           obtener();
           
   
          String codigo,tipo,marca,modelo,serial,descripcion; 
            Statement buscar = con.getConexion().createStatement();
                
                
                      con.setSelectInt("SELECT Id_persona FROM persona WHERE Num_documento='"+cedula+"'", "Id_persona");
              
                   id=con.getSelectInt();
              
  
            ResultSet mostrar=buscar.executeQuery("select id_equipos,clase_equipo,descripcion_marca_equipo,modelo,serial,Descripcion\n" +
"from equipos\n" +
"inner join tipo_equipo on id_tipo=id_tipo_equipo\n" +
"inner join marca_equipo on id_marca=id_marca_equipo\n" +
"inner join persona_equipos on id_equipos=id_equi \n" +
"where id_pers='"+id+"' order by Id_equipos;");
                
                
                String[] titulos = {"Código","Tipo","Marca","Modelo","Serial","Descripcion"};
        DefaultTableModel modeloe=new DefaultTableModel();
        modeloe.setColumnIdentifiers(titulos);
        //modeloe= new DefaultTableModel(titulos);
         
        
        while(mostrar.next()){
                   codigo=mostrar.getString("Id_equipos");
                   tipo=mostrar.getString("Clase_equipo");
                   marca=mostrar.getString("descripcion_marca_equipo");
                   modelo=mostrar.getString("Modelo");
                   serial=mostrar.getString("Serial");
                   descripcion=mostrar.getString("Descripcion");
                   modeloe.addRow(new Object[]{codigo,tipo,marca,modelo,serial,descripcion});
        }
       
       tblListaEquipos.setModel(modeloe);
       
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error de MySql");
            }catch(Exception err){
                JOptionPane.showMessageDialog(null,"Se ha encontrado un error inesperado: "+err.getMessage());
        }
        
   
    }
    
  
   public void otros(){
       boolean act=tipobox.getSelectedItem().equals("Otros");
       otrouno.setVisible(act);
       
   }
    
   
  public void obtener(){
     
     cedula = Integer.parseInt(txtid.getText());
      
     tipo = tipobox.getSelectedIndex();
     
      
     marca = marcabox.getSelectedIndex();
     
     serial = serialtxt.getText();
     modelo = modelotxt.getText();
     desc = desctxt.getText();
 
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Opciones = new javax.swing.JPopupMenu();
        Modificar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        otrodos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        marcabox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        serialtxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        modelotxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tipobox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        otrouno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        desctxt = new javax.swing.JTextArea();
        btnguardar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListaEquipos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtbuscar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        cancelarm = new javax.swing.JButton();

        Opciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpcionesMouseClicked(evt);
            }
        });

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        Opciones.add(Modificar);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        Opciones.add(Eliminar);

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Equipos"));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Otro:");

        otrodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otrodosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Marca:");

        marcabox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "ACER", "ASUS", "APPLE", "DELL", "GATEWAY", "HP", "LENOVO", "LG", "PC SMART", "THOSIBA", "SONY", "OTROS" }));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Modelo:");

        jLabel4.setText("Serial:");

        modelotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelotxtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Tipo:");

        tipobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Portatil", "Tablet", "Celular", "Proyector", "Otros" }));
        tipobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoboxItemStateChanged(evt);
            }
        });
        tipobox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tipoboxMouseClicked(evt);
            }
        });
        tipobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoboxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setText("Otro:");

        otrouno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otrounoActionPerformed(evt);
            }
        });

        jLabel7.setText("Descripcion:");

        desctxt.setColumns(20);
        desctxt.setRows(5);
        jScrollPane1.setViewportView(desctxt);

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        btnguardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnguardarKeyPressed(evt);
            }
        });

        salir.setText("Cancelar");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 2, 2), 2, true), "Mis Equipos"));

        tblListaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblListaEquipos.setComponentPopupMenu(Opciones);
        tblListaEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaEquiposMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblListaEquipos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setText("Cedula:");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        txtbuscar.setText("Buscar");
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        btnmodificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnmodificarKeyPressed(evt);
            }
        });

        cancelarm.setText("Cancelar");
        cancelarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(tipobox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(otrouno))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 405, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(marcabox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(otrodos))
                                    .addComponent(serialtxt)))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modelotxt))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(salir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelarm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnmodificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnguardar)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txtbuscar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbuscar))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(otrouno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tipobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(otrodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(marcabox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(modelotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(serialtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnguardar)
                        .addComponent(btnmodificar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(salir)
                        .addComponent(cancelarm)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void otrodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otrodosActionPerformed
        
    }//GEN-LAST:event_otrodosActionPerformed

    private void otrounoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otrounoActionPerformed


    }//GEN-LAST:event_otrounoActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void tblListaEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaEquiposMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListaEquiposMouseClicked

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        int posicion;
        
        posicion=tblListaEquipos.getSelectedRow();
        
        if(posicion>=0){
            btnguardar.setVisible(false);
        btnmodificar.setVisible(true);
        cod=tblListaEquipos.getValueAt(posicion, 0).toString();
           tipobox.setSelectedItem(tblListaEquipos.getValueAt(posicion, 1).toString());
           marcabox.setSelectedItem(tblListaEquipos.getValueAt(posicion, 2).toString());
           modelotxt.setText(tblListaEquipos.getValueAt(posicion, 3).toString());
           serialtxt.setText(tblListaEquipos.getValueAt(posicion, 4).toString());
           desctxt.setText(tblListaEquipos.getValueAt(posicion, 5).toString());
           
           salir.setVisible(false);
           cancelarm.setVisible(true);
           
        }else{
            JOptionPane.showMessageDialog(null, "No ha seleccionado la fila");
        }
    }//GEN-LAST:event_ModificarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int posicion;
        posicion=tblListaEquipos.getSelectedRow();
        
        
        int confirmado =JOptionPane.showConfirmDialog(null, "Desea eliminar este dato", "Eliminar Dato", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

        String cod="";

if (JOptionPane.YES_OPTION == confirmado){
    cod=tblListaEquipos.getValueAt(posicion, 0).toString();
            cod=tblListaEquipos.getValueAt(posicion, 0).toString();
            con.setDelete("delete from persona_equipos where id_equi='"+cod+"'");
            con.setDelete("delete from equipos where id_equipos='"+cod+"'");
            //con.setDelete("delete from persona_equipos where id_equi='"+cod+"'");
            
            
            
            JOptionPane.showMessageDialog(null, "Eliminado Exitosamente");

       CargarTablaMisEquipos();
}else{
    
}
   


            
        

    }//GEN-LAST:event_EliminarActionPerformed

    private void OpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_OpcionesMouseClicked

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
    
        obtener();

            pers=0;
             equip=0;
                

                con.setInsert("insert into equipos (Id_marca, Modelo, Serial, Id_tipo, Descripcion)values('"+marca+"','"+modelo+"','"+serial
                        + "','"+tipo+"','"+desc+"')");
               
                con.setSelectInt("SELECT Id_persona FROM persona WHERE Num_documento='"+cedula+"'", "Id_persona");
               
                   pers=con.getSelectInt();        
        
                con.setSelectInt("SELECT MAX(Id_equipos) AS id FROM equipos", "id");

                   equip=con.getSelectInt();
                  
                con.setInsert("insert into persona_equipos (Id_pers, Id_equi)values('"+pers+"','"+equip+"')");

                JOptionPane.showMessageDialog(null, "Guardado Exitosamente");

                marcabox.setSelectedItem("Seleccione");
                tipobox.setSelectedItem("Seleccione");
                modelotxt.setText("");
                serialtxt.setText("");
                desctxt.setText("");
                
                CargarTablaMisEquipos();

               
               
           
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnguardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
        }
    }//GEN-LAST:event_btnguardarKeyPressed

    private void modelotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelotxtActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
         
        
    }//GEN-LAST:event_txtidActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
obtener();
CargarTablaMisEquipos();

    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        
        con.setUpdate("update equipos set Id_marca='"+marcabox.getSelectedIndex()+"',Modelo='"+modelotxt.getText()+"',Serial='"+serialtxt.getText()+"',Id_tipo='"+tipobox.getSelectedIndex()+"',Descripcion='"+desctxt.getText()+"' where Id_equipos='"+cod+"'");
        
        JOptionPane.showMessageDialog(null, "Modificado Exitosamente");
        btnmodificar.setVisible(false);
        btnguardar.setVisible(true);
        

                marcabox.setSelectedItem("Seleccione");
                tipobox.setSelectedItem("Seleccione");
                modelotxt.setText("");
                serialtxt.setText("");
                desctxt.setText("");
                
                CargarTablaMisEquipos();

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btnmodificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnmodificarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmodificarKeyPressed

    private void tipoboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoboxItemStateChanged
       if(tipobox.getSelectedItem().equals("Otros")){
          otrouno.setVisible(true);
           
       }else if(marcabox.getSelectedItem().equals("OTROS")){
           otrodos.setVisible(true);
       }
    }//GEN-LAST:event_tipoboxItemStateChanged

    private void tipoboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoboxActionPerformed
        otros();
    }//GEN-LAST:event_tipoboxActionPerformed

    private void tipoboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoboxMouseClicked
        if(tipobox.getSelectedItem().equals("Otros")){
          otrouno.setVisible(true);
           
       }else if(marcabox.getSelectedItem().equals("OTROS")){
           otrodos.setVisible(true);
       }
    }//GEN-LAST:event_tipoboxMouseClicked

    private void cancelarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarmActionPerformed
        marcabox.setSelectedItem("Seleccione");
        tipobox.setSelectedItem("Seleccione");
        modelotxt.setText("");
        serialtxt.setText("");
        desctxt.setText("");
        btnmodificar.setVisible(false);
        btnguardar.setVisible(true);
        
                
        
    }//GEN-LAST:event_cancelarmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JMenuItem Modificar;
    private javax.swing.JPopupMenu Opciones;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton cancelarm;
    private javax.swing.JTextArea desctxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> marcabox;
    private javax.swing.JTextField modelotxt;
    private javax.swing.JTextField otrodos;
    private javax.swing.JTextField otrouno;
    private javax.swing.JButton salir;
    private javax.swing.JTextField serialtxt;
    private javax.swing.JTable tblListaEquipos;
    private javax.swing.JComboBox<String> tipobox;
    private javax.swing.JButton txtbuscar;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
