package ConnectBD;

/**
 *
 * @author FGALLARDO
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class Propiedades {
    
    public Propiedades(){
        
    }
          
    String result = "";
    InputStream inputStream;
    OutputStream outputStream;
    Properties prop = new Properties();
    String propFileName = "Config/config.properties";
    String outFileName = "resources/Config/config.properties";
            
 
    
    public String getServer() throws IOException {
        try {
            
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            
            if (inputStream != null) {
                prop.load(new FileReader("resources/Config/config.properties"));
            } else {
		throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            result = prop.getProperty("server");
            } catch (Exception e) {
		System.out.println("Exception: " + e);
            } finally {
		inputStream.close();
            }
	return result;
    }
    
    public String setServer(String Server) throws IOException{
        try {
            
            outputStream = new FileOutputStream(outFileName);
 
            prop.setProperty("server", Server);

            } catch (Exception e) {
		System.out.println("Exception: " + e);
            } finally {
		inputStream.close();
            }
        return null;
    }
    
    public String getDb() throws IOException {
 
	try {
            
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
            if (inputStream != null) {
                prop.load(new FileReader("resources/Config/config.properties"));
            } else {
		throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            result = prop.getProperty("db");

            } catch (Exception e) {
		System.out.println("Exception: " + e);
            } finally {
		inputStream.close();
            }
	return result;
    }
    
    public String setDb(String Db) throws IOException{
        try {
        
            outputStream = new FileOutputStream(outFileName);
 
            prop.setProperty("db", Db);
           
            } catch (Exception e) {
		System.out.println("Exception: " + e);
            } finally {
		inputStream.close();
            }
        return null;
    }
    
    public String getUser() throws IOException {
 
	try {
            
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
            if (inputStream != null) {
		prop.load(new FileReader("resources/Config/config.properties"));
            } else {
		throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            result = prop.getProperty("user");

            } catch (Exception e) {
		System.out.println("Exception: " + e);
            } finally {
		inputStream.close();
            }
	return result;
    }
    
    public String setUser(String User) throws IOException{
        try {
        
            outputStream = new FileOutputStream(outFileName);
 
            prop.setProperty("user", User);
            
            } catch (Exception e) {
		System.out.println("Exception: " + e);
            } finally {
		inputStream.close();
            }
        return null;
    }
    
    public String getPass() throws IOException {
 
	try {
            
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
            if (inputStream != null) {
		prop.load(new FileReader("resources/Config/config.properties"));
            } else {
		throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            result = prop.getProperty("password");

            } catch (Exception e) {
		System.out.println("Exception: " + e);
            } finally {
		inputStream.close();
            }
        return result;
    }
    
    public String setPass(String Password) throws IOException{
        try {
            
            outputStream = new FileOutputStream(outFileName);
 
            prop.setProperty("password", Password);
            
            } catch (Exception e) {
		System.out.println("Exception: " + e);
            } finally {
		inputStream.close();
            }
        return null;
    }
    
    public String store()throws IOException{
        prop.store(outputStream, null);
        return null;
    }
    
    
}
