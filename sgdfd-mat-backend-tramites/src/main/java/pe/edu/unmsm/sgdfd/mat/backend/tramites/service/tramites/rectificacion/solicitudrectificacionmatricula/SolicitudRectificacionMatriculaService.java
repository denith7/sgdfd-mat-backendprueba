package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramites.rectificacion.solicitudrectificacionmatricula;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.rectificacion.SolicitudRectificacionMatriculaFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.SolicitudRectificacionMatriculaRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.SolicitudRectificacionMatriculaResponse;



public interface SolicitudRectificacionMatriculaService extends MantenibleService<SolicitudRectificacionMatriculaRequest,SolicitudRectificacionMatriculaResponse>
{
	public SolicitudRectificacionMatriculaRequest registrarSolicitudRectificacionConOperacion(SolicitudRectificacionMatriculaRequest solicitudTramiteRequest);
		
    public SolicitudRectificacionMatriculaResponse buscarPorId(Integer id);
    
    public List<SolicitudRectificacionMatriculaResponse> buscarPorCriterio(SolicitudRectificacionMatriculaFilter criterio);
    
    public List<SolicitudRectificacionMatriculaResponse> buscarTodos();
    
    public void procesarSolicitudRectificacion(Integer id, SolicitudRectificacionMatriculaRequest solicitudRecitificacionDetalle);   

    public void validarRectificacion(Integer idSolicitud, String usuairo);
}