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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PerfilLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PerfilLocalRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.perfillocal.PerfilLocalService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de PerfilLocal 
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los perfilLocal
 * 	<li>Búsqueda de un perfilLocal por identificador de perfil y código de local 
 * 	<li>Registro de un perfilLocal
 * 	<li>Actualización de un perfilLocal
 * 	<li>Eliminación	 de un perfilLocal
 * </ul>
 * 
 * @author Ximena Politi
 * @see PerfilLocalRequest
 * @see PerfilLocalResponse
 * @see PerfilLocalService
 */
@Validated
@RestController
@RequestMapping("/perfiles-locales")
public class PerfilLocalRestController {
	
	private  PerfilLocalService perfilLocalService;
	
	public PerfilLocalRestController(PerfilLocalService perfilLocalService) {
		this.perfilLocalService = perfilLocalService;
	}
	
	/**
	 * Retorna una lista con todos los perfilLocal.  
	 * 
	 * @return	lista de perfilLocal obtenida por búsqueda es de tipo:
	 * 			{@link PerfilLocalResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_PERFIL_LOCAL','101')")
	public List<PerfilLocalResponse> buscarTodos() {
		return perfilLocalService.buscarTodos();
	}
	
	/**
	 * Retorna un perfilLocal buscado por atributo:  
	 * @param idPerfil
	 * 			el identificador del perfil
	 * @param codigoLocal
	 * 			el código del local
	 * @param --
	 * @return	perfilLocal obtenido por búsqueda:
	 * 			{@link PerfilLocalResponse}
	 */
	@GetMapping("/{idPerfil}/local/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_PERFIL_LOCAL','102')")
	public PerfilLocalResponse buscarPorIdPerfilYCodigoLocal(
				@PathVariable @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idPerfil
			   ,@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal ) {
		return perfilLocalService.buscarPorIdPerfilYCodigoLocal(idPerfil, codigoLocal);
	}
	
	/**
	 * Retorna una lista de perfilLocal buscados por atributo:  
	 * @param idPerfil
	 * 			el identificador del perfil
	 * @param --
	 * @return	perfilLocal obtenido por búsqueda:
	 * 			{@link PerfilLocalResponse}
	 */
	@GetMapping("/{idPerfil}")
	@PreAuthorize("hasPermission('MAN_PERFIL_LOCAL','103')")
	public List<PerfilLocalResponse> buscarPorIdPerfil(
				@PathVariable @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idPerfil) {
		return perfilLocalService.buscarPorIdPerfil(idPerfil);
	}
	
	/**
	 * Recibe petición de registro de un perfilLocal.  
	 * @param perfilLocalRequest
	 * 			el perfil a registrar
	 * @param --
	 * @return	perfilLocal registrado
	 * 			{@link PerfilLocalResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_PERFIL_LOCAL','201')")
	public PerfilLocalResponse registrarPerfilLocal(@Valid @RequestBody PerfilLocalRequest perfilLocalRequest) {
		return perfilLocalService.registrarPerfilLocal(perfilLocalRequest);
	}
	
	/**
	 * Recibe petición de actualización de un perfilLocal.  
	 * @param idPerfil
	 * 			el identificador del perfil
	 * @param codigoLocal
	 * 			el código del local
	 * @param perfilLocalRequest
	 * 			el perfilLocal a actualizar
	 * @param --
	 * @return	perfilLocal actualizado
	 * 			{@link PerfilLocalResponse}
	 */
	@PutMapping("/{idPerfil}/local/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_PERFIL_LOCAL','301')")
	public PerfilLocalResponse actualizarPerfilLocal(
				@PathVariable @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo")  Integer idPerfil,
				@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal,
				@Valid @RequestBody PerfilLocalRequest perfilLocalRequest) {
		return perfilLocalService.actualizarPerfilLocal(idPerfil, codigoLocal, perfilLocalRequest);
	}
	
	/**
	 * Recibe petición de eliminación de un perfilLocal.  
	 * @param idPerfil
	 * 			el identificador del perfil a eliminar
	 * @param codigoLocal
	 * 			el código del local
	 * @param --
	 * 		
	 */
	@DeleteMapping("/{idPerfil}/local/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_PERFIL_LOCAL','401')")
	public void eliminarPerfilLocal(
				@PathVariable @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idPerfil,
				@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal) {
		perfilLocalService.eliminarPerfilLocal(PerfilLocalRequest.builder().idPerfil(idPerfil).codigoLocal(codigoLocal).build());
	}
	
	
}
