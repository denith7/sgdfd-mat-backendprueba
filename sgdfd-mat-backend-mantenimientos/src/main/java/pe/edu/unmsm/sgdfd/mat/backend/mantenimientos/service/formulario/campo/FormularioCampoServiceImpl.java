package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.formulario.campo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.FormularioCamposMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.FormularioCamposResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.FormularioCamposRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de campo de formulario
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link FormularioCampoService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link FormularioCamposMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class FormularioCampoServiceImpl extends MantenibleAuditadoService<FormularioCamposRequest, FormularioCamposResponse> implements FormularioCampoService{
	
	private @Autowired FormularioCamposMapper formularioCamposMapper;
	
	/**
     * Instancia la interface {@link FormularioCamposMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public FormularioCampoServiceImpl(@Qualifier("formularioCamposMapper") MantenibleMapper<FormularioCamposRequest, FormularioCamposResponse> mapper) {
        super(mapper);
        this.formularioCamposMapper = (FormularioCamposMapper) mapper;
    }
	

	@Override
	public List<FormularioCamposResponse> buscarTodos() {
		return formularioCamposMapper.buscarTodos();
	}

	@Override
	public List<FormularioCamposResponse> buscarPorIdFormulario(Integer idFormulario) {
		return formularioCamposMapper.buscarPorIdFormulario(idFormulario);
	}
	
	@Override
	public FormularioCamposRequest registrarFormularioCampos(FormularioCamposRequest formularioCamposRequest) {
		registrar(formularioCamposRequest);
		return formularioCamposRequest;
	}
	@Override
	public FormularioCamposRequest actualizarFormularioCampos(Integer idCampo, FormularioCamposRequest formularioCamposRequest) {
		formularioCamposRequest.setIdCampo(idCampo);
		actualizar(formularioCamposRequest);
		return formularioCamposRequest;
	}
	@Override
	public void eliminarFormularioCampos(FormularioCamposRequest formularioCamposRequest) {
		eliminar(formularioCamposRequest);
		
	}	
}
