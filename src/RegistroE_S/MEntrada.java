/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistroE_S;

import java.awt.Dimension;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mensajes.EntradaNovedad;
import mensajes.EntradaNovedadEq;
import prototipo.Principal;
import static prototipo.Principal.Escritorio;

/**
 *
 * @author Axelshade
 */
public class MEntrada extends javax.swing.JInternalFrame {
    Getset medio=new Getset();
    ConnectBD.Pconnection objc= new ConnectBD.Pconnection();
    String marcaeq;
    String modeloeq;
    String serialeq;
    String select;
    String camp;
    int ideq;
    int doc;
    int idp;
    
    public MEntrada() {
        initComponents();
        jButton1.setEnabled(false);
    }
    
    public static void actfoto(String rt){
        ImageIcon foto = new ImageIcon(rt);
        ImageIcon ico = new ImageIcon(foto.getImage().getScaledInstance(jLFotor.getWidth(), jLFotor.getHeight(), Image.SCALE_DEFAULT));
        jLFotor.setIcon(ico);
    }
    //obtener el id de la persona
    private void Datos(){
      
        
        String cedula;
        cedula=txtdoc.getText();
        objc.setSelectInt(("SELECT id_persona FROM persona WHERE Num_documento='"+cedula+"'"),"id_persona"); 
        idp=objc.getSelectInt();
        System.out.println("datos...ok... "+idp);    
        }
    //obtener id de equipos asociados al id persona
    public  void Idequipos(){
        medio.listacat.clear();
         try{
        Statement stado = objc.getConexion().createStatement();
        ResultSet res = stado.executeQuery("SELECT id_equipos FROM persona_equipos WHERE id_persona='"+idp+"'");
        while(res.next()){
            ideq = res.getInt("id_equipos");
            medio.agregardatos(ideq);
            System.out.println("id equipo.... "+ideq);
        }
        System.out.println("lista.... "+medio.listacat.size());
        }catch(SQLException ex){
            System.out.println(ex);
        }
       
    }
    
    
    
