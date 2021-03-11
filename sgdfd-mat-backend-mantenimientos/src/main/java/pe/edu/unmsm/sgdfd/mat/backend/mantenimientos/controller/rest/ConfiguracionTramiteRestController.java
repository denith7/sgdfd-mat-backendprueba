package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.IdCadena;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.ConfiguracionTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.ConfiguracionTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.ConfiguracionTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.configuraciontramite.ConfiguracionTramiteService;


/**
 * Recibe las solicitudes relacionadas al mantenimiento de Tramites
 * ademas de incluir busquedas que retornen listas de acuerdo a diferentes atributos
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Búsqueda de una lista de Tramites por medio del identificador de tipo de trámite y codigo de local
 * </ul>
 * 
 * @author Eric Robladillo
 * @see ConfiguracionTramiteRequest
 * @see ConfiguracionTramiteResponse
 * @see ConfiguracionTramiteService
 */
@Validated
@RestController
@RequestMapping("/configuracion-tramites")
public class ConfiguracionTramiteRestController {

	private ConfiguracionTramiteService configuracionTramiteService;

	public ConfiguracionTramiteRestController(ConfiguracionTramiteService configuracionTramiteService) {
		this.configuracionTramiteService = configuracionTramiteService;
	}
	
	/**
	 * Retorna una lista de Tramites y que se identifiquen con el atributo:  
	 * @param idTipoTramite
	 * 			el identificador del tipo de tramite
	 * @param codigoLocal
	 * 			el codigo del local
	 * @param --
	 * @return	lista obtenida por busqueda de Tramites es de tipo:
	 * 			{@link TipoTramiteLocalRequisitoResponse}
	 */
	@GetMapping("/tipo-tramite/{idTipoTramite}/local/{codigoLocal}")
//	@PreAuthorize("hasPermission('PRO_CONFIGURACION_TRAMITE','101')")
	public ConfiguracionTramiteResponse buscarPorIdTipoTramiteYCodigoLocal(
			@PathVariable("idTipoTramite")@NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo")  Integer idTipoTramite
    		, @PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal  ){
		return configuracionTramiteService.buscarPorIdTipoTramiteYCodigoLocal(idTipoTramite, codigoLocal);
	}
	
	@PostMapping("/registro-tramite-local")
//	@PreAuthorize("hasPermission('PRO_CONFIGURACION_TRAMITE','101')")
	public ConfiguracionTramiteResponse registrarConfiguracionTramite (@RequestBody ConfiguracionTramiteRequest configuracionTramiteRequest){
		
		return configuracionTramiteService.registrarConfiguracionTramite(configuracionTramiteRequest);
	}
	
	@PostMapping("/tramites/filtrar")
	public List<ConfiguracionTramiteFilter> filtrarTramites(@RequestBody ConfiguracionTramiteFilter configuracionTramiteFilter){
		return configuracionTramiteService.filtrarTramites(configuracionTramiteFilter);
	}
}
