package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpedientEmiResponse {

	private String codigoProceso;
	private String observacionTramite;
}
