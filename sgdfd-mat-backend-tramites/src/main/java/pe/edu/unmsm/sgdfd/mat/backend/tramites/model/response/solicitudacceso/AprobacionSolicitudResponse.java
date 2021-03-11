package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.solicitudacceso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AprobacionSolicitudResponse {

	private String username;
	private String contrasenia;
	private String tipoUsuario;
	private String tipoDocumento;
	private String numeroDocumento;
	private String codigo;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String sexo;
	private String usuario;
	private String idSistema;
	private String idPerfil;
}
