
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
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.DefaultFocusManager;
import prototipo.admin;
import prototipo.operador;
import prototipo.registrador;


public class loginf extends javax.swing.JFrame {

    
    public loginf() {
        initComponents();
        this.setLocationRelativeTo(null);
        adv();
        oportunidad();
    }
    
    public int prueba, cedula, opor=0, conti=0, contp=0, cont=0;
    public static String rol="";
    public String pass,activo,contra;
    public static String nombre="";
    public static int cc;
    
    private void contrasena(){
        char clave[]=txtpass.getPassword();
        String clavedef = new String(clave);
        cedula = Integer.parseInt(txtid.getText());
        pass = clavedef;
    }
  
    public void adv(){
    adv1.setVisible(false);
    adv2.setVisible(false);
    adv3.setVisible(false);
    adv4.setVisible(false);
    adv5.setVisible(false);
    }
    
    public void oportunidad(){
        if(opor==2){
            adv2.setVisible(true);
            adv1.setVisible(false);
        }
        if(opor==3){
            adv3.setVisible(true);
            adv2.setVisible(false);
            adv1.setVisible(false);
        }
        if(opor==4){
            adv4.setVisible(true);
            adv3.setVisible(false);
            adv1.setVisible(false);
        }
        if(opor==5){
            adv5.setVisible(true);
            adv4.setVisible(false);
            adv1.setVisible(false);
            btnok.setEnabled(false);
            
            //Creacion del objeto de conexion
            Pconnection bloquea = new Pconnection();
            
            // Bloqueo de usuario en Base de datos con sentencia UPDATE
            bloquea.setUpdate("Update acceso as a JOIN persona as p on a.ACCidPerFK=p.PERidPerPK "
                    + "set ACCact = 'NO' WHERE PERnumDoc = '"+cedula+"'");
            //Cierre de conexion a la base de datos
            bloquea.cerrarConexion();
            //Inhabilita el campo usuario
            txtid.setEditable(false);
            //Inhabilita el campo password
            txtpass.setEditable(false);
            
        }
    }
    
    //METODO DE CONEXION A LA BASE DE DATOS
    public void conMySQL(){
        nombre= "";
        //Creacion del objeto de conexion
        Pconnection prueba = new Pconnection();
        
        //Comparacion cedula digitada con base de datos
        prueba.setSelectInt(("SELECT PERnumDoc FROM persona WHERE PERnumDoc ='"+cedula+"'"),
                "PERnumDoc");
        //Almacenamiento en variable
        cc = prueba.getSelectInt();
        
        //Extraccion de contraseña en base de datos
        prueba.setSelectStr(("SELECT ACCcon FROM acceso as a "
                        + "JOIN persona as p on a.ACCidPerFK=p.PERidPerPK WHERE PERnumDoc = '"+cedula+"'"),
                "ACCcon");
        //Almacenamiento en variable
        contra = prueba.getSelectStr();
        
        //Extraccion Base datos si usuario se encuentra activo
        prueba.setSelectStr(("SELECT ACCact FROM acceso as a "
                        + "JOIN persona as p on a.ACCidPerFK=p.PERidPerPK WHERE PERnumDoc = '"+cedula+"'"),
                "ACCact");
        //Almacenamiento en variable
        activo = prueba.getSelectStr();
        
        //Conversion de pasword a MD5
        prueba.setSelectMd5(pass, pass);
        //Almacenamiento en variable
        pass = prueba.getMd5();
        
        //Concatenacion del nombre
        prueba.setSelectStr(("SELECT concat(PERnom1,' ',PERnom2,' ',PERape1,' ',PERape2) as Nombre FROM persona WHERE PERnumDoc ='"+cedula+"'"),
                "Nombre");
        //Almacenamiento en variable 
        nombre = prueba.getSelectStr();
        
        //Extraccion descripcion del rol
        prueba.setSelectStr(("SELECT ROLdesRol FROM rol as r "
                        + "JOIN persona as p on r.ROLidRolPK=p.PERidRolFK WHERE PERnumDoc = '"+cedula+"'"), 
                "ROLdesRol");
        //Almacenamiento en variable
        rol = prueba.getSelectStr();
        
        //Cierre de conexion a la base de datos
        prueba.cerrarConexion();
    }
    
