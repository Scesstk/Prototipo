
package prototipo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class admin extends javax.swing.JFrame {

ConnectBD.Pconnection con= new ConnectBD.Pconnection();
    public admin() {
        initComponents();
        
        //inicio en false las vistas
        formulario.setVisible(false);
        body2.setVisible(false);
        body3.setVisible(false);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
        setLblColor(btnhome);
        resetLblColor(btnpersonas);
        resetLblColor(btnreportes);
        resetLblColor(btnregistros);
        
        
        
        
        this.setLocationRelativeTo(null);
        Border border = LineBorder.createGrayLineBorder();
        imagen.setBorder(border);
        
        //item de centrobox
        centrobox.addItem("Centro");
        centrobox.addItem("Otro");
        centrobox.select(0);
        
        //item de estadobox
        estadobox.addItem("Activo");
        estadobox.addItem("Inactivo");
        estadobox.select(0);
        
        //item de rhbox
        rhbox.addItem("A+");
        rhbox.addItem("A-");
        rhbox.addItem("AB+");
        rhbox.addItem("AB-");
        rhbox.addItem("B+");
        rhbox.addItem("B-");
        rhbox.addItem("O+");
        rhbox.addItem("O-");
        rhbox.select(0);
        
        //item de tipodocumentobox
        tipodocumentobox.add("C.C.");
        tipodocumentobox.add("T.I.");
        tipodocumentobox.add("Pasaporte");
        tipodocumentobox.select(0);
        //item de rolbox
        rolbox.addItem("Administrador");
        rolbox.addItem("Operador");
        rolbox.addItem("Usuario");
        rolbox.addItem("Ninguno");
        rolbox.select(0);
        
        //item de fichabox
        fichabox.addItem("Ficha de Formacion");
        fichabox.addItem("Otra");
        fichabox.select(0);
        //item de tipousuariobox
        tipousuariobox.addItem("Aprendiz");
        tipousuariobox.addItem("Instructor");
        tipousuariobox.addItem("Contratista");
        tipousuariobox.addItem("Administrativo");
        tipousuariobox.addItem("Visitante");
        tipousuariobox.select(0);
        //item de generobox
        generobox.addItem("Masculino");
        generobox.addItem("Femenino");
        generobox.select(0);
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
    
    public void obtener(){
        
     busquedasrt = txtconsulta.getText();
     busq = txtconsulta.getText();
     
   
 
        }
   

    public void CargarTablaUsuarios(){        
 
    
        try{
            obtener();
        
   
          String tipo_documento, num_documento, nombre_1, ape_1, rol, ape_2, nombre_2; 
            Statement buscar = con.getConexion().createStatement();
                

                
                con.setSelectStr("SELECT Id_persona FROM persona WHERE nombre_1 like '%"+busquedasrt+"%' or  apellido_1 like '%"+busquedasrt+"%' or Num_documento like '%"+busq+"%' ","Id_persona");
                txt = con.getSelectStr();
                id = Integer.parseInt(txt);
                
                
                ResultSet mostrar=buscar.executeQuery("select descripcion_tip_documento, num_documento, nombre_1, nombre_2, apellido_1, apellido_2, descripcion_rol "
                    + "from persona per "
                    + "inner join rol ro on per.id_rol =ro.id_rol "
                    + "inner join documento doc on per.id_documento = doc.id_documento "
                    + "where nombre_1 like'%"+busquedasrt+"%'or apellido_1 like '%"+busquedasrt+"%' or id_persona like '%"+id+"%';");
                
                String[] titulos = {"Identificación","Numero de documento","Nombres","Apellidos","Rol","Editar"};
        DefaultTableModel modeloe=new DefaultTableModel();
        modeloe.setColumnIdentifiers(titulos);
        
        
       
        
        
     
        while(mostrar.next()){
            tipo_documento=mostrar.getString("descripcion_tip_documento");
                   num_documento=mostrar.getString("Num_documento");
                   nombre_1=mostrar.getString("nombre_1");
                   nombre_2=mostrar.getString("nombre_2");
                   ape_1=mostrar.getString("apellido_1");
                   ape_2=mostrar.getString("apellido_2");
                   rol=mostrar.getString("descripcion_rol");
                
                   
                   modeloe.addRow(new Object[]{tipo_documento,num_documento,nombre_1+" "+nombre_2,ape_1+" "+ape_2,rol});
                   int variable = tabla.getSelectedRow();
                   tabla.setModel(modeloe);  
                   
        }
       
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error de MySql");
            }catch(Exception err){
                
        }
       
    
    }
    
    
                                      
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        barralateral = new javax.swing.JPanel();
        btnpersonas = new javax.swing.JLabel();
        btnreportes = new javax.swing.JLabel();
        btnhome = new javax.swing.JLabel();
        btnregistros = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        btnminimizar = new javax.swing.JLabel();
        btncerrar = new javax.swing.JLabel();
        barra = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        head = new javax.swing.JPanel();
        hhome = new javax.swing.JPanel();
        etiquetanombre = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        etiquetatrol = new javax.swing.JLabel();
        lblrol = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        etiquetanombre1 = new javax.swing.JLabel();
        lblrol1 = new javax.swing.JLabel();
        hbuscar = new javax.swing.JPanel();
        iconbuscar = new javax.swing.JLabel();
        separador = new javax.swing.JPanel();
        txtconsulta = new javax.swing.JTextField();
        nuevoregistro2 = new javax.swing.JLabel();
        cambiarpass = new javax.swing.JLabel();
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
        body = new javax.swing.JPanel();
        bhome = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnpassac = new javax.swing.JLabel();
        btnregistroac = new javax.swing.JLabel();
        btnequipoac = new javax.swing.JLabel();
        bbuscar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        bequipo = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListaEquipos = new javax.swing.JTable();
        body2 = new javax.swing.JPanel();
        formulario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        etiqueta = new javax.swing.JLabel();
        separador1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        etiqueta1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        separador2 = new javax.swing.JPanel();
        etiqueta2 = new javax.swing.JLabel();
        separador3 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        etiqueta3 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        separador4 = new javax.swing.JPanel();
        etiqueta4 = new javax.swing.JLabel();
        separador5 = new javax.swing.JPanel();
        separador6 = new javax.swing.JPanel();
        etiqueta5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        imagen1 = new javax.swing.JLabel();
        lblrol2 = new javax.swing.JLabel();
        etiqueta6 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        separador7 = new javax.swing.JPanel();
        etiqueta7 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        separador8 = new javax.swing.JPanel();
        etiqueta8 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        separador9 = new javax.swing.JPanel();
        centrobox = new java.awt.Choice();
        rolbox = new java.awt.Choice();
        tipodocumentobox = new java.awt.Choice();
        fichabox = new java.awt.Choice();
        tipousuariobox = new java.awt.Choice();
        generobox = new java.awt.Choice();
        estadobox = new java.awt.Choice();
        rhbox = new java.awt.Choice();
        etiqueta9 = new javax.swing.JLabel();
        etiqueta10 = new javax.swing.JLabel();
        etiqueta11 = new javax.swing.JLabel();
        etiqueta12 = new javax.swing.JLabel();
        etiqueta13 = new javax.swing.JLabel();
        etiqueta14 = new javax.swing.JLabel();
        etiqueta15 = new javax.swing.JLabel();
        etiqueta16 = new javax.swing.JLabel();
        btnagregarEquipo = new javax.swing.JLabel();
        btncancelar = new javax.swing.JLabel();
        btnguardar = new javax.swing.JLabel();
        body3 = new javax.swing.JPanel();
        btncentros = new javax.swing.JLabel();
        btnfichas = new javax.swing.JLabel();
        btnequipos = new javax.swing.JLabel();
        body4 = new javax.swing.JPanel();
        etiqueta17 = new javax.swing.JLabel();
        btnguardarficha = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        separador10 = new javax.swing.JPanel();
        etiqueta18 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        separador11 = new javax.swing.JPanel();
        etiqueta19 = new javax.swing.JLabel();
        btncancelarficha = new javax.swing.JLabel();
        body5 = new javax.swing.JPanel();
        etiqueta20 = new javax.swing.JLabel();
        btnguardarcentro = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        separador12 = new javax.swing.JPanel();
        etiqueta21 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        separador13 = new javax.swing.JPanel();
        etiqueta22 = new javax.swing.JLabel();
        cbxDepartamento = new javax.swing.JComboBox<>();
        cbxCiudad = new javax.swing.JComboBox<>();
        btncancelarcentro = new javax.swing.JLabel();
        body6 = new javax.swing.JPanel();
        etiqueta23 = new javax.swing.JLabel();
        btnguardarcentro1 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        separador14 = new javax.swing.JPanel();
        etiqueta24 = new javax.swing.JLabel();
        separador15 = new javax.swing.JPanel();
        etiqueta25 = new javax.swing.JLabel();
        btncancelarpass = new javax.swing.JLabel();
        etiqueta26 = new javax.swing.JLabel();
        separador16 = new javax.swing.JPanel();
        etiqueta27 = new javax.swing.JLabel();
        separador17 = new javax.swing.JPanel();
        txtpass1 = new javax.swing.JPasswordField();
        txtpass3 = new javax.swing.JPasswordField();
        txtpass4 = new javax.swing.JPasswordField();

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

        btnpersonas.setBackground(new java.awt.Color(89, 181, 72));
        btnpersonas.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnpersonas.setForeground(new java.awt.Color(255, 255, 255));
        btnpersonas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnpersonas.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\usuarios.png")); // NOI18N
        btnpersonas.setText("Personas");
        btnpersonas.setToolTipText("");
        btnpersonas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpersonas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnpersonas.setIconTextGap(1);
        btnpersonas.setName(""); // NOI18N
        btnpersonas.setOpaque(true);
        btnpersonas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnpersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpersonasMouseClicked(evt);
            }
        });
        barralateral.add(btnpersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 70, 70));

        btnreportes.setBackground(new java.awt.Color(89, 181, 72));
        btnreportes.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnreportes.setForeground(new java.awt.Color(255, 255, 255));
        btnreportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnreportes.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\periodico.png")); // NOI18N
        btnreportes.setText("Reportes");
        btnreportes.setToolTipText("");
        btnreportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnreportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnreportes.setIconTextGap(1);
        btnreportes.setName(""); // NOI18N
        btnreportes.setOpaque(true);
        btnreportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnreportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnreportesMouseClicked(evt);
            }
        });
        barralateral.add(btnreportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 70, 70));

        btnhome.setBackground(new java.awt.Color(89, 181, 72));
        btnhome.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnhome.setForeground(new java.awt.Color(255, 255, 255));
        btnhome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnhome.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\casa.png")); // NOI18N
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
        barralateral.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 70, 70));

        btnregistros.setBackground(new java.awt.Color(89, 181, 72));
        btnregistros.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnregistros.setForeground(new java.awt.Color(255, 255, 255));
        btnregistros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnregistros.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\agregar-documento-simbolo-delineado.png")); // NOI18N
        btnregistros.setText("Registros");
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
        barralateral.add(btnregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 70, 70));

        getContentPane().add(barralateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 460));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnminimizar.setBackground(new java.awt.Color(255, 255, 255));
        btnminimizar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnminimizar.setForeground(new java.awt.Color(89, 181, 72));
        btnminimizar.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\minimizar.png")); // NOI18N
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
        btncerrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\borrar.png")); // NOI18N
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
        header.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 170, 40));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 40));

        head.setBackground(new java.awt.Color(255, 255, 255));
        head.setLayout(new java.awt.CardLayout());

        hhome.setBackground(new java.awt.Color(255, 255, 255));

        etiquetanombre.setFont(new java.awt.Font("Calibri", 1, 26)); // NOI18N
        etiquetanombre.setForeground(new java.awt.Color(89, 181, 72));
        etiquetanombre.setText("Bienvenido(a):");

        lblnombre.setFont(new java.awt.Font("Calibri", 1, 26)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(89, 181, 72));
        lblnombre.setText("Gustavo Risueño");

        etiquetatrol.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        etiquetatrol.setForeground(new java.awt.Color(89, 181, 72));
        etiquetatrol.setText("Rol:");

        lblrol.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblrol.setForeground(new java.awt.Color(89, 181, 72));
        lblrol.setText("Administrador");

        imagen.setOpaque(true);

        etiquetanombre1.setBackground(new java.awt.Color(89, 181, 72));
        etiquetanombre1.setFont(new java.awt.Font("Calibri", 1, 26)); // NOI18N
        etiquetanombre1.setForeground(new java.awt.Color(255, 255, 255));
        etiquetanombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetanombre1.setText("Accesos Rápidos");
        etiquetanombre1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        etiquetanombre1.setOpaque(true);

        lblrol1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblrol1.setForeground(new java.awt.Color(89, 181, 72));
        lblrol1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblrol1.setText("Subir");

        javax.swing.GroupLayout hhomeLayout = new javax.swing.GroupLayout(hhome);
        hhome.setLayout(hhomeLayout);
        hhomeLayout.setHorizontalGroup(
            hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hhomeLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblrol1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hhomeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hhomeLayout.createSequentialGroup()
                                .addComponent(etiquetanombre)
                                .addGap(3, 3, 3)
                                .addComponent(lblnombre))
                            .addGroup(hhomeLayout.createSequentialGroup()
                                .addComponent(etiquetatrol)
                                .addGap(7, 7, 7)
                                .addComponent(lblrol))))
                    .addGroup(hhomeLayout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(etiquetanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        hhomeLayout.setVerticalGroup(
            hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hhomeLayout.createSequentialGroup()
                .addGroup(hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hhomeLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetanombre)
                            .addComponent(lblnombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetatrol)
                            .addComponent(lblrol)))
                    .addGroup(hhomeLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetanombre1)
                    .addComponent(lblrol1)))
        );

        head.add(hhome, "card2");

        hbuscar.setBackground(new java.awt.Color(255, 255, 255));
        hbuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconbuscar.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\buscar-con-herramienta-en-esquema.png")); // NOI18N
        hbuscar.add(iconbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 70, -1));

        separador.setBackground(new java.awt.Color(89, 181, 72));
        separador.setForeground(new java.awt.Color(89, 181, 72));
        separador.setPreferredSize(new java.awt.Dimension(172, 2));
        separador.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separadorLayout = new javax.swing.GroupLayout(separador);
        separador.setLayout(separadorLayout);
        separadorLayout.setHorizontalGroup(
            separadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separadorLayout.setVerticalGroup(
            separadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        hbuscar.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 200, 2));

        txtconsulta.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtconsulta.setForeground(new java.awt.Color(102, 102, 102));
        txtconsulta.setText("A quien buscas?....");
        txtconsulta.setBorder(null);
        txtconsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtconsultaMouseClicked(evt);
            }
        });
        txtconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconsultaActionPerformed(evt);
            }
        });
        txtconsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtconsultaKeyReleased(evt);
            }
        });
        hbuscar.add(txtconsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 190, 30));

        nuevoregistro2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        nuevoregistro2.setForeground(new java.awt.Color(89, 181, 72));
        nuevoregistro2.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\agregar-usuario.png")); // NOI18N
        nuevoregistro2.setText(" Nuevo Registro");
        nuevoregistro2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nuevoregistro2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nuevoregistro2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevoregistro22MouseClicked(evt);
            }
        });
        hbuscar.add(nuevoregistro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        cambiarpass.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cambiarpass.setForeground(new java.awt.Color(89, 181, 72));
        cambiarpass.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\contrasena.png")); // NOI18N
        cambiarpass.setText("Cambiar Contraseña");
        cambiarpass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cambiarpass.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cambiarpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarpassMouseClicked(evt);
            }
        });
        hbuscar.add(cambiarpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        head.add(hbuscar, "card3");

        hequipo.setBackground(new java.awt.Color(255, 255, 255));
        hequipo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconbuscar1.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\buscar-con-herramienta-en-esquema.png")); // NOI18N
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

        body.setBackground(new java.awt.Color(244, 242, 242));
        body.setLayout(new java.awt.CardLayout());

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(89, 181, 72));
        jLabel9.setText("v 1.0.0");

        btnpassac.setBackground(new java.awt.Color(255, 255, 255));
        btnpassac.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnpassac.setForeground(new java.awt.Color(89, 181, 72));
        btnpassac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnpassac.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\contrasena (1).png")); // NOI18N
        btnpassac.setText("Cambiar Contraseña");
        btnpassac.setToolTipText("");
        btnpassac.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnpassac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpassac.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnpassac.setIconTextGap(1);
        btnpassac.setName(""); // NOI18N
        btnpassac.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnpassac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpassacMouseClicked(evt);
            }
        });

        btnregistroac.setBackground(new java.awt.Color(255, 255, 255));
        btnregistroac.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnregistroac.setForeground(new java.awt.Color(89, 181, 72));
        btnregistroac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnregistroac.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\agregar-usuariox64.png")); // NOI18N
        btnregistroac.setText("Agregar Registro");
        btnregistroac.setToolTipText("");
        btnregistroac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnregistroac.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnregistroac.setIconTextGap(1);
        btnregistroac.setName(""); // NOI18N
        btnregistroac.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnregistroac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnregistroacMouseClicked(evt);
            }
        });

        btnequipoac.setBackground(new java.awt.Color(255, 255, 255));
        btnequipoac.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnequipoac.setForeground(new java.awt.Color(89, 181, 72));
        btnequipoac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnequipoac.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\pantalla-de-tv.png")); // NOI18N
        btnequipoac.setText("Agregar Equipo");
        btnequipoac.setToolTipText("");
        btnequipoac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnequipoac.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnequipoac.setIconTextGap(1);
        btnequipoac.setName(""); // NOI18N
        btnequipoac.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnequipoac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnequipoacMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bhomeLayout = new javax.swing.GroupLayout(bhome);
        bhome.setLayout(bhomeLayout);
        bhomeLayout.setHorizontalGroup(
            bhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bhomeLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnregistroac, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnequipoac, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnpassac, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(bhomeLayout.createSequentialGroup()
                .addGap(780, 780, 780)
                .addComponent(jLabel9))
        );
        bhomeLayout.setVerticalGroup(
            bhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bhomeLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(bhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bhomeLayout.createSequentialGroup()
                        .addGroup(bhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnregistroac, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnequipoac, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addComponent(jLabel9))
                    .addComponent(btnpassac)))
        );

        body.add(bhome, "card3");

        bbuscar.setBackground(new java.awt.Color(255, 255, 255));
        bbuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jScrollPane2.setOpaque(false);

        tabla.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tabla.setForeground(new java.awt.Color(89, 181, 72));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.setGridColor(new java.awt.Color(153, 153, 153));
        tabla.setRowHeight(22);
        tabla.setSelectionBackground(new java.awt.Color(89, 181, 72));
        jScrollPane2.setViewportView(tabla);

        bbuscar.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 250));

        body.add(bbuscar, "card2");

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

        body2.setBackground(new java.awt.Color(255, 255, 255));

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
        etiqueta.setText("Primer Nombre");
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

        jTextField2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 220, 30));

        etiqueta1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta1.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta1.setText("Segundo Nombre");
        jPanel1.add(etiqueta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, 30));

        jTextField3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 215, 30));

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
        etiqueta2.setText("Primer Apellido");
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

        jTextField4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField4.setBorder(null);
        jTextField4.setOpaque(false);
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 220, 30));

        etiqueta3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta3.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta3.setText("Segundo Apellido");
        jPanel1.add(etiqueta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, 30));

        jTextField5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField5.setBorder(null);
        jTextField5.setOpaque(false);
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 220, 30));

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
        etiqueta4.setText("N° Documento");
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

        jTextField6.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField6.setBorder(null);
        jTextField6.setOpaque(false);
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 650, 170, 30));

        jTextField7.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField7.setBorder(null);
        jTextField7.setOpaque(false);
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 170, 30));

        imagen1.setOpaque(true);
        jPanel1.add(imagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 120, 110));

        lblrol2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblrol2.setForeground(new java.awt.Color(89, 181, 72));
        lblrol2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblrol2.setText("Subir");
        jPanel1.add(lblrol2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 100, 20));

        etiqueta6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta6.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta6.setText("N° Telefono");
        jPanel1.add(etiqueta6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, -1, 30));

        jTextField8.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField8.setBorder(null);
        jTextField8.setOpaque(false);
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, 170, 30));

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

        jTextField9.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField9.setBorder(null);
        jTextField9.setOpaque(false);
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 550, 170, 30));

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
        etiqueta8.setText("Tipo de RH");
        jPanel1.add(etiqueta8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 710, -1, 30));

        jTextField10.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField10.setBorder(null);
        jTextField10.setOpaque(false);
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 650, 170, 30));

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

        centrobox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        centrobox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(centrobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 960, 180, 20));

        rolbox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(rolbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 880, 120, -1));

        tipodocumentobox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(tipodocumentobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 220, -1));

        fichabox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(fichabox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 960, 220, -1));

        tipousuariobox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(tipousuariobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 880, 180, -1));

        generobox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(generobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 760, 220, -1));

        estadobox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(estadobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 880, 180, -1));

        rhbox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(rhbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 760, 220, -1));

        etiqueta9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta9.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta9.setText("Tipo de Documento");
        jPanel1.add(etiqueta9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, 30));

        etiqueta10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta10.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta10.setText("N° de Ficha");
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
        etiqueta14.setText("Genero");
        jPanel1.add(etiqueta14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 710, -1, 30));

        etiqueta15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta15.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta15.setText("Tipo de Usuario");
        jPanel1.add(etiqueta15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 830, -1, -1));

        etiqueta16.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta16.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta16.setText("Centro");
        jPanel1.add(etiqueta16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 920, -1, 20));

        btnagregarEquipo.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btnagregarEquipo.setForeground(new java.awt.Color(89, 181, 72));
        btnagregarEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnagregarEquipo.setText("Agregar Equipo");
        btnagregarEquipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btnagregarEquipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnagregarEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnagregarEquipoMouseClicked(evt);
            }
        });
        jPanel1.add(btnagregarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1070, 180, -1));

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

        formulario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 760, 800));

        javax.swing.GroupLayout body2Layout = new javax.swing.GroupLayout(body2);
        body2.setLayout(body2Layout);
        body2Layout.setHorizontalGroup(
            body2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        body2Layout.setVerticalGroup(
            body2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formulario, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(body2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 760, 460));

        body3.setBackground(new java.awt.Color(255, 255, 255));

        btncentros.setBackground(new java.awt.Color(255, 255, 255));
        btncentros.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btncentros.setForeground(new java.awt.Color(89, 181, 72));
        btncentros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btncentros.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\edificio-comercial.png")); // NOI18N
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
        btnfichas.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\carpeta-rellena-con-pestanas.png")); // NOI18N
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

        btnequipos.setBackground(new java.awt.Color(255, 255, 255));
        btnequipos.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnequipos.setForeground(new java.awt.Color(89, 181, 72));
        btnequipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnequipos.setIcon(new javax.swing.ImageIcon("C:\\Users\\TavoRZ\\Desktop\\java\\pantalla-de-tv.png")); // NOI18N
        btnequipos.setText("Agregar Equipos");
        btnequipos.setToolTipText("");
        btnequipos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnequipos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnequipos.setIconTextGap(1);
        btnequipos.setName(""); // NOI18N
        btnequipos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnequipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnequiposMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout body3Layout = new javax.swing.GroupLayout(body3);
        body3.setLayout(body3Layout);
        body3Layout.setHorizontalGroup(
            body3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body3Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(btncentros)
                .addGap(80, 80, 80)
                .addComponent(btnequipos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btnfichas)
                .addGap(101, 101, 101))
        );
        body3Layout.setVerticalGroup(
            body3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body3Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(body3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnequipos)
                    .addComponent(btnfichas)
                    .addComponent(btncentros))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        getContentPane().add(body3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 760, 420));

        body4.setBackground(new java.awt.Color(255, 255, 255));
        body4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiqueta17.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        etiqueta17.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta17.setText("Agregar Ficha");
        body4.add(etiqueta17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 50));

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
        body4.add(btnguardarficha, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 120, -1));

        jTextField11.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField11.setBorder(null);
        jTextField11.setOpaque(false);
        body4.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 220, 30));

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

        body4.add(separador10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 220, -1));

        etiqueta18.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta18.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta18.setText("Nombre de Ficha:");
        body4.add(etiqueta18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, 30));

        jTextField12.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField12.setBorder(null);
        jTextField12.setOpaque(false);
        body4.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 220, 30));

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

        body4.add(separador11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 220, -1));

        etiqueta19.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta19.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta19.setText("Codigo de Ficha:");
        body4.add(etiqueta19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, 30));

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
        body4.add(btncancelarficha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 100, -1));

        getContentPane().add(body4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 760, 420));

        body5.setBackground(new java.awt.Color(255, 255, 255));
        body5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiqueta20.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        etiqueta20.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta20.setText("Agregar Centros");
        body5.add(etiqueta20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 250, 50));

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
        body5.add(btnguardarcentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 110, -1));

        jTextField13.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField13.setBorder(null);
        jTextField13.setOpaque(false);
        body5.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 220, 30));

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

        body5.add(separador12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 220, -1));

        etiqueta21.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta21.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta21.setText("Nombre de Centro:");
        body5.add(etiqueta21, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, 30));

        jTextField14.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField14.setBorder(null);
        jTextField14.setOpaque(false);
        body5.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 220, 30));

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

        body5.add(separador13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 220, -1));

        etiqueta22.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta22.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta22.setText("Codigo de Centro:");
        body5.add(etiqueta22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, 30));

        cbxDepartamento.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbxDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Amazonas", "Antioquia", "Arauca", "Atlántico", "Bolívar", "Boyacá", "Caldas", "Caquetá", "Casanare", "Cauca", "Cesar", "Chocó", "Córdoba", "Cundinamarca", "Guainía", "Guaviare", "Huila", "La Guajira", "Magdalena", "Meta", "Nariño", "Norte de Santander", "Putumayo", "Quindío", "Risaralda", "San Andrés y Providencia", "Santander", "Sucre", "Tolima", "Valle del Cauca", "Vaupés", "Vichada" }));
        cbxDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDepartamentoActionPerformed(evt);
            }
        });
        body5.add(cbxDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        cbxCiudad.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbxCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        body5.add(cbxCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

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
        body5.add(btncancelarcentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 100, -1));

        getContentPane().add(body5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 760, 420));

        body6.setBackground(new java.awt.Color(255, 255, 255));
        body6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiqueta23.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        etiqueta23.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta23.setText("Cambiar Contraseña");
        body6.add(etiqueta23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 320, 50));

        btnguardarcentro1.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btnguardarcentro1.setForeground(new java.awt.Color(89, 181, 72));
        btnguardarcentro1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnguardarcentro1.setText("Guardar");
        btnguardarcentro1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btnguardarcentro1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardarcentro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguardarcentro1MouseClicked(evt);
            }
        });
        body6.add(btnguardarcentro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 110, -1));

        jTextField15.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTextField15.setBorder(null);
        jTextField15.setOpaque(false);
        body6.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 220, 30));

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

        body6.add(separador14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 220, -1));

        etiqueta24.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta24.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta24.setText("Digite su contraseña actual:");
        body6.add(etiqueta24, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, 30));

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

        body6.add(separador15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 220, -1));

        etiqueta25.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta25.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta25.setText("Ingrese el usuario:");
        body6.add(etiqueta25, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, 30));

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
        body6.add(btncancelarpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 100, -1));

        etiqueta26.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta26.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta26.setText("Digite su contraseña actual:");
        body6.add(etiqueta26, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, 30));

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

        body6.add(separador16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 220, -1));

        etiqueta27.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta27.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta27.setText("Digite su contraseña actual:");
        body6.add(etiqueta27, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, 30));

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

        body6.add(separador17, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 220, -1));

        txtpass1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtpass1.setForeground(new java.awt.Color(153, 153, 153));
        txtpass1.setBorder(null);
        body6.add(txtpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 220, 30));

        txtpass3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtpass3.setForeground(new java.awt.Color(153, 153, 153));
        txtpass3.setBorder(null);
        body6.add(txtpass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 220, 30));

        txtpass4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtpass4.setForeground(new java.awt.Color(153, 153, 153));
        txtpass4.setBorder(null);
        body6.add(txtpass4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 220, 30));

        getContentPane().add(body6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 760, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncerrarMouseClicked
        
                int codigo=JOptionPane.showConfirmDialog(null, "¿Desea Salir del Programa?", "SALIR", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (codigo==JOptionPane.YES_OPTION){
			dispose();
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

    private void txtconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconsultaActionPerformed

    private void txtconsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtconsultaKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                   CargarTablaUsuarios();
                }
                if(evt.getKeyCode()==KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
    }//GEN-LAST:event_txtconsultaKeyReleased

    private void txtconsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtconsultaMouseClicked
        txtconsulta.setText("");
    }//GEN-LAST:event_txtconsultaMouseClicked

    private void btnpersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpersonasMouseClicked
        setLblColor(btnpersonas);
        resetLblColor(btnhome);
        resetLblColor(btnreportes);
        resetLblColor(btnregistros);
        //switch bettween Jpanels
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(true);
        bbuscar.setVisible(true);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        formulario.setVisible(false);
        body2.setVisible(false);
        body.setVisible(true);
        head.setVisible(true);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
        
    }//GEN-LAST:event_btnpersonasMouseClicked

    private void btnreportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnreportesMouseClicked
        setLblColor(btnreportes);
        resetLblColor(btnpersonas);
        resetLblColor(btnhome);
        resetLblColor(btnregistros);
        //switch bettween Jpanels
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        formulario.setVisible(true);
        body2.setVisible(false);
        body.setVisible(true);
        head.setVisible(true);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
        
    }//GEN-LAST:event_btnreportesMouseClicked

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
        setLblColor(btnhome);
        resetLblColor(btnpersonas);
        resetLblColor(btnreportes);
        resetLblColor(btnregistros);
        //switch bettween Jpanels
        hhome.setVisible(true);
        bhome.setVisible(true);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        formulario.setVisible(false);
        body2.setVisible(false);
        body.setVisible(true);
        head.setVisible(true);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
        
    }//GEN-LAST:event_btnhomeMouseClicked

    private void nuevoregistro22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoregistro22MouseClicked
        //switch bettween Jpanels
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        formulario.setVisible(true);
        body2.setVisible(true);
        body.setVisible(false);
        head.setVisible(false);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
    }//GEN-LAST:event_nuevoregistro22MouseClicked

    private void btnpassacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpassacMouseClicked
        //switch bettween Jpanels
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        formulario.setVisible(false);
        body2.setVisible(false);
        body.setVisible(false);
        head.setVisible(false);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(true);
    }//GEN-LAST:event_btnpassacMouseClicked

    private void btnregistroacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistroacMouseClicked
        //switch bettween Jpanels
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        formulario.setVisible(true);
        body2.setVisible(true);
        body.setVisible(false);
        head.setVisible(false);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
    }//GEN-LAST:event_btnregistroacMouseClicked

    private void btnequipoacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnequipoacMouseClicked
       //switch bettween Jpanels
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        hequipo.setVisible(true);
        bequipo.setVisible(true);
        formulario.setVisible(false);
        body2.setVisible(false);
        body.setVisible(true);
        head.setVisible(true);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
    }//GEN-LAST:event_btnequipoacMouseClicked

    private void btnagregarEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarEquipoMouseClicked
        //switch bettween Jpanels
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        hequipo.setVisible(true);
        bequipo.setVisible(true);
        formulario.setVisible(false);
        body2.setVisible(false);
        body.setVisible(true);
        head.setVisible(true);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
    }//GEN-LAST:event_btnagregarEquipoMouseClicked

    private void btncancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarMouseClicked
        setLblColor(btnpersonas);
        resetLblColor(btnhome);
        resetLblColor(btnreportes);
        resetLblColor(btnregistros);
        //switch bettween Jpanels
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(true);
        bbuscar.setVisible(true);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        formulario.setVisible(false);
        body2.setVisible(false);
        body.setVisible(true);
        head.setVisible(true);
        body3.setVisible(false);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
    }//GEN-LAST:event_btncancelarMouseClicked

    private void btnguardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardarMouseClicked

    private void btnregistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistrosMouseClicked
        setLblColor(btnregistros);
        resetLblColor(btnpersonas);
        resetLblColor(btnhome);
        resetLblColor(btnreportes);
        //switch bettween Jpanels
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        formulario.setVisible(false);
        body2.setVisible(false);
        body.setVisible(false);
        head.setVisible(false);
        body3.setVisible(true);        
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
    }//GEN-LAST:event_btnregistrosMouseClicked

    private void btncentrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncentrosMouseClicked
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        formulario.setVisible(false);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        body2.setVisible(false);
        body.setVisible(false);
        head.setVisible(false);
        body3.setVisible(false);
        body4.setVisible(false);
        body5.setVisible(true);
        body6.setVisible(false);
    }//GEN-LAST:event_btncentrosMouseClicked

    private void btnfichasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfichasMouseClicked
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        formulario.setVisible(false);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        body2.setVisible(false);
        body.setVisible(false);
        head.setVisible(false);
        body3.setVisible(false);
        body4.setVisible(true);
        body5.setVisible(false);
        body6.setVisible(false);
    }//GEN-LAST:event_btnfichasMouseClicked

    private void btnguardarfichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarfichaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardarfichaMouseClicked

    private void btnguardarcentroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarcentroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardarcentroMouseClicked

    private void cbxDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDepartamentoActionPerformed
        

    }//GEN-LAST:event_cbxDepartamentoActionPerformed

    private void btncancelarcentroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarcentroMouseClicked
        setLblColor(btnregistros);
        resetLblColor(btnhome);
        resetLblColor(btnreportes);
        resetLblColor(btnpersonas);
        //switch bettween Jpanels
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        formulario.setVisible(false);
        body2.setVisible(false);
        body.setVisible(false);
        head.setVisible(false);
        body3.setVisible(true);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
    }//GEN-LAST:event_btncancelarcentroMouseClicked

    private void btncancelarfichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarfichaMouseClicked
        setLblColor(btnregistros);
        resetLblColor(btnhome);
        resetLblColor(btnreportes);
        resetLblColor(btnpersonas);
        //switch bettween Jpanels
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        formulario.setVisible(false);
        body2.setVisible(false);
        body.setVisible(false);
        head.setVisible(false);
        body3.setVisible(true);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
    }//GEN-LAST:event_btncancelarfichaMouseClicked

    private void cambiarpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarpassMouseClicked
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        formulario.setVisible(false);
        body2.setVisible(false);
        body.setVisible(false);
        head.setVisible(false);
        body3.setVisible(false);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(true);
    }//GEN-LAST:event_cambiarpassMouseClicked

    private void btnguardarcentro1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarcentro1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardarcentro1MouseClicked

    private void btncancelarpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarpassMouseClicked
        setLblColor(btnpersonas);
        resetLblColor(btnhome);
        resetLblColor(btnreportes);
        resetLblColor(btnregistros);
        //cambio entre Jpanels
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(true);
        bbuscar.setVisible(true);
        hequipo.setVisible(false);
        bequipo.setVisible(false);
        formulario.setVisible(false);
        body2.setVisible(false);
        body.setVisible(true);
        head.setVisible(true);
        body3.setVisible(false);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
    }//GEN-LAST:event_btncancelarpassMouseClicked

    private void btnequiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnequiposMouseClicked
       //switch bettween Jpanels
        hhome.setVisible(false);
        bhome.setVisible(false);
        hbuscar.setVisible(false);
        bbuscar.setVisible(false);
        hequipo.setVisible(true);
        bequipo.setVisible(true);
        formulario.setVisible(false);
        body2.setVisible(false);
        body.setVisible(true);
        head.setVisible(true);
        body4.setVisible(false);
        body5.setVisible(false);
        body6.setVisible(false);
    }//GEN-LAST:event_btnequiposMouseClicked

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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barra;
    private javax.swing.JPanel barralateral;
    private javax.swing.JPanel bbuscar;
    private javax.swing.JPanel bequipo;
    private javax.swing.JPanel bhome;
    private javax.swing.JPanel body;
    private javax.swing.JPanel body2;
    private javax.swing.JPanel body3;
    private javax.swing.JPanel body4;
    private javax.swing.JPanel body5;
    private javax.swing.JPanel body6;
    private javax.swing.JLabel btnagregarEquipo;
    private javax.swing.JLabel btncancelar;
    private javax.swing.JLabel btncancelarcentro;
    private javax.swing.JLabel btncancelarficha;
    private javax.swing.JLabel btncancelarpass;
    private javax.swing.JLabel btncentros;
    private javax.swing.JLabel btncerrar;
    private javax.swing.JLabel btnequipoac;
    private javax.swing.JLabel btnequipos;
    private javax.swing.JLabel btnfichas;
    private javax.swing.JLabel btnguardar;
    private javax.swing.JLabel btnguardarcentro;
    private javax.swing.JLabel btnguardarcentro1;
    private javax.swing.JLabel btnguardarficha;
    private javax.swing.JLabel btnhome;
    private javax.swing.JLabel btnminimizar;
    private javax.swing.JLabel btnpassac;
    private javax.swing.JLabel btnpersonas;
    private javax.swing.JLabel btnregistroac;
    private javax.swing.JLabel btnregistros;
    private javax.swing.JLabel btnreportes;
    private javax.swing.JLabel cambiarpass;
    public static javax.swing.JComboBox<String> cbxCiudad;
    public static javax.swing.JComboBox<String> cbxDepartamento;
    private java.awt.Choice centrobox;
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
    private javax.swing.JLabel etiquetanombre1;
    private javax.swing.JLabel etiquetatrol;
    private java.awt.Choice fichabox;
    private javax.swing.JPanel formulario;
    private java.awt.Choice generobox;
    private javax.swing.JPanel hbuscar;
    private javax.swing.JPanel head;
    private javax.swing.JPanel header;
    private javax.swing.JPanel hequipo;
    private javax.swing.JPanel hhome;
    private javax.swing.JLabel iconbuscar;
    private javax.swing.JLabel iconbuscar1;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel imagen1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblrol;
    private javax.swing.JLabel lblrol1;
    private javax.swing.JLabel lblrol2;
    private javax.swing.JComboBox<String> marcabox;
    private javax.swing.JLabel nuevoregistro2;
    private java.awt.Choice rhbox;
    private java.awt.Choice rolbox;
    private javax.swing.JPanel separador;
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
    private javax.swing.JTable tabla;
    private javax.swing.JTable tblListaEquipos;
    private javax.swing.JComboBox<String> tipobox;
    private java.awt.Choice tipodocumentobox;
    private java.awt.Choice tipousuariobox;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtconsulta;
    private javax.swing.JTextField txtconsulta1;
    private javax.swing.JPasswordField txtpass1;
    private javax.swing.JPasswordField txtpass3;
    private javax.swing.JPasswordField txtpass4;
    // End of variables declaration//GEN-END:variables
}
