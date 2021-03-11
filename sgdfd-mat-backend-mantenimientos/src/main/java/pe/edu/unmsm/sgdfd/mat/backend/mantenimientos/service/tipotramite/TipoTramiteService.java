package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.TipoTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RemitoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteFiltroRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteRequest;


/**
 * Define los métodos asociados a las operaciones de mantenimiento de Tipos de Tramite,
 * ademas de incluir busquedas de listas por medio de diferentes atributos 
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see MantenibleService
 * @see TipoTramiteRequest
 * @see TipoTramiteResponse
 */
public interface TipoTramiteService extends MantenibleService<TipoTramiteRequest, TipoTramiteResponse> {
	
	/**
	 * Retorna una lista de todos los tipos de trámites	
	 */
	public List<TipoTramiteResponse> buscarTodos();
	
	/**
	 * Retorna un tipo de trámite por:
	 *@param id
	 *			el identificador del tipo de tramite
	 */
	public TipoTramiteResponse buscarPorIdTipoTramite(Integer id);
	
	/**
	 * Registra un tipo de trámite por:
	 * @param tipoTramiteRequest
	 * 			el tipo de trámite a registrar		
	 */
	public TipoTramiteResponse registrarTipoTramite(TipoTramiteRequest tipoTramiteRequest);
	
	/**
	 * Actualiza un tipo de trámite por:
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param tipoTramiteRequest
	 * 			el tipo de tramite a actualizar	
	 */
	public TipoTramiteResponse actualizarTipoTramite(int idTipoTramite, TipoTramiteRequest tipoTramiteRequest);
	
	/**
	 * Elimina un tipo de trámite por:
	 * @param idTipoTramite
	 * 			identificador del tipo de trámite	
	 */
	public void eliminarTipoTramite(int idTipoTramite);
	
	/**
	 * Retorna una lista de tipos de trámite por:
	 * @param criterioBusqueda
	 * 			el filtro de busqueda que incluye el codigo de local, indicador de Tupa y url
	 */
	public List<TipoTramiteResponse> buscarPorCriterio(TipoTramiteFilter criterioBusqueda);
	
	
	/**
	 * Retorna una lista de tipos de trámite por:
	 * @param tipoTramiteFiltroRequest
	 * 			filtro de busqueda que incluye codigo de categoria, identificador de grupo de locales, indicador Tupa y codigo de local
	 */
	public List<TipoTramiteLocalResponse> buscarFiltroTramite(TipoTramiteFiltroRequest tipoTramiteFiltroRequest);
	
	
	
	
	public TipoTramiteLocalResponse buscarPorUrlYLocal(TipoTramiteFilter criterioBusqueda);
	
	public RemitoTramiteResponse buscarPorTramiteYLocal(Integer idTipoTramite, String codigoLocal);
	
	public RemitoTramiteResponse buscarTramitePorEmpleadoYTipo(String numeroDni, Integer idTipoTramite);
	
	public TipoTramiteLocalResponse buscarPorUrlYLocalYEscuela(String nombreUrl, String codigoLocal, String codigoEscuela);
}
