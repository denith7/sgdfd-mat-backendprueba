package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DestinatariosDeResponse {

	private String codigoLocal;
	private String codigoDependencia;
	private String codigoTipoDestino;
	private String codigoEmpleado;
	private String codigoPrioridad;
	private String indicaciones;
	private String codigoMotivo;
}
