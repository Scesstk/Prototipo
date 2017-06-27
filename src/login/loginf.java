
package login;
import java.awt.Toolkit;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import prototipo.Principal;
import ConnectBD.*;
import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultFocusManager;
import javax.swing.Icon;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import prototipo.admin;
import prototipo.operador;
import prototipo.registrador;


public class loginf extends javax.swing.JFrame {

    
    public loginf() throws IOException{
        initComponents();
        this.setLocationRelativeTo(null);
        adv();
        oportunidad();
        //Intercambio de Paneles
        jPConfBD.setVisible(false);
    }
    
    Propiedades pk = new Propiedades();
    String Server = pk.getServer();
   
    
    Pconnection con =new Pconnection();

    public int prueba, cedula, opor=0, conti=0, contp=0, cont=0, cont1=0, cont2=0, cont3=0, cont4=0;
    public static String rol="";
    public String pass,activo,contra;
    public static String nombre="";
    public static int cc;
    String jo = "<html><body> <b style =\"font-size: 20; color: white;\"> ";
    
    //Pinta mensajes JOptionPane
    private void Jpaint(){
        UIManager.put("OptionPane.background", new ColorUIResource(89,200,72));
        UIManager.put("Button.background", Color.orange);
        UIManager.put("Panel.background", new ColorUIResource(89,200,72));
    }
    Icon joke = new ImageIcon(getClass().getResource("/Imagenes/logo.jpg"));

    //extrae contraseña para trabajarla en base de datos
    private void contrasena(){
        char clave[]=txtpass.getPassword();
        String clavedef = new String(clave);
        cedula = Integer.parseInt(txtid.getText());
        pass = clavedef;
    }
    
    //Vista de mensajes
    public void adv(){
    adv1.setVisible(false);
    adv2.setVisible(false);
    adv3.setVisible(false);
    adv4.setVisible(false);
    adv5.setVisible(false);
    }
    
    //MEtodo oportunidad de digitar usuario y clave
    public void oportunidad(){
        switch (opor){
            case 1:
                adv();
                adv1.setVisible(true);
                break;
            case 2:
                adv();
                adv2.setVisible(true);
                break;
            case 3:
                adv();
                adv3.setVisible(true);
                break;
            case 4:
                adv();
                adv4.setVisible(true);
                break;
            case 5:
                adv();
                adv5.setVisible(true);
                btnok.setEnabled(false);
            
                // Bloqueo de usuario en Base de datos con sentencia UPDATE
                con.setUpdate("Update acceso as a JOIN persona as p on a.ACCidPerFK=p.PERidPerPK "
                    + "set ACCact = 'NO' WHERE PERnumDoc = '"+cedula+"'");
                //Cierre de conexion a la base de datos
                con.cerrarConexion();
                //Inhabilita el campo usuario
                txtid.setEditable(false);
                //Inhabilita el campo password
                txtpass.setEditable(false);
                break;
        }
    }
    
    //METODO DE CONEXION A LA BASE DE DATOS
    public void conMySQL(){
        nombre= "";
        
        //Comparacion cedula digitada con base de datos
        con.setSelectInt(("SELECT PERnumDoc FROM persona WHERE PERnumDoc ='"+cedula+"'"),
                "PERnumDoc");
        //Almacenamiento en variable
        cc = con.getSelectInt();
        
        //Extraccion de contraseña en base de datos
        con.setSelectStr(("SELECT ACCcon FROM acceso as a "
                        + "JOIN persona as p on a.ACCidPerFK=p.PERidPerPK WHERE PERnumDoc = '"+cedula+"'"),
                "ACCcon");
        //Almacenamiento en variable
        contra = con.getSelectStr();
        
        //Extraccion Base datos si usuario se encuentra activo
        con.setSelectStr(("SELECT ACCact FROM acceso as a "
                        + "JOIN persona as p on a.ACCidPerFK=p.PERidPerPK WHERE PERnumDoc = '"+cedula+"'"),
                "ACCact");
        //Almacenamiento en variable
        activo = con.getSelectStr();
        
        //Conversion de pasword a MD5
        con.setSelectMd5(pass, pass);
        //Almacenamiento en variable
        pass = con.getMd5();
        
        //Concatenacion del nombre
        con.setSelectStr(("SELECT concat(PERnom1,' ',PERnom2,' ',PERape1,' ',PERape2) as Nombre FROM persona WHERE PERnumDoc ='"+cedula+"'"),
                "Nombre");
        //Almacenamiento en variable 
        nombre = con.getSelectStr();
        
        //Extraccion descripcion del rol
        con.setSelectStr(("SELECT ROLdesRol FROM rol as r "
                        + "JOIN persona as p on r.ROLidRolPK=p.PERidRolFK WHERE PERnumDoc = '"+cedula+"'"), 
                "ROLdesRol");
        //Almacenamiento en variable
        rol = con.getSelectStr();
        
    }
    
