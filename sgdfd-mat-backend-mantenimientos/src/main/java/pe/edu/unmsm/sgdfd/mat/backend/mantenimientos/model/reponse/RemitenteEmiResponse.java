package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemitenteEmiResponse {

	private String tipoEmisor;//03 - ciudadano
	private String codigoLocalEmision;
	private String codigoDependenciaEmision;
	private String codigoEmpleadoEmision;
	private String codigoEmpleadoResponsable;
	private String codigoDependenciaMp;
}
