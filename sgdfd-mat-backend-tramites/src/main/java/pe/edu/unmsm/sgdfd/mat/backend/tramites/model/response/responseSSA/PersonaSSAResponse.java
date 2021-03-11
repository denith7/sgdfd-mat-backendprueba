package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.responseSSA;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaSSAResponse {

	private String  	tipoDocumento;	
	private String 		numeroDocumento;	
	private String 		codigo;
	private String  	nombres;
	private String  	apellidoPaterno;	
	private String 		apellidoMaterno;	
	private String 		sexo;
	private String 		direccionDomicilio;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate 	fechaNacimiento;
	private String 		celular;
	private String 		telefono;
	private String 		correoReferencia;
	private String 		codigoUbigeo;
	private String 		username;
	private String 		contrasenia;
}
