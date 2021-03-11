package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.unidadacademica;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.UnidadAcademicaMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.UnidadAcademicaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.UnidadAcademicaRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de unidades academicas,
 * ademas de incluir busquedas de listas por medio de distintos atributos
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link UnidadAcademicaService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link UnidadAcademicaMapper} solo para operaciones de mantenimiento. 
 *
 * @author Ximena Politi
 */
@Service
@Transactional
public class UnidadAcademicaServiceImpl extends MantenibleAuditadoService<UnidadAcademicaRequest, UnidadAcademicaResponse> implements UnidadAcademicaService {

	private UnidadAcademicaMapper unidadAcademicaMapper;
	
	/**
     * Instancia la interface {@link UnidadAcademicaMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public UnidadAcademicaServiceImpl(@Qualifier("unidadAcademicaMapper") MantenibleMapper<UnidadAcademicaRequest, UnidadAcademicaResponse> mapper) {
		super(mapper);
		this.unidadAcademicaMapper = (UnidadAcademicaMapper) mapper;
	}
	
	@Override
	public List<UnidadAcademicaResponse> buscarTodos() {
		return unidadAcademicaMapper.buscarTodos();
	}
	
	@Override
	public List<UnidadAcademicaResponse> buscarPorCodigoLocal(String codigoLocal){
		return unidadAcademicaMapper.buscarPorCodigoLocal(codigoLocal);
	}
	
	@Override
	public UnidadAcademicaResponse buscarPorCodigoLocalYCodigoUnidadAcademica(String codigoLocal, Integer codigoUnidadAcademica) {
		return unidadAcademicaMapper.buscarPorCodigoLocalYCodigoUnidadAcademica(codigoLocal, codigoUnidadAcademica);
	}
	
	@Override
	public UnidadAcademicaResponse registrarUnidadAcademica(UnidadAcademicaRequest unidadAcademicaRequest) {
		unidadAcademicaMapper.mantener("INSERT",unidadAcademicaRequest , unidadAcademicaRequest.getUsuario());
    	return unidadAcademicaMapper.buscarPorCodigoLocalYCodigoUnidadAcademica(unidadAcademicaRequest.getCodigoLocal(), unidadAcademicaRequest.getCodigoUnidadAcademica());
	}
	
	@Override
	public UnidadAcademicaResponse actualizarUnidadAcademica(String codigoLocal
													,Integer codigoUnidadAcademica 
													,UnidadAcademicaRequest unidadAcademicaRequest) {
		unidadAcademicaRequest.setCodigoLocal(codigoLocal);
		unidadAcademicaRequest.setCodigoUnidadAcademica(codigoUnidadAcademica);
		unidadAcademicaMapper.mantener("UPDATE", unidadAcademicaRequest, unidadAcademicaRequest.getUsuario());
		return unidadAcademicaMapper.buscarPorCodigoLocalYCodigoUnidadAcademica(unidadAcademicaRequest.getCodigoLocal(), unidadAcademicaRequest.getCodigoUnidadAcademica());
	}
	
	@Override
	public void eliminarUnidadAcademica(UnidadAcademicaRequest unidadAcademicaRequest) {
		eliminar(unidadAcademicaRequest);
	}
}
