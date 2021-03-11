package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

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
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.FormularioCamposResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.FormularioCamposRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.formulario.campo.FormularioCampoService;

/**
 * Recibe las solicitudes relacionadas al mantenimiento de campos de formulario
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los campos de formulario
 * 	<li>Búsqueda de una lista de campos de formulario por identificador de formulario
 * 	<li>Registro de un campo de formulario
 * 	<li>Actualización de un campo de formulario
 * 	<li>Eliminación	de un campo de formulario
 * </ul>
 * 
 * @author Miguel Moya
 * @author Eric Robladillo
 * @see FormularioCamposRequest
 * @see FormularioCamposResponse
 * @see FormularioCampoService
 */
@Validated
@RestController
@RequestMapping("/formularioCampos")
public class FormularioCamposRestController {

	private FormularioCampoService formularioCamposService;
	
	/**
	 * Retorna una lista con todos los campos de todos los formularios.  
	 * 
	 * @return	lista de campos de formularios obtenida por búsqueda es de tipo:
	 * 			{@link FormularioCamposResponse}
	 */
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_FORMULARIO_CAMPO','101')")
    public List<FormularioCamposResponse> buscarTodos(){
        return formularioCamposService.buscarTodos();
    }
	
	/**
	 * Retorna una lista de campos de formularios buscada por:  
	 * @param idFormulario
	 * 			el identificador del formulario al que pertenecen los campos
	 * @param --
	 * @return	lista de campos de un formulario obtenida por búsqueda es de tipo:
	 * 			{@link FormularioCamposResponse}
	 */
	@GetMapping(value = "/formulario/{idFormulario}")
	@PreAuthorize("hasPermission('MAN_FORMULARIO_CAMPO','102')")
    //@Secured({JWTConstants.ROLE_USER})
    public List<FormularioCamposResponse> buscarPorIdFormulario(@PathVariable Integer idFormulario){
		return formularioCamposService.buscarPorIdFormulario(idFormulario);
    }
	
	/**
	 * Recibe petición de registro de un campo para formulario.  
	 * @param formularioCamposRequest
	 * 			el campo de formulario a registrar
	 * @param --
	 * @return	campo de formulario registrado
	 * 			{@link FormularioCamposRequest}
	 */
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_FORMULARIO_CAMPO','201')")
    public FormularioCamposRequest registrarFormularioCampos(
            @Validated({ IRegistro.class, Default.class }) @RequestBody FormularioCamposRequest formularioCamposRequest,
            Errors error){      
        return formularioCamposService.registrarFormularioCampos(formularioCamposRequest);
    }

	/**
	 * Recibe petición de actualización de un campo de formulario.  
	 * @param idCampo
	 * 			el identificador del campo de formulario
	 * @param formularioCamposRequest
	 * 			el campo de un formulario a actualizar
	 * @param --
	 * @return	campo de formulario actualizado
	 * 			{@link --}
	 */
    @PutMapping("/{idCampo}")
    @PreAuthorize("hasPermission('MAN_FORMULARIO_CAMPO','301')")
    public FormularioCamposRequest actualizarFormularioCampos( 
    				  @PathVariable("idCampo") Integer idCampo
    				, @RequestBody FormularioCamposRequest formularioCamposRequest){        
        return formularioCamposService.actualizarFormularioCampos(idCampo, formularioCamposRequest);
    }
    
    /**
	 * Recibe petición de eliminación de un campo de formulario.  
	 * @param idCampo
	 * 			el identificador del campo de formulario
	 * @param --
	 */
    @DeleteMapping("/{idCampo}")
    @PreAuthorize("hasPermission('MAN_FORMULARIO_CAMPO','401')")
    public void eliminarFormularioCampos(@PathVariable("idCampo") Integer codigo){
    	formularioCamposService.eliminarFormularioCampos(FormularioCamposRequest.builder().idCampo(codigo).build());
    }
	
}
