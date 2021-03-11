package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.IdCadena;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.CargoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.CargoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.cargo.CargoService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de Cargos 
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los cargos
 * 	<li>Búsqueda de un cargo por código de cargo
 * 	<li>Registro de un cargo
 * 	<li>Actualización de un cargo
 * 	<li>Eliminación de un cargo
 * </ul>
 * 
 * @author Ximena Politi
 * @see CargoRequest
 * @see CargoResponse
 * @see CargoService
 */
@Validated
@RestController
@RequestMapping("/cargos")
public class CargoRestController {

	private CargoService cargoService;

	public CargoRestController(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	/**
	 * Retorna una lista de todos los cargos existentes.  
	 * 			
	 * @return	lista de cargos obtenidos por búsqueda es de tipo:
	 * 			{@link CargoResponse}
	 */
	@GetMapping
	@PreAuthorize("hasPermission('MAN_CARGO','101')")
	public List<CargoResponse> buscarTodos() {
		return cargoService.buscarTodos();
	}
	
	
	/**
	 * Retorna un cargo buscado por atributo:  
	 * @param codigoCargo
	 * 			el código de cargo
	 * @param --
	 * @return	cargo obtenido por búsqueda:
	 * 			{@link CargoResponse}
	 */
	@GetMapping("/{codigoCargo}")
	@PreAuthorize("hasPermission('MAN_CARGO','102')")
	public CargoResponse buscarPorCodigoCargo(@PathVariable("codigoCargo") 
						@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,4}", maxLength = 4) String codigoCargo) {
		return cargoService.buscarPorCodigoCargo(codigoCargo);
	}
		
	/**
	 * Recibe petición de registro de cargo.  
	 * @param cargoRequest
	 * 			el cargo a registrar
	 * @param --
	 * @return	cargo registrado
	 * 			{@link CargoResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_CARGO','201')")
	public CargoResponse registrarCargo(@Valid @RequestBody CargoRequest cargoRequest) {
		return cargoService.registrarCargo(cargoRequest);
	}
	
	
	/**
	 * Recibe petición de actualización de cargo.  
	 * @param codigoCargo
	 * 			el código del cargo a actualizar
	 * @param cargoRequest
	 * 			el cargo a actualizar
	 * @param --
	 * @return	cargo actualizado
	 * 			{@link CargoResponse}
	 */
	@PutMapping("/{codigoCargo}")
	@PreAuthorize("hasPermission('MAN_CARGO','301')")
	public CargoResponse actualizarCargo(@PathVariable("codigoCargo") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,4}", maxLength = 4) String codigoCargo, 
										@Valid @RequestBody CargoRequest cargoRequest) {
		return cargoService.actualizarCargo(codigoCargo, cargoRequest);
	}
	
	/**
	 * Recibe petición de eliminación de cargo.  
	 * @param codigoCargo
	 * 			el código del cargo a eliminar
	 * @param --
	 * 		
	 */
	@DeleteMapping("/{codigoCargo}")
	@PreAuthorize("hasPermission('MAN_CARGO','401')")
	public void eliminarCargo(@PathVariable("codigoCargo") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,4}", maxLength = 4) String codigoCargo) {
		cargoService.eliminarCargo(CargoRequest.builder().codigoCargo(codigoCargo).build());
	}
}
