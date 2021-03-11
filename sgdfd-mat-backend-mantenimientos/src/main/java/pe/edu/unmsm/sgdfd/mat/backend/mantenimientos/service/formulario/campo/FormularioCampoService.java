package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.formulario.campo;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.FormularioCamposResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.FormularioCamposRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de campo de formulario,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see FormularioCamposRequest
 * @see FormularioCamposResponse
 */
public interface FormularioCampoService extends MantenibleService<FormularioCamposRequest, FormularioCamposResponse> {

	/**
	 * Obtiene una lista de campo de formulario 	
	 */
	public List<FormularioCamposResponse> buscarTodos();
	
	/**
	 * Obtiene una lista de campo de formulario buscado por:
	 * @param idFormulario
	 * 			el identificador de formulario 	
	 */
	public List<FormularioCamposResponse> buscarPorIdFormulario(Integer idFormulario);
	
	/**
	 * Registra un campo de formulario 
	 * @param formularioCamposRequest
	 * 			el campo de formulario a registrar	
	 */
	public FormularioCamposRequest registrarFormularioCampos(FormularioCamposRequest formularioCamposRequest);

	/**
	 * Actualiza un campo de formulario 
	 * @param idCampo
	 * 			el identificado del campo de formulario a actualizar	
	 * @param formularioCamposRequest
	 * 			el campo de formulario a actualizar	
	 */
	public FormularioCamposRequest actualizarFormularioCampos(Integer idCampo, FormularioCamposRequest formularioCamposRequest);
	
	/**
	 * Elimina un campo de formulario 
	 * @param formularioCamposRequest
	 * 		campo de formulario a eliminar
	 */
	public void eliminarFormularioCampos(FormularioCamposRequest formularioCamposRequest);
}
