package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.usuario;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.UsuarioMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.UsuarioFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.UsuarioResponse;

@Service
@Transactional
public class UsuarioServiceImpl 
implements UsuarioService{
	
	@Autowired
    private UsuarioMapper usuarioMapper;

    
	@Override
	public List<UsuarioResponse> buscarPorCriterio(UsuarioFilter criterio) {
		return usuarioMapper.buscarPorCriterio(criterio);
	}



}
