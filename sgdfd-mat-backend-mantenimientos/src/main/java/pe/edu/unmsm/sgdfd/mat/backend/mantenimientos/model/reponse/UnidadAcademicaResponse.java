package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnidadAcademicaResponse {

	private String  codigoLocal;
	private String 	nombreLocal;
	private Integer codigoUnidadAcademica;
	private String  nombre;
	private String  descripcion;
	private String  sigla;
	private String  usuario;
	
}
