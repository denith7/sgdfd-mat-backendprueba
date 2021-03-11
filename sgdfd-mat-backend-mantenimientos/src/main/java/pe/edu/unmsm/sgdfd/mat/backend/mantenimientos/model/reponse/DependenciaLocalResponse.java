package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DependenciaLocalResponse {

	private String codigoDependencia;
	private String codigoLocal;
	private String tituloDependencia;
	private String nombreLocal;
	private String estado;
	private String estadoDescripcion;
	private String usuario;

}
