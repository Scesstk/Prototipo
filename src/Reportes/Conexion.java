package Reportes;

import ConnectBD.Propiedades;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    Propiedades pk = new Propiedades();
    
    String Server = pk.getServer();
    String DB = pk.getDb();
    String User = pk.getUser();
    String Pass = pk.getPass();
    
    public Conexion()throws IOException{
        
    }
    
    public Connection getConexion(){        
         Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+Server+"/"+DB,User,Pass); 
            
            }catch(SQLException ex){
                System.out.println("Error de MySql");
            }catch(ClassNotFoundException err){
                err.printStackTrace();
            }catch(Exception err){
                System.out.println("Se ha encontrado un error inesperado: "+err.getMessage());
            }
        return con;
    }    
}
