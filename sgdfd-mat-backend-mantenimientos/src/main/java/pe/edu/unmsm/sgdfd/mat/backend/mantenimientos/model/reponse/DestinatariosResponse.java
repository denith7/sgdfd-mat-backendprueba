package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DestinatariosResponse {

	private String codigoLocal;
	private String codigoDependencia;
	private String dependencia;
	private String codigoTipoDestino;
	private String codigoEmpleado;
	private String empleado;
	private String codigoPrioridad;
	private String indicaciones;
	private String codigoMotivo;
	private String motivo;
}
