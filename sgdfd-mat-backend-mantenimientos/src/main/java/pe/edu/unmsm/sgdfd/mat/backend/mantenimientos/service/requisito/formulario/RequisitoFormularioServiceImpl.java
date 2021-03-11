package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.requisito.formulario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.RequisitoFormularioMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoFormularioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.RequisitoFormularioRequest;


@Service
public class RequisitoFormularioServiceImpl extends MantenibleAuditadoService<RequisitoFormularioRequest, RequisitoFormularioResponse> implements RequisitoFormularioService{

	private @Autowired RequisitoFormularioMapper requisitoFormularioMapper;

	public RequisitoFormularioServiceImpl(@Qualifier("requisitoFormularioMapper") MantenibleMapper<RequisitoFormularioRequest, RequisitoFormularioResponse> mapper) {
        super(mapper);
        this.requisitoFormularioMapper = (RequisitoFormularioMapper) mapper;
    }

	@Override
	public List<RequisitoFormularioResponse> buscarTodos() {
		return requisitoFormularioMapper.buscarTodos();
	}

	@Override
	public RequisitoFormularioRequest registrarRequisitoFormulario(RequisitoFormularioRequest requisitoFormularioRequest) {
		registrar(requisitoFormularioRequest);
		return requisitoFormularioRequest;
	}
	
	@Override
	public RequisitoFormularioRequest actualizarRequisitoFormulario(Integer idRequisito, Integer idFormulario, RequisitoFormularioRequest requisitoFormularioRequest) {
		requisitoFormularioRequest.setIdRequisito(idRequisito);
		requisitoFormularioRequest.setIdFormulario(idFormulario);
			actualizar(requisitoFormularioRequest);
			return requisitoFormularioRequest;
	}
	
	@Override
	public void eliminarRequisitoFormulario(RequisitoFormularioRequest requisitoFormularioRequest) {
		eliminar(requisitoFormularioRequest);
		
	}

}
