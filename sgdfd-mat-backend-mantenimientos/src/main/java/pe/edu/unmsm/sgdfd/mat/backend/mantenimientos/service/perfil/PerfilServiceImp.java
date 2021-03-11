package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.perfil;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.PerfilMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PerfilResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PerfilRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de Perfiles
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link PerfilService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link PerfilMapper} solo para operaciones de mantenimiento. 
 *
 * @author Ximena Politi
 */
@Service
@Transactional
public class PerfilServiceImp extends MantenibleAuditadoService<PerfilRequest, PerfilResponse> implements PerfilService  {

	private PerfilMapper perfilMapper;
	
	/**
     * Instancia la interface {@link PerfilMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public PerfilServiceImp(@Qualifier("perfilMapper") MantenibleMapper<PerfilRequest, PerfilResponse> mapper) {
		super(mapper);
		this.perfilMapper = (PerfilMapper) mapper;
	}

	@Override
	public List<PerfilResponse> buscarTodos() {
		return perfilMapper.buscarTodos();
	}
	
	@Override
	public PerfilResponse buscarPorIdPerfil(Integer idPerfil) {
		return perfilMapper.buscarPorIdPerfil(idPerfil);
	}

	@Override
	public PerfilResponse registrarPerfil(PerfilRequest perfilRequest) {
		perfilMapper.mantener("INSERT",perfilRequest , perfilRequest.getUsuario());
		return perfilMapper.buscarPorIdPerfil(perfilRequest.getIdPerfil());

	}

	@Override
	public PerfilResponse actualizarPerfil(Integer idPerfil, PerfilRequest perfilRequest) {
		perfilRequest.setIdPerfil(idPerfil);
		perfilMapper.mantener("UPDATE", perfilRequest ,perfilRequest.getUsuario());
		return perfilMapper.buscarPorIdPerfil(perfilRequest.getIdPerfil());
	}

	@Override
	public void eliminarPerfil(PerfilRequest perfilRequest) {
			eliminar(perfilRequest);
	}
	
	
}
