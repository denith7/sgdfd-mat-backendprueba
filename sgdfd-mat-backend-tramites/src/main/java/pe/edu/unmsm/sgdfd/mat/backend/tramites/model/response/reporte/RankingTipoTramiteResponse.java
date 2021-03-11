package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RankingTipoTramiteResponse {

	private String periodo;
	private String periodoDescriptivo;
	private Integer solicitudesDerivadas;
	private Integer solicitudesPresentadas;
}
