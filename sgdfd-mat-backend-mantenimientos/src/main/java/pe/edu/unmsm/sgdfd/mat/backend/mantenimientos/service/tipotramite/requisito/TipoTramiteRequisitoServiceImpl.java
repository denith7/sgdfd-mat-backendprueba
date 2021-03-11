package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.requisito;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.TipoTramiteRequisitoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.id.TipoTramiteRequisitoId;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteRequisitoRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de Requisitos pertenecientes a cada tipo de tramite,
 * ademas de incluir busquedas por diferentes atributos que retornaran 
 * o una lista o un Requisito de un Tipo de Tramite
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link TipoTramiteRequisitoService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link TipoTramiteRequisitoMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class TipoTramiteRequisitoServiceImpl extends MantenibleAuditadoService<TipoTramiteRequisitoRequest, TipoTramiteRequisitoResponse>
		implements TipoTramiteRequisitoService  
{

    private TipoTramiteRequisitoMapper tipoTramiteRequisitoMapper;
    
    /**
     * Instancia la interface {@link TipoTramiteRequisitoMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
    public TipoTramiteRequisitoServiceImpl(@Qualifier("tipoTramiteRequisitoMapper") MantenibleMapper<TipoTramiteRequisitoRequest, TipoTramiteRequisitoResponse> mapper) {
        super(mapper);
        this.tipoTramiteRequisitoMapper = (TipoTramiteRequisitoMapper) mapper;
    }
    
	@Override
	public List<TipoTramiteRequisitoResponse> buscarTodos() {
		return tipoTramiteRequisitoMapper.buscarTodos();
	}
    
	@Override
	public TipoTramiteRequisitoResponse buscarPorId(TipoTramiteRequisitoId id) {
		return tipoTramiteRequisitoMapper.buscarPorId(id);
	}
	
	@Override
	public List<TipoTramiteRequisitoResponse> buscarPorTipoTramite(TipoTramiteRequisitoId id) {
		return tipoTramiteRequisitoMapper.buscarPorTipoTramite(id);
	}    
	
	@Override
	public TipoTramiteRequisitoResponse registrarTipoTramiteRequisito(TipoTramiteRequisitoRequest tipoTramiteRequisitoRequest) {
		registrar(tipoTramiteRequisitoRequest);
		
		return tipoTramiteRequisitoMapper.buscarPorId(TipoTramiteRequisitoId.builder()
														.idTipoTramite(tipoTramiteRequisitoRequest.getIdTipoTramite())
														.idRequisito(tipoTramiteRequisitoRequest.getIdRequisito()).build());
	}

	@Override
	public TipoTramiteRequisitoResponse actualizarTipoTramiteRequisito(TipoTramiteRequisitoId idTipoTramiteRequisito, TipoTramiteRequisitoRequest tipoTramiteRequisitoRequest) {
		tipoTramiteRequisitoRequest.setIdRequisito(idTipoTramiteRequisito.getIdRequisito());
		tipoTramiteRequisitoRequest.setIdTipoTramite(idTipoTramiteRequisito.getIdTipoTramite());
		actualizar(tipoTramiteRequisitoRequest);
		return tipoTramiteRequisitoMapper.buscarPorId(TipoTramiteRequisitoId.builder()
				.idTipoTramite(tipoTramiteRequisitoRequest.getIdTipoTramite())
				.idRequisito(tipoTramiteRequisitoRequest.getIdRequisito()).build());
	}

	@Override
	public void eliminarTipoTramiteRequisito(TipoTramiteRequisitoRequest tipoTramiteRequisitoRequest) {
		eliminar(tipoTramiteRequisitoRequest);
	}
		

}
