package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.perfillocal;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.PerfilLocalMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PerfilLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PerfilLocalRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de PerfilLocal
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link PerfilLocalService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link PerfilLocalMapper} solo para operaciones de mantenimiento. 
 *
 * @author Ximena Politi
 */
@Service
@Transactional
public class PerfilLocalServiceImp extends MantenibleAuditadoService<PerfilLocalRequest,PerfilLocalResponse> 
					implements PerfilLocalService{

	private PerfilLocalMapper perfilLocalMapper;
	
	
	/**
     * Instancia la interface {@link PerfilLocalMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public PerfilLocalServiceImp(@Qualifier("perfilLocalMapper") MantenibleMapper<PerfilLocalRequest,PerfilLocalResponse> mapper) {
		super(mapper);
		this.perfilLocalMapper = (PerfilLocalMapper) mapper;
	}

	@Override
	public List<PerfilLocalResponse> buscarTodos() {
		return perfilLocalMapper.buscarTodos();
	}
	
	
	@Override
	public PerfilLocalResponse buscarPorIdPerfilYCodigoLocal(Integer idPerfil, String codigoLocal) {
		return perfilLocalMapper.buscarPorIdPerfilYCodigoLocal(idPerfil, codigoLocal);
	}


	@Override
	public PerfilLocalResponse registrarPerfilLocal(PerfilLocalRequest perfilLocalRequest) {
		perfilLocalMapper.mantener("INSERT", perfilLocalRequest, perfilLocalRequest.getUsuario());		
		return perfilLocalMapper.buscarPorIdPerfilYCodigoLocal(perfilLocalRequest.getIdPerfil(), perfilLocalRequest.getCodigoLocal());
	}


	@Override
	public PerfilLocalResponse actualizarPerfilLocal(Integer idPerfil, String codigoLocal,
			PerfilLocalRequest perfilLocalRequest) {
		perfilLocalRequest.setIdPerfil(idPerfil);
		perfilLocalRequest.setCodigoLocal(codigoLocal);
		perfilLocalMapper.mantener("UPDATE", perfilLocalRequest, perfilLocalRequest.getUsuario());
		return perfilLocalMapper.buscarPorIdPerfilYCodigoLocal(perfilLocalRequest.getIdPerfil(), perfilLocalRequest.getCodigoLocal());
	}


	@Override
	public void eliminarPerfilLocal(PerfilLocalRequest perfilLocalRequest) {
		eliminar(perfilLocalRequest);
		
	}
	
	@Override
	public List<PerfilLocalResponse> buscarPorIdPerfil(@Param("idPerfil") Integer idPerfil){
		return perfilLocalMapper.buscarPorIdPerfil(idPerfil);
	}
}
