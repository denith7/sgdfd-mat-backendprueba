package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.groups.Default;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.IdNumerico;
import pe.edu.unmsm.commons.validation.validation.group.IRegistro;
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
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramite.SolicitudTramiteService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.sw.VerifyRecaptcha;

/**
 * --
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Obtiene una lista total de solicitud de trámite
 * 	<li>Obtiene una solicitud de trámite por identificador
 *  <li>Obtiene una lista de solicitud de trámite por identificador y número de documento
 * 	<li>Obtiene una lista de solicitud de trámite por código local
 *  <li>Obtiene una lista de solicitud de trámite por estado código local
 *  <li>Filtra solicitud de trámite por código local
 *  <li>Obtiene una lista de solicitud de trámite por identificador de tipo de trámite y código local
 *  <li>Obtiene una lista de solicitud de trámite por identificador de tipo de trámite
 *  <li>Obtiene una lista de solicitud de trámite por número de documento
 *  <li>Obtiene una lista de solicitud de trámite por número de documento e identificador de tipo de trámite
 *  <li>Obtiene una solicitud de trámite por identificador y número de documento
 *  <li>Obtiene una solicitud de trámite sin requisitos
 *  <li>Busqueda de reporte de solicitud de trámite
 *  <li>Procesar solicitud de trámite
 *  <li>Derivar solicitud de trámite
 *  <li>Registrar solicitud de trámite
 *  <li>Registrar persona en MAT
 *  <li>Generar reporte FUT
 *  <li>Generar reporte FUT por identificador número de documento y código de alumno 
 *  <li>Cantidad total de solicitudes atendidas
 *  <li>Muestra cantidad de solicitudes atendidas por día durante la semana
 * </ul>
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see SolicitudTramiteRequest
 * @see SolicitudTramiteResponse
 * @see SolicitudTramiteService
 */
@Validated
@RestController
@RequestMapping("/solicitudes-tramite")
public class SolicitudTramiteRestController {
	
	private SolicitudTramiteService solicitudTramiteService;

	public SolicitudTramiteRestController(SolicitudTramiteService solicitudTramiteService) {
		this.solicitudTramiteService = solicitudTramiteService;
	}
	
	/**
	 * Retorna una lista total de solicitudes de trámites
	 * @param --
	 * @param --
	 * @return	solicitud de trámite obtenido por búsqueda:
	 * 			{@link SolicitudTramiteResponse}
	 */
	@GetMapping
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','101')")
	//@Secured({JWTConstants.ROLE_USER})
    public List<SolicitudTramiteResponse> buscarTodosSolicitudTramite()
    {
        return solicitudTramiteService.buscarTodosSolicitudTramite();
    }
	
