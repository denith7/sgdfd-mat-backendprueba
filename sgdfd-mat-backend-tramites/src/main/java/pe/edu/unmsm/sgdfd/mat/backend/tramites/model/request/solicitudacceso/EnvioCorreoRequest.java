package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.solicitudacceso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnvioCorreoRequest {

	private String tipoDocumento;
	private String numeroDocumento;
	private String idItem;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String mensaje;

}
