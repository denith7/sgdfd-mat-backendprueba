package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.DependenciaLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.DependenciaLocalRequest;

@Mapper
public interface DependenciaLocalMapper extends MantenibleMapper<DependenciaLocalRequest, DependenciaLocalResponse> {

	public List<DependenciaLocalResponse> buscarTodos();
	
	public DependenciaLocalResponse buscarPorCodigoDependenciaYCodigoLocal(String codigoDependencia, String codigoLocal);
	
	public void mantener(String modo, DependenciaLocalRequest objetoMantenido, String usuario);
	
}
