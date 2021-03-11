package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.remito;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.RemitoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.RemitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.RemitoTramitResponse;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de remito,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see RemitoRequest
 * @see RemitoResponse
 */
public interface RemitoService extends MantenibleService<RemitoRequest,RemitoResponse>{
	
	/**
	 * Obtiene una lista de remito
	 */
	public List<RemitoResponse> buscarTodos();
	
	/**
	 * Registra un remito
	 * @param remitoRequest
	 * 			el remito a registrar	
	 */
	public RemitoRequest registrarRemito(RemitoRequest remitoRequest);
	
	public RemitoTramitResponse buscarTramitePorEmpleadoYTipo(String numeroDni, Integer idTipoTramite);
}
