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
public class DestinatariosRequest {

	@Size(min = 1, max = 5)
	private String codigoLocal;
	private String codigoDependencia;
	private String codigoTipoDestino;
	private String codigoEmpleado;
	private String codigoPrioridad;
	private String indicaciones;
	private String codigoMotivo;
	
}
