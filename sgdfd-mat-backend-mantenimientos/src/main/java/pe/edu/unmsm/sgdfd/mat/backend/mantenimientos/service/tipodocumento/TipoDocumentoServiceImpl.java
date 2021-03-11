package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipodocumento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.TipoDocumentoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.LocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoDocumentoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoDocumentoRequest;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de Tipos de Documentos
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link TipoDocumentoService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link TipoDocumentoMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class TipoDocumentoServiceImpl extends MantenibleAuditadoService<TipoDocumentoRequest, TipoDocumentoResponse> implements TipoDocumentoService{

	
	@Autowired
	private TipoDocumentoMapper tipoDocumentoMapper;
	
	/**
     * Instancia la interface {@link TipoDocumentoMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public TipoDocumentoServiceImpl(@Qualifier("tipoDocumentoMapper") MantenibleMapper<TipoDocumentoRequest, TipoDocumentoResponse> mapper) {
        super(mapper);
        this.tipoDocumentoMapper = (TipoDocumentoMapper) mapper;
    }
	
	@Override
	public List<TipoDocumentoResponse> buscarTodos(){
		return tipoDocumentoMapper.buscarTodos();
	}

	@Override
	public TipoDocumentoResponse buscarPorId(String idTipoDocumento) {
		return tipoDocumentoMapper.buscarPorId(idTipoDocumento);
	}	
	
	@Override
	public TipoDocumentoResponse registrarTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest) {
		registrar(tipoDocumentoRequest);
		return tipoDocumentoMapper.buscarPorId(tipoDocumentoRequest.getIdTipoDocumento());
	}

	@Override
	public TipoDocumentoResponse actualizarTipoDocumento(String idTipoDocumento, TipoDocumentoRequest tipoDocumentoRequest) {
		tipoDocumentoRequest.setIdTipoDocumento(idTipoDocumento);
		actualizar(tipoDocumentoRequest);
		return tipoDocumentoMapper.buscarPorId(tipoDocumentoRequest.getIdTipoDocumento());
	}
	
	@Override
	public void eliminarTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest) {
		eliminar(tipoDocumentoRequest);
	}

	
	
	@Override
	public List<TipoDocumentoResponse> buscarPorIdTipoTramite(Integer idTipoTramite) {
		return tipoDocumentoMapper.buscarPorIdTipoTramite(idTipoTramite);
	}
	
	
}
