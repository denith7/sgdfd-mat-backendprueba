package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.localrequisito;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.TipoTramiteLocalRequisitoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.id.TipoTramiteLocalRequisitoId;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteLocalRequisitoRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de los Requisitos propios de cada Local 
 * en cada Tipo de Tramite, ademas de incluir busquedas que retornen 
 * listas de acuerdo a diferentes atributos
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link TipoTramiteLocalRequisitoService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link TipoTramiteLocalRequisitoMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class TipoTramiteLocalRequisitoServiceImpl extends MantenibleAuditadoService<TipoTramiteLocalRequisitoRequest, TipoTramiteLocalRequisitoResponse>
implements TipoTramiteLocalRequisitoService  {

    private TipoTramiteLocalRequisitoMapper tipoTramiteLocalRequisitoMapper;
    
    /**
     * Instancia la interface {@link TipoTramiteLocalRequisitoMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
    public TipoTramiteLocalRequisitoServiceImpl(@Qualifier("tipoTramiteLocalRequisitoMapper") MantenibleMapper<TipoTramiteLocalRequisitoRequest, TipoTramiteLocalRequisitoResponse> mapper) {
        super(mapper);
        this.tipoTramiteLocalRequisitoMapper = (TipoTramiteLocalRequisitoMapper) mapper;
    }
	
	@Override
	public List<TipoTramiteLocalRequisitoResponse> buscarTodos() {
		return tipoTramiteLocalRequisitoMapper.buscarTodos();
	}

	@Override
	public List<TipoTramiteLocalRequisitoResponse> buscarPorIdTipoTramite(Integer idTipoTramite){
		return tipoTramiteLocalRequisitoMapper.buscarPorIdTipoTramite(idTipoTramite);
	}

	@Override
	public List<TipoTramiteLocalRequisitoResponse> buscarPorIdRequisito(Integer idRequisito) {
		return tipoTramiteLocalRequisitoMapper.buscarPorIdRequisito(idRequisito);
	}
	
	@Override
	public TipoTramiteLocalRequisitoResponse buscarPorIdTipoTramiteYCodigoLocalYIdRequisito(Integer idTipoTramite, String codigoLocal,Integer idRequisito) {
		return tipoTramiteLocalRequisitoMapper.buscarPorIdTipoTramiteYCodigoLocalYIdRequisito(idTipoTramite,codigoLocal,idRequisito);
	}
	
    @Override
	public TipoTramiteLocalRequisitoResponse registrarTipoTramiteLocalRequisito(TipoTramiteLocalRequisitoRequest tipoTramiteLocalRequisitoRequest) {
		registrar(tipoTramiteLocalRequisitoRequest);
		
		return tipoTramiteLocalRequisitoMapper.buscarPorIdTipoTramiteYCodigoLocalYIdRequisito(
				tipoTramiteLocalRequisitoRequest.getIdTipoTramite(),
				tipoTramiteLocalRequisitoRequest.getCodigoLocal(),
				tipoTramiteLocalRequisitoRequest.getIdRequisito());
	}

	@Override
	public TipoTramiteLocalRequisitoResponse actualizarTipoTramiteLocalRequisito(TipoTramiteLocalRequisitoId idTipoTramiteLocalRequisito, TipoTramiteLocalRequisitoRequest tipoTramiteLocalRequisitoRequest) {
		tipoTramiteLocalRequisitoRequest.setIdRequisito(idTipoTramiteLocalRequisito.getIdRequisito());
		tipoTramiteLocalRequisitoRequest.setCodigoLocal(idTipoTramiteLocalRequisito.getCodigoLocal());
		tipoTramiteLocalRequisitoRequest.setIdTipoTramite(idTipoTramiteLocalRequisito.getIdTipoTramite());
		actualizar(tipoTramiteLocalRequisitoRequest);
		return tipoTramiteLocalRequisitoMapper.buscarPorIdTipoTramiteYCodigoLocalYIdRequisito(
				tipoTramiteLocalRequisitoRequest.getIdTipoTramite(),
				tipoTramiteLocalRequisitoRequest.getCodigoLocal(),
				tipoTramiteLocalRequisitoRequest.getIdRequisito());
	}

	@Override
	public void eliminarTipoTramiteLocalRequisito(TipoTramiteLocalRequisitoRequest tipoTramiteLocalRequisitoRequest) {
		eliminar(tipoTramiteLocalRequisitoRequest);
	}
    
}
