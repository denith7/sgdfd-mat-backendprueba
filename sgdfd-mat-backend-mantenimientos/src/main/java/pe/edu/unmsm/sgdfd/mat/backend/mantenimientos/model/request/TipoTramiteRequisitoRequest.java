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
public class TipoTramiteRequisitoRequest
{
	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer idTipoTramite;
	@Size(min = 1, max = 100)
	private String nombreTipoTramite;
	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer idRequisito;
	@Size(min = 1, max = 100)
	private String nombreRequisito;
    private Boolean estado; 
    @PositiveOrZero(message = "Debe ser positivo")
    private Integer numeroOrden;
    
}
