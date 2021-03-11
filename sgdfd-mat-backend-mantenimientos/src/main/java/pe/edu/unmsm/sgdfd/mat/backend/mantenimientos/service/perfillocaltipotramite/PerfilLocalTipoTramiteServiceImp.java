package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.perfillocaltipotramite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.PerfilLocalMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.PerfilLocalTipoTramiteMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.id.TipoTramiteLocalId;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PerfilLocalTipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PerfilLocalTipoTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.perfillocal.PerfilLocalService;

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
public class PerfilLocalTipoTramiteServiceImp extends MantenibleAuditadoService<PerfilLocalTipoTramiteRequest,PerfilLocalTipoTramiteResponse> implements PerfilLocalTipoTramiteService{

	private @Autowired PerfilLocalTipoTramiteMapper perfilLocalTipoTramiteMapper;
	
	/**
     * Instancia la interface {@link PerfilLocalTipoTramiteMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public PerfilLocalTipoTramiteServiceImp(@Qualifier("perfilLocalTipoTramiteMapper") MantenibleMapper<PerfilLocalTipoTramiteRequest,PerfilLocalTipoTramiteResponse> mapper) {
		super(mapper);
		this.perfilLocalTipoTramiteMapper = (PerfilLocalTipoTramiteMapper) mapper;
	}
	
	@Override
	public List<PerfilLocalTipoTramiteResponse> buscarTodos(){
		return perfilLocalTipoTramiteMapper.buscarTodos();
	}
	
	@Override
	public PerfilLocalTipoTramiteResponse buscarPorId(Integer idPerfil, String codigoLocal, Integer idTipoTramite) {
		return perfilLocalTipoTramiteMapper.buscarPorId(idPerfil, codigoLocal, idTipoTramite);
	}
	
	@Override
	public PerfilLocalTipoTramiteResponse registrarPerfilLocalTipoTramite(PerfilLocalTipoTramiteRequest perfilLocalTipoTramiteRequest) {
		registrar(perfilLocalTipoTramiteRequest);
		return perfilLocalTipoTramiteMapper.buscarPorId(perfilLocalTipoTramiteRequest.getIdPerfil(), perfilLocalTipoTramiteRequest.getCodigoLocal(), perfilLocalTipoTramiteRequest.getIdTipoTramite());
	}
	
	@Override
	public void eliminarPerfilLocalTipoTramite(PerfilLocalTipoTramiteRequest perfilLocalTipoTramiteRequest) {
		eliminar(perfilLocalTipoTramiteRequest);
	}
	
	
//	@Override
//	public PerfilLocalTipoTramiteRequest actualizarTipoDocumento(Integer idPerfil, String codigoLocal, Integer idTipoTramite, PerfilLocalTipoTramiteRequest perfilLocalTipoTramiteRequest) {
//		
//	}
}