     public void CargarTablaEquiposEntrada(){ 
        JCheckBox checkBox = new JCheckBox();
        DefaultTableModel modelo;
        limpiartabla();
        String[] titulos = {"N°","ID Equipo","Marca","Modelo","Serial","E/S"};
        Object[][] items={};
        modelo= new DefaultTableModel(items, titulos);
        tablaequipos.setModel(modelo); 
        int cont=0;
       
        for(Getset obj: medio.listacat ){
            objc.setSelectInt(("SELECT tipo_ent_sal_equ\n" +
                              "FROM entrada_salida_equipo\n" +
                              "WHERE Id_equipos='"+obj.getId()+"'\n"+
                              "ORDER BY Id_equipos DESC LIMIT 1"),"tipo_ent_sal_equ");
            int TE = objc.getSelectInt();
            
            if(TE!=1){
                objc.setSelectStr(("SELECT Descripcion_marca_equipo \n" +
                                  "FROM marca_equipo as m JOIN equipos as e on m.Id_marca_equipo=e.Id_marca_equipo\n" +
                                  "WHERE Id_equipos='"+obj.getId()+"'"),"Descripcion_marca_equipo");
                marcaeq = objc.getSelectStr();

                objc.setSelectStr(("SELECT Modelo FROM equipos WHERE Id_equipos='"+obj.getId()+"'"),"Modelo");
                modeloeq = objc.getSelectStr();

                objc.setSelectStr(("SELECT Serial FROM equipos WHERE Id_equipos='"+obj.getId()+"'"),"Serial");
                serialeq = objc.getSelectStr();

                cont=cont+1;

                   String marca=marcaeq;
                   String modeloe=modeloeq;
                   String id=String.valueOf(obj.getId());
                   String serial=serialeq;

                   String num=String.valueOf(cont);

                    System.out.println(num+" "+" "+marcaeq+" "+" "+modeloeq+" "+" "+serialeq);
                   Object[]da={num,id,marcaeq,modeloeq,serialeq," "};

                    modelo.addRow(da);

            }
        }
        System.out.println("tabla entrada...ok... ");  

    }
     
     
    public void CargarTablaEquiposSalida(){ 
     
        DefaultTableModel modelo;
        limpiartabla();
        String[] titulos = {"N°","ID Equipo","Marca","Modelo","Serial","E/S"};
        Object[][] items={};
        modelo= new DefaultTableModel(items, titulos);
        tablaequipos.setModel(modelo); 
        int cont=0;
       
        for(Getset obj: medio.listacat ){
            objc.setSelectInt(("SELECT tipo_ent_sal_equ\n" +
                              "FROM entrada_salida_equipo\n" +
                              "WHERE Id_equipos='"+obj.getId()+"'\n"+
                              "ORDER BY Id_equipos DESC LIMIT 1"),"tipo_ent_sal_equ");
            int TE = objc.getSelectInt();
            
            if(TE==1){
                objc.setSelectStr(("SELECT Descripcion_marca_equipo \n" +
                                  "FROM marca_equipo as m JOIN equipos as e on m.Id_marca_equipo=e.Id_marca_equipo\n" +
                                  "WHERE Id_equipos='"+obj.getId()+"'"),"Descripcion_marca_equipo");
                marcaeq = objc.getSelectStr();

                objc.setSelectStr(("SELECT Modelo FROM equipos WHERE Id_equipos='"+obj.getId()+"'"),"Modelo");
                modeloeq = objc.getSelectStr();

                objc.setSelectStr(("SELECT Serial FROM equipos WHERE Id_equipos='"+obj.getId()+"'"),"Serial");
                serialeq = objc.getSelectStr();

                cont=cont+1;

                   String marca=marcaeq;
                   String modeloe=modeloeq;
                   String id=String.valueOf(obj.getId());
                   String serial=serialeq;

                   String num=String.valueOf(cont);

                    System.out.println(num+" "+" "+marcaeq+" "+" "+modeloeq+" "+" "+serialeq);
                   Object[]da={num,id,marcaeq,modeloeq,serialeq," "};

                    modelo.addRow(da);
                
            }
        }
        System.out.println("tabla salida...ok... ");  

    } 
     public void limpiartabla(){
        
        DefaultTableModel modelod = (DefaultTableModel) tablaequipos.getModel();
        modelod = (DefaultTableModel) tablaequipos.getModel();
            int a =modelod.getRowCount();
            for(int i=0; i<a; i++)
                modelod.removeRow(0);
            tablaequipos.setModel(modelod);
            
            
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtnom = new javax.swing.JTextField();
        txtficha = new javax.swing.JTextField();
        txtcentro = new javax.swing.JTextField();
        txtcargo = new javax.swing.JTextField();
        txtdoc = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaequipos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        rbs = new javax.swing.JRadioButton();
        rbe = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtrh = new javax.swing.JTextField();
        jLFotor = new javax.swing.JLabel();

        jMenuItem1.setBackground(new java.awt.Color(51, 255, 51));
        jMenuItem1.setText("Incluir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Registro Entrada");
        setMinimumSize(new java.awt.Dimension(825, 700));
        setPreferredSize(new java.awt.Dimension(825, 700));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(89, 181, 72)), "Registro Entrada/Salida", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 12))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 650));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(300, 100, 80, 14);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("RH:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(660, 170, 50, 16);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Ficha de Formacion:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(300, 240, 125, 16);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Centro:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(300, 310, 48, 16);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Cargo:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(490, 240, 43, 16);

        jButton1.setBackground(new java.awt.Color(89, 181, 72));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton1.setText("Ingresar Datos");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(410, 610, 380, 50);

        txtnom.setEditable(false);
        txtnom.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtnom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtnom);
        txtnom.setBounds(300, 120, 490, 40);

        txtficha.setEditable(false);
        txtficha.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtficha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtficha);
        txtficha.setBounds(300, 260, 170, 40);

        txtcentro.setEditable(false);
        txtcentro.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtcentro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtcentro);
        txtcentro.setBounds(300, 330, 490, 40);

        txtcargo.setEditable(false);
        txtcargo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtcargo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcargoActionPerformed(evt);
            }
        });
        jPanel1.add(txtcargo);
        txtcargo.setBounds(490, 260, 300, 40);

        txtdoc.setEditable(false);
        txtdoc.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtdoc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtdoc);
        txtdoc.setBounds(300, 190, 340, 40);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(20, 1, 1, 1, new java.awt.Color(89, 181, 72)), "Equipos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 11))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 153, 0));

        tablaequipos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaequipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Descripcion", "E/S"
            }
        ));
        tablaequipos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tablaequipos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 380, 770, 220);

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton2.setText("Cancelar Ingreso");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(20, 610, 360, 50);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Estado de Registro"));

        buttonGroup1.add(rbs);
        rbs.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        rbs.setText("Salida");
        rbs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbsActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbe);
        rbe.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        rbe.setText("Entrada");
        rbe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(rbe, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbs, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbe)
                    .addComponent(rbs))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(300, 30, 490, 60);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Documento de Identificación:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 170, 183, 16);

        txtrh.setEditable(false);
        txtrh.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtrh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtrh);
        txtrh.setBounds(660, 190, 130, 40);

        jLFotor.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLFotor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLFotor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLFotor);
        jLFotor.setBounds(20, 40, 260, 330);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        objc.setSelectInt(("SELECT Id_tipo_entrada_salida\n" +
                              "FROM entrada_salida\n" +
                              "WHERE Id_persona='"+idp+"'\n"+
                              "ORDER BY Id_entrada_salida DESC LIMIT 1"),"Id_tipo_entrada_salida");
            int UE = objc.getSelectInt();
            
            System.out.println("ultima entrada--"+UE);
            
        //si es Entrada
        if(rbe.isSelected()){
            jButton1.setEnabled(true);
            if(UE != 1){
                
               int CE=tablaequipos.getRowCount();
               
               for(int i=0;i<CE;i++){
                   if(tablaequipos.getValueAt(i,5).equals("Portado")){
                       int ideq=Integer.parseInt(tablaequipos.getValueAt(i,1).toString());
                       
                       objc.setSelectInt(("SELECT tipo_ent_sal_equ\n" +
                              "FROM entrada_salida_equipo\n" +
                              "WHERE Id_equipos='"+ideq+"'\n"+
                              "ORDER BY Id_entrada_salida DESC LIMIT 1"),"tipo_ent_sal_equ");
                        int UEQ = objc.getSelectInt();
                        System.out.println("ultima entrada Equipo--"+UEQ);
                        
                        if(UEQ != 1){
                        
                            objc.setInsert("INSERT INTO entrada_salida_equipo(`Id_equipos`, `tipo_ent_sal_equ`, `Id_pers`)\n"+ 
                                      "VALUES ("+ideq+",1,"+idp+")");
                        }else{
                            objc.setSelectStr(("SELECT fech_ent_equ\n" +
                              "FROM entrada_salida_equipo\n" +
                              "WHERE Id_equipos='"+ideq+"'\n"+
                              "ORDER BY Id_entrada_salida DESC LIMIT 1"),"fech_ent_equ");
                            String FechaEq = objc.getSelectStr();

                            mensajes.EntradaNovedadEq obj= new mensajes.EntradaNovedadEq();
                            Principal.Escritorio.add(obj);
                            Dimension desktopSize = Principal.Escritorio.getSize();
                            Dimension FrameSize = obj.getSize();
                            obj.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);

                            EntradaNovedadEq.txtUE.setText(FechaEq);
                            EntradaNovedadEq.lus.setVisible(true);
                            EntradaNovedadEq.tipES=1;
                            EntradaNovedadEq.Enidp=idp;
                            EntradaNovedadEq.idequi=ideq;

                            obj.show();
                        }
                   }
               }
                objc.setInsert("INSERT INTO entrada_salida(`Id_persona`, `Id_tipo_entrada_salida`) VALUES ("+idp+",1)");
                
                
                
                mensajes.Mensaje obj= new mensajes.Mensaje();
                Principal.Escritorio.add(obj);
                Dimension desktopSize = Principal.Escritorio.getSize();
                Dimension FrameSize = obj.getSize();
                obj.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                obj.show();
                dispose();
            }else if(UE==1){
                
                
                objc.setSelectStr(("SELECT Fecha_Hora\n" +
                              "FROM entrada_salida\n" +
                              "WHERE Id_persona='"+idp+"'\n"+
                              "ORDER BY Id_entrada_salida DESC LIMIT 1"),"Fecha_Hora");
                String FechaE = objc.getSelectStr();
            
                mensajes.EntradaNovedad obj= new mensajes.EntradaNovedad();
                Principal.Escritorio.add(obj);
                Dimension desktopSize = Principal.Escritorio.getSize();
                Dimension FrameSize = obj.getSize();
                obj.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                
                EntradaNovedad.txtUE.setText(FechaE);
                EntradaNovedad.lus.setVisible(true);
                EntradaNovedad.tipES=1;
                EntradaNovedad.Enidp=idp;
                
                obj.show();
                
            }
        }
        //si es Salida
        if(rbs.isSelected()){
            jButton1.setEnabled(true);
            if(UE != 2){
                
                int CE=tablaequipos.getRowCount();
               
               for(int i=0;i<CE;i++){
                   if(tablaequipos.getValueAt(i,5).equals("Portado")){
                       int ideq=Integer.parseInt(tablaequipos.getValueAt(i,1).toString());
                       
                       objc.setSelectInt(("SELECT tipo_ent_sal_equ\n" +
                              "FROM entrada_salida_equipo\n" +
                              "WHERE Id_equipos='"+ideq+"'\n"+
                              "ORDER BY Id_entrada_salida DESC LIMIT 1"),"tipo_ent_sal_equ");
                        int UEQ = objc.getSelectInt();
                        System.out.println("ultima entrada Equipo--"+UEQ);
                        
                        if(UEQ != 2){
                        
                            objc.setInsert("INSERT INTO entrada_salida_equipo(`Id_equipos`, `tipo_ent_sal_equ`, `Id_pers`)\n"+ 
                                      "VALUES ("+ideq+",2,"+idp+")");
                        }else if(UEQ==2){
                            objc.setSelectStr(("SELECT fech_ent_equ\n" +
                              "FROM entrada_salida_equipo\n" +
                              "WHERE Id_equipos='"+ideq+"'\n"+
                              "ORDER BY Id_entrada_salida DESC LIMIT 1"),"fech_ent_equ");
                            String FechaEq = objc.getSelectStr();

                            mensajes.EntradaNovedadEq obj= new mensajes.EntradaNovedadEq();
                            Principal.Escritorio.add(obj);
                            Dimension desktopSize = Principal.Escritorio.getSize();
                            Dimension FrameSize = obj.getSize();
                            obj.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);

                            EntradaNovedadEq.txtUS.setText(FechaEq);
                            EntradaNovedadEq.lue.setVisible(true);
                            EntradaNovedadEq.tipES=2;
                            EntradaNovedadEq.Enidp=idp;
                            EntradaNovedadEq.idequi=ideq;

                            obj.show();
                        }
                   }
               }
                objc.setInsert("INSERT INTO entrada_salida(`Id_persona`, `Id_tipo_entrada_salida`) VALUES ("+idp+",2)");
                
                mensajes.MensajeSalida obj= new mensajes.MensajeSalida();
                Principal.Escritorio.add(obj);
                Dimension desktopSize = Principal.Escritorio.getSize();
                Dimension FrameSize = obj.getSize();
                obj.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);

                obj.show();
                dispose();
            }else if(UE==2){
                
                objc.setSelectStr(("SELECT Fecha_Hora\n" +
                              "FROM entrada_salida\n" +
                              "WHERE Id_persona='"+idp+"'\n"+
                              "ORDER BY Id_entrada_salida DESC LIMIT 1"),"Fecha_Hora");
                String FechaS = objc.getSelectStr();
            
                mensajes.EntradaNovedad obj= new mensajes.EntradaNovedad();
                Principal.Escritorio.add(obj);
                Dimension desktopSize = Principal.Escritorio.getSize();
                Dimension FrameSize = obj.getSize();
                obj.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                
                EntradaNovedad.txtUS.setText(FechaS);
                EntradaNovedad.lue.setVisible(true);
                EntradaNovedad.tipES=2;
                EntradaNovedad.Enidp=idp;
                
                obj.show();
                
            }
        }else{
            //JOptionPane.showMessageDialog(null,"Por favor seleccione Entrada o Salida");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcargoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MREntradaSalida obj = new MREntradaSalida();
        Escritorio.add(obj);
        Dimension desktopSize = Principal.Escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            obj.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            obj.show();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbsActionPerformed
        limpiartabla();
        Datos();
        Idequipos();
        CargarTablaEquiposSalida();
        System.out.println("boton radio salida..ok");
        jButton1.setEnabled(true);
    }//GEN-LAST:event_rbsActionPerformed

    private void rbeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbeActionPerformed
        limpiartabla();
        Datos();
        Idequipos();
        CargarTablaEquiposEntrada();
        System.out.println("boton radio entrar..ok");
        jButton1.setEnabled(true);
    }//GEN-LAST:event_rbeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int posicion;
        posicion=tablaequipos.getSelectedRow();
        String A,B;
        if(posicion>=0){
            A=tablaequipos.getValueAt(posicion,1).toString();
            if(tablaequipos.getValueAt(posicion,5).equals(" ")){
                tablaequipos.setValueAt("Portado", posicion, 5);
            }else if(tablaequipos.getValueAt(posicion,5).equals("Portado")){
                tablaequipos.setValueAt(" ", posicion, 5);
            }
            //System.out.println(A);
           
        }
        else{
            JOptionPane.showMessageDialog(this,"Seleccione una fila");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JLabel jLFotor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbe;
    private javax.swing.JRadioButton rbs;
    public static javax.swing.JTable tablaequipos;
    public static javax.swing.JTextField txtcargo;
    public static javax.swing.JTextField txtcentro;
    public static javax.swing.JTextField txtdoc;
    public static javax.swing.JTextField txtficha;
    public static javax.swing.JTextField txtnom;
    public static javax.swing.JTextField txtrh;
    // End of variables declaration//GEN-END:variables
}
