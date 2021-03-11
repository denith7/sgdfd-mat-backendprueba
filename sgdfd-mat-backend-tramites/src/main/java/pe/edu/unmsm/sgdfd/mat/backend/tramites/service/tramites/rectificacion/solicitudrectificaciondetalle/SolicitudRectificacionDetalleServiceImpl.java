package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramites.rectificacion.solicitudrectificaciondetalle;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.tramites.rectificacion.SolicitudRectificacionDetalleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.SolicitudRectificacionDetalleRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.SolicitudRectificacionDetalleResponse;


@Service
@Transactional
public class SolicitudRectificacionDetalleServiceImpl extends MantenibleAuditadoService<SolicitudRectificacionDetalleRequest, SolicitudRectificacionDetalleResponse>
		implements SolicitudRectificacionDetalleService  
{

    private SolicitudRectificacionDetalleMapper solicitudRectificacionDetalleMapper;
    
    public SolicitudRectificacionDetalleServiceImpl(@Qualifier("solicitudRectificacionDetalleMapper") MantenibleMapper<SolicitudRectificacionDetalleRequest, SolicitudRectificacionDetalleResponse> mapper) {
        super(mapper);
        this.solicitudRectificacionDetalleMapper = (SolicitudRectificacionDetalleMapper) mapper;
    }
  
    
	@Override
	public SolicitudRectificacionDetalleResponse buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public SolicitudRectificacionDetalleRequest registrarSolicitudRectificacionDetalle(SolicitudRectificacionDetalleRequest paramSolRectiDetReq) {
		registrar(paramSolRectiDetReq);
		return paramSolRectiDetReq;
	}

	@Override
	public SolicitudRectificacionDetalleRequest actualizarSolicitudRectificacionDetalle(Integer idRectificacionDetalle, SolicitudRectificacionDetalleRequest solicitudDetalle) {
		solicitudDetalle.setIdOperacion(idRectificacionDetalle);
		actualizar(solicitudDetalle);
		return solicitudDetalle;
	}


	@Override
	public void procesarEjecucionSolicitudRectificacionDetalle(Integer idOperacion,
			SolicitudRectificacionDetalleRequest solicitudRecitificacionDetalle) {
		solicitudRecitificacionDetalle.setIdOperacion(idOperacion);
		solicitudRectificacionDetalleMapper.mantener("STATE",solicitudRecitificacionDetalle,solicitudRecitificacionDetalle.getUsuario());

	}
	@Override
	public void procesarResultadoSolicitudRectificacionDetalle(Integer idOperacion,
			SolicitudRectificacionDetalleRequest solicitudRecitificacionDetalle) {
		solicitudRecitificacionDetalle.setIdOperacion(idOperacion);
		solicitudRectificacionDetalleMapper.mantener("RESULT",solicitudRecitificacionDetalle,solicitudRecitificacionDetalle.getUsuario());

	}



}

	
	

	