	/**
	 * Retorna una solicitud de trámite buscados por atributo:  
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param --
	 * @return	solicitud de trámite obtenido por búsqueda:
	 * 			{@link SolicitudTramiteResponse}
	 */
	@GetMapping("/{idSolicitudTramite}")
//	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','102')")
    public SolicitudTramiteResponse buscarPorIdSolicitudTramite(
    		@IdNumerico(maxRange = 9999999999L)@PathVariable("idSolicitudTramite") Integer id)
    {
        return solicitudTramiteService.buscarPorId(id);
    }
	
	
	/**
	 * Retorna una solicitud de trámite buscados por atributo:  
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param numeroDocumento
	 * 			el número de documento
	 * @param --
	 * @return	solicitud de trámite obtenido por búsqueda:
	 * 			{@link SolicitudTramiteResponse}
	 */
	@GetMapping("detalle/{idSolicitudTramite}/numero-documento/{numeroDocumento}")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','103')")
    public SolicitudTramiteResponse  buscarPorIdYNumeroDocumento(
    		@IdNumerico(maxRange = 9999999999L)@PathVariable("idSolicitudTramite") Integer id,@PathVariable("numeroDocumento") String numeroDocumento)
    {
        return solicitudTramiteService.buscarPorIdYNumeroDocumento(id, numeroDocumento);
    }
	
	
	/**
	 * Retorna una lista de solicitudes de trámite buscados por atributo:  
	 * @param codigoLocal
	 * 			código de local
	 * @param --
	 * @return	solicitudes de trámite obtenidas por búsqueda:
	 * 			{@link SolicitudTramiteResponse}
	 */
	@GetMapping("codigo-local/{codigoLocal}")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','104')")
    public List<SolicitudTramiteResponse>  buscarPorCodigoLocal(@PathVariable("codigoLocal") String codigoLocal)
    {
        return solicitudTramiteService.buscarPorCodigoLocal(codigoLocal);
    }
	
	
	/**
	 * Retorna una lista de estados solicitudes de trámite buscados por atributo:  
	 * @param codigoLocal
	 * 			código de local
	 * @param --
	 * @return	solicitudes de trámite obtenidas por búsqueda:
	 * 			{@link SolicitudTramiteResponse}
	 */
	@GetMapping("codigo-local-estado/{codigoLocal}")
//	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','105')")
    public List<SolicitudTramiteResponse>  buscarPorLocalEstado(@PathVariable("codigoLocal") String codigoLocal)
    {
        return solicitudTramiteService.buscarPorLocalEstado(codigoLocal);
    }
	
	
	/**
	 * Filtra una lista de estados solicitudes de trámite buscados por atributo:  
	 * @param codigoLocal
	 * 			código de local
	 * @param --
	 * @return	solicitudes de trámite obtenidas por búsqueda:
	 * 			{@link SolicitudTramiteResponse}
	 */
	@PostMapping("codigo-local/{codigoLocal}/filtrar")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','106')")
    public List<SolicitudTramiteResponse>  filtrarSolicitudTramite(@PathVariable("codigoLocal") String codigoLocal,
    		@RequestBody SolicitudTramiteFilterRequest solicitudTramiteFilterRequest)
    {
        return solicitudTramiteService.filtrarSolicitudTramite(codigoLocal, solicitudTramiteFilterRequest);
    }
	
	
	/**
	 * Retorna una lista de solicitudes de trámite buscados por atributo:  
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param codigoLocal
	 * 			el código de local
	 * @param --
	 * @return	solicitud de trámite obtenido por búsqueda:
	 * 			{@link SolicitudTramiteResponse}
	 */
	@GetMapping("tipo-tramite/{idTipoTramite}/local/{codigoLocal}")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','107')")
    public List<SolicitudTramiteResponse>  buscarPorTipoTramiteYLocal(@PathVariable("idTipoTramite") String idTipoTramite,@PathVariable("codigoLocal") String codigoLocal)
    {
        return solicitudTramiteService.buscarPorTipoTramiteYLocal(idTipoTramite,codigoLocal);
    }
	
	/**
	 * Retorna una lista de solicitudes de trámite buscados por atributo:  
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param --
	 * @return	solicitud de trámite obtenido por búsqueda:
	 * 			{@link SolicitudTramiteResponse}
	 */
	@GetMapping("tipo-tramite/{idTipoTramite}")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','108')")
    public List<SolicitudTramiteResponse>  buscarPorTipoTramite(@PathVariable("idTipoTramite") String idTipoTramite)
    {
        return solicitudTramiteService.buscarPorTipoTramiteYLocal(idTipoTramite,null);
    }
	
	
	/**
	 * Retorna una lista de solicitudes de trámite buscados por atributo:  
	 * @param numeroDocumento
	 * 			el número de documento
	 * @param --
	 * @return	solicitud de trámite obtenido por búsqueda:
	 * 			{@link SolicitudTramiteResponse}
	 */
	@GetMapping("numero-documento/{numeroDocumento}")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','109')")
    public List<SolicitudTramiteResponse>  buscarPorNumeroDocumento(@PathVariable("numeroDocumento") String numeroDocumento)
    {
        return solicitudTramiteService.buscarPorNumeroDocumento(numeroDocumento);
    }
	
	
	/**
	 * Retorna una lista de solicitudes de trámite buscados por atributo:  
	 * @param numeroDocumento
	 * 			el número de documento
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param --
	 * @return	solicitud de trámite obtenido por búsqueda:
	 * 			{@link SolicitudTramiteResponse}
	 */
	@GetMapping("numero-documento/{numeroDocumento}/tipo-tramite/{idTipoTramite}")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','110')")
    public List<SolicitudTramiteResponse>  buscarPorNumeroDocumentoTipoTramite(@PathVariable("numeroDocumento") String numeroDocumento, @PathVariable("idTipoTramite") Integer idTipoTramite)
    {
        return solicitudTramiteService.buscarPorNumeroDocumentoTipoTramite(numeroDocumento,idTipoTramite);
    }
	
	
	/**
	 * Retorna una solicitud de trámite buscados por criterios:  
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param numeroDocumento
	 * 			el número de documento
	 * @param --
	 * @return	solicitud de trámite obtenido por búsqueda:
	 * 			{@link SolicitudTramiteResponse}
	 */
	@GetMapping("/{idSolicitudTramite}/numero-documento/{numeroDocumento}")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','111')")
    public SolicitudTramiteResponse buscarPorCriterio(@PathVariable("idSolicitudTramite") Integer idSolicitudTramite,@PathVariable("numeroDocumento") String numeroDocumento)
    {	
		
        return solicitudTramiteService.buscarPorCriterio(SolicitudTramiteFilter.builder()
        		.idSolicitudTramite(idSolicitudTramite)
        		.numeroDocumento(numeroDocumento)
        		.build());
    }
	
