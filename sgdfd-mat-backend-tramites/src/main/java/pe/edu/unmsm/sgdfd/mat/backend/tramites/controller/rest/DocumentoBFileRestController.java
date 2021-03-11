package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.DocumentoBFile;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.documentobfile.DocumentoBFileService;

@Validated
@RestController
@RequestMapping("/documento-bfile")
public class DocumentoBFileRestController {

	private DocumentoBFileService documentoBFileService;
	
	public DocumentoBFileRestController(DocumentoBFileService documentoBFileService) {
		this.documentoBFileService = documentoBFileService;
	}
	
	@PostMapping("/")
	@PreAuthorize("hasPermission('CON_DOCUMENTO_BFILE','101')")
	public DocumentoBFile guardarDocumento(DocumentoBFile documentoBFile) {
		return documentoBFileService.guardarDocumento(documentoBFile);
	}
	
}
