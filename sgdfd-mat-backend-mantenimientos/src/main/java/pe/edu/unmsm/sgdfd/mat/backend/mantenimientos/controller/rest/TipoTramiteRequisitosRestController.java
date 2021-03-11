package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import pe.edu.unmsm.sgd.api.service.excepcion.BadRequestException;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.id.TipoTramiteRequisitoId;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteRequisitoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.requisito.TipoTramiteRequisitoService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de Requisitos pertenecientes a cada tipo de tramite,
 * ademas de incluir busquedas por diferentes atributos que retornaran o una lista o un Requisito de un Tipo de Tramite
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los requisitos pertenecientes a cada tipo de trámite
 * 	<li>Búsqueda de un requisito perteneciente a un tipo de trámite mediante el identificador de tipo de trámite e identificador de requisito
 *  <li>Búsqueda de una lista de requisitos pertenecientes a un tipo de trámite mediante el identificador de trámite
 * 	<li>Registro de un requisito perteneciente a un tipo de trámite 
 * 	<li>Actualización de un requisito perteneciente a un tipo de trámite
 * 	<li>Actualización del estado de un requisito perteneciente a un tipo de trámite 
 * 	<li>Eliminación	de un requisito perteneciente a un tipo de trámiteito
 * </ul>
 * 
 * @author Miguel Moya
 * @see TipoTramiteRequisitoRequest
 * @see TipoTramiteRequisitoResponse
 * @see TipoTramiteRequisitoService
 */
@Validated
@RestController
@RequestMapping("/tipo-tramite-requisitos")
public class TipoTramiteRequisitosRestController {
	
	private TipoTramiteRequisitoService tipoTramiteRequisitoService;

	public TipoTramiteRequisitosRestController(TipoTramiteRequisitoService tipoTramiteRequisitoService) {
		this.tipoTramiteRequisitoService = tipoTramiteRequisitoService;
	}
	
	/**
	 * Retorna una lista con todos los requisitos pertenecientes a cada tipo de trámite.  
	 * @param --
	 * 			
	 * @param --
	 * @return	lista obtenida de requisitos perteneciente a cada tipo de trámite es de tipo:
	 * 			{@link TipoTramiteRequisitoResponse}
	 */
	@GetMapping
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_REQUISITO','101')")
    public List<TipoTramiteRequisitoResponse> buscarTodos(){
        return tipoTramiteRequisitoService.buscarTodos();
    }
	
