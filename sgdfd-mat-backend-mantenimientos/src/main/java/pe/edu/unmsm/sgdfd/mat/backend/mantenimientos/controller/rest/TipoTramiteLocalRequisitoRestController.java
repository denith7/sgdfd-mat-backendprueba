package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.IdCadena;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.id.TipoTramiteLocalRequisitoId;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteLocalRequisitoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.localrequisito.TipoTramiteLocalRequisitoService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de los Requisitos propios de cada Local en cada Tipo de Tramite
 * ademas de incluir busquedas que retornen listas de acuerdo a diferentes atributos
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los Requisitos propios de cada local en cada tipo de trámite
 * 	<li>Búsqueda de una lista de Requisitos propios de cada local para un tipo de tramite por medio del identificador del trámite
 *  <li>Búsqueda de una lista de Requisitos propios de cada local para cada tipo de tramite por medio del identificador de requisito
 * 	<li>Búsqueda de un Requisito propio de un local para un tipo de tramite por medio del identificador del trámite, 
 * 			por código de local e identificador de requisito
 * 	<li>Registro de un Requisito propio de un local para un tipo de tramite
 * 	<li>Actualización de un Requisito propio de un local para un tipo de trámite
 * 	<li>Eliminación de un Requisito propio de un local para un tipo de trámite
 * </ul>
 * 
 * @author Miguel Moya
 * @see TipoTramiteLocalRequisitoRequest
 * @see TipoTramiteLocalRequisitoResponse
 * @see TipoTramiteLocalRequisitoService
 */
@Validated
@RestController
@RequestMapping("/tipo-tramite-local-requisito")
public class TipoTramiteLocalRequisitoRestController {

	private TipoTramiteLocalRequisitoService tipoTramiteLocalRequisitoService;

	public TipoTramiteLocalRequisitoRestController(TipoTramiteLocalRequisitoService tipoTramiteLocalRequisitoService) {
		this.tipoTramiteLocalRequisitoService = tipoTramiteLocalRequisitoService;
	}
	
	/**
	 * Retorna una lista con todos los Requisitos propios de cada local para cada tipo de trámite.  
	 * 
	 * @return	lista obtenida por búsqueda de Requisitos de cada local para cada tipo de trámite es de tipo:
	 * 			{@link TipoTramiteLocalRequisitoResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL_REQUISITO','101')")
    public List<TipoTramiteLocalRequisitoResponse> buscarTodos(){
        return tipoTramiteLocalRequisitoService.buscarTodos();
    }
	
	/**
	 * Retorna una lista de Requisitos propios de cada local para un tipo de tramite, será buscada por atributo:  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param --
	 * @return	lista obtenida por busqueda de Requisitos de cada local para el tipo de trámite es de tipo:
	 * 			{@link TipoTramiteLocalRequisitoResponse}
	 */
	@GetMapping("/tramite/{idTipoTramite}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL_REQUISITO','102')")
    public List<TipoTramiteLocalRequisitoResponse> buscarPorIdTipoTramite(
    		  @PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite)
    {
        return tipoTramiteLocalRequisitoService.buscarPorIdTipoTramite(idTipoTramite);
    }
	
	/**
	 * Retorna una lista de Requisitos propios de cada local para cada tipo de tramite y que se identifiquen con el atributo:  
	 * @param idRequisito
	 * 			el identificador del requisito
	 * @param --
	 * @return	lista obtenida por busqueda de Requisitos de cada local para cada tipo de trámite es de tipo:
	 * 			{@link TipoTramiteLocalRequisitoResponse}
	 */
	@GetMapping("/requisito/{idRequisito}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL_REQUISITO','103')")
	public List<TipoTramiteLocalRequisitoResponse> buscarPorIdRequisito(
				@PathVariable("idRequisito") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idRequisito){
		return tipoTramiteLocalRequisitoService.buscarPorIdRequisito(idRequisito);
	}
	
