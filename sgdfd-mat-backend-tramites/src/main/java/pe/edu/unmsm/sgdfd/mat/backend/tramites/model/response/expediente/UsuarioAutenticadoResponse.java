package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.expediente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAutenticadoResponse {
	private String token;
}
