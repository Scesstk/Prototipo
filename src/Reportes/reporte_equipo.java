
package Reportes;

import Reportes.Conexion;
import Reportes.IntReportes;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author user
 */
public class reporte_equipo{
    
    private final String logotipo = "/Imagenes/logo.jpg";
    //private String path = "E:/ADSI 113/5 Trimestre/Proyecto Ultima Version/Prototipo 1.1/src/Reportes/Equipos.jasper";
    URL in = this.getClass().getResource("/Reportes/Equipos.jasper");
    // = (JasperReport) JRLoader.loadObject(in);
    
  
    
            
    public void reporteDocumento (String campodocumento){
        JasperReport jr = null;
        try {
            Map parametro = new HashMap();
            parametro.put("Doc",campodocumento);
            
            parametro.put("logot",this.getClass().getResourceAsStream(logotipo));
            //jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            jr = (JasperReport) JRLoader.loadObject(in);
            JasperPrint informe = JasperFillManager.fillReport(jr,parametro,new Conexion().getConexion());
            JasperViewer visor = new JasperViewer(informe,false); //para mostrar reportes;
            visor.setVisible(true);
            visor.setTitle("SCEES 1.0");
            } catch (JRException ex) {
            Logger.getLogger(IntReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }
    
   
}
    
    
    
