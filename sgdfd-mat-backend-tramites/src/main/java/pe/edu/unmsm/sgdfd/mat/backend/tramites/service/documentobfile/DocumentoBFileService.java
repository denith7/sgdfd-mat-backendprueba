package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.documentobfile;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.DocumentoBFile;

public interface DocumentoBFileService extends MantenibleService<DocumentoBFile, DocumentoBFile>{
	
	public DocumentoBFile guardarDocumento(DocumentoBFile documentoBFile);

}
