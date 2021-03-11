package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest.tramites.rectificacion;


import java.util.List;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.IdCadena;
import pe.edu.unmsm.commons.validation.validation.IdNumerico;
import pe.edu.unmsm.commons.validation.validation.group.IRegistro;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.rectificacion.SolicitudRectificacionMatriculaFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.SolicitudRectificacionMatriculaRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion.SolicitudRectificacionMatriculaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramites.rectificacion.solicitudrectificacionmatricula.SolicitudRectificacionMatriculaService;

@Validated
@RestController
@RequestMapping("/solicitud-rectificacion-matricula")
public class SolicitudRectificacionMatriculaRestController {
	
	@Autowired
	private SolicitudRectificacionMatriculaService solicitudRectificacionMatriculaService;
	
	@GetMapping
	@PreAuthorize("hasPermission('CON_PROCESOS_RECTIFICACION','200')")
    public List<SolicitudRectificacionMatriculaResponse> buscarTodos()
    {
        return solicitudRectificacionMatriculaService.buscarTodos();
    }
	

	
	@GetMapping("/semestre/{semestre}/facultad/{codigoFacultad}")
    public List<SolicitudRectificacionMatriculaResponse> evaluacionRectificacionesPendientes(
    		@IdNumerico(maxRange = 99)@PathVariable("codigoFacultad") Integer codigoFacultad
    	   ,@IdCadena(minLength = 1, maxLength = 8)@PathVariable("semestre") String semestreAcademicoProceso
    		) {
        return solicitudRectificacionMatriculaService.buscarPorCriterio(
        		SolicitudRectificacionMatriculaFilter.builder()
				.codigoFacultad(codigoFacultad)
				.semestreAcademicoProceso(semestreAcademicoProceso)
				.ocultarCancelados(true)
				.build());
    }
		
	@GetMapping("/{idRectificacion}/alumno/{codigoAlumno}")
    public SolicitudRectificacionMatriculaResponse buscarPorId(
    		@IdNumerico(maxRange = 9999999999L)@PathVariable("idRectificacion") Integer idRectificacion
    	   ,@IdCadena(minLength = 1, maxLength = 8)@PathVariable("codigoAlumno") String codigoAlumno
    		) {
        return solicitudRectificacionMatriculaService.buscarPorCriterio(
        		SolicitudRectificacionMatriculaFilter.builder()
				.codigoAlumno(codigoAlumno)
				.idSolicitudRectificacionMatricula(idRectificacion)
				.build()).stream().findAny().orElse(null);
    }
	
	@GetMapping("/alumno/{codigoAlumno}")
	@PreAuthorize("hasPermission('CON_PROCESOS_RECTIFICACION','200')")
    public List<SolicitudRectificacionMatriculaResponse> buscarPorCodigoAlumno(
    		 @IdCadena(minLength = 1, maxLength = 10)@PathVariable("codigoAlumno") String codigoAlumno
    	//	,@IdNumerico(maxRange = 9999999999L)@PathVariable("idProcesoRectificacion") Integer idProcesoRectificacion
    		  ) {
		

        return solicitudRectificacionMatriculaService.buscarPorCriterio(
        		SolicitudRectificacionMatriculaFilter.builder()
				.codigoAlumno(codigoAlumno)
			//	.idProcesoRectificacion(idProcesoRectificacion)
				.build());
    }
	
	@GetMapping("/asignatura/{codigoAsignatura}/procesoRectificacion/{idProcesoRectificacion}")
    public List<SolicitudRectificacionMatriculaResponse> buscarPorCodigoAsignatura(
    		 @IdCadena(minLength = 1, maxLength = 8)@PathVariable("codigoAsignatura") String codigoAsignatura
    		  ) {
        return solicitudRectificacionMatriculaService.buscarPorCriterio(
        		SolicitudRectificacionMatriculaFilter.builder()
				.codigoCurso(codigoAsignatura)
				.build());
    }
	
	@PutMapping("{idSolicitudRectificacionMatricula}/proceso/")
    public void procesar(
    		 @IdNumerico(maxRange = 9999999999L)@PathVariable("idSolicitudRectificacionMatricula") Integer idSolicitudRectificacionMatricula
    		,@Validated({ IRegistro.class, Default.class })@RequestBody SolicitudRectificacionMatriculaRequest SolicitudRectificacionMatriculaRequest
    		  ) {
        solicitudRectificacionMatriculaService.procesarSolicitudRectificacion(idSolicitudRectificacionMatricula, SolicitudRectificacionMatriculaRequest);
    }
	
    @PostMapping
    public SolicitudRectificacionMatriculaRequest registrarSolicitudTramite(
            @Validated({ IRegistro.class, Default.class }) @RequestBody SolicitudRectificacionMatriculaRequest solicitud){
        return solicitudRectificacionMatriculaService.registrarSolicitudRectificacionConOperacion(solicitud);
    }
	
}
