package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoResponse {
	
	private String codigoEmpleado;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	private String sexo;
	private String numeroDni;
	private String estado;
	private String descripcionEstado;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate fechaBaja;
	private String codigoCargo;
	private String descripcionCargo;
	private String nombreCompleto;
	private String usuario;
}