	/**
	 * devuelve un trámite sin requisitos
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param --
	 * @return	solicitud de trámite obtenido por búsqueda:
	 * 			{@link SolicitudTramiteResponse}
	 */
	@GetMapping("/{idSolicitudTramite}/sin-requisitos")
//	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','112')")
    public SolicitudTramiteResponse buscarPorCriterio(@PathVariable("idSolicitudTramite") Integer idSolicitudTramite)
    {	
		
        return solicitudTramiteService.buscarPorCriterio(SolicitudTramiteFilter.builder()
        		.idSolicitudTramite(idSolicitudTramite)
        		.build());
    }
	
	
	/**
	 * Búsqueda de reporte de solicitud de trámite
	 * @param reporteSolicitudTramiteFilter
	 * 			filtro
	 * @param --
	 * @return	reporte de solicitud de trámite obtenido por búsqueda:
	 * 			{@link ReporteSolicitudTramiteResponse}
	 */
	@GetMapping("/buscarReporteSolicitudTramite")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','113')")
	public @ResponseBody ReporteSolicitudTramiteResponse buscarReporteSolicitudTramite(ReporteSolicitudTramiteFilter reporteSolicitudTramiteFilter) {
		
		return solicitudTramiteService.buscarReporteSolicitudTramite(reporteSolicitudTramiteFilter);
	}
	
	
	/**
	 * Procesar una solicitud de trámite
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param procesoSolicitudTramite
	 * 			solicitud a procesar
	 * @param --
	 * @return--
	 */
	@PutMapping("/{idSolicitudTramite}/proceso")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','501')")
	//@Secured({JWTConstants.ROLE_USER})
	@ResponseStatus(code = HttpStatus.OK)
    public void procesarSolicitudTramite(
    		  @IdNumerico(maxRange = 9999999999L)@PathVariable("idSolicitudTramite") Integer id 
    		, @RequestBody ProcesoSolicitudTramiteRequest procesoSolicitudTramite)
    {
        solicitudTramiteService.procesarSolicitudTramite(id, procesoSolicitudTramite);
    }
	
	
	/**
	 * Derivar una solicitud de trámite
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param derivarSolicitudTramite
	 * 			solicitud a derivar
	 * @param --
	 * @return--
	 */
	@PutMapping("/{idSolicitudTramite}/proceso-derivar")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','114')")
	//@Secured({JWTConstants.ROLE_USER})
	@ResponseStatus(code = HttpStatus.OK)
    public void derivarSolicitudTramite(
    		  @IdNumerico(maxRange = 9999999999L)@PathVariable("idSolicitudTramite") Integer idSolicitudTramite 
    		, @RequestBody DerivarSolicitudTramiteRequest derivarSolicitudTramite)
    {
        solicitudTramiteService.derivarSolicitudTramite(idSolicitudTramite, derivarSolicitudTramite);
    }
	
	
	/**
	 * Registrar solicitud de tramite 
	 * @param solicitudTramiteRequest
	 * 			solicitud de tramite a registrar
	 * @param --
	 * @return	solicitud de trámite registrada:
	 * 			{@link --}
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@PreAuthorize("hasPermission('PRO_REG_SOLICITUD_TRAMITE','101')")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','502')")
	@ResponseStatus(code = HttpStatus.CREATED)
	public SolicitudTramiteRequest registrarSolicitudTramite(
			@Validated({ IRegistro.class, Default.class }) @RequestBody SolicitudTramiteRequest solicitudTramiteRequest)
					throws IOException{
        return solicitudTramiteService.registrarSolicitudTramiteConRequisito(solicitudTramiteRequest);
    }
    
	
	
	// REGISTRAR PERSONAREGISTRO
	/**
	 * Registrar persona en MAT
	 * @param personaRegistroSolicitudTramiteRequest
	 * 			persona a registrar
	 * @param --
	 * @return	persona registrada:
	 * 			{@link --}
	 * @throws Exception 
	 */
	@PostMapping("/registro-externos")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','503')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	@ResponseStatus(code = HttpStatus.CREATED)
	public PersonaRegistroSolicitudTramiteRequest registrarPersonaRegistro(
			@Validated({ IRegistro.class, Default.class }) @RequestBody PersonaRegistroSolicitudTramiteRequest personaRegistroSolicitudTramiteRequest) throws Exception{
        
		try {

			String gRecaptchaResponse = personaRegistroSolicitudTramiteRequest.getCaptcha();
//			System.out.println("---------------------- CAPTCHA RESPONSE: "+ gRecaptchaResponse);
			boolean verify = VerifyRecaptcha.verify("6Lc3nMEZAAAAAAaAW8QH8YJ1C2_ymbxZpcfc-mTA", gRecaptchaResponse);
//			System.out.println("-----------------------PASO EL VERIFY");
			if (verify) {
//				System.out.println("Logro entrar al verify");
//				return null;
				return solicitudTramiteService.registrarPersonaRegistro(personaRegistroSolicitudTramiteRequest);
			}
			else {
				throw new Exception("captcha error");
			}
		} catch (Exception e) {
			throw e;
		}
		
//		return solicitudTramiteService.registrarPersonaRegistro(personaRegistroSolicitudTramiteRequest);
    }


