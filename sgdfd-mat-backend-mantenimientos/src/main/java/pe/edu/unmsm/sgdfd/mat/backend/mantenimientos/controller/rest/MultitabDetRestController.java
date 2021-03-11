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
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.IdCadena;
import pe.edu.unmsm.commons.validation.validation.IdNumerico;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.MultitabDetResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.MultitabDetRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.multitabdet.MultitabDetService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento del detalle de multitablas 
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 *  <li>Buscar el detalle de todas las multitablas
 * 	<li>Buscar una lista con cada detalle de las multitablas por identificador de cabecera de multitabla
 * 	<li>Búsqueda del detalle de una multitabla por identificador de cabecera de una multitabla y su propio identificador
 * 	<li>Registro del detalle de una multitabla
 * 	<li>Actualización del detalle de una multitabla
 * 	<li>Eliminación	del detalle de una multitabla
 * </ul>
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see MultitabDetRequest
 * @see MultitabDetResponse
 * @see MultitabDetService
 */
@Validated
@RestController
public class MultitabDetRestController {
	
	private  MultitabDetService multitabDetService;
	
	public MultitabDetRestController(MultitabDetService multitabDetService) {
		this.multitabDetService = multitabDetService;
	}
	
	/**
	 * Retorna una lista con el detalle de todas las multitablas.  
	 * 
	 * @return	lista con el detalle de todas las multitablas obtenidas por búsqueda es de tipo:
	 * 			{@link MultitabDetResponse}
	 */
	@GetMapping("/multitabs-dets/")
	@PreAuthorize("hasPermission('MAN_MULTITAB_DET','101')")
	public List<MultitabDetResponse> buscarTodos() {
		return multitabDetService.buscarTodos();
	}
	
	/**
	 * Retorna una lista con el detalle de las multitablas buscada por atributo:
	 * @param idMultitabCab
	 * 			el identificador de la cabecera de la multitabla		
	 * @param --
	 * @return	lista con el detalle de las multitablas obtenida por búsqueda es de tipo:
	 * 			{@link MultitabDetResponse}
	 */
//	@PreAuthorize("hasPermission('CON_MULTI_TABLA','201')")
	@GetMapping(value = "/multitabs-cabs/{idMultitabCab}/multitabs-dets")
//	@PreAuthorize("hasPermission('MAN_MULTITAB_DET','102')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<MultitabDetResponse> buscarPorIdMultitabCab(
			@IdNumerico(maxRange = 999999) @PathVariable int idMultitabCab) {
		return multitabDetService.buscarPorIdMultitabCab(idMultitabCab);
	}
	
	/**
	 * Retorna el detalle de una multitabla buscado por atributo:  
	 * @param idMultitabCab
	 * 			el identificador de la cabecera de la multitabla
	 * @param idMultitabDet
	 * 			el identificador del detalle de la multitabla
	 * @param --
	 * @return	detalle de la multitabla obtenido por búsqueda:
	 * 			{@link MultitabDetResponse}
	 */
	@GetMapping("/multitabs-cabs/{idMultitabCab}/multitabs-dets/{idMultitabDet}")
	@PreAuthorize("hasPermission('MAN_MULTITAB_DET','103')")
	public MultitabDetResponse buscarPorIdMultitabCabYIdMultitabDet(
					@PathVariable @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idMultitabCab,
				    @PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,10}", maxLength = 10 ) String idMultitabDet) {
		return multitabDetService.buscarPorIdMultitabCabYIdMultitabDet(idMultitabCab, idMultitabDet);
	}
	
	/**
	 * Recibe petición de registro del detalle de una multitabla.  
	 * @param multitabDetRequest
	 * 			el detalle de la multitabla a registrar
	 * @param --
	 * @return	detalle de multitabla registrado
	 * 			{@link MultitabDetResponse}
	 */
	@PostMapping("/multitabs-dets/")
	@PreAuthorize("hasPermission('MAN_MULTITAB_DET','201')")
	public MultitabDetResponse registrarMultitabDet(@Valid @RequestBody MultitabDetRequest multitabDetRequest) {
		return multitabDetService.registrarMultitabDet(multitabDetRequest);
	}
	
	/**
	 * Recibe petición de actualización del detalle de una multitabla.  
	 * @param idMultitabCab
	 * 			el identificador de la cabecera de una multitabla
	 * @param idMultitabDet
	 * 			el identificador del detalle de una multitabla
	 * @param multitabDetRequest
	 * 			el detalle de la multitabla a actualizar
	 * @param --
	 * @return	detalle de la multitabla actualizado
	 * 			{@link MultitabDetResponse}
	 */
	@PutMapping("/multitabs-cabs/{idMultitabCab}/multitabs-dets/{idMultitabDet}")
	@PreAuthorize("hasPermission('MAN_MULTITAB_DET','301')")
	public MultitabDetResponse actualizarMultitabDet(
			@PathVariable @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idMultitabCab,
	        @PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,10}", maxLength = 10 ) String idMultitabDet,
	        @Valid @RequestBody  MultitabDetRequest multitabDetRequest) {
		return multitabDetService.actualizarMultitabDet(idMultitabCab, idMultitabDet, multitabDetRequest);
	}
	
	/**
	 * Recibe petición de eliminación del detalle de una multitabla.  
	 * @param idMultitabCab
	 * 			el identificador de la cabecera de una multitabla
	 * @param idMultitabDet
	 * 			el identificador del detalle de una multitabla
	 * @param --
	 * 		
	 */
	@DeleteMapping("/multitabs-cabs/{idMultitabCab}/multitabs-dets/{idMultitabDet}")
	@PreAuthorize("hasPermission('MAN_MULTITAB_DET','401')")
	public void eliminarMultitabDet(
			@PathVariable @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idMultitabCab,
	        @PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,10}", maxLength = 10 ) String idMultitabDet) {
		multitabDetService.eliminarMultitabDet(MultitabDetRequest.builder().idMultitabCab(idMultitabCab).idMultitabDet(idMultitabDet).build());
	}
}
