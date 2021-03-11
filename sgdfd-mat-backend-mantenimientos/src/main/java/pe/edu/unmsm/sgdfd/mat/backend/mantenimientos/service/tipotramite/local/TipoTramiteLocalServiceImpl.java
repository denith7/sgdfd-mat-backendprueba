package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.local;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.TipoTramiteLocalMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.TipoTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.id.TipoTramiteLocalId;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteLocalRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de Locales en donde estarán disponibles cada tipo de tramite, 
 * ademas de incluir busquedas de listas por medio de diferentes atributos.
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link TipoTramiteLocalService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link TipoTramiteLocalMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 * @author Ximena Politi
 */
@Service
@Transactional
public class TipoTramiteLocalServiceImpl extends MantenibleAuditadoService<TipoTramiteLocalRequest, TipoTramiteLocalResponse>
		implements TipoTramiteLocalService  
{

    private TipoTramiteLocalMapper tipoTramiteLocalMapper;
    
    /**
     * Instancia la interface {@link TipoTramiteLocalMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
    public TipoTramiteLocalServiceImpl(@Qualifier("tipoTramiteLocalMapper") MantenibleMapper<TipoTramiteLocalRequest, TipoTramiteLocalResponse> mapper) {
        super(mapper);
        this.tipoTramiteLocalMapper = (TipoTramiteLocalMapper) mapper;
    }
    
 
    @Override
	public TipoTramiteLocalResponse registrarTipoTramiteLocal(TipoTramiteLocalRequest tipoTramiteLocalRequest){
    	registrar(tipoTramiteLocalRequest);
		return tipoTramiteLocalMapper.buscarPorIdTipoTramiteYCodigoLocal(TipoTramiteLocalId.builder()
				.codigoLocal(tipoTramiteLocalRequest.getCodigoLocal())
				.idTipoTramite(tipoTramiteLocalRequest.getIdTipoTramite())
				.build());
	}

	@Override
	public TipoTramiteLocalResponse actualizarTipoTramiteLocal(TipoTramiteLocalId idTipoTramiteLocal, TipoTramiteLocalRequest tipoTramiteLocalRequest) {
		tipoTramiteLocalRequest.setCodigoLocal(idTipoTramiteLocal.getCodigoLocal());
		tipoTramiteLocalRequest.setIdTipoTramite(idTipoTramiteLocal.getIdTipoTramite());
		actualizar(tipoTramiteLocalRequest);
		return tipoTramiteLocalMapper.buscarPorIdTipoTramiteYCodigoLocal(TipoTramiteLocalId.builder()
				.codigoLocal(tipoTramiteLocalRequest.getCodigoLocal())
				.idTipoTramite(tipoTramiteLocalRequest.getIdTipoTramite())
				.build());
	}

	@Override
	public void eliminarTipoTramiteLocal(TipoTramiteLocalId idTipoTramiteLocal) {
		eliminar(TipoTramiteLocalRequest.builder()
				.codigoLocal(idTipoTramiteLocal.getCodigoLocal())
				.idTipoTramite(idTipoTramiteLocal.getIdTipoTramite()).build());
	}
	
	@Override
	public TipoTramiteLocalResponse buscarPorIdTipoTramiteYCodigoLocal(TipoTramiteLocalId id) {
		return tipoTramiteLocalMapper.buscarPorIdTipoTramiteYCodigoLocal(id);
	}
	
	@Override
	public List<TipoTramiteLocalResponse> buscarTodos() {
		return tipoTramiteLocalMapper.buscarTodos();
	}


	@Override
	public List<TipoTramiteLocalResponse>  buscarPorIdTipoTramite(TipoTramiteLocalId id) {
		return tipoTramiteLocalMapper.buscarPorIdTipoTramite(id);
	}

	@Override
	public List<TipoTramiteLocalResponse>  buscarPorCodigoLocal(TipoTramiteLocalId id) {
		// TODO Auto-generated method stub
		return tipoTramiteLocalMapper.buscarPorCodigoLocal(id);
	}
	
	@Override
	public TipoTramiteLocalResponse actualizarEstadoTipoTramiteLocal(TipoTramiteLocalId idTipoTramiteLocal,
			TipoTramiteLocalRequest tipoTramiteLocalRequest) {
		tipoTramiteLocalRequest.setCodigoLocal(idTipoTramiteLocal.getCodigoLocal());
		tipoTramiteLocalRequest.setIdTipoTramite(idTipoTramiteLocal.getIdTipoTramite());
		tipoTramiteLocalMapper.mantener("STATE", tipoTramiteLocalRequest, tipoTramiteLocalRequest.getUsuario());
		return tipoTramiteLocalMapper.buscarPorIdTipoTramiteYCodigoLocal(TipoTramiteLocalId.builder()
				.codigoLocal(tipoTramiteLocalRequest.getCodigoLocal())
				.idTipoTramite(tipoTramiteLocalRequest.getIdTipoTramite())
				.build());
	}


	@Override
	public TipoTramiteLocalResponse buscarPorUrlYLocal(TipoTramiteFilter criterioBusqueda) {		
		return tipoTramiteLocalMapper.buscarPorUrlYLocal(criterioBusqueda);
	}
	
	@Override
	public TipoTramiteLocalResponse buscarPorUrlYLocalYEscuela(String nombreUrl, String codigoLocal, String codigoEscuela) {		
		return tipoTramiteLocalMapper.buscarPorUrlYLocalYEscuela(nombreUrl,codigoLocal,codigoEscuela);
	}
	

}
