package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.exportacion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.SubReportTmp;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.TramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.TramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.asincrono.AsyncFileService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramite.TramiteService;

public class TramiteExportacionController {
	private @Autowired TramiteService incomingVisaService;
	private @Autowired AsyncFileService asyncFileService;
	
	
	public ModelAndView exportarPorCriteriosTCR0(TramiteFilter criterioBusqueda) {
		 
		System.out.println(criterioBusqueda);
		
		long inicio = System.currentTimeMillis();
		
		//response.setContentType("application/zip");
		String zipFileName = "Reporte de Transacciones SwDmpLog.zip";
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", zipFileName);
		//response.setHeader(headerKey, headerValue);
		String baseXLSXFileName = "Reporte de Transacciones SwDmpLog";
		
		//ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());

		int size = 20000;
		int start = 0;
		int chunk = 0;

		List<Future<SubReportTmp>> futures = new ArrayList<>();
		List<TramiteResponse> subReportResult;
		
		/*do {
			CriterioPaginacion<TramiteFilter> criterioPaginacion = PaginacionUtil
					.getCriterioPaginacionParaReporteXLSX(criterioBusqueda, start, size);
			subReportResult = this.tnxsSwDmpLogService
					.filtrarTxnsSwDmpLogPaginado(criterioPaginacion);
			if (!subReportResult.isEmpty()) {
				futures.add(this.asyncFileService.generateXLSXChunkToZip(subReportResult, chunk, baseXLSXFileName,
						"reporteConsultaTransaccionesSwDmpLog", "reporte"));
			}
			start += size;
			chunk++;
		} while (!subReportResult.isEmpty());
		
		*/
		return null;
	}
}
