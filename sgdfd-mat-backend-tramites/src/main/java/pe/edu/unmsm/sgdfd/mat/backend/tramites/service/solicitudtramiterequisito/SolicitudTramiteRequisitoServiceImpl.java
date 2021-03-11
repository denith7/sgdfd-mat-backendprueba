package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramiterequisito;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.SolicitudTramiteRequisitoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta.SolicitudTramiteRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.id.DetalleSolicitudTramiteId;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoEstadoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoObservarRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoValorRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de requisitos de solicitudes de trámite
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link SolicitudTramiteRequisitoService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link SolicitudTramiteRequisitoMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class SolicitudTramiteRequisitoServiceImpl extends MantenibleAuditadoService<SolicitudTramiteRequisitoRequest, SolicitudTramiteRequisitoResponse> implements SolicitudTramiteRequisitoService{
	
	
    private SolicitudTramiteRequisitoMapper solicitudTramiteRequisitoMapper;

    /**
     * Instancia la interface {@link SolicitudTramiteRequisitoMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
    public SolicitudTramiteRequisitoServiceImpl(@Qualifier("solicitudTramiteRequisitoMapper") MantenibleMapper<SolicitudTramiteRequisitoRequest, SolicitudTramiteRequisitoResponse> mapper) {
        super(mapper);
        this.solicitudTramiteRequisitoMapper = (SolicitudTramiteRequisitoMapper) mapper;
    }
    
    @Override
	public SolicitudTramiteRequisitoResponse buscarPorId(DetalleSolicitudTramiteId id) {
		return solicitudTramiteRequisitoMapper.buscarPorId(id);
	}
    
	@Override	
	public List<SolicitudTramiteRequisitoResponse> buscarTodosDetalleSolicitudTramite() {
		return solicitudTramiteRequisitoMapper.buscarTodos();
	}
	
    @Override
	public SolicitudTramiteRequisitoRequest registrarDetalleSolicitudTramite(SolicitudTramiteRequisitoRequest parametroDetalleSolicitudTramite) {
    	parametroDetalleSolicitudTramite.setEstado("1");//estado por defecto "por verificar"
    	registrar(parametroDetalleSolicitudTramite);
		return parametroDetalleSolicitudTramite;
	}

	@Override
	public SolicitudTramiteRequisitoRequest actualizarDetalleSolicitudTramite(DetalleSolicitudTramiteId detalleSolicitudTramiteId,SolicitudTramiteRequisitoRequest parametroDetalleSolicitudTramite) {
		
		parametroDetalleSolicitudTramite.setIdRequisito(detalleSolicitudTramiteId.getIdRequisito());
		parametroDetalleSolicitudTramite.setIdSolicitudTramite(detalleSolicitudTramiteId.getIdSolicitudTramite());
		parametroDetalleSolicitudTramite.setIdTipoTramite(detalleSolicitudTramiteId.getIdTipoTramite());
		actualizar(parametroDetalleSolicitudTramite);
		return parametroDetalleSolicitudTramite;
	}

	@Override
	public void eliminarDetalleSolicitudTramite(SolicitudTramiteRequisitoRequest parametroDetalleSolicitudTramite) {
		eliminar(parametroDetalleSolicitudTramite);
	}

	@Override
	public void observar(Integer idSolicitudTramite, Integer idTipoTramite, Integer idRequisito, Integer idItem,
			SolicitudTramiteRequisitoObservarRequest stro) {
		SolicitudTramiteRequisitoRequest solicitudTramiteRequisito = SolicitudTramiteRequisitoRequest.builder()
				.idSolicitudTramite(idSolicitudTramite)
				.idTipoTramite(idTipoTramite)
				.idRequisito(idRequisito)
				.idItem(idItem)
				.estado(stro.getEstado())
				.observacion(stro.getObservacion())
				.build();
		System.out.println("solitramiterequi"+solicitudTramiteRequisito);
		solicitudTramiteRequisitoMapper.mantener("OBSERVAR", solicitudTramiteRequisito, stro.getUsuario());
	}

	@Override
	public void actualizarEstado(Integer idSolicitudTramite, Integer idTipoTramite, Integer idRequisito,
			SolicitudTramiteRequisitoEstadoRequest state) {
		SolicitudTramiteRequisitoRequest solicitudTramiteRequisito = SolicitudTramiteRequisitoRequest.builder()
				.idSolicitudTramite(idSolicitudTramite)
				.idTipoTramite(idTipoTramite)
				.idRequisito(idRequisito)
				.estado(state.getEstado())
				.build();
		solicitudTramiteRequisitoMapper.mantener("STATE", solicitudTramiteRequisito, state.getUsuario());
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@Override
	public SolicitudTramiteRequisitoResponse actualizarValor(
			DetalleSolicitudTramiteId detalleSolicitudTramiteId,
			SolicitudTramiteRequisitoValorRequest solicitudTramiteRequisitoValorRequest) {
		
		SolicitudTramiteRequisitoRequest solicitudTramiteRequisito = SolicitudTramiteRequisitoRequest.builder()
				.idSolicitudTramite(detalleSolicitudTramiteId.getIdSolicitudTramite())
				.idTipoTramite(detalleSolicitudTramiteId.getIdTipoTramite())
				.idRequisito(detalleSolicitudTramiteId.getIdRequisito())
				.idItem(detalleSolicitudTramiteId.getIdItem())
				.valor(solicitudTramiteRequisitoValorRequest.getValor())
				.archivoAdjunto(solicitudTramiteRequisitoValorRequest.getArchivoAdjunto())
				.estado(solicitudTramiteRequisitoValorRequest.getEstado())
				.build();
		
		solicitudTramiteRequisitoMapper.mantener("ACTUALIZAR", solicitudTramiteRequisito, solicitudTramiteRequisitoValorRequest.getUsuario());
		
		return solicitudTramiteRequisitoMapper.buscarPorId(detalleSolicitudTramiteId);
	}
	
		
//	@Override
//	public List<DetalleSolicitudTramite> buscarPorCriterio(DetalleSolicitudTramiteCriterioBusqueda criterioBusqueda) {
//		return solicitudTramiteRequisitoMapper.buscarPorCriterio(criterioBusqueda);
//	}



	


	

}
