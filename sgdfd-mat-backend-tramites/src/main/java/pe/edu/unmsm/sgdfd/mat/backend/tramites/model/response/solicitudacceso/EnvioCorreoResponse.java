package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.solicitudacceso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnvioCorreoResponse {

	private boolean confirmacionEnvio;
}
