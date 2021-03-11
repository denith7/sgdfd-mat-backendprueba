package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.IdCadena;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PersonaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PersonaRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.persona.PersonaService;

/**
 * Recibe las solicitudes relacionadas a la busqueda de Personas
 * tanto de una especifica asi como tambien de una lista de estas
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Búsqueda de una persona por su código
 * 	<li>Búsqueda de una lista de personas por DNI
 * </ul>
 * 
 * @author Ximena Politi
 * @see PersonaResponse
 * @see PersonaService
 */
@Validated
@RestController
@RequestMapping("/persona")
public class PersonaRestController {
	
	@Autowired
	private PersonaService personaService;
	
	/**
	 * Retorna una persona buscada por atributo:  
	 * @param codigoPersona
	 * 			el código de la persona
	 * @param --
	 * @return	persona obtenida por búsqueda:
	 * 			{@link PersonaResponse}
	 */
//	@PreAuthorize("hasPermission('CON_PERSONAS','101')")
	@GetMapping("/codigo/{codigoPersona}")
	@PreAuthorize("hasPermission('CON_PERSONA','101')")
	public PersonaResponse buscarPorCodigoPersona(
				@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,8}", maxLength = 8 ) String codigoPersona) {
		return personaService.buscarPorCodigoPersona(codigoPersona);
	}
	
	/**
	 * Retorna una lista de personas buscada por atributo:  
	 * @param numeroDocumento
	 * 			el DNI de la persona		
	 * @param --
	 * @return	lista de personas obtenida por búsqueda es de tipo:
	 * 			{@link PersonaResponse}
	 */
//	@PreAuthorize("hasPermission('CON_PERSONAS','101')")
	@GetMapping("/documento/{numeroDocumento}")
	@PreAuthorize("hasPermission('CON_PERSONA','102')")
	public List<PersonaResponse> buscarPorNumeroDocumento(@PathVariable @Size(min = 1, max = 12) String numeroDocumento) {
		return personaService.buscarPorNumeroDocumento(numeroDocumento);
	}
	
	/**
	 * Retorna una lista de personas buscada por multiples atributos enviados en el body. 
	 * @param ...
	 * 			...		
	 * @param ...
	 * @return	lista de personas obtenida por búsqueda es de tipo:
	 * 			{@link PersonaResponse}
	 */
//	@PreAuthorize("hasPermission('CON_PERSONAS','301')")
	@PostMapping("/filtrar")
	@PreAuthorize("hasPermission('CON_PERSONA','103')")
	public List<PersonaResponse> filtrarPersonas(@RequestBody PersonaRequest personaRequest) {
		return personaService.filtrarPersonas(personaRequest);
	}
	
}
