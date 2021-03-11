package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramites.rectificacion.solicitudrectificaciondetalle;


import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.SolicitudRectificacionDetalleRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.SolicitudRectificacionDetalleResponse;



public interface SolicitudRectificacionDetalleService extends MantenibleService<SolicitudRectificacionDetalleRequest, SolicitudRectificacionDetalleResponse>
{
    public SolicitudRectificacionDetalleResponse buscarPorId(Integer id);
    
    public List<SolicitudRectificacionDetalleResponse> buscarTodos();
      
    public SolicitudRectificacionDetalleRequest registrarSolicitudRectificacionDetalle(SolicitudRectificacionDetalleRequest paramSolRectiDetReq);
    
    public SolicitudRectificacionDetalleRequest actualizarSolicitudRectificacionDetalle(Integer idSolicitudRectificacionDetalle, SolicitudRectificacionDetalleRequest paramSolRectiDetReq);
    
    public void procesarEjecucionSolicitudRectificacionDetalle(Integer id, SolicitudRectificacionDetalleRequest solicitudRecitificacionDetalle);
    
    public void procesarResultadoSolicitudRectificacionDetalle(Integer id, SolicitudRectificacionDetalleRequest solicitudRecitificacionDetalle);

      
}