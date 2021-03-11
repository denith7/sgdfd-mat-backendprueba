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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.CronogramaVigenteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.CronogramaVigenteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.cronograma.CronogramaVigenteService;


/**
 * Recibe las solicitudes relacionadas al mantenimiento de Cronogramas Vigentes, 
 * incluye ademas busquedas por diferentes atributos que retornan listas de Cronogramas Vigentes  
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los cronogramas vigentes
 * 	<li>Búsqueda de cronogramas vigentes por identificador de tipo de trámite
 * 	<li>Búsqueda de cronogramas vigentes por identificador de tipo de trámite y código de local
 * 	<li>Búsqueda de un cronograma vigente por identificador de tipo de trámite, identificador de item y código de local
 * 	<li>Registro de un cronograma vigente
 * 	<li>Actualización de un cronograma vigente
 * 	<li>Eliminación	 de un cronograma vigente
 * </ul>
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @author Eric Robladillo
 * @see CronogramaVigenteRequest
 * @see CronogramaVigenteResponse
 * @see CronogramaVigenteService
 */
@Validated
@RestController
@RequestMapping("/cronograma-vigente")
public class CronogramaVigenteRestController {

	private CronogramaVigenteService cronogramaVigenteService;
	
	public CronogramaVigenteRestController(CronogramaVigenteService cronogramaVigenteService) {
		this.cronogramaVigenteService =  cronogramaVigenteService;
	}
	
	/**
	 * Retorna una lista de todos los cronogramas vigentes.  
	 * 			
	 * @return	lista de cronogramas vigentes obtenida por búsqueda es de tipo:
	 * 			{@link CronogramaVigenteResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_CRONOGRAMA_VIGENTE','101')")
	public List<CronogramaVigenteResponse> buscarTodos(){
		return cronogramaVigenteService.buscarTodos();
	}
	
	/**
	 * Retorna una lista de cronogramas vigentes buscada por atributo:
	 * @param idTipoTramite
	 * 			el identificador de tipo de tramite
	 * @param --
	 * @return	lista de cronogramas vigentes obtenida por búsqueda es de tipo:
	 * 			{@link CronogramaVigenteResponse}
	 */
	@GetMapping("/tipo-tramite/{idTipoTramite}")
	@PreAuthorize("hasPermission('MAN_CRONOGRAMA_VIGENTE','102')")
    public List<CronogramaVigenteResponse> buscarPorIdTipoTramite(@PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")
											@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite){
        return cronogramaVigenteService.buscarPorIdTipoTramite(idTipoTramite);
    }
	
	/**
	 * Retorna una lista de cronogramas vigentes buscada por atributo:
	 * @param idTipoTramite
	 * 			el identificador de tipo de tramite
	 * @param codigoLocal
	 * 			el código de local
	 * @param --
	 * @return	lista de cronogramas vigentes obtenida por búsqueda:
	 * 			{@link CronogramaVigenteResponse}
	 */
	@GetMapping("/tipo-tramite/{idTipoTramite}/local/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_CRONOGRAMA_VIGENTE','103')")
    public List<CronogramaVigenteResponse> buscarPorIdTipoTramiteYCodigoLocal(
    								@PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")@PositiveOrZero(message = "Debe ser positivo")Integer idTipoTramite, 
    								@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal){
        return cronogramaVigenteService.buscarPorIdTipoTramiteYCodigoLocal(idTipoTramite,codigoLocal);
    }
	
	/**
	 * Retorna un cronograma vigente buscado por atributo:
	 * @param idTipoTramite
	 * 			el identificador de tipo de tramite
	 * @param idItem
	 * 			el identificador de item
	 * @param codigoLocal
	 * 			el código de local
	 * @param --
	 * @return	cronograma vigente obtenido por búsqueda:
	 * 			{@link CronogramaVigenteResponse}
	 */
	@GetMapping("/tipo-tramite/{idTipoTramite}/item/{idItem}/local/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_CRONOGRAMA_VIGENTE','104')")
    public CronogramaVigenteResponse buscarPorIdTipoTramiteYIdItemYCodigoLocal(
    								@PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite, 
									@PathVariable("idItem") @NotNull(message = "Name cannot be null")@PositiveOrZero(message = "Debe ser positivo")Integer idItem, 
									@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal){
        return cronogramaVigenteService.buscarPorIdTipoTramiteYIdItemYCodigoLocal(idTipoTramite,idItem,codigoLocal);
    }
	
	/**
	 * Recibe petición de registro de cronograma vigente.  
	 * @param cronogramaVigenteRequest
	 * 			el cronograma vigente a registrar
	 * @param --
	 * @return	cronograma vigente registrado
	 * 			{@link CronogramaVigenteResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_CRONOGRAMA_VIGENTE','201')")
	public CronogramaVigenteResponse registrarCronogramaVigente(@Valid @RequestBody CronogramaVigenteRequest cronogramaVigenteRequest) {
		return cronogramaVigenteService.registrarCronogramaVigente(cronogramaVigenteRequest);		
	}
	
	/**
	 * Recibe petición de actualización de un cronograma vigente.  
	 * @param idTipoTramite
	 * 			el identificador de tipo de tramite
	 * @param idItem
	 * 			el identificador de item
	 * @param codigoLocal
	 * 			el código de local
	 * @param cronogramaVigenteRequest
	 * 			el cronograma vigente a actualizar
	 * @param --
	 * @return	cronograma vigente actualizado
	 * 			{@link CronogramaVigenteResponse}
	 */
	@PutMapping("/{idTipoTramite}/item/{idItem}/local/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_CRONOGRAMA_VIGENTE','301')")
	public CronogramaVigenteResponse actualizarCronogramaVigente(
							@PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite, 
							@PathVariable("idItem") @NotNull(message = "Name cannot be null")@PositiveOrZero(message = "Debe ser positivo") Integer idItem, 
							@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal,
			@RequestBody CronogramaVigenteRequest cronogramaVigenteRequest) {
		return cronogramaVigenteService.actualizarCronogramaVigente(idTipoTramite, idItem, codigoLocal, cronogramaVigenteRequest);
	}
	
	/**
	 * Recibe petición de eliminación de un cronograma vigente.  
	 * @param idTipoTramite
	 * 			el identificador de tipo de tramite
	 * @param idItem
	 * 			el identificador de item
	 * @param codigoLocal
	 * 			el código de local
	 * @param --
	 * 		
	 */
	@DeleteMapping("/{idTipoTramite}/item/{idItem}/local/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_CRONOGRAMA_VIGENTE','401')")
	public void eliminarCronogramaVigente(
						@PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null")@PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite, 
						@PathVariable("idItem") @NotNull(message = "Name cannot be null")@PositiveOrZero(message = "Debe ser positivo") Integer idItem, 
						@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal) {
		cronogramaVigenteService.eliminarCronogramaVigente(CronogramaVigenteRequest.builder().idTipoTramite(idTipoTramite).idItem(idItem).codigoLocal(codigoLocal).build());
		
	}
	
}
