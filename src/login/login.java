/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;



import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import prototipo.Principal;

import ConnectBD.*;
import java.awt.event.KeyEvent;


public class login extends javax.swing.JFrame {

    
    int opor=0;
    
    
    public login() {
        initComponents();
        adv();
        
        oportunidad();
    }
    public int cedula;
    public String pass,activo,rol,contra;
    public static String nombre="";
    public static int cc;

    private void acceso(){
        if(pass.equals(contra)){
            
            if(activo.equals("NO")){
                JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                + "Su USUARIO "+nombre+" no se encuentra ACTIVADO", "Acceso denegado",
                JOptionPane.ERROR_MESSAGE);
                txtid.setText(null);
                txtpass.setText(null);
            }else if(rol.equals("USUARIO")){
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
        if(opor==3){
            adv1.setVisible(true);
        }
        if(opor==5){
            adv2.setVisible(true);
            adv3.setVisible(true);
            adv4.setVisible(true);
            btnok.setEnabled(false);
        }
    }
    
    public void conMySQL(){
        nombre= "";
       
        Pconnection prueba = new Pconnection();

        prueba.setSelectInt(("SELECT Num_documento FROM persona WHERE Num_documento='"+cedula+"'"),
                "Num_documento");
        cc = prueba.getSelectInt();
        
        prueba.setSelectStr(("SELECT Contrasena FROM acceso as a "
                        + "JOIN persona as p on a.Id_persona=p.Id_persona WHERE Num_documento = '"+cedula+"'"),
                "Contrasena");
        contra = prueba.getSelectStr();
        prueba.setSelectStr(("SELECT Activo FROM acceso as a "
                        + "JOIN persona as p on a.Id_persona=p.Id_persona WHERE Num_documento = '"+cedula+"'"),
                "Activo");
        activo = prueba.getSelectStr();
        
        prueba.setSelectMd5(pass, pass);
        pass = prueba.getMd5();
        
        
        prueba.setSelectStr(("SELECT concat(Nombre_1,' ',Nombre_2,' ',Apellido_1,' ',Apellido_2) as Nombre FROM persona WHERE Num_documento='"+cedula+"'"),
                "Nombre");
        nombre = prueba.getSelectStr();
        
        
        prueba.setSelectStr(("SELECT Descripcion_rol FROM rol as r "
                        + "JOIN persona as p on r.Id_rol=p.Id_rol WHERE Num_documento = '"+cedula+"'"), 
                "Descripcion_rol");
        rol = prueba.getSelectStr();

        prueba.cerrarConexion();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon Icon= new ImageIcon(getClass().getResource("/Imagenes/fondoscess.png"));
        Image image = Icon.getImage();
        Fondo = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        btnok = new javax.swing.JButton();
        adv1 = new javax.swing.JLabel();
        adv2 = new javax.swing.JLabel();
        adv3 = new javax.swing.JLabel();
        adv4 = new javax.swing.JLabel();
        adv5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCESS");
        setExtendedState(6);

        Fondo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1018, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(89, 181, 72));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("S.C.E.S.S.");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("* Por Favor Digite su usuario y Contraseña");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario:");

        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidKeyTyped(evt);
            }
        });

        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });

        btnok.setText("Iniciar");
        btnok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnokActionPerformed(evt);
            }
        });
        btnok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnokKeyPressed(evt);
            }
        });

        adv1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        adv1.setForeground(new java.awt.Color(255, 0, 0));
        adv1.setText("* Ha introducido su contraseña mal 3 veces. ");

        adv2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        adv2.setForeground(new java.awt.Color(255, 0, 0));
        adv2.setText("* Ha introducido su contraseña mal 5 veces. ");

        adv3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        adv3.setForeground(new java.awt.Color(255, 0, 0));
        adv3.setText("Su Usuario ha sido !BLOQUEADO!");

        adv4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        adv4.setForeground(new java.awt.Color(255, 0, 0));
        adv4.setText("Comuniquese con el Administrador");

        adv5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        adv5.setForeground(new java.awt.Color(255, 0, 0));
        adv5.setText("* Su Usuario o Contraseña son Incorrectos. ");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adv5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnok, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtid, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adv1)
                            .addComponent(adv2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adv4)
                                    .addComponent(adv3))))))
                .addGap(0, 31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(85, 85, 85))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(adv5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)))
                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(adv1)
                .addGap(18, 18, 18)
                .addComponent(adv2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adv3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adv4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 811, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnokActionPerformed
        contrasena();
        conMySQL();
        acceso();
           
    }//GEN-LAST:event_btnokActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyTyped
        char car = evt.getKeyChar();
        if (Character.isLetter(car)){
            evt.consume();
            getToolkit().beep();
        }
        if (Character.isSpaceChar(car)){
            evt.consume();
        }
        if (Character.isAlphabetic(SOMEBITS)){
            evt.consume();
        }
    }//GEN-LAST:event_txtidKeyTyped

    private void btnokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnokKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            contrasena();
            conMySQL();
            acceso();
        }
    }//GEN-LAST:event_btnokKeyPressed

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            contrasena();
            conMySQL();
            acceso();
        }
    }//GEN-LAST:event_txtpassKeyPressed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel adv1;
    private javax.swing.JLabel adv2;
    private javax.swing.JLabel adv3;
    private javax.swing.JLabel adv4;
    private javax.swing.JLabel adv5;
    private javax.swing.JButton btnok;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtid;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
