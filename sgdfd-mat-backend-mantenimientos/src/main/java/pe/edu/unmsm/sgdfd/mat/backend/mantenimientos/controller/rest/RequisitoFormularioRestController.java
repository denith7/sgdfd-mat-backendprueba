package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

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

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoFormularioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.RequisitoFormularioRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.requisito.formulario.RequisitoFormularioService;

@Validated
@RestController
@RequestMapping("/requisitoFormulario")
public class RequisitoFormularioRestController {
	
	private @Autowired RequisitoFormularioService requisitoFormularioService;
	
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_REQUISITO_FORMULARIO','101')")
    public List<RequisitoFormularioResponse> buscarFormulario(){
        return requisitoFormularioService.buscarTodos();
    }
	
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_REQUISITO_FORMULARIO','201')")
    public RequisitoFormularioRequest registrarRequisitoFormulario(
            @RequestBody RequisitoFormularioRequest requisitoFormularioRequest,
            Errors error){
        return requisitoFormularioService.registrarRequisitoFormulario(requisitoFormularioRequest);
    }

    @PutMapping("/requisito/{idRequisito}/formulario/{idFormulario}")
    @PreAuthorize("hasPermission('MAN_REQUISITO_FORMULARIO','301')")
    public RequisitoFormularioRequest actualizarRequisitoFormulario( 
    				  @PathVariable("idRequisito") Integer idRequisito
    				, @PathVariable("idFormulario") Integer idFormulario
    				, @RequestBody RequisitoFormularioRequest requisitoFormularioRequest)
    {
        
        return requisitoFormularioService.actualizarRequisitoFormulario(idRequisito, idFormulario, requisitoFormularioRequest);
    }
    
    @DeleteMapping("/requisito/{idRequisito}/formulario/{idFormulario}")
    @PreAuthorize("hasPermission('MAN_REQUISITO_FORMULARIO','401')")
    public void eliminarRequisitoFormulario(@PathVariable("idRequisito") Integer idRequisito, @PathVariable("idFormulario") Integer idFormulario){
    	requisitoFormularioService.eliminarRequisitoFormulario(RequisitoFormularioRequest.builder().idRequisito(idRequisito).idFormulario(idFormulario).build());
    }
}
