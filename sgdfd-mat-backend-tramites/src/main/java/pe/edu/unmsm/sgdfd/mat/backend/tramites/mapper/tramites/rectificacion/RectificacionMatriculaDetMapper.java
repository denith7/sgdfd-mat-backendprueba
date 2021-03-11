package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.tramites.rectificacion;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.RectificacionMatriculaDetalleRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.RectificacionMatriculaDetalleResponse;


@Mapper
public interface RectificacionMatriculaDetMapper extends MantenibleMapper<RectificacionMatriculaDetalleRequest,RectificacionMatriculaDetalleResponse > 
{

	public List<RectificacionMatriculaDetalleResponse> buscarTodos();
}
