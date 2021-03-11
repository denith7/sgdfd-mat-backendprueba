package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.requisito;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.id.TipoTramiteRequisitoId;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteRequisitoRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de Requisitos pertenecientes a cada tipo de tramite,
 * ademas de incluir busquedas por diferentes atributos que retornaran o una lista o un Requisito de un Tipo de Tramite,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see TipoTramiteRequisitoRequest
 * @see TipoTramiteRequisitoResponse
 */
public interface TipoTramiteRequisitoService extends MantenibleService<TipoTramiteRequisitoRequest, TipoTramiteRequisitoResponse> {

	/**
	 * Retorna una lista con todos los requisitos pertenecientes a cada tipo de trámite.  
	 */
	public List<TipoTramiteRequisitoResponse> buscarTodos();
	
	/**
	 * Retorna un requisito perteneciente a un tipo de tramite, será buscado por:
	 * @param idTipoTramiteRequisito
	 * 			el identificador tanto de Requisito como de Tipo de Tramite
	 */
	public TipoTramiteRequisitoResponse buscarPorId(TipoTramiteRequisitoId idTipoTramiteRequisito);

	/**
	 * Retorna una lista con todos los requisitos pertenecientes a un tipo de tramite, será buscada por:
	 * @param idTipoTramiteRequisito
	 * 			el identificador tanto de Requisito como de Tipo de Tramite
	 */
	public List<TipoTramiteRequisitoResponse> buscarPorTipoTramite(TipoTramiteRequisitoId idTipoTramiteRequisito);
	
	/**
	 * Registra un requisito que pertenecerá a un tipo de tramite
	 * @param tipoTramiteRequisitoRequest
	 * 			el requisito a registrar perteneciente a un tipo de tramite	
	 */
	public TipoTramiteRequisitoResponse registrarTipoTramiteRequisito(TipoTramiteRequisitoRequest tipoTramiteRequisitoRequest);
	
	/**
	 * Actualiza un requisito que pertenece a un tipo de tramite 
	 * @param idTipoTramiteRequisito
	 * 			el identificador tanto de Requisito como de Tipo de Tramite
	 * @param tipoTramiteRequisitoRequest
	 * 			el requisito a actualizar perteneciente a un tipo de tramite	
	 */
	public TipoTramiteRequisitoResponse actualizarTipoTramiteRequisito(TipoTramiteRequisitoId idTipoTramiteRequisito,
			TipoTramiteRequisitoRequest tipoTramiteRequisitoRequest);
	
	/**
	 * Elimina un requisito que pertenece a un tipo de tramite 
	 * @param tipoTramiteRequisitoRequest
	 * 			el requisito a eliminar perteneciente a un tipo de tramite	
	 */
	public void eliminarTipoTramiteRequisito(TipoTramiteRequisitoRequest tipoTramiteRequisitoRequest);

}