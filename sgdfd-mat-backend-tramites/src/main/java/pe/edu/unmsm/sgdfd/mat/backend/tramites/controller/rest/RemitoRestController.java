package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.RemitoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.RemitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.RemitoTramitResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.remito.RemitoService;

/**
 * --
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los remito
 * 	<li>Registro de un remito
 * </ul>
 * 
 * @author Miguel Moya
 * @author Eric Robladillo
 * @see RemitoRequest
 * @see RemitoResponse
 * @see RemitoService
 */
@Validated
@RestController
@RequestMapping("/remitos")
public class RemitoRestController {

	private RemitoService remitoService;

	public RemitoRestController(RemitoService remitoService) {
		this.remitoService = remitoService;
	}
	
	/**
	 * Muestra una lista de todos los remito
	 * @return	lista de remito obtenidos por búsqueda son de tipo:
	 * 			{@link RemitoResponse}
	 */
	@GetMapping
	@PreAuthorize("hasPermission('PRO_REMITO','101')")
    public List<RemitoResponse> buscarTodos()
    {
        return remitoService.buscarTodos();
    }
	
	@GetMapping(value = "/empleado/{numeroDni}/tipo-tramite/{idTipoTramite}")
	@PreAuthorize("hasPermission('PRO_REMITO','102')")
	public RemitoTramitResponse buscarTramitePorEmpleadoYTipo(@PathVariable String numeroDni, @PathVariable Integer idTipoTramite) {
		return remitoService.buscarTramitePorEmpleadoYTipo(numeroDni, idTipoTramite);
	}
	
	/**
	 * Recibe petición de registro de remito.  
	 * @param remitoRequest
	 * 			el remito a registrar
	 * @return	remito registrado
	 * 			{@link --}
	 */
	@PostMapping
	@PreAuthorize("hasPermission('PRO_REMITO','501')")
	public RemitoRequest registrarRemito(
			 @RequestBody RemitoRequest remitoRequest){
        return remitoService.registrarRemito(remitoRequest);
    }
	
}
