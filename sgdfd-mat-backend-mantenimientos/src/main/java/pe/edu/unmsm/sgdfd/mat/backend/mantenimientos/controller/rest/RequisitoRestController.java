package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.http.ResponseEntity;
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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.RequisitoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.requisito.RequisitoService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de Requisitos y 
 * busquedas que retornen listas de requisitos de acuerdo a diferentes atributos
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los requisitos
 * 	<li>Búsqueda de requisitos por identificador de requisito
 * 	<li>Registro de un requisito
 * 	<li>Actualización de un requisito
 * 	<li>Eliminación	 de un requisito
 *  <li>Búsqueda de una lista de requisitos por identificador de tipo de trámite
 *  <li>Búsqueda de una lista de requisitos por identificador de tipo de trámite y código de local
 * </ul>
 * 
 * @author Miguel Moya
 * @see RequisitoRequest
 * @see RequisitoResponse
 * @see RequisitoService
 */
@Validated
@RestController
@RequestMapping("/requisitos")
public class RequisitoRestController {
	
	private RequisitoService requisitoService;

	public RequisitoRestController(RequisitoService requisitoService) {
		this.requisitoService = requisitoService;
	}
	
	/**
	 * Muestra una lista con todos los requisitos.  
	 * 
	 * @return	lista de requisitos obtenida por búsqueda es de tipo:
	 * 			{@link RequisitoResponse}
	 */
	@GetMapping("/")
//	@PreAuthorize("hasPermission('MAN_REQUISITO','101')")
	//comentado para mantenimiento tramite
	//@Secured({JWTConstants.ROLE_USER})
    public List<RequisitoResponse> buscarTodos(){
        return requisitoService.buscarTodos();
    }
	
	/**
	 * Retorna un requisito buscado por atributo:  
	 * @param idRequisito
	 * 			el identificador del requisito
	 * @param --
	 * @return	requisito obtenido por búsqueda:
	 * 			{@link RequisitoResponse}
	 */
	@GetMapping("/{idRequisito}")
//	@PreAuthorize("hasPermission('MAN_REQUISITO','102')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
    public RequisitoResponse buscarPorIdRequisito(
    			@PathVariable @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idRequisito){
		return requisitoService.buscarPorIdRequisito(idRequisito);
    }
	
	/**
	 * Retorna una lista de requisitos buscada por atributo:  
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param --
	 * @return	lista de requisitos obtenida por búsqueda es de tipo:
	 * 			{@link RequisitoResponse}
	 */
    @GetMapping(value = "/tipo-tramite/{idTipoTramite}")
    @PreAuthorize("hasPermission('MAN_REQUISITO','103')")
    public List<RequisitoResponse> buscarPorIdTipoTramite(
    			@PathVariable @NotNull(message = "Name cannot be null")	String idTipoTramite){
		return requisitoService.buscarPorIdTipoTramite(idTipoTramite);
    }
    
    /**
	 * Retorna una lista de requisitos buscada por atributos:  
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param codigoLocal
	 * 			el código de tipo de local
	 * @param --
	 * @return	lista de requisitos obtenida por búsqueda es de tipo:
	 * 			{@link RequisitoResponse}
	 */
    @GetMapping(value = "/tipo-tramite/{idTipoTramite}/local/{codigoLocal}")
    @PreAuthorize("hasPermission('MAN_REQUISITO','104')")
// 	Requerido sin validación del token para funcionalidad de registro de usuarios externos
    public List<RequisitoResponse> buscarPorIdTipoTramiteYCodigoLocal(
    				@PathVariable @NotNull(message = "Name cannot be null") String idTipoTramite
    			  , @PathVariable @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoLocal){
		return requisitoService.buscarPorIdTipoTramiteYCodigoLocal(idTipoTramite,codigoLocal);
    }
	
	/**
	 * Recibe petición de registro de un requisito.  
	 * @param requisitoRequest
	 * 			el requisito a registrar
	 * @param --
	 * @return	requisito registrado
	 * 			{@link RequisitoResponse}
	 */
    @PostMapping("/")
    @PreAuthorize("hasPermission('MAN_REQUISITO','201')")
    public RequisitoResponse registrarRequisito(@Valid @RequestBody RequisitoRequest requisitoRequest){    
        return requisitoService.registrarRequisito(requisitoRequest);
    }
    
    /**
	 * Recibe petición de actualización de un requisito.  
	 * @param idRequisito
	 * 			el identificador del requisito
	 * @param requisitoRequest
	 * 			el requisito a actualizar
	 * @param --
	 * @return	requisito actualizado
	 * 			{@link RequisitoResponse}
	 */
    @PutMapping("/{idRequisito}")
    @PreAuthorize("hasPermission('MAN_REQUISITO','301')")
    public RequisitoResponse actualizarRequisito(
    		@PathVariable("idRequisito") @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo") Integer idRequisito
    	   ,@Valid @RequestBody RequisitoRequest requisitoRequest){
        return requisitoService.actualizarRequisito(idRequisito, requisitoRequest);
    }
    
    /**
	 * Recibe petición de eliminación de un requisito.  
	 * @param idRequisito
	 * 			el identificador del requisito a eliminar
	 * @param --
	 * 		
	 */
    @DeleteMapping("/{idRequisito}")
    @PreAuthorize("hasPermission('MAN_REQUISITO','401')")
    public ResponseEntity<Void> eliminarRequisito(
    			@PathVariable("idRequisito") @NotNull(message = "Name cannot be null") @PositiveOrZero(message = "Debe ser positivo")  Integer idRequisito){
        requisitoService.eliminarRequisito(RequisitoRequest.builder().idRequisito(idRequisito).build());
        return ResponseEntity.noContent().build();
    }
    
    
}
