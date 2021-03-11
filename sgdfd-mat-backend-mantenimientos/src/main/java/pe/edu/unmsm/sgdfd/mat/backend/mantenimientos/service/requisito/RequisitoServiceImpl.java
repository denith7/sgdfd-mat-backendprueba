package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.requisito;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.RequisitoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.RequisitoRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de Requisitos y
 * busquedas que retornen listas de requisitos de acuerdo a diferentes atributos
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link RequisitoService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link RequisitoMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class RequisitoServiceImpl extends MantenibleAuditadoService<RequisitoRequest, RequisitoResponse>
		implements RequisitoService  
{

    private RequisitoMapper requisitoMapper;
    
    /**
     * Instancia la interface {@link RequisitoMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
    public RequisitoServiceImpl(@Qualifier("requisitoMapper") MantenibleMapper<RequisitoRequest, RequisitoResponse> mapper) {
        super(mapper);
        this.requisitoMapper = (RequisitoMapper) mapper;
    }
    
	@Override
	public List<RequisitoResponse> buscarTodos() {
		return requisitoMapper.buscarTodos();
	}

	@Override
	public RequisitoResponse buscarPorIdRequisito(Integer idRequisito) {
		return requisitoMapper.buscarPorIdRequisito(idRequisito);
	}
       
    @Override
	public RequisitoResponse registrarRequisito(RequisitoRequest requisitoRequest) {
		registrar(requisitoRequest);	
		return requisitoMapper.buscarPorIdRequisito(requisitoRequest.getIdRequisito());
	}

	@Override
	public RequisitoResponse actualizarRequisito(Integer idRequisito, RequisitoRequest requisitoRequest) {
		requisitoRequest.setIdRequisito(idRequisito);
		actualizar(requisitoRequest);
		return requisitoMapper.buscarPorIdRequisito(requisitoRequest.getIdRequisito());
	}

	@Override
	public void eliminarRequisito(RequisitoRequest requisitoRequest) {
		eliminar(requisitoRequest);
	}	

	@Override
	public List<RequisitoResponse> buscarPorIdTipoTramite(String idTipoTramite) {
		return requisitoMapper.buscarPorIdTipoTramite(idTipoTramite);
	}
	
	@Override
	public List<RequisitoResponse> buscarPorIdTipoTramiteYCodigoLocal(String idTipoTramite, String codigoLocal) {
		return requisitoMapper.buscarPorIdTipoTramiteYCodigoLocal(idTipoTramite, codigoLocal);
	}
	
	
	
}
