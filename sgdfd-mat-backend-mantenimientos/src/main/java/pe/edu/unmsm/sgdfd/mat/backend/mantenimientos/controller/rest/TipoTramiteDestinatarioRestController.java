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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteDestinatarioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteDestinatarioRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.destinatario.TipoTramiteDestinatarioService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de los Destinos 
 * a donde se pueden derivar cada Tipo de Tramite y busquedas de acuerdo a diferentes atributos
 * que retornaran o listas o un Destino a donde poder derivar un tipo de tramite
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los destinos donde se puede derivar cada tipo de trámite
 * 	<li>Búsqueda de una lista con los destinos a donde se puede derivar un tipo de trámite por medio 
 * 		del identificador de tipo de trámite
 * 	<li>Búsqueda de una lista con los destinos a donde se puede derivar un tipo de trámite por medio 
 * 		del código de local
 * 	<li>Búsqueda de un destino a donde se puede derivar un tipo de tramite
 * 		 por medio del identificador de trámite, código de local e identificador de item
 * 	<li>Registro de un destino a donde se puede derivar un tipo de trámite
 * 	<li>Actualización de un destino a donde se puede derivar un tipo de trámite
 * 	<li>Eliminación	de un destino a donde se puede derivar un tipo de trámite 
 * </ul>
 * 
 * @author Miguel Moya
 * @author Eric Robladillo
 * @see TipoTramiteDestinatarioRequest
 * @see TipoTramiteDestinatarioResponse
 * @see TipoTramiteDestinatarioService
 */
@Validated
@RestController
@RequestMapping("/tipo-tramite-destinatario")
public class TipoTramiteDestinatarioRestController {

private TipoTramiteDestinatarioService tipoTramiteDestinatarioService;
	
	public TipoTramiteDestinatarioRestController(TipoTramiteDestinatarioService tipoTramiteDestinatarioService) {
		this.tipoTramiteDestinatarioService = tipoTramiteDestinatarioService;
	}
	
	/**
	 * Retorna una lista con todos los destinos a donde se puede derivar cada tipo de trámite.  
	 * 
	 * @return	lista de destinos a donde se puede derivar cada tipo de trámite, obtenida por búsqueda es de tipo:
	 * 			{@link TipoTramiteDestinatarioResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_DESTINATARIO','101')")
	public List<TipoTramiteDestinatarioResponse> buscarTodos() {
		return tipoTramiteDestinatarioService.buscarTodos();
	}
	
	/**
	 * Retorna una lista con destinos a donde se puede derivar un tipo de trámite, será buscada por atributo:  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param --
	 * @return	lista con destinos a donde se puede derivar el tipo de trámite, obtenida por búsqueda es de tipo:
	 * 			{@link TipoTramiteDestinatarioResponse}
	 */
	@GetMapping("/tramite/{idTipoTramite}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_DESTINATARIO','102')")
	public List<TipoTramiteDestinatarioResponse> buscarPorIdTipoTramite(
				@PathVariable @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite) {
		return tipoTramiteDestinatarioService.buscarPorIdTipoTramite(idTipoTramite);
	}
	
	/**
	 * Retorna una lista con los destinos a donde se puede derivar un tipo de trámite, será buscada por atributo:  
	 * @param idLocal
	 * 			el identificador del local
	 * @param --
	 * @return	lista de destinos a donde se puede derivar un tipo de trámite, obtenida por búsqueda es de tipo:
	 * 			{@link TipoTramiteDestinatarioResponse}
	 */
	@GetMapping("/local/{idLocal}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_DESTINATARIO','103')")
	public List<TipoTramiteDestinatarioResponse> buscarPorIdLocal(
				@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String idLocal) {
		return tipoTramiteDestinatarioService.buscarPorIdLocal(idLocal);
	}
	
	/**
	 * Retorna un destino a donde se puede derivar un tipo de trámite, será buscado por atributo:  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idLocal
	 * 			el identificador del local
	 * @param idItem
	 * 			el identificador de item
	 * @param --
	 * @return	destino obtenido por búsqueda en donde se puede derivar un tipo de tramite :
	 * 			{@link TipoTramiteDestinatarioResponse}
	 */
	@GetMapping("/tramite/{idTipoTramite}/local/{idLocal}/item/{idItem}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_DESTINATARIO','104')")
	public TipoTramiteDestinatarioResponse buscarPorIdTipoTramiteYIdLocalYIdItem(
				@PathVariable @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite, 
				@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String idLocal, 
				@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,5}", maxLength = 5 ) Integer idItem) {
		return tipoTramiteDestinatarioService.buscarPorIdTipoTramiteYIdLocalYIdItem(idTipoTramite,idLocal,idItem);
	}
	
	/**
	 * Recibe petición de registro de un destino en donde se puede derivar un tipo de trámite.  
	 * @param tipoTramiteDestinatarioRequest
	 * 			el destino a registrar a donde se podrá derivar un tipo de trámite 
	 * @param --
	 * @return	destino registrado a donde se podrá derivar un tipo de tramite
	 * 			{@link TipoTramiteDestinatarioResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_DESTINATARIO','201')")
	public TipoTramiteDestinatarioResponse registrarTipoTramiteDestinatario(
			@Valid @RequestBody TipoTramiteDestinatarioRequest tipoTramiteDestinatarioRequest) {
		return tipoTramiteDestinatarioService.registrarTipoTramiteDestinatario(tipoTramiteDestinatarioRequest);
	}
	
	/**
	 * Recibe petición de actualización de un destino a donde se puede derivar un tipo de trámite.  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idLocal
	 * 			el identificador del local 
	 * @param idItem
	 * 			el identificador de item 
	 * @param tipoTramiteDestinatarioRequest
	 * 			el destino a actualizar en donde se puede derivar el tipo de trámite
	 * @param --
	 * @return	destino actualizado en donde se puede derivar el tipo de trámite
	 * 			{@link TipoTramiteDestinatarioResponse}
	 */
	@PutMapping("/{idTramite}/local/{idLocal}/item/{idItem}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_DESTINATARIO','301')")
	public TipoTramiteDestinatarioResponse actualizarTipoTramiteDestinatario(
			   @PathVariable @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTramite, 
			   @PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String idLocal, 
			   @PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,5}", maxLength = 5 ) Integer idItem
			, @Valid @RequestBody TipoTramiteDestinatarioRequest tipoTramiteDestinatarioRequest) {
		return tipoTramiteDestinatarioService.actualizarTipoTramiteDestinatario(idTramite, idLocal, idItem, tipoTramiteDestinatarioRequest);
	}
	
	/**
	 * Recibe petición de eliminación de un destino a donde se puede derivar un tipo de trámite.  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idLocal
	 * 			el identificador del local 
	 * @param idItem
	 * 			el identificador de item
	 * @param --
	 * 		
	 */
	@DeleteMapping("/{idTramite}/local/{idLocal}/item/{idItem}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_DESTINATARIO','401')")
	public void eliminarTipoTramiteDestinatario(
			@PathVariable @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTramite, 
			@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String idLocal, 
			@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,5}", maxLength = 5 ) Integer idItem) {
	    tipoTramiteDestinatarioService.eliminarTipoTramiteDestinatario(TipoTramiteDestinatarioRequest.builder().idTipoTramite(idTramite).idLocal(idLocal).idItem(idItem).build());
	}
	
	
	
	
}
