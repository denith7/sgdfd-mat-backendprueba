package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest.tramites.rectificacion;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.RectificacionMatriculaDetalleResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramites.rectificacion.rectificacionmatriculadet.RectificacionMatriculaDetalleService;

@Validated
@RestController
@RequestMapping("/rectificacion-matricula-det")
public class RectificacionMatriculaDetRestController {
	
	@Autowired
	private RectificacionMatriculaDetalleService rectificacionMatriculaDetalleService;
	
	@GetMapping
    public List<RectificacionMatriculaDetalleResponse> buscarTodos()
    {
        return rectificacionMatriculaDetalleService.buscarTodos();
    }
	
}
