package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.perfil;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PerfilResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PerfilRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de Perfiles,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Ximena Politi
 * @see MantenibleService
 * @see PerfilRequest
 * @see PerfilResponse
 */
public interface PerfilService extends MantenibleService <PerfilRequest, PerfilResponse> {
	
	/**
	 * Retorna una lista con todos los perfiles 	
	 */
	public List<PerfilResponse> buscarTodos();
	
	/**
	 * Retorna un perfil por:
	 * @param idPerfil
	 * 			el identificador del perfil a buscar		
	 */
	public PerfilResponse buscarPorIdPerfil(Integer idPerfil);
	
	/**
	 * Registra un perfil 
	 * @param perfilRequest
	 * 			el perfil a registrar	
	 */
	public PerfilResponse registrarPerfil(PerfilRequest perfilRequest);
	
	/**
	 * Actualiza un perfil 
	 * @param idPerfil
	 * 			el identificador del perfil
	 * @param perfilRequest
	 * 			el perfil a actualizar	
	 */
	public PerfilResponse actualizarPerfil(Integer idPerfil, PerfilRequest perfilRequest);
	
	/**
	 * Elimina un perfil 
	 * @param perfilRequest
	 * 		perfil a eliminar
	 */
	void eliminarPerfil(PerfilRequest perfilRequest);
	
}
