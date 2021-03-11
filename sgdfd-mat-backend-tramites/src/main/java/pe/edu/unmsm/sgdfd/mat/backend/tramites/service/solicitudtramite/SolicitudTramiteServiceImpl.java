package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramite;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.LocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PersonaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.local.LocalService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.persona.PersonaService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.requisito.RequisitoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.TipoTramiteService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.PersonaRegistroMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.SolicitudTramiteMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.ReporteSolicitudCodigoDniFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.ReporteSolicitudTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta.ReporteSolicitudTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta.SolicitudTramiteRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta.SolicitudTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.SolicitudTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.id.DetalleSolicitudTramiteId;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.DerivarSolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.PersonaRegistroRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.PersonaRegistroSolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.ProcesoSolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.ReporteAnexoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteFilterRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rae.ArchivoFoliadoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rae.ArchivoMetadataRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rae.ArchivoSegRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.ReporteFutResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.SolicitudTramiteEstadisticaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.SolicitudTramiteSegNotifResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramiterequisito.SolicitudTramiteRequisitoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramite.TramiteService;


/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de solicitud de trámite
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link SolicitudTramiteService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link SolicitudTramiteMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 * @author Ximena Politi
 */
@Service
@Transactional
@PropertySource("classpath:rae-api.properties")
public class SolicitudTramiteServiceImpl extends MantenibleAuditadoService<SolicitudTramiteRequest, SolicitudTramiteResponse>
		implements SolicitudTramiteService {
	@Autowired
	private TramiteService tramiteService;

	@Autowired
	private PersonaRegistroMapper personaRegistroMapper;
	
	@Autowired
	private SolicitudTramiteRequisitoService solicitudTramiteRequisitoService;

	private SolicitudTramiteMapper solicitudTramiteMapper;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private @Autowired Environment env;

	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private TipoTramiteService tipoTramiteService;
	
	@Autowired
	private LocalService localService;
	
	@Autowired
	private RequisitoService requisitoService;

	/**
     * Instancia la interface {@link SolicitudTramiteMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public SolicitudTramiteServiceImpl(
			@Qualifier("solicitudTramiteMapper") MantenibleMapper<SolicitudTramiteRequest, SolicitudTramiteResponse> mapper) {
		super(mapper);
		this.solicitudTramiteMapper = (SolicitudTramiteMapper) mapper;
	}

//    @Override
//	public SolicitudTramite registrarSolicitudTramite(SolicitudTramite parametroSolicitudTramite) {
//		registrar(parametroSolicitudTramite);
//		return parametroSolicitudTramite;
//	}

	
	@Override
	public List<SolicitudTramiteResponse> buscarTodosSolicitudTramite() {
		return solicitudTramiteMapper.buscarTodosSolicitudTramite();
	}
	
	@Override
	public SolicitudTramiteResponse buscarPorId(Integer id) {
		return solicitudTramiteMapper.buscarPorId(id);
	}
	
	@Override
	public SolicitudTramiteResponse buscarPorIdYNumeroDocumento(Integer id, String numeroDocumento) {
		return solicitudTramiteMapper.buscarPorIdYNumeroDocumento(id, numeroDocumento);
	}
	
	@Override
	public List<SolicitudTramiteResponse> buscarPorCodigoLocal(String codigoLocal) {
		return solicitudTramiteMapper.buscarPorLocal(codigoLocal);
	}
	
	@Override
	public List<SolicitudTramiteResponse> buscarPorLocalEstado(String codigoLocal) {
		return solicitudTramiteMapper.buscarPorLocalEstado(codigoLocal);
	}
	
	@Override
	public List<SolicitudTramiteResponse> filtrarSolicitudTramite(String codigoLocal,
			SolicitudTramiteFilterRequest solicitudTramiteFilterRequest) {
		solicitudTramiteFilterRequest.setCodigoLocal(codigoLocal);
		return solicitudTramiteMapper.filtrarSolicitudTramite(solicitudTramiteFilterRequest);
	}
	
	@Override
	public List<SolicitudTramiteResponse> buscarPorTipoTramiteYLocal(String idTipoTramite, String codigoLocal) {
		return solicitudTramiteMapper.buscarPorTipoTramiteYLocal(idTipoTramite, codigoLocal);
	}
	
	@Override
	public List<SolicitudTramiteResponse> buscarPorNumeroDocumento(String numeroDocumento) {
		return solicitudTramiteMapper.buscarPorNumeroDocumento(numeroDocumento);
	}

	@Override
	public List<SolicitudTramiteResponse> buscarPorNumeroDocumentoTipoTramite(String numeroDocumento,
			Integer codigoTipo) {
		
		return solicitudTramiteMapper.buscarPorNumeroDocumentoTipoTramite(numeroDocumento, codigoTipo);
	}
	
	@Override
	public SolicitudTramiteResponse buscarPorCriterio(
			SolicitudTramiteFilter solicitudTramiteFilter) {
		return solicitudTramiteMapper.buscarPorCriterio(solicitudTramiteFilter);
	}
	
	@Override
	public ReporteSolicitudTramiteResponse buscarReporteSolicitudTramite(
			ReporteSolicitudTramiteFilter reporteSolicitudTramiteFilter) {
		System.out.println();
		System.out.println();
		System.out.println("=======================================DOCUMENTO DE ALUMNO: "+solicitudTramiteMapper.buscarReporteSolicitudTramite(reporteSolicitudTramiteFilter).getCodigoAlumno());
		return solicitudTramiteMapper.buscarReporteSolicitudTramite(reporteSolicitudTramiteFilter);
	}
	
	@Override
	public void procesarSolicitudTramite(Integer id, ProcesoSolicitudTramiteRequest procesoSolicitudTramite) {

		switch (procesoSolicitudTramite.getEstado()) {
		case "1": // observado
		case "5": // cancelado
			SolicitudTramiteRequest solicitudTramite = SolicitudTramiteRequest.builder().idSolicitudTramite(id)
					.estado(procesoSolicitudTramite.getEstado()).build();

			actualizar(solicitudTramite);
			break;
		case "6": // derivado
			SolicitudTramiteRequest solicitudTramite2 = SolicitudTramiteRequest.builder().idSolicitudTramite(id)
					.estado(procesoSolicitudTramite.getEstado()).build();

			actualizar(solicitudTramite2);
			break;
		case "3": // aprobado
			solicitudTramite = SolicitudTramiteRequest.builder().idSolicitudTramite(id)
					.estado(procesoSolicitudTramite.getEstado())
					.fechaAprobacion(
							(procesoSolicitudTramite.getEstado().equals("3") ? java.sql.Date.valueOf(LocalDate.now())
									: null))
					.build();
			actualizar(solicitudTramite);

			// REGISTRO USANDO rest de sgd-api y obtengo numero expediente

//			Tramite tramite = Tramite.builder().fechaVencimiento(null).numeroExpediente("EXPEDIENTE")
//					.idSolicitudTramite(id).build();
//			tramiteService.registrar(tramite);

			break;
		case "8": // archivado
			SolicitudTramiteRequest solicitudTramite3 = SolicitudTramiteRequest.builder().idSolicitudTramite(id)
					.estado(procesoSolicitudTramite.getEstado()).build();

			actualizar(solicitudTramite3);
			break;
		default:
			throw new RuntimeException("Codigo de estado " + procesoSolicitudTramite.getEstado() + " no existe");
		}
	}
	
	@Override
	public void derivarSolicitudTramite(Integer id, DerivarSolicitudTramiteRequest derivarSolicitudTramite) {
		
		SolicitudTramiteRequest solicitudTramite = SolicitudTramiteRequest.builder().idSolicitudTramite(id)
				.estado(derivarSolicitudTramite.getEstado())
				.numeroExpediente(derivarSolicitudTramite.getNumeroExpediente())
				.build();
		
		solicitudTramiteMapper.mantener("UPDATE", solicitudTramite, derivarSolicitudTramite.getUsuario());
		
	}
	
	@Override
	public SolicitudTramiteRequest registrarSolicitudTramiteConRequisito(
			SolicitudTramiteRequest solicitudTramiteRequest) throws IOException{

		SolicitudTramiteRequest solicitudTramite = SolicitudTramiteRequest.builder()
				.idSolicitudTramite(solicitudTramiteRequest.getIdSolicitudTramite())
				.fechaSolicitud(solicitudTramiteRequest.getFechaSolicitud())
				.fechaAprobacion(solicitudTramiteRequest.getFechaAprobacion())
				.tipoDocumentoIdentidad(solicitudTramiteRequest.getTipoDocumentoIdentidad())
				.numeroDocumentoIdentidad(solicitudTramiteRequest.getNumeroDocumentoIdentidad())
				.codigoSolicitante(solicitudTramiteRequest.getCodigoSolicitante())
				.asunto(solicitudTramiteRequest.getAsunto()).justificacion(solicitudTramiteRequest.getJustificacion())
				.codigoLocal(solicitudTramiteRequest.getCodigoLocal())
				.codigoLocalSolicitante(solicitudTramiteRequest.getCodigoLocalSolicitante())
				.idTipoTramite(solicitudTramiteRequest.getIdTipoTramite()).estado(solicitudTramiteRequest.getEstado())
				.tipoDocumentoRegistrado(solicitudTramiteRequest.getTipoDocumentoRegistrado()).build();

//		registrar(solicitudTramite);
		solicitudTramiteMapper.mantener("INSERT", solicitudTramite, solicitudTramiteRequest.getUsuario());
		
		solicitudTramiteRequest.getLsSolicitudTramiteRequisito().forEach(str -> {
			byte[] archivoAdjunto;
			
			if(str.getTipoRequisito().equals("6")) {
				
				
				//OBTENIENDO INFORMACIÓN ADICIONAL 
				PersonaResponse pr=personaService.buscarPorCodigoPersona(solicitudTramiteRequest.getCodigoSolicitante());
				List<ArchivoMetadataRequest> listaMetaData=new ArrayList<>();
				TipoTramiteResponse ttr= tipoTramiteService.buscarPorIdTipoTramite(solicitudTramiteRequest.getIdTipoTramite());
				LocalResponse lr=	localService.buscarPorId(solicitudTramiteRequest.getCodigoLocal());
				RequisitoResponse rr= requisitoService.buscarPorIdRequisito(str.getIdRequisito());
				
				//AÑADIENDO CAMPOS ADICIONALES (ASUNTO, TIPO TRÁMITE, DESTINO)
				listaMetaData.add(ArchivoMetadataRequest.builder()
										.idCampo(1)
										.valor(solicitudTramiteRequest.getAsunto())
										.build());
				listaMetaData.add(ArchivoMetadataRequest.builder()
										.idCampo(2)
										.valor(ttr.getNombre())
										.build());
				listaMetaData.add(ArchivoMetadataRequest.builder()
										.idCampo(3)
										.valor(lr.getDescripcion())
										.build());
				
				//CONSTRUYENDO EL OBJETO A ENVIAR AL RAE
//				JSONObject user = new JSONObject();
//				user.put("username", env.getProperty("usuario"));
				
				ArchivoSegRequest asr=ArchivoSegRequest.builder()
					.tipoDocumento(solicitudTramiteRequest.getTipoDocumentoIdentidad())
					.numeroDocumento(solicitudTramiteRequest.getNumeroDocumentoIdentidad())
					.apellidoPaterno(pr.getApellidoPaterno())
					.apellidoMaterno(pr.getApellidoMaterno())
					.nombres(pr.getNombres())
					.idOrigen(1)
					.codigoReferencia(solicitudTramite.getIdSolicitudTramite().toString())
					.referencia("MAT | Solicitud "+solicitudTramite.getIdSolicitudTramite().toString()+" | R-"+str.getIdRequisito().toString())
					.lsMetaData(listaMetaData)
					.nombreArchivo(rr.getNombre())
					.formato("pdf")
					.archivo(str.getArchivoAdjunto())
					.usuario(solicitudTramiteRequest.getUsuario())
					.build();
				
				//ALMACENANDO EN EL RAE Y RETORNO DEL ARCHIVO FOLIADO Y CON GLOSA
				var urlRegistroArchivo=env.getProperty("url.almacenar-archivo");
				RestTemplate restTemplate = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				
				HttpEntity<ArchivoSegRequest> request =  new HttpEntity<ArchivoSegRequest>(asr, headers);
				ArchivoFoliadoResponse afr = restTemplate.postForObject(urlRegistroArchivo, request, ArchivoFoliadoResponse.class);
				
				//EL REPORTE DE LO ALMACENADO EN EL RAE SE REGISTRARÁ EN EL MAT
				archivoAdjunto=afr.getReporte();
				
			}else {
				//EL REQUISITO NO REQUIERE SER ALMACENADO EN EL RAE
				archivoAdjunto=str.getArchivoAdjunto();				
			}
			
			if(str.getTipoRequisito().equals("5")) {
				//REGISTRO DE REQUISITO tipo 5
				solicitudTramiteRequisitoService.registrarDetalleSolicitudTramite(
						SolicitudTramiteRequisitoRequest.builder().idSolicitudTramite(solicitudTramite.getIdSolicitudTramite())
								.idTipoTramite(str.getIdTipoTramite())
								.idRequisito(str.getIdRequisito())
								.archivoAdjunto(archivoAdjunto)
								.valor(str.getValor())
								.indicadorSgd(str.getIndicadorSgd())
								.asunto(str.getAsunto())
								.numeroDocumento(str.getNumeroDocumento())
								.tipoDocumento(str.getTipoDocumento())
								.build());
			}else {
				//REGISTRO DEL REQUISITO (diferente a 5)
				solicitudTramiteRequisitoService.registrarDetalleSolicitudTramite(
						SolicitudTramiteRequisitoRequest.builder().idSolicitudTramite(solicitudTramite.getIdSolicitudTramite())
								.idTipoTramite(str.getIdTipoTramite())
								.idRequisito(str.getIdRequisito())
								.archivoAdjunto(archivoAdjunto)
								.valor(str.getValor())
								.indicadorSgd(str.getIndicadorSgd())
								.build());
			}
			
			
			str.setIdSolicitudTramite(solicitudTramite.getIdSolicitudTramite());
		});

		solicitudTramiteRequest.setIdSolicitudTramite(solicitudTramite.getIdSolicitudTramite());

//		solicitudTramiteMapper.buscarPorId();

		return solicitudTramiteRequest;
	}

	@Override
	public PersonaRegistroSolicitudTramiteRequest registrarPersonaRegistro(
			PersonaRegistroSolicitudTramiteRequest personaRegistroSolicitudTramiteRequest) {


			// --------------- Registrar en PersonaRegistro------------------
		
		PersonaRegistroRequest personaRegistro = PersonaRegistroRequest.builder()
				.idItem(personaRegistroSolicitudTramiteRequest.getIdPersonaRegistro())
				.tipoDocumento(personaRegistroSolicitudTramiteRequest.getTipoDocumento())
				.numeroDocumento(personaRegistroSolicitudTramiteRequest.getNumeroDocumento())
				.nombres(personaRegistroSolicitudTramiteRequest.getNombres())
				.apellidoPaterno(personaRegistroSolicitudTramiteRequest.getApellidoPaterno())
				.apellidoMaterno(personaRegistroSolicitudTramiteRequest.getApellidoMaterno())
				.sexo(personaRegistroSolicitudTramiteRequest.getSexo())
				.direccionDomicilio(personaRegistroSolicitudTramiteRequest.getDireccionDomicilio())
				.fechaNacimiento(personaRegistroSolicitudTramiteRequest.getFechaNacimiento())
				.celular(personaRegistroSolicitudTramiteRequest.getCelular())
				.telefono(personaRegistroSolicitudTramiteRequest.getTelefono())
				.correoReferencia(personaRegistroSolicitudTramiteRequest.getCorreoReferencia())
				.codigoAlumno(personaRegistroSolicitudTramiteRequest.getCodigoAlumno())
				.ubigeoPersona(personaRegistroSolicitudTramiteRequest.getUbigeoPersona())
				.username(personaRegistroSolicitudTramiteRequest.getUsername())
				.contrasenia(passwordEncoder.encode(personaRegistroSolicitudTramiteRequest.getContrasenia()))
				.tipoUsuario(personaRegistroSolicitudTramiteRequest.getTipoUsuario())
				.ruc(personaRegistroSolicitudTramiteRequest.getRuc())
				.razonSocial(personaRegistroSolicitudTramiteRequest.getRazonSocial())
				.direccionEmpresa(personaRegistroSolicitudTramiteRequest.getDireccionEmpresa())
				.contactoRepresentante(personaRegistroSolicitudTramiteRequest.getContactoRepresentante())
				.ubigeoEmpresa(personaRegistroSolicitudTramiteRequest.getUbigeoEmpresa())
				.tipoExterno(personaRegistroSolicitudTramiteRequest.getTipoExterno())
				.build()
					;
		
		
		personaRegistroMapper.mantener("INSERT", personaRegistro, personaRegistroSolicitudTramiteRequest.getUsuario());
		
		
			// --------------- Registrar en solicitudTramite------------------
			
		SolicitudTramiteRequest solicitudTramite = SolicitudTramiteRequest.builder()
				.idSolicitudTramite(personaRegistroSolicitudTramiteRequest.getIdSolicitudTramite())
				.fechaSolicitud(personaRegistroSolicitudTramiteRequest.getFechaSolicitud())
				.fechaAprobacion(personaRegistroSolicitudTramiteRequest.getFechaAprobacion())
				.tipoDocumentoIdentidad(personaRegistroSolicitudTramiteRequest.getTipoDocumentoIdentidad())
				.numeroDocumentoIdentidad(personaRegistroSolicitudTramiteRequest.getNumeroDocumentoIdentidad())
				.asunto(personaRegistroSolicitudTramiteRequest.getAsunto())
				.justificacion(personaRegistroSolicitudTramiteRequest.getJustificacion())
				.codigoLocal(personaRegistroSolicitudTramiteRequest.getCodigoLocal())
				.codigoLocalSolicitante(personaRegistroSolicitudTramiteRequest.getCodigoLocalSolicitante())
				.idTipoTramite(personaRegistroSolicitudTramiteRequest.getIdTipoTramite())
				.estado(personaRegistroSolicitudTramiteRequest.getEstado())
				.tipoDocumentoRegistrado(personaRegistroSolicitudTramiteRequest.getTipoDocumentoRegistrado())
				.codigoSolicitante(personaRegistro.getIdItem().toString())
				.build();
				System.out.println(personaRegistroSolicitudTramiteRequest.getIdPersonaRegistro());
		solicitudTramiteMapper.mantener("INSERT", solicitudTramite, personaRegistroSolicitudTramiteRequest.getUsuario());
		
		
		personaRegistroSolicitudTramiteRequest.getLsSolicitudTramiteRequisito().forEach(str -> {
			solicitudTramiteRequisitoService.registrarDetalleSolicitudTramite(
					SolicitudTramiteRequisitoRequest.builder().idSolicitudTramite(solicitudTramite.getIdSolicitudTramite())
							.idTipoTramite(str.getIdTipoTramite()).idRequisito(str.getIdRequisito())
							.archivoAdjunto(str.getArchivoAdjunto()).valor(str.getValor())
							.indicadorSgd(str.getIndicadorSgd())
							.build());
			str.setIdSolicitudTramite(solicitudTramite.getIdSolicitudTramite());
		});

		personaRegistroSolicitudTramiteRequest.setIdSolicitudTramite(solicitudTramite.getIdSolicitudTramite());

//		solicitudTramiteMapper.buscarPorId();

		return personaRegistroSolicitudTramiteRequest;
	}


	@Override
	public ReporteFutResponse generarReporteFUT(String idSolicitudTramite, String numeroDocumento) {
		byte[] data = null;
		
//		System.out.println("DATOS= " + idSolicitudTramite + " ------------ " +numeroDocumento );
////		ArrayList<requisito> lista= new ArrayList<>(); 
		
		ReporteSolicitudTramiteResponse rstr = buscarReporteSolicitudTramite(ReporteSolicitudTramiteFilter.builder()
				.idSolicitudTramite(idSolicitudTramite).numeroDocumento(numeroDocumento).build());
		

		if (rstr != null && rstr.getNumeroDocumentoIdentidad().equals(numeroDocumento)) {

			try {

				Map<String, Object> parametros = new HashMap<>();
				parametros.put("numeroDocumento", rstr.getNumeroDocumentoIdentidad());
				parametros.put("codigoAlumno", rstr.getCodigoAlumno());
				parametros.put("nombreCompleto", rstr.getNombreCompleto());
				parametros.put("facultad", rstr.getFacultadAlumno());
				parametros.put("escuelaProfesional", rstr.getEscuelaAlumno());
				parametros.put("especialidad", rstr.getEspecialidadAlumno());
				parametros.put("numeroSolicitud", rstr.getIdSolicitudTramiteReporte());
				parametros.put("tramite", rstr.getTipoTramite());
				parametros.put("fechaSolicitud", rstr.getFechaSolicitud());
				parametros.put("estadoSolicitud", rstr.getEstadoSolicitud());
				parametros.put("fechaAprobacion", rstr.getFechaAprobacion());
				parametros.put("estadoTramite", rstr.getEstadoTramite());
				parametros.put("fechaGeneracion", new Date());

				parametros.put("tipoDocumento", rstr.getTipoDocumento());
				parametros.put("domicilio", rstr.getDomicilio());
				parametros.put("celular", rstr.getCelular());
				parametros.put("correoInstitucional", rstr.getCorreoInstitucional());
				parametros.put("tipoSolicitante", rstr.getTipoSolicitante());
				parametros.put("lugarSolicitado", rstr.getNombreLocal());
				parametros.put("numeroExpediente", rstr.getNumeroExpediente());

				File file = new ClassPathResource("/reportes/RptSolicitudTramite3.jasper").getFile();
				JasperPrint print = JasperFillManager.fillReport(file.getPath(), parametros,
						new JRBeanCollectionDataSource(rstr.getRequisitos()));
				data = JasperExportManager.exportReportToPdf(print);

//				try (FileOutputStream fos = new FileOutputStream(
//						"C:\\Users\\Administración\\Documents\\jasperPrueba\\mireporte.pdf")) {
//					fos.write(data);
//					fos.close();
//				}
				System.out.println("=========================		TipoDocumento: "+rstr.getTipoDocumento()+", Domicilio: "+rstr.getDomicilio()+", Celular: "+rstr.getCelular()+", Correo Institucional: "+rstr.getCorreoInstitucional()+", Tipo Solicitante: "+rstr.getTipoSolicitante()+", Codigo Alumno: "+rstr.getCodigoAlumno());
				System.out.println("----------------------- Formato: "+rstr.getRequisitos().get(0).getFormato());	
			} catch (Exception e) {
				e.printStackTrace();
			}

			return ReporteFutResponse.builder().reporteFUT(data).build();
		} else {
			throw new RuntimeException("El DNI no corresponde con el de la solicitud");
		}

	}
	
	@Override
	public ReporteFutResponse reporteFutPorCodigoYDni(String idSolicitudTramite, String numeroDNI, String codigoAlumno) {
		byte[] data = null;
		
		ReporteSolicitudTramiteResponse rstr = buscarReportePorCodigoYDni(ReporteSolicitudCodigoDniFilter.builder()
				.idSolicitudTramite(idSolicitudTramite).numeroDocumento(numeroDNI).codigoAlumno(codigoAlumno).build());
		

		if (rstr != null && rstr.getNumeroDocumentoIdentidad().equals(numeroDNI) && rstr.getCodigoAlumno().equals(codigoAlumno) ) {

			try {

				Map<String, Object> parametros = new HashMap<>();
				parametros.put("numeroDocumento", rstr.getNumeroDocumentoIdentidad());
				parametros.put("codigoAlumno", rstr.getCodigoAlumno());
				parametros.put("nombreCompleto", rstr.getNombreCompleto());
				parametros.put("facultad", rstr.getFacultadAlumno());
				parametros.put("escuelaProfesional", rstr.getEscuelaAlumno());
				parametros.put("especialidad", rstr.getEspecialidadAlumno());
				parametros.put("numeroSolicitud", rstr.getIdSolicitudTramiteReporte());
				parametros.put("tramite", rstr.getTipoTramite());
				parametros.put("fechaSolicitud", rstr.getFechaSolicitud());
				parametros.put("estadoSolicitud", rstr.getEstadoSolicitud());
				parametros.put("fechaAprobacion", rstr.getFechaAprobacion());
				parametros.put("estadoTramite", rstr.getEstadoTramite());
				parametros.put("fechaGeneracion", new Date());

				parametros.put("tipoDocumento", rstr.getTipoDocumento());
				parametros.put("domicilio", rstr.getDomicilio());
				parametros.put("celular", rstr.getCelular());
				parametros.put("correoInstitucional", rstr.getCorreoInstitucional());
				parametros.put("tipoSolicitante", rstr.getTipoSolicitante());
				parametros.put("lugarSolicitado", rstr.getNombreLocal());
				parametros.put("numeroExpediente", rstr.getNumeroExpediente());

				File file = new ClassPathResource("/reportes/RptSolicitudTramite3.jasper").getFile();
				JasperPrint print = JasperFillManager.fillReport(file.getPath(), parametros,
						new JRBeanCollectionDataSource(rstr.getRequisitos()));
				data = JasperExportManager.exportReportToPdf(print);

//				try (FileOutputStream fos = new FileOutputStream(
//						"C:\\Users\\Administración\\Documents\\jasperPrueba\\mireporte.pdf")) {
//					fos.write(data);
//					fos.close();
//				}
				System.out.println("=========================		TipoDocumento: "+rstr.getTipoDocumento()+", Domicilio: "+rstr.getDomicilio()+", Celular: "+rstr.getCelular()+", Correo Institucional: "+rstr.getCorreoInstitucional()+", Tipo Solicitante: "+rstr.getTipoSolicitante());
				System.out.println("----------------------- Formato: "+rstr.getRequisitos().get(0).getFormato());	
			} catch (Exception e) {
				e.printStackTrace();
			}

			return ReporteFutResponse.builder().reporteFUT(data).build();
		} else {
			if(!rstr.getNumeroDocumentoIdentidad().equals(numeroDNI)) {
				throw new RuntimeException("El DNI no corresponde con el de la solicitud");
			}
			else {
				if(!rstr.getCodigoAlumno().equals(codigoAlumno) ) {
					throw new RuntimeException("El Codigo de Alumno no corresponde con el de la solicitud");
				}else {
					throw new RuntimeException("El reporte FUT no existe");
				}
			}
			
		}

	}


	@Override
	public Integer totalSolicitudesAtendidas() {		
		return solicitudTramiteMapper.totalSolicitudesAtendidas();
	}
	
	@Override
	public List<SolicitudTramiteEstadisticaResponse> solicitudesRealizadasEnLaUltimaSemana() {		
		return solicitudTramiteMapper.solicitudesRealizadasEnLaUltimaSemana();
	}
	
	@Override
	public void actualizarEstadoNotificacion(Integer idTramiteSeguimiento, Integer estadoNotifLeido) {
		solicitudTramiteMapper.actualizarEstadoNotificacion(idTramiteSeguimiento, estadoNotifLeido);
	}
	
	@Override
	public ReporteSolicitudTramiteResponse buscarReportePorCodigoYDni(
			ReporteSolicitudCodigoDniFilter reporteSolicitudCodigoDniFilter) {
		ReporteSolicitudTramiteResponse prueba= solicitudTramiteMapper.buscarReportePorCodigoYDni(reporteSolicitudCodigoDniFilter);
		System.out.println();
		System.out.println();
		System.out.println("=======================================NUMERO DOCUMENTO DE IDENTIDAD: "+prueba.getNumeroDocumentoIdentidad());
		return solicitudTramiteMapper.buscarReportePorCodigoYDni(reporteSolicitudCodigoDniFilter);
	}
	
	

//////////// NO DOCUMENTAR

	@Override
	public List<SolicitudTramiteSegNotifResponse> notificacionTramiteDerivadoObservado(String numeroDocumento) {
		return solicitudTramiteMapper.notificacionTramiteDerivadoObservado(numeroDocumento);
	}

	@Override
	public SolicitudTramiteSegNotifResponse obtenerSeguimiento(Integer idTramiteSeguimiento) {
		return solicitudTramiteMapper.obtenerSeguimiento(idTramiteSeguimiento);
	}


//	@Override
//	public SolicitudTramite actualizarSolicitudTramite(Integer idSolicitudTramite, SolicitudTramite parametroSolicitudTramite) {
//		parametroSolicitudTramite.setIdSolicitudTramite(idSolicitudTramite);
//		actualizar(parametroSolicitudTramite);
//		return parametroSolicitudTramite;
//	}

//	
//	@Override
//	public byte[] generarReporte(VentaDTO venta) {
//		
//	}
	
	 @Override
	 public ReporteFutResponse generarReporteAnexo(ReporteAnexoRequest reporte) {
		 byte[] data = null;
			
			
			SolicitudTramiteResponse str = this.buscarPorId(reporte.getIdSolicitud());
			SolicitudTramiteRequisitoResponse strr = solicitudTramiteRequisitoService.buscarPorId(DetalleSolicitudTramiteId.builder().
																									idTipoTramite(reporte.getIdTipoTramite())
																									.idSolicitudTramite(reporte.getIdSolicitud())
																									.idRequisito(reporte.getIdRequisito())
																									.idItem(reporte.getIdItem()).build()
																									);				
					
					
			if (str != null &&  str.getIdSolicitudTramite().equals(reporte.getIdSolicitud())) {

				try {

					Map<String, Object> parametros = new HashMap<>();
					parametros.put("numeroSolicitud", str.getIdSolicitudTramite());
					parametros.put("numeroExpediente", str.getNumeroExpediente());
					parametros.put("tipoDocumento", str.getTipoDocumentoIdentidad());
					parametros.put("numeroDocumento", str.getNumeroDocumentoIdentidad());
					parametros.put("tramite", str.getNombreTipoTramite());
					parametros.put("nombreRequisito", strr.getNombreRequisito());
					parametros.put("url", reporte.getUrl());
					parametros.put("solicitante",str.getNombres()+" "+str.getApellidoPaterno()+" "+str.getApellidoMaterno());
					parametros.put("fechaEnvio", new Date());
					parametros.put("fechaGeneracion", new Date());
					


					File file = new ClassPathResource("/reportes/AnexoSolicitudRequisito.jasper").getFile();
					JasperPrint print = JasperFillManager.fillReport(file.getPath(), parametros,
							new JRBeanCollectionDataSource(str.getRequisitos()));
					data = JasperExportManager.exportReportToPdf(print);


				} catch (Exception e) {
					e.printStackTrace();
				}

				return ReporteFutResponse.builder().reporteFUT(data).build();
			} else {
//				if(!str.getIdSolicitudTramite().equals(reporte.getIdSolicitud())) {
//					throw new RuntimeException("El id no corresponde con el de la solicitud");
//				}
//				else {
						throw new RuntimeException("El reporte anexo no existe");
					
//				}
				
			}
	 }
	 
	 
	 @Override
	 public ReporteFutResponse generarReporteAnexoRevisado(ReporteAnexoRequest reporte) {
		 byte[] data = null;
			
			

			SolicitudTramiteResponse str = this.buscarPorId(reporte.getIdSolicitud());
			SolicitudTramiteRequisitoResponse strr = solicitudTramiteRequisitoService.buscarPorId(DetalleSolicitudTramiteId.builder().
																									idTipoTramite(reporte.getIdTipoTramite())
																									.idSolicitudTramite(reporte.getIdSolicitud())
																									.idRequisito(reporte.getIdRequisito())
																									.idItem(reporte.getIdItem()).build()
																									);			
//			ReporteSolicitudTramiteResponse rst = this.buscarReporteSolicitudTramite(ReporteSolicitudTramiteFilter.builder()
//																									.idSolicitudTramite(reporte.getIdSolicitud().toString())
//																									.numeroDocumento(str.getNumeroDocumentoIdentidad())
//																									.build()
//																									);
//			
					
					
			if (str != null &&  str.getIdSolicitudTramite().equals(reporte.getIdSolicitud())) {

				try {

					Map<String, Object> parametros = new HashMap<>();
					parametros.put("numeroSolicitud", str.getIdSolicitudTramite());
					parametros.put("numeroExpediente", str.getNumeroExpediente());
					parametros.put("tipoDocumento", str.getTipoDocumentoIdentidad());
					parametros.put("numeroDocumento", str.getNumeroDocumentoIdentidad());
					parametros.put("tramite", str.getNombreTipoTramite());
					parametros.put("nombreRequisito", strr.getNombreRequisito());
					parametros.put("url", reporte.getUrl());
					parametros.put("solicitante",str.getNombres()+" "+str.getApellidoPaterno()+" "+str.getApellidoMaterno());
					parametros.put("fechaEnvio", new Date());
					parametros.put("fechaGeneracion", new Date());
					parametros.put("nombreRequisitoFirmado", reporte.getNombreRequisitoFirmado());
					parametros.put("fechaRecepcion", str.getFechaAprobacion());
					parametros.put("urlRevisado",reporte.getUrl());	//esta url debe ser sacada de BD
					
					
					File file = new ClassPathResource("/reportes/AnexoSolicitudRequisito2.jasper").getFile();
					JasperPrint print = JasperFillManager.fillReport(file.getPath(), parametros,
							new JRBeanCollectionDataSource(str.getRequisitos()));
					data = JasperExportManager.exportReportToPdf(print);


				} catch (Exception e) {
					e.printStackTrace();
				}

				return ReporteFutResponse.builder().reporteFUT(data).build();
			} else {
//				if(!str.getIdSolicitudTramite().equals(reporte.getIdSolicitud())) {
//					throw new RuntimeException("El id no corresponde con el de la solicitud");
//				}
//				else {
						throw new RuntimeException("El reporte anexo no existe");
					
//				}
				
			}
	 }

}
