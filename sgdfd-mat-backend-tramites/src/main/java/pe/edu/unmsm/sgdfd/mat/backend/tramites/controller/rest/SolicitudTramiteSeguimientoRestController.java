package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.SolicitudTramiteSegNotifResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramiteseguimiento.SolicitudTramiteSeguimientoService;

/**
 * --
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Obtener las notificaciones en estado derivado y observado
 * 	<li>Seguimiento de una solicitud según su identificador 
 *  <li>Actualizar el estado de No Leído a Leído con el botón en el modal notificación
 * 	<li>seguimiento de una solicitud de trámite
 * </ul>
 * 
 * @author Miguel Moya
 * @see SolicitudTramiteSegNotifResponse
 * @see SolicitudTramiteSeguimientoService
 */
@Validated
@RestController
@RequestMapping("/seguimiento-tramite")
public class SolicitudTramiteSeguimientoRestController {

	private SolicitudTramiteSeguimientoService solicitudTramiteSeguimientoService;
	
	public SolicitudTramiteSeguimientoRestController (SolicitudTramiteSeguimientoService solicitudTramiteSeguimientoService) {
		this.solicitudTramiteSeguimientoService = solicitudTramiteSeguimientoService;
	}
	
	//-- NOTIFICACIONES --//
	
	//Obtener las notificaciones en estado derivado y observado
	/**
	 * Retorna una lista de seguimientos de solicitudes de trámites buscados por atributo:  
	 * @param numeroDocumento
	 * 			el número de documento
	 * @param --
	 * @return	seguimiento de solicitud de trámite obtenido por búsqueda:
	 * 			{@link SolicitudTramiteSegNotifResponse}
	 */
	@GetMapping("numero-documento/{numeroDocumento}/seguimiento-notif")
	@PreAuthorize("hasPermission('CON_SEGUIMIENTO_TRAMITE','101')")
    public List<SolicitudTramiteSegNotifResponse> notificacionTramiteDerivadoObservado(@PathVariable("numeroDocumento") String numeroDocumento)
    {
        return solicitudTramiteSeguimientoService.notificacionTramiteDerivadoObservado(numeroDocumento);
    }
	
	
	//Seguimiento de una solicitud según id
	/**
	 * Retorna un seguimiento de solicitude de trámite buscados por atributo:  
	 * @param idTramiteSeguimiento
	 * 			identificador de trámite de seguimiento
	 * @param --
	 * @return	seguimiento de solicitude de trámite obtenido por búsqueda:
	 * 			{@link SolicitudTramiteSegNotifResponse}
	 */
	@GetMapping("id-tramite-seguimiento/{idTramiteSeguimiento}")
	@PreAuthorize("hasPermission('CON_SEGUIMIENTO_TRAMITE','102')")
    public SolicitudTramiteSegNotifResponse obtenerSeguimiento(@PathVariable("idTramiteSeguimiento") Integer idTramiteSeguimiento)
    {
        return solicitudTramiteSeguimientoService.obtenerSeguimiento(idTramiteSeguimiento);
    }
	
	
	//Actualizar el estado de No Leído a Leído con el botón en el modal notificación
	/**
	 * Recibe petición de actualización de seguimiento de solicitude de trámite
	 * @param idTramiteSeguimiento
	 * 			el identificador de seguimiento de solicitude de trámite
	 * @param solicitudTramiteSegNotifResponse
	 * 			el seguimiento de solicitude de trámite a actualizar
	 * @param --
	 * @return	seguimiento de solicitude de trámite actualizado
	 * 			{@link SolicitudTramiteSegNotifResponse}
	 */
	@PostMapping("id-tramite-seguimiento/{idTramiteSeguimiento}/estado-seguimiento-notif")
	@PreAuthorize("hasPermission('CON_SEGUIMIENTO_TRAMITE','301')")
    public SolicitudTramiteSegNotifResponse actualizarEstadoNotificacion(@PathVariable("idTramiteSeguimiento") Integer idTramiteSeguimiento, @RequestBody SolicitudTramiteSegNotifResponse solicitudTramiteSegNotifResponse)
    {
		solicitudTramiteSeguimientoService.actualizarEstadoNotificacion(idTramiteSeguimiento, solicitudTramiteSegNotifResponse.getEstadoNotifLeido());
        return solicitudTramiteSeguimientoService.obtenerSeguimiento(idTramiteSeguimiento);
    }
	
	//-- END NOTIFICACIONES --//
	
	//-- SEGUIMIENTO --//
	/**
	 * Retorna una lista de seguimientos de solicitudes de trámites buscados por atributo:  
	 * @param idSolicitudTramite
	 * 			el identificador de seguimiento de solicitude de trámite
	 * @param --
	 * @return	seguimiento de solicitude de trámite obtenido por búsqueda:
	 * 			{@link SolicitudTramiteSegNotifResponse}
	 */
	@GetMapping("id-solicitud-tramite/{idSolicitudTramite}")
//	@PreAuthorize("hasPermission('CON_SEGUIMIENTO_TRAMITE','103')")
    public List<SolicitudTramiteSegNotifResponse> seguimientoSolicitudCompleto(@PathVariable("idSolicitudTramite") Integer idSolicitudTramite)
    {
        return solicitudTramiteSeguimientoService.seguimientoSolicitudCompleto(idSolicitudTramite);
    }
	//-- END --//
	
}
