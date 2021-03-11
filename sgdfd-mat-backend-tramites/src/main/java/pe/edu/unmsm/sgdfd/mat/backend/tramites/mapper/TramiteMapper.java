package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.TramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.TramiteResponse;


@Mapper
public interface TramiteMapper extends MantenibleMapper<TramiteRequest,TramiteResponse>
{

	public List<TramiteResponse> buscarTodos();
	
}
