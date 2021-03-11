package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.Valid;

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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EstadoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.EstadoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.estado.EstadoService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de Estados y
 * de busquedas por atributos que retornen o listas o un Estado
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los estados
 * 	<li>Búsqueda de una lista de estados por su tabla origen
 * 	<li>Búsqueda de un estado por tabla origen y código de estado
 * 	<li>Registro de un estado
 * 	<li>Actualización de un estado
 * 	<li>Eliminación	de un estado
 * </ul>
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see EstadoRequest
 * @see EstadoResponse
 * @see EstadoService
 */
@Validated
@RestController
@RequestMapping("/estados")
public class EstadoRestController {
	
	private EstadoService estadoService;
	
	
	public EstadoRestController(EstadoService estadoService) {
		this.estadoService = estadoService;
	}
	
	/**
	 * Retorna una lista con todos los estados.  
	 * 
	 * @return	lista de estados obtenida por búsqueda es de tipo:
	 * 			{@link EstadoResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_ESTADO','101')")
	public List<EstadoResponse> buscarTodos() {
		return estadoService.buscarTodos();
	}	
	
	/**
	 * Retorna una lista de estados buscados por atributo:  
	 * @param tablaOrigen
	 * 			la tabla origen del estado a buscar	
	 * @param --
	 * @return	lista de estados obtenida por búsqueda es de tipo:
	 * 			{@link EstadoResponse}
	 */
	@GetMapping("/{tablaOrigen}")
//	@PreAuthorize("hasPermission('MAN_ESTADO','102')")
	public List<EstadoResponse> buscarPorTablaOrigen(
					@PathVariable("tablaOrigen") @IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,30}", maxLength = 30 ) String tablaOrigen) {
		return estadoService.buscarPorTablaOrigen(tablaOrigen);
	}
	
	/**
	 * Retorna un estado buscado por atributos:  
	 * @param tablaOrigen
	 * 			la tabla origen del estado a buscar
	 * @param codigoEstado
	 * 			el código del estado a buscar
	 * @param --
	 * @return	estado obtenido por búsqueda:
	 * 			{@link EstadoResponse}
	 */
	@GetMapping("/origen/{tablaOrigen}/estado/{codigoEstado}")
	@PreAuthorize("hasPermission('MAN_ESTADO','103')")
	public EstadoResponse buscarPorTablaOrigenYCodigoEstado(
					@PathVariable("tablaOrigen") @IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,30}", maxLength = 30 ) String tablaOrigen,
					@PathVariable("codigoEstado") @IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,30}", maxLength = 10 ) String codigoEstado) {
		return estadoService.buscarPorTablaOrigenYCodigoEstado(tablaOrigen, codigoEstado);
	}
	
	/**
	 * Recibe petición de registro de un estado.  
	 * @param estadoRequest
	 * 			el estado a registrar
	 * @param --
	 * @return	estado registrado
	 * 			{@link EstadoResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_ESTADO','201')")
	public EstadoResponse registrarEstado(@Valid @RequestBody EstadoRequest estadoRequest) {
		return estadoService.registrarEstado(estadoRequest);
	}
	
	/**
	 * Recibe petición de actualización de un estado.  
	 * @param tablaOrigen
	 * 			la tabla origen del estado
	 * @param codigoEstado
	 * 			el código del estado
	 * @param estadoRequest
	 * 			el estado a actualizar
	 * @param --
	 * @return	estado actualizado
	 * 			{@link EstadoResponse}
	 */
	@PutMapping("/origen/{tablaOrigen}/estado/{codigoEstado}")
	@PreAuthorize("hasPermission('MAN_ESTADO','301')")
	public EstadoResponse actualizarEstado( 
			@PathVariable("tablaOrigen") @IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,30}", maxLength = 30 ) String tablaOrigen
		  , @PathVariable("codigoEstado") @IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,30}", maxLength = 10 ) String codigoEstado
		  , @Valid @RequestBody EstadoRequest estadoRequest) {
		return estadoService.actualizarEstado(tablaOrigen, codigoEstado, estadoRequest);
	}
	
	/**
	 * Recibe petición de eliminación de un estado.  
	 * @param tablaOrigen
	 * 			la tabla origen del estado
	 * @param codigoEstado
	 * 			el código del estado
	 * @param --
	 * 		
	 */
	@DeleteMapping("/origen/{tablaOrigen}/estado/{codigoEstado}")
	@PreAuthorize("hasPermission('MAN_ESTADO','401')")
	public void eliminarEstado(
			    @PathVariable("tablaOrigen") @IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,30}", maxLength = 30 ) String tablaOrigen
			  , @PathVariable("codigoEstado") @IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,30}", maxLength = 10 ) String codigoEstado) {
		estadoService.eliminarEstado(EstadoRequest.builder().tablaOrigen(tablaOrigen).codigoEstado(codigoEstado).build());
	}
	
	
}
