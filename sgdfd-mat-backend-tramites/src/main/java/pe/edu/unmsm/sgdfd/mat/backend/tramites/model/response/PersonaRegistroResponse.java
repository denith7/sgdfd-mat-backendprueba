package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response;

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
public class PersonaRegistroResponse {
	
	private String  	idItem;	
	private String  	tipoDocumento;	
	private String 		numeroDocumento;	
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
	private String 		codigoAlumno;
	private String 		ubigeoPersona;
	private String 		username;
	private String 		contrasenia;
	private String 		tipoUsuario;
	private String 		ruc;
	private String 		razonSocial;
	private String 		direccionEmpresa;
	private String 		contactoRepresentante;
	private String 		ubigeoEmpresa;
	private String 		estado;
	private String		departamentoPersona;
	private String 		provinciaPersona;
	private String 		distritoPersona;
	private String		departamentoEmpresa;
	private String		provinciaEmpresa;
	private String		distritoEmpresa;
	private String		descripcionSexo;
	private String		descripcionDocumento;
    private String		descripcionTipoUsuario;	
}
