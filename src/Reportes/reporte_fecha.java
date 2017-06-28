
package Reportes;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static mondrian.olap.fun.vba.Vba.date;
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
public class reporte_fecha {
    
   
    //JasperReport jr = null; private String path = "E:/ADSI 113/5 Trimestre/Proyecto Ultima Version/Prototipo 1.1/src/Reportes/fechas.jasper";
    URL in = this.getClass().getResource("/Reportes/fechas.jasper");
    private final String logotipo = "/Imagenes/logo.jpg";
    
    java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat ("yyyy-MM-dd");
    String fechad;
    String fechah;
    

  
     
     public void reporte(Date f1, Date f2, int entrada, int salida) throws IOException{
         
        
        fechad = formato.format(f1);
        fechah = formato.format(f2);
       
        try {
            Map formulario = new HashMap();
            
            formulario.put("fechad",fechad);
            
            formulario.put("fechah",fechah);
            
            formulario.put("tipoentrada",entrada);
            
            formulario.put("tiposalida",salida);
           
            formulario.put("logo",this.getClass().getResourceAsStream(logotipo));
            //LINEA PARA QUITAR RUTA ABSOLUTA
            JasperReport jr = (JasperReport) JRLoader.loadObject(in);
            
            JasperPrint informe = JasperFillManager.fillReport(jr,formulario,new Conexion().getConexion());
            
            JasperViewer visor = new JasperViewer(informe,false); //para mostrar reportes;
            
            visor.setVisible(true);
            
            visor.setTitle("SCEES 1.0");
            
        } catch (JRException ex) {
            Logger.getLogger(IntReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
