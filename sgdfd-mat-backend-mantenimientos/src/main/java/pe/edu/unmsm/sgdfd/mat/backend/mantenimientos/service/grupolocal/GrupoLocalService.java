package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.grupolocal;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.GrupoLocalFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.GrupoLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.GrupoLocalRequest;


/**
 * Define los métodos asociados a las operaciones de mantenimiento de grupos de locales,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see GrupoLocalRequest
 * @see GrupoLocalResponse
 */
public interface GrupoLocalService extends MantenibleService<GrupoLocalRequest, GrupoLocalResponse>
{
	/**
	 * Retorna una lista de grupos de locales 	
	 */
	public List<GrupoLocalResponse> buscarTodos();
	
	/**
	 * Retorna un grupo de locales por:
	 * @param idGrupoLocal
	 * 			idenfificador del grupo de locales a buscar		
	 */
	public GrupoLocalResponse buscarPorIdGrupoLocal(Integer idGrupoLocal);
	
	/**
	 * Registra un grupo de locales 
	 * @param grupoLocalRequest
	 * 			el grupo de locales a registrar	
	 */
	public GrupoLocalResponse registrarGrupoLocal(GrupoLocalRequest grupoLocalRequest);
	
	/**
	 * Actualiza un grupo de locales 
	 * @param idGrupoLocal
	 * 			identificador del grupo de locales a actualizar	
	 * @param grupoLocalRequest
	 * 			el grupo de locales a actualizar	
	 */
    public GrupoLocalResponse actualizarGrupoLocal(Integer idGrupoLocal, GrupoLocalRequest grupoLocalRequest);
    
    /**
	 * Elimina un grupo de locales 
	 * @param grupoLocalRequest
	 * 		grupo de locales a eliminar
	 */
    public void eliminarGrupoLocal(GrupoLocalRequest grupoLocalRequest); 
    
    /**
	 * Retorna una lista de grupos de locales buscada por:
	 * @param criterioBusqueda
	 * 			criterios de búsqueda para el formulario de tipo GrupoLocalFilter
	 */
	public List<GrupoLocalResponse> buscarPorCriterio(GrupoLocalFilter criterioBusqueda);
}