package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemitentEmiResponse {

	private String tipoEmisor;//03 - ciudadano
	private String codigoLocalEmision;
	private String codigoDependenciaEmision;
	private String codigoEmpleadoEmision;
	private String codigoEmpleadoResponsable;
	private String codigoDependenciaMp;
}
