package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDepLocalResponse {

	private String codigoEmpleado;
	private String codigoDependencia;
	private String tituloDependencia;
	private String codigoLocal;
	private String codigoLocalSgd;
	private String nombreLocal;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	private String nombreCompleto;
	private String sexo;
	private String numeroDni;
	private String estado;
	private LocalDate fechaBaja;
	private String codigoCargo;

}
