package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.rectificacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcesoRectificacionFilter {
	private String codigoLocal;
	private String semestreAcademico;
	private String estado;
}
