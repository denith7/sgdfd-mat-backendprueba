package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramites.rectificacion.procesorectificacion;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.tramites.rectificacion.ProcesoRectificacionMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.ProcesoRectificacionRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.ProcesoRectificacionResponse;


@Service
@Transactional
public class ProcesoRectificacionServiceImpl extends MantenibleAuditadoService<ProcesoRectificacionRequest,ProcesoRectificacionResponse>
		implements ProcesoRectificacionService  
{

    private ProcesoRectificacionMapper procesoRectificacionMapper;
    
    public ProcesoRectificacionServiceImpl(@Qualifier("procesoRectificacionMapper") MantenibleMapper<ProcesoRectificacionRequest,ProcesoRectificacionResponse> mapper) {
        super(mapper);
        this.procesoRectificacionMapper = (ProcesoRectificacionMapper) mapper;
    }
  
    
	@Override
	public ProcesoRectificacionResponse buscarPorId(Integer id) {
		return procesoRectificacionMapper.buscarPorId(id);
	}


	@Override
	public ProcesoRectificacionRequest registrarProcesoRectificacion(ProcesoRectificacionRequest procesoRectificacion) {
		registrar(procesoRectificacion);
		return procesoRectificacion;
	}

	
}

	
	

	