    //Metodo valida Acceso
    public void accede(){
        int pr=0;
        try{
            //Linea para validar ingreso de datos de usuario
            pr = Integer.parseInt(txtid.getText());
            //Inicia el metodo de verificacion de contraseña
            contrasena();
            //Ejecuta el metodo de conexion a la base de datos
            conMySQL();
            //Validacion de usuario Activo o no
            if(activo.equals("NO")){

                Jpaint();
                String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Acceso denegado: <br> Su USUARIO \"+nombre+\" no se encuentra ACTIVADO </b> </body> </html>";
                JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
                txtid.setText(null);
                txtpass.setText(null);
            }else {
                //Ejecuta el metodo de acceso al Sistema    
                acceso();
            }
        }catch(Exception ex){
            pr=txtid.getText().length();
            System.out.println(pr);
            if (pr!=0){
                Jpaint();
                String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Acceso denegado: <br> EL usuario no puede contener Caracteres Albabeticos y/o Especiales </b> </body> </html>"+ex;
                JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
            }else {
                Jpaint();
                String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Acceso denegado: <br> EL usuario no puede estar vacío </b> </body> </html>"+ex;
                JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
            }
            
        }
    }
    
    //Metodo Cerrar Login
    private void cerrarVentana(){
        //Cierra Login
        this.dispose();
        //Cierre de conexion a la base de datos
        con.cerrarConexion();
    }
    
    //Ruta de imagenes
    File ruta = new File("//"+Server+"/fotos");
    
