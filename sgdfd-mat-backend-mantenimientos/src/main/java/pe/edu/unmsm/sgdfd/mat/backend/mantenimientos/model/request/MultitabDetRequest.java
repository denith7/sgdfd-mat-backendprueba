package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

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
public class MultitabDetRequest {
	
	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private int idMultitabCab;
	@IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,10}", maxLength = 10 )
	private String idMultitabDet;
	@Size(min = 1, max = 200)
	private String descripcionItem;
	@Size(min = 1, max = 40)
	private String abreviatura;
	@Size(min = 1, max = 30)
	private String descripcionMultitabCab;
	@Size(min = 1, max = 20)
	private String usuario;

}
