package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.ubigeo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.UbigeoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.UbigeoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.UbigeoRequest;
import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de ubigeos, ademas de incluir busquedas 
 * de todos los departamentos, provincias o distritos
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link UbigeoService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link UbigeoMapper} solo para operaciones de mantenimiento. 
 *
 * @author Ximena Politi
 */
@Service
@Transactional
public class UbigeoServiceImpl extends MantenibleAuditadoService<UbigeoRequest, UbigeoResponse>
		implements UbigeoService  {

    private UbigeoMapper ubigeoMapper;
    
    /**
     * Instancia la interface {@link UbigeoMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
    public UbigeoServiceImpl(@Qualifier("ubigeoMapper") MantenibleMapper<UbigeoRequest, UbigeoResponse> mapper) {
        super(mapper);
        this.ubigeoMapper = (UbigeoMapper) mapper;
    }
    	
    @Override
	public List<UbigeoResponse> buscarTodos() {
		return ubigeoMapper.buscarTodos();
	}
    
    @Override
	public List<UbigeoResponse> buscarTodosPorDepartamentos() {
		return ubigeoMapper.buscarTodosPorDepartamentos();
	}
	
	@Override
	public List<UbigeoResponse> obtenerProvincias(String codigoDepartamento) {
		return ubigeoMapper.obtenerProvincias(codigoDepartamento);
	}
	
	
	@Override
	public List<UbigeoResponse> obtenerDistritos(String codigoDepartamento, String codigoProvincia) {
		return ubigeoMapper.obtenerDistritos(codigoDepartamento, codigoProvincia);
	}


	@Override
	public UbigeoResponse buscarPorCodigoUbigeo(String codigoUbigeo) {
		return ubigeoMapper.buscarPorCodigoUbigeo(codigoUbigeo);
	}


	@Override
	public UbigeoResponse registrarUbigeo(UbigeoRequest ubigeoRequest) {
		ubigeoMapper.mantener("INSERT", ubigeoRequest, ubigeoRequest.getUsuario());		
		return ubigeoMapper.buscarPorCodigoUbigeo(ubigeoRequest.getCodigoUbigeo());
	}


	@Override
	public UbigeoResponse actualizarUbigeo(String codigoUbigeo, UbigeoRequest ubigeoRequest) {
		ubigeoRequest.setCodigoUbigeo(codigoUbigeo);
		ubigeoMapper.mantener("UPDATE", ubigeoRequest, ubigeoRequest.getUsuario());
		return ubigeoMapper.buscarPorCodigoUbigeo(ubigeoRequest.getCodigoUbigeo());
	}


	@Override
	public void eliminarUbigeo(UbigeoRequest ubigeoRequest) {
		eliminar(ubigeoRequest);
	}
	


}
