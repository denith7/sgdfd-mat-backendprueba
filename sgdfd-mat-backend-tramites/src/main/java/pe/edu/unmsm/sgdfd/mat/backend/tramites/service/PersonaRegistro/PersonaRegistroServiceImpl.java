package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.PersonaRegistro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.json.simple.JSONObject;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.lang.Assert;
import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.PersonaRegistroMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.PersonaRegistroFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.PersonaRegistroRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.ProcesoSolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.expediente.UsuarioAutenticacionRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.solicitudacceso.AprobacionSolicitudRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.solicitudacceso.EnvioCorreoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.PersonaRegistroResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.PersonasRegistradasResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.expediente.UsuarioAutenticadoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.solicitudacceso.AprobacionSolicitudResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.solicitudacceso.EnvioCorreoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramite.SolicitudTramiteService;


/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de "persona registro"
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link PersonaRegistroService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link PersonaRegistroMapper} solo para operaciones de mantenimiento. 
 *
 * @author Ximena Politi
 */
@Service
@Transactional
public class PersonaRegistroServiceImpl extends MantenibleAuditadoService<PersonaRegistroRequest,PersonaRegistroResponse>
			implements PersonaRegistroService{

	
	private PersonaRegistroMapper personaRegistroMapper;
	
	@Autowired
	private SolicitudTramiteService solicitudTramiteService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	/**
     * Instancia la interface {@link PersonaRegistroMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public PersonaRegistroServiceImpl (@Qualifier("personaRegistroMapper") MantenibleMapper<PersonaRegistroRequest,PersonaRegistroResponse> mapper) {
	super (mapper);
	this.personaRegistroMapper = (PersonaRegistroMapper) mapper;
	}
	
	
	@Override
	public List<PersonaRegistroResponse> buscarTodos() {
		return personaRegistroMapper.buscarTodos();
	}
	
	@Override
	public PersonaRegistroResponse buscarPorIdItemYTipoDocumentoYNumeroDocumento(String idItem, String tipoDocumento, String numeroDocumento) {
		return personaRegistroMapper.buscarPorIdItemYTipoDocumentoYNumeroDocumento(idItem, tipoDocumento, numeroDocumento);
	}
	
	
	@Override
	public  boolean existeUsuarioPersonaRegistro(String username) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8082/ssa/backend/usuarios/existe/"+username;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		String respuesta = response.toString();
		System.out.println(respuesta);
			if(respuesta.contains("true")) {
				return true;
			}
			return false;		
	}
	
	

	
	@Override
	public void registrarPersonaRegistroEnSSA(String idItem, String tipoDocumento, String numeroDocumento) {
		
		// OBTENGO A LA PERSONA DESDE EL MAT
		PersonaRegistroResponse registroPersona = new PersonaRegistroResponse();		
		registroPersona= personaRegistroMapper.buscarPorIdItemYTipoDocumentoYNumeroDocumento(idItem, tipoDocumento, numeroDocumento);

		// INSERTAR EN SSA
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		
		
		// VERIFICO TIPO PERSONA
		if (registroPersona.getRuc() == null) {  
			// PERSONA NATURAL
			String createPersonaURL = "http://localhost:8082/ssa/backend/personas/";
			JSONObject personaJsonObject = new JSONObject();
			/*
			try {
				
				personaJsonObject.put("tipoDocumento", registroPersona.getTipoDocumento());
				personaJsonObject.put("numeroDocumento", registroPersona.getNumeroDocumento());
				personaJsonObject.put("codigo", registroPersona.getCodigoAlumno());
				personaJsonObject.put("nombres", registroPersona.getNombres());
				personaJsonObject.put("apellidoPaterno", registroPersona.getApellidoPaterno());
				personaJsonObject.put("apellidoMaterno", registroPersona.getApellidoMaterno());
				personaJsonObject.put("sexo", registroPersona.getSexo());
				personaJsonObject.put("direccionDomicilio", registroPersona.getDireccionDomicilio());
				personaJsonObject.put("fechaNacimiento", registroPersona.getFechaNacimiento());
				personaJsonObject.put("celuar", registroPersona.getCelular());
				personaJsonObject.put("telefono", registroPersona.getTelefono());
				personaJsonObject.put("correoReferencia", registroPersona.getCorreoReferencia());
				personaJsonObject.put("codigoUbigeo", registroPersona.getUbigeoPersona());
				personaJsonObject.put("username", registroPersona.getUsername());
				personaJsonObject.put("contrasenia", registroPersona.getContrasenia());
				
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			*/
			HttpEntity <String> request = new HttpEntity<String> (personaJsonObject.toString(), headers);
			String personaResponse = restTemplate.postForObject(createPersonaURL, request, String.class);	
			System.out.println(personaResponse);
			
			
		}
		
		else {
			
			//PERSONA JURIDICA
			String createEmpresaURL = "http://localhost:8082/ssa/backend/empresas/";
			
			
			/*
			try {
			
				JSONObject empresaJsonObject = new JSONObject();
				empresaJsonObject.put("tipoDocumento", registroPersona.getTipoDocumento());
				empresaJsonObject.put("numeroDocumento", registroPersona.getNumeroDocumento());
				empresaJsonObject.put("codigo", registroPersona.getCodigoAlumno());
				empresaJsonObject.put("nombres", registroPersona.getNombres());
				empresaJsonObject.put("apellidoPaterno", registroPersona.getApellidoPaterno());
				empresaJsonObject.put("apellidoMaterno", registroPersona.getApellidoMaterno());
				empresaJsonObject.put("sexo", registroPersona.getSexo());
				empresaJsonObject.put("direccionDomicilio", registroPersona.getDireccionDomicilio());
				empresaJsonObject.put("fechaNacimiento", registroPersona.getFechaNacimiento());
				empresaJsonObject.put("celuar", registroPersona.getCelular());
				empresaJsonObject.put("telefono", registroPersona.getTelefono());
				empresaJsonObject.put("correoReferencia", registroPersona.getCorreoReferencia());
				empresaJsonObject.put("ubigeoPersona", registroPersona.getUbigeoPersona());
				empresaJsonObject.put("username", registroPersona.getUsername());
				empresaJsonObject.put("contrasenia", registroPersona.getContrasenia());
				empresaJsonObject.put("tipo", registroPersona.getTipoUsuario());
				empresaJsonObject.put("ruc", registroPersona.getRuc());
				empresaJsonObject.put("razonSocial", registroPersona.getRazonSocial());
				empresaJsonObject.put("direccion", registroPersona.getDireccionEmpresa());
				empresaJsonObject.put("contacto", registroPersona.getContactoRepresentante());
				empresaJsonObject.put("ubigeoEmpresa", registroPersona.getUbigeoEmpresa());
				
				HttpEntity <String> request = new HttpEntity<String> (empresaJsonObject.toString(), headers);
			String personaResponse = restTemplate.postForObject(createEmpresaURL, request, String.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			*/
			
		};
	
		
		
	}



	@Override
	public PersonaRegistroResponse registrarPersonaRegistro(PersonaRegistroRequest personaRegistroRequest) throws Exception{
		personaRegistroRequest.setContrasenia(passwordEncoder.encode(personaRegistroRequest.getContrasenia()));
		registrar(personaRegistroRequest);
		PersonaRegistroResponse personaRegistro = personaRegistroMapper.buscarPorIdItemYTipoDocumentoYNumeroDocumento(personaRegistroRequest.getIdItem()
				, personaRegistroRequest.getTipoDocumento()
				, personaRegistroRequest.getNumeroDocumento());
		
		try {
		
			var url="http://tramiteonline.unmsm.edu.pe:8080/sgdfd/mpb-executor/notificacion/confirmacion-registro";
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			JSONObject personJsonObject = new JSONObject();
			personJsonObject.put("apellidoPaterno", personaRegistroRequest.getApellidoPaterno());
			personJsonObject.put("apellidoMaterno", personaRegistroRequest.getApellidoMaterno());
			personJsonObject.put("nombres", personaRegistroRequest.getNombres());
			personJsonObject.put("idItem", personaRegistroRequest.getIdItem());
			personJsonObject.put("tipoDocumento", personaRegistroRequest.getTipoDocumento());
			personJsonObject.put("numeroDocumento", personaRegistroRequest.getNumeroDocumento());
			personJsonObject.put("correo", personaRegistroRequest.getCorreoReferencia());
			final ObjectMapper objectMapper = new ObjectMapper();
			HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
			String personResultAsJsonStr = restTemplate.postForObject(url, request, String.class);
			JsonNode root = objectMapper.readTree(personResultAsJsonStr);
			Assert.notNull(personResultAsJsonStr);
			Assert.notNull(root);
			Assert.notNull(root.path("name").asText());
			

			
			return  personaRegistro;
		}catch(Exception e) {
			throw e;
		}
		
	}

	
	@Override
	public PersonaRegistroResponse cambioEstadoPorIdItemYTipoDocumentoYNumeroDocumento(String idItem, String tipoDocumento, String numeroDocumento) {
		PersonaRegistroRequest personaRegistroRequest = new PersonaRegistroRequest();
		personaRegistroRequest.setIdItem(idItem);
		personaRegistroRequest.setTipoDocumento(tipoDocumento);
		personaRegistroRequest.setNumeroDocumento(numeroDocumento);
		personaRegistroMapper.mantener("STATE", personaRegistroRequest, "");
		return personaRegistroMapper.buscarPorIdItemYTipoDocumentoYNumeroDocumento(idItem, tipoDocumento, numeroDocumento);
	}
	
	@Override
	public PersonaRegistroResponse buscarPorCorreo(String correoReferencia) {
		return personaRegistroMapper.buscarPorCorreo(correoReferencia);
	}
	
	@Override
	public List<PersonasRegistradasResponse> buscarPersonasPorCorreoYNumeroDocumento(PersonaRegistroFilter personaRegistroFilter){
		return personaRegistroMapper.buscarPersonasPorCorreoYNumeroDocumento(personaRegistroFilter);
	}
	
	@Override
	public PersonaRegistroResponse cambioEstadoYCreacionPerfil(String idItem, String tipoDocumento, String numeroDocumento)  throws Exception{
		
		
		
		PersonaRegistroRequest personaRegistroRequest = new PersonaRegistroRequest();
		personaRegistroRequest.setIdItem(idItem);
		personaRegistroRequest.setTipoDocumento(tipoDocumento);
		personaRegistroRequest.setNumeroDocumento(numeroDocumento);
		personaRegistroMapper.mantener("STATE", personaRegistroRequest, "");
		PersonaRegistroResponse personaR = personaRegistroMapper.buscarPorIdItemYTipoDocumentoYNumeroDocumento(idItem, tipoDocumento, numeroDocumento);
		System.out.println("-------------------------------------------ENTRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA-----------------------\n\n");
		try {
	

			var url="http://servicioonline.unmsm.edu.pe:8080/ssa/backend/usuarios/externos";
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			JSONObject personJsonObject = new JSONObject();
			personJsonObject.put("username", personaR.getUsername());
			personJsonObject.put("contrasenia", personaR.getContrasenia());
			personJsonObject.put("tipoUsuario", "E");
			personJsonObject.put("tipoDocumento", personaR.getTipoDocumento());
			personJsonObject.put("numeroDocumento", personaR.getNumeroDocumento());
			personJsonObject.put("codigo", personaR.getIdItem());
			personJsonObject.put("nombres", personaR.getNombres());
			personJsonObject.put("apellidoPaterno", personaR.getApellidoPaterno());
			personJsonObject.put("apellidoMaterno", personaR.getApellidoMaterno());
			personJsonObject.put("sexo", personaR.getSexo());
			personJsonObject.put("usuario", personaR.getUsername());
			personJsonObject.put("idSistema", "1");
			personJsonObject.put("idPerfil", "1");

			
			final ObjectMapper objectMapper = new ObjectMapper();
			HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
			String personResultAsJsonStr = restTemplate.postForObject(url, request, String.class);
			JsonNode root = objectMapper.readTree(personResultAsJsonStr);
			Assert.notNull(personResultAsJsonStr);
			Assert.notNull(root);
			Assert.notNull(root.path("name").asText());

			
			
			
			return  personaR;
		}catch(Exception e) {
			throw e;
		}
//		return personaR;
	}
	
	@Override
