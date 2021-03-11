package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DependenciaResponse {
	
	private String codigoDependencia;
	private String codigoLocal;
	private String titulo;
	private String descripcionCorta;
	private String sigla;
	private String codigoNivel;
	private String codigoDependenciaPadre;
	private String codigoEmpleadoTitular;
	private String codigoCargo;
	private String descripcionCargoCompleto;
	private String codigoLocalSgd;
	private String tituloDependenciaPadre;
	private String nombreEmpleado;
	private String nombreLocal;
	private String usuario;
	
}
