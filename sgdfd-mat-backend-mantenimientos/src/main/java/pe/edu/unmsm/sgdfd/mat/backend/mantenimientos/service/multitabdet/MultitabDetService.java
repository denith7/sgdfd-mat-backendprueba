package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.multitabdet;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.MultitabDetResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.MultitabDetRequest;

import java.util.List;

/**
 * Define los métodos asociados a las operaciones de mantenimiento del Detalle de las Multitablas,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see MantenibleService
 * @see MultitabDetRequest
 * @see MultitabDetResponse
 */
public interface MultitabDetService extends MantenibleService<MultitabDetRequest, MultitabDetResponse> {
	
	/**
	 * Retorna una lista con el detalle de cada multitabla 	
	 */
	public List<MultitabDetResponse> buscarTodos();
	
	/**
	 * Retorna una lista con el detalle de cada multitabla, esta será buscada por:
	 * @param idMultitabCab
	 * 			el identificador de la cabecera de la multitabla	
	 */
	public List<MultitabDetResponse> buscarPorIdMultitabCab(int idMultitabCab);
	
	/**
	 * Retorna el detalle de una multitabla por:
	 * @param idMultitabCab
	 * 			el identificador de la cabecera de la multitabla
	 * @param idMultitabDet
	 * 			el identificador del detalle de la multitabla		
	 */
	public MultitabDetResponse buscarPorIdMultitabCabYIdMultitabDet(Integer idMultitabCab, String idMultitabDet);
	
	/**
	 * Registra el detalle de una multitabla 
	 * @param multitabDetRequest
	 * 			el detalle a registrar para una multitabla	
	 */
	public MultitabDetResponse registrarMultitabDet(MultitabDetRequest multitabDetRequest);
	
	/**
	 * Actualiza el detalle de una multitabla 
	 * @param idMultitabCab
	 * 			el identificador de la cabecera de la multitabla
	 * @param idMultitabDet
	 * 			el identificador del detalle de la multitabla
	 * @param multitabDetRequest
	 * 			el detalle a actualizar de la multitabla	
	 */
	public MultitabDetResponse actualizarMultitabDet(Integer idMultitabCab, String idMultitabDet, MultitabDetRequest multitabDetRequest);
	
	/**
	 * Elimina el detalle de una multitabla 
	 * @param multitabDetRequest
	 * 		detalle a eliminar de la multitabla
	 */
	public void eliminarMultitabDet(MultitabDetRequest multitabDetRequest);
	
}
