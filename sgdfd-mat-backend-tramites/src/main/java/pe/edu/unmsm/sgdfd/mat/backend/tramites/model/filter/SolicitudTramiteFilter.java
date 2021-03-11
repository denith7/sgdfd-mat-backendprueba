package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudTramiteFilter {	
	@NotNull
	private Integer idSolicitudTramite;
	
	@NotNull
	private String numeroDocumento;

}
