package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

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
//import pe.edu.unmsm.sgd.api.service.excepcion.BadRequestException;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.id.TipoTramiteLocalId;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteLocalRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.local.TipoTramiteLocalService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de Locales en donde estarán disponibles cada tipo de tramite,
 * ademas de incluir busquedas de listas por medio de diferentes atributos 
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los locales donde se encuentren disponibles cada tipo de tramite
 * <li>Búsqueda de un local donde se encuentre disponible un tipo de tramite por medio del identificador de trámite y por el código de local
 * 	<li>Búsqueda de una lista con los locales en donde se encuentren disponible un tipo de tramite por medio del identificador de tipo de trámite
 *  <li>Búsqueda de una lista con el local buscado y todos los tipos de tramites pertenecientes a este por medio del identificador de local
 * 	<li>Registro de un local en donde estará disponible un tipo de trámite
 * 	<li>Actualización de un local en donde está disponible un tipo de trámite
 *  <li>Actualización del estado de un local donde este disponible un tipo de trámite
 * 	<li>Eliminación	de un local donde está disponible un tipo de trámite
 *  <li>Búsqueda de un local en donde está disponible un tipo de trámite por medio de la url del tipo de tramite y el código de local
 *  <li>Búsqueda de un local en donde está disponible un tipo de trámite por medio de la url del tipo de tramite, el código de local y código de escuela 
 * </ul>
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see TipoTramiteLocalRequest
 * @see TipoTramiteLocalResponse
 * @see TipoTramiteLocalService
 */
@Validated
@RestController
@RequestMapping("/tipos-tramite-locales")
public class TipoTramiteLocalRestController {
	
	private TipoTramiteLocalService tipoTramiteLocalService;

	public TipoTramiteLocalRestController(TipoTramiteLocalService tipoTramiteLocalService) {
		this.tipoTramiteLocalService = tipoTramiteLocalService;
	}
	
	/**
	 * Retorna una lista con todos los locales que tengan disponible cada tipo de tramite.  
	 * 
	 * @return	lista buscada de locales donde estan disponibles cada tipo de trámite, esta es de tipo:
	 * 			{@link TipoTramiteLocalResponse}
	 */
	@GetMapping
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL','101')")
    public List<TipoTramiteLocalResponse> buscarTodos(){
        return tipoTramiteLocalService.buscarTodos();
    }
	
	/**
	 * Retorna un local donde esté disponible un tipo de trámite, será buscado por atributo:  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param codigoLocal
	 * 			el código de local
	 * @param --
	 * @return	local donde esté disponible el tipo de tramite:
	 * 			{@link TipoTramiteLocalResponse}
	 */
	@GetMapping("/{idTipoTramite}/locales/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL','102')")
    public TipoTramiteLocalResponse buscarPorIdTipoTramiteYCodigoLocal(
    		@PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite
    		, @PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal)
    {
        return tipoTramiteLocalService.buscarPorIdTipoTramiteYCodigoLocal(TipoTramiteLocalId.builder()
        		.idTipoTramite(idTipoTramite)
        		.codigoLocal(codigoLocal)
        		.build());
    }
	
	/**
	 * Retorna una lista de locales en donde esté disponible un tipo trámite, será buscada por atributo:  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param --
	 * @return	lista buscada de locales en donde esté disponible el tipo de trámite, esta es de tipo:
	 * 			{@link TipoTramiteLocalResponse}
	 */
	@GetMapping("/{idTipoTramite}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL','103')")
    public List<TipoTramiteLocalResponse>  buscarPorIdTipoTramite(
    		@PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite )
    {
        return tipoTramiteLocalService.buscarPorIdTipoTramite(TipoTramiteLocalId.builder()
        		.idTipoTramite(idTipoTramite)
//        		.codigoLocal(codigoLocal)
        		.build());
    }
	
	/**
	 * Retorna una lista con el local buscado y con cada tipo de trámite disponible en este, será buscada por atributo:  
	 * @param codigoLocal
	 * 			el código del local
	 * @param --
	 * @return	lista buscada con el local y los tipos de tramite disponibles en este, será de tipo:
	 * 			{@link TipoTramiteLocalResponse}
	 */
	@GetMapping("/locales/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL','104')")
    public List<TipoTramiteLocalResponse>  buscarPorCodigoLocal(
    		@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal )
    {
        return tipoTramiteLocalService.buscarPorCodigoLocal(TipoTramiteLocalId.builder()
//        		.idTipoTramite(idTipoTramite)
        		.codigoLocal(codigoLocal)
        		.build());
    }
	
    /**
	 * Retorna un local donde esté disponible un tipo de trámite, será buscado por atributo:  
	 * @param urlTipoTramite
	 * 			el url del tipo de trámite
	 * @param codigoLocal
	 * 			el código del local
	 * @param --
	 * @return	local buscado donde está disponible el tipo de trámite:
	 * 			{@link TipoTramiteLocalResponse}
	 */
	@GetMapping(value = "/url/{urlTipoTramite}/codigo-local/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL','105')")
	public TipoTramiteLocalResponse buscarPorUrlYLocal(
				@PathVariable @Size(min = 1, max = 200) String urlTipoTramite, 
				@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal) {
		return tipoTramiteLocalService.buscarPorUrlYLocal(TipoTramiteFilter.builder()
				.nombreUrl(urlTipoTramite).codigoLocal(codigoLocal).build());
	}
	
