package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.asincrono;

import java.util.List;
import java.util.concurrent.Future;

import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.SubReportTmp;


public interface AsyncFileService {
	public Future<SubReportTmp> generateXLSXChunkToZip(List<?> subReport, 
			Integer chunk, String baseFileName, String templateName, String reportVarName) throws Exception;
}
