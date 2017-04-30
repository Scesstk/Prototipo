
package Reportes;

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
    
  
    
            
    public void reporteDocumento (String campodocumento, String camposerie){
        JasperReport jr = null;
        try {
            Map parametro = new HashMap();
            parametro.put("Doc",campodocumento);
            parametro.put("Serial", camposerie);
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
    
    /*public void reporteFecha (Date desde,Date hasta){
        //int TipoRegistro = 0;    
        fechad = formato.format(desde);
        fechah = formato.format(hasta);
        
        /*if(Entrada.isSelected()){
            TipoRegistro = 1;
        }else if (Salida.isSelected()){
            TipoRegistro = 2;
        }
        
        JasperReport jr = null;
        try {
            
            Map parametro = new HashMap();
            parametro.put("fechadesde",fechad);
            parametro.put("fechahasta",fechah);
            parametro.put("logo",this.getClass().getResourceAsStream(logotipo));
            //parametro.put("Entrada_Salida",TipoRegistro);            
            jr = (JasperReport) JRLoader.loadObjectFromFile(path2);
            JOptionPane.showMessageDialog(null,parametro);
            JasperPrint informe = JasperFillManager.fillReport(jr,parametro,new Conexion().getConexion());
             
            JasperViewer visor = new JasperViewer(informe,false); //para mostrar reportes;
            visor.setVisible(true);
            visor.setTitle("SENA MEJOR SABER");
            } catch (JRException ex) {
            Logger.getLogger(IntReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }*/
}
    
    
    
