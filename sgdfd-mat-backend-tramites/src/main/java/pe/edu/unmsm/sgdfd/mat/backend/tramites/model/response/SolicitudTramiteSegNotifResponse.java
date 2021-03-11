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
public class SolicitudTramiteSegNotifResponse {
	
	private Integer idTramiteSeguimiento;
	private Integer idSolicitudTramite;
	private Date 	fechaSolicitud;
	private String 	asunto;
	private String 	codigoLocal;
	private String 	localNombre;
	private Integer	idTipoTramite;
	private String	tipoTramiteNombre;
	private String 	estadoTramite;
	private String	estadoNombre;
	private String	fechaRegistroEstadoExt;
	private String	fechaRegistroEstado;
	private String	numeroDocumento;
	private Integer estadoNotifLeido;

}
