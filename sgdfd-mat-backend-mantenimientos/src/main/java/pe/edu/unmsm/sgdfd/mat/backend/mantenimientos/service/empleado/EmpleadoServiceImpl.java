package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.EmpleadoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EmpleadoDepLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EmpleadoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.EmpleadoRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de empleado y de busquedas por
 * diferentes atributos que retornaran un Empleado.
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link EmpleadoService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link EmpleadoMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 * @author Ximena Politi
 */
@Service
public class EmpleadoServiceImpl extends MantenibleAuditadoService<EmpleadoRequest, EmpleadoResponse> implements EmpleadoService{

	private EmpleadoMapper empleadoMapper;
	
	/**
     * Instancia la interface {@link EmpleadoMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public EmpleadoServiceImpl(@Qualifier("empleadoMapper") MantenibleMapper<EmpleadoRequest, EmpleadoResponse> mapper) {
        super(mapper);
        this.empleadoMapper = (EmpleadoMapper) mapper;
    }

	@Override
	public List<EmpleadoResponse> buscarTodos() {
		return empleadoMapper.buscarTodos();
	}
	
	@Override
	public EmpleadoResponse buscarPorCodigoEmpleado(String codigoEmpleado) {
		return empleadoMapper.buscarPorCodigoEmpleado(codigoEmpleado);
	}
	
	@Override
	public List<EmpleadoResponse> buscarPorCodigoDependencia(String codigoDependencia) {
		return empleadoMapper.buscarPorCodigoDependencia(codigoDependencia);
	}
	
	@Override
	public EmpleadoDepLocalResponse buscarPorNumeroDni(String numeroDni) {
		return empleadoMapper.buscarPorNumeroDni(numeroDni);
	}
	
	 @Override
		public EmpleadoResponse registrarEmpleado(EmpleadoRequest empleadoRequest) {
		 	empleadoMapper.mantener("INSERT",empleadoRequest , empleadoRequest.getUsuario());
	    	return empleadoMapper.buscarPorCodigoEmpleado(empleadoRequest.getCodigoEmpleado());
		}

		@Override
		public EmpleadoResponse actualizarEmpleado(String codigoEmpleado, EmpleadoRequest empleadoRequest) {
			empleadoRequest.setCodigoEmpleado(codigoEmpleado);
			empleadoMapper.mantener("UPDATE", empleadoRequest, empleadoRequest.getUsuario());
			return empleadoMapper.buscarPorCodigoEmpleado(empleadoRequest.getCodigoEmpleado());
		}

		@Override
		public void eliminarEmpleado(EmpleadoRequest empleadoRequest) {
			eliminar(empleadoRequest);
		}
	
}
