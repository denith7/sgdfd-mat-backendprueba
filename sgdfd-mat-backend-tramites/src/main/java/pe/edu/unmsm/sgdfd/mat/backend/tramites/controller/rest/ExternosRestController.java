package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.IdCadena;
import pe.edu.unmsm.commons.validation.validation.IdNumerico;
import pe.edu.unmsm.commons.validation.validation.group.IRegistro;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.LocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.MultitabDetResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.UbigeoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.local.LocalService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.multitabdet.MultitabDetService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.requisito.RequisitoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.ubigeo.UbigeoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.PersonaRegistroFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.PersonaRegistroSolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.PersonasRegistradasResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.PersonaRegistro.PersonaRegistroService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramite.SolicitudTramiteService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.sw.VerifyRecaptcha;



/**
 * Permite obtener la informacion necesaria para rellenar los selects y obtener requisitos
 * para los registros de persona natural y juridica 
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Búsqueda de una lista de Tramites por medio del identificador de tipo de trámite y codigo de local
 * </ul>
 * 
 * @author Eric Robladillo
 * 
 */
@Validated
@RestController
@RequestMapping("/externos")
public class ExternosRestController {

	@Autowired
	private UbigeoService ubigeoService;
	
	@Autowired
	private  MultitabDetService multitabDetService;
	
	@Autowired
	private LocalService localService;
	
	@Autowired
	private RequisitoService requisitoService;
	
	@Autowired
	private PersonaRegistroService personaRegistroService;
	
	@Autowired
	private SolicitudTramiteService solicitudTramiteService;
	
	/**
	 * Retorna una lista de ubigeos que muestra todos los departamentos.  
	 * 
	 * @return	lista de ubigeos obtenida por búsqueda es de tipo:
	 * 			{@link UbigeoResponse}
	 */
	@GetMapping("/departamentos")
//	@PreAuthorize("hasPermission('CON_UBIGEO','102')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<UbigeoResponse> buscarTodosPorDepartamentos() {
		return ubigeoService.buscarTodosPorDepartamentos();
	}
	
	/**
	 * Retorna una lista de ubigeos que muestra todas las provincias por cada departamento
	 * @param codigoDepartamento
	 * 			el código de departamento			
	 * @param --
	 * @return	lista de ubigeos obtenida por búsqueda es de tipo:
	 * 			{@link UbigeoResponse}
	 */
	@GetMapping("/departamentos/{codigoDepartamento}/provincias")
//	@PreAuthorize("hasPermission('CON_UBIGEO','103')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<UbigeoResponse> obtenerProvincias(
				@PathVariable("codigoDepartamento") @Size(min = 1, max = 2) String codigoDepartamento) {
		return ubigeoService.obtenerProvincias(codigoDepartamento);
	}
	
	/**
	 * Retorna una lista de ubigeos que muestra todos los distritos por cada provincia
	 * @param codigoDepartamento
	 * 			el código de departamento		
	 * @param codigoProvincia
	 * 			el código de provincia	
	 * @param --
	 * @return	lista de ubigeos obtenida por búsqueda es de tipo:
	 * 			{@link UbigeoResponse}
	 */
	@GetMapping("/departamentos/{codigoDepartamento}/provincias/{codigoProvincia}/distritos")
//	@PreAuthorize("hasPermission('CON_UBIGEO','104')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<UbigeoResponse> obtenerDistritos(
					@PathVariable("codigoDepartamento") @Size(min = 1, max = 2) String codigoDepartamento
					,@PathVariable("codigoProvincia") @Size(min = 1, max = 2) String codigoProvincia) {
		return ubigeoService.obtenerDistritos(codigoDepartamento, codigoProvincia);
	}
	
	
	/**
	 * Retorna una lista con los valores para el select de sexo:	
	 * @param --
	 * @return	lista con el detalle de la multitabla obtenida por búsqueda es de tipo:
	 * 			{@link MultitabDetResponse}
	 */

	@GetMapping(value = "/multitabs-cabs/sexo/multitabs-dets")
//	@PreAuthorize("hasPermission('CON_MULTITAB_DET','102')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<MultitabDetResponse> buscarPorIdMultitabCabSexo() {
		return multitabDetService.buscarPorIdMultitabCab(15);
	}
	
	/**
	 * Retorna una lista con los valores para el select de tipo documento:	
	 * @param --
	 * @return	lista con el detalle de la multitabla obtenida por búsqueda es de tipo:
	 * 			{@link MultitabDetResponse}
	 */

	@GetMapping(value = "/multitabs-cabs/tipo-documento/multitabs-dets")
