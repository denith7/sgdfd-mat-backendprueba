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
public class PerfilLocalTipoTramiteRequest {

	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer idPerfil;
	
	@Size(min = 1, max = 10)
	private String codigoLocal;
	
	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer idTipoTramite;
	
	@Size(min = 1, max = 20)
	private String usuario;
}
