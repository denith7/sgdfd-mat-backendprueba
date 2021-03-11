package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.TipoTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RemitoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteFiltroRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteRequest;

@Mapper
public interface TipoTramiteMapper extends MantenibleMapper<TipoTramiteRequest, TipoTramiteResponse> {

	public TipoTramiteResponse buscarPorId(@Param("idTipoTramite") Integer idTipoTramite);

	public List<TipoTramiteResponse> buscarPorCriterio(TipoTramiteFilter criterioBusqueda);

	public List<TipoTramiteResponse> buscarTodos();
	
	public List<TipoTramiteResponse> buscarPorLocal(@Param("codigoLocal")String codigoLocal);
	
	public List<TipoTramiteLocalResponse> buscarFiltroTramite(TipoTramiteFiltroRequest tipoTramiteFiltroRequest);
	
	public TipoTramiteLocalResponse buscarPorUrlYLocal(TipoTramiteFilter criterioBusqueda);
	
	public TipoTramiteLocalResponse buscarPorUrlYLocalYEscuela(@Param("nombreUrl") String nombreUrl, @Param("codigoLocal") String codigoLocal, @Param("codigoEscuela") String codigoEscuela);
	
	public RemitoTramiteResponse buscarPorTramiteYLocal(@Param("idTipoTramite") Integer idTipoTramite, @Param("codigoLocal") String codigoLocal);
	
	public RemitoTramiteResponse buscarTramitePorEmpleadoYTipo(@Param("numeroDni") String numeroDni, @Param("idTipoTramite") Integer idTipoTramite);
	
	public void mantener(String modo, TipoTramiteRequest objetoMantenido ,String usuario);
}
