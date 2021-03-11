package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.dependencialocal;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.DependenciaLocalMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.DependenciaLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.DependenciaLocalRequest;

@Service
@Transactional
public class DependenciaLocalServiceImpl extends MantenibleAuditadoService<DependenciaLocalRequest, DependenciaLocalResponse>
		implements DependenciaLocalService {

	private DependenciaLocalMapper dependenciaLocalMapper;
	
	public DependenciaLocalServiceImpl(@Qualifier("dependenciaLocalMapper") MantenibleMapper<DependenciaLocalRequest, DependenciaLocalResponse> mapper) {
		super(mapper);
		this.dependenciaLocalMapper = (DependenciaLocalMapper) mapper;
	}
	
	@Override
	public List<DependenciaLocalResponse> buscarTodos(){
		return dependenciaLocalMapper.buscarTodos();
	}
	
	@Override
	public DependenciaLocalResponse buscarPorCodigoDependenciaYCodigoLocal(String codigoDependencia,
			String codigoLocal) {
		return dependenciaLocalMapper.buscarPorCodigoDependenciaYCodigoLocal(codigoDependencia, codigoLocal);
	}
	
	@Override
	public DependenciaLocalResponse registrarDependenciaLocal(DependenciaLocalRequest dependenciaLocalRequest) {
		dependenciaLocalMapper.mantener("INSERT", dependenciaLocalRequest, dependenciaLocalRequest.getUsuario());
		return dependenciaLocalMapper.buscarPorCodigoDependenciaYCodigoLocal(dependenciaLocalRequest.getCodigoDependencia(), 
				dependenciaLocalRequest.getCodigoLocal());
	}

	@Override
	public DependenciaLocalResponse actualizarDependenciaLocal(String codigoDependencia, String codigoLocal,
			DependenciaLocalRequest dependenciaLocalRequest) {
		dependenciaLocalRequest.setCodigoDependencia(codigoDependencia);
		dependenciaLocalRequest.setCodigoLocal(codigoLocal);
		dependenciaLocalMapper.mantener("UPDATE", dependenciaLocalRequest, dependenciaLocalRequest.getUsuario());
		return dependenciaLocalMapper.buscarPorCodigoDependenciaYCodigoLocal(dependenciaLocalRequest.getCodigoDependencia(), 
				dependenciaLocalRequest.getCodigoLocal());
	}

	@Override
	public void eliminarDependenciaLocal(DependenciaLocalRequest dependenciaLocalRequest) {
		eliminar(dependenciaLocalRequest);
	}
	
}
