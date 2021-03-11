package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.dependencia;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.DependenciaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.DependenciaRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de dependencias,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see MantenibleService
 * @see DependenciaRequest
 * @see DependenciaResponse
 */
public interface DependenciaService extends MantenibleService<DependenciaRequest, DependenciaResponse>{
	
	/**
	 * Retorna una lista de dependencias 	
	 */
	public List<DependenciaResponse> buscarTodos();
	
	/**
	 * Retorna una dependencia por:
	 * @param codigoDependencia
	 * 			codigo de la dependencia a buscar		
	 */
	public DependenciaResponse buscarPorCodigoDependencia( String codigoDependencia);
	
	/**
	 * Retorna una lista de dependencias por:
	 * @param codigoLocal
	 * 			codigo del local a donde pertenecen las dependencias	
	 */
	public List<DependenciaResponse> buscarPorCodigoLocalSgd( String codigoLocal);
	
	/**
	 * Registra una dependencia 
	 * @param dependenciaRequest
	 * 			la dependencia a registrar	
	 */
	public DependenciaResponse registrarDependencia(DependenciaRequest dependenciaRequest);
	
	/**
	 * Actualiza una dependencia 
	 * @param codigoDependencia
	 * 			codigo identificador de la dependencia a actualizar	
	 * @param dependenciaRequest
	 * 			la dependencia a actualizar	
	 */
    public DependenciaResponse actualizarDependencia(String codigoDependencia, DependenciaRequest dependenciaRequest);
    
    /**
	 * Elimina una dependencia 
	 * @param dependenciaRequest
	 * 			dependencia a eliminar		
	 */
    public void eliminarDependencia(DependenciaRequest dependenciaRequest);
}
