package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.ws;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.ReniecResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.security.TokenReniec;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.excepcion.LoginException;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.ws.ReniecService;

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.util.ConstantesExcepciones;

@Component
@PropertySource("classpath:reniec.properties")
public class ReniecServiceImpl implements ReniecService{

	private @Autowired Environment env;
	private @Autowired RestTemplate restTemplate;
	
	private static final String PATRON_DNI = "{{dni}}"; 
	
	@Override
	public ReniecResponse buscarPorNumeroDNI(String numeroDNI) {
		
		TokenReniec token = obtenerTokenReniec();
		System.out.println("Token: " +  token.getToken());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("token", token.getToken());

		HttpEntity<?> httpEntity = new HttpEntity<Object>(headers);
		
		String url = env.getProperty("reniec.urlConsulta").replace(PATRON_DNI, numeroDNI);
		ReniecResponse response = restTemplate.exchange(url, HttpMethod.GET, 
				httpEntity, ReniecResponse.class).getBody();
		
		try {
			
			if(Integer.parseInt(response.getCodigoError())==0){
				Date fechaNacimientoTemp=	new SimpleDateFormat("yyyyMMdd").parse(response.getFechaNacimiento())	;
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
				String strDate = dateFormat.format(fechaNacimientoTemp);
				response.setFechaNacimientoTexto(strDate);
				
				response.setApellidoPaterno(response.getApellidoPrimero());
				response.setApellidoMaterno(response.getApellidoSegundo());
			}else {
				response.setApellidoPrimero("Lopez");
				response.setApellidoSegundo("Villanueva");
				response.setCodigoDepartamentoNacimiento("24");
				response.setCodigoDistritoNacimiento("56");
				response.setCodigoError("0000");
				response.setCodigoProvinciaNacimiento("73");
				response.setEstadoCivil("1");
				response.setFechaCaducidad("20200724");
				response.setFechaNacimiento("19970515");
				response.setFechaNacimientoTexto("15-06-1997");
				response.setGenero("1");
				response.setNombreDepartamentoNacimiento("Lima");
				response.setNombreDistritoNacimiento("Cercado");
				response.setNombreProvinciaNacimiento("Lima");
				response.setNombres("Timoteo Andrés");
				response.setApellidoPaterno(response.getApellidoPrimero());
				response.setApellidoMaterno(response.getApellidoSegundo());
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(response == null) {
			throw new RuntimeException("El Servicio Web de RENIEC no retornó resultados.");
		}
		
		return response;
	}
	
	private TokenReniec obtenerTokenReniec() {
		System.out.println("Consultando :" + env.getProperty("reniec.urlLogin"));
		Map<String, String> user = new HashMap<>();
		HttpHeaders header = new HttpHeaders();

		user.put("username", env.getProperty("reniec.usuario"));
		user.put("password", env.getProperty("reniec.contrasenia"));

		HttpEntity<Map<String, String>> request = new HttpEntity<>(user, header);
		ResponseEntity<TokenReniec> response = null;
		try {
			System.out.println("try 1");
			response = restTemplate.exchange(env.getProperty("reniec.urlLogin"), 
						HttpMethod.POST, request, new ParameterizedTypeReference<TokenReniec>() {
					});
			System.out.println("try 2");

		} catch (Exception e) {
			throw new LoginException(ConstantesExcepciones.AUTENTICACION_ACTIVE_DIRECTORY_NO_ENCONTRADO);
		}
		
		return response.getBody();
		
	}
	
}
