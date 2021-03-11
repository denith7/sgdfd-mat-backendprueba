package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest;

import javax.validation.groups.Default;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.group.IRegistro;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.DestinoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.expediente.GeneracionExpedienteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.DestinoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.expediente.GeneracionExpedienteResumenResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.destino.DestinoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.expediente.ExpedienteService;

/**
 * --
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Generar Expediente
 * </ul>
 * 
 * @author Sergio de la Torre
 * @see DestinoRequest
 * @see DestinoResponse
 * @see DestinoService
 */
@Validated
@RestController
@RequestMapping("/expedientes")
public class ExpedienteRestController {
	
	private @Autowired ExpedienteService expedienteService;

	
	/**
	 * Generar expediente en el SGD
	 * @param ger
	 * 			datos del expediente a generar
	 * @return	datos del expediente generado
	 * 			{@link GeneracionExpedienteResumenResponse} 
	 * @throws NotFoundException 
	 */
	@PostMapping("/generar")
	@PreAuthorize("hasPermission('PRO_EXPEDIENTE','501')")
	public GeneracionExpedienteResumenResponse generarReporteFutPorCodigoYDni (
			@Validated({ IRegistro.class, Default.class }) @RequestBody GeneracionExpedienteRequest ger
			) {
//		System.out.println("Authorization:"+authorization);
//		String token= authorization.substring(authorization.indexOf("Bearer")+7,authorization.length());
//		System.out.println("token:"+token);
//		return null;
//		GeneracionExpedienteResumenResponse geresp=expedienteService.generarExpediente(ger);
//		 if (geresp == null) {
//		        throw new NullPointerException("Error al derivar. Null pointer exception");
//
//		 }
        return expedienteService.generarExpediente(ger);
        
    }

}
