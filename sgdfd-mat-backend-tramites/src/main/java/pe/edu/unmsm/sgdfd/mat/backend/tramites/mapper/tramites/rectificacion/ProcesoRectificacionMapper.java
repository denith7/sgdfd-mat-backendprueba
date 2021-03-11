package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.tramites.rectificacion;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.rectificacion.ProcesoRectificacionFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.ProcesoRectificacionRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.ProcesoRectificacionResponse;


@Mapper
public interface ProcesoRectificacionMapper extends MantenibleMapper<ProcesoRectificacionRequest,ProcesoRectificacionResponse>
{
	public ProcesoRectificacionResponse buscarPorId(@Param("idProcesoRectificacion")Integer idProcesoRectificacion);
	
	public ProcesoRectificacionResponse buscarPorCriterio(ProcesoRectificacionFilter criterio);
	
	public List<ProcesoRectificacionResponse> buscarTodos();
}