    public void accede(){
        int pr;
        try{
            //Linea para validar ingreso de datos de usuario
            pr = Integer.parseInt(txtid.getText());
            //Inicia el metodo de verificacion de contraseña
            contrasena();
            //Ejecuta el metodo de conexion a la base de datos
            conMySQL();
            //Validacion de usuario Activo o no
            if(activo.equals("NO")){
                JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                + "Su USUARIO "+nombre+" no se encuentra ACTIVADO", "Acceso denegado",
                JOptionPane.ERROR_MESSAGE);
                txtid.setText(null);
                txtpass.setText(null);
            }else {
                //Ejecuta el metodo de acceso al Sistema    
                acceso();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "EL usuario no puede contener Caracteres Especiales");
        }
    }
    
    private void acceso(){
        if(pass.equals(contra)){
            
            if(rol.equals("REGISTRADOR")){
                this.dispose();
                JOptionPane.showMessageDialog(null, "Bienvenido "+nombre+"\n"
                + "Has ingresado satisfactoriamente al Sistema para el Control "
                        + "de Entrada y Salida SENA (S.C.E.S.S.) ",   "Mensaje de Ingreso",
                JOptionPane.INFORMATION_MESSAGE);
                registrador formulario2 = new registrador();
                formulario2.setVisible(true);
                File ruta = new File(System.getenv("APPDATA")+"/SCESS/Images");
                String r=ruta+"/"+txtid.getText()+".png";
                formulario2.actfoto(r);
            }else if (rol.equals("ADMINISTRADOR")){
                this.dispose();
                JOptionPane.showMessageDialog(null, "Bienvenido "+nombre+"\n"
                + "Has ingresado satisfactoriamente al Sistema para el Control "
                        + "de Entrada y Salida SENA (S.C.E.S.S.) ",   "Mensaje de Ingreso",
                JOptionPane.INFORMATION_MESSAGE);
                admin formformulario1 = new admin();
                formformulario1.setVisible(true);
                File ruta = new File(System.getenv("APPDATA")+"/SCESS/Images");
                String r=ruta+"/"+txtid.getText()+".png";
                formformulario1.actfoto(r);
            }else if (rol.equals("OPERADOR")){
                this.dispose();
                JOptionPane.showMessageDialog(null, "Bienvenido "+nombre+"\n"
                + "Has ingresado satisfactoriamente al Sistema para el Control "
                        + "de Entrada y Salida SENA (S.C.E.S.S.) ",   "Mensaje de Ingreso",
                JOptionPane.INFORMATION_MESSAGE);
                operador formformulario = new operador();
                formformulario.setVisible(true);
                File ruta = new File(System.getenv("APPDATA")+"/SCESS/Images");
                String r=ruta+"/"+txtid.getText()+".png";
                formformulario.actfoto(r);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
            + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
            JOptionPane.ERROR_MESSAGE);
            adv5.setVisible(true);
            opor=opor+1;
            oportunidad();
            txtid.setText(null);
            txtpass.setText(null);
        }
    }
    
    public Image getIconImage(){
       Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logo3.png"));
       return retvalue;
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra = new javax.swing.JPanel();
        body = new javax.swing.JPanel();
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
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barra.setBackground(new java.awt.Color(89, 181, 72));
        barra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 340));

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        body.setLayout(new java.awt.CardLayout());

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

        body.add(login, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );

        body.add(jPanel1, "card3");

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 340));

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
        txtpass.setText("");
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
        txtpass.setText("");      
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
        int pr=0;
        
        try{
            //Linea para validar ingreso de datos de usuario
            pr = Integer.parseInt(txtid.getText());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "EL usuario no puede contener\n Caracteres Alfabeticos y/o Especiales");
        }
    }//GEN-LAST:event_txtidKeyTyped

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
                new loginf().setVisible(true);
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
    private javax.swing.JPanel body;
    private javax.swing.JLabel btnexit;
    private javax.swing.JLabel btnok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel login;
    private javax.swing.JPanel separador;
    private javax.swing.JPanel separador2;
    private javax.swing.JTextField txtid;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
