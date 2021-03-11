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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EmpleadoDependenciaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.EmpleadoDependenciaRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.empleadodependencia.EmpleadoDependenciaService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de Empleados de Dependencias, asi
 * como tambien de busquedas por diferentes atributos que retornan o listas 
 * o un Empleado de Dependencia
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los empleados de todas las dependencias
 *  <li>Buscar todos los empleados de una dependencia por código de dependencia
 * 	<li>Búsqueda de un empleado de una dependencia por el código de dependencia y código de empleado
 * 	<li>Registro de un empleado a una dependencia 
 * 	<li>Actualización de un empleado de una dependencia 
 * 	<li>Eliminación de un empleado de una dependencia 
 * </ul>
 * 
 * @author Ximena Politi
 * @see EmpleadoDependenciaRequest
 * @see EmpleadoDependenciaResponse
 * @see EmpleadoDependenciaService
 */
@Validated
@RestController
@RequestMapping("/empleado-dependencia")
public class EmpleadoDependenciaRestController {
	
	
	private  EmpleadoDependenciaService empleadoDependenciaService;
	
	public EmpleadoDependenciaRestController(EmpleadoDependenciaService empleadoDependenciaService) {
		this.empleadoDependenciaService = empleadoDependenciaService;
	}
	
	/**
	 * Retorna una lista con todos los empleados de todas las dependencias.  
	 * 
	 * @return	lista de empleados por dependencia obtenida por búsqueda es de tipo:
	 * 			{@link EmpleadoDependenciaResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_EMPLEADO_DEPENDENCIA','101')")
	public List<EmpleadoDependenciaResponse> buscarTodos() {
		return empleadoDependenciaService.buscarTodos();
	}
	
	/**
	 * Retorna una lista de todos los empleados de una dependencia buscada por atributo:  
	 * @param codigoDependencia
	 * 			el código de la dependencia a la que pertenecen los empleados 			
	 * @param --
	 * @return	lista de empleados de una dependencia obtenida por búsqueda es de tipo:
	 * 			{@link EmpleadoDependenciaResponse}
	 */
	@GetMapping("/{codigoDependencia}")
	@PreAuthorize("hasPermission('MAN_EMPLEADO_DEPENDENCIA','102')")
	public List<EmpleadoDependenciaResponse> buscarPorCodigoDependencia(
				@PathVariable("codigoDependencia") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoDependencia) {
		return empleadoDependenciaService.buscarPorCodigoDependencia(codigoDependencia);
	}
	
	/**
	 * Retorna un empleado de una dependencia buscado por atributos:  
	 * @param codigoDependencia
	 * 			el código de la dependencia a la que pertenece el empleado a buscar 	
	 * @param codigoEmpleado
	 * 			el código del empleado a buscar 		
	 * @param --
	 * @return	empleado de una dependencia obtenido por búsqueda:
	 * 			{@link EmpleadoDependenciaResponse}
	 */
	@GetMapping("/dependencia/{codigoDependencia}/empleado/{codigoEmpleado}")
	@PreAuthorize("hasPermission('MAN_EMPLEADO_DEPENDENCIA','103')")
	public EmpleadoDependenciaResponse buscarPorCodigoDependenciaYCodigoEmpleado(
						@PathVariable("codigoDependencia") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoDependencia
					   ,@PathVariable("codigoEmpleado") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,20}", maxLength = 20 ) String codigoEmpleado) {
		return empleadoDependenciaService.buscarPorCodigoDependenciaYCodigoEmpleado(codigoDependencia, codigoEmpleado);
	}
	
	/**
	 * Recibe petición de registro de un empleado para una dependencia.  
	 * @param empleadoDependenciaRequest
	 * 			el empleado de dependencia a registrar
	 * @param --
	 * @return	empleado de dependencia registrado
	 * 			{@link EmpleadoDependenciaResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_EMPLEADO_DEPENDENCIA','201')")
	public EmpleadoDependenciaResponse registrarEmpleadoDependencia( @Valid @RequestBody EmpleadoDependenciaRequest empleadoDependenciaRequest) {
		return empleadoDependenciaService.registrarEmpleadoDependencia(empleadoDependenciaRequest);
	}
	
	/**
	 * Recibe petición de actualización de un empleado de una dependencia.  
	 * @param codigoDependencia
	 * 			el código de la dependencia a la que pertenece el empleado
	 * @param codigoEmpleado
	 * 			el código del empleado
	 * @param empleadoDependenciaRequest
	 * 			el empleado de dependencia a actualizar
	 * @param --
	 * @return	empleado de dependencia actualizado
	 * 			{@link EmpleadoDependenciaResponse}
	 */
	@PutMapping("/dependencia/{codigoDependencia}/empleado/{codigoEmpleado}")
	@PreAuthorize("hasPermission('MAN_EMPLEADO_DEPENDENCIA','301')")
	public EmpleadoDependenciaResponse actualizarEmpleadoDependencia(
							@PathVariable("codigoDependencia") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoDependencia
			  			   ,@PathVariable("codigoEmpleado") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,20}", maxLength = 20 )	String codigoEmpleado
			  			   ,@Valid @RequestBody EmpleadoDependenciaRequest empleadoDependenciaRequest) {
		return empleadoDependenciaService.actualizarEmpleadoDependencia(codigoDependencia, codigoEmpleado, empleadoDependenciaRequest);
	}
	
	/**
	 * Recibe petición de eliminación de un empleado de una dependencia.  
	 * @param codigoDependencia
	 * 			el código de la dependencia a la que pertenece el empleado
	 * @param codigoEmpleado
	 * 			el código del empleado
	 * @param --
	 * 		
	 */
	@DeleteMapping("/dependencia/{codigoDependencia}/empleado/{codigoEmpleado}")
	@PreAuthorize("hasPermission('MAN_EMPLEADO_DEPENDENCIA','401')")
	public void eliminarEmpleadoDependencia(
						@PathVariable("codigoDependencia") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoDependencia
					   ,@PathVariable("codigoEmpleado") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,20}", maxLength = 20 ) String codigoEmpleado) {
		empleadoDependenciaService.eliminarEmpleadoDependencia(EmpleadoDependenciaRequest.builder()
															.codigoDependencia(codigoDependencia)
															.codigoEmpleado(codigoEmpleado).build());
	}
	
	

}
