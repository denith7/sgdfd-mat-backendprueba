package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.GrupoLocalFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.GrupoLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.GrupoLocalRequest;


@Mapper
public interface GrupoLocalMapper extends MantenibleMapper<GrupoLocalRequest, GrupoLocalResponse> 
{

	public GrupoLocalResponse buscarPorIdGrupoLocal(@Param("idGrupoLocal") Integer idGrupoLocal);
	
	public List<GrupoLocalResponse> buscarPorCriterio(GrupoLocalFilter criterioBusqueda);
	
	public List<GrupoLocalResponse> buscarTodos();
}
