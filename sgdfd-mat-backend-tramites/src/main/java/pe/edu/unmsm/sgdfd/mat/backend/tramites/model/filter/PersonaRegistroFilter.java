package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaRegistroFilter {

	private String numeroDocumento;
	private String correoInstitucional;
}
