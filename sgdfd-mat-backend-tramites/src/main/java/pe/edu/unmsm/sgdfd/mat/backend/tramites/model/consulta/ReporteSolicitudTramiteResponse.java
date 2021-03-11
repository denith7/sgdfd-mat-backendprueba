package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReporteSolicitudTramiteResponse {
	
	private Integer idSolicitudTramite;
	private String idSolicitudTramiteReporte;
	private String tipoDocumentoIdentidad;
	private String numeroDocumentoIdentidad;
	private String nombreCompleto;
	private Date fechaSolicitud;
	private Date fechaAprobacion;
	private String numeroExpediente;
	private String estadoSolicitud;
	private String estadoTramite;
	private String nombreLocal;
	private String tipoTramite;
	private String codigoAlumno;
	private String facultadAlumno;
	private String tipoDocumento;
	private String domicilio;
	private String celular;
	private String telefono;
	private String correoInstitucional;
	private String correoPersonal;
	private String tipoSolicitante;
//	private String lugarSolicitado;
	
	private String escuelaAlumno;
	private String especialidadAlumno;
	private String observacion;
	private List<ReporteSolicitudTramiteRequisitoResponse> requisitos;
	
}
