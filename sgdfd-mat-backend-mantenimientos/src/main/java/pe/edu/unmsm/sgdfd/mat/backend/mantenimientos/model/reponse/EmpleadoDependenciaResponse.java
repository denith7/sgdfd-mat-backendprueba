package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDependenciaResponse {
	
	private String codigoEmpleado;
	private String codigoDependencia;
	private String tituloDependencia;
	private String nombreEmpleado;
	private String estado;
	private String estadoDescripcion;
	private String usuario;
}
