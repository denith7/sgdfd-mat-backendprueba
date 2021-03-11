package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.DependenciaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.DependenciaRequest;

@Mapper
public interface DependenciaMapper extends MantenibleMapper<DependenciaRequest ,DependenciaResponse>{

	public List<DependenciaResponse> buscarTodos();

	public DependenciaResponse buscarPorCodigoDependencia(@Param("codigoDependencia") String codigoDependencia);

	public List<DependenciaResponse> buscarPorCodigoLocalSgd(@Param("codigoLocalSgd") String codigoLocalSgd);

	public void mantener(String modo, DependenciaRequest objetoMantenido ,String usuario);
}
