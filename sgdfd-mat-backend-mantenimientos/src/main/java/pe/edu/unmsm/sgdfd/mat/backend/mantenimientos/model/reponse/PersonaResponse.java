package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaResponse {
	
	private String anioCicloEstudio;
	private String anioIngreso;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String codigoAlumno;
	private String codigoEscuela;
	private String codigoEspecialidad;
	private String codigoFacultad;
	private String codigoPlan;
	private String correoInstitucional;
	private String correoPersonal;
	private String direccionDomicilio;
	private String epCompletaMayus;
	private String escuelaProfesional;
	private String escuelaProfesionalCompleta;
	private String escuelaProfesionalMayus;
	private String especialidad;
	private String estadoCivil;
	private String estadoPermanencia;
	private String fechaNacimiento;
	private String modalidadIngreso;
	private String nombres;
	private String numeroCelular;
	private String numeroDocumento;
	private String numeroTelefono;
	private String plan;
	private String promedioPonderado;
	private String promedioUltimaMatricula;
	private String sexo;
	private String situacionAcademica;
	private String tipoDocumento;
	private String ubigeo;
	private String ultimaMatricula;
	
	private String facultad;
	private String departamentoAcademico;
	private String idPerfil;
	private String descripcionPerfil;
	
	
	
	
}
