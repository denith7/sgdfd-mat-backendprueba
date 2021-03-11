package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RankingTipoTramiteFilter {

	private Integer mesInicio;
	private Integer mesFin;
	private Integer anioInicio;
	private Integer anioFin;
	private String codigoLocal;
	private Integer idTipoTramite;
}
