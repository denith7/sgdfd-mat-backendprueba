package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.formulario;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.FormularioFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.FormularioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoFormularioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.FormularioRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de formulario,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see FormularioRequest
 * @see FormularioResponse
 */
public interface FormularioService extends MantenibleService<FormularioRequest, FormularioResponse>{
	
	/**
	 * Retorna una lista de formularios 	
	 */
	public List<FormularioResponse> buscarTodos();
	
	/**
	 * Retorna una lista de formularios por:
	 * @param idRequisito
	 * 			el identificador de requisito		
	 */
	public List<RequisitoFormularioResponse> buscarPorRequisito(Integer idRequisito);

	/**
	 * Registra un formulario 
	 * @param formularioRequest
	 * 			el formulario a registrar	
	 */
	public FormularioResponse registrarFormulario(FormularioRequest formularioRequest);
	
	/**
	 * Actualiza un formulario 
	 * @param idFormulario
	 * 			el identificador de formulario a actualizar	
	 * @param formularioRequest
	 * 			el formulario a actualizar	
	 */
	public FormularioResponse actualizarFormulario(Integer idFormulario, FormularioRequest formularioRequest);
	
	/**
	 * Elimina un formulario 
	 * @param formularioRequest
	 * 		formulario a eliminar
	 */
    public void eliminarFormulario(FormularioRequest formularioRequest);
    
    /**
	 * obtiene una lista de formularios por:
	 * @param criterioBusqueda
	 * 			criterios de búsqueda para el formulario de tipo FormularioFilter
	 */
	public List<FormularioResponse> buscarPorCriterio(FormularioFilter criterioBusqueda);    
    
	/**
	 * obtiene un formulario por:
	 * @param idFormulario
	 * 			el identificador de formulario a buscar		
	 */
    public FormularioResponse buscarPorIdFormuario(Integer idFormulario);

}
