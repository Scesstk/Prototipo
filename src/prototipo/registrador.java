
package prototipo;

import ConnectBD.*;
import RegistroPersona.Maven.Camara;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import login.loginf;

public class registrador extends javax.swing.JFrame {

    public class NombreBD extends Thread{
        
        public void run(){
            while (true){
                lblnombre.setText(login.loginf.nombre);
                lblrol.setText(login.loginf.rol);
                Thread.interrupted();
            }
        }
   }
    
    Pconnection con= new Pconnection();
    public registrador() throws IOException{
        initComponents();
        
        NombreBD nmb = new NombreBD();
        nmb.start();
        
        //inicio en false las vistas
        oculta();
        jpHome.setVisible(true);
                
        setLblColor(btnregistros);

        this.setLocationRelativeTo(null);
        Border border = LineBorder.createGrayLineBorder();
        
        
        //item de centrobox
        cbxCentro.addItem("Centro");
        cbxCentro.addItem("Otro");
        cbxCentro.select(0);
        
        //item de estadobox
        estadobox.addItem("Activo");
        estadobox.addItem("Inactivo");
        estadobox.select(0);
        
        //item de rhbox
        cbxRh.addItem("Seleccione");
        cbxRh.addItem("A+");
        cbxRh.addItem("A-");
        cbxRh.addItem("AB+");
        cbxRh.addItem("AB-");
        cbxRh.addItem("B+");
        cbxRh.addItem("B-");
        cbxRh.addItem("O+");
        cbxRh.addItem("O-");
        cbxRh.select(0);
        
        //item de tipodocumentobox
        cbxTipoDoc.add("Seleccione");
        cbxTipoDoc.add("T.I.");
        cbxTipoDoc.add("C.C.");
        cbxTipoDoc.add("C.E.");
        cbxTipoDoc.select(0);
        //item de rolbox
        cbxRol.addItem("Seleccione");
        cbxRol.addItem("Administrador");
        cbxRol.addItem("Operador");
        cbxRol.addItem("Registrador");
        cbxRol.addItem("Ninguno");
        cbxRol.select(0);
        
        //item de fichabox
        cbxFicha.addItem("Ficha de Formacion");
        cbxFicha.addItem("Otra");
        cbxFicha.select(0);
        //item de tipousuariobox
        cbxTipUser.addItem("Seleccione");
        cbxTipUser.addItem("Instructor");
        cbxTipUser.addItem("Aprendiz");
        cbxTipUser.addItem("Contratista");
        cbxTipUser.addItem("Administrativo");
        cbxTipUser.addItem("Visitante");
        cbxTipUser.select(0);
        //item de generobox
        cbxGenero.addItem("Seleccione");
        cbxGenero.addItem("Femenino");
        cbxGenero.addItem("Masculino");
        cbxGenero.select(0);
    }
    
    public int x=0,y=0;
    public String id_documento, nombre_1, ape_1, id_ficha, txt, busquedasrt;
    public int id;
    public String busq = "";
    private int cedula;
    private int docu;

    Propiedades pk = new Propiedades();
    String Server = pk.getServer();


    File ruta = new File("http://"+Server+"/api/fotos");
    DefaultTableModel modeloe;
    
    private void Jpaint(){
        UIManager.put("OptionPane.background", new ColorUIResource(89,200,72));
        UIManager.put("Button.background", Color.orange);
        UIManager.put("Panel.background", new ColorUIResource(89,200,72));
    }
    Icon joke = new ImageIcon(getClass().getResource("/Imagenes/logo.jpg"));

    public Image getIconImage(){
       Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logo3.png"));
       return retvalue;
    }
    
    public static void actfoto(String rt){
        ImageIcon foto = new ImageIcon(rt);
        ImageIcon ico = new ImageIcon(foto.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(ico);
                       
    }
    
    public static void fotoPer(String rt){
        ImageIcon foto = new ImageIcon(rt);
        ImageIcon ico = new ImageIcon(foto.getImage().getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT));
        lblfoto.setIcon(ico);
                       
    }
    
    public void oculta(){
        formulario.setVisible(false);
        jpHome.setVisible(false);
        jpFicha.setVisible(false);
        jpCentros.setVisible(false);
        JpCamCon.setVisible(false);
        body.setVisible(false);
        head.setVisible(false);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
    }
    
    public void resetPersona(){
        cbxTipoDoc.select(0);
        txtDocumento.setText("");
        txtNombre1.setText("");
        txtNombre2.setText("");
        txtApellido1.setText("");
        txtApellido2.setText("");
        cbxGenero.select(0);
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCelular.setText("");
        txtEmail.setText("");
        cbxRh.select(0);
        cbxTipUser.select(0);
        cbxRol.select(0);
        cbxCentro.select(0);
        cbxFicha.select(0);
    }
    
        //variables cambio de contraseña
    private int prueba, cedul, idp;
    private String contra, pass, pass1, passold;
    String pas;
    
    //metodo MySQL cambio de contraseña
    private void conecMySQL(){
        con.setSelectInt(("SELECT PERnumDoc FROM persona WHERE PERnumDoc='"+cedul+"'"), "PERnumDoc");
        prueba=con.getSelectInt();
        
        con.setSelectStr(("SELECT ACCcon FROM acceso as a "
                        + "JOIN persona as p on a.ACCidPerFK=p.PERidPerPK WHERE PERnumDoc = '"+cedul+"'"),
                "ACCcon");
        contra = con.getSelectStr();
        
        con.setSelectInt(("SELECT PERidPerPK FROM persona Where PERnumDoc = '"+cedul+"'"), "PERidPerPK");
        idp = con.getSelectInt();
        
        con.setSelectMd5(passold, passold);
        passold = con.getMd5();
        
        con.setSelectMd5(pass1, pass1);
        pass1 = con.getMd5();
        
        con.setSelectMd5(pass, pass);
        pass = con.getMd5();
        
           
        if(cedul==login.loginf.cc){
            
        
            if(cedul==prueba){
             
                if(passold.equals(contra)){
                
                    if(pass1.equals(pass)){
                    
                        con.setUpdate("UPDATE acceso SET ACCcon = '"+pass+"'"+" WHERE ACCidPerFK = "+id);
            
                        Jpaint();
                        String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Su contraseña Fue cambiada Con Exito</b> </body> </html>";
                        JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
                        
                        //dispose();
                        txtid.setText(null);
                        jPactual.setText(null);
                        jPnueva.setText(null);
                        jPcNueva.setText(null);
                    }else{
                        Jpaint();
                        String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Las contraseñas no son iguales</b> </body> </html>";
                        JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error de contraseña",JOptionPane.WARNING_MESSAGE,joke);
                        
                    }
                }else{
                    Jpaint();
                    String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Su contraseña no Fue cambiada</b> </body> </html>";
                    JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error de contraseña anterior",JOptionPane.WARNING_MESSAGE,joke);
                        
                }
            }else{
                Jpaint();
                String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Usuario no Valido</b> </body> </html>";
                JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error de Usuario",JOptionPane.WARNING_MESSAGE,joke);
                    
            }
        }else{
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Usuario no Coincide con el usuario Logueado</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error de Usuario",JOptionPane.WARNING_MESSAGE,joke);
            System.out.println("Prueba pass " + cedul);
            System.out.println("Prueba login " + login.loginf.cc);
            
        }
    }
    
