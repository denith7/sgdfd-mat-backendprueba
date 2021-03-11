package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.IdCadena;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaRequest {
	
	@PositiveOrZero(message = "Debe ser positivo")
	private String anioCicloEstudio;
	@PositiveOrZero(message = "Debe ser positivo")
	private String anioIngreso;
	@Size(min = 1, max = 30)
	private String apellidoMaterno;
	@Size(min = 1, max = 30)
	private String apellidoPaterno;
	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,8}", maxLength = 8 )
	private String codigoAlumno;
	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,3}", maxLength = 3)
	private String codigoEscuela;
	@Size(min = 1, max = 250)
	private String codigoEspecialidad;
	@PositiveOrZero(message = "Debe ser positivo")
	private String codigoFacultad;
	@Size(min = 1, max = 6)
	private String codigoPlan;
	@Size(min = 1, max = 40)
	private String correoInstitucional;
	@Size(min = 1, max = 50)
	private String correoPersonal;
	@Size(min = 1, max = 120)
	private String direccionDomicilio;
	@Size(min = 1, max = 4000)
	private String epCompletaMayus;
	@Size(min = 1, max = 250)
	private String escuelaProfesional;
	@Size(min = 1, max = 4000)
	private String escuelaProfesionalCompleta;
	@Size(min = 1, max = 250)
	private String escuelaProfesionalMayus;
	@Size(min = 1, max = 150)
	private String especialidad;
	@Size(min = 1, max = 30)
	private String estadoCivil;
	@Size(min = 1, max = 4)
	private String estadoPermanencia;
	private String fechaNacimiento;
	@Size(min = 1, max = 4)
	private String modalidadIngreso;
	@Size(min = 1, max = 40)
	private String nombres;
	@Size(min = 1, max = 20)
	private String numeroCelular;
	@Size(min = 1, max = 12)
	private String numeroDocumento;
	@Size(min = 1, max = 20)
	private String numeroTelefono;
	@Size(min = 1, max = 6)
	private String plan;
	private String promedioPonderado;
	private String promedioUltimaMatricula;
	@Size(min = 1, max = 2)
	private String sexo;
	@Size(min = 1, max = 4)
	private String situacionAcademica;
	@Size(min = 1, max = 4)
	private String tipoDocumento;
	@Size(min = 1, max = 6)
	private String ubigeo;
	@Size(min = 1, max = 5)
	private String ultimaMatricula;
	
	
	
	
	
	
}
