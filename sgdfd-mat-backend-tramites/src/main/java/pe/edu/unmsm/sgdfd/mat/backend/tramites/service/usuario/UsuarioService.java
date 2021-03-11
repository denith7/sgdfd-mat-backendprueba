package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.usuario;

import java.util.List;

import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.UsuarioFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.UsuarioResponse;


public interface UsuarioService 
{
	
    List<UsuarioResponse> buscarPorCriterio(UsuarioFilter criterio);
    
    
}