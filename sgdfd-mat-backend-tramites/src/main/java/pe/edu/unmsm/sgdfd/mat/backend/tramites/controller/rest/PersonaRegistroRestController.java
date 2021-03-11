package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest;

import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.lang.Assert;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.PersonaRegistroFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.PersonaRegistroRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.ProcesoSolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.PersonaRegistroResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.PersonasRegistradasResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.PersonaRegistro.PersonaRegistroService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.sw.VerifyRecaptcha;

/**
 * --
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Búsqueda de una lista de todas las "persona registro"
 * 	<li>Consulta de existencia de "persona registro" por su username
 *  <li>Búsqueda de una  "persona registro" por identificador de item, tipo de documento y número de documento
 *  <li>Registro de una "persona registro" en el SSA
 * </ul>
 * 
 * @author Ximena Politi
 * @see PersonaRegistroResponse
 * @see PersonaRegistroService
 */
@Validated
@RestController
@RequestMapping("/persona-registro")
public class PersonaRegistroRestController {
	
	private PersonaRegistroService personaRegistroService;
	public PersonaRegistroRestController(PersonaRegistroService personaRegistroService) {
		this.personaRegistroService = personaRegistroService;
	}
	
	/**
	 * Muestra una lista de todos los "persona registro".  
	 * @param --
	 * 			
	 * @param --
	 * @return	lista de "persona registro" obtenidos por búsqueda son de tipo:
	 * 			{@link PersonaRegistroResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('PRO_PERSONA_REGISTRO','101')")
    public List<PersonaRegistroResponse> buscarTodos(){
        return personaRegistroService.buscarTodos();
    }
	
	/**
	 * Retorna una "persona registro" buscado por atributo:  
	 * @param idItem
	 * 			identificador de item
	 * @param tipoDocumento
	 * 			tipo de documento
	 * @param numeroDocumento
	 * 			número de documento
	 * @param --
	 * @return	"persona registro" obtenido por búsqueda:
	 * 			{@link PersonaRegistroResponse}
	 */
	@GetMapping("/{idItem}/tipo-documento/{tipoDocumento}/numero-documento/{numeroDocumento}")
//	@PreAuthorize("hasPermission('PRO_PERSONA_REGISTRO','102')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public PersonaRegistroResponse buscarPorIdItemYTipoDocumentoYNumeroDocumento( @PathVariable("idItem") String idItem
    												  ,@PathVariable("tipoDocumento") String tipoDocumento
    												  ,@PathVariable("numeroDocumento") String numeroDocumento){
		
        return personaRegistroService.buscarPorIdItemYTipoDocumentoYNumeroDocumento(idItem, tipoDocumento, numeroDocumento );
    }
	
	
	/**
	 * Retorna la confirmación de exixtencia usuario de "persona registro" buscado por atributo:  
	 * @param username
	 * 			usuario de "persona registro"
	 * @param --
	 * @return	un boolean "true" si exixte y "false" si no
	 */
	@GetMapping("/existe-usuario/{username}")
	@PreAuthorize("hasPermission('PRO_PERSONA_REGISTRO','501')")
    public boolean existeUsuarioPersonaRegistro( @PathVariable("username") String username){
		
        return personaRegistroService.existeUsuarioPersonaRegistro(username);
    }
	
	/**
	 * Recibe petición de registro en SSA de "persona registro" .  
	 * @param idItem
	 * 			identificador de item
	 * @param tipoDocumento
	 * 			tipo de documento
	 * @param numeroDocumento
	 * 			número de documento
	 * @param --
	 */

	@PostMapping("/{idItem}/tipo-documento/{tipoDocumento}/numero-documento/{numeroDocumento}")
	@PreAuthorize("hasPermission('PRO_PERSONA_REGISTRO','502')")
	public void registrarPersonaRegistroEnSSA( @PathVariable("idItem") String idItem
    										  ,@PathVariable("tipoDocumento") String tipoDocumento
    										  ,@PathVariable("numeroDocumento") String numeroDocumento){
		
         personaRegistroService.registrarPersonaRegistroEnSSA(idItem, tipoDocumento, numeroDocumento );
    }

	
	
	/**
	 * Recibe petición de registro de "persona registro".  
	 * @param idItem
	 * 			identificador de item
	 * @param tipoDocumento
	 * 			tipo de documento
	 * @param numeroDocumento
	 * 			número de documento
	 * @param --
	 */

	@PostMapping("/")
	@PreAuthorize("hasPermission('PRO_PERSONA_REGISTRO','503')")
    public PersonaRegistroResponse registrarPersonaRegistro( @RequestBody PersonaRegistroRequest personaRegistroRequest) throws Exception {
		
//		try {
//			
//			String gRecaptchaResponse = personaRegistroRequest.getCaptcha();
//
//			boolean verify = VerifyRecaptcha.verify("6Lc3nMEZAAAAAAaAW8QH8YJ1C2_ymbxZpcfc-mTA", gRecaptchaResponse);
//			if (verify) {
//
//				return  personaRegistroService.registrarPersonaRegistro(personaRegistroRequest);
//			}
//			else {
//				throw new Exception("captcha error");
//			}
//		} catch (Exception e) {
//			throw e;
//		}
		
	
		return personaRegistroService.registrarPersonaRegistro(personaRegistroRequest);
		
	}
		
		
    
	
	/**
	 * Solicitud de cambio de estado, retorna una "persona registro" 
	 * @param idItem
	 * 			identificador de item
	 * @param tipoDocumento
	 * 			tipo de documento
	 * @param numeroDocumento
	 * 			número de documento
	 * @param --
	 * @return	"persona registro" obtenido por:
	 * 			{@link PersonaRegistroResponse}
	 */
	@GetMapping("/cambio-estado/{idItem}/tipo-documento/{tipoDocumento}/numero-documento/{numeroDocumento}")
