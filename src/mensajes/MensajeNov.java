/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajes;

import ConnectBD.Pconnection;
import RegistroE_S.operador;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author Axel
 */
public class MensajeNov extends javax.swing.JFrame {

    public static int idequi;

    Pconnection objc= new Pconnection();
    
    public int x=0,y=0;
    public static int Enidp;
    public static int tipES;
    
    private void Jpaint(){
        UIManager.put("OptionPane.background", new ColorUIResource(89,200,72));
        UIManager.put("Button.background", Color.orange);
        UIManager.put("Panel.background", new ColorUIResource(89,200,72));
    }
    Icon joke = new ImageIcon(getClass().getResource("/Imagenes/logo.jpg"));
    
    public MensajeNov()  throws IOException{
        initComponents();
        lue.setVisible(false);
        lus.setVisible(false);
        this.setLocationRelativeTo(null);
    }
    
    operador medio=new operador();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barralateral = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        barra = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lus = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUE = new javax.swing.JTextField();
        txtUS = new javax.swing.JTextField();
        lue = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbnov = new javax.swing.JComboBox<>();
        btnok = new javax.swing.JLabel();
        btncancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barralateral.setBackground(new java.awt.Color(89, 181, 72));
        barralateral.setToolTipText("");
        barralateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(barralateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 220));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        header.add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 40));

        titulo.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(252, 115, 35));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("\"Novedad Registro Entrada/Salida\"");
        titulo.setToolTipText("");
        header.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 40));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, -1));

        body.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Fecha del Ultimo Registro de Entrada");

        lus.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lus.setForeground(new java.awt.Color(255, 0, 0));
        lus.setText("*No se encuentra un registro de salida");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Fecha del Ultimo Registro de Salida");

        txtUE.setEditable(false);
        txtUE.setBackground(new java.awt.Color(255, 255, 255));
        txtUE.setForeground(new java.awt.Color(255, 0, 0));
        txtUE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUE.setBorder(null);
        txtUE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUEActionPerformed(evt);
            }
        });

        txtUS.setEditable(false);
        txtUS.setBackground(new java.awt.Color(255, 255, 255));
        txtUS.setForeground(new java.awt.Color(255, 0, 0));
        txtUS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUS.setBorder(null);
        txtUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUSActionPerformed(evt);
            }
        });

        lue.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lue.setForeground(new java.awt.Color(255, 0, 0));
        lue.setText("*No se encuentra un registro de Entrada");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(252, 115, 35));
        jLabel4.setText("DESCRIPCION DE LA NOVEDAD:");

        cbnov.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cbnov.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Usuario No Registro Entrada/Salida", "SCESS No Operativo" }));
        cbnov.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        btnok.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btnok.setForeground(new java.awt.Color(89, 181, 72));
        btnok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnok.setText("OK");
        btnok.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btnok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnokMouseClicked(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(89, 181, 72));
        btncancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btncancelar.setText("CANCELAR");
        btncancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(lue)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(txtUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUS, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(bodyLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lus))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bodyLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(bodyLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnok, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cbnov, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(3, 3, 3)))
                        .addGap(55, 55, 55))))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lue, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lus, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cbnov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnok)
                    .addComponent(btncancelar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 530, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUEActionPerformed

    private void txtUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUSActionPerformed

    private void btnokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnokMouseClicked
        // TODO add your handling code here:
        if(cbnov.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione un descripcion de la novedad");
        }else{
            if(tipES==1){
                System.out.println(Enidp);
                objc.setInsert("INSERT INTO entsal(`ESidPerFK`, `ESidTiEnSaFK`,`ESnov`) VALUES ("+Enidp+",2,'"+cbnov.getSelectedItem()+"')");
                //objc.setInsert("INSERT INTO entsal(`ESidPerFK`, `ESidTiEnSaFK`) VALUES ("+Enidp+",1)");
            }else if(tipES==2){
                System.out.println(Enidp);
                objc.setInsert("INSERT INTO entsal(`ESidPerFK`, `ESidTiEnSaFK`,`ESnov`) VALUES ("+Enidp+",1,'"+cbnov.getSelectedItem()+"')");
                //objc.setInsert("INSERT INTO entsal(`ESidPerFK`, `ESidTiEnSaFK`) VALUES ("+Enidp+",2)");
                
            }
            dispose();
            operador formformulario = null;
            try {
                formformulario = new operador();
            } catch (IOException ex) {
                Logger.getLogger(MensajeNov.class.getName()).log(Level.SEVERE, null, ex);
            }
            formformulario.setVisible(true);
            formformulario.Reiniciar();
            Jpaint();
           String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Registro de Novedad Exitoso<br> Se ha registrado la Novedad para la fecha anterior<br> Por favor Genere el registro Actual </b> </body> </html>";
           JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
           
           
            
        }
       
    }//GEN-LAST:event_btnokMouseClicked

    private void btncancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarMouseClicked
        dispose();
        operador formformulario = null;
        try {
            formformulario = new operador();
        } catch (IOException ex) {
            Logger.getLogger(MensajeNov.class.getName()).log(Level.SEVERE, null, ex);
        }
            formformulario.setVisible(true);
            formformulario.Reiniciar();
    }//GEN-LAST:event_btncancelarMouseClicked

    private void barraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_barraMouseDragged

    private void barraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_barraMousePressed
    
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
            java.util.logging.Logger.getLogger(MensajeNov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MensajeNov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MensajeNov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MensajeNov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MensajeNov().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MensajeNov.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barra;
    private javax.swing.JPanel barralateral;
    private javax.swing.JPanel body;
    private javax.swing.JLabel btncancelar;
    private javax.swing.JLabel btnok;
    private javax.swing.JComboBox<String> cbnov;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel lue;
    public static javax.swing.JLabel lus;
    private javax.swing.JLabel titulo;
    public static javax.swing.JTextField txtUE;
    public static javax.swing.JTextField txtUS;
    // End of variables declaration//GEN-END:variables

    
}
