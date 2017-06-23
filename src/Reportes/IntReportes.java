
package Reportes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class IntReportes extends javax.swing.JInternalFrame {
    
java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat ("yyyy-MM-dd");
String fechad;
String fechah;
int tipoEntrada = 0;
int tipoSalida = 0;


private String consulta,prueba;

    public IntReportes() {
        initComponents();
        initComponents();
        campoDocumento.setEnabled(false);
        campoFicha.setEnabled(false);
        campoSerie.setEnabled(false);
        //fechaDesde.setEnabled(false);
      
     }
       
        private void HabilitarCampo(){        
        if (radioDocumento.isSelected()){
                campoDocumento.setEnabled(true);
                campoFicha.setEnabled(false);
                campoFicha.setText(null);
                campoSerie.setEnabled(false);
                campoSerie.setText(null);
            
        }else if(radioFicha.isSelected()){
                campoDocumento.setEnabled(false);
                campoDocumento.setText(null);
                campoFicha.setEnabled(true);
                campoSerie.setEnabled(false);
                campoSerie.setText(null);
        }else if(radioSerie.isSelected()){
                campoDocumento.setEnabled(false);
                campoDocumento.setText(null);
                campoFicha.setEnabled(false);
                campoFicha.setText(null);
                campoSerie.setEnabled(true);
        }
    }
  
    private boolean ValidarCaracteres(String cadena){
        int num;
        try {
            num = (Integer.parseInt(cadena));
            return true;
        }catch  (Exception e){
            return false;
        }   
    }
        
   
    public void validarCampos(){
        
        consulta = "select PERnumDoc from persona where PERnumDoc = '"+campoDocumento.getText()+"';";
        
        boolean v = ValidarCaracteres(campoDocumento.getText());
        if (v == false && radioDocumento.getModel()== grupoRadio.getSelection() ){
            JOptionPane.showMessageDialog(null,"Error solo se permiten valores numericos");
        //VALIDA SI SE HA SELECCIONADO EL RADIO DOCUMENTO
        }else if(radioDocumento.getModel()== grupoRadio.getSelection()&& fechaDesde.getDate() == null && fechaHasta.getDate() == null) { 
            try {
                Consultas consul = new Consultas(new Conexion().getConexion(),consulta);
                ResultSet rs = consul.getResultado();
                if(rs.next()){//recorre el resultset al siguiente registro si es que existen
                    rs.beforeFirst();//regresa el puntero al primer registro
                   new reporte_equipo().reporteDocumento(campoDocumento.getText());
                   
                //   new reporte_ficha().reporteFicha(Integer.parseInt(campoFicha.getText()));
                }else{
                    JOptionPane.showMessageDialog(null,"El numero de documento no existe en la base de datos");
                }
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
   
     //VALIDAR QUE LOS CAMOPOS FECHAS NO SEAN NULOS NI MENOR A LA INICIAL
     
        if (fechaDesde.getDate() != null && fechaHasta.getDate() == null){
               JOptionPane.showMessageDialog(null,"Faltan datos en la fecha incial"); 
               
        }else if(fechaDesde.getDate() == null && fechaHasta.getDate() != null){
               JOptionPane.showMessageDialog(null,"Faltan datos en la fecha final");  
        }else{
           if(fechaDesde.getDate().getTime()>fechaHasta.getDate().getTime()){
                JOptionPane.showMessageDialog(null, "La fecha inicial debe ser menor a la final");
                
             //CONDICION PARA VALIDAR SI TODOS LOS RADIOS NO ESTAB SELECCIONADOS Y RELAIZAR EL REPORTE POR FECHA    
            }else if (null == grupoRadio.getSelection()){ 
 
                //GENERA EL REPORTE DEPENDIENDO DEL CHECKBOX SELECCIONADO
                if( CheckBoxEntrada.isSelected()&& CheckBoxSalida.isSelected()){
                     tipoEntrada = 1;
                     tipoSalida = 2;
                    new reporte_fecha().reporte(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida);
                     JOptionPane.showMessageDialog(null, "Entrada y salida"+tipoEntrada+""+tipoSalida);
  
                     
                }else if(CheckBoxSalida.isSelected()){
                    tipoEntrada = 0;
                     tipoSalida = 2;
                     new reporte_fecha().reporte(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida);
                     JOptionPane.showMessageDialog(null,"salida selecionada");
            
                }else if (CheckBoxEntrada.isSelected()){
                    
                    tipoEntrada = 1;
                    tipoSalida = 0;
                     new reporte_fecha().reporte(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida);
                     JOptionPane.showMessageDialog(null,"entrada selecionada");
                 }else{
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de ingreso (ENTRADA O SALIDA)");
                }
                // CONDICION PARA VALIDAR QUE HEMOS SELECCIONADO EL RADIO DOCUMENTO Y GENERAR EL REPORTE POR FECHA Y DOCUMENTO 
            }else{              
             
                
                
                
            try {
                Consultas consul = new Consultas(new Conexion().getConexion(),consulta);
                ResultSet rs = consul.getResultado();
                if(rs.next()){//recorre el resultset al siguiente registro si es que existen
                    rs.beforeFirst();//regresa el puntero al primer registro
                   
                    if(radioDocumento.getModel()== grupoRadio.getSelection() && CheckBoxEntrada.isSelected()&& CheckBoxSalida.isSelected()){
                     tipoEntrada = 1;
                     tipoSalida = 2;
                    new reporte_docfecha().reporteDocFecha(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida,campoDocumento.getText());
                     JOptionPane.showMessageDialog(null, "Entrada y salida"+tipoEntrada+""+tipoSalida);
  
                     
                    }else if(radioDocumento.getModel()== grupoRadio.getSelection() && CheckBoxSalida.isSelected()){
                        tipoEntrada = 0;
                         tipoSalida = 2;
                         new reporte_docfecha().reporteDocFecha(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida ,campoDocumento.getText());
                         //JOptionPane.showMessageDialog(null,"salida selecionada");

                    }else if (radioDocumento.getModel()== grupoRadio.getSelection() && CheckBoxEntrada.isSelected()){

                        tipoEntrada = 1;
                        tipoSalida = 0;
                         new reporte_docfecha().reporteDocFecha(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida,campoDocumento.getText());
                         //JOptionPane.showMessageDialog(null,"entrada selecionada");
                     }else{
                        JOptionPane.showMessageDialog(null, "Debe seleccionar (ENTRADA O SALIDA) ");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"El documento no se encuentra en la base de datos");
                }
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
    }
}
    
    
    public void validarFicha (){
         
        consulta = "select Num_ficha from ficha where Num_ficha = '"+campoFicha.getText()+"' ;";
        
        boolean v = ValidarCaracteres(campoFicha.getText());
       
        if (v == false && radioFicha.getModel()== grupoRadio.getSelection() ){
            JOptionPane.showMessageDialog(null,"Error solo se permiten valores numericos");
        //VALIDA SI SE HA SELECCIONADO EL RADIO DOCUMENTO
        }else if(radioFicha.getModel()== grupoRadio.getSelection()&& (fechaDesde.getDate() == null && fechaHasta.getDate() == null)) { 
            try {
                Consultas consul = new Consultas(new Conexion().getConexion(),consulta);
                ResultSet rs = consul.getResultado();
                if(rs.next()){//recorre el resultset al siguiente registro si es que existen
                    rs.beforeFirst();//regresa el puntero al primer registro
                    new reporte_ficha().reporteFicha(Integer.parseInt(campoFicha.getText()));
                                     
                }else{
                    JOptionPane.showMessageDialog(null,"El numero de documento no existe en la base de datos");
                    }
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
        
     
        



        //VALIDAR QUE LOS CAMOPOS FECHAS NO SEAN NULOS NI MENOR A LA INICIAL
     
        if (fechaDesde.getDate() != null && fechaHasta.getDate() == null){
               JOptionPane.showMessageDialog(null,"Faltan datos en el formulario 1"); 
        }else if(fechaDesde.getDate() == null && fechaHasta.getDate() != null){
               JOptionPane.showMessageDialog(null,"Faltan datos en el formulario 2");  
        }else if(fechaDesde.getDate().getTime()>fechaHasta.getDate().getTime()){
                JOptionPane.showMessageDialog(null, "La fecha inicial debe ser menor a la final");
        
             //CONDICION PARA VALIDAR SI TODOS LOS RADIOS NO ESTAB SELECCIONADOS Y RELAIZAR EL REPORTE POR FECHA    
        }else {
            if(radioFicha.getModel()== grupoRadio.getSelection() && CheckBoxEntrada.isSelected()&& CheckBoxSalida.isSelected()){
                     tipoEntrada = 1;
                     tipoSalida = 2;
                    new reporte_fichaFecha().reporteDocFecha(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida,Integer.parseInt(campoFicha.getText()));
                    JOptionPane.showMessageDialog(null, "Entrada y salida"+tipoEntrada+""+tipoSalida);
  
                     
                }else if(radioFicha.getModel()== grupoRadio.getSelection() && CheckBoxSalida.isSelected()){
                    tipoEntrada = 0;
                     tipoSalida = 2;
                    new reporte_fichaFecha().reporteDocFecha(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida,Integer.parseInt(campoFicha.getText()));
                     JOptionPane.showMessageDialog(null,"salida selecionada");
            
                }else if (radioFicha.getModel()== grupoRadio.getSelection() && CheckBoxEntrada.isSelected()){
                    
                    tipoEntrada = 1;
                    tipoSalida = 0;
                   new reporte_fichaFecha().reporteDocFecha(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida,Integer.parseInt(campoFicha.getText()));
                     JOptionPane.showMessageDialog(null,"entrada selecionada");
                 }else{
                    JOptionPane.showMessageDialog(null, "Debe seleccionar (ENTRADA O SALIDA) ");
                }
        
        }
        
        
   
    }
    
    
         @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadio = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        radioDocumento = new javax.swing.JRadioButton();
        radioSerie = new javax.swing.JRadioButton();
        radioFicha = new javax.swing.JRadioButton();
        campoDocumento = new javax.swing.JTextField();
        campoSerie = new javax.swing.JTextField();
        campoFicha = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        CheckBoxEntrada = new javax.swing.JCheckBox();
        CheckBoxSalida = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        pru = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Generar Reportes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reporte Detallado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        grupoRadio.add(radioDocumento);
        radioDocumento.setText("Documento usuario");
        radioDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDocumentoActionPerformed(evt);
            }
        });

        grupoRadio.add(radioSerie);
        radioSerie.setText("Serie equipo");
        radioSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSerieActionPerformed(evt);
            }
        });

        grupoRadio.add(radioFicha);
        radioFicha.setText("Ficha");
        radioFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFichaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioDocumento)
                    .addComponent(radioFicha)
                    .addComponent(radioSerie))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(campoFicha)
                    .addComponent(campoDocumento))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioDocumento)
                    .addComponent(campoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioSerie)
                    .addComponent(campoSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(campoFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioFicha)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reporte general", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        fechaHasta.setDateFormatString("yyyy-MM-dd");

        jLabel1.setText("Desde");

        jLabel2.setText("Hasta");

        fechaDesde.setDateFormatString("yyyy-MM-dd");

        CheckBoxEntrada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CheckBoxEntrada.setText("ENTRADA");
        CheckBoxEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxEntradaActionPerformed(evt);
            }
        });

        CheckBoxSalida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CheckBoxSalida.setText("SALIDA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(48, 48, 48)
                                .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(CheckBoxEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(CheckBoxSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fechaDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CheckBoxEntrada)
                    .addComponent(CheckBoxSalida))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Control de Reportes");

        jButton2.setText("Generar reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pru.setText("limpiar seleccion inferior");
        pru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruActionPerformed(evt);
            }
        });

        jButton1.setText("Limpiar seleccion superior");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(154, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pru, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2)
                                        .addGap(9, 9, 9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(pru, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDocumentoActionPerformed
        HabilitarCampo();
    }//GEN-LAST:event_radioDocumentoActionPerformed

    private void radioSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSerieActionPerformed
        HabilitarCampo();
    }//GEN-LAST:event_radioSerieActionPerformed

    private void radioFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFichaActionPerformed
        HabilitarCampo();
    }//GEN-LAST:event_radioFichaActionPerformed

    private void CheckBoxEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxEntradaActionPerformed

    }//GEN-LAST:event_CheckBoxEntradaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if (radioFicha.getModel()== grupoRadio.getSelection()){
            validarFicha();
           // validarFechas();
        }else{
            validarCampos();
        }
        
        
        

            /*JRPdfExporter  exporter = new JRPdfExporter();
           exporter.setParameter(JRExporterParameter.JASPER_PRINT,jp); 
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File("reportePDF.pdf"));
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(IntReportes.class.getName()).log(Level.SEVERE, null, ex);
        }*/
     
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruActionPerformed
       
        CheckBoxSalida.setSelected(false);
        CheckBoxEntrada.setSelected(false);
        fechaHasta.setDate(null);
        fechaDesde.setDate(null);
       
        
        
        
    }//GEN-LAST:event_pruActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        campoDocumento.setEnabled(false);
        campoDocumento.setText("");
        campoFicha.setEnabled(false);
        campoFicha.setText("");
        campoSerie.setEnabled(false);
        campoSerie.setText("");
        grupoRadio.clearSelection();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxEntrada;
    private javax.swing.JCheckBox CheckBoxSalida;
    private javax.swing.JTextField campoDocumento;
    private javax.swing.JTextField campoFicha;
    private javax.swing.JTextField campoSerie;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton pru;
    private javax.swing.JRadioButton radioDocumento;
    private javax.swing.JRadioButton radioFicha;
    private javax.swing.JRadioButton radioSerie;
    // End of variables declaration//GEN-END:variables
}
