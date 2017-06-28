
package RegistroE_S;

import ConnectBD.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import login.loginf;
import mensajes.MensajeNov;


public class operador extends javax.swing.JFrame {
    
    public class NombreBD extends Thread{
        
        public void run(){
            while (true){
                lblnombre.setText(login.loginf.nombre);
                lblrol.setText(login.loginf.rol);
                Thread.interrupted();
            }
        }
   }
    
   public void Reiniciar(){
        textid.setText("");
        hhome.setVisible(false);
        formentrada.setVisible(true);
        entradaysalida.setVisible(false);
   }
    Propiedades pk = new Propiedades();
    String Server = pk.getServer();
    File ruta = new File("//"+Server+"/fotos");

        Getset medio=new Getset();
        Pconnection objc= new Pconnection();
        String marcaeq;
        String modeloeq;
        String serialeq;
        String select;
        String camp;
        int ideq;
        int doc;
        int idp;
    
    String jo = "<html><body> <b style =\"font-size: 20; color: white;\"> ";
    private void Jpaint(){
        UIManager.put("OptionPane.background", new ColorUIResource(89,200,72));
        UIManager.put("Button.background", Color.orange);
        UIManager.put("Panel.background", new ColorUIResource(89,200,72));
    }
    Icon error = new ImageIcon(getClass().getResource("/Imagenes/advertencia122x122.png"));
    Icon ok = new ImageIcon(getClass().getResource("/Imagenes/check-in122x122px.png"));
    Icon joke = new ImageIcon(getClass().getResource("/Imagenes/logo.jpg"));
    
    Pconnection con= new Pconnection();
    public operador() throws IOException{
        initComponents();
        
        NombreBD nmb = new NombreBD();
        nmb.start();
        
        //inicio en false las vistas
        setLblColor(btnhome);
        

        this.setLocationRelativeTo(null);
        Border border = LineBorder.createGrayLineBorder();
        imagen.setBorder(border);
        
        //inicio el boton ingresar en false
        btningresar.setEnabled(false);
        
        
        
      
    }
    
    public static void fotoPer(String rt){
        ImageIcon foto = new ImageIcon(rt);
        ImageIcon ico = new ImageIcon(foto.getImage().getScaledInstance(jLFotor.getWidth(), jLFotor.getHeight(), Image.SCALE_DEFAULT));
        jLFotor.setIcon(ico);
                       
    }
    
    
    
