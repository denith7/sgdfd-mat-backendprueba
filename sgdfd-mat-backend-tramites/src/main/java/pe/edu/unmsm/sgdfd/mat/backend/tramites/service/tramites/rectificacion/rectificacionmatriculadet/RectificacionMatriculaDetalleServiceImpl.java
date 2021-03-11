package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramites.rectificacion.rectificacionmatriculadet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.tramites.rectificacion.RectificacionMatriculaDetMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.RectificacionMatriculaDetalleRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.RectificacionMatriculaDetalleResponse;


@Service
@Transactional
public class RectificacionMatriculaDetalleServiceImpl extends MantenibleAuditadoService<RectificacionMatriculaDetalleRequest,RectificacionMatriculaDetalleResponse >
		implements RectificacionMatriculaDetalleService  
{

    private RectificacionMatriculaDetMapper RectificacionMatriculaDetMapper;
    
    public RectificacionMatriculaDetalleServiceImpl(@Qualifier("rectificacionMatriculaDetMapper") MantenibleMapper<RectificacionMatriculaDetalleRequest,RectificacionMatriculaDetalleResponse > mapper) {
        super(mapper);
        this.RectificacionMatriculaDetMapper = (RectificacionMatriculaDetMapper) mapper;
    }
      	
}

	
	

	


