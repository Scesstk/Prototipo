/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistroPersona.Maven;
import static RegistroPersona.RegistroPersona.actfoto;
import static RegistroPersona.RegistroPersona.txtDocumento;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


/**
 *
 * @author FGALLARDO
 */
public class jFrameCamera extends javax.swing.JInternalFrame {
    
    private Executor executor = Executors.newSingleThreadExecutor();
    private AtomicBoolean initialized = new AtomicBoolean(false);
    private Webcam webcam = null;
    private WebcamPanel panel = null;
    /**
     * Creates new form jFrameCamera
     */
    
    
    public jFrameCamera() {
        initComponents();
        
        //Se crea un objeto de la clase webcam
        webcam = Webcam.getDefault();
        webcam.setViewSize(webcam.getViewSizes()[0]);
        //Se crea el panel que contendrá la imagen
        panel = new WebcamPanel(webcam, false);
        panel.setPreferredSize(webcam.getViewSize());
        panel.setOpaque(true);
        panel.setBackground(Color.BLACK);
        //Se establece el tamaño y ubicación del panel de video
        panel.setBounds(0, 0, 400, 300);
        //Se agrega el panel que contiene la imagen animada a un JPanel
        jPanelCamera.add(panel);
        if (initialized.compareAndSet(false, true)) {
            executor.execute(new Runnable() {

                @Override
                public void run() {
                    //Se inicia la webcam
                    panel.start();
                }
                
            });
        }
    }
    /**
    public void image(){
        Graphics g = null;
        ImageIcon img = new ImageIcon(getClass().getResource("C:/temp/"+txtDocumento.getText()+".png"));
        g.drawImage(img.getImage(),0,0,getWidth(),getHeight(),this);
    }
**/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCamera = new javax.swing.JPanel();
        jbtnCaptura = new javax.swing.JButton();

        setTitle("Fotografía");
        setVisible(false);

        javax.swing.GroupLayout jPanelCameraLayout = new javax.swing.GroupLayout(jPanelCamera);
        jPanelCamera.setLayout(jPanelCameraLayout);
        jPanelCameraLayout.setHorizontalGroup(
            jPanelCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelCameraLayout.setVerticalGroup(
            jPanelCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        jbtnCaptura.setText("Capturar Imagen");
        jbtnCaptura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCapturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jbtnCaptura)
                .addContainerGap(150, Short.MAX_VALUE))
            .addComponent(jPanelCamera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnCaptura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCapturaActionPerformed
        try {
            BufferedImage image = webcam.getImage();
            
            if(txtDocumento.getText().equals("")){
                JOptionPane.showMessageDialog(null, "El campo Documento no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                //nombre y formato de la imagen de salida
                File ruta = new File(System.getenv("APPDATA")+"/SCESS/Images/");
                //ruta.mkdir();
                ImageIO.write(image, "PNG", new File(ruta+txtDocumento.getText()+".png"));
                //cerrar camara
                webcam.close();
                //actualiza foto
                
                String r=ruta+txtDocumento.getText()+".png";
                actfoto(r);
                //cierra ventana
                dispose();
            }
        } catch (IOException ex) {
            Logger.getLogger(jFrameCamera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnCapturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelCamera;
    private javax.swing.JButton jbtnCaptura;
    // End of variables declaration//GEN-END:variables

    
}
