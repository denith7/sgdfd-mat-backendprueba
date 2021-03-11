package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.UbigeoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.UbigeoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.ubigeo.UbigeoService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de ubigeos,
 * ademas de incluir busquedas de todos los departamentos, provincias o distritos
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los ubigeos
 *  <li>Buscar todos los departamentos
 *  <li>Buscar todos las provincias por departamento
 *  <li>Buscar todos los distritos por provincia
 * 	<li>Búsqueda de un ubigeo por su código
 * 	<li>Registro de un ubigeo
 * 	<li>Actualización de un ubigeo
 * 	<li>Eliminación	de un ubigeo
 * </ul>
 * 
 * @author Ximena Politi
 * @see UbigeoRequest
 * @see UbigeoResponse
 * @see UbigeoService
 */
@Validated
@RestController
@RequestMapping("/ubigeos")
public class UbigeoRestController {

	private UbigeoService ubigeoService;

	public UbigeoRestController(UbigeoService ubigeoService) {
		this.ubigeoService = ubigeoService;
	}

	/**
	 * Retorna una lista con todos los ubigeos.  
	 * 
	 * @return	lista de ubigeos obtenida por búsqueda es de tipo:
	 * 			{@link UbigeoResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_UBIGEO','101')")
	public List<UbigeoResponse> buscarTodos() {
		return ubigeoService.buscarTodos();
	}
	
	/**
	 * Retorna una lista de ubigeos que muestra todos los departamentos.  
	 * 
	 * @return	lista de ubigeos obtenida por búsqueda es de tipo:
	 * 			{@link UbigeoResponse}
	 */
	@GetMapping("/departamentos")
	@PreAuthorize("hasPermission('MAN_UBIGEO','102')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<UbigeoResponse> buscarTodosPorDepartamentos() {
		return ubigeoService.buscarTodosPorDepartamentos();
	}
	
	/**
	 * Retorna una lista de ubigeos que muestra todas las provincias por cada departamento
	 * @param codigoDepartamento
	 * 			el código de departamento			
	 * @param --
	 * @return	lista de ubigeos obtenida por búsqueda es de tipo:
	 * 			{@link UbigeoResponse}
	 */
	@GetMapping("/departamentos/{codigoDepartamento}/provincias")
	@PreAuthorize("hasPermission('MAN_UBIGEO','103')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<UbigeoResponse> obtenerProvincias(
				@PathVariable("codigoDepartamento") @Size(min = 1, max = 2) String codigoDepartamento) {
		return ubigeoService.obtenerProvincias(codigoDepartamento);
	}
	
	/**
	 * Retorna una lista de ubigeos que muestra todos los distritos por cada provincia
	 * @param codigoDepartamento
	 * 			el código de departamento		
	 * @param codigoProvincia
	 * 			el código de provincia	
	 * @param --
	 * @return	lista de ubigeos obtenida por búsqueda es de tipo:
	 * 			{@link UbigeoResponse}
	 */
	@GetMapping("/departamentos/{codigoDepartamento}/provincias/{codigoProvincia}/distritos")
	@PreAuthorize("hasPermission('MAN_UBIGEO','104')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<UbigeoResponse> obtenerDistritos(
					@PathVariable("codigoDepartamento") @Size(min = 1, max = 2) String codigoDepartamento
					,@PathVariable("codigoProvincia") @Size(min = 1, max = 2) String codigoProvincia) {
		return ubigeoService.obtenerDistritos(codigoDepartamento, codigoProvincia);
	}
	
	/**
	 * Retorna un ubigeo buscado por atributo:  
	 * @param codigoUbigeo
	 * 			el código de ubigeo
	 * @param --
	 * @return	ubigeo obtenido por búsqueda:
	 * 			{@link UbigeoResponse}
	 */
	@GetMapping("/{codigoUbigeo}")
	@PreAuthorize("hasPermission('MAN_UBIGEO','105')")
	public UbigeoResponse buscarPorCodigoUbigeo(
					@PathVariable("codigoUbigeo") @IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,10}", maxLength = 6) String codigoUbigeo) {
		return ubigeoService.buscarPorCodigoUbigeo(codigoUbigeo);
	}
	
	/**
	 * Recibe petición de registro de un ubigeo.  
	 * @param ubigeoRequest
	 * 			el ubigeo a registrar
	 * @param --
	 * @return	ubigeo registrado
	 * 			{@link UbigeoResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_UBIGEO','201')")
	public UbigeoResponse registrarUbigeo( @Valid @RequestBody UbigeoRequest ubigeoRequest) {
		return ubigeoService.registrarUbigeo(ubigeoRequest);
	}
	
	/**
	 * Recibe petición de actualización de un ubigeo.  
	 * @param codigoUbigeo
	 * 			el código del ubigeo
	 * @param ubigeoRequest
	 * 			el ubigeo a actualizar
	 * @param --
	 * @return	ubigeo actualizado
	 * 			{@link UbigeoResponse}
	 */
	@PutMapping("/{codigoUbigeo}")
	@PreAuthorize("hasPermission('MAN_UBIGEO','301')")
	public UbigeoResponse actualizarUbigeo(
					@PathVariable("codigoUbigeo") @IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,10}", maxLength = 6) String codigoUbigeo
				   ,@Valid @RequestBody UbigeoRequest ubigeoRequest) {
		return ubigeoService.actualizarUbigeo(codigoUbigeo, ubigeoRequest);
	}
	
	/**
	 * Recibe petición de eliminación de un ubigeo.  
	 * @param codigoUbigeo
	 * 			el código del ubigeo a eliminar
	 * @param --
	 * 		
	 */
	@DeleteMapping("/{codigoUbigeo}")
	@PreAuthorize("hasPermission('MAN_UBIGEO','401')")
	public void eliminarUbigeo(
					@PathVariable("codigoUbigeo") @IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,10}", maxLength = 6) String codigoUbigeo) {
		ubigeoService.eliminarUbigeo(UbigeoRequest.builder().codigoUbigeo(codigoUbigeo).build());
	}

}


