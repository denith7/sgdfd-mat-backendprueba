package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.EstadoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.EstadoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.EstadoRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de estado y de busquedas por diferentes atributos
 * que retornaran o una lista o un Estado
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link EstadoService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link EstadoMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 * @author Ximena Politi
 */
@Service
@Transactional
public class EstadoServiceImpl extends MantenibleAuditadoService<EstadoRequest, EstadoResponse>
		implements EstadoService  {


    private EstadoMapper estadoMapper;
    
    /**
     * Instancia la interface {@link EstadoMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
    public EstadoServiceImpl(@Qualifier("estadoMapper") MantenibleMapper<EstadoRequest, EstadoResponse> mapper) {
        super(mapper);
        this.estadoMapper = (EstadoMapper) mapper;
    }
    
    @Override
	public List<EstadoResponse> buscarTodos() {
		return estadoMapper.buscarTodos();
	}

    
    @Override
	public List<EstadoResponse> buscarPorTablaOrigen(String tablaOrigen) {
		return estadoMapper.buscarPorTablaOrigen(tablaOrigen);
	}
    
    @Override
	public EstadoResponse buscarPorTablaOrigenYCodigoEstado(String tablaOrigen, String codigoEstado) {
		return estadoMapper.buscarPorTablaOrigenYCodigoEstado(tablaOrigen, codigoEstado);
	}
    
    
    @Override
	public EstadoResponse registrarEstado(EstadoRequest estadoRequest) {
    	estadoMapper.mantener("INSERT",estadoRequest , estadoRequest.getUsuario());
		return estadoMapper.buscarPorTablaOrigenYCodigoEstado(estadoRequest.getTablaOrigen(), estadoRequest.getCodigoEstado());
	}

	@Override
	public EstadoResponse actualizarEstado(String tablaOrigen, String codigoEstado, EstadoRequest estadoRequest) {
		estadoRequest.setTablaOrigen(tablaOrigen);
		estadoRequest.setCodigoEstado(codigoEstado);
		estadoMapper.mantener("UPDATE",estadoRequest, estadoRequest.getUsuario());
		return estadoMapper.buscarPorTablaOrigenYCodigoEstado(estadoRequest.getTablaOrigen(), estadoRequest.getCodigoEstado());
	}

	@Override
	public void eliminarEstado(EstadoRequest estadoRequest) {
		eliminar(estadoRequest);
	}
	
}
