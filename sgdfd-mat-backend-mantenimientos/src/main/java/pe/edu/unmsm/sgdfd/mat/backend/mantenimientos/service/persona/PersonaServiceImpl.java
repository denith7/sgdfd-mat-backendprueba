package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.PersonaMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PersonaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PersonaRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de Personas 
 * y de busquedas que retornen o una lista o una Persona
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link PersonaService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link PersonaMapper} solo para operaciones de mantenimiento. 
 *
 * @author Ximena Politi
 */
@Service
@Transactional
public class PersonaServiceImpl extends MantenibleAuditadoService<PersonaRequest, PersonaResponse> implements PersonaService{
	
	private PersonaMapper personaMapper;
	
	/**
     * Instancia la interface {@link PersonaMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public PersonaServiceImpl(@Qualifier("personaMapper") MantenibleMapper<PersonaRequest, PersonaResponse> mapper) {
		super(mapper);
		this.personaMapper = (PersonaMapper) mapper;
	}
	
	@Override
	public PersonaResponse buscarPorCodigoPersona(String codigoPersona) {
		return personaMapper.buscarPorCodigoPersona(codigoPersona);
	}

	@Override
	public List<PersonaResponse> buscarPorNumeroDocumento(String numeroDocumento) {
		return personaMapper.buscarPorNumeroDocumento(numeroDocumento);
	}

	@Override
	public List<PersonaResponse> filtrarPersonas(PersonaRequest personaRequest) {
		return personaMapper.filtrarPersonas(personaRequest);
	}
	
}