public PersonaRegistroResponse aprobarSolicitudAcceso(String idItem, String tipoDocumento, String numeroDocumento, Integer idSolicitud, String usuario) throws Exception{
		
		PersonaRegistroResponse personaR = personaRegistroMapper.buscarPorIdItemYTipoDocumentoYNumeroDocumento(idItem, tipoDocumento, numeroDocumento);
		try {
		
			var urlAutenticacion="http://servicioonline.unmsm.edu.pe:8080/ssa-authenticator/login";
			RestTemplate restTemplateA = new RestTemplate();
			HttpHeaders headersA = new HttpHeaders();
			headersA.setContentType(MediaType.APPLICATION_JSON);
			headersA.set("Sistema-origen", "SSA");
			UsuarioAutenticacionRequest usuarioA = UsuarioAutenticacionRequest.builder()
												.username("ssa.api.mat")
												.password("tsth1zGsKkqarLT1")
												.build();

			HttpEntity<UsuarioAutenticacionRequest> requestA =  new HttpEntity<UsuarioAutenticacionRequest>(usuarioA, headersA);
			UsuarioAutenticadoResponse uar = restTemplateA.postForObject(urlAutenticacion, requestA, UsuarioAutenticadoResponse.class);
			
			var url="http://servicioonline.unmsm.edu.pe:8080/ssa/backend/usuarios/externos";
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setBearerAuth(uar.getToken());
			AprobacionSolicitudRequest personaRequest = AprobacionSolicitudRequest.builder().username(personaR.getUsername())
													.contrasenia(personaR.getContrasenia())
													.tipoUsuario("E")
													.tipoDocumento(personaR.getTipoDocumento())
													.numeroDocumento(personaR.getNumeroDocumento())
													.codigo(personaR.getIdItem())
													.nombres(personaR.getNombres())
													.apellidoPaterno(personaR.getApellidoPaterno())
													.apellidoMaterno(personaR.getApellidoMaterno())
													.sexo(personaR.getSexo())
													.usuario(usuario)
													.idSistema("1")
													.idPerfil("3")
													.build();
			HttpEntity<AprobacionSolicitudRequest> request =  new HttpEntity<AprobacionSolicitudRequest>(personaRequest, headers);										
			restTemplate.postForObject(url, request,AprobacionSolicitudResponse.class);		
		
			var url2="http://servicioonline.unmsm.edu.pe:8080/spb/executor/notificacion/confirmacion-registro";
			RestTemplate restTemplate2 = new RestTemplate();
			HttpHeaders headers2 = new HttpHeaders();
			headers2.setContentType(MediaType.APPLICATION_JSON);
			EnvioCorreoRequest envioCorreo = EnvioCorreoRequest.builder()
											.tipoDocumento(personaR.getTipoDocumento())
											.numeroDocumento(personaR.getNumeroDocumento())
											.idItem(personaR.getIdItem())
											.nombres(personaR.getNombres())
											.apellidoPaterno(personaR.getApellidoPaterno())
											.apellidoMaterno(personaR.getApellidoMaterno())
											.correo(personaR.getCorreoReferencia())
											.mensaje("")
											.build();
			HttpEntity<EnvioCorreoRequest> request2 =  new HttpEntity<EnvioCorreoRequest>(envioCorreo, headers2);										
			restTemplate2.postForObject(url2, request2,EnvioCorreoResponse.class);	
			
			this.cambioEstadoPorIdItemYTipoDocumentoYNumeroDocumento(idItem, tipoDocumento, numeroDocumento);
			
			solicitudTramiteService.procesarSolicitudTramite(idSolicitud, ProcesoSolicitudTramiteRequest.builder().mensaje("").estado("8").build());
			
			
			return  personaR;
		}catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public PersonaRegistroResponse rechazarSolicitudAcceso(String idItem, String tipoDocumento, String numeroDocumento, Integer idSolicitud, String observacion) throws Exception{
		
		PersonaRegistroResponse personaR = personaRegistroMapper.buscarPorIdItemYTipoDocumentoYNumeroDocumento(idItem, tipoDocumento, numeroDocumento);
		try {
	
			var url="http://servicioonline.unmsm.edu.pe:8080/spb/executor/notificacion/rechazo-registro";
			RestTemplate restTemplate2 = new RestTemplate();
			HttpHeaders headers2 = new HttpHeaders();
			headers2.setContentType(MediaType.APPLICATION_JSON);
			
			EnvioCorreoRequest envioCorreo = EnvioCorreoRequest.builder()
					.tipoDocumento(personaR.getTipoDocumento())
					.numeroDocumento(personaR.getNumeroDocumento())
					.idItem(personaR.getIdItem())
					.nombres(personaR.getNombres())
					.apellidoPaterno(personaR.getApellidoPaterno())
					.apellidoMaterno(personaR.getApellidoMaterno())
					.correo(personaR.getCorreoReferencia())
					.mensaje("")
					.build();
			HttpEntity<EnvioCorreoRequest> request2 =  new HttpEntity<EnvioCorreoRequest>(envioCorreo, headers2);										
			restTemplate2.postForObject(url, request2,EnvioCorreoResponse.class);		

			solicitudTramiteService.procesarSolicitudTramite(idSolicitud, ProcesoSolicitudTramiteRequest.builder().mensaje(observacion).estado("8").build());
						
			return  personaR;
		}catch(Exception e) {
			throw e;
		}
	}
	
}