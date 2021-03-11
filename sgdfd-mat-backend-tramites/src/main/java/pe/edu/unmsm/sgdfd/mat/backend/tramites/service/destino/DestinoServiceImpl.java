package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.destino;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.DestinoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.DestinoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.DestinoResponse;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de destino
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link DestinoService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link DestinoMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class DestinoServiceImpl extends MantenibleAuditadoService<DestinoRequest,DestinoResponse> implements DestinoService{

	private DestinoMapper destinoMapper;

	/**
     * Instancia la interface {@link DestinoMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public DestinoServiceImpl(
			@Qualifier("destinoMapper") MantenibleMapper<DestinoRequest,DestinoResponse> mapper) {
		super(mapper);
		this.destinoMapper = (DestinoMapper) mapper;
	}
	
	@Override
	public List<DestinoResponse> buscarTodos(){
		return destinoMapper.buscarTodos();
	}

	@Override
	public DestinoRequest registrarDestino(DestinoRequest destinoRequest) {
		registrar(destinoRequest);
		return destinoRequest;
	}
	
	
}