    public static void actfoto(String rt){
        ImageIcon foto = new ImageIcon(rt);
        ImageIcon ico = new ImageIcon(foto.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(ico);
                       
    }
    
    public int x=0,y=0;
    public String id_documento, nombre_1, ape_1, id_ficha, txt, busquedasrt, nombre,Ficha,centro,cargo,rh;
    public int id;
    public String busq = "";
    private int cedula;
    DefaultTableModel modeloe;

    public Image getIconImage(){
       Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logo3.png"));
       return retvalue;
    }
    
    //obtener el id de la persona
    public void Datos(){
      
        
        
        //cedula=Integer.parseInt(txtdoc.getText());
        objc.setSelectInt(("SELECT PERnumDoc FROM persona WHERE PERnumDoc='"+cedula+"'"),"PERnumDoc"); 
        int temced=objc.getSelectInt();
        System.out.println("cedula...bd... "+temced); 
        
        
        if(temced==cedula){
            

                objc.setSelectInt(("SELECT PERidPerPK FROM persona WHERE PERnumDoc='"+cedula+"'"),"PERidPerPK"); 
                idp=objc.getSelectInt();
                System.out.println("datos...ok... "+idp); 
            
                objc.setSelectStr(("SELECT concat(`PERnom1`,' ', `PERnom2`,' ', `PERape1`,' ', `PERape2`) AS Nombre FROM persona WHERE PERnumDoc='"+cedula+"'"),"Nombre");
                nombre = objc.getSelectStr();
                
                objc.setSelectStr(("SELECT FICdesFic \n" +
                        "FROM ficha as f JOIN persona as p on f.FICidFicPK=p.PERidFicFK\n" +
                        "WHERE PERnumDoc='"+cedula+"'"),"FICdesFic");
                Ficha = objc.getSelectStr();
                
                objc.setSelectStr(("SELECT CENnomCen \n" +
                        "FROM centros as c JOIN persona as p on c.CENidCenPK=p.PERidCenFK\n" +
                        "WHERE PERnumDoc='"+cedula+"'"),"CENnomCen");
                centro = objc.getSelectStr();
                
                objc.setSelectStr(("SELECT TPdeTiPe \n" +
                        "FROM tipper as t JOIN persona as p on t.TPidTiPePK=p.PERidTiPeFK\n" +
                        "WHERE PERnumDoc='"+cedula+"'"),"TPdeTiPe");
                cargo = objc.getSelectStr();
                
                objc.setSelectStr(("SELECT RHdesRh \n" +
                        "FROM rh as r JOIN persona as p on r.RHidRhPK=p.PERidRhFK\n" +
                        "WHERE PERnumDoc='"+cedula+"'"),"RHdesRh");
                rh = objc.getSelectStr();
                
                
                                
                txtdoc.setText(String.valueOf(cedula));
                txtnom.setText(nombre);
                txtficha.setText(Ficha);
                txtcentro.setText(centro);
                txtcargo.setText(cargo);
                txtrh.setText(rh);
                
                hhome.setVisible(false);
                formentrada.setVisible(false);
                entradaysalida.setVisible(true);
        }else{
           Jpaint();
           String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Error: <br> EL Usuario NO se encuentra Registrado </b> </body> </html>";
           JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,error);
            textid.setText("");
            System.out.println("No se encuentra usuario");
        }
    }
    //obtener id de equipos asociados al id persona
    public  void Idequipos(){
        medio.listacat.clear();
         try{
        Statement stado = objc.getConexion().createStatement();
        ResultSet res = stado.executeQuery("SELECT PEidEquFK FROM perequ WHERE PEidPerFK='"+idp+"'");
        while(res.next()){
            ideq = res.getInt("PEidEquFK");
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
            objc.setSelectInt(("SELECT ESQtiEnSaEq\n" +
                              "FROM entsalequ\n" +
                              "WHERE ESQidEquFK='"+obj.getId()+"'\n"+
                              "ORDER BY ESQidEnSaFK DESC LIMIT 1"),"ESQtiEnSaEq");
            int TE = objc.getSelectInt();
            
            if(TE!=1){
                objc.setSelectStr(("SELECT MEdeMaEq \n" +
                                  "FROM marequ as m JOIN equipos as e on m.MEidMaEqPK=e.EQUidEquPK\n" +
                                  "WHERE EQUidEquPK='"+obj.getId()+"'"),"MEdeMaEq");
                marcaeq = objc.getSelectStr();

                objc.setSelectStr(("SELECT EQUmod FROM equipos WHERE EQUidEquPK='"+obj.getId()+"'"),"EQUmod");
                modeloeq = objc.getSelectStr();

                objc.setSelectStr(("SELECT EQUser FROM equipos WHERE EQUidEquPK='"+obj.getId()+"'"),"EQUser");
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
            objc.setSelectInt(("SELECT ESQtiEnSaEq\n" +
                              "FROM entsalequ\n" +
                              "WHERE ESQidEquFK='"+obj.getId()+"'\n"+
                              "ORDER BY ESQidEnSaFK DESC LIMIT 1"),"ESQtiEnSaEq");
            int TE = objc.getSelectInt();
            
            if(TE==1){
                objc.setSelectStr(("SELECT MEdeMaEq \n" +
                                  "FROM marequ as m JOIN equipos as e on m.MEidMaEqPK=e.EQUidEquPK\n" +
                                  "WHERE EQUidEquPK='"+obj.getId()+"'"),"MEdeMaEq");
                marcaeq = objc.getSelectStr();

                objc.setSelectStr(("SELECT EQUmod FROM equipos WHERE EQUidEquPK='"+obj.getId()+"'"),"EQUmod");
                modeloeq = objc.getSelectStr();

                objc.setSelectStr(("SELECT EQUser FROM equipos WHERE EQUidEquPK='"+obj.getId()+"'"),"EQUser");
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

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        barralateral = new javax.swing.JPanel();
        btnhome = new javax.swing.JLabel();
        btnlogout = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        btnminimizar = new javax.swing.JLabel();
        btncerrar = new javax.swing.JLabel();
        barra = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        hhome = new javax.swing.JPanel();
        etiquetanombre = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        etiquetatrol = new javax.swing.JLabel();
        lblrol = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        btnentradaysalida = new javax.swing.JLabel();
        formentrada = new javax.swing.JPanel();
        etiquetanombre1 = new javax.swing.JLabel();
        separador1 = new javax.swing.JPanel();
        textid = new javax.swing.JTextField();
        btnguardar = new javax.swing.JLabel();
        entradaysalida = new javax.swing.JPanel();
        rbe = new javax.swing.JRadioButton();
        rbs = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtdoc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtrh = new javax.swing.JTextField();
        txtficha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcargo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcentro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaequipos = new javax.swing.JTable();
        btncancelar = new javax.swing.JLabel();
        btningresar = new javax.swing.JLabel();
        jLFotor = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem1.setBackground(new java.awt.Color(51, 255, 51));
        jMenuItem1.setText("Incluir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barralateral.setBackground(new java.awt.Color(89, 181, 72));
        barralateral.setToolTipText("");
        barralateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome.setBackground(new java.awt.Color(89, 181, 72));
        btnhome.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnhome.setForeground(new java.awt.Color(255, 255, 255));
        btnhome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/casa.png"))); // NOI18N
        btnhome.setText("Inicio");
        btnhome.setToolTipText("");
        btnhome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnhome.setIconTextGap(1);
        btnhome.setName(""); // NOI18N
        btnhome.setOpaque(true);
        btnhome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhomeMouseClicked(evt);
            }
        });
        barralateral.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 70, 70));

        btnlogout.setBackground(new java.awt.Color(89, 181, 72));
        btnlogout.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnlogout.setForeground(new java.awt.Color(255, 255, 255));
        btnlogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlogout.setText("LogOut");
        btnlogout.setToolTipText("");
        btnlogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnlogout.setIconTextGap(1);
        btnlogout.setMaximumSize(new java.awt.Dimension(41, 56));
        btnlogout.setMinimumSize(new java.awt.Dimension(41, 56));
        btnlogout.setName(""); // NOI18N
        btnlogout.setOpaque(true);
        btnlogout.setPreferredSize(new java.awt.Dimension(41, 56));
        btnlogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogoutMouseClicked(evt);
            }
        });
        barralateral.add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 70, 70));

        getContentPane().add(barralateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 460));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnminimizar.setBackground(new java.awt.Color(255, 255, 255));
        btnminimizar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnminimizar.setForeground(new java.awt.Color(89, 181, 72));
        btnminimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimizar.png"))); // NOI18N
        btnminimizar.setToolTipText("Minimizar");
        btnminimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnminimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnminimizarMouseClicked(evt);
            }
        });
        header.add(btnminimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        btncerrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btncerrar.setForeground(new java.awt.Color(89, 181, 72));
        btncerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        btncerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncerrarMouseClicked(evt);
            }
        });
        header.add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, -1));

        barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        barra.setFocusable(false);
        barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraMouseDragged(evt);
            }
        });
        barra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraMousePressed(evt);
            }
        });
        header.add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 840, 60));

        titulo.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        titulo.setForeground(new java.awt.Color(252, 115, 35));
        titulo.setText("S.C.E.S.S");
        titulo.setToolTipText("");
        header.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 170, 40));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 40));

        body.setLayout(new java.awt.CardLayout());

        hhome.setBackground(new java.awt.Color(255, 255, 255));

        etiquetanombre.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiquetanombre.setForeground(new java.awt.Color(89, 181, 72));
        etiquetanombre.setText("Bienvenido(a):");

        lblnombre.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(89, 181, 72));
        lblnombre.setText("Gustavo Risueño");

        etiquetatrol.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        etiquetatrol.setForeground(new java.awt.Color(89, 181, 72));
        etiquetatrol.setText("Rol:");

        lblrol.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblrol.setForeground(new java.awt.Color(89, 181, 72));
        lblrol.setText("Administrador");

        imagen.setOpaque(true);

        btnentradaysalida.setBackground(new java.awt.Color(255, 255, 255));
        btnentradaysalida.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnentradaysalida.setForeground(new java.awt.Color(89, 181, 72));
        btnentradaysalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnentradaysalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/puerta-abierta-esbozada.png"))); // NOI18N
        btnentradaysalida.setText("Entrada y Salida");
        btnentradaysalida.setToolTipText("");
        btnentradaysalida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnentradaysalida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnentradaysalida.setIconTextGap(1);
        btnentradaysalida.setName(""); // NOI18N
        btnentradaysalida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnentradaysalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnentradaysalidaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hhomeLayout = new javax.swing.GroupLayout(hhome);
        hhome.setLayout(hhomeLayout);
        hhomeLayout.setHorizontalGroup(
            hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hhomeLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hhomeLayout.createSequentialGroup()
                        .addComponent(etiquetanombre)
                        .addGap(3, 3, 3)
                        .addComponent(lblnombre))
                    .addGroup(hhomeLayout.createSequentialGroup()
                        .addComponent(etiquetatrol)
                        .addGap(7, 7, 7)
                        .addComponent(lblrol)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hhomeLayout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addComponent(btnentradaysalida, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(298, 298, 298))
        );
        hhomeLayout.setVerticalGroup(
            hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hhomeLayout.createSequentialGroup()
                .addGroup(hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hhomeLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetanombre)
                            .addComponent(lblnombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetatrol)
                            .addComponent(lblrol)))
                    .addGroup(hhomeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(btnentradaysalida, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        body.add(hhome, "card2");

        formentrada.setBackground(new java.awt.Color(255, 255, 255));
        formentrada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiquetanombre1.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        etiquetanombre1.setForeground(new java.awt.Color(89, 181, 72));
        etiquetanombre1.setText("Ingrese ID");
        formentrada.add(etiquetanombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 200, 48));

        separador1.setBackground(new java.awt.Color(252, 115, 35));
        separador1.setForeground(new java.awt.Color(252, 115, 35));
        separador1.setPreferredSize(new java.awt.Dimension(172, 2));
        separador1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador1Layout = new javax.swing.GroupLayout(separador1);
        separador1.setLayout(separador1Layout);
        separador1Layout.setHorizontalGroup(
            separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        separador1Layout.setVerticalGroup(
            separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        formentrada.add(separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 270, -1));

        textid.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        textid.setForeground(new java.awt.Color(252, 115, 35));
        textid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textid.setBorder(null);
        textid.setOpaque(false);
        textid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textidKeyReleased(evt);
            }
        });
        formentrada.add(textid, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 270, 30));

        btnguardar.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(89, 181, 72));
        btnguardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnguardar.setText("OK");
        btnguardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguardarMouseClicked(evt);
            }
        });
        formentrada.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 90, -1));

        body.add(formentrada, "card3");

        entradaysalida.setBackground(new java.awt.Color(255, 255, 255));
        entradaysalida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbe.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbe);
        rbe.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        rbe.setForeground(new java.awt.Color(89, 181, 72));
        rbe.setText("Entrada");
        rbe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbeActionPerformed(evt);
            }
        });
        entradaysalida.add(rbe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, 50));

        rbs.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbs);
        rbs.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        rbs.setForeground(new java.awt.Color(89, 181, 72));
        rbs.setText("Salida");
        rbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbsActionPerformed(evt);
            }
        });
        entradaysalida.add(rbs, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 130, 50));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(89, 181, 72));
        jLabel1.setText("Nombre:");
        entradaysalida.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 80, 20));

        txtnom.setEditable(false);
        txtnom.setBackground(new java.awt.Color(255, 255, 255));
        txtnom.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtnom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });
        entradaysalida.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 300, 30));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(89, 181, 72));
        jLabel2.setText("N° de Identificación:");
        entradaysalida.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 190, 20));

        txtdoc.setEditable(false);
        txtdoc.setBackground(new java.awt.Color(255, 255, 255));
        txtdoc.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtdoc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocActionPerformed(evt);
            }
        });
        entradaysalida.add(txtdoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 190, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(89, 181, 72));
        jLabel3.setText("RH:");
        entradaysalida.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 30, 20));

        txtrh.setEditable(false);
        txtrh.setBackground(new java.awt.Color(255, 255, 255));
        txtrh.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtrh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtrh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrhActionPerformed(evt);
            }
        });
        entradaysalida.add(txtrh, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 90, 30));

        txtficha.setEditable(false);
        txtficha.setBackground(new java.awt.Color(255, 255, 255));
        txtficha.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtficha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtficha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfichaActionPerformed(evt);
            }
        });
        entradaysalida.add(txtficha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 170, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(89, 181, 72));
        jLabel4.setText("Ficha de Formacion:");
        entradaysalida.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 170, 20));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(89, 181, 72));
        jLabel5.setText("Cargo:");
        entradaysalida.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 70, 20));

        txtcargo.setEditable(false);
        txtcargo.setBackground(new java.awt.Color(255, 255, 255));
        txtcargo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtcargo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcargoActionPerformed(evt);
            }
        });
        entradaysalida.add(txtcargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 110, 30));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(89, 181, 72));
        jLabel6.setText("Centro:");
        entradaysalida.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 70, 20));

        txtcentro.setEditable(false);
        txtcentro.setBackground(new java.awt.Color(255, 255, 255));
        txtcentro.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtcentro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcentroActionPerformed(evt);
            }
        });
        entradaysalida.add(txtcentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 300, 30));

        tablaequipos.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        tablaequipos.setForeground(new java.awt.Color(89, 181, 72));
        tablaequipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaequipos.setComponentPopupMenu(jPopupMenu1);
        tablaequipos.setGridColor(new java.awt.Color(89, 181, 72));
        tablaequipos.setSelectionBackground(new java.awt.Color(89, 181, 72));
        jScrollPane1.setViewportView(tablaequipos);

        entradaysalida.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 420, 240));

        btncancelar.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(89, 181, 72));
        btncancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btncancelar.setText("Cancelar");
        btncancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelarMouseClicked(evt);
            }
        });
        entradaysalida.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 130, -1));

        btningresar.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btningresar.setForeground(new java.awt.Color(89, 181, 72));
        btningresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btningresar.setText("Ingresar");
        btningresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btningresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btningresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btningresarMouseClicked(evt);
            }
        });
        entradaysalida.add(btningresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 130, -1));

        jLFotor.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLFotor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLFotor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        entradaysalida.add(jLFotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 110, 110));

        body.add(entradaysalida, "card4");

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 760, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncerrarMouseClicked
        Jpaint();
        String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> ¿Desea Salir del Programa?</b></body> </html>";
        int codigo=JOptionPane.showConfirmDialog(null,jok, "SALIR", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,joke);
        if (codigo==JOptionPane.YES_OPTION){
            System.exit(0);
            con.cerrarConexion();
	}else if(codigo==JOptionPane.NO_OPTION){
			
	}
    }//GEN-LAST:event_btncerrarMouseClicked

    private void btnminimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnminimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnminimizarMouseClicked

    private void barraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y); 
    }//GEN-LAST:event_barraMouseDragged

    private void barraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMousePressed
        x = evt.getX(); 
        y = evt.getY(); 
    }//GEN-LAST:event_barraMousePressed

    private void btnentradaysalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnentradaysalidaMouseClicked
        //switch bettween Jpanels
        hhome.setVisible(false);
        formentrada.setVisible(true);
        entradaysalida.setVisible(false);
        
        
    }//GEN-LAST:event_btnentradaysalidaMouseClicked

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
            hhome.setVisible(true);
            formentrada.setVisible(false);
            entradaysalida.setVisible(false);
            
            
    }//GEN-LAST:event_btnhomeMouseClicked

    private void btnguardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarMouseClicked
            
            cedula=Integer.parseInt(textid.getText());
            System.out.println(cedula);
            String r=ruta+"/"+textid.getText()+".png";
            System.out.println(r);
            fotoPer(r);
            Datos();
            
            
    }//GEN-LAST:event_btnguardarMouseClicked

    private void textidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textidKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cedula=Integer.parseInt(textid.getText());
            String r=ruta+"/"+textid.getText()+".png";
            System.out.println(cedula);
            Datos();
        }
    }//GEN-LAST:event_textidKeyReleased

    private void rbeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbeActionPerformed
        limpiartabla();
        Datos();
        Idequipos();
        CargarTablaEquiposEntrada();
        System.out.println("boton radio entrar..ok");
        btningresar.setEnabled(true);
    }//GEN-LAST:event_rbeActionPerformed

    private void rbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbsActionPerformed
        limpiartabla();
        Datos();
        Idequipos();
        CargarTablaEquiposSalida();
        System.out.println("boton radio salida..ok");
        btningresar.setEnabled(true);
    }//GEN-LAST:event_rbsActionPerformed

    private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomActionPerformed

    private void txtdocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdocActionPerformed

    private void txtrhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrhActionPerformed

    private void txtfichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfichaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfichaActionPerformed

    private void txtcargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcargoActionPerformed

    private void txtcentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcentroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcentroActionPerformed

    private void btncancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarMouseClicked
        
        //switch bettween Jpanels
        textid.setText("");
        hhome.setVisible(false);
        formentrada.setVisible(true);
        entradaysalida.setVisible(false);
    }//GEN-LAST:event_btncancelarMouseClicked

    private void btningresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btningresarMouseClicked
        objc.setSelectInt(("SELECT ESidTiEnSaFK\n" +
                              "FROM entsal\n" +
                              "WHERE ESidPerFK='"+idp+"'\n"+
                              "ORDER BY ESidEntSalPK DESC LIMIT 1"),"ESidTiEnSaFK");
            int UE = objc.getSelectInt();
            
            System.out.println("ultima entrada--"+UE);
            
        //si es Entrada
        if(rbe.isSelected()){
            btningresar.setEnabled(true);
            if(UE == 2 || UE == 3){
                
               int CE=tablaequipos.getRowCount();
               
               for(int i=0;i<CE;i++){
                   if(tablaequipos.getValueAt(i,5).equals("Portado")){
                       int ideq=Integer.parseInt(tablaequipos.getValueAt(i,1).toString());
                       
                       objc.setSelectInt(("SELECT ESQtiEnSaEq\n" +
                              "FROM entsalequ\n" +
                              "WHERE ESQidEquFK='"+ideq+"'\n"+
                              "ORDER BY ESQidEnSaFK DESC LIMIT 1"),"ESQtiEnSaEq");
                        int UEQ = objc.getSelectInt();
                        System.out.println("ultima entrada Equipo--"+UEQ);
                        
                        if(UEQ == 2 || UEQ == 3 || UEQ == 0){
                        
                            objc.setInsert("INSERT INTO entsalequ(`ESQidEquFK`, `ESQtiEnSaEq`, `ESQidPerFK`)\n"+ 
                                      "VALUES ("+ideq+",1,"+idp+")");
                        /*}else{
                            objc.setSelectStr(("SELECT ESQfeEnEq\n" +
                              "FROM entsalequ\n" +
                              "WHERE ESQidEquFK='"+ideq+"'\n"+
                              "ORDER BY ESQidEnSaFK DESC LIMIT 1"),"ESQfeEnEq");
                            String FechaEq = objc.getSelectStr();

                            mensajes.MensajeNov obj= new mensajes.MensajeNov();
                            
                            MensajeNov.txtUE.setText(FechaEq);
                            MensajeNov.lus.setVisible(true);
                            MensajeNov.tipES=1;
                            MensajeNov.Enidp=idp;
                            MensajeNov.idequi=ideq;

                            obj.setVisible(true);*/
                        }
                   }
               }
                objc.setInsert("INSERT INTO entsal(`ESidPerFK`, `ESidTiEnSaFK`) VALUES ("+idp+",1)");
                Jpaint();
                String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Registro Exitoso: <br> EL Registro de Entrada fue exitoso, el usuario puede pasar </b> </body> </html>";
                JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,ok);
                
                textid.setText("");
                hhome.setVisible(false);
                formentrada.setVisible(true);
                entradaysalida.setVisible(false);
                
                System.out.println("registro usuario entrada ok");
                
            }else if(UE==1){
                
                
                objc.setSelectStr(("SELECT ESfecHor\n" +
                              "FROM entsal\n" +
                              "WHERE ESidPerFK='"+idp+"'\n"+
                              "ORDER BY ESidEntSalPK DESC LIMIT 1"),"ESfecHor");
                String FechaE = objc.getSelectStr();
            
                mensajes.MensajeNov obj = null;
                try {
                    obj = new mensajes.MensajeNov();
                } catch (IOException ex) {
                    Logger.getLogger(operador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println("A) ultima entrada: "+FechaE);
                MensajeNov.txtUE.setText(FechaE);
                MensajeNov.lus.setVisible(true);
                MensajeNov.tipES=1;
                MensajeNov.Enidp=idp;
                
                obj.setVisible(true);
                dispose();
            }
        }
        //si es Salida
        if(rbs.isSelected()){
            btningresar.setEnabled(true);
            if(UE == 1 || UE == 3){
                
                int CE=tablaequipos.getRowCount();
               
               for(int i=0;i<CE;i++){
                   if(tablaequipos.getValueAt(i,5).equals("Portado")){
                       int ideq=Integer.parseInt(tablaequipos.getValueAt(i,1).toString());
                       
                       objc.setSelectInt(("SELECT ESQtiEnSaEq\n" +
                              "FROM entsalequ\n" +
                              "WHERE ESQidEquFK='"+ideq+"'\n"+
                              "ORDER BY ESQidEnSaFK DESC LIMIT 1"),"ESQtiEnSaEq");
                        int UEQ = objc.getSelectInt();
                        System.out.println("ultima entrada Equipo--"+UEQ);
                        
                        if(UEQ == 1 || UEQ == 3){
                        
                            objc.setInsert("INSERT INTO entsalequ(`ESQidEquFK`, `ESQtiEnSaEq`, `ESQidPerFK`)\n"+"VALUES ("+ideq+",2,"+idp+")");
                            
                        }else if(UEQ==2 || UEQ==3 || UEQ == 0){
                            objc.setSelectStr(("SELECT ESQfeEnEq\n" +
                              "FROM entsalequ\n" +
                              "WHERE ESQidEquFK='"+ideq+"'\n"+
                              "ORDER BY ESQidEnSaFK DESC LIMIT 1"),"ESQfeEnEq");
                            String FechaEq = objc.getSelectStr();

                        }
                   }
               }
                objc.setInsert("INSERT INTO entsal(`ESidPerFK`, `ESidTiEnSaFK`) VALUES ("+idp+",2)");
                
                Jpaint();
                String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Registro Exitoso: <br> EL Registro de Salida fue exitoso, el usuario puede pasar </b> </body> </html>";
                JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,ok);
                
                textid.setText("");
                hhome.setVisible(false);
                formentrada.setVisible(true);
                entradaysalida.setVisible(false);
                System.out.println("registro usuario salida ok");
                
            }else if(UE==2){
                
                objc.setSelectStr(("SELECT ESfecHor\n" +
                              "FROM entsal\n" +
                              "WHERE ESidPerFK='"+idp+"'\n"+
                              "ORDER BY ESidEntSalPK DESC LIMIT 1"),"ESfecHor");
                String FechaS = objc.getSelectStr();
            
                mensajes.MensajeNov obj = null;
                try {
                    obj = new mensajes.MensajeNov();
                } catch (IOException ex) {
                    Logger.getLogger(operador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println("B) ultima salida: "+FechaS);
                MensajeNov.txtUS.setText(FechaS);
                MensajeNov.lue.setVisible(true);
                MensajeNov.tipES=2;
                MensajeNov.Enidp=idp;
                
                obj.setVisible(true);
                dispose();
            }
        }else{
            //JOptionPane.showMessageDialog(null,"Por favor seleccione Entrada o Salida");
        }
    }//GEN-LAST:event_btningresarMouseClicked

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

    private void btnlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseClicked

        Jpaint();
        String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> ¿Desea Cerrar Sesión?</b> </body> </html>";

        int codigo=JOptionPane.showConfirmDialog(null, jok, "Cerrar Sesion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,joke);
        if (codigo==JOptionPane.YES_OPTION){
            dispose();
            con.cerrarConexion();
            loginf log = null;
            try {
                log = new loginf();
            } catch (IOException ex) {
                Logger.getLogger(operador.class.getName()).log(Level.SEVERE, null, ex);
            }
            log.setVisible(true);
        }
    }//GEN-LAST:event_btnlogoutMouseClicked

    // ------------switch between colors for Active/Inactive color
    public void setLblColor(JLabel lbl)
    {
        lbl.setBackground(new Color(0,150,62));
    }
    
      public void resetLblColor(JLabel lbl)
    {
        lbl.setBackground(new Color(89,181,72));
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        //Change UI look of table.
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(operador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(operador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(operador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(operador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new operador().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(operador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barra;
    private javax.swing.JPanel barralateral;
    private javax.swing.JPanel body;
    private javax.swing.JLabel btncancelar;
    private javax.swing.JLabel btncerrar;
    private javax.swing.JLabel btnentradaysalida;
    private javax.swing.JLabel btnguardar;
    private javax.swing.JLabel btnhome;
    private javax.swing.JLabel btningresar;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JLabel btnminimizar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel entradaysalida;
    private javax.swing.JLabel etiquetanombre;
    private javax.swing.JLabel etiquetanombre1;
    private javax.swing.JLabel etiquetatrol;
    private javax.swing.JPanel formentrada;
    private javax.swing.JPanel header;
    private javax.swing.JPanel hhome;
    public static javax.swing.JLabel imagen;
    private javax.swing.JFrame jFrame1;
    public static javax.swing.JLabel jLFotor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblrol;
    private javax.swing.JRadioButton rbe;
    private javax.swing.JRadioButton rbs;
    private javax.swing.JPanel separador1;
    public static javax.swing.JTable tablaequipos;
    public static javax.swing.JTextField textid;
    private javax.swing.JLabel titulo;
    public static javax.swing.JTextField txtcargo;
    public static javax.swing.JTextField txtcentro;
    public static javax.swing.JTextField txtdoc;
    public static javax.swing.JTextField txtficha;
    public static javax.swing.JTextField txtnom;
    public static javax.swing.JTextField txtrh;
    // End of variables declaration//GEN-END:variables
}
