package Reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    public Connection getConexion(){        
         Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/scess","root",""); 
            
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
