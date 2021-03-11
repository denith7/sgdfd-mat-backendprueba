package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.TipoTramiteMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.TipoTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RemitoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteFiltroRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de Tipos de Tramite,
 * ademas de incluir busquedas de listas por medio de diferentes atributos 
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link TipoTramiteService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link TipoTramiteMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 * @author Ximena Politi
 */
@Service
@Transactional
public class TipoTramiteServiceImpl extends MantenibleAuditadoService<TipoTramiteRequest, TipoTramiteResponse> implements TipoTramiteService {

	private TipoTramiteMapper tipoTramiteMapper;
	
	/**
     * Instancia la interface {@link TipoTramiteMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
    public TipoTramiteServiceImpl(@Qualifier("tipoTramiteMapper") MantenibleMapper<TipoTramiteRequest, TipoTramiteResponse> mapper) {
        super(mapper);
        this.tipoTramiteMapper = (TipoTramiteMapper) mapper;
    }	
	
	@Override
	public TipoTramiteResponse buscarPorIdTipoTramite(Integer id) {
		return tipoTramiteMapper.buscarPorId(id);
	}
	
	@Override
	public List<TipoTramiteResponse> buscarTodos() {
		return  tipoTramiteMapper.buscarTodos();
	}

	@Override
	public TipoTramiteResponse registrarTipoTramite(TipoTramiteRequest tipoTramiteRequest) {
		tipoTramiteMapper.mantener("INSERT",tipoTramiteRequest , tipoTramiteRequest.getUsuario());
		return tipoTramiteMapper.buscarPorId(tipoTramiteRequest.getIdTipoTramite());
	}

	@Override
	public TipoTramiteResponse actualizarTipoTramite(int idTipoTramite, TipoTramiteRequest tipoTramiteRequest) {
		tipoTramiteRequest.setIdTipoTramite(idTipoTramite);
		tipoTramiteMapper.mantener("UPDATE",tipoTramiteRequest, tipoTramiteRequest.getUsuario());
		return tipoTramiteMapper.buscarPorId(tipoTramiteRequest.getIdTipoTramite());
	}

	@Override
	public void eliminarTipoTramite(int idTipoTramite) {
		eliminar(TipoTramiteRequest.builder().idTipoTramite(idTipoTramite).build());
	}

//	@Override
//	public List<TipoTramite> buscarPorLocal(String codigoLocal) {
//		
//		return tipoTramiteMapper.buscarPorLocal(codigoLocal);
//	}

	@Override
	public List<TipoTramiteResponse> buscarPorCriterio(TipoTramiteFilter criterioBusqueda) {
		
		System.out.println("CRITEIRO BUSQEUQDA = " + criterioBusqueda);
		return tipoTramiteMapper.buscarPorCriterio(criterioBusqueda);
	}

	@Override
	public TipoTramiteLocalResponse buscarPorUrlYLocal(TipoTramiteFilter criterioBusqueda) {		
		return tipoTramiteMapper.buscarPorUrlYLocal(criterioBusqueda);
	}

	@Override
	public RemitoTramiteResponse buscarPorTramiteYLocal(Integer idTipoTramite, String codigoLocal) {
		System.out.print(idTipoTramite+"------"+codigoLocal);
		return tipoTramiteMapper.buscarPorTramiteYLocal(idTipoTramite, codigoLocal);
	}

	@Override
	public RemitoTramiteResponse buscarTramitePorEmpleadoYTipo(String numeroDni, Integer idTipoTramite) {
		return tipoTramiteMapper.buscarTramitePorEmpleadoYTipo(numeroDni,idTipoTramite);
	}
	
	@Override
	public TipoTramiteLocalResponse buscarPorUrlYLocalYEscuela(String nombreUrl, String codigoLocal, String codigoEscuela) {		
		return tipoTramiteMapper.buscarPorUrlYLocalYEscuela(nombreUrl,codigoLocal,codigoEscuela);
	}

	@Override
	public List<TipoTramiteLocalResponse> buscarFiltroTramite(TipoTramiteFiltroRequest tipoTramiteFiltroRequest) {
		return tipoTramiteMapper.buscarFiltroTramite(tipoTramiteFiltroRequest);
	}

}
