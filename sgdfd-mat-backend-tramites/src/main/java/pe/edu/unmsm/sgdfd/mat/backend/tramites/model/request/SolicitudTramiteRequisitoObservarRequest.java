package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudTramiteRequisitoObservarRequest {
	private String estado;
	private String observacion;
	private String usuario;
}
