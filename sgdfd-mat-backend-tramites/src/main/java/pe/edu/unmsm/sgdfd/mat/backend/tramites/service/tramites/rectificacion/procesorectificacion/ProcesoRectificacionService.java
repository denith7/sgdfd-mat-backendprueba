package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramites.rectificacion.procesorectificacion;


import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.ProcesoRectificacionRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.ProcesoRectificacionResponse;



public interface ProcesoRectificacionService extends MantenibleService<ProcesoRectificacionRequest,ProcesoRectificacionResponse>
{
    public ProcesoRectificacionResponse buscarPorId(Integer id);
    
    public List<ProcesoRectificacionResponse> buscarTodos();
    
    public ProcesoRectificacionRequest registrarProcesoRectificacion(ProcesoRectificacionRequest procesoRectificacion);
    

}