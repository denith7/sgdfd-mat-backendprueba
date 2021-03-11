package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.local;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.LocalMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.LocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.LocalRequest;


/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de local
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link LocalService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link LocalMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class LocalServiceImpl extends MantenibleAuditadoService<LocalRequest, LocalResponse>
		implements LocalService  {

    private LocalMapper localMapper;
    
    /**
     * Instancia la interface {@link LocalMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
    public LocalServiceImpl(@Qualifier("localMapper") MantenibleMapper<LocalRequest, LocalResponse > mapper) {
        super(mapper);
        this.localMapper = (LocalMapper) mapper;
    }
    
    @Override
	public LocalResponse registrarLocal(LocalRequest parametroLocal) {
    	localMapper.mantener("INSERT",parametroLocal , parametroLocal.getUsuario());
    	return localMapper.buscarPorId(parametroLocal.getCodigoLocal());
	}

	@Override
	public LocalResponse actualizarLocal(String codigoLocal, LocalRequest parametroLocal) {
		parametroLocal.setCodigoLocal(codigoLocal);
		localMapper.mantener("UPDATE", parametroLocal, parametroLocal.getUsuario());
		return localMapper.buscarPorId(parametroLocal.getCodigoLocal());
	}

	@Override
	public void eliminarLocal(LocalRequest parametroLocal) {
		eliminar(parametroLocal);
	}
	
	@Override
	public LocalResponse buscarPorId(String codigoLocal) {
		return localMapper.buscarPorId(codigoLocal);
	}
	
	
	@Override
	public List<LocalResponse> buscarTodos() {
		return localMapper.buscarTodos();
	}

	@Override
	public List<LocalResponse> buscarPorDocumento(String numeroDocumento) {
		return localMapper.buscarPorDocumento(numeroDocumento);
	}

	@Override
	public List<LocalResponse> buscarPorGrupoLocal(Integer idGrupoLocal){
		return localMapper.buscarPorGrupoLocal(idGrupoLocal);
	}
	

}
