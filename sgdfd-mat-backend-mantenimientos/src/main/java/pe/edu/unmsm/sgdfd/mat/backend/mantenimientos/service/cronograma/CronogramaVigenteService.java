package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.cronograma;

import java.util.List;


import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.CronogramaVigenteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.CronogramaVigenteRequest;


/**
 * Define los métodos asociados a las operaciones de mantenimiento de cronogramas vigentes,
 * asi como de las busquedas por diferentes atributos que devolverán listas de cronogramas vigentes 
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see MantenibleService
 * @see CronogramaVigenteRequest
 * @see CronogramaVigenteResponse
 */
public interface CronogramaVigenteService extends MantenibleService<CronogramaVigenteRequest, CronogramaVigenteResponse>{
	
	/**
	 * Retorna una lista de cronogramas vigentes 	
	 */
	public List<CronogramaVigenteResponse> buscarTodos();
	
	/**
	 * Retorna una lista de cronogramas vigentes por:
	 * @param idTipoTramite
	 * 			el identificador de tipo de tramite		
	 */
	public List<CronogramaVigenteResponse> buscarPorIdTipoTramite(Integer idTipoTramite);
	
	/**
	 * Retorna una lista de cronogramas vigentes por:
	 * @param idTipoTramite
	 * 			el identificador de tipo de tramite
	 * @param codigoLocal
	 * 			el código del local		
	 */
	public List<CronogramaVigenteResponse> buscarPorIdTipoTramiteYCodigoLocal(Integer idTipoTramite, String codigoLocal);
	
	/**
	 * Retorna un cronograma vigente por:
	 * @param idTipoTramite
	 * 			el identificador de tipo de tramite
	 * @param idItem
	 * 			el identificador de item
	 * @param codigoLocal
	 * 			el código del local		
	 */
	public CronogramaVigenteResponse buscarPorIdTipoTramiteYIdItemYCodigoLocal(Integer idTipoTramite, Integer idItem, String codigoLocal);
	
	/**
	 * Registra un cronograma vigente 
	 * @param cronogramaVigenteRequest
	 * 			el cronograma vigente a registrar	
	 */
	public CronogramaVigenteResponse registrarCronogramaVigente(CronogramaVigenteRequest cronogramaVigenteRequest);
	
	/**
	 * Actualiza un cronograma vigente 
	 * @param idTipoTramite
	 * 			el identificador de tipo de tramite
	 * @param idItem
	 * 			el identificador de item
	 * @param codigoLocal
	 * 			el código de local
	 * @param cronogramaVigenteRequest
	 * 			el cronograma vigente a actualizar	
	 */
	public CronogramaVigenteResponse actualizarCronogramaVigente(Integer idTipoTramite,  Integer idItem, String idLocal, CronogramaVigenteRequest cronogramaVigenteRequest);

	/**
	 * Elimina un cronograma vigente  
	 * @param cronogramaVigenteRequest
	 * 			cronograma vigente a eliminar		
	 */
	public void eliminarCronogramaVigente(CronogramaVigenteRequest cronogramaVigenteRequest);

}
