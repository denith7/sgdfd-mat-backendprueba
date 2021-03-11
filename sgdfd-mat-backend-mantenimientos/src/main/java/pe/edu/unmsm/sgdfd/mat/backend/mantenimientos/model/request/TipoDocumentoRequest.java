package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoDocumentoRequest {

	@Size(min = 1, max = 3)
	private String idTipoDocumento;
	@Size(min = 1, max = 100)
	private String descripcion;
}
