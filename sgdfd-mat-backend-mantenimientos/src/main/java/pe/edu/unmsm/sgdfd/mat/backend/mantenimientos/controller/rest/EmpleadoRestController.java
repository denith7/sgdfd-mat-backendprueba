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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EmpleadoDepLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EmpleadoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.EmpleadoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.empleado.EmpleadoService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de empleados
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los empleados
 * 	<li>Búsqueda de un empleado por código de empleado
 *  <li>Búsqueda de un empleado por su DNI
 * 	<li>Registro de un empleado
 * 	<li>Actualización de un empleado
 * 	<li>Eliminación	de un empleado
 * </ul>
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see EmpleadoRequest
 * @see EmpleadoResponse
 * @see EmpleadoService
 */
@Validated
@RestController
@RequestMapping("/empleado")
public class EmpleadoRestController {
	
	private EmpleadoService empleadoService;
	
	public EmpleadoRestController(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}
	
	/**
	 * Retorna una lista de todos los empleados.  
	 * 
	 * @return	lista de empleados obtenida por búsqueda es de tipo:
	 * 			{@link EmpleadoResponse}
	 */
//	@PreAuthorize("hasPermission('CON_EMPLEADO','301')")
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_EMPLEADO','101')")
	public List<EmpleadoResponse> buscarTodos() {
		return empleadoService.buscarTodos();
	}
	
	/**
	 * Retorna un empleado buscado por atributo:  
	 * @param codigoEmpleado
	 * 			el código de empleado a buscar
	 * @param --
	 * @return	empleado obtenido por búsqueda:
	 * 			{@link EmpleadoResponse}
	 */
//	@PreAuthorize("hasPermission('CON_EMPLEADO','101')")
	@GetMapping("/{codigoEmpleado}")
	@PreAuthorize("hasPermission('MAN_EMPLEADO','102')")
	public EmpleadoResponse buscarPorCodigoEmpleado(@PathVariable("codigoEmpleado") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,20}", maxLength = 20 ) String codigoEmpleado) {
		return empleadoService.buscarPorCodigoEmpleado(codigoEmpleado);
	}
	
	/**
	 * Retorna un empleado buscado por atributo:  
	 * @param codigoEmpleado
	 * 			el código de empleado a buscar
	 * @return	empleado obtenido por búsqueda:
	 * 			{@link EmpleadoResponse}
	 */
//	@PreAuthorize("hasPermission('CON_EMPLEADO','301')")
	@GetMapping("dependencia/{codigoDependencia}")
//	@PreAuthorize("hasPermission('MAN_EMPLEADO','103')")
	//comentado para mantenimiento tramite
	public List<EmpleadoResponse> buscarPorCodigoDependencia(@PathVariable("codigoDependencia") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoDependencia) {
		return empleadoService.buscarPorCodigoDependencia(codigoDependencia);
	}
	
	/**
	 * Retorna un empleado buscado por atributo:  
	 * @param numeroDni
	 * 			el DNI del empleado a buscar
	 * @param --
	 * @return	empleado obtenido por búsqueda:
	 * 			{@link EmpleadoResponse}
	 */
//	@PreAuthorize("hasPermission('CON_EMPLEADO','101')")
	@GetMapping("/numero-documento/{numeroDni}")
//	@PreAuthorize("hasPermission('MAN_EMPLEADO','104')")
	public EmpleadoDepLocalResponse buscarPorNumeroDni(@PathVariable("numeroDni") @Size(min = 1, max = 8) String numeroDni) {
		return empleadoService.buscarPorNumeroDni(numeroDni);
	}
	
	/**
	 * Recibe petición de registro de un empleado.  
	 * @param empleadoRequest
	 * 			el empleado a registrar
	 * @param --
	 * @return	empleado registrado
	 * 			{@link EmpleadoResponse}
	 */
//	@PreAuthorize("hasPermission('CON_EMPLEADO','301')")
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_EMPLEADO','201')")
	public EmpleadoResponse registrarEmpleado(@Valid @RequestBody EmpleadoRequest empleadoRequest) {
		return empleadoService.registrarEmpleado(empleadoRequest);
	}
	
	/**
	 * Recibe petición de actualización de un empleado.  
	 * @param codigoEmpleado
	 * 			el código del empleado a actualizar
	 * @param empleadoRequest
	 * 			el empleado a actualizar
	 * @param --
	 * @return	empleado actualizado
	 * 			{@link EmpleadoResponse}
	 */
//	@PreAuthorize("hasPermission('CON_EMPLEADO','301')")
	@PutMapping("/{codigoEmpleado}")
	@PreAuthorize("hasPermission('MAN_EMPLEADO','301')")
	public EmpleadoResponse actualizarEmpleado(
					@PathVariable("codigoEmpleado") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,20}", maxLength = 20 ) String codigoEmpleado
				  ,@Valid @RequestBody EmpleadoRequest empleadoRequest) {
		return empleadoService.actualizarEmpleado(codigoEmpleado, empleadoRequest);
	}
	
	/**
	 * Recibe petición de eliminación de un empleado.  
	 * @param codigoEmpleado
	 * 			el código del empleado a eliminar
	 * @param --
	 * 		
	 */
//	@PreAuthorize("hasPermission('CON_EMPLEADO','301')")
	@DeleteMapping("/{codigoEmpleado}")
	@PreAuthorize("hasPermission('MAN_EMPLEADO','401')")
	public void eliminarEmpleado(
				@PathVariable("codigoEmpleado") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,20}", maxLength = 20 ) String codigoEmpleado) {
		empleadoService.eliminarEmpleado(EmpleadoRequest.builder().codigoEmpleado(codigoEmpleado).build());
	}
}
