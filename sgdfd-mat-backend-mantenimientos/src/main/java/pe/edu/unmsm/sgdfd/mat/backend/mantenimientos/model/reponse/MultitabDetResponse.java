package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.CaracterNoRequerido;
import pe.edu.unmsm.commons.validation.validation.CaracterRequerido;
import pe.edu.unmsm.commons.validation.validation.IdCadena;
import pe.edu.unmsm.commons.validation.validation.IdNumerico;
import pe.edu.unmsm.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultitabDetResponse {
	
	private int idMultitabCab;
	private String idMultitabDet;
	private String descripcionItem;
	private String abreviatura;
	private String descripcionMultitabCab;
	private String usuario;

}
