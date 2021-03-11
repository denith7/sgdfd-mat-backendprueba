package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.CaracterRequerido;
import pe.edu.unmsm.commons.validation.validation.IdNumerico;
import pe.edu.unmsm.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerfilResponse {
	
	private Integer idPerfil;
	private String 	nombre;
	private String 	descripcion;
	private String  usuario;

}
