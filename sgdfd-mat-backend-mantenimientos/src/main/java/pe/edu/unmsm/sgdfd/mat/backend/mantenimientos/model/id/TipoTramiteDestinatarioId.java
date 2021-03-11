package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.IdCadena;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTramiteDestinatarioId {
	
	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer idTipoTramite;
	@IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,10}", maxLength = 10 )
	private String idLocal;
	@IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,5}", maxLength = 5 )
	private String idItem;
}
