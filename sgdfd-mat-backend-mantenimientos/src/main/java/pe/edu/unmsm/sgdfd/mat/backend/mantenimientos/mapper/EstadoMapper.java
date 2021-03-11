package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EstadoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.EstadoRequest;


@Mapper
public interface EstadoMapper extends MantenibleMapper<EstadoRequest, EstadoResponse> 
{

	public List<EstadoResponse> buscarTodos();
	
	public EstadoResponse buscarPorTablaOrigenYCodigoEstado(@Param("tablaOrigen") String tablaOrigen
			   												,@Param("codigoEstado") String codigoEstado);
	
	public List<EstadoResponse> buscarPorTablaOrigen(@Param("tablaOrigen") String tablaOrigen);
	
	public void mantener(String modo, EstadoRequest objetoMantenido ,String usuario);
	
}
