package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.IdCadena;
import pe.edu.unmsm.commons.validation.validation.IdNumerico;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.TipoTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RemitoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteFiltroRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.TipoTramiteService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de Tipos de Tramite,
 * ademas de incluir busquedas de listas por medio de diferentes atributos 
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los tipos de trámite
 * 	<li>Búsqueda de una lista de tipos de trámite por identificador de Tupa
 *  <li>Búsqueda de una lista de tipos de trámite por identificador de tipo de trámite
 * 	<li>Registro de un tipo de trámite
 * 	<li>Actualización de un tipo de trámite
 * 	<li>Eliminación	 de un tipo de trámite
 *  <li>Búsqueda de una lista de tipos de trámite por medio del código de local
 *  <li>Búsqueda de una lista de tipos de trámite por filtro
 *  <li>Búsqueda de una lista de tipos de trámite por medio de código del local y por indentificador de Tupa
 *  <li>Búsqueda de una lista de tipos de trámite por medio de la url del tipo de trámite
 * </ul>
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see TipoTramiteRequest
 * @see TipoTramiteResponse
 * @see TipoTramiteService
 */
@Validated
@RestController
@RequestMapping("/tipos-tramite")
public class TipoTramiteRestController {
	
	@Autowired
	private TipoTramiteService tipoTramiteService;
	
	/**
	 * Retorna una lista con todos los tipos de trámite.  
	 * 
	 * @return	lista de tipos de trámite obtenida por búsqueda es de tipo:
	 * 			{@link TipoTramiteResponse}
	 */
	@GetMapping
//	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE','101')")
	//comentado para mantenimiento tramite
//	@PreAuthorize("hasPermission('MAN_TIPOS_TRAMITE','200')")
	public List<TipoTramiteResponse> buscarTodos() {
		return tipoTramiteService.buscarTodos();
	}
	
	/**
	 * Retorna una lista de tipos de trámite que será buscada por atributo:  
	 * @param indicadorTupa
	 * 			el identificador de Tupa
	 * @param --
	 * @return	lista de tipos de trámite obtenida por búsqueda es de tipo:
	 * 			{@link TipoTramiteResponse}
	 */
	@GetMapping(value = "/tupa/{indicadorTupa}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE','102')")
	public List<TipoTramiteResponse> buscarPorIndicadorTupa(@PathVariable Boolean indicadorTupa) {
		return tipoTramiteService.buscarTodos().stream().filter(e->e.getIndicadorTupa().equals(indicadorTupa)).collect(Collectors.toList());
	}
	
	/**
	 * Retorna un tipo de trámite buscado por atributo:  
	 * @param idTramite
	 * 			el identificador del tipo de trámite
	 * @param --
	 * @return	tipo de trámite obtenido por búsqueda:
	 * 			{@link TipoTramiteResponse}
	 */
	@GetMapping(value = "/{idTramite}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE','103')")
//	@PreAuthorize("hasPermission('MAN_TIPOS_TRAMITE','200')")
	public TipoTramiteResponse buscarPorIdTiposTramite(@IdNumerico(maxRange = 99) @PathVariable int idTramite) {
		return tipoTramiteService.buscarPorIdTipoTramite(idTramite);
	}
	
	/**
	 * Retorna una lista de tipos de trámite, será buscada por atributo:  
	 * @param codigoLocal
	 * 			el código del local
	 * @param --
	 * @return	lista obtenida de tipos de trámite es de tipo:
	 * 			{@link TipoTramiteResponse}
	 */
	@GetMapping(value = "/local/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE','104')")
	public List<TipoTramiteResponse> buscarPorCodigoLocal(
			@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal) {
		return tipoTramiteService.buscarPorCriterio(TipoTramiteFilter.builder()
				.codigoLocal(codigoLocal).build());
	}
	
	
	/**
	 * Retorna una lista de tipos de trámite filtrados por atributo:  
	 * @param codigoLocal
	 * 			el código del local
	 * @param --
	 * @return	lista obtenida de tipos de trámite es de tipo:
	 * 			{@link TipoTramiteResponse}
	 */
	@PostMapping(value = "/local/{codigoLocal}/filtrar")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE','105')")
	public List<TipoTramiteLocalResponse> buscarFiltroTramite(
			@Valid @RequestBody TipoTramiteFiltroRequest tipoTramiteFiltroRequest,
			@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal) {
		tipoTramiteFiltroRequest.setCodigoLocal(codigoLocal);
		return tipoTramiteService.buscarFiltroTramite(tipoTramiteFiltroRequest);
	}
	
	/**
	 * Retorna una lista de tipos de trámite, será buscada por atributo:  
	 * @param codigoLocal
	 * 			el código del local
	 * @param indicadorTupa
	 * 			el identificador de Tupa
	 * @param --
	 * @return	lista obtenida de tipos de trámite es de tipo:
	 * 			{@link TipoTramiteResponse}
	 */
	@GetMapping(value = "/local/{codigoLocal}/tupa/{indicadorTupa}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE','106')")
	public List<TipoTramiteResponse> buscarPorCodigoLocalYIndicadorTupa(
			@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal
		   ,@PathVariable @Size(min = 1, max = 200) String indicadorTupa) {
		return tipoTramiteService.buscarPorCriterio(TipoTramiteFilter.builder()
				.codigoLocal(codigoLocal)
				.indicadorTupa(indicadorTupa).build());
	}
	