	/**
	 * Retorna un requisito perteneciente a un local y a un tipo de trámite, será buscado por atributo:  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idLocal
	 * 			el identificador del local
	 * @param idRequisito
	 * 			el identificador del requisito
	 * @param --
	 * @return	requisito obtenido por búsqueda perteneciente al local y al tipo de trámite :
	 * 			{@link TipoTramiteLocalRequisitoResponse}
	 */
	@GetMapping("/tramite/{idTipoTramite}/local/{codigoLocal}/requisito/{idRequisito}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL_REQUISITO','104')")
    public TipoTramiteLocalRequisitoResponse buscarPorIdTipoTramiteYCodigoLocalYIdRequisito(
    		  @PathVariable("idTipoTramite")@NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo")  Integer idTipoTramite
    		, @PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal  
    		, @PathVariable("idRequisito") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idRequisito)
    {
        return tipoTramiteLocalRequisitoService.buscarPorIdTipoTramiteYCodigoLocalYIdRequisito(idTipoTramite, codigoLocal, idRequisito);
    }
	
	/**
	 * Recibe petición de registro de un Requisito propio de un local y para un tipo de tramite.  
	 * @param tipoTramiteLocalRequisitoRequest
	 * 			el requisito a registrar propio de un local y para un tipo de tramite
	 * @param --
	 * @return	requisito registrado para un local y para un tipo de trámite
	 * 			{@link TipoTramiteLocalRequisitoResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL_REQUISITO','201')")
    public TipoTramiteLocalRequisitoResponse registrarTipoTramiteLocalRequisito(
    		@Valid @RequestBody TipoTramiteLocalRequisitoRequest tipoTramiteLocalRequisitoRequest){
        return tipoTramiteLocalRequisitoService.registrarTipoTramiteLocalRequisito(tipoTramiteLocalRequisitoRequest);
    }
	
	/**
	 * Recibe petición de actualizacion de un Requisito propio de un local y para un tipo de tramite.
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idLocal
	 * 			el identificador del local
	 * @param idRequisito
	 * 			el identificador del requisito 
	 * @param tipoTramiteLocalRequisitoRequest
	 * 			el requisito a actualizar propio de un local y para un tipo de tramite
	 * @param --
	 * @return	tipo trámite local requisito actualizado
	 * 			{@link TipoTramiteLocalRequisitoResponse}
	 */
	@PutMapping("/tramite/{idTipoTramite}/local/{codigoLocal}/requisito/{idRequisito}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL_REQUISITO','301')")
    public TipoTramiteLocalRequisitoResponse actualizarTipoTramiteLocalRequisito( 
    				  @PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite
    				, @PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal 
    				, @PathVariable("idRequisito") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idRequisito
    				, @Valid @RequestBody TipoTramiteLocalRequisitoRequest tipoTramiteLocalRequisitoRequest)
    {
        return tipoTramiteLocalRequisitoService.actualizarTipoTramiteLocalRequisito(
        		TipoTramiteLocalRequisitoId.builder().idTipoTramite(idTipoTramite)
        		.codigoLocal(codigoLocal)
        		.idRequisito(idRequisito).build()
        		, tipoTramiteLocalRequisitoRequest);
    }
	
	/**
	 * Recibe petición de eliminacion de un Requisito propio de un local y para un tipo de tramite.
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idLocal
	 * 			el identificador del local
	 * @param idRequisito
	 * 			el identificador del requisito
	 * @param --
	 * 		
	 */
	@DeleteMapping("/tramite/{idTipoTramite}/local/{codigoLocal}/requisito/{idRequisito}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_LOCAL_REQUISITO','401')")
    public void eliminarTipoTramiteLocalRequisito(
    		  @PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite
    		, @PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal
    		, @PathVariable("idRequisito") @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idRequisito)
    {
        tipoTramiteLocalRequisitoService.eliminarTipoTramiteLocalRequisito(TipoTramiteLocalRequisitoRequest.builder()
        		.idTipoTramite(idTipoTramite)
        		.codigoLocal(codigoLocal)
        		.idRequisito(idRequisito)
        		.build());
    }
	
}
