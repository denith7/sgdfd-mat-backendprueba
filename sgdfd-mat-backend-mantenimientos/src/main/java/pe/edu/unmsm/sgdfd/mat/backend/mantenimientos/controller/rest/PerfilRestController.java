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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PerfilResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PerfilRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.perfil.PerfilService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de Perfiles 
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los perfiles
 * 	<li>Búsqueda de un perfil por su código
 * 	<li>Registro de un perfil
 * 	<li>Actualización de un perfil
 * 	<li>Eliminación	 de un perfil
 * </ul>
 * 
 * @author Ximena Politi
 * @see PerfilRequest
 * @see PerfilResponse
 * @see PerfilService
 */
@Validated
@RestController
@RequestMapping("/perfiles")
public class PerfilRestController {
	
	private  PerfilService perfilService;
	
	public PerfilRestController(PerfilService perfilService) {
		this.perfilService = perfilService;
	}
	
	/**
	 * Retorna una lista con todos los perfiles.  
	 * 
	 * @return	lista de perfiles obtenida por búsqueda es de tipo:
	 * 			{@link PerfilResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_PERFIL','101')")
	public List<PerfilResponse> buscarTodos() {
		return perfilService.buscarTodos();
	}
	
	/**
	 * Retorna un perfil buscado por atributo:  
	 * @param idPerfil
	 * 			el identificador del perfil
	 * @param --
	 * @return	perfil obtenido por búsqueda:
	 * 			{@link PerfilResponse}
	 */
	@GetMapping("/{idPerfil}")
	@PreAuthorize("hasPermission('MAN_PERFIL','102')")
	public PerfilResponse buscarPorIdPerfil(
				@PathVariable @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idPerfil) {
		return perfilService.buscarPorIdPerfil(idPerfil);
	}
	
	/**
	 * Recibe petición de registro de un perfil.  
	 * @param perfilRequest
	 * 			el perfil a registrar
	 * @param --
	 * @return	perfil registrado
	 * 			{@link PerfilResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_PERFIL','201')")
	public PerfilResponse registrarPerfil(@Valid @RequestBody PerfilRequest perfilRequest) {
		return perfilService.registrarPerfil(perfilRequest);
	}
	
	/**
	 * Recibe petición de actualización de un perfil.  
	 * @param idPerfil
	 * 			el identificador del perfil
	 * @param perfilRequest
	 * 			el perfil a actualizar
	 * @param --
	 * @return	perfil actualizado
	 * 			{@link PerfilResponse}
	 */
	@PutMapping("/{idPerfil}")
	@PreAuthorize("hasPermission('MAN_PERFIL','301')")
	public PerfilResponse actualizarPerfil(
				@PathVariable @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo")  Integer idPerfil,
				@Valid @RequestBody PerfilRequest perfilRequest) {
		return perfilService.actualizarPerfil(idPerfil, perfilRequest);
	}
	
	/**
	 * Recibe petición de eliminación de un perfil.  
	 * @param idPerfil
	 * 			el identificador del perfil a eliminar
	 * @param --
	 * 		
	 */
	@DeleteMapping("/{idPerfil}")
	@PreAuthorize("hasPermission('MAN_PERFIL','401')")
	public void eliminarPerfil(
				@PathVariable @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idPerfil) {
		perfilService.eliminarPerfil(PerfilRequest.builder().idPerfil(idPerfil).build());
	}
}
