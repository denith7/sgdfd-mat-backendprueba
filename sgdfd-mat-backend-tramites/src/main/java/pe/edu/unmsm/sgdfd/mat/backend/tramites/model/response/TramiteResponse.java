package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TramiteResponse {
	
	private Integer idTramite;
	private Date fechaVencimiento;
    private String numeroExpediente;
    private Integer idSolicitudTramite;

}
