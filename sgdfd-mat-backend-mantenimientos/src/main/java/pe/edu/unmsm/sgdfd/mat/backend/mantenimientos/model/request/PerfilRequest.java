package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.IdCadena;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerfilRequest {
	

	private Integer idPerfil;
	@Size(min = 1, max = 100)
	private String 	nombre;
	@Size(min = 1, max = 200)
	private String 	descripcion;
	@Size(min = 1, max = 20)
	private String  usuario;

}
