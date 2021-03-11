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

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoDocumentoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoDocumentoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipodocumento.TipoDocumentoService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de tipo de documentos 
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los tipos de documento
 * 	<li>Registro de un tipo de documento
 * 	<li>Actualización de un tipo de documento
 * 	<li>Eliminación	de un tipo de documento
 * </ul>
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see TipoDocumentoRequest
 * @see TipoDocumentoResponse
 * @see TipoDocumentoService
 */
@Validated
@RestController
@RequestMapping("/tipo-documento")
public class TipoDocumentoRestController {

	private TipoDocumentoService tipoDocumentoService;
	
	public TipoDocumentoRestController(TipoDocumentoService tipoDocumentoService) {
		this.tipoDocumentoService =  tipoDocumentoService;
	}
	
	/**
	 * Retorna una lista con todos los tipos de documento.  
	 * 
	 * @return	lista de tipos de documento obtenida por búsqueda es de tipo:
	 * 			{@link TipoDocumentoResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_TIPO_DOCUMENTO','101')")
	public List<TipoDocumentoResponse> buscarTodos(){
		return tipoDocumentoService.buscarTodos();
	}
	
	/**
	 * Retorna una lista de Tipo documentos buscados por identificador de tipo trámite 
	 * @param idTipoTramite
	 * 		identificador de tipo trámite 
	 * @return	lista de tipos de documento obtenida por búsqueda es de tipo:
	 * 			{@link TipoDocumentoResponse}
	 */
	@GetMapping("/idTipoTramite/{idTipoTramite}")
	@PreAuthorize("hasPermission('MAN_TIPO_DOCUMENTO','102')")
	public List<TipoDocumentoResponse> buscarPorIdTipoTramite(@PathVariable Integer idTipoTramite){
		return tipoDocumentoService.buscarPorIdTipoTramite(idTipoTramite);
	}
	
	/**
	 * Recibe petición de registro de un tipo de documento.  
	 * @param tipoDocumentoRequest
	 * 			el tipo de documento a registrar
	 * @param --
	 * @return	tipo de documento registrado
	 * 			{@link TipoDocumentoRequest}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_TIPO_DOCUMENTO','201')")
	public TipoDocumentoResponse registrarTipoDocumento(@Valid @RequestBody TipoDocumentoRequest tipoDocumentoRequest) {
		return tipoDocumentoService.registrarTipoDocumento(tipoDocumentoRequest);		
	}
	
	/**
	 * Recibe petición de actualización de un tipo de documento.  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param tipoDocumentoRequest
	 * 			el tipo de documento a actualizar
	 * @param --
	 * @return	tipo de documento actualizado
	 * 			{@link TipoDocumentoRequest}
	 */
	@PutMapping("/{idTipoDocumento}")
	@PreAuthorize("hasPermission('MAN_TIPO_DOCUMENTO','301')")
	public TipoDocumentoResponse actualizarTipoDocumento(
						@PathVariable String idTipoDocumento
					  , @Valid @RequestBody TipoDocumentoRequest tipoDocumentoRequest) {
		return tipoDocumentoService.actualizarTipoDocumento(idTipoDocumento, tipoDocumentoRequest);
	}
	
	/**
	 * Recibe petición de eliminación de un tipo de documento.  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param --
	 * 		
	 */
	@DeleteMapping("/{idTipoDocumento}")
	@PreAuthorize("hasPermission('MAN_TIPO_DOCUMENTO','401')")
	public void eliminarTipoDocumento(
			@PathVariable  String idTipoDocumento) {
		tipoDocumentoService.eliminarTipoDocumento(TipoDocumentoRequest.builder().idTipoDocumento(idTipoDocumento).build());
		
	}
	
	
}
