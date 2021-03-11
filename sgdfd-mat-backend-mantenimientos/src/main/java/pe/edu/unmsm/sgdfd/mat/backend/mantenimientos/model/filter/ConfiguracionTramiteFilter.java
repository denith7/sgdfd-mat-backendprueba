package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracionTramiteFilter {

	private Integer idTipoTramite;
	private String codigoLocal;
	private String estado;
}
