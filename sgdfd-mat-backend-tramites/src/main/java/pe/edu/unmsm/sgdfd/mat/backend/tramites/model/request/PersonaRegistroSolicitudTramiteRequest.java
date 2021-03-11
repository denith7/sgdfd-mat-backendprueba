package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaRegistroSolicitudTramiteRequest 
{
	private String  	idPersonaRegistro;	
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
	private String		tipoExterno;
	
	private Integer idSolicitudTramite;
	private Integer idItem;
	private Date fechaSolicitud;
	private Date fechaAprobacion;
	private String tipoDocumentoIdentidad;
    private String numeroDocumentoIdentidad;
    private String asunto;
    private String justificacion;
    private String codigoLocal;
    private String codigoLocalSolicitante;
    private String estado;    
    private Integer tipoDocumentoRegistrado;
    private Integer idTipoTramite;
    private String  codigoSolicitante;
    private String  captcha;
	
    private String usuario;
	private List<SolicitudTramiteRequisitoRequest> lsSolicitudTramiteRequisito;
}