    //metodo obtener contraseña
    private void contrasena(){
        char claveold[]=jPactual.getPassword();
        char claven[]=jPnueva.getPassword();
        char clavec[]=jPcNueva.getPassword();
        
        String claveol = new String(claveold);
        passold = claveol;
        String clavenew = new String(claven);
        pass1 = clavenew;
        String clavedef = new String(clavec);
        cedul = Integer.parseInt(txtid.getText());
        pass = clavedef;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jpHome = new javax.swing.JPanel();
        btncentros = new javax.swing.JLabel();
        btnfichas = new javax.swing.JLabel();
        btnusuarios = new javax.swing.JLabel();
        lblrol = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        etiquetanombre = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        etiquetatrol = new javax.swing.JLabel();
        cambiarpass = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        btnminimizar = new javax.swing.JLabel();
        btncerrar = new javax.swing.JLabel();
        barra = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        head = new javax.swing.JPanel();
        hequipo = new javax.swing.JPanel();
        iconbuscar1 = new javax.swing.JLabel();
        separador18 = new javax.swing.JPanel();
        txtconsulta1 = new javax.swing.JTextField();
        etiqueta28 = new javax.swing.JLabel();
        tipobox = new javax.swing.JComboBox<>();
        etiqueta30 = new javax.swing.JLabel();
        etiqueta31 = new javax.swing.JLabel();
        marcabox = new javax.swing.JComboBox<>();
        etiqueta32 = new javax.swing.JLabel();
        etiqueta33 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        separador20 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        desctxt = new javax.swing.JTextArea();
        jTextField18 = new javax.swing.JTextField();
        separador21 = new javax.swing.JPanel();
        formulario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        etiqueta = new javax.swing.JLabel();
        separador1 = new javax.swing.JPanel();
        txtNombre1 = new javax.swing.JTextField();
        etiqueta1 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        separador2 = new javax.swing.JPanel();
        etiqueta2 = new javax.swing.JLabel();
        separador3 = new javax.swing.JPanel();
        txtApellido1 = new javax.swing.JTextField();
        etiqueta3 = new javax.swing.JLabel();
        txtApellido2 = new javax.swing.JTextField();
        separador4 = new javax.swing.JPanel();
        etiqueta4 = new javax.swing.JLabel();
        separador5 = new javax.swing.JPanel();
        separador6 = new javax.swing.JPanel();
        etiqueta5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtDocumento = new javax.swing.JTextField();
        lblfoto = new javax.swing.JLabel();
        lbsubir = new javax.swing.JLabel();
        etiqueta6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        separador7 = new javax.swing.JPanel();
        etiqueta7 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        separador8 = new javax.swing.JPanel();
        etiqueta8 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        separador9 = new javax.swing.JPanel();
        cbxCentro = new java.awt.Choice();
        cbxRol = new java.awt.Choice();
        cbxTipoDoc = new java.awt.Choice();
        cbxFicha = new java.awt.Choice();
        cbxTipUser = new java.awt.Choice();
        cbxGenero = new java.awt.Choice();
        estadobox = new java.awt.Choice();
        cbxRh = new java.awt.Choice();
        etiqueta9 = new javax.swing.JLabel();
        etiqueta10 = new javax.swing.JLabel();
        etiqueta11 = new javax.swing.JLabel();
        etiqueta12 = new javax.swing.JLabel();
        etiqueta13 = new javax.swing.JLabel();
        etiqueta14 = new javax.swing.JLabel();
        etiqueta15 = new javax.swing.JLabel();
        etiqueta16 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JLabel();
        btnguardar = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        bequipo = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListaEquipos = new javax.swing.JTable();
        jpCentros = new javax.swing.JPanel();
        etiqueta20 = new javax.swing.JLabel();
        btnguardarcentro = new javax.swing.JLabel();
        jtxtCodCentro = new javax.swing.JTextField();
        separador12 = new javax.swing.JPanel();
        etiqueta21 = new javax.swing.JLabel();
        jtxtNombreCentro = new javax.swing.JTextField();
        separador13 = new javax.swing.JPanel();
        etiqueta22 = new javax.swing.JLabel();
        cbxDepartamento = new javax.swing.JComboBox<>();
        cbxCiudad = new javax.swing.JComboBox<>();
        btncancelarcentro = new javax.swing.JLabel();
        jpFicha = new javax.swing.JPanel();
        etiqueta17 = new javax.swing.JLabel();
        btnguardarficha = new javax.swing.JLabel();
        jtxtCod = new javax.swing.JTextField();
        separador10 = new javax.swing.JPanel();
        etiqueta18 = new javax.swing.JLabel();
        jtxtNom = new javax.swing.JTextField();
        separador11 = new javax.swing.JPanel();
        etiqueta19 = new javax.swing.JLabel();
        btncancelarficha = new javax.swing.JLabel();
        barralateral = new javax.swing.JPanel();
        btnregistros = new javax.swing.JLabel();
        btnlogout = new javax.swing.JLabel();
        JpCamCon = new javax.swing.JPanel();
        etiqueta23 = new javax.swing.JLabel();
        btnguarcampass = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        separador14 = new javax.swing.JPanel();
        etiqueta24 = new javax.swing.JLabel();
        separador15 = new javax.swing.JPanel();
        etiqueta25 = new javax.swing.JLabel();
        btncancelarpass = new javax.swing.JLabel();
        etiqueta26 = new javax.swing.JLabel();
        separador16 = new javax.swing.JPanel();
        etiqueta27 = new javax.swing.JLabel();
        separador17 = new javax.swing.JPanel();
        jPcNueva = new javax.swing.JPasswordField();
        jPactual = new javax.swing.JPasswordField();
        jPnueva = new javax.swing.JPasswordField();

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

        jpHome.setBackground(new java.awt.Color(255, 255, 255));

        btncentros.setBackground(new java.awt.Color(255, 255, 255));
        btncentros.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btncentros.setForeground(new java.awt.Color(89, 181, 72));
        btncentros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btncentros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edificio-comercial.png"))); // NOI18N
        btncentros.setText("Agregar Centros");
        btncentros.setToolTipText("");
        btncentros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncentros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncentros.setIconTextGap(1);
        btncentros.setName(""); // NOI18N
        btncentros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncentros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncentrosMouseClicked(evt);
            }
        });

        btnfichas.setBackground(new java.awt.Color(255, 255, 255));
        btnfichas.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnfichas.setForeground(new java.awt.Color(89, 181, 72));
        btnfichas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnfichas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carpeta-rellena-con-pestanas.png"))); // NOI18N
        btnfichas.setText("Agregar Fichas");
        btnfichas.setToolTipText("");
        btnfichas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnfichas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnfichas.setIconTextGap(1);
        btnfichas.setName(""); // NOI18N
        btnfichas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnfichas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnfichasMouseClicked(evt);
            }
        });

        btnusuarios.setBackground(new java.awt.Color(255, 255, 255));
        btnusuarios.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnusuarios.setForeground(new java.awt.Color(89, 181, 72));
        btnusuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-usuariox64.png"))); // NOI18N
        btnusuarios.setText("Agregar Usuarios");
        btnusuarios.setToolTipText("");
        btnusuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnusuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnusuarios.setIconTextGap(1);
        btnusuarios.setName(""); // NOI18N
        btnusuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnusuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnusuariosMouseClicked(evt);
            }
        });

        lblrol.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblrol.setForeground(new java.awt.Color(89, 181, 72));
        lblrol.setText("Administrador");

        imagen.setOpaque(true);

        etiquetanombre.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiquetanombre.setForeground(new java.awt.Color(89, 181, 72));
        etiquetanombre.setText("Bienvenido(a):");

        lblnombre.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(89, 181, 72));
        lblnombre.setText("Gustavo Risueño");

        etiquetatrol.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        etiquetatrol.setForeground(new java.awt.Color(89, 181, 72));
        etiquetatrol.setText("Rol:");

        cambiarpass.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cambiarpass.setForeground(new java.awt.Color(89, 181, 72));
        cambiarpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrasena.png"))); // NOI18N
        cambiarpass.setText("Cambiar Contraseña");
        cambiarpass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cambiarpass.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cambiarpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarpassMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpHomeLayout = new javax.swing.GroupLayout(jpHome);
        jpHome.setLayout(jpHomeLayout);
        jpHomeLayout.setHorizontalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(btncentros)
                .addGap(80, 80, 80)
                .addComponent(btnusuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btnfichas)
                .addGap(101, 101, 101))
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpHomeLayout.createSequentialGroup()
                        .addComponent(etiquetanombre)
                        .addGap(3, 3, 3)
                        .addComponent(lblnombre)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpHomeLayout.createSequentialGroup()
                        .addComponent(etiquetatrol)
                        .addGap(7, 7, 7)
                        .addComponent(lblrol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cambiarpass)))
                .addContainerGap())
        );
        jpHomeLayout.setVerticalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpHomeLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetanombre)
                            .addComponent(lblnombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetatrol)
                            .addComponent(lblrol)
                            .addComponent(cambiarpass))))
                .addGap(36, 36, 36)
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnusuarios)
                    .addComponent(btnfichas)
                    .addComponent(btncentros))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        getContentPane().add(jpHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 760, 420));

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

        head.setBackground(new java.awt.Color(255, 255, 255));
        head.setLayout(new java.awt.CardLayout());

        hequipo.setBackground(new java.awt.Color(255, 255, 255));
        hequipo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconbuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar-con-herramienta-en-esquema.png"))); // NOI18N
        hequipo.add(iconbuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 70, -1));

        separador18.setBackground(new java.awt.Color(89, 181, 72));
        separador18.setForeground(new java.awt.Color(89, 181, 72));
        separador18.setPreferredSize(new java.awt.Dimension(172, 2));
        separador18.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador18Layout = new javax.swing.GroupLayout(separador18);
        separador18.setLayout(separador18Layout);
        separador18Layout.setHorizontalGroup(
            separador18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separador18Layout.setVerticalGroup(
            separador18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        hequipo.add(separador18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 200, 2));

        txtconsulta1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtconsulta1.setForeground(new java.awt.Color(102, 102, 102));
        txtconsulta1.setText("Digita tu Cedula");
        txtconsulta1.setBorder(null);
        txtconsulta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtconsulta1MouseClicked(evt);
            }
        });
        txtconsulta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconsulta1ActionPerformed(evt);
            }
        });
        txtconsulta1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtconsulta1KeyReleased(evt);
            }
        });
        hequipo.add(txtconsulta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 190, 30));

        etiqueta28.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta28.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta28.setText("Serial:");
        hequipo.add(etiqueta28, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 60, 30));

        tipobox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
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
        hequipo.add(tipobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 30));

        etiqueta30.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta30.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta30.setText("Tipo:");
        hequipo.add(etiqueta30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 30));

        etiqueta31.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta31.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta31.setText("Marca:");
        hequipo.add(etiqueta31, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, 30));

        marcabox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        marcabox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "ACER", "ASUS", "APPLE", "DELL", "GATEWAY", "HP", "LENOVO", "LG", "PC SMART", "THOSIBA", "SONY", "OTROS" }));
        hequipo.add(marcabox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 140, 30));

        etiqueta32.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta32.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta32.setText("Descripcion:");
        hequipo.add(etiqueta32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 100, 30));

        etiqueta33.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta33.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta33.setText("Modelo:");
        hequipo.add(etiqueta33, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 70, 30));

        jTextField17.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField17.setBorder(null);
        jTextField17.setOpaque(false);
        hequipo.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 180, 30));

        separador20.setBackground(new java.awt.Color(252, 115, 35));
        separador20.setForeground(new java.awt.Color(252, 115, 35));
        separador20.setPreferredSize(new java.awt.Dimension(172, 2));
        separador20.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador20Layout = new javax.swing.GroupLayout(separador20);
        separador20.setLayout(separador20Layout);
        separador20Layout.setHorizontalGroup(
            separador20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        separador20Layout.setVerticalGroup(
            separador20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        hequipo.add(separador20, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 180, -1));

        desctxt.setColumns(20);
        desctxt.setRows(5);
        desctxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        jScrollPane4.setViewportView(desctxt);

        hequipo.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 300, 50));

        jTextField18.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField18.setBorder(null);
        jTextField18.setOpaque(false);
        hequipo.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 170, 30));

        separador21.setBackground(new java.awt.Color(252, 115, 35));
        separador21.setForeground(new java.awt.Color(252, 115, 35));
        separador21.setPreferredSize(new java.awt.Dimension(172, 2));
        separador21.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador21Layout = new javax.swing.GroupLayout(separador21);
        separador21.setLayout(separador21Layout);
        separador21Layout.setHorizontalGroup(
            separador21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        separador21Layout.setVerticalGroup(
            separador21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        hequipo.add(separador21, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 170, -1));

        head.add(hequipo, "card3");

        getContentPane().add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 760, 170));

        formulario.setBackground(new java.awt.Color(255, 255, 255));
        formulario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(877, 1500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiqueta.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta.setText("* Primer Nombre");
        jPanel1.add(etiqueta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, 30));

        separador1.setBackground(new java.awt.Color(252, 115, 35));
        separador1.setForeground(new java.awt.Color(252, 115, 35));
        separador1.setPreferredSize(new java.awt.Dimension(172, 2));
        separador1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador1Layout = new javax.swing.GroupLayout(separador1);
        separador1.setLayout(separador1Layout);
        separador1Layout.setHorizontalGroup(
            separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador1Layout.setVerticalGroup(
            separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 220, -1));

        txtNombre1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtNombre1.setBorder(null);
        txtNombre1.setOpaque(false);
        jPanel1.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 220, 30));

        etiqueta1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta1.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta1.setText("Segundo Nombre");
        jPanel1.add(etiqueta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, 30));

        txtNombre2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtNombre2.setBorder(null);
        txtNombre2.setOpaque(false);
        jPanel1.add(txtNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 215, 30));

        separador2.setBackground(new java.awt.Color(252, 115, 35));
        separador2.setForeground(new java.awt.Color(252, 115, 35));
        separador2.setPreferredSize(new java.awt.Dimension(172, 2));

        javax.swing.GroupLayout separador2Layout = new javax.swing.GroupLayout(separador2);
        separador2.setLayout(separador2Layout);
        separador2Layout.setHorizontalGroup(
            separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador2Layout.setVerticalGroup(
            separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 220, -1));

        etiqueta2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta2.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta2.setText("* Primer Apellido");
        jPanel1.add(etiqueta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, 30));

        separador3.setBackground(new java.awt.Color(252, 115, 35));
        separador3.setForeground(new java.awt.Color(252, 115, 35));
        separador3.setPreferredSize(new java.awt.Dimension(172, 2));
        separador3.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador3Layout = new javax.swing.GroupLayout(separador3);
        separador3.setLayout(separador3Layout);
        separador3Layout.setHorizontalGroup(
            separador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador3Layout.setVerticalGroup(
            separador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 220, -1));

        txtApellido1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtApellido1.setBorder(null);
        txtApellido1.setOpaque(false);
        jPanel1.add(txtApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 220, 30));

        etiqueta3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta3.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta3.setText("Segundo Apellido");
        jPanel1.add(etiqueta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, 30));

        txtApellido2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtApellido2.setBorder(null);
        txtApellido2.setOpaque(false);
        jPanel1.add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 220, 30));

        separador4.setBackground(new java.awt.Color(252, 115, 35));
        separador4.setForeground(new java.awt.Color(252, 115, 35));
        separador4.setPreferredSize(new java.awt.Dimension(172, 2));
        separador4.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador4Layout = new javax.swing.GroupLayout(separador4);
        separador4.setLayout(separador4Layout);
        separador4Layout.setHorizontalGroup(
            separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador4Layout.setVerticalGroup(
            separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(separador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 220, -1));

        etiqueta4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta4.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta4.setText("* N° Documento");
        jPanel1.add(etiqueta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, 30));

        separador5.setBackground(new java.awt.Color(252, 115, 35));
        separador5.setForeground(new java.awt.Color(252, 115, 35));
        separador5.setPreferredSize(new java.awt.Dimension(172, 2));
        separador5.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador5Layout = new javax.swing.GroupLayout(separador5);
        separador5.setLayout(separador5Layout);
        separador5Layout.setHorizontalGroup(
            separador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador5Layout.setVerticalGroup(
            separador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(separador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 220, -1));

        separador6.setBackground(new java.awt.Color(252, 115, 35));
        separador6.setForeground(new java.awt.Color(252, 115, 35));
        separador6.setPreferredSize(new java.awt.Dimension(172, 2));
        separador6.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador6Layout = new javax.swing.GroupLayout(separador6);
        separador6.setLayout(separador6Layout);
        separador6Layout.setHorizontalGroup(
            separador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador6Layout.setVerticalGroup(
            separador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(separador6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 680, 220, -1));

        etiqueta5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta5.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta5.setText("Email");
        jPanel1.add(etiqueta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 620, -1, 30));

        txtEmail.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtEmail.setBorder(null);
        txtEmail.setOpaque(false);
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 650, 170, 30));

        txtDocumento.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtDocumento.setBorder(null);
        txtDocumento.setOpaque(false);
        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });
        jPanel1.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 170, 30));

        lblfoto.setOpaque(true);
        jPanel1.add(lblfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 120, 110));

        lbsubir.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbsubir.setForeground(new java.awt.Color(89, 181, 72));
        lbsubir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbsubir.setText("Subir");
        lbsubir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbsubirMouseClicked(evt);
            }
        });
        jPanel1.add(lbsubir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 100, 20));

        etiqueta6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta6.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta6.setText("* N° Telefono");
        jPanel1.add(etiqueta6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, -1, 30));

        txtTelefono.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtTelefono.setBorder(null);
        txtTelefono.setOpaque(false);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, 170, 30));

        separador7.setBackground(new java.awt.Color(252, 115, 35));
        separador7.setForeground(new java.awt.Color(252, 115, 35));
        separador7.setPreferredSize(new java.awt.Dimension(172, 2));
        separador7.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador7Layout = new javax.swing.GroupLayout(separador7);
        separador7.setLayout(separador7Layout);
        separador7Layout.setHorizontalGroup(
            separador7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador7Layout.setVerticalGroup(
            separador7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(separador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 580, 220, -1));

        etiqueta7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta7.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta7.setText("N° Celular");
        jPanel1.add(etiqueta7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, -1, 30));

        txtCelular.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtCelular.setBorder(null);
        txtCelular.setOpaque(false);
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 550, 170, 30));

        separador8.setBackground(new java.awt.Color(252, 115, 35));
        separador8.setForeground(new java.awt.Color(252, 115, 35));
        separador8.setPreferredSize(new java.awt.Dimension(172, 2));
        separador8.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador8Layout = new javax.swing.GroupLayout(separador8);
        separador8.setLayout(separador8Layout);
        separador8Layout.setHorizontalGroup(
            separador8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador8Layout.setVerticalGroup(
            separador8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(separador8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 580, 220, -1));

        etiqueta8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta8.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta8.setText("* Tipo de RH");
        jPanel1.add(etiqueta8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 710, -1, 30));

        txtDireccion.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtDireccion.setBorder(null);
        txtDireccion.setOpaque(false);
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 650, 170, 30));

        separador9.setBackground(new java.awt.Color(252, 115, 35));
        separador9.setForeground(new java.awt.Color(252, 115, 35));
        separador9.setPreferredSize(new java.awt.Dimension(172, 2));
        separador9.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador9Layout = new javax.swing.GroupLayout(separador9);
        separador9.setLayout(separador9Layout);
        separador9Layout.setHorizontalGroup(
            separador9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador9Layout.setVerticalGroup(
            separador9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(separador9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 680, 220, -1));

        cbxCentro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbxCentro.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(cbxCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 960, 180, 20));

        cbxRol.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(cbxRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 880, 120, -1));

        cbxTipoDoc.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(cbxTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 220, -1));

        cbxFicha.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(cbxFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 960, 220, -1));

        cbxTipUser.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(cbxTipUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 880, 180, -1));

        cbxGenero.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(cbxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 760, 220, -1));

        estadobox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(estadobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 880, 180, -1));

        cbxRh.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(cbxRh, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 760, 220, -1));

        etiqueta9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta9.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta9.setText("* Tipo de Documento");
        jPanel1.add(etiqueta9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, 30));

        etiqueta10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta10.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta10.setText("* N° de Ficha");
        jPanel1.add(etiqueta10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 920, -1, -1));

        etiqueta11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta11.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta11.setText("Rol de Usuario");
        jPanel1.add(etiqueta11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 830, -1, -1));

        etiqueta12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta12.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta12.setText("Estado de Usuario");
        jPanel1.add(etiqueta12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 830, -1, -1));

        etiqueta13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta13.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta13.setText("Dirección");
        jPanel1.add(etiqueta13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 620, -1, 30));

        etiqueta14.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta14.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta14.setText("* Genero");
        jPanel1.add(etiqueta14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 710, -1, 30));

        etiqueta15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta15.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta15.setText("* Tipo de Usuario");
        jPanel1.add(etiqueta15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 830, -1, -1));

        etiqueta16.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta16.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta16.setText("* Centro");
        jPanel1.add(etiqueta16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 920, -1, 20));

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
        jPanel1.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 1070, 160, -1));

        btnguardar.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(89, 181, 72));
        btnguardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnguardar.setText("Guardar");
        btnguardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguardarMouseClicked(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 1070, 130, -1));

        jScrollPane1.setViewportView(jPanel1);

        formulario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 800));

        getContentPane().add(formulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 760, 420));

        body.setBackground(new java.awt.Color(244, 242, 242));
        body.setLayout(new java.awt.CardLayout());

        bequipo.setBackground(new java.awt.Color(255, 255, 255));
        bequipo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jScrollPane3.setOpaque(false);

        tblListaEquipos.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblListaEquipos.setForeground(new java.awt.Color(89, 181, 72));
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
        tblListaEquipos.setGridColor(new java.awt.Color(153, 153, 153));
        tblListaEquipos.setRowHeight(22);
        tblListaEquipos.setSelectionBackground(new java.awt.Color(89, 181, 72));
        jScrollPane3.setViewportView(tblListaEquipos);

        bequipo.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 250));

        body.add(bequipo, "card2");

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 760, 250));

        jpCentros.setBackground(new java.awt.Color(255, 255, 255));
        jpCentros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiqueta20.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        etiqueta20.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta20.setText("Agregar Centros");
        jpCentros.add(etiqueta20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 250, 50));

        btnguardarcentro.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btnguardarcentro.setForeground(new java.awt.Color(89, 181, 72));
        btnguardarcentro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnguardarcentro.setText("Guardar");
        btnguardarcentro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btnguardarcentro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardarcentro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguardarcentroMouseClicked(evt);
            }
        });
        jpCentros.add(btnguardarcentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 110, -1));

        jtxtCodCentro.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jtxtCodCentro.setBorder(null);
        jtxtCodCentro.setOpaque(false);
        jpCentros.add(jtxtCodCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 220, 30));

        separador12.setBackground(new java.awt.Color(252, 115, 35));
        separador12.setForeground(new java.awt.Color(252, 115, 35));
        separador12.setPreferredSize(new java.awt.Dimension(172, 2));
        separador12.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador12Layout = new javax.swing.GroupLayout(separador12);
        separador12.setLayout(separador12Layout);
        separador12Layout.setHorizontalGroup(
            separador12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador12Layout.setVerticalGroup(
            separador12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jpCentros.add(separador12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 220, -1));

        etiqueta21.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta21.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta21.setText("Nombre de Centro:");
        jpCentros.add(etiqueta21, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, 30));

        jtxtNombreCentro.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jtxtNombreCentro.setBorder(null);
        jtxtNombreCentro.setOpaque(false);
        jpCentros.add(jtxtNombreCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 220, 30));

        separador13.setBackground(new java.awt.Color(252, 115, 35));
        separador13.setForeground(new java.awt.Color(252, 115, 35));
        separador13.setPreferredSize(new java.awt.Dimension(172, 2));
        separador13.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador13Layout = new javax.swing.GroupLayout(separador13);
        separador13.setLayout(separador13Layout);
        separador13Layout.setHorizontalGroup(
            separador13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador13Layout.setVerticalGroup(
            separador13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jpCentros.add(separador13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 220, -1));

        etiqueta22.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta22.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta22.setText("Codigo de Centro:");
        jpCentros.add(etiqueta22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, 30));

        cbxDepartamento.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbxDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Amazonas", "Antioquia", "Arauca", "Atlántico", "Bolívar", "Boyacá", "Caldas", "Caquetá", "Casanare", "Cauca", "Cesar", "Chocó", "Córdoba", "Cundinamarca", "Guainía", "Guaviare", "Huila", "La Guajira", "Magdalena", "Meta", "Nariño", "Norte de Santander", "Putumayo", "Quindío", "Risaralda", "San Andrés y Providencia", "Santander", "Sucre", "Tolima", "Valle del Cauca", "Vaupés", "Vichada" }));
        cbxDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDepartamentoActionPerformed(evt);
            }
        });
        jpCentros.add(cbxDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        cbxCiudad.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbxCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        jpCentros.add(cbxCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        btncancelarcentro.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btncancelarcentro.setForeground(new java.awt.Color(89, 181, 72));
        btncancelarcentro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btncancelarcentro.setText("Cancelar");
        btncancelarcentro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btncancelarcentro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelarcentro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelarcentroMouseClicked(evt);
            }
        });
        jpCentros.add(btncancelarcentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 100, -1));

        getContentPane().add(jpCentros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 38, 760, 420));

        jpFicha.setBackground(new java.awt.Color(255, 255, 255));
        jpFicha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiqueta17.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        etiqueta17.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta17.setText("Agregar Ficha");
        jpFicha.add(etiqueta17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 50));

        btnguardarficha.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btnguardarficha.setForeground(new java.awt.Color(89, 181, 72));
        btnguardarficha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnguardarficha.setText("Guardar");
        btnguardarficha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btnguardarficha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardarficha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguardarfichaMouseClicked(evt);
            }
        });
        jpFicha.add(btnguardarficha, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 120, -1));

        jtxtCod.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jtxtCod.setBorder(null);
        jtxtCod.setOpaque(false);
        jpFicha.add(jtxtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 220, 30));

        separador10.setBackground(new java.awt.Color(252, 115, 35));
        separador10.setForeground(new java.awt.Color(252, 115, 35));
        separador10.setPreferredSize(new java.awt.Dimension(172, 2));
        separador10.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador10Layout = new javax.swing.GroupLayout(separador10);
        separador10.setLayout(separador10Layout);
        separador10Layout.setHorizontalGroup(
            separador10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador10Layout.setVerticalGroup(
            separador10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jpFicha.add(separador10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 220, -1));

        etiqueta18.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta18.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta18.setText("Nombre de Ficha:");
        jpFicha.add(etiqueta18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, 30));

        jtxtNom.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jtxtNom.setBorder(null);
        jtxtNom.setOpaque(false);
        jpFicha.add(jtxtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 220, 30));

        separador11.setBackground(new java.awt.Color(252, 115, 35));
        separador11.setForeground(new java.awt.Color(252, 115, 35));
        separador11.setPreferredSize(new java.awt.Dimension(172, 2));
        separador11.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador11Layout = new javax.swing.GroupLayout(separador11);
        separador11.setLayout(separador11Layout);
        separador11Layout.setHorizontalGroup(
            separador11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador11Layout.setVerticalGroup(
            separador11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jpFicha.add(separador11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 220, -1));

        etiqueta19.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta19.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta19.setText("Codigo de Ficha:");
        jpFicha.add(etiqueta19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, 30));

        btncancelarficha.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btncancelarficha.setForeground(new java.awt.Color(89, 181, 72));
        btncancelarficha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btncancelarficha.setText("Cancelar");
        btncancelarficha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btncancelarficha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelarficha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelarfichaMouseClicked(evt);
            }
        });
        jpFicha.add(btncancelarficha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 100, -1));

        getContentPane().add(jpFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 760, 420));

        barralateral.setBackground(new java.awt.Color(89, 181, 72));
        barralateral.setToolTipText("");
        barralateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnregistros.setBackground(new java.awt.Color(89, 181, 72));
        btnregistros.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnregistros.setForeground(new java.awt.Color(255, 255, 255));
        btnregistros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnregistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/casa.png"))); // NOI18N
        btnregistros.setText("Inicio");
        btnregistros.setToolTipText("");
        btnregistros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnregistros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnregistros.setIconTextGap(1);
        btnregistros.setName(""); // NOI18N
        btnregistros.setOpaque(true);
        btnregistros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnregistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnregistrosMouseClicked(evt);
            }
        });
        barralateral.add(btnregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 70, 70));

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

        JpCamCon.setBackground(new java.awt.Color(255, 255, 255));
        JpCamCon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiqueta23.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        etiqueta23.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta23.setText("Cambiar Contraseña");
        JpCamCon.add(etiqueta23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 320, 50));

        btnguarcampass.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btnguarcampass.setForeground(new java.awt.Color(89, 181, 72));
        btnguarcampass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnguarcampass.setText("Guardar");
        btnguarcampass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btnguarcampass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguarcampass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguarcampassMouseClicked(evt);
            }
        });
        JpCamCon.add(btnguarcampass, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 110, -1));

        txtid.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtid.setBorder(null);
        txtid.setOpaque(false);
        JpCamCon.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 220, 30));

        separador14.setBackground(new java.awt.Color(252, 115, 35));
        separador14.setForeground(new java.awt.Color(252, 115, 35));
        separador14.setPreferredSize(new java.awt.Dimension(172, 2));
        separador14.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador14Layout = new javax.swing.GroupLayout(separador14);
        separador14.setLayout(separador14Layout);
        separador14Layout.setHorizontalGroup(
            separador14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador14Layout.setVerticalGroup(
            separador14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        JpCamCon.add(separador14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 220, -1));

        etiqueta24.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta24.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta24.setText("Digite su contraseña actual:");
        JpCamCon.add(etiqueta24, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, 30));

        separador15.setBackground(new java.awt.Color(252, 115, 35));
        separador15.setForeground(new java.awt.Color(252, 115, 35));
        separador15.setPreferredSize(new java.awt.Dimension(172, 2));
        separador15.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador15Layout = new javax.swing.GroupLayout(separador15);
        separador15.setLayout(separador15Layout);
        separador15Layout.setHorizontalGroup(
            separador15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador15Layout.setVerticalGroup(
            separador15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        JpCamCon.add(separador15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 220, -1));

        etiqueta25.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta25.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta25.setText("Ingrese el usuario:");
        JpCamCon.add(etiqueta25, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, 30));

        btncancelarpass.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btncancelarpass.setForeground(new java.awt.Color(89, 181, 72));
        btncancelarpass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btncancelarpass.setText("Cancelar");
        btncancelarpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btncancelarpass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelarpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelarpassMouseClicked(evt);
            }
        });
        JpCamCon.add(btncancelarpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 100, -1));

        etiqueta26.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta26.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta26.setText("Digite su contraseña nueva:");
        JpCamCon.add(etiqueta26, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, 30));

        separador16.setBackground(new java.awt.Color(252, 115, 35));
        separador16.setForeground(new java.awt.Color(252, 115, 35));
        separador16.setPreferredSize(new java.awt.Dimension(172, 2));
        separador16.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador16Layout = new javax.swing.GroupLayout(separador16);
        separador16.setLayout(separador16Layout);
        separador16Layout.setHorizontalGroup(
            separador16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador16Layout.setVerticalGroup(
            separador16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        JpCamCon.add(separador16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 220, -1));

        etiqueta27.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta27.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta27.setText("Confirme su contraseña nueva:");
        JpCamCon.add(etiqueta27, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, 30));

        separador17.setBackground(new java.awt.Color(252, 115, 35));
        separador17.setForeground(new java.awt.Color(252, 115, 35));
        separador17.setPreferredSize(new java.awt.Dimension(172, 2));
        separador17.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador17Layout = new javax.swing.GroupLayout(separador17);
        separador17.setLayout(separador17Layout);
        separador17Layout.setHorizontalGroup(
            separador17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        separador17Layout.setVerticalGroup(
            separador17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        JpCamCon.add(separador17, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 220, -1));

        jPcNueva.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPcNueva.setForeground(new java.awt.Color(153, 153, 153));
        jPcNueva.setBorder(null);
        JpCamCon.add(jPcNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 220, 30));

        jPactual.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPactual.setForeground(new java.awt.Color(153, 153, 153));
        jPactual.setBorder(null);
        JpCamCon.add(jPactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 220, 30));

        jPnueva.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPnueva.setForeground(new java.awt.Color(153, 153, 153));
        jPnueva.setBorder(null);
        JpCamCon.add(jPnueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 220, 30));

        getContentPane().add(JpCamCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 760, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncerrarMouseClicked
        
        Jpaint();
        String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> ¿Desea Salir del Programa?</b></body> </html>";
        int codigo=JOptionPane.showConfirmDialog(null,jok, "SALIR", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,joke);
        if (codigo==JOptionPane.YES_OPTION){
            System.exit(0);
            con.cerrarConexion();
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

    private void btncancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarMouseClicked
        setLblColor(btnregistros);
        oculta();
        jpHome.setVisible(true);
    }//GEN-LAST:event_btncancelarMouseClicked

    private void btnguardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarMouseClicked
        
        docu = 0;
        int id=0;
        con.setSelectInt("Select PERnumDoc from persona where PERnumDoc ='"+txtDocumento.getText()+"'","PERnumDoc");
        docu = con.getSelectInt();
        
        con.setSelectInt("Select PERidPerPK from persona","PERidPerPK");
        id=con.getSelectInt();
        
        FileInputStream fi = null;

        id++;
        
        if(docu>0){
            Jpaint();
            String jokio = "<html><body> <b style =\"font-size: 20; color: white;\">ya se encuentra registrado </b></body> </html>";
            JOptionPane.showMessageDialog(null,jokio, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
            
        }else{
            
            if((cbxTipoDoc.getSelectedIndex()==0)||(txtDocumento.getText().equals(""))||
                (txtNombre1.getText().equals(""))||(txtApellido1.getText().equals(""))||
                (cbxGenero.getSelectedIndex()==0)||
                (txtTelefono.getText().equals(""))||(cbxRh.getSelectedIndex()==0)||
                (cbxTipUser.getSelectedIndex()==0)||
                ((cbxCentro.getSelectedIndex())==0)||((cbxFicha.getSelectedIndex())==0)){
                
                Jpaint();
                String jokte = "<html><body> <b style =\"font-size: 20; color: white;\"> Hay Campos marcados con (*) vacios que son obligatorios </b></body> </html>";
                JOptionPane.showMessageDialog(null,jokte, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
                    
            }else{
                if(txtNombre2.getText().equals("")){
                    txtNombre2.setText(" ");
                }
                if(txtApellido2.getText().equals("")){
                    txtApellido2.setText(" ");
                }
                if(txtDireccion.getText().equals("")){
                    txtDireccion.setText(" ");
                }
                if(txtCelular.getText().equals("")){
                    txtCelular.setText("0");
                }
                if(txtEmail.getText().equals("")){
                    txtEmail.setText(" ");
                }

                
                String insert = "INSERT INTO persona (PERidPerPK, PERidDocFK, PERnumDoc, PERnom1, PERnom2, PERape1, PERape2, PERidGenFK, PERdir, PERtelFij, PERcel, PERcor, PERidRhFK, PERidTiPeFK, PERidRolFK, PERidCenFK, PERidFicFK, PERfoto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = null;

                try {

                    Pconnection grabar = new Pconnection();
                    String r=ruta+"/"+txtDocumento.getText()+".png";
                    File file = new File(r);
                //fi = new FileInputStream(file);

                    ps = grabar.getConexion().prepareStatement(insert);
                    ps.setInt(1,id);
                    ps.setInt(2,cbxTipoDoc.getSelectedIndex());
                    ps.setInt(3,Integer.parseInt(txtDocumento.getText()));
                    ps.setString(4,txtNombre1.getText());
                    ps.setString(5,txtNombre2.getText());
                    ps.setString(6,txtApellido1.getText());
                    ps.setString(7,txtApellido2.getText());
                    ps.setInt(8,cbxGenero.getSelectedIndex());
                    ps.setString(9,txtDireccion.getText());
                    ps.setInt(10,(Integer.parseInt(txtTelefono.getText())));
                    ps.setInt(11,(Integer.parseInt(txtCelular.getText())));
                    ps.setString(12,txtEmail.getText());
                    ps.setInt(13,cbxRh.getSelectedIndex());
                    ps.setInt(14,cbxTipUser.getSelectedIndex());
                    ps.setInt(15,cbxRol.getSelectedIndex());
                    ps.setInt(16,(cbxCentro.getSelectedIndex()));
                    ps.setInt(17,(cbxFicha.getSelectedIndex()));
                //ps.setBinaryStream(18,fi,(int)file.length());
                    ps.setString(18,r);
                    ps.executeUpdate(); 
   
                    Jpaint();
                    String jokd = "<html><body> <b style =\"font-size: 20; color: white;\"> Registro almacenado con Exito.! </b></body> </html>";
                    JOptionPane.showMessageDialog(null,jokd, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
                    ps.close();
                }catch(SQLException e){
                    System.out.println(e.getMessage());

                } catch (IOException ex) {
                    Logger.getLogger(registrador.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        }
        
        String insert2 = "INSERT INTO entsal (ESidPerFK, ESidTiEnSaFK) VALUES (?,?)";
        PreparedStatement ps = null;

                try {
                    Pconnection grabar = new Pconnection();
                    ps = grabar.getConexion().prepareStatement(insert2);
                    ps.setInt(1,id);
                    ps.setInt(2,3);
                    ps.executeUpdate();
                }catch(SQLException e){
                    System.out.println(e.getMessage());

                } catch (IOException ex) {
            Logger.getLogger(registrador.class.getName()).log(Level.SEVERE, null, ex);
        }

                    
                
        
        resetPersona();
    }//GEN-LAST:event_btnguardarMouseClicked

    private void btnguardarfichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarfichaMouseClicked
        con.setInsert("INSERT INTO ficha (FICnumFic, FICdesFic)VALUES "
                + "("+jtxtCod.getText()+",'"+jtxtNom.getText()+"')");
        
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Se ha guardado la ficha correctamente</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
        
        jtxtCod.setText("");
        jtxtNom.setText("");
        
        resetLblColor(btnregistros);
        setLblColor(btnregistros);
        //switch bettween Jpanels
        
        oculta();
        jpHome.setVisible(true);
    }//GEN-LAST:event_btnguardarfichaMouseClicked

    private void btnguardarcentroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarcentroMouseClicked
        
        String ciudad = cbxCiudad.getSelectedItem().toString();
        
        con.setSelectInt("Select CIUidCiuPK from ciudad where CIUnomCiu = '"+ciudad+"'", "CIUidCiuPK");
        int idCiudad = con.getSelectInt();
                   
        con.setInsert("INSERT INTO centros (CENnomCen, CENcodSenCen, CENidCiuFK) VALUES"
                +"('"+jtxtNombreCentro.getText()+"','"+jtxtCodCentro.getText()+"',"+idCiudad+")");
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Se ha guardado el centro correctamente</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
        
        jtxtNombreCentro.setText("");
        jtxtCodCentro.setText("");
        cbxDepartamento.setSelectedIndex(0);
        
        resetLblColor(btnregistros);
        setLblColor(btnregistros);
        //switch bettween Jpanels
        oculta();
        jpHome.setVisible(true);        
    }//GEN-LAST:event_btnguardarcentroMouseClicked

    private void cbxDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDepartamentoActionPerformed
        cbxCiudad.removeAllItems();

        con.getConexion();
        if(cbxDepartamento.getSelectedIndex()>0){
            con.setLlenaCombo(("Select CIUnomCiu from ciudad where CIUidDepFK "
                + "= "+cbxDepartamento.getSelectedIndex()),"CIUnomCiu", 2);

        }
    }//GEN-LAST:event_cbxDepartamentoActionPerformed

    private void btncancelarcentroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarcentroMouseClicked
        
        oculta();
        jpHome.setVisible(true);
        setLblColor(btnregistros);
    }//GEN-LAST:event_btncancelarcentroMouseClicked

    private void btncancelarfichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarfichaMouseClicked
        setLblColor(btnregistros);
        oculta();
        jpHome.setVisible(true);
    }//GEN-LAST:event_btncancelarfichaMouseClicked

    private void btnusuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnusuariosMouseClicked
        cbxFicha.removeAll();
        cbxFicha.addItem("Seleccione");
        con.setLlenaCombo("Select FICnumFic from ficha", "FICnumFic", 2);
        cbxFicha.addItem(con.getLlenaCombo());
        //cbxFicha.remove(3);
        
        cbxCentro.removeAll();
        cbxCentro.addItem("Seleccione");
        con.setLlenaCombo("Select CENnomCen from centros ", "CENnomCen", 2);
        cbxCentro.addItem(con.getLlenaCombo());
        //cbxCentro.remove(3);
        
        estadobox.setEnabled(false);
        
        resetLblColor(btnregistros);
        //switch bettween Jpanels
        oculta();
        formulario.setVisible(true);
        resetPersona();
    }//GEN-LAST:event_btnusuariosMouseClicked

    private void btnfichasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfichasMouseClicked
        resetLblColor(btnregistros);
        oculta();
        jpFicha.setVisible(true);
    }//GEN-LAST:event_btnfichasMouseClicked

    private void btncentrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncentrosMouseClicked
        resetLblColor(btnregistros);
        oculta();
        jpCentros.setVisible(true);
    }//GEN-LAST:event_btncentrosMouseClicked

    private void txtconsulta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtconsulta1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconsulta1MouseClicked

    private void txtconsulta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconsulta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconsulta1ActionPerformed

    private void txtconsulta1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtconsulta1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconsulta1KeyReleased

    private void tipoboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoboxItemStateChanged

    }//GEN-LAST:event_tipoboxItemStateChanged

    private void tipoboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoboxMouseClicked

    }//GEN-LAST:event_tipoboxMouseClicked

    private void tipoboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoboxActionPerformed

    }//GEN-LAST:event_tipoboxActionPerformed

    private void btnregistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistrosMouseClicked
        
        setLblColor(btnregistros);
        oculta();
        jpHome.setVisible(true);
    }//GEN-LAST:event_btnregistrosMouseClicked

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
                Logger.getLogger(registrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            log.setVisible(true);
	}
    }//GEN-LAST:event_btnlogoutMouseClicked

    private void lbsubirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbsubirMouseClicked
        try{
            Camara window = new Camara();
            window.show();
            window.setLocationRelativeTo(null);
        }catch (Exception e){
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> La camara ya esta en uso</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
        }       
    }//GEN-LAST:event_lbsubirMouseClicked

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnguarcampassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguarcampassMouseClicked
        int num = txtid.getText().length();
        if(num==0){
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> El campo Usuario no puede estar vacío</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
        }else{
            contrasena();
            conecMySQL();
        }
    }//GEN-LAST:event_btnguarcampassMouseClicked

    private void btncancelarpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarpassMouseClicked
        
        //cambio entre Jpanels
        oculta();
        jpHome.setVisible(true);
        
    }//GEN-LAST:event_btncancelarpassMouseClicked

    private void cambiarpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarpassMouseClicked
        oculta();
        JpCamCon.setVisible(true);
    }//GEN-LAST:event_cambiarpassMouseClicked

    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
        char car = evt.getKeyChar();
        if (Character.isLetter(car)){
            evt.consume();
            getToolkit().beep();
        }
        if (Character.isSpaceChar(car)){
            evt.consume();
        }
    }//GEN-LAST:event_txtDocumentoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char car = evt.getKeyChar();
        if (Character.isLetter(car)){
            evt.consume();
            getToolkit().beep();
        }
        if (Character.isSpaceChar(car)){
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        char car = evt.getKeyChar();
        if (Character.isLetter(car)){
            evt.consume();
            getToolkit().beep();
        }
        if (Character.isSpaceChar(car)){
            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

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
            java.util.logging.Logger.getLogger(registrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new registrador().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(registrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpCamCon;
    private javax.swing.JLabel barra;
    private javax.swing.JPanel barralateral;
    private javax.swing.JPanel bequipo;
    private javax.swing.JPanel body;
    private javax.swing.JLabel btncancelar;
    private javax.swing.JLabel btncancelarcentro;
    private javax.swing.JLabel btncancelarficha;
    private javax.swing.JLabel btncancelarpass;
    private javax.swing.JLabel btncentros;
    private javax.swing.JLabel btncerrar;
    private javax.swing.JLabel btnfichas;
    private javax.swing.JLabel btnguarcampass;
    private javax.swing.JLabel btnguardar;
    private javax.swing.JLabel btnguardarcentro;
    private javax.swing.JLabel btnguardarficha;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JLabel btnminimizar;
    private javax.swing.JLabel btnregistros;
    private javax.swing.JLabel btnusuarios;
    private javax.swing.JLabel cambiarpass;
    public static java.awt.Choice cbxCentro;
    public static javax.swing.JComboBox<String> cbxCiudad;
    public static javax.swing.JComboBox<String> cbxDepartamento;
    public static java.awt.Choice cbxFicha;
    private java.awt.Choice cbxGenero;
    private java.awt.Choice cbxRh;
    private java.awt.Choice cbxRol;
    private java.awt.Choice cbxTipUser;
    private java.awt.Choice cbxTipoDoc;
    private javax.swing.JTextArea desctxt;
    private java.awt.Choice estadobox;
    private javax.swing.JLabel etiqueta;
    private javax.swing.JLabel etiqueta1;
    private javax.swing.JLabel etiqueta10;
    private javax.swing.JLabel etiqueta11;
    private javax.swing.JLabel etiqueta12;
    private javax.swing.JLabel etiqueta13;
    private javax.swing.JLabel etiqueta14;
    private javax.swing.JLabel etiqueta15;
    private javax.swing.JLabel etiqueta16;
    private javax.swing.JLabel etiqueta17;
    private javax.swing.JLabel etiqueta18;
    private javax.swing.JLabel etiqueta19;
    private javax.swing.JLabel etiqueta2;
    private javax.swing.JLabel etiqueta20;
    private javax.swing.JLabel etiqueta21;
    private javax.swing.JLabel etiqueta22;
    private javax.swing.JLabel etiqueta23;
    private javax.swing.JLabel etiqueta24;
    private javax.swing.JLabel etiqueta25;
    private javax.swing.JLabel etiqueta26;
    private javax.swing.JLabel etiqueta27;
    private javax.swing.JLabel etiqueta28;
    private javax.swing.JLabel etiqueta3;
    private javax.swing.JLabel etiqueta30;
    private javax.swing.JLabel etiqueta31;
    private javax.swing.JLabel etiqueta32;
    private javax.swing.JLabel etiqueta33;
    private javax.swing.JLabel etiqueta4;
    private javax.swing.JLabel etiqueta5;
    private javax.swing.JLabel etiqueta6;
    private javax.swing.JLabel etiqueta7;
    private javax.swing.JLabel etiqueta8;
    private javax.swing.JLabel etiqueta9;
    private javax.swing.JLabel etiquetanombre;
    private javax.swing.JLabel etiquetatrol;
    private javax.swing.JPanel formulario;
    private javax.swing.JPanel head;
    private javax.swing.JPanel header;
    private javax.swing.JPanel hequipo;
    private javax.swing.JLabel iconbuscar1;
    public static javax.swing.JLabel imagen;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPasswordField jPactual;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPcNueva;
    private javax.swing.JPasswordField jPnueva;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JPanel jpCentros;
    private javax.swing.JPanel jpFicha;
    private javax.swing.JPanel jpHome;
    private javax.swing.JTextField jtxtCod;
    private javax.swing.JTextField jtxtCodCentro;
    private javax.swing.JTextField jtxtNom;
    private javax.swing.JTextField jtxtNombreCentro;
    public static javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblrol;
    private javax.swing.JLabel lbsubir;
    private javax.swing.JComboBox<String> marcabox;
    private javax.swing.JPanel separador1;
    private javax.swing.JPanel separador10;
    private javax.swing.JPanel separador11;
    private javax.swing.JPanel separador12;
    private javax.swing.JPanel separador13;
    private javax.swing.JPanel separador14;
    private javax.swing.JPanel separador15;
    private javax.swing.JPanel separador16;
    private javax.swing.JPanel separador17;
    private javax.swing.JPanel separador18;
    private javax.swing.JPanel separador2;
    private javax.swing.JPanel separador20;
    private javax.swing.JPanel separador21;
    private javax.swing.JPanel separador3;
    private javax.swing.JPanel separador4;
    private javax.swing.JPanel separador5;
    private javax.swing.JPanel separador6;
    private javax.swing.JPanel separador7;
    private javax.swing.JPanel separador8;
    private javax.swing.JPanel separador9;
    private javax.swing.JTable tblListaEquipos;
    private javax.swing.JComboBox<String> tipobox;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtconsulta1;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
