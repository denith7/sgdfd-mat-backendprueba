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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteDocumentoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteDestinatarioRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteDocumentoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.destinatario.TipoTramiteDestinatarioService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.documento.TipoTramiteDocumentoService;


/**
 * Recibe las solicitudes relacionadas al mantenimiento de TiposTramiteDocumento 
 *  y busquedas de acuerdo a diferentes atributos
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los TiposTramiteDocumento
 * 	<li>Búsqueda de un TipoTramiteDocumento
 * 		 por medio del identificador de tipo de trámite e identificador de tipo de documento
 * 	<li>Registro de un TipoTramiteDocumento
 * 	<li>Actualización de un TipoTramiteDocumento
 * 	<li>Eliminación	de un TipoTramiteDocumento
 * </ul>
 * 
 * @author Eric Robladillo
 * @see TipoTramiteDocumentoRequest
 * @see TipoTramiteDocumentoResponse
 * @see TipoTramiteDocumentoService
 */
@Validated
@RestController
@RequestMapping("/tipo-tramite-documento")
public class TipoTramiteDocumentoRestController {

	private TipoTramiteDocumentoService tipoTramiteDocumentoService;
	
	public TipoTramiteDocumentoRestController(TipoTramiteDocumentoService tipoTramiteDocumentoService) {
		this.tipoTramiteDocumentoService = tipoTramiteDocumentoService;
	}
	
	/**
	 * Retorna una lista con todos los TipoTramiteDocumento.  
	 * 
	 * @return	lista de TipoTramiteDocumento, obtenida por búsqueda es de tipo:
	 * 			{@link TipoTramiteDocumentoResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_DOCUMENTO','101')")
	public List<TipoTramiteDocumentoResponse> buscarTodos() {
		return tipoTramiteDocumentoService.buscarTodos();
	}
	
	/**
	 * Retorna un TipoTramiteDocumento, será buscado por atributo:  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idTipoDocumento
	 * 			el identificador del tipo de documento
	 * @param --
	 * @return	TipoTramiteDocumento obtenido por búsqueda :
	 * 			{@link TipoTramiteDocumentoResponse}
	 */
	@GetMapping("/tramite/{idTipoTramite}/documento/{idTipoDocumento}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_DOCUMENTO','102')")
	public TipoTramiteDocumentoResponse buscarPorIdTipoTramiteYIdTipoDocumento(
				@PathVariable @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite, 
				@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String idTipoDocumento) {
		return tipoTramiteDocumentoService.buscarPorIdTipoTramiteYIdTipoDocumento(idTipoTramite,idTipoDocumento);
	}
	
	/**
	 * Recibe petición de registro de un TipoTramiteDocumento.  
	 * @param tipoTramiteDocumentoRequest
	 * 			el TipoTramiteDocumento a registrar  
	 * @param --
	 * @return	TipoTramiteDocumento registrado 
	 * 			{@link TipoTramiteDocumentoResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_DOCUMENTO','201')")
	public TipoTramiteDocumentoResponse registrarTipoTramiteDocumento(
			@Valid @RequestBody TipoTramiteDocumentoRequest tipoTramiteDocumentoRequest) {
		return tipoTramiteDocumentoService.registrarTipoTramiteDocumento(tipoTramiteDocumentoRequest);
	}
	
	/**
	 * Recibe petición de actualización de un TipoTramiteDocumento.  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idTipoDocumento
	 * 			el identificador del tipo de documento
	 * @param tipoTramiteDocumentoRequest
	 * 			el TipoTramiteDocumento a actualizar 
	 * @param --
	 * @return	TipoTramiteDocumento actualizado
	 * 			{@link TipoTramiteDestinatarioResponse}
	 */
	@PutMapping("/{idTramite}/documento/{idTipoDocumento}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_DOCUMENTO','301')")
	public TipoTramiteDocumentoResponse actualizarTipoTramiteDestinatario(
			   @PathVariable @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTramite, 
			   @PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String idTipoDocumento
			, @Valid @RequestBody TipoTramiteDocumentoRequest tipoTramiteDocumentoRequest) {
		return tipoTramiteDocumentoService.actualizarTipoTramiteDocumento(idTramite, idTipoDocumento, tipoTramiteDocumentoRequest);
	}
	
	/**
	 * Recibe petición de eliminación de un TipoTramiteDocumento.  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idTipoDocumento
	 * 			el identificador del tipo de documento
	 * @param --
	 * 		
	 */
	@DeleteMapping("/{idTramite}/documento/{idTipoDocumento}")
	@PreAuthorize("hasPermission('MAN_TIPO_TRAMITE_DOCUMENTO','401')")
	public void eliminarTipoTramiteDestinatario(
			@PathVariable @NotNull(message = "Name cannot be null")	@PositiveOrZero(message = "Debe ser positivo") Integer idTramite, 
			@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String idTipoDocumento) {
	    tipoTramiteDocumentoService.eliminarTipoTramiteDocumento(TipoTramiteDocumentoRequest.builder().idTipoTramite(idTramite).idTipoDocumento(idTipoDocumento).build());
	}
	
}