	/**
	 * Generar reporte FUT
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param numeroDocumento
	 * 			el número de documento
	 * @param --
	 * @return	reporte de FUT generado
	 * 			{@link ReporteFutResponse}
	 */
	@GetMapping("/{idSolicitudTramite}/reporte/{numeroDocumento}")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','504')")
	//@Secured({JWTConstants.ROLE_USER})
	@ResponseStatus(code = HttpStatus.CREATED)
	public ReporteFutResponse generarReporteFUT(
			@PathVariable("idSolicitudTramite") String idSolicitudTramite
			,@PathVariable("numeroDocumento") String numeroDocumento) throws FileNotFoundException, IOException{
//		byte[]  b = solicitudTramiteService.generarReporteFUT(idSolicitudTramite, numeroDocumento);
//		
//		try (FileOutputStream fos = new FileOutputStream("C:\\Users\\Administración\\Documents\\jasperPrueba\\mireporte.pdf")) {
//			   fos.write(b); 
//			   fos.close();
//			}
//		System.out.println("REPORTE = " + b);
        return solicitudTramiteService.generarReporteFUT(idSolicitudTramite, numeroDocumento);
    }
	
	
	/**
	 * Generar reporte FUT
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param numeroDocumento
	 * 			el número de documento
	 * @param codigoAlumno
	 * 			código de alumno
	 * @param --
	 * @return	reporte de FUT generado
	 * 			{@link ReporteFutResponse}
	 */
	@GetMapping("/{idSolicitudTramite}/reporte/{numeroDocumento}/codigo/{codigoAlumno}")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','505')")
	//@Secured({JWTConstants.ROLE_USER})
	@ResponseStatus(code = HttpStatus.CREATED)
	public ReporteFutResponse generarReporteFutPorCodigoYDni(
			@PathVariable("idSolicitudTramite") String idSolicitudTramite
			,@PathVariable("numeroDocumento") String numeroDocumento
			,@PathVariable("codigoAlumno") String codigoAlumno) throws FileNotFoundException, IOException{

        return solicitudTramiteService.reporteFutPorCodigoYDni(idSolicitudTramite, numeroDocumento, codigoAlumno);
    }
	
	
	/**
	 * Generar reporte Anexo 
	 * @param reporteAnexo
	 * 			solicitud de tramite a registrar
	 * @param --
	 * @return	reporte anexo:
	 * 			{@link --}
	 */
	@GetMapping("/reporte-anexo")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','506')")
	//@Secured({JWTConstants.ROLE_USER})
	@ResponseStatus(code = HttpStatus.CREATED)
	public ReporteFutResponse generarReporteAnexo(
			@RequestBody ReporteAnexoRequest reporteAnexo) throws FileNotFoundException, IOException{

        return solicitudTramiteService.generarReporteAnexo(reporteAnexo);
    }
	
