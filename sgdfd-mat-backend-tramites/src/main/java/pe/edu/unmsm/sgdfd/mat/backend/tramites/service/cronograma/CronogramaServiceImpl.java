package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.cronograma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.CronogramaMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.CronogramaRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.CronogramaResponse;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de cronograma
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link CronogramaService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link CronogramaMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class CronogramaServiceImpl extends MantenibleAuditadoService<CronogramaRequest, CronogramaResponse> implements CronogramaService{

	
	@Autowired
	private CronogramaMapper cronogramaMapper;
	
	/**
     * Instancia la interface {@link CronogramaMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public CronogramaServiceImpl(@Qualifier("cronogramaMapper") MantenibleMapper<CronogramaRequest, CronogramaResponse> mapper) {
        super(mapper);
        this.cronogramaMapper = (CronogramaMapper) mapper;
    }
	
	
	@Override
	public List<CronogramaResponse> buscarPorIdTipoTramite(Integer idTipoTramite) {
		return cronogramaMapper.buscarPorIdTipoTramite(idTipoTramite);
	}


	@Override
	public List<CronogramaResponse> buscarPorIdTipoTramiteYCodigoLocal(Integer codigoTipo, String codigoLocal) {
		return cronogramaMapper.buscarPorIdTipoTramiteYCodigoLocal(codigoTipo, codigoLocal);
	}

}
