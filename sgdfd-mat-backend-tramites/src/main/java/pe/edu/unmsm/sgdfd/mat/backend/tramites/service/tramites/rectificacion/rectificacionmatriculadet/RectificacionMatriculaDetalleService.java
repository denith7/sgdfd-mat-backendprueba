package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramites.rectificacion.rectificacionmatriculadet;


import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.RectificacionMatriculaDetalleRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.RectificacionMatriculaDetalleResponse;



public interface RectificacionMatriculaDetalleService extends MantenibleService<RectificacionMatriculaDetalleRequest,RectificacionMatriculaDetalleResponse >
{
    
    public List<RectificacionMatriculaDetalleResponse> buscarTodos();

}