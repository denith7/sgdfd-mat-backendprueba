package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.asincrono;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Future;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jxls.area.Area;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.transform.poi.PoiTransformer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.commons.util.StringsUtils;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.SubReportTmp;

@Service
public class AsyncFileServiceImpl implements AsyncFileService{
	public static final String RUTA_REPORTE_XLSX = "xlsx/";
	public static final String EXTENSION_XLSX = ".xlsx";

	@Async("taskExecutor")
	public Future<SubReportTmp> generateXLSXChunkToZip(List<?> subReport,
			Integer chunk, String baseFileName, String templateName, String reportVarName) throws Exception {		
		System.out.println("Start Chunk " + chunk);
		InputStream stream = getClass().getClassLoader().getResourceAsStream(StringsUtils.unirConSeparador(
				RUTA_REPORTE_XLSX, templateName, EXTENSION_XLSX,""));
		Workbook workbook = WorkbookFactory.create(stream);
		Transformer transformer = PoiTransformer.createSxssfTransformer(workbook, 10, true);
		AreaBuilder areaBuilder = new XlsCommentAreaBuilder(transformer);
		List<Area> xlsAreaList = areaBuilder.build();
		Area xlsArea = xlsAreaList.get(0);
		Context context = new Context();
		context.getConfig().setIsFormulaProcessingRequired(false);
		context.putVar(reportVarName, subReport);
		xlsArea.applyAt(new CellRef("Result!A1"), context);  
		workbook.setActiveSheet(1);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		((PoiTransformer) transformer).getWorkbook().write(bos);
		SubReportTmp subReportTmp = new SubReportTmp();
		//subReportTmp.setBos(bos);
		//subReportTmp.setFileName(baseFileName + "-" + (chunk+1) + ".xlsx");
		System.out.println("End Chunk " + chunk);
		return new AsyncResult<>(subReportTmp);
	}
	
}
	
	