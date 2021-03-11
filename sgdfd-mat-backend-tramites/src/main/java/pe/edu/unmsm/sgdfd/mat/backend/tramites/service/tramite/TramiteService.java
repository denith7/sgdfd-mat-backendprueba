package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramite;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.TramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.TramiteResponse;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de trámite,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see TramiteRequest
 * @see TramiteResponse
 */
public interface TramiteService extends MantenibleService<TramiteRequest,TramiteResponse>
{
	
//    Tramite buscarPorId(Integer id);

	/**
	 * Obtiene una lista de trámite 	
	 */
    public List<TramiteResponse> buscarTodos();
    
    /**
	 * Registra un trámite 
	 * @param parametroTipoTramite
	 * 			el trámite a registrar	
	 */
    public TramiteRequest registrarTramite(TramiteRequest parametroTipoTramite);
    
}