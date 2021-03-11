package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.perfillocaltipotramite;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PerfilLocalTipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PerfilLocalTipoTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoDocumentoRequest;

/**
* Define los métodos asociados a las operaciones de mantenimiento de PerfilLocalTipoTramite,
* los cuales deberán ser implementados.
* <p>
* Esta interface extiende de {@link MantenibleService} para poder heredar 
* los métodos comunes de mantenimiento.
* 
* @author Eric Robladillo
* @see MantenibleService
* @see PerfilLocalTipoTramiteRequest
* @see PerfilLocalTipoTramiteResponse
*/

public interface PerfilLocalTipoTramiteService extends MantenibleService<PerfilLocalTipoTramiteRequest,PerfilLocalTipoTramiteResponse>{

	/**
	 * Retorna una lista con todos los perfiles locales de tipo de tramite
	 */
	public List<PerfilLocalTipoTramiteResponse> buscarTodos();
	
	/**
	 * Retorna un perfilLocalTipoTramite buscado por:
	 * 
	 * @param idPerfil
	 * 			el identificador del perfil
	 * @param codigoLocal
	 * 			el código del local
	 * @param idTipoTramite
	 * 			el identificador del tipo de tramite
	 * 
	 * @param idPerfil
	 * @param codigoLocal
	 * @param idTipoTramite
	 * @return
	 */
	public PerfilLocalTipoTramiteResponse buscarPorId(Integer idPerfil, String codigoLocal, Integer idTipoTramite);
	
	/**
	 * Actualiza un tipo de documento 
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param tipoDocumentoRequest
	 * 			el tipo de documento a actualizar	
	 */
	public PerfilLocalTipoTramiteResponse registrarPerfilLocalTipoTramite(PerfilLocalTipoTramiteRequest perfilLocalTipoTramiteRequest);
	
	/**
	 * Registra un perfilLocalTipoTramite
	 * @param perfilLocalTipoTramiteRequest
	 * 			el perfilLocalTipoTramite a registrar	
	 */
	public void eliminarPerfilLocalTipoTramite(PerfilLocalTipoTramiteRequest perfilLocalTipoTramiteRequest);
	
	
	/**
	 * Elimina un perfilLocalTipoTramite
	 * @param perfilLocalTipoTramiteRequest
	 * 		 perfilLocalTipoTramite a eliminar
	 */
//	public PerfilLocalTipoTramiteResponse actualizarTipoDocumento(Integer idPerfil, String codigoLocal, Integer idTipoTramite, PerfilLocalTipoTramiteRequest perfilLocalTipoTramiteRequest);
}
