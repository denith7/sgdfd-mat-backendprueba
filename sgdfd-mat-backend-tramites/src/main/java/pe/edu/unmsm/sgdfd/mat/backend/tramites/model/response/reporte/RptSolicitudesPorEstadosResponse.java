package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RptSolicitudesPorEstadosResponse {
	
	private String codigoLocal;
	private String nombreLocal;
	private Integer solicitudesPorAtender;
	private Integer solicitudesObservadas;
	private Integer solicitudesDerivadas;

}
