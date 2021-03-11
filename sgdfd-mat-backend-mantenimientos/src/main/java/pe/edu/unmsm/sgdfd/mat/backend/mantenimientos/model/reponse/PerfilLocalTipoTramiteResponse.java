package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerfilLocalTipoTramiteResponse {

	private Integer idPerfil;
	private String codigoLocal;
	private Integer idTipoTramite;
	private String usuario;
	private String nombrePerfil;
	private String nombreLocal;
	private String nombreTipoTramite;
}
