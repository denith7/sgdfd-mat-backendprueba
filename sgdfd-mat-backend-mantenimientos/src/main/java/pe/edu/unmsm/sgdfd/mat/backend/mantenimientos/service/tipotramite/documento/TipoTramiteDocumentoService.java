package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.documento;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteDocumentoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteDocumentoRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de TiposTramiteDocumento,
 *  ademas de busquedas que retornen listas de requisitos de acuerdo 
 * a diferentes atributos,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Eric Robladillo
 * @see MantenibleService
 * @see TipoTramiteDocumentoRequest
 * @see TipoTramiteDocumentoResponse
 */
public interface TipoTramiteDocumentoService extends MantenibleService<TipoTramiteDocumentoRequest, TipoTramiteDocumentoResponse>{

	/**
	 * Retorna una lista con todos los TiposTramiteDocumento 	
	 */
	public List<TipoTramiteDocumentoResponse> buscarTodos();
	
	/**
	 * Retorna un TipoTramiteDocumento , será buscado por:
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idTipoDocumento
	 * 			el identificador del tipo de documento
	 */
	public TipoTramiteDocumentoResponse buscarPorIdTipoTramiteYIdTipoDocumento(Integer idTipoTramite, String idTipoDocumento);
	
	/**
	 * Registra un TipoTramiteDocumento 
	 * @param tipoTramiteDocumentoRequest
	 * 			el TipoTramiteDocumento a registrar
	 */
	public TipoTramiteDocumentoResponse registrarTipoTramiteDocumento(TipoTramiteDocumentoRequest tipoTramiteDocumentoRequest);
	
	/**
	 * Actualiza un destino a donde se puede derivar un tipo de tramite 
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param idTipoDocumento
	 * 			el identificador del tipo de documento
	 * @param tipoTramiteDestinatarioRequest
	 * 			el destino a actualizar donde se puede derivar un tipo de trámite	
	 */
	public TipoTramiteDocumentoResponse actualizarTipoTramiteDocumento(Integer idTipoTramite, String idTipoDocumento
						, TipoTramiteDocumentoRequest tipoTramiteDocumentoRequest);
	
	/**
	 * Elimina un TipoTramiteDocumento
	 * @param tipoTramiteDocumentoRequest
	 * 			el TipoTramiteDocumento a eliminar 
	 */
	public void eliminarTipoTramiteDocumento(TipoTramiteDocumentoRequest tipoTramiteDocumentoRequest);

	
	
}
