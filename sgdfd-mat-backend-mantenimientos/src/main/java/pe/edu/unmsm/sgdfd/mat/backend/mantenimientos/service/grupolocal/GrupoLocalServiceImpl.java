package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.grupolocal;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.GrupoLocalMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.GrupoLocalFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.GrupoLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.GrupoLocalRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de grupos de locales
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link GrupoLocalService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link GrupoLocalMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class GrupoLocalServiceImpl extends MantenibleAuditadoService<GrupoLocalRequest, GrupoLocalResponse>
		implements GrupoLocalService  
{

    private GrupoLocalMapper grupoLocalMapper;
    
    /**
     * Instancia la interface {@link GrupoLocalMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
    public GrupoLocalServiceImpl(@Qualifier("grupoLocalMapper") MantenibleMapper<GrupoLocalRequest, GrupoLocalResponse> mapper) {
        super(mapper);
        this.grupoLocalMapper = (GrupoLocalMapper) mapper;
    }

	@Override
	public List<GrupoLocalResponse> buscarTodos() {
		return grupoLocalMapper.buscarTodos();
	}
	
	@Override
	public GrupoLocalResponse buscarPorIdGrupoLocal(Integer idGrupoLocal) {
		return grupoLocalMapper.buscarPorIdGrupoLocal(idGrupoLocal);
	}
	
	@Override
	public List<GrupoLocalResponse> buscarPorCriterio(GrupoLocalFilter criterioBusqueda) {
		return grupoLocalMapper.buscarPorCriterio(criterioBusqueda);
	}


    @Override
	public GrupoLocalResponse registrarGrupoLocal(GrupoLocalRequest grupoLocalRequest) {
		registrar(grupoLocalRequest);
		return grupoLocalMapper.buscarPorIdGrupoLocal(grupoLocalRequest.getIdGrupoLocal());
	}

	@Override
	public GrupoLocalResponse actualizarGrupoLocal(Integer idGrupoLocal, GrupoLocalRequest grupoLocalRequest) {
		grupoLocalRequest.setIdGrupoLocal(idGrupoLocal);
		actualizar(grupoLocalRequest);
		return grupoLocalMapper.buscarPorIdGrupoLocal(grupoLocalRequest.getIdGrupoLocal());
	}

	@Override
	public void eliminarGrupoLocal(GrupoLocalRequest grupoLocalRequest) {
		eliminar(grupoLocalRequest);
	}

	

}
