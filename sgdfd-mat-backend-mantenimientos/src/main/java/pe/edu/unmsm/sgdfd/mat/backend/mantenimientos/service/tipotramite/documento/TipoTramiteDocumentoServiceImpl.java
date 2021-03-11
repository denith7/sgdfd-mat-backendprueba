package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.documento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.TipoTramiteDocumentoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteDocumentoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteDocumentoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.destinatario.TipoTramiteDestinatarioService;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de TipoTramiteDocumento, ademas de busquedas que retornen 
 * listas de TiposTramiteDocumento de acuerdo a diferentes atributos
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link TipoTramiteDestinatarioService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link TipoTramiteDocumentoMapper} solo para operaciones de mantenimiento. 
 *
 * @author Eric Robladillo
 */
@Service
@Transactional
public class TipoTramiteDocumentoServiceImpl extends MantenibleAuditadoService<TipoTramiteDocumentoRequest, TipoTramiteDocumentoResponse> implements TipoTramiteDocumentoService {

	private @Autowired TipoTramiteDocumentoMapper tipoTramiteDocumentoMapper;
	
	/**
     * Instancia la interface {@link TipoTramiteDocumentoMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public TipoTramiteDocumentoServiceImpl(@Qualifier("tipoTramiteDocumentoMapper") MantenibleMapper<TipoTramiteDocumentoRequest, TipoTramiteDocumentoResponse> mapper) {
        super(mapper);
        this.tipoTramiteDocumentoMapper = (TipoTramiteDocumentoMapper) mapper;
    }

	@Override
	public List<TipoTramiteDocumentoResponse> buscarTodos() {
		return tipoTramiteDocumentoMapper.buscarTodos();
		
	}
	
	@Override
	public TipoTramiteDocumentoResponse buscarPorIdTipoTramiteYIdTipoDocumento(Integer idTipoTramite, String idTipoDocumento) {
		return tipoTramiteDocumentoMapper.buscarPorIdTipoTramiteYIdTipoDocumento(idTipoTramite,idTipoDocumento);
	}
	
	@Override
	public void eliminarTipoTramiteDocumento(TipoTramiteDocumentoRequest tipoTramiteDocumentoRequest) {
		eliminar(tipoTramiteDocumentoRequest);
		
	}

	@Override
	public TipoTramiteDocumentoResponse registrarTipoTramiteDocumento(TipoTramiteDocumentoRequest tipoTramiteDocumentoRequest) {
		registrar(tipoTramiteDocumentoRequest);
		return tipoTramiteDocumentoMapper.buscarPorIdTipoTramiteYIdTipoDocumento(
				tipoTramiteDocumentoRequest.getIdTipoTramite(),
				tipoTramiteDocumentoRequest.getIdTipoDocumento());
	}

	@Override
	public TipoTramiteDocumentoResponse actualizarTipoTramiteDocumento(Integer idTipoTramite, String idTipoDocumento,
			 TipoTramiteDocumentoRequest tipoTramiteDocumentoRequest) {
		tipoTramiteDocumentoRequest.setIdTipoTramite(idTipoTramite);
		tipoTramiteDocumentoRequest.setIdTipoDocumento(idTipoDocumento);
		actualizar(tipoTramiteDocumentoRequest);
		return tipoTramiteDocumentoMapper.buscarPorIdTipoTramiteYIdTipoDocumento(idTipoTramite, idTipoDocumento);
	}
}
