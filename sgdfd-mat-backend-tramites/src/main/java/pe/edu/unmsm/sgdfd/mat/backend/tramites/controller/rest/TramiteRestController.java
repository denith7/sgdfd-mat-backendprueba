package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.group.IRegistro;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.TramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.TramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramite.TramiteService;

/**
 * --
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los tramites
 * 	<li>Registrar un trámite
 * </ul>
 * 
 * @author Miguel Moya
 * @see TramiteRequest
 * @see TramiteResponse
 * @see TramiteService
 */
@Validated
@RestController
@RequestMapping("/tramites")
public class TramiteRestController {
	
	@Autowired
	private TramiteService tramiteService;

	/**
	 * Muestra una lista de todos los trámites.  
	 * @param --
	 * 			
	 * @param --
	 * @return	lista de trámites obtenidos por búsqueda son de tipo:
	 * 			{@link TramiteResponse}
	 */
	@GetMapping
	//@PreAuthorize("hasPermission('PRO_REG_SOLICITUD_TRAMITE','1')")
	@PreAuthorize("hasPermission('MAN_TRAMITE','101')")
    public List<TramiteResponse> buscarTodos(){
        return  tramiteService.buscarTodos();
    }

	/**
	 * Recibe petición de registro de trámite
	 * @param tramite
	 * 			el trámite a registrar
	 * @param --
	 * @return  trámite registrado
	 * 			{@link --}
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PreAuthorize("hasPermission('MAN_TRAMITE','201')")
	@ResponseStatus(code = HttpStatus.CREATED)
    public TramiteRequest registrarSolicitudTramite(@Validated({ IRegistro.class, Default.class }) @RequestBody TramiteRequest tramite){
        return tramiteService.registrarTramite(tramite);
    }

}
