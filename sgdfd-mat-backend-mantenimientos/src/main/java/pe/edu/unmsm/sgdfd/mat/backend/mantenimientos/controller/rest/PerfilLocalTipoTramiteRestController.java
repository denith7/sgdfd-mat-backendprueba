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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PerfilLocalTipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PerfilLocalTipoTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.perfillocaltipotramite.PerfilLocalTipoTramiteService;


/**
 * Recibe las solicitudes relacionadas al mantenimiento de PerfilLocalTipoTramite
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los perfilLocalTipoTramite
 * 	<li>Búsqueda de un perfilLocalTipoTramite por identificador de perfil, código de local e identificador de tipo de tramite 
 * 	<li>Registro de un perfilLocalTipoTramite
 * 	<li>Actualización de un perfilLocalTipoTramite
 * 	<li>Eliminación	de un perfilLocalTipoTramite
 * </ul>
 * 
 * @author Eric Robladillo
 * @see PerfilLocalTipoTramiteRequest
 * @see PerfilLocalTipoTramiteResponse
 * @see PerfilLocalTipoTramiteService
 */
@Validated
@RestController
@RequestMapping("/perfil-local-tipo-tramite")
public class PerfilLocalTipoTramiteRestController {

	private  PerfilLocalTipoTramiteService perfilLocalTipoTramiteService;
	
	public PerfilLocalTipoTramiteRestController(PerfilLocalTipoTramiteService perfilLocalTipoTramiteService) {
		this.perfilLocalTipoTramiteService = perfilLocalTipoTramiteService;
	}
	
	/**
	 * Retorna una lista con todos los perfilLocalTipoTramite.  
	 * 
	 * @return	lista de perfilLocalTipoTramite obtenida por búsqueda es de tipo:
	 * 			{@link PerfilLocalTipoTramiteResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_PERFIL_LOCAL_TIPO_TRAMITE','101')")
	public List<PerfilLocalTipoTramiteResponse> buscarTodos() {
		return perfilLocalTipoTramiteService.buscarTodos();
	}
	
	/**
	 * Retorna un perfilLocalTipoTramite buscado por atributo:  
	 * @param idPerfil
	 * 			el identificador del perfil
	 * @param codigoLocal
	 * 			el código del local
	 * @param idTipoTramite
	 * 			el identificador del tipo de tramite
	 * @param --
	 * @return	perfilLocalTipoTramite obtenido por búsqueda:
	 * 			{@link PerfilLocalTipoTramiteResponse}
	 */
	@GetMapping("/{idPerfil}/local/{codigoLocal}/tramite/{idTipoTramite}")
	@PreAuthorize("hasPermission('MAN_PERFIL_LOCAL_TIPO_TRAMITE','102')")
	public PerfilLocalTipoTramiteResponse buscarPorId(
				@PathVariable("idPerfil") @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idPerfil
			   ,@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal
			   ,@PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite) {
		return perfilLocalTipoTramiteService.buscarPorId(idPerfil, codigoLocal, idTipoTramite);
	}
	
	/**
	 * Recibe petición de registro de un perfilLocalTipoTramite.  
	 * @param perfilLocalTipoTramiteRequest
	 * 			el perfil a registrar
	 * @param --
	 * @return	perfilLocalTipoTramite registrado
	 * 			{@link PerfilLocalResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_PERFIL_LOCAL_TIPO_TRAMITE','201')")
	public PerfilLocalTipoTramiteResponse registrarPerfilLocalTipoTramite(@Valid @RequestBody PerfilLocalTipoTramiteRequest perfilLocalTipoTramiteRequest) {
		return perfilLocalTipoTramiteService.registrarPerfilLocalTipoTramite(perfilLocalTipoTramiteRequest);
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
//	@PutMapping("/{idPerfil}/local/{codigoLocal}/tramite/{idTipoTramite}")
//	public PerfilLocalTipoTramiteResponse actualizarPerfilLocal(
//				@PathVariable ("idPerfil") @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo")  Integer idPerfil,
//				@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal,
//				@PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite
//				@Valid @RequestBody PerfilLocalRequest perfilLocalRequest) {
//		return perfilLocalTipoTramiteService.actualizarPerfilLocal(idPerfil, codigoLocal, perfilLocalRequest);
//	}
//	
	/**
	 * Recibe petición de eliminación de un perfilLocal.  
	 * @param idPerfil
	 * 			el identificador del perfil a eliminar
	 * @param codigoLocal
	 * 			el código del local
	 * @param --
	 * 		
	 */
	@DeleteMapping("/{idPerfil}/local/{codigoLocal}/tramite/{idTipoTramite}")
	@PreAuthorize("hasPermission('MAN_PERFIL_LOCAL_TIPO_TRAMITE','401')")
	public void eliminarPerfilLocalTipoTramite(
				@PathVariable @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idPerfil,
				@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal,
				@PathVariable("idTipoTramite") @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idTipoTramite) {
		perfilLocalTipoTramiteService.eliminarPerfilLocalTipoTramite(PerfilLocalTipoTramiteRequest.builder().idPerfil(idPerfil).codigoLocal(codigoLocal).idTipoTramite(idTipoTramite).build());
	}
	
}
