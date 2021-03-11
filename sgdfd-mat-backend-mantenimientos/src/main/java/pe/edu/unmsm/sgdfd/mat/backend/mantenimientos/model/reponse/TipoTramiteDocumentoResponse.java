package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTramiteDocumentoResponse {

	private Integer idTipoTramite;
	private String nombreTipoTramite;
	private String idTipoDocumento;
	private String descripcionTipoDocumento;
}
