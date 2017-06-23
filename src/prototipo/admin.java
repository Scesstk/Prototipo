
package prototipo;

import ConnectBD.Pconnection;
import Reportes.reporte_equipo;
import RegistroPersona.Maven.Camara;
import Reportes.Conexion;
import Reportes.Consultas;
import Reportes.IntReportes;
import Reportes.reporte_docfecha;
import Reportes.reporte_fecha;
import Reportes.reporte_ficha;
import Reportes.reporte_fichaFecha;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import login.loginf;

public class admin extends javax.swing.JFrame {
    
//Variables de reportes 
java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat ("yyyy-MM-dd");
String fechad;
String fechah;
int tipoEntrada = 0;
int tipoSalida = 0;


private String consulta;

    public class NombreBD extends Thread{
        
        public void run(){
            while (true){
                lblnombre.setText(login.loginf.nombre);
                lblrol.setText(login.loginf.rol);
                Thread.interrupted();
            }
        }
   }
    
ConnectBD.Pconnection con= new ConnectBD.Pconnection();
    public admin() {
        initComponents();
        
        NombreBD nmb = new NombreBD();
        nmb.start();
        
        resetBoton();
        setLblColor(btnhome);
        
        //switch bettween Jpanels
        oculta();
        hhome.setVisible(true);
        bhome.setVisible(true);
        body.setVisible(true);
        head.setVisible(true);
        
        this.setLocationRelativeTo(null);
        Border border = LineBorder.createGrayLineBorder();
        
        
        
       //item de centrobox
        cbxCentro.addItem("Seleccione");
        cbxCentro.addItem("CEAI");
        cbxCentro.addItem("ASTIN");
        cbxCentro.select(0);
        
        //item de estadobox
        estadobox.addItem("Seleccione");
        estadobox.addItem("Activo");
        estadobox.addItem("Inactivo");
        estadobox.select(0);
        
        //item de rhbox
        cbxRh.addItem("Seleccione");
        cbxRh.addItem("A+");
        cbxRh.addItem("B+");
        cbxRh.addItem("AB+");
        cbxRh.addItem("O+");
        cbxRh.addItem("A-");
        cbxRh.addItem("B-");
        cbxRh.addItem("AB-");
        cbxRh.addItem("O-");
        cbxRh.select(0);
        
        //item de tipodocumentobox
        cbxTipoDoc.add("Seleccione");
        cbxTipoDoc.add("CC");
        cbxTipoDoc.add("CE");
        cbxTipoDoc.add("RC");
        cbxTipoDoc.add("TI");
        cbxTipoDoc.select(0);
        //item de rolbox
        cbxRol.addItem("Seleccione");
        cbxRol.addItem("ADMINISTRADOR");
        cbxRol.addItem("OPERADOR");
        cbxRol.addItem("REGISTRADOR");
        cbxRol.addItem("NINGUNO");
        cbxRol.select(0);
        
        //item de fichabox
        cbxFicha.addItem("Seleccione");
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
        cbxGenero.addItem("FEMENINO");
        cbxGenero.addItem("MASCULINO");                        
        cbxGenero.select(0);
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
    
    public static void actfoto(String rt){
        ImageIcon foto = new ImageIcon(rt);
        ImageIcon ico = new ImageIcon(foto.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(ico);
                       
    }
    
    public static void fotoPer(String rt){
        ImageIcon foto = new ImageIcon(rt);
        ImageIcon ico = new ImageIcon(foto.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_DEFAULT));
        imagen1.setIcon(ico);
                       
    }
    
   public int x=0,y=0;
    public String id_documento, nombre_1, ape_1, id_ficha, hrtxt, hrbusquedasrt,codequipo,serial,modelo,desc;;
    public int hrid,idequipos,pers_equipos,equip_equipos,tipo,marca;
    public String hrbusq = "";
    private int cedula,cedulaequipos;
    File ruta2 = new File("//192.168.1.17/fotos");
    File ruta = new File("http://192.168.1.17/api/fotos");
    DefaultTableModel modeloe;

    
    private void Jpaint(){
        UIManager.put("OptionPane.background", new ColorUIResource(89,200,72));
        UIManager.put("Button.background", Color.orange);
        UIManager.put("Panel.background", new ColorUIResource(89,200,72));
    }
    
    
    ///******************************************** INICIO DE REPORTES ***************************************************///
    
    //Habilotar radios del modulo reportes
    private void HabilitarCampo(){        
        if (radioDocumento.isSelected()){
                campoDocumento.setEnabled(true);
                campoFicha.setEnabled(false);
                campoFicha.setText(null);
                          
        }else if(radioFicha.isSelected()){
                campoDocumento.setEnabled(false);
                campoDocumento.setText(null);
                campoFicha.setEnabled(true);
             }
    }
    
    
    //Validar numeros en el campo documento de reportes
     private boolean ValidarCaracteres(String cadena){
        int num;
        try {
            num = (Integer.parseInt(cadena));
            return true;
        }catch  (Exception e){
            return false;
        }   
    }
    
     //Valida campos y realiza los reportes por documento
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
                }else{
                    JOptionPane.showMessageDialog(null,"El numero de documento no existe en la base de datos");
                }
            }catch (SQLException ex) {
                ex.getMessage();
            }
        }
   
     //VALIDAR QUE LOS CAMOPOS FECHAS NO SEAN NULOS NI MENOR A LA FECHA INICIAL
     
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
                    // JOptionPane.showMessageDialog(null, "Entrada y salida"+tipoEntrada+""+tipoSalida);
  
                     
                }else if(CheckBoxSalida.isSelected()){
                    tipoEntrada = 0;
                     tipoSalida = 2;
                     new reporte_fecha().reporte(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida);
                     //JOptionPane.showMessageDialog(null,"salida selecionada");
            
                }else if (CheckBoxEntrada.isSelected()){
                    
                    tipoEntrada = 1;
                    tipoSalida = 0;
                     new reporte_fecha().reporte(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida);
                    // JOptionPane.showMessageDialog(null,"entrada selecionada");
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
                    // JOptionPane.showMessageDialog(null, "Entrada y salida"+tipoEntrada+""+tipoSalida);
  
                     
                    }else if(radioDocumento.getModel()== grupoRadio.getSelection() && CheckBoxSalida.isSelected()){
                        tipoEntrada = 0;
                         tipoSalida = 2;
                         new reporte_docfecha().reporteDocFecha(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida ,campoDocumento.getText());
                        
                    }else if (radioDocumento.getModel()== grupoRadio.getSelection() && CheckBoxEntrada.isSelected()){

                        tipoEntrada = 1;
                        tipoSalida = 0;
                         new reporte_docfecha().reporteDocFecha(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida,campoDocumento.getText());
                         
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
     //Valida campos y genera el reporte por ficha
     
     public void validarFicha (){
         
        consulta = "select FICnumFic from ficha where FICnumFic = '"+campoFicha.getText()+"' ;";
        
        boolean v = ValidarCaracteres(campoFicha.getText());
        
       //Valida si el dato ingresado es numerico
        if (v == false && radioFicha.getModel()== grupoRadio.getSelection() ){
            JOptionPane.showMessageDialog(null,"Error solo se permiten valores numericos");
            
        //VALIDA SI SE HA SELECCIONADO EL RADIO DOCUMENTO
        }else if(radioFicha.getModel()== grupoRadio.getSelection()&& (fechaDesde.getDate() == null && fechaHasta.getDate() == null)) { 
            try {//Entrega el dato para generar el reporte
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
        
     
        



        //VALIDAR QUE LOS CAMPOS FECHAS NO SEAN NULOS NI MENOR A LA FECHA INICIAL
     
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
                    //JOptionPane.showMessageDialog(null, "Entrada y salida"+tipoEntrada+""+tipoSalida);
  
                     
                }else if(radioFicha.getModel()== grupoRadio.getSelection() && CheckBoxSalida.isSelected()){
                    tipoEntrada = 0;
                     tipoSalida = 2;
                    new reporte_fichaFecha().reporteDocFecha(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida,Integer.parseInt(campoFicha.getText()));
                    // JOptionPane.showMessageDialog(null,"salida selecionada");
            
                }else if (radioFicha.getModel()== grupoRadio.getSelection() && CheckBoxEntrada.isSelected()){
                    
                    tipoEntrada = 1;
                    tipoSalida = 0;
                   new reporte_fichaFecha().reporteDocFecha(fechaDesde.getDate(),fechaHasta.getDate(),tipoEntrada,tipoSalida,Integer.parseInt(campoFicha.getText()));
                    // JOptionPane.showMessageDialog(null,"entrada selecionada");
                 }else{
                    JOptionPane.showMessageDialog(null, "Debe seleccionar (ENTRADA O SALIDA) ");
                }
        
        }
        
        
   
    }
    
    ///******************************************************* AQUI TERMINA REPORTES ****************************************************///
     
     
     

    Icon joke = new ImageIcon(getClass().getResource("/Imagenes/logo.jpg"));
    
    public Image getIconImage(){
       Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logo3.png"));
       return retvalue;
    }
    
    public void obtener(){
        
        hrbusquedasrt = txtconsulta.getText();
        hrbusq = txtconsulta.getText();
    }
    
    public void oculta(){
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
        JpCamCon.setVisible(false);
        body7.setVisible(false);
    }
    
    public void resetBoton(){
        resetLblColor(btnhome);
        resetLblColor(btnpersonas);
        resetLblColor(btnreportes);
        resetLblColor(btnregistros);
    }
    
    public void CargarTablaUsuarios(){        
 
    
        try{
            obtener();
        
   
          String hrtipo_documento, hrnum_documento, hrnombre_1, hrape_1, hrrol, hrape_2, hrnombre_2; 
            Statement buscar = con.getConexion().createStatement();
                

                
                con.setSelectStr("SELECT PERidPerPK FROM persona WHERE PERnom1 like '%"+hrbusquedasrt+"%' or  PERape1 like '%"+hrbusquedasrt+"%' or PERnumDoc like '%"+hrbusq+"%' ","PERidPerPK");
                hrtxt = con.getSelectStr();
                hrid = Integer.parseInt(hrtxt);
                
                
                ResultSet mostrar=buscar.executeQuery("select DOCdesTipDoc, PERnumDoc, PERnom1, PERnom2, PERape1, PERape2, ROLdesRol "
                    + "from persona per "
                    + "inner join rol ro on per.PERidRolFK =ro.ROLidRolPK "
                    + "inner join documento doc on per.PERidDocFK = doc.DOCidDocPK "
                    + "where PERnom1 like'%"+hrbusquedasrt+"%'or PERape1 like '%"+hrbusquedasrt+"%' or PERidPerPK like '%"+hrid+"%';");
                
                String[] titulos = {"Identificación","Numero de documento","Nombres","Apellidos","Rol","Editar"};
        DefaultTableModel modeloe=new DefaultTableModel();
        modeloe.setColumnIdentifiers(titulos);

        while(mostrar.next()){
            hrtipo_documento=mostrar.getString("DOCdesTipDoc");
                   hrnum_documento=mostrar.getString("PERnumDoc");
                   hrnombre_1=mostrar.getString("PERnom1");
                   hrnombre_2=mostrar.getString("PERnom2");
                   hrape_1=mostrar.getString("PERape1");
                   hrape_2=mostrar.getString("PERape2");
                   hrrol=mostrar.getString("ROLdesRol");
                
                   
                   modeloe.addRow(new Object[]{hrtipo_documento,hrnum_documento,hrnombre_1+" "+hrnombre_2,hrape_1+" "+hrape_2,hrrol});
                   int variable = tabla.getSelectedRow();
                   tabla.setModel(modeloe);  
                   
        }
       
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error de MySql");
            }catch(Exception err){
                
        }
   
    }  
    
    public void CargarTablaMisEquipos(){        
        try{
           obtenerdatosequipos();
           
   
          String codigo,tipo,marca,modelo,serial,descripcion; 
            Statement buscar = con.getConexion().createStatement();
                
                
                      con.setSelectInt("SELECT PERidPerPK FROM persona WHERE PERnumDoc = '"+cedulaequipos+"'", "PERidPerPK");
              
                   idequipos=con.getSelectInt();
              
  
            ResultSet mostrar=buscar.executeQuery("select EQUidEquPK,TEclaEqu,MEdeMaEq,EQUmod,EQUser,EQUdes\n" +
                "from equipos\n" +
                "inner join tipequ on EQUidTipFK=TEidTiEqPK\n" +
                "inner join marequ on EQUidMarFK=MEidMaEqPK\n" +
                "inner join perequ on EQUidEquPK=PEidEquFK \n" +
                "where PEidPerFK='"+idequipos+"' order by EQUidEquPK;");
                
                
                String[] titulos = {"Código","Tipo","Marca","Modelo","Serial","Descripcion"};
                DefaultTableModel modeloe=new DefaultTableModel();
                modeloe.setColumnIdentifiers(titulos);
                //modeloe= new DefaultTableModel(titulos);

            while(mostrar.next()){
                       codigo=mostrar.getString("EQUidEquPK");
                       tipo=mostrar.getString("TEclaEqu");
                       marca=mostrar.getString("MEdeMaEq");
                       modelo=mostrar.getString("EQUmod");
                       serial=mostrar.getString("EQUser");
                       descripcion=mostrar.getString("EQUdes");
                       modeloe.addRow(new Object[]{codigo,tipo,marca,modelo,serial,descripcion});
            }
       
            tblListaEquipos.setModel(modeloe);

             }catch(SQLException ex){
                     JOptionPane.showMessageDialog(null,"Error de MySql");
                 }catch(Exception err){
                     JOptionPane.showMessageDialog(null,"Se ha encontrado un error inesperado: "+err.getMessage());
             }
    }
    
    public void obtenerdatosequipos(){
     
        cedulaequipos = Integer.parseInt(equipostxtconsulta.getText());
      
        tipo = equipostipobox.getSelectedIndex();
     
      
        marca = equiposmarcabox.getSelectedIndex();
     
        serial = equipostxtserial.getText();
        modelo = equipostxtmodelo.getText();
        desc = equipostxtdesc.getText();
 
    }
    //variables cambio de contraseña
    private int prueba, cedul, id;
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
        id = con.getSelectInt();
        
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

        Opciones = new javax.swing.JPopupMenu();
        Modificarequipos = new javax.swing.JMenuItem();
        Desactivarequipos = new javax.swing.JMenuItem();
        grupoRadio = new javax.swing.ButtonGroup();
        hrpopmenu = new javax.swing.JPopupMenu();
        hrinfo = new javax.swing.JMenuItem();
        barralateral = new javax.swing.JPanel();
        btnpersonas = new javax.swing.JLabel();
        btnreportes = new javax.swing.JLabel();
        btnhome = new javax.swing.JLabel();
        btnregistros = new javax.swing.JLabel();
        btnlogout1 = new javax.swing.JLabel();
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
        hbuscar = new javax.swing.JPanel();
        iconbuscar = new javax.swing.JLabel();
        separador = new javax.swing.JPanel();
        txtconsulta = new javax.swing.JTextField();
        nuevoregistro2 = new javax.swing.JLabel();
        cambiarpass = new javax.swing.JLabel();
        hequipo = new javax.swing.JPanel();
        iconbuscar1 = new javax.swing.JLabel();
        separador18 = new javax.swing.JPanel();
        equipostxtconsulta = new javax.swing.JTextField();
        etiqueta28 = new javax.swing.JLabel();
        equipostipobox = new javax.swing.JComboBox<>();
        etiqueta30 = new javax.swing.JLabel();
        etiqueta31 = new javax.swing.JLabel();
        equiposmarcabox = new javax.swing.JComboBox<>();
        etiqueta32 = new javax.swing.JLabel();
        etiqueta33 = new javax.swing.JLabel();
        equipostxtserial = new javax.swing.JTextField();
        separador20 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        equipostxtdesc = new javax.swing.JTextArea();
        equipostxtmodelo = new javax.swing.JTextField();
        separador21 = new javax.swing.JPanel();
        btnguardarequipos = new javax.swing.JLabel();
        btncancelarequipos = new javax.swing.JLabel();
        btnmodificarequipos = new javax.swing.JLabel();
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
        imagen1 = new javax.swing.JLabel();
        lblrol2 = new javax.swing.JLabel();
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
        body3 = new javax.swing.JPanel();
        btncentros = new javax.swing.JLabel();
        btnfichas = new javax.swing.JLabel();
        btnequipos = new javax.swing.JLabel();
        body4 = new javax.swing.JPanel();
        etiqueta17 = new javax.swing.JLabel();
        btnguardarficha = new javax.swing.JLabel();
        jtxtCod = new javax.swing.JTextField();
        separador10 = new javax.swing.JPanel();
        etiqueta18 = new javax.swing.JLabel();
        jtxtNom = new javax.swing.JTextField();
        separador11 = new javax.swing.JPanel();
        etiqueta19 = new javax.swing.JLabel();
        btncancelarficha = new javax.swing.JLabel();
        body5 = new javax.swing.JPanel();
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
        body7 = new javax.swing.JPanel();
        etiqueta29 = new javax.swing.JLabel();
        btnguardarcentro2 = new javax.swing.JLabel();
        campoFicha = new javax.swing.JTextField();
        campoDocumento = new javax.swing.JTextField();
        separador19 = new javax.swing.JPanel();
        btncancelarreportes = new javax.swing.JLabel();
        separador23 = new javax.swing.JPanel();
        radioDocumento = new javax.swing.JRadioButton();
        radioFicha = new javax.swing.JRadioButton();
        btnlimpiar = new javax.swing.JLabel();
        CheckBoxSalida = new javax.swing.JCheckBox();
        lblrol3 = new javax.swing.JLabel();
        lblrol4 = new javax.swing.JLabel();
        CheckBoxEntrada = new javax.swing.JCheckBox();
        btnlimpiar1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        fechaHasta = new com.toedter.calendar.JDateChooser();

        Opciones.setBackground(new java.awt.Color(255, 255, 255));
        Opciones.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        Opciones.setForeground(new java.awt.Color(89, 181, 72));
        Opciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpcionesMouseClicked(evt);
            }
        });

        Modificarequipos.setBackground(new java.awt.Color(255, 255, 255));
        Modificarequipos.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        Modificarequipos.setForeground(new java.awt.Color(89, 181, 72));
        Modificarequipos.setText("Modificar");
        Modificarequipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarequiposActionPerformed(evt);
            }
        });
        Opciones.add(Modificarequipos);

        Desactivarequipos.setBackground(new java.awt.Color(255, 255, 255));
        Desactivarequipos.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        Desactivarequipos.setForeground(new java.awt.Color(89, 181, 72));
        Desactivarequipos.setText("Eliminar");
        Desactivarequipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesactivarequiposActionPerformed(evt);
            }
        });
        Opciones.add(Desactivarequipos);

        hrinfo.setBackground(new java.awt.Color(255, 255, 255));
        hrinfo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        hrinfo.setForeground(new java.awt.Color(89, 181, 72));
        hrinfo.setLabel("información");
        hrinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrinfoActionPerformed(evt);
            }
        });
        hrpopmenu.add(hrinfo);

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
        btnpersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
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
        btnreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/periodico.png"))); // NOI18N
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
        barralateral.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 70, 70));

        btnregistros.setBackground(new java.awt.Color(89, 181, 72));
        btnregistros.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnregistros.setForeground(new java.awt.Color(255, 255, 255));
        btnregistros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnregistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-documento-simbolo-delineado.png"))); // NOI18N
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

        btnlogout1.setBackground(new java.awt.Color(89, 181, 72));
        btnlogout1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnlogout1.setForeground(new java.awt.Color(255, 255, 255));
        btnlogout1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlogout1.setText("LogOut");
        btnlogout1.setToolTipText("");
        btnlogout1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlogout1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnlogout1.setIconTextGap(1);
        btnlogout1.setMaximumSize(new java.awt.Dimension(41, 56));
        btnlogout1.setMinimumSize(new java.awt.Dimension(41, 56));
        btnlogout1.setName(""); // NOI18N
        btnlogout1.setOpaque(true);
        btnlogout1.setPreferredSize(new java.awt.Dimension(41, 56));
        btnlogout1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnlogout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogout1MouseClicked(evt);
            }
        });
        barralateral.add(btnlogout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 70, 40));

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

        javax.swing.GroupLayout hhomeLayout = new javax.swing.GroupLayout(hhome);
        hhome.setLayout(hhomeLayout);
        hhomeLayout.setHorizontalGroup(
            hhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hhomeLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(etiquetanombre1))
        );

        head.add(hhome, "card2");

        hbuscar.setBackground(new java.awt.Color(255, 255, 255));
        hbuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar-con-herramienta-en-esquema.png"))); // NOI18N
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
        nuevoregistro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-usuario.png"))); // NOI18N
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
        cambiarpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrasena.png"))); // NOI18N
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

        iconbuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar-con-herramienta-en-esquema.png"))); // NOI18N
        hequipo.add(iconbuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

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

        hequipo.add(separador18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 160, 2));

        equipostxtconsulta.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        equipostxtconsulta.setForeground(new java.awt.Color(102, 102, 102));
        equipostxtconsulta.setText("Cedula de Usuario");
        equipostxtconsulta.setBorder(null);
        equipostxtconsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equipostxtconsultaMouseClicked(evt);
            }
        });
        equipostxtconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipostxtconsultaActionPerformed(evt);
            }
        });
        equipostxtconsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                equipostxtconsultaKeyReleased(evt);
            }
        });
        hequipo.add(equipostxtconsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 150, 30));

        etiqueta28.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta28.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta28.setText("Serial:");
        hequipo.add(etiqueta28, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 70, 30));

        equipostipobox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        equipostipobox.setForeground(new java.awt.Color(102, 102, 102));
        equipostipobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Portatil", "Tablet", "Celular", "Proyector", "Otros" }));
        equipostipobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                equipostipoboxItemStateChanged(evt);
            }
        });
        equipostipobox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equipostipoboxMouseClicked(evt);
            }
        });
        equipostipobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipostipoboxActionPerformed(evt);
            }
        });
        hequipo.add(equipostipobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 100, 30));

        etiqueta30.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta30.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta30.setText("Tipo:");
        hequipo.add(etiqueta30, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, 30));

        etiqueta31.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta31.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta31.setText("Marca:");
        hequipo.add(etiqueta31, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 60, 30));

        equiposmarcabox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        equiposmarcabox.setForeground(new java.awt.Color(102, 102, 102));
        equiposmarcabox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "ACER", "ASUS", "APPLE", "DELL", "GATEWAY", "HP", "LENOVO", "LG", "PC SMART", "THOSIBA", "SONY", "OTROS" }));
        hequipo.add(equiposmarcabox, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 140, 30));

        etiqueta32.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta32.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta32.setText("Descripcion:");
        hequipo.add(etiqueta32, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 100, 30));

        etiqueta33.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta33.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta33.setText("Modelo:");
        hequipo.add(etiqueta33, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 80, 30));

        equipostxtserial.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        equipostxtserial.setForeground(new java.awt.Color(102, 102, 102));
        equipostxtserial.setBorder(null);
        equipostxtserial.setOpaque(false);
        hequipo.add(equipostxtserial, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 140, 30));

        separador20.setBackground(new java.awt.Color(252, 115, 35));
        separador20.setForeground(new java.awt.Color(252, 115, 35));
        separador20.setPreferredSize(new java.awt.Dimension(172, 2));
        separador20.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador20Layout = new javax.swing.GroupLayout(separador20);
        separador20.setLayout(separador20Layout);
        separador20Layout.setHorizontalGroup(
            separador20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        separador20Layout.setVerticalGroup(
            separador20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        hequipo.add(separador20, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 140, -1));

        equipostxtdesc.setColumns(20);
        equipostxtdesc.setForeground(new java.awt.Color(102, 102, 102));
        equipostxtdesc.setRows(5);
        equipostxtdesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        jScrollPane4.setViewportView(equipostxtdesc);

        hequipo.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 170, 120));

        equipostxtmodelo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        equipostxtmodelo.setForeground(new java.awt.Color(102, 102, 102));
        equipostxtmodelo.setBorder(null);
        equipostxtmodelo.setOpaque(false);
        hequipo.add(equipostxtmodelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 140, 30));

        separador21.setBackground(new java.awt.Color(252, 115, 35));
        separador21.setForeground(new java.awt.Color(252, 115, 35));
        separador21.setPreferredSize(new java.awt.Dimension(172, 2));
        separador21.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador21Layout = new javax.swing.GroupLayout(separador21);
        separador21.setLayout(separador21Layout);
        separador21Layout.setHorizontalGroup(
            separador21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        separador21Layout.setVerticalGroup(
            separador21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        hequipo.add(separador21, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 140, -1));

        btnguardarequipos.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btnguardarequipos.setForeground(new java.awt.Color(89, 181, 72));
        btnguardarequipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnguardarequipos.setText("Guardar");
        btnguardarequipos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btnguardarequipos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardarequipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguardarequiposMouseClicked(evt);
            }
        });
        hequipo.add(btnguardarequipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 110, -1));

        btncancelarequipos.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btncancelarequipos.setForeground(new java.awt.Color(89, 181, 72));
        btncancelarequipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btncancelarequipos.setText("Cancelar");
        btncancelarequipos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btncancelarequipos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelarequipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelarequiposMouseClicked(evt);
            }
        });
        hequipo.add(btncancelarequipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 100, -1));

        btnmodificarequipos.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btnmodificarequipos.setForeground(new java.awt.Color(89, 181, 72));
        btnmodificarequipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnmodificarequipos.setText("Modificar");
        btnmodificarequipos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btnmodificarequipos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmodificarequipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmodificarequiposMouseClicked(evt);
            }
        });
        hequipo.add(btnmodificarequipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 110, -1));

        head.add(hequipo, "card3");

        getContentPane().add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 760, 170));

        body.setBackground(new java.awt.Color(244, 242, 242));
        body.setLayout(new java.awt.CardLayout());

        bhome.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(89, 181, 72));
        jLabel9.setText("v 1.0.0");

        btnpassac.setBackground(new java.awt.Color(255, 255, 255));
        btnpassac.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnpassac.setForeground(new java.awt.Color(89, 181, 72));
        btnpassac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnpassac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrasena (1).png"))); // NOI18N
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
        btnregistroac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-usuariox64.png"))); // NOI18N
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
        btnequipoac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pantalla-de-tv.png"))); // NOI18N
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
        tabla.setComponentPopupMenu(hrpopmenu);
        tabla.setGridColor(new java.awt.Color(153, 153, 153));
        tabla.setRowHeight(22);
        tabla.setSelectionBackground(new java.awt.Color(89, 181, 72));
        jScrollPane2.setViewportView(tabla);

        bbuscar.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 250));

        body.add(bbuscar, "card2");

        bequipo.setBackground(new java.awt.Color(255, 255, 255));
        bequipo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));

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
        tblListaEquipos.setComponentPopupMenu(Opciones);
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

        txtEmail.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtEmail.setBorder(null);
        txtEmail.setOpaque(false);
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 650, 170, 30));

        txtDocumento.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtDocumento.setBorder(null);
        txtDocumento.setOpaque(false);
        jPanel1.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 170, 30));

        imagen1.setOpaque(true);
        jPanel1.add(imagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 120, 110));

        lblrol2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblrol2.setForeground(new java.awt.Color(89, 181, 72));
        lblrol2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblrol2.setText("Subir");
        lblrol2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblrol2MouseClicked(evt);
            }
        });
        jPanel1.add(lblrol2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 100, 20));

        etiqueta6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiqueta6.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta6.setText("N° Telefono");
        jPanel1.add(etiqueta6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, -1, 30));

        txtTelefono.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtTelefono.setBorder(null);
        txtTelefono.setOpaque(false);
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
        etiqueta8.setText("Tipo de RH");
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

        btnequipos.setBackground(new java.awt.Color(255, 255, 255));
        btnequipos.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnequipos.setForeground(new java.awt.Color(89, 181, 72));
        btnequipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnequipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pantalla-de-tv.png"))); // NOI18N
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

        jtxtCod.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jtxtCod.setBorder(null);
        jtxtCod.setOpaque(false);
        body4.add(jtxtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 220, 30));

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

        jtxtNom.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jtxtNom.setBorder(null);
        jtxtNom.setOpaque(false);
        body4.add(jtxtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 220, 30));

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

        jtxtCodCentro.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jtxtCodCentro.setBorder(null);
        jtxtCodCentro.setOpaque(false);
        body5.add(jtxtCodCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 220, 30));

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

        jtxtNombreCentro.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jtxtNombreCentro.setBorder(null);
        jtxtNombreCentro.setOpaque(false);
        body5.add(jtxtNombreCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 220, 30));

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

        body7.setBackground(new java.awt.Color(255, 255, 255));
        body7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiqueta29.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        etiqueta29.setForeground(new java.awt.Color(89, 181, 72));
        etiqueta29.setText("Crontol De Reportes");
        body7.add(etiqueta29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 320, 50));

        btnguardarcentro2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btnguardarcentro2.setForeground(new java.awt.Color(89, 181, 72));
        btnguardarcentro2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnguardarcentro2.setText("Generar Reporte");
        btnguardarcentro2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btnguardarcentro2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardarcentro2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguardarcentro2MouseClicked(evt);
            }
        });
        body7.add(btnguardarcentro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 150, -1));

        campoFicha.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        campoFicha.setBorder(null);
        campoFicha.setOpaque(false);
        body7.add(campoFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 220, 30));

        campoDocumento.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        campoDocumento.setBorder(null);
        campoDocumento.setOpaque(false);
        body7.add(campoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 220, 30));

        separador19.setBackground(new java.awt.Color(252, 115, 35));
        separador19.setForeground(new java.awt.Color(252, 115, 35));
        separador19.setPreferredSize(new java.awt.Dimension(172, 2));
        separador19.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador19Layout = new javax.swing.GroupLayout(separador19);
        separador19.setLayout(separador19Layout);
        separador19Layout.setHorizontalGroup(
            separador19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separador19Layout.setVerticalGroup(
            separador19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        body7.add(separador19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 220, -1));

        btncancelarreportes.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btncancelarreportes.setForeground(new java.awt.Color(89, 181, 72));
        btncancelarreportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btncancelarreportes.setText("Cancelar");
        btncancelarreportes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 181, 72)));
        btncancelarreportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelarreportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelarreportesMouseClicked(evt);
            }
        });
        body7.add(btncancelarreportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 100, -1));

        separador23.setBackground(new java.awt.Color(252, 115, 35));
        separador23.setForeground(new java.awt.Color(252, 115, 35));
        separador23.setPreferredSize(new java.awt.Dimension(172, 2));
        separador23.setRequestFocusEnabled(false);

        javax.swing.GroupLayout separador23Layout = new javax.swing.GroupLayout(separador23);
        separador23.setLayout(separador23Layout);
        separador23Layout.setHorizontalGroup(
            separador23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separador23Layout.setVerticalGroup(
            separador23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        body7.add(separador23, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 220, -1));

        radioDocumento.setBackground(new java.awt.Color(255, 255, 255));
        grupoRadio.add(radioDocumento);
        radioDocumento.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        radioDocumento.setForeground(new java.awt.Color(89, 181, 72));
        radioDocumento.setText("N° de Documento");
        radioDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDocumentoActionPerformed(evt);
            }
        });
        body7.add(radioDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        radioFicha.setBackground(new java.awt.Color(255, 255, 255));
        grupoRadio.add(radioFicha);
        radioFicha.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        radioFicha.setForeground(new java.awt.Color(89, 181, 72));
        radioFicha.setText("N° de Ficha");
        radioFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFichaActionPerformed(evt);
            }
        });
        body7.add(radioFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        btnlimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnlimpiar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnlimpiar.setForeground(new java.awt.Color(89, 181, 72));
        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/escoba-de-limpieza-para-suelos.png"))); // NOI18N
        btnlimpiar.setToolTipText("Minimizar");
        btnlimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlimpiarMouseClicked(evt);
            }
        });
        body7.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 30, 30));

        CheckBoxSalida.setBackground(new java.awt.Color(255, 255, 255));
        CheckBoxSalida.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        CheckBoxSalida.setForeground(new java.awt.Color(89, 181, 72));
        CheckBoxSalida.setText("Salida");
        CheckBoxSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxSalidaActionPerformed(evt);
            }
        });
        body7.add(CheckBoxSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

        lblrol3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblrol3.setForeground(new java.awt.Color(89, 181, 72));
        lblrol3.setText("Hasta");
        body7.add(lblrol3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        lblrol4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblrol4.setForeground(new java.awt.Color(89, 181, 72));
        lblrol4.setText("Desde");
        body7.add(lblrol4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        CheckBoxEntrada.setBackground(new java.awt.Color(255, 255, 255));
        CheckBoxEntrada.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        CheckBoxEntrada.setForeground(new java.awt.Color(89, 181, 72));
        CheckBoxEntrada.setText("Entrada");
        CheckBoxEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxEntradaActionPerformed(evt);
            }
        });
        body7.add(CheckBoxEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        btnlimpiar1.setBackground(new java.awt.Color(255, 255, 255));
        btnlimpiar1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnlimpiar1.setForeground(new java.awt.Color(89, 181, 72));
        btnlimpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/escoba-de-limpieza-para-suelos.png"))); // NOI18N
        btnlimpiar1.setToolTipText("Minimizar");
        btnlimpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlimpiar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlimpiar1MouseClicked(evt);
            }
        });
        body7.add(btnlimpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 30, 30));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(252, 115, 35)), "Reporte General", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18), new java.awt.Color(89, 181, 72))); // NOI18N
        body7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 440, 140));

        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(252, 115, 35)), "Reporte Detallado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18), new java.awt.Color(89, 181, 72))); // NOI18N
        body7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 440, 150));

        fechaDesde.setDateFormatString("yyyy/MM/dd");
        body7.add(fechaDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 220, -1));

        fechaHasta.setDateFormatString("yyyy/MM/dd");
        body7.add(fechaHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 220, -1));

        getContentPane().add(body7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 760, 420));

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
        resetBoton();
        setLblColor(btnpersonas);
                
        //switch bettween Jpanels
        oculta();
        hbuscar.setVisible(true);
        bbuscar.setVisible(true);
        body.setVisible(true);
        head.setVisible(true);
    }//GEN-LAST:event_btnpersonasMouseClicked

    private void btnreportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnreportesMouseClicked
       
        resetBoton();
        setLblColor(btnreportes);
        
        //switch bettween Jpanels
        oculta();
        body7.setVisible(true);
        
    }//GEN-LAST:event_btnreportesMouseClicked

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
        resetBoton();
        setLblColor(btnhome);
        
        //switch bettween Jpanels
        oculta();
        hhome.setVisible(true);
        bhome.setVisible(true);
        body.setVisible(true);
        head.setVisible(true);
    }//GEN-LAST:event_btnhomeMouseClicked

    private void nuevoregistro22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoregistro22MouseClicked
        cbxFicha.removeAll();
        cbxFicha.addItem("Seleccione");
        con.setLlenaCombo("Select FICnumFic from ficha", "FICnumFic", 1);
        cbxFicha.addItem(con.getLlenaCombo());
        //cbxFicha.remove(3);
        
        cbxCentro.removeAll();
        cbxCentro.addItem("Seleccione");
        con.setLlenaCombo("Select CENnomCen from centros ", "CENnomCen", 1);
        cbxCentro.addItem(con.getLlenaCombo());
        //cbxCentro.remove(3);
        
        estadobox.setEnabled(false);
        
        //switch bettween Jpanels
        oculta();
        formulario.setVisible(true);
        body2.setVisible(true);
    }//GEN-LAST:event_nuevoregistro22MouseClicked

    private void btnpassacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpassacMouseClicked
        ///switch bettween Jpanels
        oculta();
        JpCamCon.setVisible(true);
    }//GEN-LAST:event_btnpassacMouseClicked

    private void btnregistroacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistroacMouseClicked
        cbxFicha.removeAll();
        cbxFicha.addItem("Seleccione");
        con.setLlenaCombo("Select FICnumFic from ficha", "FICnumFic", 1);
        cbxFicha.addItem(con.getLlenaCombo());
        //cbxFicha.remove(3);
        
        cbxCentro.removeAll();
        cbxCentro.addItem("Seleccione");
        con.setLlenaCombo("Select CENnomCen from centros ", "CENnomCen", 1);
        cbxCentro.addItem(con.getLlenaCombo());
        //cbxCentro.remove(3);
        
        estadobox.setEnabled(false);
        
    //switch bettween Jpanels
        oculta();
        body2.setVisible(true);
        formulario.setVisible(true);
        
        
    }//GEN-LAST:event_btnregistroacMouseClicked

    private void btnequipoacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnequipoacMouseClicked
       //switch bettween Jpanels
        oculta();
        hequipo.setVisible(true);
        bequipo.setVisible(true);
        body.setVisible(true);
        head.setVisible(true);
    }//GEN-LAST:event_btnequipoacMouseClicked

    private void btnregistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistrosMouseClicked
        resetBoton();
        setLblColor(btnregistros);
        
        //switch bettween Jpanels
        oculta();
        body3.setVisible(true);
    }//GEN-LAST:event_btnregistrosMouseClicked

    private void btncentrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncentrosMouseClicked
        oculta();
        body5.setVisible(true);
    }//GEN-LAST:event_btncentrosMouseClicked

    private void btnfichasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfichasMouseClicked
        oculta();
        body4.setVisible(true);
    }//GEN-LAST:event_btnfichasMouseClicked

    private void btnguardarfichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarfichaMouseClicked
        con.setInsert("INSERT INTO ficha (FICnumFic, FICdesFic)VALUES "
                + "("+jtxtCod.getText()+",'"+jtxtNom.getText()+"')");
        
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Se ha guardado la ficha correctamente</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
        
        resetBoton();
        setLblColor(btnregistros);
        
        //switch bettween Jpanels
        oculta();
        body4.setVisible(true);
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
        
        
        setLblColor(btnregistros);

        resetLblColor(btnregistros);
    }//GEN-LAST:event_btnguardarcentroMouseClicked

    private void cbxDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDepartamentoActionPerformed
        cbxCiudad.removeAllItems();

        con.getConexion();
        if(cbxDepartamento.getSelectedIndex()>0){
            con.setLlenaCombo(("Select CIUnomCiu from ciudad where CIUidDepFK "
                + "= "+cbxDepartamento.getSelectedIndex()),"CIUnomCiu", 1);

        }

    }//GEN-LAST:event_cbxDepartamentoActionPerformed

    private void btncancelarcentroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarcentroMouseClicked
        resetBoton();
        setLblColor(btnregistros);
        
        //switch bettween Jpanels
        oculta();
        body3.setVisible(true);
        
    }//GEN-LAST:event_btncancelarcentroMouseClicked

    private void btncancelarfichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarfichaMouseClicked
        resetBoton();
        setLblColor(btnregistros);
        
        //switch bettween Jpanels
        oculta();
        body3.setVisible(true);
    }//GEN-LAST:event_btncancelarfichaMouseClicked

    private void cambiarpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarpassMouseClicked
        oculta();
        JpCamCon.setVisible(true);
    }//GEN-LAST:event_cambiarpassMouseClicked

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
        resetBoton();
        setLblColor(btnpersonas);
        
        //cambio entre Jpanels
        oculta();
        body.setVisible(true);
        head.setVisible(true);
    }//GEN-LAST:event_btncancelarpassMouseClicked

    private void btnequiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnequiposMouseClicked
        //switch bettween Jpanels
       oculta();
       
        body.setVisible(true);
        head.setVisible(true);
       
    }//GEN-LAST:event_btnequiposMouseClicked

    private void equipostxtconsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equipostxtconsultaMouseClicked
        equipostxtconsulta.setText("");
    }//GEN-LAST:event_equipostxtconsultaMouseClicked

    private void equipostxtconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipostxtconsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equipostxtconsultaActionPerformed

    private void equipostxtconsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_equipostxtconsultaKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                   obtenerdatosequipos();
                   CargarTablaMisEquipos();
                }
                if(evt.getKeyCode()==KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
    }//GEN-LAST:event_equipostxtconsultaKeyReleased

    private void equipostipoboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_equipostipoboxItemStateChanged
        
    }//GEN-LAST:event_equipostipoboxItemStateChanged

    private void equipostipoboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equipostipoboxMouseClicked
        
    }//GEN-LAST:event_equipostipoboxMouseClicked

    private void equipostipoboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipostipoboxActionPerformed
        
    }//GEN-LAST:event_equipostipoboxActionPerformed

    private void ModificarequiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarequiposActionPerformed
        int posicion;

        posicion=tblListaEquipos.getSelectedRow();

        if(posicion>=0){
            btnguardarequipos.setVisible(false);
            btnmodificarequipos.setVisible(true);
            codequipo=tblListaEquipos.getValueAt(posicion, 0).toString();
            equipostipobox.setSelectedItem(tblListaEquipos.getValueAt(posicion, 1).toString());
            equiposmarcabox.setSelectedItem(tblListaEquipos.getValueAt(posicion, 2).toString());
            equipostxtmodelo.setText(tblListaEquipos.getValueAt(posicion, 3).toString());
            equipostxtserial.setText(tblListaEquipos.getValueAt(posicion, 4).toString());
            equipostxtdesc.setText(tblListaEquipos.getValueAt(posicion, 5).toString());
            btncancelarequipos.setVisible(true);

        }else{
            JOptionPane.showMessageDialog(null, "No ha seleccionado la fila");
        }
    }//GEN-LAST:event_ModificarequiposActionPerformed

    private void DesactivarequiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesactivarequiposActionPerformed
        int posicion;
        posicion=tblListaEquipos.getSelectedRow();

        int confirmado =JOptionPane.showConfirmDialog(null, "Desea eliminar este dato", "Eliminar Dato", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

        String codequipo="";

        if (JOptionPane.YES_OPTION == confirmado){
            codequipo=tblListaEquipos.getValueAt(posicion, 0).toString();
            codequipo=tblListaEquipos.getValueAt(posicion, 0).toString();
            con.setDelete("delete from perequ where PEidEquFK='"+codequipo+"'");
            con.setDelete("delete from equipos where EQUidEquPK='"+codequipo+"'");
            //con.setDelete("delete from persona_equipos where id_equi='"+cod+"'");

            JOptionPane.showMessageDialog(null, "Eliminado Exitosamente");

            CargarTablaMisEquipos();
        }else{

        }

    }//GEN-LAST:event_DesactivarequiposActionPerformed

    private void OpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_OpcionesMouseClicked

    private void btnguardarequiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarequiposMouseClicked
        obtenerdatosequipos();

            pers_equipos=0;
            equip_equipos=0;
       
               
            //System.out.println(tipo);
            //if(tipo != 0 && marca != 0 && serial != null && modelo != null && desc != null){
             
            btnguardarequipos.setVisible(true);
            con.setInsert("insert into equipos (EQUidMarFK, EQUmod, EQUser, EQUidTipFK, EQUdes)values('"+marca+"','"+modelo+"','"+serial
                        + "','"+tipo+"','"+desc+"')");
               
            con.setSelectInt("SELECT PERidPerPK FROM persona WHERE PERnumDoc='"+cedulaequipos+"'", "PERidPerPK");
               
                pers_equipos=con.getSelectInt();        
        
            con.setSelectInt("SELECT MAX(EQUidEquPK) AS id FROM equipos", "id");

                equip_equipos=con.getSelectInt();
                  
            con.setInsert("insert into perequ (PEidPerFK, PEidEquFK)values('"+pers_equipos+"','"+equip_equipos+"')");

                JOptionPane.showMessageDialog(null, "Guardado Exitosamente");

                equiposmarcabox.setSelectedItem("Seleccione");
                equipostipobox.setSelectedItem("Seleccione");
                equipostxtmodelo.setText("");
                equipostxtserial.setText("");
                equipostxtdesc.setText("");
                
            CargarTablaMisEquipos();
            //}
    }//GEN-LAST:event_btnguardarequiposMouseClicked

    private void btncancelarequiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarequiposMouseClicked
        equiposmarcabox.setSelectedItem("Seleccione");
        equipostipobox.setSelectedItem("Seleccione");
        equipostxtmodelo.setText("");
        equipostxtserial.setText("");
        equipostxtdesc.setText("");
        btnmodificarequipos.setVisible(false);
        btnguardarequipos.setVisible(true);
        btncancelarequipos.setVisible(false);
    }//GEN-LAST:event_btncancelarequiposMouseClicked

    private void btnmodificarequiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodificarequiposMouseClicked
        con.setUpdate("update equipos set EQUidMarFK='"+equiposmarcabox.getSelectedIndex()+"',EQUmod='"+equipostxtmodelo.getText()+"',EQUser='"+equipostxtserial.getText()+"',EQUidTipFK='"+equipostipobox.getSelectedIndex()+"',EQUdes='"+equipostxtdesc.getText()+"' where EQUidEquPK='"+codequipo+"'");
        
        JOptionPane.showMessageDialog(null, "Modificado Exitosamente");
        btnmodificarequipos.setVisible(false);
        btnguardar.setVisible(true);
        

                equiposmarcabox.setSelectedItem("Seleccione");
                equipostipobox.setSelectedItem("Seleccione");
                equipostxtmodelo.setText("");
                equipostxtserial.setText("");
                equipostxtdesc.setText("");
                
                CargarTablaMisEquipos();
    }//GEN-LAST:event_btnmodificarequiposMouseClicked

    private void btnguardarcentro2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarcentro2MouseClicked
        if (radioFicha.getModel()== grupoRadio.getSelection()){
            validarFicha();
           // validarFechas();
        }else{
            validarCampos();
        }
       
    }//GEN-LAST:event_btnguardarcentro2MouseClicked

    private void btncancelarreportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarreportesMouseClicked
        resetBoton();
        setLblColor(btnhome);
        
        //cambio entre Jpanels
        oculta();
        hhome.setVisible(true);
        bhome.setVisible(true);
        body.setVisible(true);
        
    }//GEN-LAST:event_btncancelarreportesMouseClicked

    private void radioDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDocumentoActionPerformed
        HabilitarCampo();
    }//GEN-LAST:event_radioDocumentoActionPerformed

    private void radioFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFichaActionPerformed
        HabilitarCampo();
    }//GEN-LAST:event_radioFichaActionPerformed

    private void btnlimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlimpiarMouseClicked
        //Limpia campos superiores
        campoDocumento.setEnabled(false);
        campoDocumento.setText("");
        campoFicha.setEnabled(false);
        campoFicha.setText("");
        grupoRadio.clearSelection();
    }//GEN-LAST:event_btnlimpiarMouseClicked

    private void CheckBoxSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBoxSalidaActionPerformed

    private void CheckBoxEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBoxEntradaActionPerformed

    private void btnlimpiar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlimpiar1MouseClicked
        //Limpia campos inferiores
        CheckBoxSalida.setSelected(false);
        CheckBoxEntrada.setSelected(false);
        fechaHasta.setDate(null);
        fechaDesde.setDate(null);
    }//GEN-LAST:event_btnlimpiar1MouseClicked

    private void lblrol2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblrol2MouseClicked
        try{
            Camara window = new Camara();
            window.id=1;
            window.show();
            window.setLocationRelativeTo(null);
        }catch (Exception e){
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> La camara ya esta en uso</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S",JOptionPane.WARNING_MESSAGE,joke);
        }
    }//GEN-LAST:event_lblrol2MouseClicked

    private void btncancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarMouseClicked
        resetBoton();
        setLblColor(btnpersonas);

        //switch bettween Jpanels
        oculta();
        hbuscar.setVisible(true);
        bbuscar.setVisible(true);
        body.setVisible(true);
        head.setVisible(true);
    }//GEN-LAST:event_btncancelarMouseClicked

    private void btnguardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarMouseClicked

        int hrid,docu = 0,id=0;
        con.setSelectInt("Select PERidPerPK from persona where PERnumDoc ='"+txtDocumento.getText()+"'","PERidPerPK");
        hrid = con.getSelectInt();
        con.setSelectInt("Select PERnumDoc from persona where PERnumDoc ='"+txtDocumento.getText()+"'","PERnumDoc");
        docu = con.getSelectInt();

        con.setSelectInt("Select PERidPerPK from persona","PERidPerPK");
        id=con.getSelectInt();

        //FileInputStream fi = null;

        id++;

        if(docu>0){

            con.setUpdate("update persona set PERidDocFK='"+cbxTipoDoc.getSelectedIndex()+"',"
                + "PERnumDoc='"+txtDocumento.getText()+"',"
                + "PERnom1='"+txtNombre1.getText()+"',"
                + "PERnom2='"+txtNombre2.getText()+"',"
                + "PERape1='"+txtApellido1.getText()+"',"
                + "PERape2='"+txtApellido2.getText()+"',"
                + "PERidGenFK='"+cbxGenero.getSelectedIndex()+"',"
                + "PERdir='"+txtDireccion.getText()+"',"
                + "PERtelFij='"+txtTelefono.getText()+"',"
                + "PERcel='"+txtCelular.getText()+"',"
                + "PERcor='"+txtEmail.getText()+"',"
                + "PERidRhFK='"+cbxRh.getSelectedIndex()+"',"
                + "PERidTiPeFK='"+cbxTipUser.getSelectedIndex()+"',"
                + "PERidRolFK='"+cbxRol.getSelectedIndex()+"',"
                + "PERidCenFK='"+cbxCentro.getSelectedIndex()+"',"
                + "PERidCenFK='"+estadobox.getSelectedIndex()+"',"
                + "PERidFicFK='"+cbxFicha.getSelectedIndex()+"'"
                + "where PERidPerPK='"+hrid+"'");

            Jpaint();
            String jokio = "<html><body> <b style =\"font-size: 20; color: white;\">Modificado Existosamente </b></body> </html>";
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

                } /*      catch (FileNotFoundException ex) {
                    Logger.getLogger(RegistroPersona.class.getName()).log(Level.SEVERE, null, ex);*/
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
                ps.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());

            }

            resetPersona();
    }//GEN-LAST:event_btnguardarMouseClicked

    private void hrinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrinfoActionPerformed
        int hrid,hrId_tipo_persona,acceso=0;
        String hrTdoc,hrcentro,hrgener,hrusrol,hrtipo_persona,tphr,hrnum_documento, hrnombre_1,hrnombre_2, hrape_1,hrape_2,hrId_ficha ,hrcorreo,hrcelular,hrTelfono,hrdireccion, accesos;

        int posicion;
        String codequipo="";
        posicion=tabla.getSelectedRow();
        codequipo=tabla.getValueAt(posicion, 1).toString();

        if (codequipo != null){

            con.setSelectStr("SELECT PERnom1 FROM persona WHERE PERnumDoc='"+codequipo+"'","PERnom1");
            hrnombre_1 = con.getSelectStr();

            con.setSelectStr(("SELECT PERnom2  FROM persona WHERE PERnumDoc='"+codequipo+"'"),"PERnom2");
            hrnombre_2 = con.getSelectStr();

            con.setSelectStr(("SELECT PERape1  FROM persona WHERE PERnumDoc='"+codequipo+"'"),"PERape1");
            hrape_1 = con.getSelectStr();

            con.setSelectStr(("SELECT PERape2 FROM persona WHERE PERnumDoc='"+codequipo+"'"),"PERape2");
            hrape_2 = con.getSelectStr();

            con.setSelectStr(("SELECT FICnumFic \n" +
                "FROM ficha as f JOIN persona as p on f.FICidFicPK=p.PERidFicFK\n" +
                "WHERE PERnumDoc='"+codequipo+"'"),"FICnumFic");
        hrId_ficha = con.getSelectStr();

        con.setSelectStr(("SELECT PERnumDoc  FROM persona WHERE PERnumDoc='"+codequipo+"'"),"PERnumDoc");
        hrnum_documento = con.getSelectStr();

        con.setSelectStr("select DOCdesTipDoc from persona inner join documento on PERidDocFK=DOCidDocPK where PERnumDoc='"+codequipo+"'","DOCdesTipDoc");
        hrTdoc=con.getSelectStr();

        con.setSelectInt("select PERidTiPeFK from persona where PERnumDoc='"+codequipo+"'","PERidTiPeFK");
        hrId_tipo_persona=con.getSelectInt();

        con.setSelectStr(("SELECT CENnomCen FROM persona inner join centros on PERidCenFK=CENidCenPK WHERE PERnumDoc='"+codequipo+"'"),"CENnomCen");
        hrcentro = con.getSelectStr();

        con.setSelectStr(("SELECT RHdesRh from persona inner join rh on PERidRhFK=RHidRhPK where PERnumDoc='"+codequipo+"'"),"RHdesRh");
        tphr=con.getSelectStr();

        con.setSelectStr("select GENdesGen from persona inner join genero on PERidGenFK=GENidGenPK where PERnumDoc='"+codequipo+"'","GENdesGen");
        hrgener=con.getSelectStr();

        con.setSelectStr(("SELECT PERcor FROM persona WHERE PERnumDoc='"+codequipo+"'"),"PERcor");
        hrcorreo = con.getSelectStr();

        con.setSelectStr(("SELECT PERtelFij  FROM persona WHERE PERnumDoc='"+codequipo+"'"),"PERtelFij");
        hrTelfono = con.getSelectStr();

        con.setSelectStr(("SELECT PERcel  FROM persona WHERE PERnumDoc='"+codequipo+"'"),"PERcel");
        hrcelular = con.getSelectStr();

        con.setSelectStr(("SELECT PERdir  FROM persona WHERE PERnumDoc='"+codequipo+"'"),"PERdir");
        hrdireccion = con.getSelectStr();

        con.setSelectStr("select TPdeTiPe from persona inner join tipper on PERidTiPeFK=TPidTiPePK where PERnumDoc='"+codequipo+"'","TPdeTiPe");
        hrtipo_persona=con.getSelectStr();

        con.setSelectStr(("select ACCact \n" +
            "from persona pr \n" +
            "inner join acceso ac \n" +
            "on pr.PERidPerPK=ac.ACCidPerFK\n" +
            "where PERnumDoc='"+codequipo+"';"),"ACCact");
    accesos = con.getSelectStr();
    switch (accesos){
        case "SI":
        acceso=0;
        break;
        case "NO":
        acceso=1;
        break;
        }

        con.setSelectStr("select ROLdesRol from persona inner join rol on PERidRolFK=ROLidRolPK where PERnumDoc='"+codequipo+"'","ROLdesRol");
        hrusrol=con.getSelectStr() ;

        body2.setVisible(true);
        formulario.setVisible(true);
        body.setVisible(false);
        head.setVisible(false);
        txtNombre1.setText(hrnombre_1);
        txtNombre2.setText(hrnombre_2);
        txtApellido1.setText(hrape_1);
        txtApellido2.setText(hrape_2);
        cbxFicha.select(hrId_ficha);
        txtDocumento.setText(hrnum_documento);
        cbxRh.select(tphr);
        cbxCentro.select(hrcentro);
        txtEmail.setText(hrcorreo);
        txtTelefono.setText(hrTelfono);
        txtCelular.setText(hrcelular);
        txtDireccion.setText(hrdireccion);
        cbxGenero.select(hrgener);
        cbxTipUser.select(hrtipo_persona);
        cbxRol.select(hrusrol);
        estadobox.select(acceso);
        cbxTipoDoc.select(hrTdoc);
        String r=ruta2+"/"+txtDocumento.getText()+".png";

        }else{

            txtconsulta.setText(null);
            JOptionPane.showMessageDialog(null, codequipo);
            JOptionPane.showMessageDialog(null, cedula);
        }
    }//GEN-LAST:event_hrinfoActionPerformed

    private void btnlogout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogout1MouseClicked

        Jpaint();
        String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> ¿Desea Cerrar Sesión?</b> </body> </html>";

        int codigo=JOptionPane.showConfirmDialog(null, jok, "Cerrar Sesion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,joke);
        if (codigo==JOptionPane.YES_OPTION){
            dispose();
            con.cerrarConexion();
            loginf log = new loginf();
            log.setVisible(true);
        }
    }//GEN-LAST:event_btnlogout1MouseClicked

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
    private javax.swing.JCheckBox CheckBoxEntrada;
    private javax.swing.JCheckBox CheckBoxSalida;
    private javax.swing.JMenuItem Desactivarequipos;
    private javax.swing.JPanel JpCamCon;
    private javax.swing.JMenuItem Modificarequipos;
    private javax.swing.JPopupMenu Opciones;
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
    private javax.swing.JPanel body7;
    private javax.swing.JLabel btncancelar;
    private javax.swing.JLabel btncancelarcentro;
    private javax.swing.JLabel btncancelarequipos;
    private javax.swing.JLabel btncancelarficha;
    private javax.swing.JLabel btncancelarpass;
    private javax.swing.JLabel btncancelarreportes;
    private javax.swing.JLabel btncentros;
    private javax.swing.JLabel btncerrar;
    private javax.swing.JLabel btnequipoac;
    private javax.swing.JLabel btnequipos;
    private javax.swing.JLabel btnfichas;
    private javax.swing.JLabel btnguarcampass;
    private javax.swing.JLabel btnguardar;
    private javax.swing.JLabel btnguardarcentro;
    private javax.swing.JLabel btnguardarcentro2;
    private javax.swing.JLabel btnguardarequipos;
    private javax.swing.JLabel btnguardarficha;
    private javax.swing.JLabel btnhome;
    private javax.swing.JLabel btnlimpiar;
    private javax.swing.JLabel btnlimpiar1;
    private javax.swing.JLabel btnlogout1;
    private javax.swing.JLabel btnminimizar;
    private javax.swing.JLabel btnmodificarequipos;
    private javax.swing.JLabel btnpassac;
    private javax.swing.JLabel btnpersonas;
    private javax.swing.JLabel btnregistroac;
    private javax.swing.JLabel btnregistros;
    private javax.swing.JLabel btnreportes;
    private javax.swing.JLabel cambiarpass;
    private javax.swing.JTextField campoDocumento;
    private javax.swing.JTextField campoFicha;
    public static java.awt.Choice cbxCentro;
    public static javax.swing.JComboBox<String> cbxCiudad;
    public static javax.swing.JComboBox<String> cbxDepartamento;
    public static java.awt.Choice cbxFicha;
    private java.awt.Choice cbxGenero;
    private java.awt.Choice cbxRh;
    private java.awt.Choice cbxRol;
    private java.awt.Choice cbxTipUser;
    private java.awt.Choice cbxTipoDoc;
    private javax.swing.JComboBox<String> equiposmarcabox;
    private javax.swing.JComboBox<String> equipostipobox;
    private javax.swing.JTextField equipostxtconsulta;
    private javax.swing.JTextArea equipostxtdesc;
    private javax.swing.JTextField equipostxtmodelo;
    private javax.swing.JTextField equipostxtserial;
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
    private javax.swing.JLabel etiqueta29;
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
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.JPanel formulario;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JPanel hbuscar;
    private javax.swing.JPanel head;
    private javax.swing.JPanel header;
    private javax.swing.JPanel hequipo;
    private javax.swing.JPanel hhome;
    private javax.swing.JMenuItem hrinfo;
    private javax.swing.JPopupMenu hrpopmenu;
    private javax.swing.JLabel iconbuscar;
    private javax.swing.JLabel iconbuscar1;
    public static javax.swing.JLabel imagen;
    public static javax.swing.JLabel imagen1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPactual;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPcNueva;
    private javax.swing.JPasswordField jPnueva;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jtxtCod;
    private javax.swing.JTextField jtxtCodCentro;
    private javax.swing.JTextField jtxtNom;
    private javax.swing.JTextField jtxtNombreCentro;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblrol;
    private javax.swing.JLabel lblrol2;
    private javax.swing.JLabel lblrol3;
    private javax.swing.JLabel lblrol4;
    private javax.swing.JLabel nuevoregistro2;
    private javax.swing.JRadioButton radioDocumento;
    private javax.swing.JRadioButton radioFicha;
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
    private javax.swing.JPanel separador19;
    private javax.swing.JPanel separador2;
    private javax.swing.JPanel separador20;
    private javax.swing.JPanel separador21;
    private javax.swing.JPanel separador23;
    private javax.swing.JPanel separador3;
    private javax.swing.JPanel separador4;
    private javax.swing.JPanel separador5;
    private javax.swing.JPanel separador6;
    private javax.swing.JPanel separador7;
    private javax.swing.JPanel separador8;
    private javax.swing.JPanel separador9;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tblListaEquipos;
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
    private javax.swing.JTextField txtconsulta;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
