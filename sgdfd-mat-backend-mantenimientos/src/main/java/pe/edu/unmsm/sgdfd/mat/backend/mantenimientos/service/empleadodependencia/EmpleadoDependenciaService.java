package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.empleadodependencia;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EmpleadoDependenciaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.EmpleadoDependenciaRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de empleado por dependencia,
 * y de busquedas por diferentes atributos que retornen o listas o un empleado de dependencia
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Ximena Politi
 * @see MantenibleService
 * @see EmpleadoDependenciaRequest
 * @see EmpleadoDependenciaResponse
 */
public interface EmpleadoDependenciaService extends MantenibleService<EmpleadoDependenciaRequest, EmpleadoDependenciaResponse>
{
	/**
	 * Retorna una lista con todos los empleados por dependencia 	
	 */
	public List<EmpleadoDependenciaResponse> buscarTodos();
	
	/**
	 * Retorna una lista de empleados de dependencia buscada por:
	 * @param codigoDependencia
	 * 			el código de la dependencia a buscar 		
	 */
	public List<EmpleadoDependenciaResponse> buscarPorCodigoDependencia(String codigoDependencia);
	
	/**
	 * Retorna un empleado de una dependencia buscado por:
	 * @param codigoDependencia
	 * 			el código de dependencia a buscar 	
	 * @param codigoEmpleado
	 * 			el código del empleado a buscar de una dependencia
	 */
	public EmpleadoDependenciaResponse buscarPorCodigoDependenciaYCodigoEmpleado(String codigoDependencia, String codigoEmpleado);
	
	/**
	 * Registra un empleado por dependencia 
	 * @param empleadoDependenciaRequest
	 * 			el empleado a registrar de una dependencia 
	 */
	public EmpleadoDependenciaResponse registrarEmpleadoDependencia(EmpleadoDependenciaRequest empleadoDependenciaRequest);
	
	/**
	 * Actualiza un empleado perteneciente a una dependencia 
	 * @param codigoDependencia
	 * 			el código de la dependencia	
	 * @param codigoEmpleado
	 * 			el código del empleado a buscar	
	 * @param empleadoDependenciaRequest
	 * 			el empleado a actualizar de una dependencia 
	 */
	public EmpleadoDependenciaResponse actualizarEmpleadoDependencia(String codigoDependencia, String codigoEmpleado ,EmpleadoDependenciaRequest empleadoDependenciaRequest);
	
	/**
	 * Elimina un empleado de una dependencia 
	 * @param empleadoDependenciaRequest
	 * 			el empleado a eliminar de una dependencia 
	 */
	public void eliminarEmpleadoDependencia(EmpleadoDependenciaRequest empleadoDependenciaRequest);
	
}
