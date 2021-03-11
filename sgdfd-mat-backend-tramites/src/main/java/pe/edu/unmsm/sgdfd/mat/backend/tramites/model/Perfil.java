package pe.edu.unmsm.sgdfd.mat.backend.tramites.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {

	private String idPerfil;
	private String idSistema;
}
