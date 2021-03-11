package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.multitabcab;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.MultitabCabMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.MultitabCabResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.MultitabCabRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de cabeceras de multitablas
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link MultitabCabService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link MultitabCabMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 * @author Ximena Politi
 */
@Service
@Transactional
public class MultitabCabServiceImpl extends MantenibleAuditadoService<MultitabCabRequest, MultitabCabResponse> implements MultitabCabService {

	
	private MultitabCabMapper multitabCabMapper;
	
	/**
     * Instancia la interface {@link MultitabCabMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public MultitabCabServiceImpl(@Qualifier("multitabCabMapper") MantenibleMapper<MultitabCabRequest, MultitabCabResponse> mapper) {
		super(mapper);
		this.multitabCabMapper = (MultitabCabMapper) mapper;
	}

	@Override
	public List<MultitabCabResponse> buscarTodos() {
		return multitabCabMapper.buscarTodos();
	}
	
	@Override
	public MultitabCabResponse buscarPorIdMultitabCab(Integer idMultitabCab) {
		return multitabCabMapper.buscarPorIdMultitabCab(idMultitabCab);
	}

	@Override
	public MultitabCabResponse registrarMultitabCab(MultitabCabRequest multitabCabRequest) {
		multitabCabMapper.mantener("INSERT",multitabCabRequest , multitabCabRequest.getUsuario());
		return multitabCabMapper.buscarPorIdMultitabCab(multitabCabRequest.getIdMultitabCab());

	}

	@Override
	public MultitabCabResponse actualizarMultitabCab(Integer idMultitabCab, MultitabCabRequest multitabCabRequest) {
		multitabCabRequest.setIdMultitabCab(idMultitabCab);
		multitabCabMapper.mantener("UPDATE",multitabCabRequest , multitabCabRequest.getUsuario());
		return multitabCabMapper.buscarPorIdMultitabCab(multitabCabRequest.getIdMultitabCab());
	}

	@Override
	public void eliminarMultitabCab(MultitabCabRequest multitabCabRequest) {
			eliminar(multitabCabRequest);
	}
}
