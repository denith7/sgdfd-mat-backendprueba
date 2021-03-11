package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.DestinoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.DestinoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.destino.DestinoService;

/**
 * --
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los destinos
 * 	<li>Registro de un destino
 * </ul>
 * 
 * @author Miguel Moya
 * @see DestinoRequest
 * @see DestinoResponse
 * @see DestinoService
 */
@Validated
@RestController
@RequestMapping("/destino")
public class DestinoRestController {

	private DestinoService destinoService;

	public DestinoRestController(DestinoService destinoService) {
		this.destinoService = destinoService;
	}
	
	/**
	 * Muestra una lista de todos los destinos.  
	 * @param --
	 * 			
	 * @param --
	 * @return	lista de destinos obtenidos por búsqueda son de tipo:
	 * 			{@link DestinoResponse}
	 */
	@GetMapping
	//@Secured({JWTConstants.ROLE_USER})
	@PreAuthorize("hasPermission('MAN_DESTINO','101')")
    public List<DestinoResponse> buscarTodos()
    {
        return destinoService.buscarTodos();
    }
	
	/**
	 * Recibe petición de registro de destino.  
	 * @param destinoRequest
	 * 			el destino a registrar
	 * @param --
	 * @return	destino registrado
	 * 			{@link DestinoRequest}
	 */
	@PostMapping
	@PreAuthorize("hasPermission('MAN_DESTINO','201')")
	public DestinoRequest registrarDestino(
	   @RequestBody DestinoRequest destinoRequest){
	    return destinoService.registrarDestino(destinoRequest);
	    }
}
