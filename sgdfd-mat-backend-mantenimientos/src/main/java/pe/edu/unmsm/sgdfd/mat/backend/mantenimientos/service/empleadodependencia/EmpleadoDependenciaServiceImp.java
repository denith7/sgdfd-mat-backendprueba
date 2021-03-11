package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.empleadodependencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.EmpleadoDependenciaMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EmpleadoDependenciaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.EmpleadoDependenciaRequest;


/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de empleados de dependencias y de
 * busquedas por diferentes atributos que pueden retornar
 * o una lista o un empleado de una dependencia
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link EmpleadoDependenciaService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link EmpleadoDependenciaMapper} solo para operaciones de mantenimiento. 
 *
 * @author Ximena Politi
 */
@Service
@Transactional
public class EmpleadoDependenciaServiceImp extends MantenibleAuditadoService<EmpleadoDependenciaRequest, EmpleadoDependenciaResponse> 
		implements EmpleadoDependenciaService{

	private EmpleadoDependenciaMapper empleadoDependenciaMapper;
	
	/**
     * Instancia la interface {@link EmpleadoDependenciaMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public EmpleadoDependenciaServiceImp(@Qualifier("empleadoDependenciaMapper") MantenibleMapper<EmpleadoDependenciaRequest, EmpleadoDependenciaResponse> mapper) {
		super(mapper);
		this.empleadoDependenciaMapper = (EmpleadoDependenciaMapper) mapper;
	}
	
	@Override
	public List<EmpleadoDependenciaResponse> buscarTodos(){
		return empleadoDependenciaMapper.buscarTodos();
	}
	
	@Override
	public List<EmpleadoDependenciaResponse> buscarPorCodigoDependencia(String codigoDependencia) {
		return empleadoDependenciaMapper.buscarPorCodigoDependencia(codigoDependencia);
	}

	@Override
	public EmpleadoDependenciaResponse buscarPorCodigoDependenciaYCodigoEmpleado(String codigoDependencia, String codigoEmpleado) {
		return empleadoDependenciaMapper.buscarPorCodigoDependenciaYCodigoEmpleado(codigoDependencia, codigoEmpleado);
	}

	@Override
	public EmpleadoDependenciaResponse registrarEmpleadoDependencia(EmpleadoDependenciaRequest EmpleadoDependenciaRequest) {
		empleadoDependenciaMapper.mantener("INSERT", EmpleadoDependenciaRequest, EmpleadoDependenciaRequest.getUsuario());
		return empleadoDependenciaMapper.buscarPorCodigoDependenciaYCodigoEmpleado(EmpleadoDependenciaRequest.getCodigoDependencia()
																				 , EmpleadoDependenciaRequest.getCodigoEmpleado());
	}

	@Override
	public EmpleadoDependenciaResponse actualizarEmpleadoDependencia(String codigoDependencia, String codigoEmpleado,
			EmpleadoDependenciaRequest EmpleadoDependenciaRequest) {
		EmpleadoDependenciaRequest.setCodigoDependencia(codigoDependencia);
		EmpleadoDependenciaRequest.setCodigoEmpleado(codigoEmpleado);
		empleadoDependenciaMapper.mantener("UPDATE", EmpleadoDependenciaRequest, EmpleadoDependenciaRequest.getUsuario());
		return empleadoDependenciaMapper.buscarPorCodigoDependenciaYCodigoEmpleado(EmpleadoDependenciaRequest.getCodigoDependencia()
																				 , EmpleadoDependenciaRequest.getCodigoEmpleado());
	}

	@Override
	public void eliminarEmpleadoDependencia(EmpleadoDependenciaRequest EmpleadoDependenciaRequest) {
		eliminar(EmpleadoDependenciaRequest);
		
	}

}
