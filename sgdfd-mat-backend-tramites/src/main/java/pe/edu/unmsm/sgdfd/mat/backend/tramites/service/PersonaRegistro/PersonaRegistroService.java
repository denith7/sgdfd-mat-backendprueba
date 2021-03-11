package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.PersonaRegistro;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.PersonaRegistroFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.PersonaRegistroRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.ProcesoSolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.PersonaRegistroResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.PersonasRegistradasResponse;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de "persona registro",
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Ximena Politi
 * @see MantenibleService
 * @see PersonaRegistroRequest
 * @see PersonaRegistroResponse
 */
public interface PersonaRegistroService extends MantenibleService<PersonaRegistroRequest,PersonaRegistroResponse>
{

	/**
	 * Obtiene una lista de "persona registro" 	
	 */
	public List<PersonaRegistroResponse> buscarTodos();
	
	/**
	 * obtiene un "persona registro"  por:
	 * @param idItem
	 * 			identificador de item
	 * @param tipoDocumento
	 * 			tipo de documento
	 * @param numeroDocumento
	 * 			número de documento		
	 */
	public PersonaRegistroResponse buscarPorIdItemYTipoDocumentoYNumeroDocumento(String idItem, String tipoDocumento, String numeroDocumento);
	
	/**
	 * Retorna la confirmación de existencia usuario de "persona registro" buscado por atributo:  
	 * @param username
	 * 			usuario de "persona registro"
	 */
	public boolean existeUsuarioPersonaRegistro(String username);
	
	/**
	 * Registra un usuario en el SSA 
	 * @param idItem
	 * 			identificador de item
	 * @param tipoDocumento
	 * 			tipo de documento
	 * @param numeroDocumento
	 * 			número de documento	
	 */
	public void registrarPersonaRegistroEnSSA(String idItem, String tipoDocumento, String numeroDocumento);
	
	
	/**
	 * Registra un usuario
	 * @param idItem
	 * 			identificador de item
	 * @param tipoDocumento
	 * 			tipo de documento
	 * @param numeroDocumento
	 * 			número de documento	
	 */
	public PersonaRegistroResponse registrarPersonaRegistro(PersonaRegistroRequest personaRegistroRequest) throws Exception;
	
	
	
	/**
	 * Solicitud de cambio de estado, retorna una "persona registro" 
	 * @param idItem
	 * 			identificador de item
	 * @param tipoDocumento
	 * 			tipo de documento
	 * @param numeroDocumento
	 * 			número de documento		
	 */
	public PersonaRegistroResponse cambioEstadoPorIdItemYTipoDocumentoYNumeroDocumento(String idItem, String tipoDocumento, String numeroDocumento);

	/**
	 * Retorna una "persona registro"  por:
	 * 
	 * @param correoReferencia
	 * 			correo de la persona registro
	 */
	public PersonaRegistroResponse buscarPorCorreo(String correoReferencia);
	
	/**
	 * Retorna una lista de PersonasRegistradas
	 * 
	 * @param personaRegistroFilter
	 * 			filtro por correo y numero de documento
	 * 
	 */
	public List<PersonasRegistradasResponse> buscarPersonasPorCorreoYNumeroDocumento(PersonaRegistroFilter personaRegistroFilter);
	
	
	
	/**
	 * Solicitud de cambio de estado y creacion de un nuevo perfil, retorna una "persona registro"
	 * 
	 * @param idItem
	 * 			identificador de item
	 * @param tipoDocumento
	 * 			tipo de documento
	 * @param numeroDocumento
	 * 			número de documento		
	 */
	public PersonaRegistroResponse cambioEstadoYCreacionPerfil(String idItem, String tipoDocumento, String numeroDocumento) throws Exception;
	
	/**
	 * Retorna una PersonaRegistroResponse y crea usuario, cambia estado y manda un correo
	 * 
	 * @param idItem
	 * 			identificador de item
	 * @param tipoDocumento
	 * 			tipo de documento
	 * @param numeroDocumento
	 * 			número de documento	
	 * @param idSolicitud
	 * 			identificador de Solicitud
	 */
	public PersonaRegistroResponse aprobarSolicitudAcceso(String idItem, String tipoDocumento, String numeroDocumento, Integer idSolicitud, String usuario) throws Exception;

	/**
	 * Retorna una PersonaRegistroResponse y cambia estado y manda un correo
	 * 
	 * @param idItem
	 * 			identificador de item
	 * @param tipoDocumento
	 * 			tipo de documento
	 * @param numeroDocumento
	 * 			número de documento	
	 * @param idSolicitud
	 * 			identificador de Solicitud
	 */
	public PersonaRegistroResponse rechazarSolicitudAcceso(String idItem, String tipoDocumento, String numeroDocumento, Integer idSolicitud, String observacion) throws Exception;

}
