package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.empleado;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EmpleadoDepLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EmpleadoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.EmpleadoRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de empleados,
 * asi como de busquedas por distintos atributos que retornaran un empleado
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see MantenibleService
 * @see EmpleadoRequest
 * @see EmpleadoResponse
 */
public interface EmpleadoService extends MantenibleService<EmpleadoRequest, EmpleadoResponse>{
	
	/**
	 * Retorna una lista de empleados 	
	 */
	List<EmpleadoResponse> buscarTodos();
	
	/**
	 * Retorna un empleado por:
	 * @param codigoEmpleado
	 * 			codigo identificador del empleado a buscar		
	 */
	public EmpleadoResponse buscarPorCodigoEmpleado(String codigoEmpleado);
	
	/**
	 * Retorna una lista de empleados por:
	 * @param codigoDependencia
	 * 			código identificador de la depedencia a donde los empleados pertenecen		
	 */
	public List<EmpleadoResponse> buscarPorCodigoDependencia(String codigoDependencia);
	
	/**
	 * Retorna un empleado por:
	 * @param numeroDni
	 * 			DNI del empleado a buscar		
	 */
	public EmpleadoDepLocalResponse buscarPorNumeroDni(String numeroDni);
	
	/**
	 * Registra un empleado 
	 * @param empleadoRequest
	 * 			el empleado a registrar	
	 */
	public EmpleadoResponse registrarEmpleado(EmpleadoRequest empleadoRequest);
	
	/**
	 * Actualiza un empleado 
	 * @param codigoEmpleado
	 * 			codigo identificador del empleado a actualizar	
	 * @param empleadoRequest
	 * 			el empleado a actualizar	
	 */
    public EmpleadoResponse actualizarEmpleado(String codigoEmpleado, EmpleadoRequest empleadoRequest);
    
    /**
	 * Elimina un empleado 
	 * @param empleadoRequest
	 * 			empleado a eliminar		
	 */
    public void eliminarEmpleado(EmpleadoRequest empleadoRequest);
}