//	@PreAuthorize("hasPermission('CON_MULTITAB_DET','102')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<MultitabDetResponse> buscarPorIdMultitabCabTipoDocumento() {
		return multitabDetService.buscarPorIdMultitabCab(2);
	}
	
	
	/**
	 * Retorna una lista con los valores para el select de tipo usuarios externos:	
	 * @param --
	 * @return	lista con el detalle de la multitabla obtenida por búsqueda es de tipo:
	 * 			{@link MultitabDetResponse}
	 */

	@GetMapping(value = "/multitabs-cabs/tipo-usuarios-externos/multitabs-dets")
//	@PreAuthorize("hasPermission('CON_MULTITAB_DET','102')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<MultitabDetResponse> buscarPorIdMultitabCabTipoUsuariosExternos() {
		return multitabDetService.buscarPorIdMultitabCab(16);
	}
	
	
	/**
	 * Retorna una lista con todos los locales
	 * 
	 * @return lista de locales obtenidos por busqueda de tipo:
	 * 			{@link LocalResponse} 
	 */
	@GetMapping(value = "/locales")
//	@PreAuthorize("hasPermission('CON_LOCAL','101')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<LocalResponse> buscarTodos() {
		return localService.buscarTodos();
	}
	
	
	/**
	 * Retorna el requisito de terminos y condiciones buscado por atributo:  
	 * @param idRequisito
	 * 			el identificador del requisito
	 * @param --
	 * @return	requisito obtenido por búsqueda:
	 * 			{@link RequisitoResponse}
	 */
	@GetMapping("/terminos-condiciones")
//	@PreAuthorize("hasPermission('CON_REQUISITO','102')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
    public RequisitoResponse buscarTerminosCondiciones(){
		return requisitoService.buscarPorIdRequisito(201);
    }
	
	
	/**
	 * Retorna una lista de Personas Registradas para verificar si ya existe alguno con los valores de:
	 * @param correoInstitucional
	 * 			correo de las personas registradas
	 * @param numeroDocumento
	 * 			numero de documento de las personas registradas
	 * @param --
	 * @return  lista de "personasRegistradas" obtenida por:
	 * 				{@link PersonasRegistradas}
	 */
	@GetMapping("/buscar-persona-registrada/{correoInstitucional}/numeroDocumento/{numeroDocumento}")
//	@PreAuthorize("hasPermission('PRO_PERSONA_REGISTRO','105')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<PersonasRegistradasResponse> buscarPersonasPorCorreoYNumeroDocumento(@PathVariable("correoInstitucional") String correoInstitucional,@PathVariable("numeroDocumento") String numeroDocumento){
		return personaRegistroService.buscarPersonasPorCorreoYNumeroDocumento(PersonaRegistroFilter.builder().numeroDocumento(numeroDocumento).correoInstitucional(correoInstitucional).build());
	}
	
	
	/**
	 * Retorna una lista de requisitos para registro de persona natural:  
	 * @param --
	 * @return	lista de requisitos obtenida por búsqueda es de tipo:
	 * 			{@link RequisitoResponse}
	 */
    @GetMapping(value = "/requisitos-registro-natural")
//    @PreAuthorize("hasPermission('CON_REQUISITO','104')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
    public List<RequisitoResponse> buscarRequisitosPersonaNatural(){
		return requisitoService.buscarPorIdTipoTramiteYCodigoLocal("130","40");
    }
	
    
    /**
	 * Retorna una lista de requisitos para registro de persona juridica:  
	 * @param --
	 * @return	lista de requisitos obtenida por búsqueda es de tipo:
	 * 			{@link RequisitoResponse}
	 */
    @GetMapping(value = "/requisitos-registro-juridico")
//    @PreAuthorize("hasPermission('CON_REQUISITO','104')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
    public List<RequisitoResponse> buscarRequisitosPersonaJuridico(){
		return requisitoService.buscarPorIdTipoTramiteYCodigoLocal("131","40");
    }
    
    
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
//	@PreAuthorize("hasPermission('PRO_SOLICITUD_TRAMITE','503')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	@ResponseStatus(code = HttpStatus.CREATED)
	public PersonaRegistroSolicitudTramiteRequest registrarPersonaRegistro(
			@Validated({ IRegistro.class, Default.class }) @RequestBody PersonaRegistroSolicitudTramiteRequest personaRegistroSolicitudTramiteRequest) throws Exception{
        
		try {

			String gRecaptchaResponse = personaRegistroSolicitudTramiteRequest.getCaptcha();
			boolean verify = VerifyRecaptcha.verify("6Lc3nMEZAAAAAAaAW8QH8YJ1C2_ymbxZpcfc-mTA", gRecaptchaResponse);
			if (verify) {

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
}
