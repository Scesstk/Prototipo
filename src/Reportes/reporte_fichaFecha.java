package Reportes;


import java.util.Date;
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


public class reporte_fichaFecha  {
    
    
    JasperReport jr = null;
    private final String path = "E:/ADSI 113/5 Trimestre/Proyecto Ultima Version/Prototipo 1.1/src/Reportes/reporte_fichafecha.jasper";
    private final String logotipo = "/Imagenes/logo.jpg";
    
    java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat ("yyyy-MM-dd");
    String fechad;
    String fechah;

     
     public void reporteDocFecha(Date f1, Date f2, int entrada, int salida, int ficha){
         
        
         fechad = formato.format(f1);
        fechah = formato.format(f2);
       
        try {
            Map formulario = new HashMap();
            
            formulario.put("fechad",fechad);
            
            formulario.put("fechah",fechah);
            
            formulario.put("tipoentrada",entrada);
            
            formulario.put("tiposalida",salida);
            
             formulario.put("ficha",ficha);
           
            formulario.put("logo",this.getClass().getResourceAsStream(logotipo));
            
            jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint informe = JasperFillManager.fillReport(jr,formulario,new Conexion().getConexion());
            
            JasperViewer visor = new JasperViewer(informe,false); //para mostrar reportes;
            
            visor.setVisible(true);
            
            visor.setTitle("SCEES 1.0");
            
        } catch (JRException ex) {
            Logger.getLogger(IntReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}

