package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.IdCadena;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTramiteLocalRequisitoRequest {
	
	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer idTipoTramite;
	@Size(min = 1, max = 100)
	private String nombre;
	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 )
	private String codigoLocal;
	@Size(min = 1, max = 300)
	private String descripcion;
	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer idRequisito;
	@Size(min = 1, max = 100)
	private String nombreRequisito;
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer numeroOrden;
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer indicadorObligatorio;
	@Size(min = 1, max = 1)
	private String estado;
//	@Size(min = 1, max = 3)
//	private String formaEnvio;
	private String usuario;
}
