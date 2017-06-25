/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectBD;

import java.awt.Color;
import java.io.IOException;
import prototipo.registrador;
import prototipo.admin;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author FGALLARDO
 */
public class Pconnection {
    
    Propiedades pk = new Propiedades();
    String Server = pk.getServer();
    String DB = pk.getDb();
    String User = pk.getUser();
    String Pass = pk.getPass();
    
    private Connection conexion=null;
    private String select="";
    private String camp="";
    private int sel=0;
    private String sele="";
    private String md5="";
    private String campmd5="";
    private String update="";
    private String insert="";
    private String combo="";
    private String combox="";
    private String servidor=Server;
    private String database=DB;
    private String usuario=User;
    private String password=Pass;
    private String cbx = "";
    private String delete = "";

    private String campb="";
    private Blob selBlob =null;
    
    private void Jpaint(){
        UIManager.put("OptionPane.background", new ColorUIResource(89,200,72));
        UIManager.put("Button.background", Color.orange);
        UIManager.put("Panel.background", new ColorUIResource(89,200,72));
    }
    Icon joke = new ImageIcon(getClass().getResource("/Imagenes/logo.jpg"));
    
    
    public Pconnection() throws IOException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url="jdbc:mysql://"+servidor+"/"+database;
            //String jdbc = "jdbc:mysql://85.10.205.173/scesstk?user=wagallardo1&password=Sena2016";
            //String jdbcutf8 = "&useUnicode=true&characterEncoding=UTF-8";
            conexion=DriverManager.getConnection(url, usuario, password);
            //conexion=DriverManager.getConnection(jdbc+jdbcutf8);
            //Statement estado = conexion.createStatement();
            //System.out.println("Conexion a Base de Datos "+jdbc+" . . . . .Ok");
 
        }
        catch(SQLException ex){
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Error de Conexion MySql</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error MySQL",JOptionPane.WARNING_MESSAGE,joke);
        }catch (ClassNotFoundException ex) {
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Consulta erronea: \n "+ ex.getMessage() +"</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error MySQL",JOptionPane.WARNING_MESSAGE,joke);    
           /* JOptionPane.showMessageDialog(null,"Consulta erronea: \n"+ 
                        ex.getMessage(),"ERROR de ejecucion MySql",JOptionPane.WARNING_MESSAGE);*/
        }
        
    }
 
    public Connection getConexion(){
        return conexion;
    }
    
    public Connection setSelectInt(String Select, String campoInt){
        this.select = Select;
        this.camp = campoInt;
        sel=0;
        try{
        Statement stado = conexion.createStatement();
        ResultSet res = stado.executeQuery(select);
        while(res.next()){
            sel = res.getInt(camp);
        }
       // System.out.println("prueba select "+sel);
        }catch(SQLException ex){
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Error de Conexion MySql</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error MySQL",JOptionPane.WARNING_MESSAGE,joke);
        }
        
        return conexion;
    }
    
    
    public int getSelectInt(){
        return sel;
    }
    
    public Connection setDelete(String Delete){
        this.delete=Delete;
        try{
            Statement stado=conexion.createStatement();
            stado.executeUpdate(delete);
            
            System.out.println("prueba md5 "+delete);
        }catch(SQLException ex){
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Error de Conexion MySql</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error MySQL",JOptionPane.WARNING_MESSAGE,joke);
        }
        return conexion;
        
    }
    
    public Connection setSelectStr(String Select, String campoStr){
        this.select = Select;
        this.camp = campoStr;
        
        try{
        Statement stado = conexion.createStatement();
        ResultSet res = stado.executeQuery(select);
        while(res.next()){
            sele = res.getString(camp);
        }
       // System.out.println("prueba select "+sele);
        }catch(SQLException ex){
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Error de Conexion MySql</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error MySQL",JOptionPane.WARNING_MESSAGE,joke);
        }
        return conexion;
    }
    
    public String getSelectStr(){
        return sele;
    } 
    
    public Connection setUpdate(String Update){
        this.update=Update;
        try{
        Statement stado = conexion.createStatement();
        stado.executeUpdate(update);

        //System.out.println("prueba Update "+update);
        }catch(SQLException ex){
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Error de Conexion MySql</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error MySQL",JOptionPane.WARNING_MESSAGE,joke);
        }
        return conexion;
    }
    
    public Connection setInsert(String Insert){
        this.insert=Insert;
        try{
        Statement stado = conexion.createStatement();
        stado.execute(insert);

        //System.out.println("prueba Insert "+insert);
        }catch(SQLException ex){
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Error de Conexion MySql</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error MySQL",JOptionPane.WARNING_MESSAGE,joke);
        }
        return conexion;
    }
    
    
    public Connection setSelectMd5(String Md5, String campMd5){
        this.md5 =Md5;
        try{
        Statement stado = conexion.createStatement();
        ResultSet res = stado.executeQuery("SELECT md5('"+md5+"')");
        while(res.next()){
            campmd5 = res.getString("md5('"+campMd5+"')");
        }
      //  System.out.println("prueba md5 "+campmd5);
        }catch(SQLException ex){
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Error de Conexion MySql</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error MySQL",JOptionPane.WARNING_MESSAGE,joke);
        }
             
        return conexion;
    }
    
    public String getMd5(){
        return campmd5;
    }
    
    public Connection setLlenaCombo(String Select, String CampoN, int id){
        this.combo=Select;
        try{
        Statement stado = conexion.createStatement();
        ResultSet res = stado.executeQuery(combo);
        combox=null;
        //int i=0;
        while(res.next()){
            
            combox = res.getString(CampoN);
            if(CampoN.equals("CIUnomCiu")){
                if (id==1){
                    admin.cbxCiudad.addItem(combox);
                }else if(id==2){
                    registrador.cbxCiudad.addItem(combox);
                }
                
                //;
            }else if(CampoN.equals("FICnumFic")){
                if (id==1){
                    admin.cbxFicha.addItem(combox);
                }else if(id==2){
                    registrador.cbxFicha.addItem(combox);
                }
                
                //;
            }else if(CampoN.equals("CENnomCen")){
                if (id==1){
                    admin.cbxCentro.addItem(combox);
                }else if(id==2){
                    registrador.cbxCentro.addItem(combox);
                }
                
                //;
            }
            
        
         //   System.out.println("Prueba\n "+combox);
           // i++;
        }
        
        }catch(SQLException ex){
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Error de Conexion MySql</b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error MySQL",JOptionPane.WARNING_MESSAGE,joke);
        }
        
        return conexion;
    }
    
    public String getLlenaCombo(){
        return combox;
    }
    
    public Connection setSelectBlob(String Select, String campoBlob){
        this.select = Select;
        this.campb = campoBlob;
        
        try{
        Statement stado = conexion.createStatement();
        ResultSet res = stado.executeQuery(select);
        while(res.next()){
            selBlob = res.getBlob(campoBlob);
        }
       // System.out.println("prueba select "+sel);
        }catch(SQLException ex){
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Error de Conexion MySql </b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error MySQL",JOptionPane.WARNING_MESSAGE,joke);
        }
        
        return conexion;
    }
    
    public Blob getSelectBlob(){
        return selBlob;
    }

    public Connection cerrarConexion(){
        try {
            conexion.close();
            // System.out.println("Cerrando conexion a  . . . . . Ok");
        } catch (SQLException ex) {
            Jpaint();
            String jok = "<html><body> <b style =\"font-size: 20; color: white;\"> Error de Conexion MySql </b> </body> </html>";
            JOptionPane.showMessageDialog(null,jok, "S.C.E.S.S - Error MySQL",JOptionPane.WARNING_MESSAGE,joke);
        }
        conexion=null;
        return conexion;
    }
}
