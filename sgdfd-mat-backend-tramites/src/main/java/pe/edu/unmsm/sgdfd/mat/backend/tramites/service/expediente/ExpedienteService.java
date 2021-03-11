package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.expediente;

import java.io.IOException;

import org.springframework.boot.configurationprocessor.json.JSONException;

import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta.SolicitudTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.expediente.GeneracionExpedienteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.expediente.GeneracionExpedienteResumenResponse;

/**
 * Define los métodos asociados a las operaciones de derivación
 * de solicitudes al SGD para generar un expediente
 * <p>
 * 
 * @author Sergio de la Torre
 * @see GeneracionExpedienteRequest
 * @see SolicitudTramiteResponse
 */
public interface ExpedienteService {
	
	/**
	 * Genera el expediente en el SGD y retorna 
	 * su número de expediente,
	 * @param ger
	 * 			datos del expediente a generar
	 * @throws IOException 
	 */
    public GeneracionExpedienteResumenResponse generarExpediente(GeneracionExpedienteRequest ger);

}
