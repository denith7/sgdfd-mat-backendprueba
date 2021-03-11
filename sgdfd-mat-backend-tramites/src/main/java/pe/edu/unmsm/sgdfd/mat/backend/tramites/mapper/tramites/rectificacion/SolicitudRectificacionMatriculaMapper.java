package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.tramites.rectificacion;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.rectificacion.SolicitudRectificacionMatriculaFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.SolicitudRectificacionMatriculaRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.SolicitudRectificacionMatriculaResponse;


@Mapper
public interface SolicitudRectificacionMatriculaMapper extends MantenibleMapper<SolicitudRectificacionMatriculaRequest,SolicitudRectificacionMatriculaResponse> 
{
	public SolicitudRectificacionMatriculaResponse buscarPorId(@Param("idSolicitudRectificacionMatricula") Integer idSolicitudRectificacionMatricula);
		
	public List<SolicitudRectificacionMatriculaResponse> buscarPorCriterio(SolicitudRectificacionMatriculaFilter criterioBusqueda);
	
	public SolicitudRectificacionMatriculaResponse buscarPorCodigoAlumno(@Param("codigoAlumno") String codigoAlumno);
	
	public List<SolicitudRectificacionMatriculaResponse> buscarTodos();
	
	public void mantener(String modo, SolicitudRectificacionMatriculaRequest objetoMantenido,String usuario);
	
	public void validacionRectificacion(Integer idSolicitudRectificacion, String usuario);
}
