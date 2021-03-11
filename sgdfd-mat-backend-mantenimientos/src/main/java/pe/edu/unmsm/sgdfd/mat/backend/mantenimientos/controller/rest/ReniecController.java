package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.anotacion.Audit;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.enumeracion.Accion;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.enumeracion.Comentario;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.enumeracion.Dato;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.aspecto.enumeracion.Tipo;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.ReniecResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.ws.ReniecService;



@Audit(tipo = Tipo.RENIEC, datos = Dato.RENIEC)
@RestController
@RequestMapping("/api/reniec")
public class ReniecController {

private @Autowired ReniecService reniecService;
	
	/**
	 * Recibe las peticiones para consulta de datos generales de una persona al
	 * RENIEC
	 * 
	 * @param numeroDNI Numero de Documento de Identidad
	 * 
	 * @return lista de {@link ReniecResponse}
	 * 
	 */
	@Audit(accion = Accion.CONSULTA, comentario = Comentario.CONSULTA_POR_ID)
	@GetMapping("/{numeroDNI}")
	@PreAuthorize("hasPermission('PRO_RENIEC','501')")
	public ReniecResponse buscarPorNumeroDNI(@PathVariable String numeroDNI) {
		return reniecService.buscarPorNumeroDNI(numeroDNI);
	}
}
