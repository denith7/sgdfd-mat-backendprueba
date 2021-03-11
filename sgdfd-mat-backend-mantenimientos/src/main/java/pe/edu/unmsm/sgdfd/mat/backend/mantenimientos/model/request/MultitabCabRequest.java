package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

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
public class MultitabCabRequest {

	private Integer idMultitabCab;
	@Size(min = 1, max = 30)
	private String 	nombre;
	@Size(min = 1, max = 200)
	private String 	descripcion;
	@Size(min = 1, max = 20)
	private String  usuario;

}
