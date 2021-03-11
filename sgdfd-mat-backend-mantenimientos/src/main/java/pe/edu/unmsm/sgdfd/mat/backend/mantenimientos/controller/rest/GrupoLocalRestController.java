package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.GrupoLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.GrupoLocalRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.grupolocal.GrupoLocalService;


/**
 * Recibe las solicitudes relacionadas al mantenimiento de grupos de locales 
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los grupos de locales
 * 	<li>Búsqueda de un grupo de locales por su identificador
 * 	<li>Registro de un grupo de locales
 * 	<li>Actualización de un grupo de locales
 * 	<li>Eliminación	de un grupo de locales
 * </ul>
 * 
 * @author Miguel Moya
 * @see GrupoLocalRequest
 * @see GrupoLocalResponse
 * @see GrupoLocalService
 */
@Validated
@RestController
@RequestMapping("/grupos-local")
public class GrupoLocalRestController {
	
	private GrupoLocalService grupoLocalService;
	
	public GrupoLocalRestController(GrupoLocalService grupoLocalService) {
		this.grupoLocalService =  grupoLocalService;
	}
	
	/**
	 * Retorna una lista con todos los grupos de locales.  
	 * 
	 * @return	lista de grupos de locales obtenida por búsqueda es de tipo:
	 * 			{@link GrupoLocalResponse}
	 */
	@GetMapping
	@PreAuthorize("hasPermission('MAN_GRUPO_LOCAL','101')")
    public List<GrupoLocalResponse> buscarTodos(){
        return grupoLocalService.buscarTodos();
    }
	
	/**
	 * Retorna un grupo de locales buscado por atributo:  
	 * @param idGrupoLocal
	 * 			el idenfificador del grupo de locales
	 * @param --
	 * @return	grupo de locales obtenido por búsqueda:
	 * 			{@link GrupoLocalResponse}
	 */
	@GetMapping("/{idGrupoLocal}")
	@PreAuthorize("hasPermission('MAN_GRUPO_LOCAL','102')")
    public GrupoLocalResponse buscarPorIdGrupoLocal(
    		@PathVariable("idGrupoLocal") @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idGrupoLocal){
        return grupoLocalService.buscarPorIdGrupoLocal(idGrupoLocal);
    }
	
	/**
	 * Recibe petición de registro de un grupo de locales.  
	 * @param grupoLocalRequest
	 * 			el grupo de locales a registrar
	 * @param --
	 * @return	grupo de locales registrado
	 * 			{@link GrupoLocalResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_GRUPO_LOCAL','201')")
	@ResponseStatus(code = HttpStatus.CREATED)
    public GrupoLocalResponse registrarGrupoLocal( @Valid @RequestBody GrupoLocalRequest grupoLocalRequest){
        return grupoLocalService.registrarGrupoLocal(grupoLocalRequest);
    }
	
	/**
	 * Recibe petición de actualización de un grupo de locales.  
	 * @param idGrupoLocal
	 * 			el identificador del grupo de locales a actualizar
	 * @param grupoLocalRequest
	 * 			el grupo de locales a actualizar
	 * @param --
	 * @return	grupo de locales actualizado
	 * 			{@link GrupoLocalResponse}
	 */
    @PutMapping("/{idGrupoLocal}")
    @PreAuthorize("hasPermission('MAN_GRUPO_LOCAL','301')")
    public GrupoLocalResponse actualizarGrupoLocal(
    		@PathVariable("idGrupoLocal") @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idGrupoLocal
    		,@Valid @RequestBody GrupoLocalRequest grupoLocalRequest){
        return grupoLocalService.actualizarGrupoLocal(idGrupoLocal, grupoLocalRequest);
    }
    
    /**
	 * Recibe petición de eliminación de un grupo de locales.  
	 * @param idGrupoLocal
	 * 			el identificador del grupo de locales a eliminar
	 * @param --
	 * 		
	 */
    @DeleteMapping("/{idGrupoLocal}")
    @PreAuthorize("hasPermission('MAN_GRUPO_LOCAL','401')")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarGrupoLocal(
    		@PathVariable("idGrupoLocal") @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idGrupoLocal){
        grupoLocalService.eliminarGrupoLocal(GrupoLocalRequest.builder().idGrupoLocal(idGrupoLocal).build());        
    }
}
