package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.multitabcab;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.MultitabCabResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.MultitabCabRequest;

import java.util.List;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de cabeceras de multitablas,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see MantenibleService
 * @see MultitabCabRequest
 * @see MultitabCabResponse
 */
public interface MultitabCabService extends MantenibleService<MultitabCabRequest, MultitabCabResponse> {
	
	/**
	 * Retorna una lista de cabeceras de multitablas 	
	 */
	public List<MultitabCabResponse> buscarTodos();
	
	/**
	 * Retorna una cabecera de una multitabla por:
	 * @param idMultitabCab
	 * 			el identificador de la cabecera de una multitabla a buscar		
	 */
	public MultitabCabResponse buscarPorIdMultitabCab(Integer idMultitabCab);
	
	/**
	 * Registra una cabecera de una multitabla 
	 * @param multitabCabRequest
	 * 			la cabecera a registrar de una multitabla
	 */
	public MultitabCabResponse registrarMultitabCab(MultitabCabRequest multitabCabRequest);
	
	/**
	 * Actualiza una cabecera de una multitabla
	 * @param idMultitabCab
	 * 			el identificador de la cabecera a actualizar de una multitabla
	 * @param multitabCabRequest
	 * 			cabecera a actualizar de una multitabla	
	 */
	public MultitabCabResponse actualizarMultitabCab(Integer idMultitabCab, MultitabCabRequest multitabCabRequest);
	
	/**
	 * Elimina una cabecera de una multitabla 
	 * @param multitabCabRequest
	 * 		cabecera a eliminar de una multitabla
	 */
	void eliminarMultitabCab(MultitabCabRequest multitabCabRequest);
}
