package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.documentobfile;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.DocumentoBFileMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.DocumentoBFile;

@Service
@Transactional
public class DocumentoBFileServiceImpl extends MantenibleAuditadoService<DocumentoBFile, DocumentoBFile> implements DocumentoBFileService {

	private DocumentoBFileMapper documentoBFileMapper;
	
	public DocumentoBFileServiceImpl(@Qualifier("documentoBFileMapper") MantenibleMapper<DocumentoBFile, DocumentoBFile> mapper) {
		super(mapper);
		this.documentoBFileMapper = (DocumentoBFileMapper) mapper;
	}
	
	@Override
	public DocumentoBFile guardarDocumento(DocumentoBFile documentoBFile) {
		documentoBFileMapper.mantener("GUARDAR", documentoBFile, "Dummy");
		return documentoBFile;
	}

	
	
}
