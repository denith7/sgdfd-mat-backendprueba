package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.destinatario;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteDestinatarioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteDestinatarioRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de Destinos a donde es posible
 * derivar cada Tipo Trámite, ademas de busquedas que retornen listas de requisitos de acuerdo 
 * a diferentes atributos,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see TipoTramiteDestinatarioRequest
 * @see TipoTramiteDestinatarioResponse
 */
public interface TipoTramiteDestinatarioService extends MantenibleService<TipoTramiteDestinatarioRequest, TipoTramiteDestinatarioResponse>{
	
	/**
	 * Retorna una lista con todos los Destinos a donde es posible derivar cada Tipo de Trámite 	
	 */
	public List<TipoTramiteDestinatarioResponse> buscarTodos();
	
	/**
	 * Retorna una lista con todos los destinos a donde es posible derivar un Tipo de Tramite, esta será buscada por:
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite	
	 */
	public List<TipoTramiteDestinatarioResponse> buscarPorIdTipoTramite( Integer idTipoTramite);
	
	/**
	 * Retorna una lista tipo trámite destinatario por:
	 * @param idLocal
	 * 			el identificador de local
	 */
	public List<TipoTramiteDestinatarioResponse> buscarPorIdLocal(String idLocal);
	
	/**
	 * Retorna un Destino a donde es posible derivar un tipo de trámite, será buscado por:
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idLocal
	 * 			el identificador del local
	 * @param idItem
	 * 			el identificador de item	
	 */
	public TipoTramiteDestinatarioResponse buscarPorIdTipoTramiteYIdLocalYIdItem(Integer idTipoTramite, String idLocal, Integer idItem);
	
	/**
	 * Registra un Destino a donde será posible derivar un tipo de trámite 
	 * @param tipoTramiteDestinatarioRequest
	 * 			el destino a registrar a donde será posible derivar un tipo de tramite	
	 */
	public TipoTramiteDestinatarioResponse registrarTipoTramiteDestinatario(TipoTramiteDestinatarioRequest tipoTramiteDestinatarioRequest);
	
	/**
	 * Actualiza un destino a donde se puede derivar un tipo de tramite 
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idLocal
	 * 			el identificador del local
	 * @param idItem
	 * 			el identificador de item
	 * @param tipoTramiteDestinatarioRequest
	 * 			el destino a actualizar donde se puede derivar un tipo de trámite	
	 */
	public TipoTramiteDestinatarioResponse actualizarTipoTramiteDestinatario(Integer idTipoTramite, String idLocal
						, Integer idItem, TipoTramiteDestinatarioRequest tipoTramiteDestinatarioRequest);
	
	/**
	 * Elimina un destino a donde se puede derivar un tipo de tramite 
	 * @param tipoTramiteDestinatarioRequest
	 * 			el destino a eliminar a donde se puede derivar un tipo de trámite	
	 */
	public void eliminarTipoTramiteDestinatario(TipoTramiteDestinatarioRequest tipoTramiteDestinatarioRequest);

}
