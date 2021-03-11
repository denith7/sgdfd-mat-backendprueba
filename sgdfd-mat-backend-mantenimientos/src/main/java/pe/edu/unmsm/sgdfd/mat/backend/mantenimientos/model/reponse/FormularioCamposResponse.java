package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormularioCamposResponse {
	
		private Integer idFormulario;
		private Integer idCampo;
		private String nombreCampo;
		private String tipoDato;
		private String descripcion;
		private String descripcionCorta;
		private Integer longitud;
		private Integer precision;
		private Integer obligatorio;
		private String placeholder;
}
