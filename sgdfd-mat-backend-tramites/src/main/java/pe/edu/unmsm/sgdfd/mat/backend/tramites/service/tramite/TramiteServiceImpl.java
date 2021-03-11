package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramite;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.TramiteMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.TramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.TramiteResponse;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de trámite
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link TramiteService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link TramiteMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class TramiteServiceImpl extends MantenibleAuditadoService<TramiteRequest,TramiteResponse>
implements TramiteService{
	
    private TramiteMapper tramiteMapper;

    /**
     * Instancia la interface {@link TipoTramiteRequisitoMapper} a partir de la interface 
     * genérica {@link TramiteMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
    public TramiteServiceImpl(@Qualifier("tramiteMapper")MantenibleMapper<TramiteRequest,TramiteResponse> mapper) {
        super(mapper);
        this.tramiteMapper = (TramiteMapper) mapper;
    }

	@Override	
	public List<TramiteResponse> buscarTodos() {
		return tramiteMapper.buscarTodos();
	}
	
    @Override
	public TramiteRequest registrarTramite(TramiteRequest tramite) {
		super.registrar(tramite);
		return tramite;
	}
}
