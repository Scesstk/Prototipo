/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectBD;

/**
 *
 * @author FGALLARDO
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;


public class Propiedades {
    
    public Propiedades(){
        
    }
          
    String result = "";
    InputStream inputStream;
    
    public String getServer() throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "Config/config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 			result = prop.getProperty("server");
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
    
    public String setServer(String Server) throws IOException{
        
        return null;
    }
    
    public String getDb() throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "Config/config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 			// get the property value and print it out
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
 
			result = prop.getProperty("db");
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
    }
    
    public String setDb(String Db) throws IOException{
        
        return null;
    }
    
    public String getUser() throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "Config/config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			result = prop.getProperty("user");
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
    }
    
    public String setUser(String User) throws IOException{
        
        return null;
    }
    
    public String getPass() throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "Config/config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 			result = prop.getProperty("password");
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
    }
    
    public String setPass(String Password) throws IOException{
        
        return null;
    }
    
    
}
