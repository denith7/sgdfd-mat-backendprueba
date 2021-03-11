package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramiterequisito;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta.SolicitudTramiteRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.id.DetalleSolicitudTramiteId;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoEstadoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoObservarRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoValorRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de requisitos de solicitudes de trámite,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see SolicitudTramiteRequisitoRequest
 * @see SolicitudTramiteRequisitoResponse
 */
public interface SolicitudTramiteRequisitoService extends MantenibleService<SolicitudTramiteRequisitoRequest, SolicitudTramiteRequisitoResponse>{
	
	/**
	 * Obtiene un requisito de solicitud de trámite
	 * @param detalleSolicitudTramiteId
	 * 			el requisito de solicitud de trámite 
	 */
	public SolicitudTramiteRequisitoResponse buscarPorId(DetalleSolicitudTramiteId detalleSolicitudTramiteId);

	/**
	 * Obtiene una lista de requisitos de solicitudes de trámite
	 */
	public List<SolicitudTramiteRequisitoResponse> buscarTodosDetalleSolicitudTramite();
    
	/**
	 * Registra un requisito de solicitud de trámite
	 * @param solicitudTramiteRequisitoRequest
	 * 			el requisito de solicitud de trámite a registrar	
	 */
	public SolicitudTramiteRequisitoRequest registrarDetalleSolicitudTramite(SolicitudTramiteRequisitoRequest solicitudTramiteRequisitoRequest);

	/**
	 * Actualiza un requisito de solicitud de trámite
	 * @param detalleSolicitudTramiteId
	 * 			de tipo  DetalleSolicitudTramiteId
	 * @param solicitudTramiteRequisitoRequest
	 * 			requisito de solicitud de trámite a actualizar	
	 * 
	 */
	public SolicitudTramiteRequisitoRequest actualizarDetalleSolicitudTramite(DetalleSolicitudTramiteId detalleSolicitudTramiteId ,SolicitudTramiteRequisitoRequest solicitudTramiteRequisitoRequest);
    
	/**
	 * --
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param idRequisito
	 * 			el identificador de requisito
	 * @param idItem
	 * 			el identificador de item
	 * @param solicitudTramiteRequisitoObservarRequest
	 * 			requisito de solicitud de trámite 	
	 * 
	 */
	public void observar(Integer idSolicitudTramite, Integer idTipoTramite,Integer idRequisito,Integer idItem,SolicitudTramiteRequisitoObservarRequest solicitudTramiteRequisitoObservarRequest);
    
	
	/**
	 * Recibe petición de actualización de estado de requisito de solicitud de trámite
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param idRequisito
	 * 			el identificador de requisito
	 * @param idItem
	 * 			el identificador de item
	 * @param solicitudTramiteRequisitoEstadoRequest
	 * 			requisito de solicitud de trámite 	
	 * 
	 */
	public void actualizarEstado(Integer idSolicitudTramite, Integer idTipoTramite,Integer idRequisito,SolicitudTramiteRequisitoEstadoRequest solicitudTramiteRequisitoEstadoRequest);
    
	
	/**
	 * Recibe petición de actualización de valor de requisito de solicitud de trámite
	 * @param detalleSolicitudTramiteId
	 * 			de tipo  DetalleSolicitudTramiteId
	 * @param solicitudTramiteRequisitoValorRequest
	 * 			requisito de solicitud de trámite a actualizar 	
	 * 
	 */
	public SolicitudTramiteRequisitoResponse actualizarValor(DetalleSolicitudTramiteId detalleSolicitudTramiteId,SolicitudTramiteRequisitoValorRequest solicitudTramiteRequisitoValorRequest);

	
	/**
	 * Elimina un requisito de solicitud de trámite 
	 * @param solicitudTramiteRequisitoRequest
	 * 			el requisito de solicitud de trámite a Eliminar	
	 */
	public void eliminarDetalleSolicitudTramite(SolicitudTramiteRequisitoRequest solicitudTramiteRequisitoRequest);
    
   
    
}