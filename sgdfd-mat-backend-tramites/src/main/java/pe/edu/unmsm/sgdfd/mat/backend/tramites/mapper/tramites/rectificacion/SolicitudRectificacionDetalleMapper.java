package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.tramites.rectificacion;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.SolicitudRectificacionDetalleRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.SolicitudRectificacionDetalleResponse;


@Mapper
public interface SolicitudRectificacionDetalleMapper extends MantenibleMapper<SolicitudRectificacionDetalleRequest, SolicitudRectificacionDetalleResponse> 
{
	public SolicitudRectificacionDetalleResponse buscarPorId(Integer id);
		
	public List<SolicitudRectificacionDetalleResponse> buscarTodos();
		
	public void mantener(String modo, SolicitudRectificacionDetalleRequest objetoMantenido,String usuario);

}