	/**
	 * Retorna una lista de tipos de trámite, será buscada por la url del tipo de tramite:  
	 * @param urlTipoTramite
	 * 			el url del tipo de trámite
	 * @param --
	 * @return	lista obtenida de tipos de trámite es de tipo:
	 * 			{@link TipoTramiteResponse}
	 */
	@GetMapping(value = "/url/{urlTipoTramite}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE','107')")
	public List<TipoTramiteResponse> buscarPorUrl(
				@PathVariable @Size(min = 1, max = 200) String urlTipoTramite) {
		return tipoTramiteService.buscarPorCriterio(TipoTramiteFilter.builder()
				.nombreUrl(urlTipoTramite).build());
	}
	
	/**
	 * Recibe petición de registro de un tipo de trámite.  
	 * @param tipoTramiteRequest
	 * 			el tipo de trámite a registrar
	 * @param --
	 * @return	tipo de trámite registrado
	 * 			{@link TipoTramiteResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE','201')")
	@ResponseStatus(code = HttpStatus.CREATED)
	public TipoTramiteResponse registrarTipoTramite(@Valid @RequestBody TipoTramiteRequest tipoTramiteRequest) {
		return tipoTramiteService.registrarTipoTramite(tipoTramiteRequest);
	}
	
	
	/**
	 * Recibe petición de actualización de un tipo de trámite.  
	 * @param idTramite
	 * 			el identificador del tipo de trámite
	 * @param tipoTramiteRequest
	 * 			el tipo de trámite a actualizar
	 * @param --
	 * @return	tipo de trámite actualizado
	 * 			{@link TipoTramiteResponse}
	 */
	@PutMapping(value = "/{idTramite}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE','301')")
	public TipoTramiteResponse actualizarTipoTramite(
			   @PathVariable @IdNumerico(maxRange = 999999) Integer idTramite
			, @Valid @RequestBody TipoTramiteRequest tipoTramiteRequest) {
		return tipoTramiteService.actualizarTipoTramite(idTramite, tipoTramiteRequest);
	}
	
	
	/**
	 * Recibe petición de eliminación de un tipo de trámite.  
	 * @param idTramite
	 * 			el identificador del tipo de trámite
	 * @param --
	 * 		
	 */
	@DeleteMapping(value = "/{idTramite}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE','401')")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTipoTramite(@IdNumerico(maxRange = 999999) @PathVariable int idTramite) {
		tipoTramiteService.eliminarTipoTramite(idTramite);
	}
	
	
	
	// Se copiaron a Tipo tramite local
	
	//Update: se actualizó en frontend con los nuevos endpoints. Omitir
	
//	@GetMapping(value = "/url/{urlTipoTramite}/codigo-local/{codigoLocal}")
//	@PreAuthorize("hasPermission('CON_TIPO_TRAMITE','108')")
//	public TipoTramiteLocalResponse buscarPorUrlYLocal(@PathVariable String urlTipoTramite, @PathVariable String codigoLocal) {
//		return tipoTramiteService.buscarPorUrlYLocal(TipoTramiteFilter.builder()
//				.nombreUrl(urlTipoTramite).codigoLocal(codigoLocal).build());
//	}
//	
//	@GetMapping(value = "/url/{nombreUrl}/codigo-local/{codigoLocal}/codigo-escuela/{codigoEscuela}")
//	@PreAuthorize("hasPermission('CON_TIPO_TRAMITE','109')")
//	public TipoTramiteLocalResponse buscarPorUrlYLocalYEscuela(@PathVariable String nombreUrl, @PathVariable String codigoLocal, @PathVariable String codigoEscuela) {
//		return tipoTramiteService.buscarPorUrlYLocalYEscuela( nombreUrl,codigoLocal,codigoEscuela);
//	}
	
	//Revisar Erick
//	Update: Se cambió el endpoint de la consulta /empleado... al usado en remitos, CON 110 aparentemente no usada. Omitir
//	
//	@GetMapping(value = "/{idTipoTramite}/local/{codigoLocal}")
//	@PreAuthorize("hasPermission('CON_TIPO_TRAMITE','110')")
//	public RemitoTramiteResponse buscarPorTramiteYLocal(@PathVariable Integer idTipoTramite,@PathVariable String codigoLocal) {
//		return tipoTramiteService.buscarPorTramiteYLocal(idTipoTramite, codigoLocal);
//	}
//	
//	@GetMapping(value = "/empleado/{numeroDni}/tramite/{idTipoTramite}")
//	@PreAuthorize("hasPermission('CON_TIPO_TRAMITE','111')")
//	public RemitoTramiteResponse buscarTramitePorEmpleadoYTipo(@PathVariable String numeroDni, @PathVariable Integer idTipoTramite) {
//		return tipoTramiteService.buscarTramitePorEmpleadoYTipo(numeroDni, idTipoTramite);
//	}
	
}
