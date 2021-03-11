package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.UsuarioFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.UsuarioRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.UsuarioResponse;


@Mapper
public interface UsuarioMapper extends MantenibleMapper<UsuarioRequest,UsuarioResponse>
{

	public List<UsuarioResponse> buscarPorCriterio(UsuarioFilter  criterio);
	
}
