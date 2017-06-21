
package prototipo;





import static RegistroE_S.MEntrada.tablaequipos;
import RegistroE_S.MREntradaSalida;
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
import mensajes.EntradaNovedad;
import mensajes.EntradaNovedadEq;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import prototipo.Getset;
import prototipo.Principal;
import prototipo.Principal;
import static prototipo.Principal.Escritorio;

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
    
ConnectBD.Pconnection con= new ConnectBD.Pconnection();
    public operador() {
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
    
    public static void actfoto(String rt){
        ImageIcon foto = new ImageIcon(rt);
        ImageIcon ico = new ImageIcon(foto.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(ico);
                       
    }
    
    public int x=0,y=0;
    public String id_documento, nombre_1, ape_1, id_ficha, txt, busquedasrt;
    public int id;
    public String busq = "";
    private int cedula;
    DefaultTableModel modeloe;

    public Image getIconImage(){
       Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logo3.png"));
       return retvalue;
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

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        barralateral = new javax.swing.JPanel();
        btnhome = new javax.swing.JLabel();
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
        txtnom2 = new javax.swing.JTextField();
        txtnom3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnom4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtnom5 = new javax.swing.JTextField();
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

        textid.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
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

        txtnom2.setEditable(false);
        txtnom2.setBackground(new java.awt.Color(255, 255, 255));
        txtnom2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtnom2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom2ActionPerformed(evt);
            }
        });
        entradaysalida.add(txtnom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 90, 30));

        txtnom3.setEditable(false);
        txtnom3.setBackground(new java.awt.Color(255, 255, 255));
        txtnom3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtnom3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnom3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom3ActionPerformed(evt);
            }
        });
        entradaysalida.add(txtnom3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 170, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(89, 181, 72));
        jLabel4.setText("Ficha de Formacion:");
        entradaysalida.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 170, 20));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(89, 181, 72));
        jLabel5.setText("Cargo:");
        entradaysalida.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 70, 20));

        txtnom4.setEditable(false);
        txtnom4.setBackground(new java.awt.Color(255, 255, 255));
        txtnom4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtnom4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnom4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom4ActionPerformed(evt);
            }
        });
        entradaysalida.add(txtnom4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 110, 30));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(89, 181, 72));
        jLabel6.setText("Centro:");
        entradaysalida.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 70, 20));

        txtnom5.setEditable(false);
        txtnom5.setBackground(new java.awt.Color(255, 255, 255));
        txtnom5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtnom5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnom5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom5ActionPerformed(evt);
            }
        });
        entradaysalida.add(txtnom5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 300, 30));

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
        
        int codigo=JOptionPane.showConfirmDialog(null, "¿Desea Salir del Programa?", "SALIR", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
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
            hhome.setVisible(false);
            formentrada.setVisible(false);
            entradaysalida.setVisible(true);
            
    }//GEN-LAST:event_btnguardarMouseClicked

    private void textidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textidKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
            hhome.setVisible(false);
            formentrada.setVisible(false);
            entradaysalida.setVisible(true);
            
        
  
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

    private void txtnom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom2ActionPerformed

    private void txtnom3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom3ActionPerformed

    private void txtnom4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom4ActionPerformed

    private void txtnom5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom5ActionPerformed

    private void btncancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarMouseClicked
        
        //switch bettween Jpanels
        hhome.setVisible(false);
        formentrada.setVisible(true);
        entradaysalida.setVisible(false);
    }//GEN-LAST:event_btncancelarMouseClicked

    private void btningresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btningresarMouseClicked
        objc.setSelectInt(("SELECT Id_tipo_entrada_salida\n" +
                              "FROM entrada_salida\n" +
                              "WHERE Id_persona='"+idp+"'\n"+
                              "ORDER BY Id_entrada_salida DESC LIMIT 1"),"Id_tipo_entrada_salida");
            int UE = objc.getSelectInt();
            
            System.out.println("ultima entrada--"+UE);
            
        //si es Entrada
        if(rbe.isSelected()){
            btningresar.setEnabled(true);
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
            btningresar.setEnabled(true);
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
    }//GEN-LAST:event_btningresarMouseClicked

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
                new operador().setVisible(true);
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
    private javax.swing.JLabel btnminimizar;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblrol;
    private javax.swing.JRadioButton rbe;
    private javax.swing.JRadioButton rbs;
    private javax.swing.JPanel separador1;
    public static javax.swing.JTable tablaequipos;
    private javax.swing.JTextField textid;
    private javax.swing.JLabel titulo;
    public static javax.swing.JTextField txtdoc;
    public static javax.swing.JTextField txtnom;
    public static javax.swing.JTextField txtnom2;
    public static javax.swing.JTextField txtnom3;
    public static javax.swing.JTextField txtnom4;
    public static javax.swing.JTextField txtnom5;
    // End of variables declaration//GEN-END:variables
}
