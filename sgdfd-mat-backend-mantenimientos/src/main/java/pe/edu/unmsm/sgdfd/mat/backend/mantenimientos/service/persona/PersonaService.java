package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.persona;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PersonaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PersonaRequest;


/**
 * Define los métodos asociados a las operaciones de mantenimiento de Personas,
 * y de busquedas que retornen o una lista o una Persona
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Ximena Politi
 * @see MantenibleService
 * @see PersonaRequest
 * @see PersonaResponse
 */
public interface PersonaService extends MantenibleService<PersonaRequest, PersonaResponse> {
	
	/**
	 * Retorna un persona por:
	 * @param codigoPersona
	 * 			el código de la persona a buscar		
	 */
	public PersonaResponse buscarPorCodigoPersona(String codigoPersona);
	
	/**
	 * Retorna una lista de personas
	 * @param numeroDocumento
	 * 			el DNI de la persona 	
	 */
	public List<PersonaResponse> buscarPorNumeroDocumento(String numeroDocumento);
	
	/**
	 * Retorna una lista de personas
	 * @param personaRequest
	 * 			body con múltiples atributos de la persona 	
	 */
	public List<PersonaResponse> filtrarPersonas(PersonaRequest personaRequest);
	
}
