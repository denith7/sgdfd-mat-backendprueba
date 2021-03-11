package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReporteSolicitudTramiteRequisitoResponse {
	
	private Integer idRequisito;
	private String nombre;
	private String formato;
	private String estado;
	
	
}
