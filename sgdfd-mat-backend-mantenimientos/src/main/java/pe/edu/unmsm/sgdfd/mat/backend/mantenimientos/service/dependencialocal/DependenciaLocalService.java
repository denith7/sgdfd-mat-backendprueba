package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.dependencialocal;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.DependenciaLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.DependenciaLocalRequest;

public interface DependenciaLocalService extends MantenibleService<DependenciaLocalRequest, DependenciaLocalResponse> {

	public List<DependenciaLocalResponse> buscarTodos();
	
	public DependenciaLocalResponse buscarPorCodigoDependenciaYCodigoLocal(String codigoDependencia, String codigoLocal);
	
	public DependenciaLocalResponse registrarDependenciaLocal(DependenciaLocalRequest dependenciaLocalRequest);

	public DependenciaLocalResponse actualizarDependenciaLocal(String codigoDependencia, String codigoLocal, DependenciaLocalRequest dependenciaLocalRequest);
	
	public void eliminarDependenciaLocal(DependenciaLocalRequest dependenciaLocalRequest);
	
}
