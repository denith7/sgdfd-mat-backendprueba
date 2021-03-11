package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.requisito.formulario;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoFormularioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.RequisitoFormularioRequest;

public interface RequisitoFormularioService extends MantenibleService <RequisitoFormularioRequest, RequisitoFormularioResponse>{
	
	public RequisitoFormularioRequest registrarRequisitoFormulario(RequisitoFormularioRequest requisitoFormularioRequest);

    public RequisitoFormularioRequest actualizarRequisitoFormulario(Integer idRequisito, Integer idFormulario, RequisitoFormularioRequest requisitoFormularioRequest);

    public void eliminarRequisitoFormulario(RequisitoFormularioRequest requisitoFormularioRequest);
	
	List<RequisitoFormularioResponse> buscarTodos();
	
}
