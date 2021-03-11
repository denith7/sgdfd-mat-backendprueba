package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PersonaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PersonaRequest;

@Mapper
public interface PersonaMapper extends MantenibleMapper<PersonaRequest, PersonaResponse> {
	
	public PersonaResponse buscarPorCodigoPersona(String codigoPersona);
	
	public List<PersonaResponse> buscarPorNumeroDocumento(String numeroDocumento);
	
	public List<PersonaResponse> filtrarPersonas(PersonaRequest personaRequest);
	
}
