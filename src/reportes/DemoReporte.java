package reportes;

import Clases.Conexion;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;
 
public class DemoReporte {
 
	public static void llamarReporte(int num_facturaPara) throws JRException {
            
            
            
            
            
            HashMap hm = new HashMap();
            hm.put("numFacPara",num_facturaPara);
		// descarga dentro del mismo proyecto
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				"C:\\Users\\JAZMIN\\JaspersoftWorkspace\\MyReports\\reporteFacturaFinal .jasper", hm,
				Conexion.conectar());
		JRPdfExporter exp = new JRPdfExporter();
		exp.setExporterInput(new SimpleExporterInput(jasperPrint));
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput("reportFactura.pdf"));
		SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
		exp.setConfiguration(conf);
		exp.exportReport();
 
		// se muestra en una ventana aparte para su descarga
		JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
				"C:\\Users\\JAZMIN\\JaspersoftWorkspace\\MyReports\\reporteFacturaFinal .jasper", hm,
				Conexion.conectar());
		JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
		jasperViewer.setVisible(true);
	}
}