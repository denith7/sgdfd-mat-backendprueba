package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudTramiteEstadisticaResponse {
	private Integer conteo;
	private Date 	fecha;
	private String 	descripcionDia;
}
