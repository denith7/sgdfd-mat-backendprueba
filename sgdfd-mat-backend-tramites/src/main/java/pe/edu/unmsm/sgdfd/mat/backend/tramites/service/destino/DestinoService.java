package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.destino;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.DestinoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.DestinoResponse;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de destino,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see DestinoRequest
 * @see DestinoResponse
 */
public interface DestinoService extends MantenibleService<DestinoRequest,DestinoResponse>{

	
	/**
	 * Obtiene una lista de destinos	
	 */
	public List<DestinoResponse> buscarTodos();
	
	/**
	 * Registra un destino 
	 * @param destinoRequest
	 * 			el destino a registrar	
	 */
	public DestinoRequest registrarDestino(DestinoRequest destinoRequest);
}