	/**
	 * Generar reporte Anexo revisado 
	 * @param reporteAnexo
	 * 			solicitud de tramite a registrar
	 * @param --
	 * @return	reporte anexo:
	 * 			{@link --}
	 */
	@GetMapping("/reporte-anexo-revisado")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','507')")
	//@Secured({JWTConstants.ROLE_USER})
	@ResponseStatus(code = HttpStatus.CREATED)
	public ReporteFutResponse generarReporteAnexoRevisado(
			@RequestBody ReporteAnexoRequest reporteAnexo) throws FileNotFoundException, IOException{

        return solicitudTramiteService.generarReporteAnexoRevisado(reporteAnexo);
    }
	
	/**
	 * Cantidad total de solicitudes atendidas
	 * @param --
	 * @param --
	 * @return	cantidad
	 * 			{@link Integer}
	 */
	@GetMapping("/total-solicitudes-atendidas")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','115')")
	public Integer totalSolicitudesAtendidas() {		
		 return solicitudTramiteService.totalSolicitudesAtendidas();
	}
	
	/**
	 * Cantidad de solicitudes atendidas por día durante la semana
	 * @param --
	 * @param --
	 * @return	resultados son de tipo:
	 * 			{@link SolicitudTramiteEstadisticaResponse}
	 */
	@GetMapping("/solicitudes-ultima-semana")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','116')")
	public List<SolicitudTramiteEstadisticaResponse> solicitudesRealizadasEnLaUltimaSemana() {		
		 return solicitudTramiteService.solicitudesRealizadasEnLaUltimaSemana();
	}
	
	
	
	
	
	/////// NO DOCUMENTAR
//	@PreAuthorize("hasPermission('CON_SEGUIMIENTO_NOTIFICACION','101')")
	@GetMapping("numero-documento/{numeroDocumento}/seguimiento-notif")
//	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','116')")
    public List<SolicitudTramiteSegNotifResponse> notificacionTramiteDerivadoObservado(@PathVariable("numeroDocumento") String numeroDocumento)
    {
        return solicitudTramiteService.notificacionTramiteDerivadoObservado(numeroDocumento);
    }
	
//	@PreAuthorize("hasPermission('CON_SEGUIMIENTO_NOTIFICACION','101')")
	@GetMapping("id-tramite-seguimiento/{idTramiteSeguimiento}")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','117')")
    public SolicitudTramiteSegNotifResponse obtenerSeguimiento(@PathVariable("idTramiteSeguimiento") Integer idTramiteSeguimiento)
    {
        return solicitudTramiteService.obtenerSeguimiento(idTramiteSeguimiento);
    }
	
	@PostMapping("id-tramite-seguimiento/{idTramiteSeguimiento}/estado-seguimiento-notif")
	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','118')")
    public SolicitudTramiteSegNotifResponse actualizarEstadoNotificacion(@PathVariable("idTramiteSeguimiento") Integer idTramiteSeguimiento, @RequestBody SolicitudTramiteSegNotifResponse solTramSeguimiento)
    {
		solicitudTramiteService.actualizarEstadoNotificacion(idTramiteSeguimiento, solTramSeguimiento.getEstadoNotifLeido());
        return solicitudTramiteService.obtenerSeguimiento(idTramiteSeguimiento);
    }
	
	////// 
	
}
