package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.local;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.LocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.LocalRequest;


/**
 * Define los métodos asociados a las operaciones de mantenimiento de locales,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see LocalRequest
 * @see LocalResponse
 */
public interface LocalService extends MantenibleService<LocalRequest, LocalResponse>
{
	/**
	 * Registra un local 
	 * @param parametroLocal
	 * 			el local a registrar	
	 */
	public LocalResponse registrarLocal(LocalRequest parametroLocal);
	
	/**
	 * Actualiza un local 
	 * @param codigoLocal
	 * 			codigo identificador del local a actualizar	
	 * @param parametroLocal
	 * 			el local a actualizar	
	 */
    public LocalResponse actualizarLocal(String codigoLocal, LocalRequest parametroLocal);

    /**
     * Elimina un local
     * @param parametroLocal
     * 			el local a eliminar
     */  
    public void eliminarLocal(LocalRequest parametroLocal);
    
    /**
     * Retorna un Local buscado por:
     * @param codigoLocal 
     * 			codigo del local a buscar
     */   
    public LocalResponse buscarPorId(String codigoLocal);
    
    /**
     * Retorna una lista con todos los locales
     */
    public List<LocalResponse> buscarTodos();
    
    /**
     * Retorna una lista con todos los locales asociados a un usuario (numeroDocumento)
     */
    public List<LocalResponse> buscarPorDocumento(String numeroDocumento);
    
    /**
     * Retorna una lista con todos los locales que pertenecen a un grupoLocal
     * @param idGrupoLocal
     * 			id del grupo a los que pertenecen los locales
     */
    public List<LocalResponse> buscarPorGrupoLocal(@Param("idGrupoLocal") Integer idGrupoLocal);
}