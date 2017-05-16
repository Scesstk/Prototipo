
package login;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import prototipo.Principal;
import ConnectBD.*;
import java.awt.event.KeyEvent;



public class loginf extends javax.swing.JFrame {

    
    public loginf() {
        initComponents();
        this.setLocationRelativeTo(null);
        adv();
        oportunidad();
    }
    public int prueba, cedula, opor=0;
    public String pass,activo,rol,contra;
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
            
            if(rol.equals("USUARIO")){
                this.dispose();
                JOptionPane.showMessageDialog(null, "Bienvenido "+nombre+"\n"
                + "Has ingresado satisfactoriamente al Sistema para el Control "
                        + "de Entrada y Salida SENA (S.C.E.S.S.) ",   "Mensaje de Ingreso",
                JOptionPane.INFORMATION_MESSAGE);
                Principal formulario2 = new Principal();
               
                formulario2.setVisible(true);
                formulario2.bloqueo();
            }else if (rol.equals("ADMINISTRADOR")){
                this.dispose();
                JOptionPane.showMessageDialog(null, "Bienvenido "+nombre+"\n"
                + "Has ingresado satisfactoriamente al Sistema para el Control "
                        + "de Entrada y Salida SENA (S.C.E.S.S.) ",   "Mensaje de Ingreso",
                JOptionPane.INFORMATION_MESSAGE);
                Principal formformulario1 = new Principal();
                formformulario1.setVisible(true);
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
    
    
    
    
   /* public Image getIconImage(){
       Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logo3.png"));
       return retvalue;
   }*/
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        btnok = new javax.swing.JLabel();
        adv1 = new javax.swing.JLabel();
        adv2 = new javax.swing.JLabel();
        adv3 = new javax.swing.JLabel();
        adv4 = new javax.swing.JLabel();
        adv5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));

        jPanel2.setBackground(new java.awt.Color(89, 181, 72));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(89, 181, 72));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Salir");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(89, 181, 72));
        jLabel1.setText("S.C.E.S.S");

        jSeparator1.setBackground(new java.awt.Color(252, 115, 35));
        jSeparator1.setForeground(new java.awt.Color(252, 115, 35));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 115, 35));
        jLabel2.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(252, 115, 35));
        jLabel3.setText("Contraseña");

        txtid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtid.setForeground(new java.awt.Color(153, 153, 153));
        txtid.setText("Ingrese usuario");
        txtid.setBorder(null);
        txtid.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtidMouseClicked(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(89, 181, 72));
        jLabel4.setText("Bienvenido a");

        txtpass.setForeground(new java.awt.Color(153, 153, 153));
        txtpass.setText("0000000");
        txtpass.setBorder(null);
        txtpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpassMouseClicked(evt);
            }
        });
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(252, 115, 35));
        jSeparator2.setForeground(new java.awt.Color(252, 115, 35));

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
        btnok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnokKeyPressed(evt);
            }
        });

        adv1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        adv1.setForeground(new java.awt.Color(35, 130, 118));
        adv1.setText("*Te quedan 4 Intentos");

        adv2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        adv2.setForeground(new java.awt.Color(35, 130, 118));
        adv2.setText("*Te quedan 3 Intentos");

        adv3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        adv3.setForeground(new java.awt.Color(35, 130, 118));
        adv3.setText("*Te quedan 2 Intentos");

        adv4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        adv4.setForeground(new java.awt.Color(35, 130, 118));
        adv4.setText("*Te quedan 1 Intentos");

        adv5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        adv5.setForeground(new java.awt.Color(35, 130, 118));
        adv5.setText("comunicate con un admistrador");
        adv5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adv1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adv2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adv3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adv4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnok)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(txtpass)))
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                    .addComponent(adv5))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adv1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adv2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adv3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adv4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adv5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(btnok))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txtidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtidMouseClicked
        txtid.setText("");
    }//GEN-LAST:event_txtidMouseClicked

    private void btnokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnokMouseClicked
        //Ejecutamos el metodo accede
        accede();
    }//GEN-LAST:event_btnokMouseClicked

    private void txtpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpassMouseClicked
        txtpass.setText("");
    }//GEN-LAST:event_txtpassMouseClicked

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //Ejecutamos el metodo accede
            accede();        
        }
        
    }//GEN-LAST:event_txtpassKeyPressed

    private void btnokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnokKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //Ejecutamos el metodo accede
            accede();        
        }
    }//GEN-LAST:event_btnokKeyPressed

    private void txtidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_DELETE){
            txtid.setText("");
            txtpass.setText("");            
        }
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //Ejecutamos el metodo accede
            accede();        
        }
    }//GEN-LAST:event_txtidKeyPressed

    private void txtidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyTyped
        // TODO add your handling code here:
        
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
                if ("Nimbus".equals(info.getName())) {
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
    private javax.swing.JLabel btnok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtid;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
