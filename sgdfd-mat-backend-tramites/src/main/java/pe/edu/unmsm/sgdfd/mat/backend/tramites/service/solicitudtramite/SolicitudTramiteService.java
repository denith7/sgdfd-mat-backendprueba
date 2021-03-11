package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramite;

import java.io.IOException;
import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.ReporteSolicitudCodigoDniFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.ReporteSolicitudTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta.ReporteSolicitudTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta.SolicitudTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.SolicitudTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.DerivarSolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.PersonaRegistroSolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.ProcesoSolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.ReporteAnexoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteFilterRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.ReporteFutResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.SolicitudTramiteEstadisticaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.SolicitudTramiteSegNotifResponse;


/**
 * Define los métodos asociados a las operaciones de mantenimiento de solicitud de trámite,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see MantenibleService
 * @see SolicitudTramiteRequest
 * @see SolicitudTramiteResponse
 */
public interface SolicitudTramiteService extends MantenibleService<SolicitudTramiteRequest, SolicitudTramiteResponse>
{
	
    /**
	 * Obtiene una lista total de solicitud de trámite
	 */
    public List<SolicitudTramiteResponse> buscarTodosSolicitudTramite();
	
	/**
	 *  Obtiene una solicitud de trámite por atributo
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 */
    public SolicitudTramiteResponse buscarPorId(Integer idSolicitudTramite);
	
    /**
	 *  Obtiene una solicitud de trámite por atributo
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param numeroDocumento
	 * 			el número de documento  
	 */
    public SolicitudTramiteResponse  buscarPorIdYNumeroDocumento(Integer id,String numeroDocumento);
    
    /**
	 *  Obtiene una lista de solicitudes de trámite por atributo
	 * @param codigoLocal
	 * 			código de local  
	 */
    public List<SolicitudTramiteResponse> buscarPorCodigoLocal(String codigoLocal);
    
    /**
	 *  Obtiene una lista de solicitudes de trámite por atributo
	 * @param codigoLocal
	 * 			código de local  
	 */
    public List<SolicitudTramiteResponse> buscarPorLocalEstado(String codigoLocal);
    
    /**
	 *  Obtiene una lista de solicitudes de trámite por atributo
	 * @param codigoLocal
	 * 			código de local 
	 * @param solicitudTramiteFilterRequest
	 * 			contenido para filtrar
	 */
    public List<SolicitudTramiteResponse> filtrarSolicitudTramite(String codigoLocal, SolicitudTramiteFilterRequest solicitudTramiteFilterRequest);
    
    /**
	 *  Obtiene una lista de solicitudes de trámite por atributo
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param codigoLocal
	 * 			el código de local  
	 */
    public List<SolicitudTramiteResponse> buscarPorTipoTramiteYLocal(String idTipoTramite, String codigoLocal);
    
    /**
	 *  Obtiene una lista de solicitudes de trámite por atributo
	 * @param numeroDocumento
	 * 			el número de documento  
	 */
    public List<SolicitudTramiteResponse> buscarPorNumeroDocumento(String numeroDocumento);
    
    /**
	 *  Obtiene una lista de solicitudes de trámite por atributo
	 * @param numeroDocumento
	 * 			el número de documento
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite 
	 */
    public List<SolicitudTramiteResponse> buscarPorNumeroDocumentoTipoTramite(String numeroDocumento, Integer idTipoTramite);
    
    /**
	 *  Obtiene una solicitud de trámite por atributo
	 * @param solicitudTramiteFilter
	 * 			de tipo SolicitudTramiteFilter  
	 */
    public SolicitudTramiteResponse buscarPorCriterio(SolicitudTramiteFilter solicitudTramiteFilter);
    
    /**
	 * Busqueda de reporte de solicitud de trámite
	 * @param reporteSolicitudTramiteFilter
	 * 			filtro
	 */
    public ReporteSolicitudTramiteResponse buscarReporteSolicitudTramite(ReporteSolicitudTramiteFilter reporteSolicitudTramiteFilter);
    
    /**
	 *  Procesar una solicitud de trámite
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param procesoSolicitudTramite
	 * 			solicitud a procesar  
	 */
    public void procesarSolicitudTramite(Integer idSolicitudTramite, ProcesoSolicitudTramiteRequest procesoSolicitudTramite);
    
    /**
	 * Derivar una solicitud de trámite
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param derivarSolicitudTramite
	 * 			solicitud a derivar  
	 */
    public void derivarSolicitudTramite(Integer id, DerivarSolicitudTramiteRequest procesoSolicitudTramite);
    
	/**
	 *  Registra una solicitud de trámite por
	 * @param solicitudTramiteRequest
	 * 			solicitud de tramite a registrar
	 */
	public SolicitudTramiteRequest registrarSolicitudTramiteConRequisito(SolicitudTramiteRequest solicitudTramiteRequest) throws IOException;

	/**
	 *  Registra una persona en el MAT
	 * @param personaRegistroSolicitudTramiteRequest
	 * 			persona a registrar
	 */
	public PersonaRegistroSolicitudTramiteRequest registrarPersonaRegistro(PersonaRegistroSolicitudTramiteRequest personaRegistroSolicitudTramiteRequest);
    
    /**
	 * Generar reporte FUT
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param numeroDocumento
	 * 			el número de documento  
	 */
    public ReporteFutResponse generarReporteFUT(String idSolicitudTramite, String numeroDocumento);
    
    /**
	 * Generar reporte FUT por:
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param numeroDocumento
	 * 			el número de documento
	 * @param codigoAlumno
	 * 			código de alumno 
	 */
    public ReporteFutResponse reporteFutPorCodigoYDni(String id, String numeroDNI, String codigoAlumno);
    
    /**
	 * Obtiene cantidad total de solicitudes atendidas
	 */
    public Integer totalSolicitudesAtendidas();
    
    /**
	 * Obtiene antidad de solicitudes atendidas por día durante la semana
	 */
    public List<SolicitudTramiteEstadisticaResponse> solicitudesRealizadasEnLaUltimaSemana();
    
    /**
	 * Actualiza el estado
	 * @param idTramiteSeguimiento
	 * 			el identificador de seguimiento de trámite
	 * @param estadoNotifLeido
	 * 			estado de notificación 
	 */
    public void actualizarEstadoNotificacion(Integer idTramiteSeguimiento, Integer estadoNotifLeido);
    
    
    /**
	 * Busqueda de reporte de solicitud de trámite
	 * @param reporteSolicitudTramiteFilter
	 * 			filtro
	 */
    public ReporteSolicitudTramiteResponse buscarReportePorCodigoYDni(ReporteSolicitudCodigoDniFilter reporteSolicitudTramiteFilter);
    
    
    
   //NO DOCUMENTAR
    public List<SolicitudTramiteSegNotifResponse> notificacionTramiteDerivadoObservado(String numeroDocumento);
    
    public SolicitudTramiteSegNotifResponse obtenerSeguimiento(Integer idTramiteSeguimiento);
    
//  public SolicitudTramite actualizarSolicitudTramite(Integer idSolicitudTramite, SolicitudTramite parametroTipoTramite);
    
    
    /**
	 * Generar reporte anexo
	 * @param reporte
	 * 			Reporte con los atributos para generar el anexo
	 */
    public ReporteFutResponse generarReporteAnexo(ReporteAnexoRequest reporte);
    
    
    /**
	 * Generar reporte anexo con revision
	 * @param reporte
	 * 			Reporte con los atributos para generar el anexo
	 */
    public ReporteFutResponse generarReporteAnexoRevisado(ReporteAnexoRequest reporte);
    
}