package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EmpleadoDepLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EmpleadoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.EmpleadoRequest;
import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;

@Mapper
public interface EmpleadoMapper extends MantenibleMapper<EmpleadoRequest, EmpleadoResponse>{

	public List<EmpleadoResponse> buscarTodos();
	
	public EmpleadoResponse buscarPorCodigoEmpleado(@Param("codigoEmpleado") String codigoEmpleado);

	public List<EmpleadoResponse>  buscarPorCodigoDependencia(@Param("codigoDependencia") String codigoDependencia);

	public EmpleadoDepLocalResponse buscarPorNumeroDni(@Param("numeroDni") String numeroDni);
	
	public void mantener(String modo, EmpleadoRequest objetoMantenido ,String usuario);
}
