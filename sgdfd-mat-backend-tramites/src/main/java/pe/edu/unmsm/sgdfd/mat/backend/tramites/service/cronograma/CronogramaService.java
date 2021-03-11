package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.cronograma;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.CronogramaRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.CronogramaResponse;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de cronograma,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see CronogramaVigenteRequest
 * @see CronogramaResponse
 */
public interface CronogramaService extends MantenibleService<CronogramaRequest, CronogramaResponse>{
	
	/**
	 * obtiene una lista de cronogramas por:
	 * @param idTipoTramite
	 * 			el identificador de tipo tramite		
	 */
	public List<CronogramaResponse> buscarPorIdTipoTramite(Integer idTipoTramite);
	
	/**
	 * obtiene una lista de cronogramas por:
	 * @param idTipoTramite
	 * 			el identificador de tipo tramite
	 * @param codigoLocal
	 * 			el código de local		
	 */
	public List<CronogramaResponse> buscarPorIdTipoTramiteYCodigoLocal(Integer codigoTipo, String codigoLocal);
}
