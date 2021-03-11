package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonasRegistradasResponse {

	private String codigoAlumno;
	private String tipoDocumentoId;
	private String numeroDocumento;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correoPersonal;
	private String codigoEscuela;
	private String correoInstitucional;
	private String direccionDomicilio;
	private String numeroCelular;
	private String numeroTelefono;
	private String facultad;
	private String escuelaProfesional;
	private String especialidad;
	private String codigoEspecialidad;
}
