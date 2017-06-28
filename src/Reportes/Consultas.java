package Reportes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {

private Connection con;
private ResultSet rs;//contenedor
private String consulta;

    public Consultas() throws IOException{
    
    }

    public Consultas(Connection c, String consulta_sql) {
        this.con = c;
        this.consulta = consulta_sql;
        try {
            Statement st = con.createStatement();
            this.rs = st.executeQuery(consulta_sql);
                 
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public ResultSet getResultado(){
        return this.rs;
    }   
    
}
