package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpedienteEmiRequest {
	
	private String codigoProceso;
	private String observacionTramite;
	private String numeroExpediente;

}