	/**
	 * Retorna un local donde esté disponible un tipo de trámite, será buscado por atributo:  
	 * @param nombreUrl
	 * 			el url del tipo de trámite
	 * @param codigoLocal
	 * 			el código del local
	 * @param codigoEscuela
	 * 			el código de la escuela
	 * @param --
	 * @return	local buscado donde está disponible el tipo de trámite:
	 * 			{@link TipoTramiteLocalResponse}
	 */
	@GetMapping(value = "/url/{nombreUrl}/codigo-local/{codigoLocal}/codigo-escuela/{codigoEscuela}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL','106')")
	public TipoTramiteLocalResponse buscarPorUrlYLocalYEscuela(
			@PathVariable @Size(min = 1, max = 200) String nombreUrl, 
			@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal, 
			@PathVariable String codigoEscuela) {
		return tipoTramiteLocalService.buscarPorUrlYLocalYEscuela( nombreUrl,codigoLocal,codigoEscuela);
	}
	
	/**
	 * Recibe petición de registro de un local en donde estará disponible un tipo de trámite.  
	 * @param tipoTramiteLocalRequest
	 * 			el tipo trámite local a registrar
	 * @param --
	 * @return	local registrado donde estará disponible un tipo de trámite
	 * 			{@link TipoTramiteLocalResponse}
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL','201')")
	@ResponseStatus(code = HttpStatus.CREATED)
    public TipoTramiteLocalResponse registrarTipoTramiteLocal(
    		@Valid @RequestBody TipoTramiteLocalRequest tipoTramiteLocalRequest){    
        return tipoTramiteLocalService.registrarTipoTramiteLocal(tipoTramiteLocalRequest);
    }
	
	/**
	 * Recibe petición de actualización de un local donde está disponible un tipo de trámite.  
	 * @param codigoLocal
	 * 			el identificador del tipo de trámite
	 * @param idLocal
	 * 			el código del local 
	 * @param tipoTramiteLocalRequest
	 * 			el local a actualizar donde está disponible un tipo de trámite
	 * @param --
	 * @return	local actualizado donde está disponible un tipo de trámite
	 * 			{@link TipoTramiteLocalResponse}
	 */
    @PutMapping(value = "/{idTipoTramite}/locales/{codigoLocal}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL','301')")
    public TipoTramiteLocalResponse actualizarTipoTramiteLocal( 
    		@IdNumerico(maxRange = 99999) @PathVariable("idTipoTramite") Integer idTipoTramite
    				, @PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal
    				, @Valid @RequestBody TipoTramiteLocalRequest tipoTramiteLocalRequest)
    {      
        return tipoTramiteLocalService.actualizarTipoTramiteLocal(
        		TipoTramiteLocalId.builder().codigoLocal(codigoLocal).idTipoTramite(idTipoTramite).build()
        		,tipoTramiteLocalRequest);
    }
    
    
    /**
	 * Recibe petición de actualización de estado de local donde está disponible un tipo de trámite.  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param codigoLocal
	 * 			el código del local 
	 * @param tipoTramiteLocalRequest
	 * 			el local a actualizar donde está disponible un tipo de trámite
	 * @param --
	 * @return	local actualizado donde está disponible un tipo de trámite
	 * 			{@link TipoTramiteLocalResponse}
	 */
    @PutMapping(value = "/{idTipoTramite}/locales/{codigoLocal}/actualizar-estado", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL','302')")
    public TipoTramiteLocalResponse actualizarEstadoTipoTramiteLocal( 
    		@IdNumerico(maxRange = 99999) @PathVariable("idTipoTramite") Integer idTipoTramite
    				, @PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal
    				, @Valid @RequestBody TipoTramiteLocalRequest tipoTramiteLocalRequest)
    {
        return tipoTramiteLocalService.actualizarEstadoTipoTramiteLocal(
        		TipoTramiteLocalId.builder().codigoLocal(codigoLocal).idTipoTramite(idTipoTramite).build()
        		,tipoTramiteLocalRequest);
    }
    
    
    /**
	 * Recibe petición de eliminación de un local donde está disponible un tipo de trámite.  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param codigoLocal
	 * 			el código del local
	 * @param --
	 * 		
	 */
    @DeleteMapping("/{idTipoTramite}/locales/{codigoLocal}")
    @PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL','401')")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarTipoTramiteLocal(
    		  @PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite
    		, @PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal)
    {
    	tipoTramiteLocalService.eliminarTipoTramiteLocal(TipoTramiteLocalId.builder()
    			.codigoLocal(codigoLocal)
    			.idTipoTramite(idTipoTramite)
    			.build());
    }
	
}