	/**
	 * Retorna un requisito perteneciente a un tipo de trámite, será buscada por atributo:  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idRequisito
	 * 			el identificador de requisito
	 * @param --
	 * @return	requisito perteneciente a un tipo de trámite, obtenido por búsqueda:
	 * 			{@link TipoTramiteRequisitoResponse}
	 */
	@GetMapping("/{idTipoTramite}/requisitos/{idRequisito}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_REQUISITO','102')")
    public TipoTramiteRequisitoResponse buscarPorIdTipoTramiteRequisitos(
    		  @PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite
    		, @PathVariable("idRequisito") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idRequisito)
    {
        return tipoTramiteRequisitoService.buscarPorId(TipoTramiteRequisitoId.builder()
        		.idTipoTramite(idTipoTramite)
        		.idRequisito(idRequisito).build());
    }
	
	
	/**
	 * Retorna una lista de requisitos pertenecientes a un tipo de trámite, será buscada por atributo:  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param --
	 * @return	lista obtenida de requisitos pertenecientes al tipo de trámite es de tipo:
	 * 			{@link TipoTramiteRequisitoResponse}
	 */
	@GetMapping("tipo-tramite/{idTipoTramite}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_REQUISITO','103')")
    public List<TipoTramiteRequisitoResponse> buscarPorTipoTramite(
    		  @PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite)
    {
        return tipoTramiteRequisitoService.buscarPorTipoTramite(TipoTramiteRequisitoId.builder()
        		.idTipoTramite(idTipoTramite)
        		.build());
    }
	
	
	/**
	 * Recibe petición de registro de un requisito que pertenecerá a un tipo de trámite.  
	 * @param tipoTramiteRequisitoRequest
	 * 			el requisito a registrar que pertenecerá a un tipo trámite 
	 * @param --
	 * @return	requisito registrado que pertenecerá a un tipo de trámite
	 * 			{@link TipoTramiteRequisitoResponse}
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_REQUISITO','201')")
	@ResponseStatus(code = HttpStatus.CREATED)
    public TipoTramiteRequisitoResponse registrarTipoTramiteRequisitos(
    		@Valid @RequestBody TipoTramiteRequisitoRequest tipoTramiteRequisitoRequest){
        return tipoTramiteRequisitoService.registrarTipoTramiteRequisito(tipoTramiteRequisitoRequest);
    }
	
	/**
	 * Recibe petición de actualización de un requisito perteneciente a un tipo de trámite.  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idRequisito
	 * 			el identificador del requisito 
	 * @param tipoTramiteRequisitoRequest
	 * 			el requisito a actualizar perteneciente a un tipo de trámite  
	 * @param --
	 * @return	requisito actualizado perteneciente a un tipo de trámite
	 * 			{@link TipoTramiteRequisitoResponse}
	 */
    @PutMapping(value = "/{idTipoTramite}/requisitos/{idRequisito}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_REQUISITO','301')")
    public TipoTramiteRequisitoResponse actualizarTipoTramiteRequisitos( 
    				  @PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite
    				, @PathVariable("idRequisito") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idRequisito
    				, @Valid @RequestBody TipoTramiteRequisitoRequest tipoTramiteRequisitoRequest)
    {
        return tipoTramiteRequisitoService.actualizarTipoTramiteRequisito(
        		TipoTramiteRequisitoId.builder().idTipoTramite(idTipoTramite)
        		.idRequisito(idRequisito).build()
        		, tipoTramiteRequisitoRequest);
    }
    
    
    /**
	 * Recibe petición de actualización del estado de un lrequisito perteneciente a un tipo de trámite.
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param idRequisito
	 * 			el identificador del requisito 
	 * @param tipoTramiteRequisitoRequest
	 * 			el requisito a actualizar perteneciente a un tipo de trámite
	 * @param --
	 * @return	el requisito actualizado perteneciente a un tipo de trámite
	 * 			{@link TipoTramiteRequisitoResponse}
	 */ 
    @PatchMapping(value = "/{idTipoTramite}/requisitos/{idRequisito}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_REQUISITO','302')")
    public TipoTramiteRequisitoResponse actualizarEstadoTipoTramiteRequisitos( 
    				  @PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite
    				, @PathVariable("idRequisito") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idRequisito
    				, @Valid @RequestBody TipoTramiteRequisitoRequest tipoTramiteRequisitoRequest)
    {
        return tipoTramiteRequisitoService.actualizarTipoTramiteRequisito(
        		TipoTramiteRequisitoId.builder().idTipoTramite(idTipoTramite)
        		.idRequisito(idRequisito).build()
        		, tipoTramiteRequisitoRequest);
    }
    
    
    /**
	 * Recibe petición de eliminación de un requisito perteneciente a un tipo de trámite.  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idRequisito
	 * 			el identificador del requisito
	 * @param --
	 * 		
	 */
    @DeleteMapping("/{idTipoTramite}/requisitos/{idRequisito}")
    @PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_REQUISITO','401')")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarTipoTramiteRequisitos(
    		  @PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite
    		, @PathVariable("idRequisito") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idRequisito)
    {
        tipoTramiteRequisitoService.eliminarTipoTramiteRequisito(TipoTramiteRequisitoRequest.builder()
        		.idTipoTramite(idTipoTramite)
        		.idRequisito(idRequisito)
        		.build());
    }
}
