package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudTramiteFilterRequest {

	private Integer idSolicitudTramite;
	private Integer idTipoTramite;
	private String 	fechaInicio; //Solicitud
	private String	fechaFin; //Solicitud
	private String  numeroDocumento;
	private String  numeroExpediente;
	private String 	nombres;
	private String 	apellidoPaterno;
	private String	apellidoMaterno;
	private String 	codigoLocal; //idFacultad
	private String 	codigoEscuela;
	private String  codigoEspecialidad;
	private String 	codigoEstado;
	
}
