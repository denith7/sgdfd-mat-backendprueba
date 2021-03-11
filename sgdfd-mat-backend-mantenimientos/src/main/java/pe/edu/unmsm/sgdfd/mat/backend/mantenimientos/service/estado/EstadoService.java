package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.estado;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EstadoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.EstadoRequest;


/**
 * Define los métodos asociados a las operaciones de mantenimiento de Estado,
 * y busquedas por diferentes atributos que retornaran o una lista o un Estado
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see MantenibleService
 * @see EstadoRequest
 * @see EstadoResponse
 */
public interface EstadoService extends MantenibleService<EstadoRequest, EstadoResponse>
{
	
	/**
	 * Retorna una lista con todos los estados 	
	 */
	public List<EstadoResponse> buscarTodos();
	
	/**
	 * Obtiene una lista de estados por:
	 * @param tablaOrigen
	 * 			la tabla origen del estado a buscar 	
	 */
	public List<EstadoResponse> buscarPorTablaOrigen(String tablaOrigen);
	
	/**
	 * obtiene un estado por:
	 * @param tablaOrigen
	 * 			la tabla origen de estado
	 * @param codigoEstado
	 * 			el código de estado	
	 */
	public EstadoResponse buscarPorTablaOrigenYCodigoEstado(String tablaOrigen, String codigoEstado);
	
	/**
	 * Registra un estado 
	 * @param estadoRequest
	 * 			el estado a registrar	
	 */
	public EstadoResponse registrarEstado(EstadoRequest estadoRequest);
    
	/**
	 * Actualiza un estado 
	 * @param tablaOrigen
	 * 			la tabla origen de estado
	 * @param codigoEstado
	 * 			el código de estado	
	 * @param estadoRequest
	 * 			el estado a actualizar	
	 */
	public EstadoResponse actualizarEstado(String tablaOrigen, String codigoEstado, EstadoRequest estadoRequest);
	
	/**
	 * Elimina un estado 
	 * @param estadoRequest
	 * 		estado a eliminar
	 */
    public void eliminarEstado( EstadoRequest estadoRequest);
    
    
}