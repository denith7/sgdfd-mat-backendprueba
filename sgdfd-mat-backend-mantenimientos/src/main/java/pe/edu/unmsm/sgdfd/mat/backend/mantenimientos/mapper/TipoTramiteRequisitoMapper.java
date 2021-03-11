package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.TipoTramiteRequisitoFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.id.TipoTramiteRequisitoId;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteRequisitoRequest;


@Mapper
public interface TipoTramiteRequisitoMapper extends MantenibleMapper<TipoTramiteRequisitoRequest, TipoTramiteRequisitoResponse> 
{
	
	public TipoTramiteRequisitoResponse buscarPorId(TipoTramiteRequisitoId id);
	
	public List<TipoTramiteRequisitoResponse> buscarPorTipoTramite(TipoTramiteRequisitoId id);
	
	public List<TipoTramiteRequisitoResponse> buscarPorCriterio(TipoTramiteRequisitoFilter criterioBusqueda);
	
	public List<TipoTramiteRequisitoResponse> buscarTodos();
}
