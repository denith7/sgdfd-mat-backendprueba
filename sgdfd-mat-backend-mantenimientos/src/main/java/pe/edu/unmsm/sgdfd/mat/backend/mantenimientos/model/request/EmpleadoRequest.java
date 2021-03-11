package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import java.time.LocalDate;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.IdCadena;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoRequest {
	
	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,20}", maxLength = 20 )
	private String codigoEmpleado;
	@Size(min = 1, max = 40)
	private String apellidoPaterno;
	@Size(min = 1, max = 40)
	private String apellidoMaterno;
	@Size(min = 1, max = 80)
	private String nombres;
	@Size(min = 1, max = 1)
	private String sexo;
	@Size(min = 1, max = 8)
	private String numeroDni;
	@Size(min = 1, max = 1)
	private String estado;
	@Size(min = 1, max = 100)
	private String descripcionEstado;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate fechaBaja;
	@Size(min = 1, max = 4)
	private String codigoCargo;
	@Size(min = 1, max = 200)
	private String descripcionCargo;
	@Size(min = 1, max = 163)
	private String nombreCompleto;
	@Size(min = 1, max = 20)
	private String usuario;
}
