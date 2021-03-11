package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.cargo;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.CargoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.CargoRequest;


/**
 * Define los métodos asociados a las operaciones de mantenimiento de Cargos,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Ximena Politi
 * @see MantenibleService
 * @see CargoRequest
 * @see CargoResponse
 */
public interface CargoService extends MantenibleService<CargoRequest, CargoResponse>
{
	
	/**
	 * Retorna una lista de cargos 	
	 */
	public List<CargoResponse> buscarTodos();
	
	/**
	 * Retorna un cargo por:
	 * @param codigoCargo
	 * 			codigo del cargo a buscar		
	 */
	public CargoResponse buscarPorCodigoCargo(String codigoCargo);
	
	/**
	 * Registra un cargo 
	 * @param cargoRequest
	 * 			el cargo a registrar	
	 */
	public CargoResponse registrarCargo(CargoRequest cargoRequest);
	
	/**
	 * Actualiza un cargo 
	 * @param codigoCargo
	 * 			codigo identificador del cargo
	 * @param cargoRequest
	 * 			el cargo a actualizar	
	 */
    public CargoResponse actualizarCargo(String codigoCargo, CargoRequest cargoRequest);
    
    /**
	 * Elimina un cargo 
	 * @param cargoRequest
	 * 		cargo a eliminar
	 */
    public void eliminarCargo(CargoRequest cargoRequest);
    

}
