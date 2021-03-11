package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest.tramites.rectificacion;



import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.IdNumerico;
import pe.edu.unmsm.commons.validation.validation.group.IRegistro;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion.SolicitudRectificacionDetalleRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.tramites.rectificacion.solicitudrectificaciondetalle.SolicitudRectificacionDetalleService;

@Validated
@RestController
@RequestMapping("/solicitud-rectificacion-detalle")
public class SolicitudRectificacionDetalleRestController {
	
	@Autowired
	private SolicitudRectificacionDetalleService solicitudRectificacionDetalleService;
	
	
	
    @PutMapping("/{idRectificacionDetalle}")
    public SolicitudRectificacionDetalleRequest actualizarSolicitudTramite(
              @Validated({ IRegistro.class, Default.class }) @RequestBody SolicitudRectificacionDetalleRequest solicitud
            , @IdNumerico(maxRange = 9999999999L)@PathVariable("idRectificacionDetalle") Integer idRectificacionDetalle){
        return solicitudRectificacionDetalleService.actualizarSolicitudRectificacionDetalle(idRectificacionDetalle,solicitud);
    }
	
	@PutMapping("/{idDetalleTramite}/proceso-ejecucion")
	@ResponseStatus(code = HttpStatus.OK)
    public void procesarEjecucionRectificacionDetalle(
    		  @IdNumerico(maxRange = 9999999999L)@PathVariable("idDetalleTramite") Integer idDetalleTramite 
    		, @Validated({ IRegistro.class, Default.class })@RequestBody SolicitudRectificacionDetalleRequest procesoSolicitudTramite)
    {
		solicitudRectificacionDetalleService.procesarEjecucionSolicitudRectificacionDetalle(idDetalleTramite, procesoSolicitudTramite);
    }
	@PutMapping("/{idDetalleTramite}/proceso-resultado")
	@ResponseStatus(code = HttpStatus.OK)
    public void procesarResultadoRectificacionDetalle(
    		  @IdNumerico(maxRange = 9999999999L)@PathVariable("idDetalleTramite") Integer idDetalleTramite 
    		, @Validated({ IRegistro.class, Default.class })@RequestBody SolicitudRectificacionDetalleRequest procesoSolicitudTramite)
    {
		solicitudRectificacionDetalleService.procesarResultadoSolicitudRectificacionDetalle(idDetalleTramite, procesoSolicitudTramite);
    }
	
	
}
