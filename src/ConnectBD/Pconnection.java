/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectBD;

import RegistroPersona.RegistroCentro;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author FGALLARDO
 */
public class Pconnection {
    
    
        
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
    private String servidor="localhost";
    private String database="scess";
    private String usuario="root";
    private String password="";
    private String cbx = "";
    private String delete = "";

    private String campb="";
    private Blob selBlob =null;
    
    public Pconnection(){
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
                JOptionPane.showMessageDialog(null,"Error de Conexion MySql \n",
                        "Error MySql",JOptionPane.ERROR_MESSAGE);
        }catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Consulta erronea: \n"+ 
                        ex.getMessage(),"ERROR de ejecucion MySql",JOptionPane.WARNING_MESSAGE);
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
                JOptionPane.showMessageDialog(null,"Error de Conexion MySql \n"+ex,
                        "Error MySql",JOptionPane.ERROR_MESSAGE);
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
            System.out.println(ex);
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
        }        catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error de Conexion MySql \n"+ex,
                        "Error MySql",JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }
    
    public String getSelectStr(){
        return sele;
    } 
    
    public ArrayList<Persona> getLstPersona() throws SQLException, Exception{
            this.getConexion();
            ArrayList<Persona> lst = new ArrayList<>();
     /**       ResultSet rs = this.("SELECT * FROM Persona");

            if (rs != null) {
                while(rs.next()){
                    Cliente cli = new Cliente();
                    cli.setId(rs.getInt("id"));
                    cli.setPrimer_nombre(rs.getString("primer_nombre"));
                    cli.setSegundo_nombre(rs.getString("segundo_nombre"));
                    cli.setPrimer_apellido(rs.getString("primer_apellido"));
                    cli.setSegundo_apellido(rs.getString("segundo_apellido"));
                    cli.setCelular(rs.getString("celular"));
                    cli.setEmail(rs.getString("email"));
                    cli.setDireccion(rs.getString("direccion"));
                    lst.add(cli);
                }
            }**/
            this.cerrarConexion();
            return lst;
        }
    public Connection setUpdate(String Update){
        this.update=Update;
        try{
        Statement stado = conexion.createStatement();
        stado.executeUpdate(update);

        //System.out.println("prueba Update "+update);
        }        catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error de Conexion MySql \n"+ex,
                        "Error MySql",JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }
    
    public Connection setInsert(String Insert){
        this.insert=Insert;
        try{
        Statement stado = conexion.createStatement();
        stado.execute(insert);

        System.out.println("prueba Insert "+insert);
        }        catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error de Conexion MySql \n"+ex,
                        "Error MySql",JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null,"Error de Conexion MySql \n"+ex,
                        "Error MySql",JOptionPane.ERROR_MESSAGE);
        }
             
        return conexion;
    }
    
    public String getMd5(){
        return campmd5;
    }
    
    public Connection setLlenCombox(String Select, String Camp){
        this.combo=Select;
        try{
            Statement es = conexion.createStatement();
            ResultSet rs = es.executeQuery(combo);
            cbx = null;
            
            while(rs.next()){
                cbx = rs.getString(Camp);
            }
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error de Conexion MySql \n"+ex,
                        "Error MySql",JOptionPane.ERROR_MESSAGE);
        }
        
        
        return conexion;
    }
    
    public String getLlenCombox(){
        return cbx;
    }
    
    public Connection setLlenaCombo(String Select, String CampoN){
        this.combo=Select;
        try{
        Statement stado = conexion.createStatement();
        ResultSet res = stado.executeQuery(combo);
        combox=null;
        //int i=0;
        while(res.next()){
            
            combox = res.getString(CampoN);
            RegistroCentro.cbxCiudad.addItem(combox);
           // i++;
        }
        //System.out.println("combo \n "+combox);
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error de Conexion MySql \n"+ex,
                        "Error MySql",JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null,"Error de Conexion MySql \n"+ex,
                        "Error MySql",JOptionPane.ERROR_MESSAGE);
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
            System.out.println(ex);
        }
        conexion=null;
        return conexion;
    }
}
