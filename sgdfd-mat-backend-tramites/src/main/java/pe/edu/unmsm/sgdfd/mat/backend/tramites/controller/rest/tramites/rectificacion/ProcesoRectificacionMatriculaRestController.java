package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest.tramites.rectificacion;


import java.util.List;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.IdNumerico;
import pe.edu.unmsm.commons.validation.validation.group.IRegistro;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.ProcesoRectificacionRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.ProcesoRectificacionResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramites.rectificacion.procesorectificacion.ProcesoRectificacionService;

@Validated
@RestController
@RequestMapping("/proceso-rectificacion")
public class ProcesoRectificacionMatriculaRestController {
	
	@Autowired
	private ProcesoRectificacionService procesoRectificacionService;
	
	@GetMapping
    public List<ProcesoRectificacionResponse> buscarTodos(){
        return procesoRectificacionService.buscarTodos();
    }
	
	@GetMapping("/proceso-actual")
    public List<ProcesoRectificacionResponse> procesoActual(){
        return procesoRectificacionService.buscarTodos();
    }
	
	@GetMapping("/{idProcesoRectificacion}")
	//@Secured({JWTConstants.ROLE_USER})
    public ProcesoRectificacionResponse buscarPorId(
    		@IdNumerico(maxRange = 9999999999L)@PathVariable("idProcesoRectificacion") Integer idProcesoRectificacion) {
        return procesoRectificacionService.buscarPorId(idProcesoRectificacion);
    }

	
    @PostMapping
    public ProcesoRectificacionRequest registrarSolicitudTramite(
            @Validated({ IRegistro.class, Default.class }) @RequestBody ProcesoRectificacionRequest procesoRectificacion){
        return procesoRectificacionService.registrarProcesoRectificacion(procesoRectificacion);
    }
	
}
