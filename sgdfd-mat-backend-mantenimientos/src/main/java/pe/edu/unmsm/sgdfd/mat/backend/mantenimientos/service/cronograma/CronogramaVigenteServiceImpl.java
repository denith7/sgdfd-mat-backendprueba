package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.cronograma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.CronogramaVigenteMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.CronogramaVigenteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.CronogramaVigenteRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de cronogramas vigentes y de las
 * busquedas de acuerdo a diferentes atributos que
 * devolveran listas de cronogramas vigentes
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link CronogramaVigenteService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link CronogramaVigenteMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 * @author Ximena Politi
 */
@Service
@Transactional
public class CronogramaVigenteServiceImpl extends MantenibleAuditadoService<CronogramaVigenteRequest, CronogramaVigenteResponse> implements CronogramaVigenteService{

	
	@Autowired
	private CronogramaVigenteMapper cronogramaVigenteMapper;
	
	/**
     * Instancia la interface {@link CronogramaVigenteMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public CronogramaVigenteServiceImpl(@Qualifier("cronogramaVigenteMapper") MantenibleMapper<CronogramaVigenteRequest, CronogramaVigenteResponse> mapper) {
        super(mapper);
        this.cronogramaVigenteMapper = (CronogramaVigenteMapper) mapper;
    }
	
	@Override
	public List<CronogramaVigenteResponse> buscarTodos(){
		return cronogramaVigenteMapper.buscarTodos();
	}
	
	
	@Override
	public List<CronogramaVigenteResponse> buscarPorIdTipoTramite(Integer idTipoTramite) {
		return cronogramaVigenteMapper.buscarPorIdTipoTramite(idTipoTramite);
	}


	@Override
	public List<CronogramaVigenteResponse> buscarPorIdTipoTramiteYCodigoLocal(Integer idTipoTramite, String codigoLocal) {
		return cronogramaVigenteMapper.buscarPorIdTipoTramiteYCodigoLocal(idTipoTramite, codigoLocal);
	}


	@Override
	public void eliminarCronogramaVigente(CronogramaVigenteRequest cronogramaVigenteRequest) {
		eliminar(cronogramaVigenteRequest);
		
	}


	@Override
	public CronogramaVigenteResponse registrarCronogramaVigente(CronogramaVigenteRequest cronogramaVigenteRequest) {
		cronogramaVigenteMapper.mantener("INSERT",cronogramaVigenteRequest , cronogramaVigenteRequest.getUsuario());
		return buscarPorIdTipoTramiteYIdItemYCodigoLocal(cronogramaVigenteRequest.getIdTipoTramite()
									, cronogramaVigenteRequest.getIdItem(), cronogramaVigenteRequest.getCodigoLocal());
	}


	@Override
	public CronogramaVigenteResponse actualizarCronogramaVigente(Integer idTipoTramite, Integer idItem, String idLocal,
			CronogramaVigenteRequest cronogramaVigenteRequest) {
		cronogramaVigenteRequest.setIdTipoTramite(idTipoTramite);
		cronogramaVigenteRequest.setIdItem(idItem);
		cronogramaVigenteRequest.setCodigoLocal(idLocal);
		cronogramaVigenteMapper.mantener("UPDATE",cronogramaVigenteRequest , cronogramaVigenteRequest.getUsuario());
		return buscarPorIdTipoTramiteYIdItemYCodigoLocal(cronogramaVigenteRequest.getIdTipoTramite()
									, cronogramaVigenteRequest.getIdItem(), cronogramaVigenteRequest.getCodigoLocal());
	}

	@Override
	public CronogramaVigenteResponse buscarPorIdTipoTramiteYIdItemYCodigoLocal(Integer idTipoTramite, Integer idItem, String codigoLocal) {
		return cronogramaVigenteMapper.buscarPorIdTipoTramiteYIdItemYCodigoLocal(idTipoTramite, idItem, codigoLocal);
	}

}
