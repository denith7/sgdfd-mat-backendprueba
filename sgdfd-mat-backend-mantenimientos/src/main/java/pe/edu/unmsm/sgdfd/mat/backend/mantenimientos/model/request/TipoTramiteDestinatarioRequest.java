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
public class TipoTramiteDestinatarioRequest {
	
	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer idTipoTramite;
	@Size(min = 1, max = 100)
	private String nombreTramite;
	@Size(min = 1, max = 10)
	private String idLocal;
	@Size(min = 1, max = 100)
	private String nombreLocal;

	private Integer idItem;
	@Size(min = 1, max = 15)
	private String codigoDependencia;
	@Size(min = 1, max = 200)
	private String tituloDependencia;
	@Size(min = 1, max = 2)
	private String tipoDestino;
	@Size(min = 1, max = 40)
	private String destino;
	@Size(min = 1, max = 20)
	private String codigoEmpleado;
	@Size(min = 1, max = 162)
	private String nombreCompleto;
	@Size(min = 1, max = 1)
	private String codigoPrioridad;
	@Size(min = 1, max = 40)
	private String prioridad;
	@Size(min = 0, max = 100)
	private String indicaciones;
	@Size(min = 1, max = 1)
	private String codigoMotivo;
	@Size(min = 1, max = 40)
	private String motivo;
	@Size(min = 1, max = 10)
	private String tipoReceptor;
	private String usuario;
}