    //Comprueba rol de acceso
    private void acceso() throws IOException{
        if(pass.equals(contra)){
            
            if(rol.equals("REGISTRADOR")){
                cerrarVentana();
                //Muestra mensaje
                Jpaint();
                String jok = " Has ingresado satisfactoriamente al Sistema para el Control <br> de Entrada y Salida SENA (S.C.E.S.S.) </b> </body> </html>";
                JOptionPane.showMessageDialog(null,jo+"Bienvenido(a) "+nombre+jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
                //Abre ventana Registrador
                registrador formulario2 = new registrador();
                formulario2.setVisible(true);
                //Selecciona foto
                String r=ruta+"/"+txtid.getText()+".png";
                //muestra la foto de usuario
                formulario2.actfoto(r);
            }else if (rol.equals("ADMINISTRADOR")){
                cerrarVentana();
                //Muestra mensaje
                Jpaint();
                String jok = " Has ingresado satisfactoriamente al Sistema para el Control <br> de Entrada y Salida SENA (S.C.E.S.S.) </b> </body> </html>";
                JOptionPane.showMessageDialog(null,jo+"Bienvenido(a) "+nombre+jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
                //Abre ventana Admin
                admin formformulario1 = new admin();
                formformulario1.setVisible(true);
                //Selecciona foto
                String r=ruta+"/"+txtid.getText()+".png";
                //muestra la foto de usuario
                formformulario1.actfoto(r);
                
            }else if (rol.equals("OPERADOR")){
                cerrarVentana();
                //Muestra mensaje
                Jpaint();
                String jok = " Has ingresado satisfactoriamente al Sistema para el Control <br> de Entrada y Salida SENA (S.C.E.S.S.) </b> </body> </html>";
                JOptionPane.showMessageDialog(null,jo+"Bienvenido(a) "+nombre+jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
                //Abre ventana operador
                operador formformulario = new operador();
                formformulario.setVisible(true);
                //selecciona foto
                String r=ruta+"/"+txtid.getText()+".png";
                //mestra la foto de usuario
                formformulario.actfoto(r);
            }
        }else {
            Jpaint();
            String joker ="<html><body> <b style =\"font-size: 20; color: white;\"> Acceso denegado: <br> Por favor ingrese un usuario y/o contraseña correctos </b> </body> </html>";
            JOptionPane.showMessageDialog(null,joker, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
            
            opor++;
            oportunidad();
            txtid.setText("");
            txtpass.setText("");
        }
    }
    
    //Guarda conf Base de Datos
    private void guardaBD(){
        try {
            //Guardar Datos Configuracion
            pk.setServer(txtServer.getText());
            pk.setDb(txtBD.getText());
            pk.setUser(txtuserBD.getText());
            pk.setPass(txtpassBD.getText());
            pk.store();
        } catch (IOException ex) {
            Logger.getLogger(loginf.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Intercambio de Paneles
        jPConfBD.setVisible(false);
        login.setVisible(true);
        
    }
    
    //Icono Scess
    public Image getIconImage(){
       Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logo3.png"));
       return retvalue;
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra = new javax.swing.JPanel();
        btnConf = new javax.swing.JLabel();
        login = new javax.swing.JPanel();
        btnexit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        btnok = new javax.swing.JLabel();
        adv1 = new javax.swing.JLabel();
        adv2 = new javax.swing.JLabel();
        adv3 = new javax.swing.JLabel();
        adv4 = new javax.swing.JLabel();
        adv5 = new javax.swing.JLabel();
        separador = new javax.swing.JPanel();
        separador2 = new javax.swing.JPanel();
        jPConfBD = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblServer = new javax.swing.JLabel();
        separador5 = new javax.swing.JPanel();
        txtServer = new javax.swing.JTextField();
        lblBD = new javax.swing.JLabel();
        separador4 = new javax.swing.JPanel();
        txtBD = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        separador1 = new javax.swing.JPanel();
        txtuserBD = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        separador3 = new javax.swing.JPanel();
        txtpassBD = new javax.swing.JPasswordField();
        btnCancel = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barra.setBackground(new java.awt.Color(89, 181, 72));
        barra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConf.setBackground(new java.awt.Color(89, 181, 72));
        btnConf.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnConf.setForeground(new java.awt.Color(255, 255, 255));
        btnConf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/periodico (1).png"))); // NOI18N
        btnConf.setToolTipText("");
        btnConf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConf.setIconTextGap(1);
        btnConf.setMaximumSize(new java.awt.Dimension(41, 56));
        btnConf.setMinimumSize(new java.awt.Dimension(41, 56));
        btnConf.setName(""); // NOI18N
        btnConf.setOpaque(true);
        btnConf.setPreferredSize(new java.awt.Dimension(41, 56));
        btnConf.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfMouseClicked(evt);
            }
        });
        barra.add(btnConf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 50, 60));

        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 340));

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnexit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnexit.setForeground(new java.awt.Color(89, 181, 72));
        btnexit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnexit.setText("Salir");
        btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnexitMouseClicked(evt);
            }
        });
        login.add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 39, -1));

        jLabel1.setFont(new java.awt.Font("Freshman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(89, 181, 72));
        jLabel1.setText("S.C.E.S.S");
        login.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, 42));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 115, 35));
        jLabel2.setText("Usuario");
        login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 92, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(252, 115, 35));
        jLabel3.setText("Contraseña");
        login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        txtid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtid.setForeground(new java.awt.Color(153, 153, 153));
        txtid.setText("Ingrese usuario");
        txtid.setBorder(null);
        txtid.setCaretPosition(0);
        txtid.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtid.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtidMouseMoved(evt);
            }
        });
        txtid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtidFocusLost(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidKeyTyped(evt);
            }
        });
        login.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 145, 173, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(89, 181, 72));
        jLabel4.setText("Bienvenido a");
        login.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 137, -1));

        txtpass.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtpass.setForeground(new java.awt.Color(153, 153, 153));
        txtpass.setText("0000000");
        txtpass.setBorder(null);
        txtpass.setCaretPosition(0);
        txtpass.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtpassMouseMoved(evt);
            }
        });
        txtpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpassMouseClicked(evt);
            }
        });
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpassKeyReleased(evt);
            }
        });
        login.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 227, 173, 20));

        btnok.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnok.setForeground(new java.awt.Color(89, 181, 72));
        btnok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnok.setText("Ingresar");
        btnok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnokMouseClicked(evt);
            }
        });
        login.add(btnok, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        adv1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        adv1.setForeground(new java.awt.Color(35, 130, 118));
        adv1.setText("*Te quedan 4 Intentos");
        login.add(adv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 137, -1));

        adv2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        adv2.setForeground(new java.awt.Color(35, 130, 118));
        adv2.setText("*Te quedan 3 Intentos");
        login.add(adv2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 137, -1));

        adv3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        adv3.setForeground(new java.awt.Color(35, 130, 118));
        adv3.setText("*Te quedan 2 Intentos");
        login.add(adv3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 137, -1));

        adv4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        adv4.setForeground(new java.awt.Color(35, 130, 118));
        adv4.setText("*Te quedan 1 Intentos");
        login.add(adv4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 137, -1));

        adv5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        adv5.setForeground(new java.awt.Color(35, 130, 118));
        adv5.setText("comunicate con un admistrador");
        adv5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        login.add(adv5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        separador.setBackground(new java.awt.Color(252, 115, 35));
        separador.setForeground(new java.awt.Color(252, 115, 35));
        separador.setPreferredSize(new java.awt.Dimension(172, 2));
        separador.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separadorLayout = new javax.swing.GroupLayout(separador);
        separador.setLayout(separadorLayout);
        separadorLayout.setHorizontalGroup(
            separadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );
        separadorLayout.setVerticalGroup(
            separadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        login.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, 2));

        separador2.setBackground(new java.awt.Color(252, 115, 35));
        separador2.setForeground(new java.awt.Color(252, 115, 35));
        separador2.setPreferredSize(new java.awt.Dimension(172, 1));
        separador2.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador2Layout = new javax.swing.GroupLayout(separador2);
        separador2.setLayout(separador2Layout);
        separador2Layout.setHorizontalGroup(
            separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );
        separador2Layout.setVerticalGroup(
            separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        login.add(separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 2));

        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 340));

        jPConfBD.setBackground(new java.awt.Color(255, 255, 255));
        jPConfBD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(89, 181, 72));
        lblTitulo.setText("Configuración");
        jPConfBD.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 150, -1));

        jLabel5.setFont(new java.awt.Font("Freshman", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(89, 181, 72));
        jLabel5.setText("BD");
        jPConfBD.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, 42));

        lblServer.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblServer.setForeground(new java.awt.Color(252, 115, 35));
        lblServer.setText("Server");
        jPConfBD.add(lblServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 92, -1));

        separador5.setBackground(new java.awt.Color(252, 115, 35));
        separador5.setForeground(new java.awt.Color(252, 115, 35));
        separador5.setPreferredSize(new java.awt.Dimension(172, 2));
        separador5.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador5Layout = new javax.swing.GroupLayout(separador5);
        separador5.setLayout(separador5Layout);
        separador5Layout.setHorizontalGroup(
            separador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );
        separador5Layout.setVerticalGroup(
            separador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPConfBD.add(separador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 2));

        txtServer.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtServer.setForeground(new java.awt.Color(153, 153, 153));
        txtServer.setText("Servidor");
        txtServer.setBorder(null);
        txtServer.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtServer.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtServerMouseMoved(evt);
            }
        });
        txtServer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtServerFocusLost(evt);
            }
        });
        txtServer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtServerMouseClicked(evt);
            }
        });
        txtServer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtServerKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtServerKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtServerKeyTyped(evt);
            }
        });
        jPConfBD.add(txtServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 173, -1));

        lblBD.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblBD.setForeground(new java.awt.Color(252, 115, 35));
        lblBD.setText("BD");
        jPConfBD.add(lblBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 92, -1));

        separador4.setBackground(new java.awt.Color(252, 115, 35));
        separador4.setForeground(new java.awt.Color(252, 115, 35));
        separador4.setPreferredSize(new java.awt.Dimension(172, 2));
        separador4.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador4Layout = new javax.swing.GroupLayout(separador4);
        separador4.setLayout(separador4Layout);
        separador4Layout.setHorizontalGroup(
            separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );
        separador4Layout.setVerticalGroup(
            separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPConfBD.add(separador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 2));

        txtBD.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtBD.setForeground(new java.awt.Color(153, 153, 153));
        txtBD.setText("Base de Datos");
        txtBD.setBorder(null);
        txtBD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtBDMouseMoved(evt);
            }
        });
        txtBD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBDFocusLost(evt);
            }
        });
        txtBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBDMouseClicked(evt);
            }
        });
        txtBD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBDKeyTyped(evt);
            }
        });
        jPConfBD.add(txtBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 173, -1));

        lblUser.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblUser.setForeground(new java.awt.Color(252, 115, 35));
        lblUser.setText("User BD");
        jPConfBD.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 92, -1));

        separador1.setBackground(new java.awt.Color(252, 115, 35));
        separador1.setForeground(new java.awt.Color(252, 115, 35));
        separador1.setPreferredSize(new java.awt.Dimension(172, 2));
        separador1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador1Layout = new javax.swing.GroupLayout(separador1);
        separador1.setLayout(separador1Layout);
        separador1Layout.setHorizontalGroup(
            separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );
        separador1Layout.setVerticalGroup(
            separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPConfBD.add(separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 2));

        txtuserBD.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtuserBD.setForeground(new java.awt.Color(153, 153, 153));
        txtuserBD.setText("Usuario BD");
        txtuserBD.setBorder(null);
        txtuserBD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtuserBD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtuserBDMouseMoved(evt);
            }
        });
        txtuserBD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtuserBDFocusLost(evt);
            }
        });
        txtuserBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtuserBDMouseClicked(evt);
            }
        });
        txtuserBD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtuserBDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtuserBDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtuserBDKeyTyped(evt);
            }
        });
        jPConfBD.add(txtuserBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 173, -1));

        lblPass.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblPass.setForeground(new java.awt.Color(252, 115, 35));
        lblPass.setText("Password BD");
        jPConfBD.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        separador3.setBackground(new java.awt.Color(252, 115, 35));
        separador3.setForeground(new java.awt.Color(252, 115, 35));
        separador3.setPreferredSize(new java.awt.Dimension(172, 1));
        separador3.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador3Layout = new javax.swing.GroupLayout(separador3);
        separador3.setLayout(separador3Layout);
        separador3Layout.setHorizontalGroup(
            separador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );
        separador3Layout.setVerticalGroup(
            separador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPConfBD.add(separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, 2));

        txtpassBD.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtpassBD.setForeground(new java.awt.Color(153, 153, 153));
        txtpassBD.setText("0000000");
        txtpassBD.setBorder(null);
        txtpassBD.setCaretPosition(0);
        txtpassBD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtpassBDMouseMoved(evt);
            }
        });
        txtpassBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpassBDMouseClicked(evt);
            }
        });
        txtpassBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassBDActionPerformed(evt);
            }
        });
        txtpassBD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpassBDKeyReleased(evt);
            }
        });
        jPConfBD.add(txtpassBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 173, 20));

        btnCancel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(89, 181, 72));
        btnCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancel.setText("Cancelar");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        jPConfBD.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 70, -1));

        btnGuardar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(89, 181, 72));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        jPConfBD.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        getContentPane().add(jPConfBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnexitMouseClicked

    private void btnokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnokMouseClicked
        //Ejecutamos el metodo accede
        accede();
        
    }//GEN-LAST:event_btnokMouseClicked

    private void txtpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpassMouseClicked
        if (contp<=0){
            txtpass.setText("");
            contp++;
        }
    }//GEN-LAST:event_txtpassMouseClicked

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

    private void txtidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyReleased
        if(cont==0){
            txtid.setText("");
            cont++;
        }
    }//GEN-LAST:event_txtidKeyReleased

    private void txtpassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            //Ejecutamos el metodo accede
            accede();
        }
        
    }//GEN-LAST:event_txtpassKeyReleased

    private void txtidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidFocusLost
        if (contp<=0){
            txtpass.setText("");
            contp++;
        }     
    }//GEN-LAST:event_txtidFocusLost

    private void txtidMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtidMouseMoved
        if (cont<=0){
            txtid.setText("");
            cont++;
        }
    }//GEN-LAST:event_txtidMouseMoved

    private void txtidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            //Ejecutamos el metodo accede
            accede();
        }
    }//GEN-LAST:event_txtidKeyPressed

    private void txtpassMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpassMouseMoved
        if (contp<=0){
            txtpass.setText("");
            contp++;
        }
    }//GEN-LAST:event_txtpassMouseMoved

    private void txtidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyTyped
        char car = evt.getKeyChar();
        if (Character.isLetter(car)){
            evt.consume();
            getToolkit().beep();
        }
        if (Character.isSpaceChar(car)){
            evt.consume();
        }
    }//GEN-LAST:event_txtidKeyTyped

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        //Intercambio de Paneles
        jPConfBD.setVisible(false);
        login.setVisible(true);
        
    }//GEN-LAST:event_btnCancelMouseClicked

    private void txtuserBDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtuserBDMouseMoved
        if (cont3<=0){
            txtuserBD.setText("");
            cont3++;
        }
    }//GEN-LAST:event_txtuserBDMouseMoved

    private void txtuserBDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtuserBDFocusLost
        if (cont4<=0){
            txtpassBD.setText("");
            cont4++;
        }
    }//GEN-LAST:event_txtuserBDFocusLost

    private void txtuserBDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserBDKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserBDKeyPressed

    private void txtuserBDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserBDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserBDKeyReleased

    private void txtuserBDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserBDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserBDKeyTyped

    private void txtpassBDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpassBDMouseMoved
        if (cont4<=0){
            txtpassBD.setText("");
            cont4++;
        }
    }//GEN-LAST:event_txtpassBDMouseMoved

    private void txtpassBDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpassBDMouseClicked
        if (cont4<=0){
            txtpassBD.setText("");
            cont4++;
        }
    }//GEN-LAST:event_txtpassBDMouseClicked

    private void txtpassBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassBDActionPerformed

    private void txtpassBDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassBDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassBDKeyReleased

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        guardaBD();
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void txtBDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBDMouseMoved
        if (cont2<=0){
            txtBD.setText("");
            cont2++;
        }
    }//GEN-LAST:event_txtBDMouseMoved

    private void txtBDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBDFocusLost
        if (cont3<=0){
            txtuserBD.setText("");
            cont3++;
        }
    }//GEN-LAST:event_txtBDFocusLost

    private void txtBDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBDKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBDKeyPressed

    private void txtBDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBDKeyReleased

    private void txtBDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBDKeyTyped

    private void txtServerMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtServerMouseMoved
        if (cont1<=0){
            txtServer.setText("");
            cont1++;
        }
    }//GEN-LAST:event_txtServerMouseMoved

    private void txtServerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtServerFocusLost
        if (cont2<=0){
            txtBD.setText("");
            cont2++;
        }
    }//GEN-LAST:event_txtServerFocusLost

    private void txtServerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServerKeyPressed
        
    }//GEN-LAST:event_txtServerKeyPressed

    private void txtServerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServerKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServerKeyReleased

    private void txtServerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServerKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServerKeyTyped

    private void btnConfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfMouseClicked

        //Intercambio de Paneles
        login.setVisible(false);
        jPConfBD.setVisible(true);
        //barra.setVisible(true);
        btnConf.setVisible(false);
    }//GEN-LAST:event_btnConfMouseClicked

    private void txtuserBDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtuserBDMouseClicked
        if (cont3<=0){
            txtuserBD.setText("");
            cont3++;
        }
    }//GEN-LAST:event_txtuserBDMouseClicked

    private void txtBDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBDMouseClicked
        if (cont2<=0){
            txtBD.setText("");
            cont2++;
        }
    }//GEN-LAST:event_txtBDMouseClicked

    private void txtServerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtServerMouseClicked
        if (cont1<=0){
            txtServer.setText("");
            cont1++;
        }
    }//GEN-LAST:event_txtServerMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new loginf().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(loginf.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adv1;
    private javax.swing.JLabel adv2;
    private javax.swing.JLabel adv3;
    private javax.swing.JLabel adv4;
    private javax.swing.JLabel adv5;
    private javax.swing.JPanel barra;
    private javax.swing.JLabel btnCancel;
    private javax.swing.JLabel btnConf;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnexit;
    private javax.swing.JLabel btnok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPConfBD;
    private javax.swing.JLabel lblBD;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblServer;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel login;
    private javax.swing.JPanel separador;
    private javax.swing.JPanel separador1;
    private javax.swing.JPanel separador2;
    private javax.swing.JPanel separador3;
    private javax.swing.JPanel separador4;
    private javax.swing.JPanel separador5;
    private javax.swing.JTextField txtBD;
    private javax.swing.JTextField txtServer;
    private javax.swing.JTextField txtid;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JPasswordField txtpassBD;
    private javax.swing.JTextField txtuserBD;
    // End of variables declaration//GEN-END:variables
}
