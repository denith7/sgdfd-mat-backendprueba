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

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.MultitabCabResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.MultitabCabRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.multitabcab.MultitabCabService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de las cabeceras de multitablas 
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todas las cabeceras de multitablas 
 * 	<li>Búsqueda de una cabecera de multitabla por su identificador
 * 	<li>Registro de una cabecera de multitabla 
 * 	<li>Actualización de una cabecera de multitabla 
 * 	<li>Eliminación	de una cabecera de multitabla 
 * </ul>
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see MultitabCabRequest
 * @see MultitabCabResponse
 * @see MultitabCabService
 */
@Validated
@RestController
@RequestMapping("/multitabs-cabs")
public class MultitabCabRestController {
	
	private  MultitabCabService multitabCabService;
	
	public MultitabCabRestController(MultitabCabService multitabCabService) {
		this.multitabCabService = multitabCabService;
	}
	
	/**
	 * Muestra una lista con todas las cabeceras de multitablas.  
	 * 
	 * @return	lista de las cabeceras de multitablas obtenidas por búsqueda es de tipo:
	 * 			{@link MultitabCabResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_MULTITAB_CAB','101')")
	public List<MultitabCabResponse> buscarTodos() {
		return multitabCabService.buscarTodos();
	}
	
	/**
	 * Retorna una cabecera de una multitabla buscada por atributo:  
	 * @param idMultitabCab
	 * 			el identificador de la cabecera de una multitabla 
	 * @param --
	 * @return	cabecera de una multitabla obtenida por búsqueda:
	 * 			{@link MultitabCabResponse}
	 */
	@GetMapping("/{idMultitabCab}")
	@PreAuthorize("hasPermission('MAN_MULTITAB_CAB','102')")
	public MultitabCabResponse buscarPorIdMultitabCab(
				@PathVariable("idMultitabCab") @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idMultitabCab) {
		return multitabCabService.buscarPorIdMultitabCab(idMultitabCab);
	}
	
	/**
	 * Recibe petición de registro de una cabecera de una multitabla.  
	 * @param multitabCabRequest
	 * 			la cabecera de una multitabla a registrar
	 * @param --
	 * @return	multitabla cabecera registrada
	 * 			{@link MultitabCabResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_MULTITAB_CAB','201')")
	public MultitabCabResponse registrarMultitabCab(@Valid @RequestBody MultitabCabRequest multitabCabRequest) {
		return multitabCabService.registrarMultitabCab(multitabCabRequest);
	}
	
	/**
	 * Recibe petición de actualización de una cabecera de una multitabla.  
	 * @param idMultitabCab
	 * 			el identificador de una cabecera de una multitabla a actualizar
	 * @param multitabCabRequest
	 * 			cabecera de una multitabla a actualizar
	 * @param --
	 * @return	cabecera de multitabla actualizada
	 * 			{@link MultitabCabResponse}
	 */
	@PutMapping("/{idMultitabCab}")
	@PreAuthorize("hasPermission('MAN_MULTITAB_CAB','301')")
	public MultitabCabResponse actualizarMultitabCab(
					@PathVariable("idMultitabCab") @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idMultitabCab,
					@Valid @RequestBody MultitabCabRequest multitabCabRequest) {
		return multitabCabService.actualizarMultitabCab(idMultitabCab, multitabCabRequest);
	}
	
	/**
	 * Recibe petición de eliminación de una cabecera de una multitabla.  
	 * @param idMultitabCab
	 * 			el identificador de una cabecera de una multitabla a eliminar
	 * @param --
	 * 		
	 */
	@DeleteMapping("/{idMultitabCab}")
	@PreAuthorize("hasPermission('MAN_MULTITAB_CAB','401')")
	public void eliminarMultitabCab(
				@PathVariable("idMultitabCab") @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idMultitabCab) {
		 multitabCabService.eliminarMultitabCab(MultitabCabRequest.builder().idMultitabCab(idMultitabCab).build());
	}
}
