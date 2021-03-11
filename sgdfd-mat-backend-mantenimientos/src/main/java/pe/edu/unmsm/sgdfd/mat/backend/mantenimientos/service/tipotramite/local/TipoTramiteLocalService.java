package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.local;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.TipoTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.id.TipoTramiteLocalId;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteLocalRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de Locales 
 * en donde estarán disponibles cada tipo de tramite, ademas de incluir busquedas 
 * de listas por medio de diferentes atributos, los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see MantenibleService
 * @see TipoTramiteLocalRequest
 * @see TipoTramiteLocalResponse
 */
public interface TipoTramiteLocalService extends MantenibleService<TipoTramiteLocalRequest, TipoTramiteLocalResponse>
{
    
	/**
	 * Retorna una lista con todos los locales en donde están disponibles cada tipo de tramite 	
	 */
	public List<TipoTramiteLocalResponse> buscarTodos();
	
	/**
	 * Retorna un local en donde está disponible un tipo de trámite:
	 * @param idTipoTramiteLocal
	 * 			el identificador tanto de tipo de tramite como del local donde este se encuentra disponible
	 */
    public TipoTramiteLocalResponse buscarPorIdTipoTramiteYCodigoLocal(TipoTramiteLocalId idTipoTramiteLocal);
    
    /**
	 * Retorna una lista con todos los locales que tienen disponible un tipo de trámite, será buscada por:
	 * @param idTipoTramiteLocal
	 * 			el identificador tanto de tipo de tramite como del local donde este se encuentra disponible
	 */
    public List<TipoTramiteLocalResponse>  buscarPorIdTipoTramite(TipoTramiteLocalId idTipoTramiteLocal);

    /**
	 * Retorna una lista con un local y todos los tramites disponibles en él que coincidan con:
	 * @param idTipoTramiteLocal
	 * 			el identificador tanto de tipo de tramite como del local donde este se encuentra disponible
	 */
    public List<TipoTramiteLocalResponse>  buscarPorCodigoLocal(TipoTramiteLocalId idTipoTramiteLocal);
    
    /**
	 * Registra un local que tendra disponible un tipo de tramite 
	 * @param tipoTramiteLocalRequest
	 * 			el local a registrar que tendra disponible un tipo de tramite	
	 */
	public TipoTramiteLocalResponse registrarTipoTramiteLocal(TipoTramiteLocalRequest tipoTramiteLocalRequest) ;

	/**
	 * Actualiza un local que tiene disponible un tipo de tramite 
	 * @param idTipoTramiteLocal
	 * 			el identificador tanto de tipo de tramite como del local donde este se encuentra disponible
	 * @param tipoTramiteLocalRequest
	 * 			el local a actualizar que tiene disponible un tipo de tramite	
	 */
    public TipoTramiteLocalResponse actualizarTipoTramiteLocal(TipoTramiteLocalId idTipoTramiteLocal, TipoTramiteLocalRequest tipoTramiteLocalRequest);
    
    /**
	 * Actualiza el estado de un local que tenga disponible un tipo de trámite  
	 * @param idTipoTramiteLocal
	 * 			el identificador tanto de tipo de tramite como del local donde este se encuentra disponible
	 * @param tipoTramiteLocalRequest
	 * 			el local a actualizar que tiene disponible un tipo de tramite	
	 */
    public TipoTramiteLocalResponse actualizarEstadoTipoTramiteLocal(TipoTramiteLocalId idTipoTramiteLocal, TipoTramiteLocalRequest tipoTramiteLocalRequest);
    
    /**
	 * Elimina un local que tiene disponible un tipo de trámite 
	 * @param idTipoTramiteLocal
	 * 			el identificador tanto de tipo de tramite como del local donde este se encuentra disponible
	 */
    public void eliminarTipoTramiteLocal(TipoTramiteLocalId idTipoTramiteLocal);
    
    /**
	 * Retorna un local que tenga disponible un tipo de trámite 
	 * @param criterioBusqueda
	 * 			filtro de busqueda que incluye codigo de local, url e indicador de Tupa
	 */
	public TipoTramiteLocalResponse buscarPorUrlYLocal(TipoTramiteFilter criterioBusqueda);
	
	/**
	 * Retorna un local que tenga disponible un tipo de tramite
	 * @param nombreUrl
	 * 			el url del tipo de trámite
	 * @param codigoLocal
	 * 			el código del local
	 * @param codigoEscuela
	 * 			el código de la escuela	
	 */
	public TipoTramiteLocalResponse buscarPorUrlYLocalYEscuela(String nombreUrl, String codigoLocal, String codigoEscuela);
    
}