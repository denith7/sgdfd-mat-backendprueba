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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.DependenciaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.DependenciaRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.dependencia.DependenciaService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de dependencias
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos las dependencias
 * 	<li>Búsqueda de una dependencia por código de dependencia
 * 	<li>Registro de una dependencia
 * 	<li>Actualización de una dependencia
 * 	<li>Eliminación	de una dependencia
 * </ul>
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see DependenciaRequest
 * @see DependenciaResponse
 * @see DependenciaService
 */
@Validated
@RestController
@RequestMapping("/dependencia")
public class DependenciaRestController {

	private DependenciaService dependenciaService;
	
	public DependenciaRestController(DependenciaService dependenciaService) {
		this.dependenciaService = dependenciaService;
	}
	
	/**
	 * Retorna una lista con todas las dependencias.  
	 * 			
	 * @return	lista de dependencias obtenidas por búsqueda son de tipo:
	 * 			{@link DependenciaResponse}
	 */
	@GetMapping("/")
//	@PreAuthorize("hasPermission('MAN_DEPENDENCIA','101')")
	//comentado para mantenimiento tramite
	public List<DependenciaResponse> buscarTodos() {
		return this.dependenciaService.buscarTodos();
	}
	
	/**
	 * Retorna una dependencia buscada por atributo:  
	 * @param codigoDependencia
	 * 			el codigo de la dependencia a buscar
	 * @param --
	 * @return	dependencia obtenida por búsqueda:
	 * 			{@link DependenciaResponse}
	 */
	@GetMapping("/{codigoDependencia}")
//	@PreAuthorize("hasPermission('MAN_DEPENDENCIA','102')")
	//comentado para mantenimiento tramite
	public DependenciaResponse buscarPorCodigoDependencia(@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoDependencia) {
		return dependenciaService.buscarPorCodigoDependencia(codigoDependencia);
	}
	
	/**
	 * Retorna una dependencia buscada por atributo:  
	 * @param codigoDependencia
	 * 			el codigo de la dependencia a buscar
	 * @param --
	 * @return	dependencia obtenida por búsqueda:
	 * 			{@link DependenciaResponse}
	 */
	@GetMapping("local-sgd/{codigoLocalSgd}")
	@PreAuthorize("hasPermission('MAN_DEPENDENCIA','103')")
	public List<DependenciaResponse> buscarPorCodigoLocalSgd(@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocalSgd) {
		return this.dependenciaService.buscarPorCodigoLocalSgd(codigoLocalSgd);
	}
	
	/**
	 * Recibe petición de registro de una dependencia.  
	 * @param dependenciaRequest
	 * 			la dependencia a registrar
	 * @param --
	 * @return	dependencia registrada
	 * 			{@link DependenciaResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_DEPENDENCIA','201')")
	public DependenciaResponse registrarDependencia( @Valid @RequestBody DependenciaRequest dependenciaRequest) {
		return dependenciaService.registrarDependencia(dependenciaRequest);
	}
	
	/**
	 * Recibe petición de actualización de una dependencia.  
	 * @param codigoDependencia
	 * 			el código de la dependencia a actualizar
	 * @param dependenciaRequest
	 * 			la dependencia a actualizar
	 * @param --
	 * @return	dependencia actualizada
	 * 			{@link DependenciaResponse}
	 */
	@PutMapping("/{codigoDependencia}")
	@PreAuthorize("hasPermission('MAN_DEPENDENCIA','301')")
	public DependenciaResponse actualizarDependencia(@PathVariable("codigoDependencia") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoDependencia, 
													@Valid @RequestBody DependenciaRequest dependenciaRequest) {
		return dependenciaService.actualizarDependencia(codigoDependencia, dependenciaRequest);
	}
	
	/**
	 * Recibe petición de eliminación de una dependencia.  
	 * @param codigoDependencia
	 * 			el código de la dependencia a eliminar
	 * @param --
	 * 		
	 */
	@DeleteMapping("/{codigoDependencia}")
	@PreAuthorize("hasPermission('MAN_DEPENDENCIA','401')")
	public void eliminarDependencia(@PathVariable("codigoDependencia") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoDependencia) {
		dependenciaService.eliminarDependencia(DependenciaRequest.builder().codigoDependencia(codigoDependencia).build());
	}
}
