package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.localrequisito;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.id.TipoTramiteLocalRequisitoId;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteLocalRequisitoRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de los Requisitos propios de cada Local 
 * en cada Tipo de Tramite, ademas de incluir busquedas que retornen listas de acuerdo a diferentes atributos
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see TipoTramiteLocalRequisitoRequest
 * @see TipoTramiteLocalRequisitoResponse
 */
public interface TipoTramiteLocalRequisitoService extends MantenibleService<TipoTramiteLocalRequisitoRequest, TipoTramiteLocalRequisitoResponse>{
	
	/**
	 * Retorna una lista con todos los Requisitos propios de cada local para cada tipo de trámite. 	
	 */
	public List<TipoTramiteLocalRequisitoResponse> buscarTodos();
	
	/**
	 * Retorna una lista de Requisitos propios de cada local para un tipo de tramite, será buscada por:  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite	
	 */
	public List<TipoTramiteLocalRequisitoResponse> buscarPorIdTipoTramite(Integer idTipoTramite);
	
	/**
	 * Retorna una lista de Requisitos propios de cada local para cada tipo de tramite y que se identifiquen con el atributo:  
	 * @param idRequisito
	 * 			el identificador de requisito 
	 */
	public List<TipoTramiteLocalRequisitoResponse> buscarPorIdRequisito(Integer idRequisito);

	/**
	 * Retorna un requisito perteneciente a un local y a un tipo de trámite, será buscado por atributo:  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idLocal
	 * 			el identificador del local
	 * @param idRequisito
	 * 			el identificador del requisito	
	 */
	public TipoTramiteLocalRequisitoResponse buscarPorIdTipoTramiteYCodigoLocalYIdRequisito(Integer idTipoTramite, String codigoLocal,Integer idRequisito);
	
	/**
	 * Registra un Requisito propio de un local y para un tipo de tramite.  
	 * @param tipoTramiteLocalRequisitoRequest
	 * 			el requisito a registrar propio de un local y para un tipo de tramite
	 */
	public TipoTramiteLocalRequisitoResponse registrarTipoTramiteLocalRequisito(TipoTramiteLocalRequisitoRequest tipoTramiteLocalRequisitoRequest);
	
	/**
	 * Actualiza un Requisito propio de un local y para un tipo de tramite.  
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idLocal
	 * 			el identificador de local
	 * @param idRequisito
	 * 			el identificador del requisito 
	 * @param tipoTramiteLocalRequisitoRequest
	 * 			el requisito a actualizar propio de un local y para un tipo de tramite
	 */
	public TipoTramiteLocalRequisitoResponse actualizarTipoTramiteLocalRequisito(TipoTramiteLocalRequisitoId idTipoTramiteLocalRequisito,
																TipoTramiteLocalRequisitoRequest tipoTramiteLocalRequisitoRequest);
	
	/**
	 * Elimina un Requisito propio de un local y para un tipo de tramite.  
	 * @param tipoTramiteLocalRequisitoRequest
	 * 			el requisito a eliminar propio de un local y para un tipo de tramite
	 */
	public void eliminarTipoTramiteLocalRequisito(TipoTramiteLocalRequisitoRequest tipoTramiteLocalRequisitoRequest);
	
}
 