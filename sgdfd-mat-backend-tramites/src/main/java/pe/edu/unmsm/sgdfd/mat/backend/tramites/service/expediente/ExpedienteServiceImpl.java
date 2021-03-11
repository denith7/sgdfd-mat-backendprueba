package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.expediente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.DerivarSolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.expediente.GeneracionExpedienteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.expediente.UsuarioAutenticacionRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.expediente.GeneracionExpedienteResumenResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.expediente.UsuarioAutenticadoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramite.SolicitudTramiteService;
@Service
@Transactional
@PropertySource("classpath:sgd-api.properties")
public class ExpedienteServiceImpl implements ExpedienteService{
	
	private @Autowired Environment env;
	private @Autowired SolicitudTramiteService solicitudTramiteService;

	@Override
	@PreAuthorize("hasPermission('PRO_GEN_EXPEDIENTE','501')")
	@ResponseStatus(code = HttpStatus.CREATED)
	public GeneracionExpedienteResumenResponse generarExpediente(GeneracionExpedienteRequest ger)
		 {
		
		
		
			var urlAutenticacion=env.getProperty("url.autenticacion");
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Sistema-origen", env.getProperty("sistema_origen"));
			
			UsuarioAutenticacionRequest usuario = UsuarioAutenticacionRequest.builder()
												.username(env.getProperty("usuario"))
												.password(env.getProperty("contrasenia"))
												.build();
			HttpEntity<UsuarioAutenticacionRequest> request =  new HttpEntity<UsuarioAutenticacionRequest>(usuario, headers);
			UsuarioAutenticadoResponse uar = restTemplate.postForObject(urlAutenticacion, request, UsuarioAutenticadoResponse.class);
			
			var urlGenerarExpediente=env.getProperty("url.generar-expediente");

			RestTemplate restTemplate2 = new RestTemplate();
			HttpHeaders headers2 = new HttpHeaders();
			headers2.setContentType(MediaType.APPLICATION_JSON);
			headers2.setBearerAuth(uar.getToken());
			HttpEntity<GeneracionExpedienteRequest> request2 =  new HttpEntity<GeneracionExpedienteRequest>(ger, headers2);
			
			GeneracionExpedienteResumenResponse generacionExpedienteResumenResponse = restTemplate2.postForObject(urlGenerarExpediente, request2, GeneracionExpedienteResumenResponse.class);
			
			DerivarSolicitudTramiteRequest dstr= DerivarSolicitudTramiteRequest.builder()
													.estado("6")
													.numeroExpediente(generacionExpedienteResumenResponse.getNumeroExpediente())
													.usuario(ger.getUsuario())//Adaptarlo para registrar el usuario de sesión
													.build();
	        solicitudTramiteService.derivarSolicitudTramite(ger.getCodigoSolicitud(), dstr);

			 
			return generacionExpedienteResumenResponse;
		

		
	}

}
