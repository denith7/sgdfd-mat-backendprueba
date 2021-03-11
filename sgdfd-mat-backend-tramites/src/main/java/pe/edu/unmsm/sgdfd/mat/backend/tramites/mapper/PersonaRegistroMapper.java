package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.PersonaRegistroFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.PersonaRegistroRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.PersonaRegistroResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.PersonasRegistradasResponse;

@Mapper
public interface PersonaRegistroMapper extends MantenibleMapper<PersonaRegistroRequest,PersonaRegistroResponse> 
{

	public List<PersonaRegistroResponse> buscarTodos();
	
	public PersonaRegistroResponse buscarPorIdItemYTipoDocumentoYNumeroDocumento(@Param("idItem") String idItem
													 ,@Param("tipoDocumento") String tipoDocumento
													 ,@Param("numeroDocumento") String numeroDocumento);
	
	public void mantener(String modo, PersonaRegistroRequest objetoMantenido ,String usuario);
	
	public PersonaRegistroResponse buscarPorCorreo(@Param("correoReferencia") String correoReferencia);
	
	public List<PersonasRegistradasResponse> buscarPersonasPorCorreoYNumeroDocumento(PersonaRegistroFilter personaRegistroFilter);
}