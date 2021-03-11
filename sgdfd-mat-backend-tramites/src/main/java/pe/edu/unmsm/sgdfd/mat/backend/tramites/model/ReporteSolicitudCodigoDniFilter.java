package pe.edu.unmsm.sgdfd.mat.backend.tramites.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReporteSolicitudCodigoDniFilter {

	private String idSolicitudTramite;
	private String numeroDocumento;
	private String codigoAlumno;
}
