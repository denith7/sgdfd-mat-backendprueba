package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramiteseguimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.SolicitudTramiteSeguimientoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteSeguimientoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.SolicitudTramiteSegNotifResponse;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de seguimiento de solicitud de trámite
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link SolicitudTramiteSeguimientoService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link SolicitudTramiteSeguimientoMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class SolicitudTramiteSeguimientoImpl
		extends MantenibleAuditadoService<SolicitudTramiteSeguimientoRequest, SolicitudTramiteSegNotifResponse>
		implements SolicitudTramiteSeguimientoService {
	
	@Autowired
	private SolicitudTramiteSeguimientoMapper solicitudTramiteSeguimientoMapper;
	
	/**
     * Instancia la interface {@link SolicitudTramiteSeguimientoMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public SolicitudTramiteSeguimientoImpl(
			@Qualifier("solicitudTramiteSeguimientoMapper") MantenibleMapper<SolicitudTramiteSeguimientoRequest, SolicitudTramiteSegNotifResponse> mapper) {
		super(mapper);
		this.solicitudTramiteSeguimientoMapper = (SolicitudTramiteSeguimientoMapper) mapper;
	}
	
	@Override
	public List<SolicitudTramiteSegNotifResponse> notificacionTramiteDerivadoObservado(String numeroDocumento) {
		return solicitudTramiteSeguimientoMapper.notificacionTramiteDerivadoObservado(numeroDocumento);
	}

	@Override
	public SolicitudTramiteSegNotifResponse obtenerSeguimiento(Integer idTramiteSeguimiento) {
		return solicitudTramiteSeguimientoMapper.obtenerSeguimiento(idTramiteSeguimiento);
	}

	@Override
	public void actualizarEstadoNotificacion(Integer idTramiteSeguimiento, Integer estadoNotifLeido) {
		solicitudTramiteSeguimientoMapper.actualizarEstadoNotificacion(idTramiteSeguimiento, estadoNotifLeido);
	}

	@Override
	public List<SolicitudTramiteSegNotifResponse> seguimientoSolicitudCompleto(Integer idSolicitudTramite) {
		return solicitudTramiteSeguimientoMapper.seguimientoSolicitudCompleto(idSolicitudTramite);
	}

}
