package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.beans.factory.annotation.Autowired;
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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.UnidadAcademicaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.UnidadAcademicaRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.unidadacademica.UnidadAcademicaService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de unidades academicas ,
 * ademas de incluir busquedas de listas por medio de distintos atributos
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todas las unidades académicas 
 *  <li>Buscar una lista de unidades académicas por código de local
 * 	<li>Búsqueda de una unidad académica por código local y código unidad académica
 * 	<li>Registro de una unidad académica
 * 	<li>Actualización de una unidad académica
 * 	<li>Eliminación	de una unidad académica
 * </ul>
 * 
 * @author Ximena Politi
 * @see UnidadAcademicaRequest
 * @see UnidadAcademicaResponse
 * @see UnidadAcademicaService
 */
@Validated
@RestController
@RequestMapping("/unidad-academica")
public class UnidadAcademicaRestController {
	
	@Autowired
	private UnidadAcademicaService unidadAcademicaService;
	
	/**
	 * Retorna una lista con todas las unidades académicas.  
	 * 
	 * @return	lista obtenida de unidades académicas es de tipo:
	 * 			{@link UnidadAcademicaResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_UNIDAD_ACADEMICA','101')")
	public List<UnidadAcademicaResponse> buscarTodos() {
		return unidadAcademicaService.buscarTodos();
	}
	
	/**
	 * Retorna una lista de todas los unidades académicas buscada por atributo:.  
	 * @param codigoLocal
	 * 			el código del local			
	 * @param --
	 * @return	lista obtenida de unidades académicas es de tipo:
	 * 			{@link UnidadAcademicaResponse}
	 */
	@GetMapping("/local/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_UNIDAD_ACADEMICA','102')")
	public List<UnidadAcademicaResponse> buscarPorCodigoLocal(
					@PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal){
		return unidadAcademicaService.buscarPorCodigoLocal(codigoLocal);
	}
	
	/**
	 * Retorna una unidad académica buscada por atributo:  
	 * @param codigoLocal
	 * 			el código del local
	 * @param codigoUnidadAcademica
	 * 			el código de la unidad académica
	 * @param --
	 * @return	unidad académica obtenida por búsqueda:
	 * 			{@link UnidadAcademicaResponse}
	 */
	@GetMapping("/local/{codigoLocal}/unidad-academica/{codigoUnidadAcademica}")
	@PreAuthorize("hasPermission('MAN_UNIDAD_ACADEMICA','103')")
	public UnidadAcademicaResponse buscarPorCodigoLocalYCodigoUnidadAcademica(
					@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal
				   ,@PathVariable("codigoUnidadAcademica") @PositiveOrZero(message = "Debe ser positivo") Integer codigoUnidadAcademica ) {
		return unidadAcademicaService.buscarPorCodigoLocalYCodigoUnidadAcademica(codigoLocal, codigoUnidadAcademica);
	}
	
	/**
	 * Recibe petición de registro de una unidad académica.  
	 * @param unidadAcademicaRequest
	 * 			unidad académica a registrar
	 * @param --
	 * @return	unidad académica registrada
	 * 			{@link UnidadAcademicaResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_UNIDAD_ACADEMICA','201')")
	public UnidadAcademicaResponse registrarUnidadAcademica(@Valid @RequestBody UnidadAcademicaRequest unidadAcademicaRequest) {
		return unidadAcademicaService.registrarUnidadAcademica(unidadAcademicaRequest);
	}
	
	/**
	 * Recibe petición de actualización de una unidad académica.  
	 * @param codigoLocal
	 * 			el código del local
	 * @param codigoUnidadAcademica
	 * 			el código de la unidad académica
	 * @param unidadAcademicaRequest
	 * 			unidad académica a actualizar
	 * @param --
	 * @return	unidad académica actualizada
	 * 			{@link UnidadAcademicaResponse}
	 */
	@PutMapping("/local/{codigoLocal}/unidad-academica/{codigoUnidadAcademica}")
	@PreAuthorize("hasPermission('MAN_UNIDAD_ACADEMICA','301')")
	public UnidadAcademicaResponse actualizarUnidadAcademica(
						@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal,
					    @PathVariable("codigoUnidadAcademica")  @PositiveOrZero(message = "Debe ser positivo") Integer codigoUnidadAcademica,
					    @Valid @RequestBody UnidadAcademicaRequest unidadAcademicaRequest) {
		return unidadAcademicaService.actualizarUnidadAcademica(codigoLocal,codigoUnidadAcademica ,unidadAcademicaRequest);
	}
	
	/**
	 * Recibe petición de eliminación de una unidad académica.  
	 * @param codigoLocal
	 * 			el código del local
	 * @param codigoUnidadAcademica
	 * 			el código de la unidad académica
	 * @param --
	 * 		
	 */
	@DeleteMapping("/local/{codigoLocal}/unidad-academica/{codigoUnidadAcademica}")
	@PreAuthorize("hasPermission('MAN_UNIDAD_ACADEMICA','401')")
	public void eliminarUnidadAcademica(
					@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal,
				    @PathVariable("codigoUnidadAcademica") @PositiveOrZero(message = "Debe ser positivo") Integer codigoUnidadAcademica) {
		unidadAcademicaService.eliminarUnidadAcademica(UnidadAcademicaRequest.builder().codigoLocal(codigoLocal).codigoUnidadAcademica(codigoUnidadAcademica).build());
	}
	
	
}
