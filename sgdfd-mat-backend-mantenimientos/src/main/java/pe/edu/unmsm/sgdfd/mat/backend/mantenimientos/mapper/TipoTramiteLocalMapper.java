package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.TipoTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.TipoTramiteLocalFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.id.TipoTramiteLocalId;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteLocalRequest;


@Mapper
public interface TipoTramiteLocalMapper extends MantenibleMapper<TipoTramiteLocalRequest, TipoTramiteLocalResponse> 
{
	
	public TipoTramiteLocalResponse buscarPorIdTipoTramiteYCodigoLocal(TipoTramiteLocalId id);
	
	public List<TipoTramiteLocalResponse> buscarPorCriterio(TipoTramiteLocalFilter criterioBusqueda);
	
	public List<TipoTramiteLocalResponse> buscarTodos();
	
	  public List<TipoTramiteLocalResponse>  buscarPorIdTipoTramite(TipoTramiteLocalId id);
	
	public List<TipoTramiteLocalResponse>  buscarPorCodigoLocal(TipoTramiteLocalId id);
	
	public TipoTramiteLocalResponse mantener(String modo, TipoTramiteLocalRequest objetoMantenido, String usuario);

	public TipoTramiteLocalResponse buscarPorUrlYLocal(TipoTramiteFilter criterioBusqueda);
	
	public TipoTramiteLocalResponse buscarPorUrlYLocalYEscuela(@Param("nombreUrl") String nombreUrl, @Param("codigoLocal") String codigoLocal, @Param("codigoEscuela") String codigoEscuela);
	
}
