package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;


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
public class EmpleadoDependenciaRequest {
	
	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,20}", maxLength = 20 )
	private String codigoEmpleado;
	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 )
	private String codigoDependencia;
	@Size(min = 1, max = 200)
	private String tituloDependencia;
	@Size(min = 1, max = 163)
	private String nombreEmpleado;
	@Size(min = 1, max = 2)
	private String estado;
	@Size(min = 1, max = 100)
	private String estadoDescripcion;
	@Size(min = 1, max = 20)
	private String usuario;
}
