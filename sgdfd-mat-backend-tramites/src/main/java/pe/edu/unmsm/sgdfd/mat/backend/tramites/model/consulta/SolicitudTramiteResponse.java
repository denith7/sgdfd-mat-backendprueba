package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudTramiteResponse {
	private Integer idSolicitudTramite;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
	private Date fechaSolicitud;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
	private Date fechaAprobacion;
	private String tipoDocumentoIdentidad;
	private String numeroDocumentoIdentidad;
	private String nombreCompleto;//para el reporte (FUT) y otros casos
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	private String direccionDomicilio;
	private String asunto;
	private String justificacion;
	private String codigoLocal;
	private String nombreLocal;
	private String codigoLocalSolicitante;
	private String nombreLocalSolicitante;
	private String correoInstitucional;
	private Integer idTipoTramite;
	private String nombreTipoTramite;
	private String nombreUrl;
	private String indicadorTupa;
	private String codigoEstado;//estadoSolicitud
	private String descripcionEstado;
	private String numeroExpediente;
	private String codigoSolicitante;
	private String estadoTramite;
	private String facultadAlumno;
	private String escuelaAlumno;
	private String especialidadAlumno;
	private List<SolicitudTramiteRequisitoResponse> requisitos; 
	
}
