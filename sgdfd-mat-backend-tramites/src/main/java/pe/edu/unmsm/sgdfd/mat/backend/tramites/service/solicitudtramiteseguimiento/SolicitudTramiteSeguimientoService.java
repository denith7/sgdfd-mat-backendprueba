package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramiteseguimiento;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteSeguimientoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.SolicitudTramiteSegNotifResponse;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de seguimiento de solicitud de trámite,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see SolicitudTramiteSeguimientoRequest
 * @see SolicitudTramiteSegNotifResponse
 */
public interface SolicitudTramiteSeguimientoService
		extends MantenibleService<SolicitudTramiteSeguimientoRequest, SolicitudTramiteSegNotifResponse> {
	
	/**
	 * obtiene una lista seguimientos de solicitudes de trámites por:
	 * @param numeroDocumento
	 * 			número de documento
	 */
	public List<SolicitudTramiteSegNotifResponse> notificacionTramiteDerivadoObservado(String numeroDocumento);

	/**
	 * Actualiza un estado de seguimiento de solicitud de trámite
	 * @param idTramiteSeguimiento
	 * 			identificador de trámite de seguimiento
	 * @param estadoNotifLeido
	 * 			estado
	 */
	public void actualizarEstadoNotificacion(Integer idTramiteSeguimiento, Integer estadoNotifLeido);

	/**
	 * obtiene un seguimiento de solicitud de trámite por:
	 * @param idTramiteSeguimiento
	 * 			identificador de trámite de seguimiento
	 */
	public SolicitudTramiteSegNotifResponse obtenerSeguimiento(Integer idTramiteSeguimiento);
	
	/**
	 * obtiene una lista seguimientos de solicitudes de trámites por:
	 * @param idSolicitudTramite
	 * 			identificador de trámite de seguimiento
	 */
	public List<SolicitudTramiteSegNotifResponse> seguimientoSolicitudCompleto(Integer idSolicitudTramite);

}
