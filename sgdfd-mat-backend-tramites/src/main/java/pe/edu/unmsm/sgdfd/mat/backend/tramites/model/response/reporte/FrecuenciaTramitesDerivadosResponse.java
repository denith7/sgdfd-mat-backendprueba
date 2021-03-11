package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FrecuenciaTramitesDerivadosResponse {

	private String idTipoTramite;
	private String nombreTipoTramite;
	private Integer cantidadSolicitudes;
}
