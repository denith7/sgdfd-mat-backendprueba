package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
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
//import pe.edu.unmsm.sgd.api.service.excepcion.BadRequestException;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.LocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.LocalRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.local.LocalService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de locales 
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los locales
 * 	<li>Búsqueda de un local por código de local
 *  <li>Búsqueda de una lista de locales por número de documento asociado
 *  <li>Búsqueda de una lista de locales por identificador de grupo local 
 * 	<li>Registro de local
 * 	<li>Actualización de local
 * 	<li>Eliminación	 de local
 * </ul>
 * 
 * @author Miguel Moya
 * @author Ximena Politi
 * @see LocalRequest
 * @see LocalResponse
 * @see LocalService
 */


@Validated
@RestController
@RequestMapping("/locales")
public class LocalRestController {

	private LocalService localService;

	public LocalRestController(LocalService localService) {
		this.localService = localService;
	}

	/**
	 * Retorna una lista con todos los locales
	 * 
	 * @return lista de locales obtenidos por busqueda de tipo:
	 * 			{@link LocalResponse} 
	 */
	@GetMapping
//	@PreAuthorize("hasPermission('MAN_LOCAL','101')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
	public List<LocalResponse> buscarTodos() {
		return localService.buscarTodos();
	}
	
	/**
	 * Retorna una lista con todos los locales segun el documento del perfil
	 * 
	 * @return lista de locales obtenidos por busqueda de tipo:
	 * 			{@link LocalResponse} 
	 */
	@GetMapping("/documento/{numeroDocumento}")
	@PreAuthorize("hasPermission('MAN_LOCAL','102')")
	public List<LocalResponse> buscarPorDocumento(@PathVariable("numeroDocumento") String numeroDocumento) {
		return localService.buscarPorDocumento(numeroDocumento);
	}

	/**
	 * Retorna un local buscado por atributo:
	 * @param codigoLocal
	 * 				el codigo del local a buscar
	 * @param --
	 * 
	 * @return local obtenido por busqueda:
	 * 				{@link LocalResponse}
	 */
	@GetMapping("/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_LOCAL','103')")
	public LocalResponse buscarPorCodigoLocal(@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal) {
		return localService.buscarPorId(codigoLocal);
	}
	
	/**
	 * Retorna una lista con todos los locales pertenecientes a un grupoLocal
	 * @param idGrupoLocal 
	 * @return lista de locales obtenidos por busqueda de tipo 
	 * 				{@link LocalResponse}
	 */
	@GetMapping("/grupo-local/{idGrupoLocal}")
	@PreAuthorize("hasPermission('MAN_LOCAL','104')")
	public List<LocalResponse> buscarPorGrupoLocal(@PathVariable("idGrupoLocal")Integer idGrupoLocal){
		return localService.buscarPorGrupoLocal(idGrupoLocal);
	}
	
	/**
	 * Recibe peticion de registro de un local.  
	 * @param localRequest
	 * 			el local a registrar
	 * @param error
	 * 			almacena los mensajes de error obtenidos del proceso de 
	 * 			validación del parámetro <b>local</b>
	 * 			{@literal @Validated}
	 * @return	local registrado
	 * 			{@link LocalResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_LOCAL','201')")
	public LocalResponse registrarLocal(@Valid @RequestBody LocalRequest localRequest) {
		return localService.registrarLocal(localRequest);
	}
	
	/**
	 * Recibe peticion de actualización de un local.  
	 * @param codigoLocal
	 * 			el codigo del local a actualizar
	 * @param local
	 * 			el local a actualizar
	 * @param error
	 * 			almacena los mensajes de error obtenidos del proceso de 
	 * 			validación del parámetro <b>local</b>
	 * 			{@literal @Validated}
	 * @return	local registrado
	 * 			{@link LocalResponse}
	 */
	@PutMapping("/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_LOCAL','301')")
	public LocalResponse actualizarLocal(@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal, 
										@Valid @RequestBody LocalRequest localRequest) {
		return localService.actualizarLocal(codigoLocal, localRequest);
	}

	/**
	 * Recibe peticion para eliminar un local
	 * 
	 * @param codigo
	 * 			el codigo del Local a eliminar
	 */
	
	@DeleteMapping("/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_LOCAL','401')")
	public void eliminarLocal(@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal) {
		localService.eliminarLocal(LocalRequest.builder().codigoLocal(codigoLocal).build());
	}
}
