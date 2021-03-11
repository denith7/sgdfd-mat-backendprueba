package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {
	private String codigoAlumno;
	private String idUsuario;
	private Integer idPerfil;
	private String nombrePerfil;
	private String contrasenia;
	private String sexo;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer idFacultad;
	private Integer idEscuela;
	private Integer codigoPlan;
}
