package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.destinatario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.TipoTramiteDestinatarioMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteDestinatarioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteDestinatarioRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de Destinos a donde es posible derivar 
 * cada tipo de tramite, ademas de busquedas que retornen 
 * listas de requisitos de acuerdo a diferentes atributos
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link TipoTramiteDestinatarioService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link TipoTramiteDestinatarioMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class TipoTramiteDestinatarioServiceImpl extends MantenibleAuditadoService<TipoTramiteDestinatarioRequest, TipoTramiteDestinatarioResponse> implements TipoTramiteDestinatarioService {

	private @Autowired TipoTramiteDestinatarioMapper tipoTramiteDestinatarioMapper;
	
	/**
     * Instancia la interface {@link TipoTramiteDestinatarioMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public TipoTramiteDestinatarioServiceImpl(@Qualifier("tipoTramiteDestinatarioMapper") MantenibleMapper<TipoTramiteDestinatarioRequest, TipoTramiteDestinatarioResponse> mapper) {
        super(mapper);
        this.tipoTramiteDestinatarioMapper = (TipoTramiteDestinatarioMapper) mapper;
    }

	@Override
	public List<TipoTramiteDestinatarioResponse> buscarTodos() {
		return tipoTramiteDestinatarioMapper.buscarTodos();
		
	}
	
	@Override
	public List<TipoTramiteDestinatarioResponse> buscarPorIdTipoTramite(Integer idTipoTramite) {
		return tipoTramiteDestinatarioMapper.buscarPorIdTipoTramite(idTipoTramite);
		
	}

	@Override
	public List<TipoTramiteDestinatarioResponse> buscarPorIdLocal(String idLocal) {
		return tipoTramiteDestinatarioMapper.buscarPorIdLocal(idLocal);
	}

	@Override
	public TipoTramiteDestinatarioResponse buscarPorIdTipoTramiteYIdLocalYIdItem(Integer idTipoTramite, String idLocal, Integer idItem) {
		return tipoTramiteDestinatarioMapper.buscarPorIdTipoTramiteYIdLocalYIdItem(idTipoTramite,idLocal,idItem);
	}
	
	@Override
	public void eliminarTipoTramiteDestinatario(TipoTramiteDestinatarioRequest tipoTramiteDestinatarioRequest) {
		eliminar(tipoTramiteDestinatarioRequest);
		
	}

	@Override
	public TipoTramiteDestinatarioResponse registrarTipoTramiteDestinatario(TipoTramiteDestinatarioRequest tipoTramiteDestinatarioRequest) {
		registrar(tipoTramiteDestinatarioRequest);
		return tipoTramiteDestinatarioMapper.buscarPorIdTipoTramiteYIdLocalYIdItem(
				tipoTramiteDestinatarioRequest.getIdTipoTramite(),
				tipoTramiteDestinatarioRequest.getIdLocal(),
				tipoTramiteDestinatarioRequest.getIdItem());
	}

	@Override
	public TipoTramiteDestinatarioResponse actualizarTipoTramiteDestinatario(Integer idTipoTramite, String idLocal,
			Integer idItem, TipoTramiteDestinatarioRequest tipoTramiteDestinatarioRequest) {
		tipoTramiteDestinatarioRequest.setIdTipoTramite(idTipoTramite);
		tipoTramiteDestinatarioRequest.setIdLocal(idLocal);
		tipoTramiteDestinatarioRequest.setIdItem(idItem);
		actualizar(tipoTramiteDestinatarioRequest);
		return tipoTramiteDestinatarioMapper.buscarPorIdTipoTramiteYIdLocalYIdItem(idTipoTramite, idLocal, idItem);
	}
	
	


}
