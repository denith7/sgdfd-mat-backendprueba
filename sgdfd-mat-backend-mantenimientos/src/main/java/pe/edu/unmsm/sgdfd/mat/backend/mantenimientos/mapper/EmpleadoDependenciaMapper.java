package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EmpleadoDependenciaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.EmpleadoDependenciaRequest;
import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;

@Mapper
public interface EmpleadoDependenciaMapper extends MantenibleMapper<EmpleadoDependenciaRequest, EmpleadoDependenciaResponse>{

	public List<EmpleadoDependenciaResponse> buscarTodos();
	
	public List<EmpleadoDependenciaResponse> buscarPorCodigoDependencia(@Param("codigoDependencia") String codigoDependencia);
	
	public EmpleadoDependenciaResponse buscarPorCodigoDependenciaYCodigoEmpleado(@Param("codigoDependencia") String codigoDependencia, @Param("codigoEmpleado") String codigoEmpleado);
	
	public void mantener(String modo, EmpleadoDependenciaRequest objetoMantenido ,String usuario);
}
