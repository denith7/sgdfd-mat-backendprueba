package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequisitoFormularioRequest {

		@NotNull(message = "Name cannot be null")
		@PositiveOrZero(message = "Debe ser positivo")
		private Integer idRequisito;
		@NotNull(message = "Name cannot be null")
		@PositiveOrZero(message = "Debe ser positivo")
		private Integer idFormulario;


}
