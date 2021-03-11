package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipodocumento;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoDocumentoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoDocumentoRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de Tipos de Documentos,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see MantenibleService
 * @see TipoDocumentoRequest
 * @see TipoDocumentoResponse
 */
public interface TipoDocumentoService extends MantenibleService<TipoDocumentoRequest, TipoDocumentoResponse>{
	
	/**
	 * Retorna una lista con todos los tipos de documentos 	
	 */
	public List<TipoDocumentoResponse> buscarTodos();
	
	/**
     * Retorna un Tipo de documento buscado por:
     * @param tipoDocumento
     * 			tipo de Documento a buscar
     */   
    public TipoDocumentoResponse buscarPorId(String idTipoDocumento);
	
	/**
	 * Registra un tipo de documento 
	 * @param tipoDocumentoRequest
	 * 			el tipo de documento a registrar	
	 */
	public void eliminarTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest);
	
	/**
	 * Actualiza un tipo de documento 
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param tipoDocumentoRequest
	 * 			el tipo de documento a actualizar	
	 */
	public TipoDocumentoResponse registrarTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest);
	
	/**
	 * Elimina un tipo de documento 
	 * @param tipoDocumentoRequest
	 * 		tipo de documento a eliminar
	 */
	public TipoDocumentoResponse actualizarTipoDocumento(String idTipoDocumento, TipoDocumentoRequest tipoDocumentoRequest);
	
	
	/**
	 * Retorna una lista de Tipo documentos buscados por identificador de tipo trámite 
	 * @param idTipoTramite
	 * 		identificador de tipo trámite 
	 */
	public List<TipoDocumentoResponse> buscarPorIdTipoTramite(Integer idTipoTramite);
	
	
}
