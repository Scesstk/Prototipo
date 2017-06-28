
package Reportes;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class reporte_ficha {
    
    private final String logotipo = "/Imagenes/logo.jpg";
    URL in = this.getClass().getResource("/Reportes/reporte_ficha.jasper");
   // private final String path = "E:/ADSI 113/5 Trimestre/Proyecto Ultima Version/Prototipo 1.1/src/Reportes/reporte_ficha.jasper";
    
    IntReportes repor = new IntReportes();
    
     public void reporteFicha (int campficha) throws IOException{
         
        JasperReport jr;
        try {
            Map parametro = new HashMap();
            parametro.put("numficha",campficha);
            parametro.put("logo",this.getClass().getResourceAsStream(logotipo));
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