//	@PreAuthorize("hasPermission('PRO_PERSONA_REGISTRO','103')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public PersonaRegistroResponse cambioEstadoPorIdItemYTipoDocumentoYNumeroDocumento( @PathVariable("idItem") String idItem
    												  ,@PathVariable("tipoDocumento") String tipoDocumento
    												  ,@PathVariable("numeroDocumento") String numeroDocumento){
		
        return personaRegistroService.cambioEstadoPorIdItemYTipoDocumentoYNumeroDocumento(idItem, tipoDocumento, numeroDocumento );
    }
	
	
	/**
	 * Retorna una Persona Registro buscada por
	 * @param correoReferencia
	 * 			correo de la persona registro
	 * @param --
	 * @return	"persona registro" obtenido por:
	 * 			{@link PersonaRegistroResponse}
	 */
	@GetMapping("/buscar-correo/{correoReferencia}")
	@PreAuthorize("hasPermission('PRO_PERSONA_REGISTRO','104')")
	public PersonaRegistroResponse buscarPorCorreo(@PathVariable("correoReferencia") String correoReferencia) {
		return personaRegistroService.buscarPorCorreo(correoReferencia);
	}
	
	/**
	 * Retorna una lista de Personas Registradas
	 * @param correoInstitucional
	 * 			correo de las personas registradas
	 * @param numeroDocumento
	 * 			numero de documento de las personas registradas
	 * @param --
	 * @return  lista de "personasRegistradas" obtenida por:
	 * 				{@link PersonasRegistradas}
	 */
	@GetMapping("/buscar-persona-registrada/{correoInstitucional}/numeroDocumento/{numeroDocumento}")
	@PreAuthorize("hasPermission('PRO_PERSONA_REGISTRO','105')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<PersonasRegistradasResponse> buscarPersonasPorCorreoYNumeroDocumento(@PathVariable("correoInstitucional") String correoInstitucional,@PathVariable("numeroDocumento") String numeroDocumento){
		return personaRegistroService.buscarPersonasPorCorreoYNumeroDocumento(PersonaRegistroFilter.builder().numeroDocumento(numeroDocumento).correoInstitucional(correoInstitucional).build());
	}
	
	/**
	 * Solicitud de cambio de estado y creacion de perfil para una PersonaRegistro
	 * @throws Exception 
	 * 
	 * 
	 */
	@PostMapping("/cambio-estado-crea-perfil/{idItem}/tipo-documento/{tipoDocumento}/numero-documento/{numeroDocumento}")
	@PreAuthorize("hasPermission('PRO_PERSONA_REGISTRO','504')")
	public PersonaRegistroResponse cambioEstadoYCreacionPerfil(@PathVariable("idItem") String idItem
			  ,@PathVariable("tipoDocumento") String tipoDocumento
			  ,@PathVariable("numeroDocumento") String numeroDocumento) throws Exception {
		return personaRegistroService.cambioEstadoYCreacionPerfil(idItem, tipoDocumento, numeroDocumento);
	}
	
	@PostMapping("/aprobar-solicitud-acceso/{idItem}/tipo-documento/{tipoDocumento}/numero-documento/{numeroDocumento}/id-solicitud/{idSolicitud}/usuario/{usuario}")
//	@PreAuthorize("hasPermission('PRO_PERSONA_REGISTRO','505')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public PersonaRegistroResponse aprobarSolicitudAcceso(@PathVariable("idItem") String idItem
			  ,@PathVariable("tipoDocumento") String tipoDocumento
			  ,@PathVariable("numeroDocumento") String numeroDocumento
			  ,@PathVariable("idSolicitud") Integer idSolicitud,
			   @PathVariable("usuario") String usuario) throws Exception {
		return personaRegistroService.aprobarSolicitudAcceso(idItem, tipoDocumento, numeroDocumento, idSolicitud,usuario);
	}
	
	@PostMapping("/rechazar-solicitud-acceso/{idItem}/tipo-documento/{tipoDocumento}/numero-documento/{numeroDocumento}/id-solicitud/{idSolicitud}/observacion/{observacion}")
//	@PreAuthorize("hasPermission('PRO_PERSONA_REGISTRO','506')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public PersonaRegistroResponse rechazarSolicitudAcceso(@PathVariable("idItem") String idItem
			  ,@PathVariable("tipoDocumento") String tipoDocumento
			  ,@PathVariable("numeroDocumento") String numeroDocumento
			  ,@PathVariable("idSolicitud") Integer idSolicitud
			  ,@PathVariable("observacion") String observacion) throws Exception {
		return personaRegistroService.rechazarSolicitudAcceso(idItem, tipoDocumento, numeroDocumento, idSolicitud,observacion);
	}
}
