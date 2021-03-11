package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.cargo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.CargoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.CargoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.CargoRequest;


/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de cargo
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link CargoService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link CargoMapper} solo para operaciones de mantenimiento. 
 *
 * @author Ximena Politi
 */
@Service
@Transactional
public class CargoServiceImp extends MantenibleAuditadoService<CargoRequest, CargoResponse>
implements CargoService {

	private CargoMapper cargoMapper;
	
	/**
     * Instancia la interface {@link CargoMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public CargoServiceImp(@Qualifier("cargoMapper") MantenibleMapper<CargoRequest, CargoResponse> mapper) {
        super(mapper);
        this.cargoMapper = (CargoMapper) mapper;
    }
    
	@Override
	public List<CargoResponse> buscarTodos() {
		return cargoMapper.buscarTodos();
	}	
	
	@Override
	public CargoResponse buscarPorCodigoCargo(String codigoCargo) {
		return cargoMapper.buscarPorCodigoCargo(codigoCargo);
	}
	
	@Override
	public CargoResponse registrarCargo(CargoRequest cargoRequest) {
		cargoMapper.mantener("INSERT",cargoRequest , cargoRequest.getUsuario());
    	return cargoMapper.buscarPorCodigoCargo(cargoRequest.getCodigoCargo());
	}

	@Override
	public CargoResponse actualizarCargo(String codigoCargo, CargoRequest cargoRequest) {
		cargoRequest.setCodigoCargo(codigoCargo);
		cargoMapper.mantener("UPDATE", cargoRequest, cargoRequest.getUsuario());
		return cargoMapper.buscarPorCodigoCargo(cargoRequest.getCodigoCargo());
	}

	@Override
	public void eliminarCargo(CargoRequest cargoRequest) {
		eliminar(cargoRequest);
	}

	
}
