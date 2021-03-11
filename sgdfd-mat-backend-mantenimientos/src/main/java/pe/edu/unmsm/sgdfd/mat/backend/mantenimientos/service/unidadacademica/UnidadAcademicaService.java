package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.unidadacademica;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.UnidadAcademicaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.UnidadAcademicaRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de unidades academicas,
 * ademas de incluir busquedas de listas por medio de distintos atributos
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Ximena Politi
 * @see MantenibleService
 * @see UnidadAcademicaRequest
 * @see UnidadAcademicaResponse
 */
public interface UnidadAcademicaService extends MantenibleService<UnidadAcademicaRequest, UnidadAcademicaResponse> {
	
	/**
	 * Retorna una lista con todas las unidades académicas
	 */
	public List<UnidadAcademicaResponse> buscarTodos();
	
	/**
	 * Retorna una lista de unidades académicas por:
	 * @param codigoLocal
	 * 			el código del local		
	 */
	public List<UnidadAcademicaResponse> buscarPorCodigoLocal(String codigoLocal);
	
	/**
	 * Retorna una unidad académica por:
	 * @param codigoLocal
	 * 			el código del local
	 * @param codigoUnidadAcademica
	 * 			el código de la unidad académica		
	 */
	public UnidadAcademicaResponse buscarPorCodigoLocalYCodigoUnidadAcademica(String codigoLocal, Integer codigoUnidadAcademica);
	
	/**
	 * Registra una unidad académica 
	 * @param unidadAcademicaRequest
	 * 			la unidad académica a registrar	
	 */
	public UnidadAcademicaResponse registrarUnidadAcademica(UnidadAcademicaRequest unidadAcademicaRequest);
	
	/**
	 * Actualiza una unidad académica  
	 * @param codigoLocal
	 * 			el código del local
	 * @param codigoUnidadAcademica
	 * 			el código de la unidad académica
	 * @param unidadAcademicaRequest
	 * 			la unidad académica a actualizar	
	 */
    public UnidadAcademicaResponse actualizarUnidadAcademica(String codigoLocal, Integer codigoUnidadAcademica , UnidadAcademicaRequest unidadAcademicaRequest);
    
    /**
	 * Elimina una unidad académica 
	 * @param unidadAcademicaRequest
	 * 		la unidad académica a eliminar
	 */
    public void eliminarUnidadAcademica(UnidadAcademicaRequest unidadAcademicaRequest);
	
	
}
