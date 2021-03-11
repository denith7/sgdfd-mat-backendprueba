package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.dependencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.DependenciaMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.DependenciaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.DependenciaRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de dependencias
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link DependenciaService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link DependenciaMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 * @author Ximena Politi
 */
@Service
public class DependenciaServiceImpl extends MantenibleAuditadoService<DependenciaRequest, DependenciaResponse> implements DependenciaService{

	private DependenciaMapper dependenciaMapper;
	
	/**
     * Instancia la interface {@link DependenciaMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public DependenciaServiceImpl(@Qualifier("dependenciaMapper") MantenibleMapper<DependenciaRequest, DependenciaResponse> mapper) {
        super(mapper);
        this.dependenciaMapper = (DependenciaMapper) mapper;
    }
	
	@Override
	public List<DependenciaResponse> buscarTodos() {
		return dependenciaMapper.buscarTodos();
	}

	@Override
	public DependenciaResponse buscarPorCodigoDependencia(String codigoDependencia) {
		System.out.println("ESTOOOOO:          "+codigoDependencia);
		return dependenciaMapper.buscarPorCodigoDependencia(codigoDependencia);
	}
	
	@Override
	public DependenciaResponse registrarDependencia(DependenciaRequest dependenciaRequest) {
		dependenciaMapper.mantener("INSERT",dependenciaRequest , dependenciaRequest.getUsuario());
    	return dependenciaMapper.buscarPorCodigoDependencia(dependenciaRequest.getCodigoDependencia());
	}

	@Override
	public DependenciaResponse actualizarDependencia(String codigoDependencia, DependenciaRequest dependenciaRequest) {
		dependenciaRequest.setCodigoDependencia(codigoDependencia);
		dependenciaMapper.mantener("UPDATE", dependenciaRequest, dependenciaRequest.getUsuario());
		return dependenciaMapper.buscarPorCodigoDependencia(dependenciaRequest.getCodigoDependencia());
	}

	@Override
	public void eliminarDependencia(DependenciaRequest dependenciaRequest) {
		eliminar(dependenciaRequest);
	}

	@Override
	public List<DependenciaResponse> buscarPorCodigoLocalSgd(String codigoLocalSgd) {
		return dependenciaMapper.buscarPorCodigoLocalSgd(codigoLocalSgd);
	}

}
