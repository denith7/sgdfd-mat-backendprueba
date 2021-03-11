package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.perfillocal;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PerfilLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PerfilLocalRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de PerfilLocal,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Ximena Politi
 * @see MantenibleService
 * @see PerfilLocalRequest
 * @see PerfilLocalResponse
 */
public interface PerfilLocalService extends MantenibleService<PerfilLocalRequest,PerfilLocalResponse>{

	/**
	 * Retorna una lista con todos los perfilLocal 	
	 */
	public List<PerfilLocalResponse> buscarTodos();
	
	/**
	 * Retorna un perfilLocal por:
	 * @param idPerfil
	 * 			el identificador del perfil
	 * @param codigoLocal
	 * 			el código del local		
	 */
	public PerfilLocalResponse buscarPorIdPerfilYCodigoLocal(Integer idPerfil, String codigoLocal);
	
	/**
	 * Registra un perfilLocal 
	 * @param PerfilLocalRequest
	 * 			el perfilLocal a registrar	
	 */
	public PerfilLocalResponse registrarPerfilLocal(PerfilLocalRequest perfilLocalRequest);
	
	
	/**
	 * Actualiza un perfil 
	 * @param idPerfil
	 * 			el identificador del perfil
	 * @param codigoLocal
	 * 			el código del local
	 * @param PerfilLocalRequest
	 * 			el perfilLocal a actualizar	
	 */
	public PerfilLocalResponse actualizarPerfilLocal(Integer idPerfil, String codigoLocal, PerfilLocalRequest perfilLocalRequest);
	
	/**
	 * Elimina un perfilLocal 
	 * @param perfilLocalRequest
	 * 		perfilLocal a eliminar
	 */
	void eliminarPerfilLocal(PerfilLocalRequest perfilLocalRequest);
	
	
	/**
	 * Retorna una lista de perfilesLocales buscados por:
	 * @param idPerfil
	 * 			el identificador del perfil
	 * @return
	 */
	public List<PerfilLocalResponse> buscarPorIdPerfil(@Param("idPerfil") Integer idPerfil);
}
