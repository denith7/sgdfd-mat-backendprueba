package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramites.rectificacion.solicitudrectificacionmatricula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.tramites.rectificacion.SolicitudRectificacionMatriculaMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.rectificacion.SolicitudRectificacionMatriculaFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.SolicitudRectificacionMatriculaRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.SolicitudRectificacionMatriculaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramite.SolicitudTramiteService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramites.rectificacion.solicitudrectificaciondetalle.SolicitudRectificacionDetalleService;


@Service
@Transactional
public class SolicitudRectificacionMatriculaServiceImpl extends MantenibleAuditadoService<SolicitudRectificacionMatriculaRequest,SolicitudRectificacionMatriculaResponse>
		implements SolicitudRectificacionMatriculaService  
{
    private SolicitudRectificacionMatriculaMapper solicitudRectificacionMatriculaMapper;
      
    public SolicitudRectificacionMatriculaServiceImpl(@Qualifier("solicitudRectificacionMatriculaMapper") MantenibleMapper<SolicitudRectificacionMatriculaRequest,SolicitudRectificacionMatriculaResponse> mapper) {
        super(mapper);
        this.solicitudRectificacionMatriculaMapper = (SolicitudRectificacionMatriculaMapper) mapper;
    }
      
    @Autowired
    private SolicitudRectificacionDetalleService solicitudRectificacionDetalleService;
    
    @Autowired
    private SolicitudTramiteService solicitudTramiteService;
    	
    @Override
	public SolicitudRectificacionMatriculaRequest registrarSolicitudRectificacionConOperacion(SolicitudRectificacionMatriculaRequest solicitud) {
    	
    	SolicitudTramiteRequest st = SolicitudTramiteRequest.builder().idSolicitudTramite(0).build();
    	solicitudTramiteService.registrar(st);
    	solicitud.setIdSolicitudTramite(st.getIdSolicitudTramite());
    	registrar(solicitud);
    	solicitud.getLsOperaciones().forEach(e->{
    		e.setIdSolicitudRectiMatri(solicitud.getIdSolicitudRectiMatri());
    		solicitudRectificacionDetalleService.registrarSolicitudRectificacionDetalle(e);
    	});
    	  
    	//LLAMAR AQUI AL PROCEIMIENTO CREADO POR ANDRES
//    	validarRectificacion(st.getIdSolicitudTramite(),solicitud.getUsuario()I);
    	
		return solicitud;
	}
    
    @Override
	public void validarRectificacion(Integer idSolicitud, String usuairo) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public SolicitudRectificacionMatriculaResponse buscarPorId(Integer id) {
		return solicitudRectificacionMatriculaMapper.buscarPorId(id);
	}
	
	public List<SolicitudRectificacionMatriculaResponse> buscarPorCriterio(SolicitudRectificacionMatriculaFilter criterioBusqueda) {
		return solicitudRectificacionMatriculaMapper.buscarPorCriterio(criterioBusqueda);
	}
	
	@Override
	public List<SolicitudRectificacionMatriculaResponse> buscarTodos() {
		return solicitudRectificacionMatriculaMapper.buscarTodos();
	}

	@Override
	public void procesarSolicitudRectificacion(Integer idSolicitudRectiMatri, SolicitudRectificacionMatriculaRequest procesoSolicitudTramite) {
		procesoSolicitudTramite.setIdSolicitudRectiMatri(idSolicitudRectiMatri);
		solicitudRectificacionMatriculaMapper.mantener("STATE",procesoSolicitudTramite,procesoSolicitudTramite.getUsuario());
	}


	
}

	
	

	


