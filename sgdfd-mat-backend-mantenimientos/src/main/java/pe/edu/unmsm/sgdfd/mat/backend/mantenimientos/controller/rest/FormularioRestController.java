package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.group.IRegistro;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.FormularioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoFormularioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.FormularioRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.formulario.FormularioService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de Formularios
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los formularios
 * 	<li>Búsqueda de un formulario por identificador de requisito
 * 	<li>Registro de un formulario
 * 	<li>Actualización de un formulario
 * 	<li>Eliminación	de un formulario
 * </ul>
 * 
 * @author Eric Robladillo
 * @see FormularioRequest
 * @see FormularioResponse
 * @see FormularioService
 */
@Validated
@RestController
@RequestMapping("/formulario")
public class FormularioRestController {
	
	private @Autowired FormularioService formularioService;
	
	/**
	 * Retorna una lista con todos los formularios.  
	 * 
	 * @return	lista de formularios obtenida por búsqueda es de tipo:
	 * 			{@link FormularioResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_FORMULARIO','101')")
    public List<FormularioResponse> buscarTodos(){
        return formularioService.buscarTodos();
    }
	
	/**
	 * Muestra una lista de formularios buscada por atributo:  
	 * @param idRequisito
	 * 			el identificador del requisito presente en los formularios a buscar			
	 * @param --
	 * @return	lista de requisitos de formulario obtenidos por búsqueda es de tipo:
	 * 			{@link RequisitoFormularioResponse}
	 */
	@GetMapping(value = "/requisito/{idRequisito}")
	@PreAuthorize("hasPermission('MAN_FORMULARIO','102')")
	    //@Secured({JWTConstants.ROLE_USER})
	public List<RequisitoFormularioResponse> buscarPorRequisito(@PathVariable Integer idRequisito){
		return formularioService.buscarPorRequisito(idRequisito);
	}
	
	/**
	 * Recibe petición de registro de un formulario.  
	 * @param formularioRequest
	 * 			el formulario a registrar
	 * @param --
	 * @return	formulario registrado
	 * 			{@link FormularioResponse}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_FORMULARIO','201')")
    public FormularioResponse registrarFormulario(
            @Validated({ IRegistro.class, Default.class }) @RequestBody FormularioRequest formularioRequest,
            Errors error){      
        return formularioService.registrarFormulario(formularioRequest);
    }

	/**
	 * Recibe petición de actualización de un formulario.  
	 * @param idFormulario
	 * 			el identificador del formulario a actualizar
	 * @param formularioRequest
	 * 			el formulario a actualizar
	 * @param --
	 * @return	formulario actualizado
	 * 			{@link FormularioResponse}
	 */
    @PutMapping("/{idFormulario}")
    @PreAuthorize("hasPermission('MAN_FORMULARIO','301')")
    public FormularioResponse actualizarFormulario( 
    				  @PathVariable("idFormulario") Integer idFormulario
    				, @RequestBody FormularioRequest formularioRequest){
        return formularioService.actualizarFormulario(idFormulario, formularioRequest);
    }
    
    /**
	 * Recibe petición de eliminación de un formulario.  
	 * @param idFormulario
	 * 			el identificador del formulario a eliminar
	 * @param --
	 * 		
	 */
    @DeleteMapping("/{idFormulario}")
    @PreAuthorize("hasPermission('MAN_FORMULARIO','401')")
    public void eliminarFormulario(@PathVariable("idFormulario") Integer codigo){
        formularioService.eliminarFormulario(FormularioRequest.builder().idFormulario(codigo).build());
    }
	
	
	/* Para validaciones 
	 * 
	 *  @IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idCadena
	 * */
}
