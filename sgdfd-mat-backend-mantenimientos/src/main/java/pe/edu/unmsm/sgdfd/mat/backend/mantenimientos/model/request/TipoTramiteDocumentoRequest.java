package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTramiteDocumentoRequest {

	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer idTipoTramite;
	@Size(min = 1, max = 3)
	private String idTipoDocumento;

}
