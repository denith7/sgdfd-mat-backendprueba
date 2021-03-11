package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.formulario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.FormularioMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.FormularioFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.FormularioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoFormularioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.FormularioRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de formulario
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link FormularioService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link FormularioMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class FormularioServiceImpl extends MantenibleAuditadoService<FormularioRequest, FormularioResponse> implements FormularioService {

	private @Autowired FormularioMapper formularioMapper;
	
	/**
     * Instancia la interface {@link FormularioMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public FormularioServiceImpl(@Qualifier("formularioMapper") MantenibleMapper<FormularioRequest, FormularioResponse> mapper) {
        super(mapper);
        this.formularioMapper = (FormularioMapper) mapper;
    }


	@Override
	public List<FormularioResponse> buscarTodos() {
		return formularioMapper.buscarTodos();
	}

	@Override
	public List<RequisitoFormularioResponse> buscarPorRequisito(Integer idRequisito) {
		return formularioMapper.buscarPorRequisito(idRequisito);
	}

	@Override
	public FormularioResponse registrarFormulario(FormularioRequest formularioRequest) {
		registrar(formularioRequest);
		return formularioMapper.buscarPorIdFormuario(formularioRequest.getIdFormulario());
	}

	@Override
	public FormularioResponse actualizarFormulario(Integer idFormulario, FormularioRequest formularioRequest) {
		formularioRequest.setIdFormulario(idFormulario);
		actualizar(formularioRequest);
		return formularioMapper.buscarPorIdFormuario(formularioRequest.getIdFormulario());
	}

	@Override
	public void eliminarFormulario(FormularioRequest formularioRequest) {
		eliminar(formularioRequest);
		
	}	
	
	@Override
	public List<FormularioResponse> buscarPorCriterio(FormularioFilter criterioBusqueda) {
		return formularioMapper.buscarPorCriterio(criterioBusqueda);
	}
	
	@Override
	public FormularioResponse buscarPorIdFormuario(Integer idFormulario) {
		return formularioMapper.buscarPorIdFormuario(idFormulario);
	}
	

	
}
