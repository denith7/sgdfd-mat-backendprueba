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
public class SolicitudTramiteRequest 
{
	private Integer idSolicitudTramite;
	private Integer idItem;
	private Date fechaSolicitud;
	private Date fechaAprobacion;
	private String tipoDocumentoIdentidad;
    private String numeroDocumentoIdentidad;
    private String codigoSolicitante;
    private String asunto;
    private String justificacion;
    private String codigoLocal;
    private String codigoLocalSolicitante;
    private String estado;    
    private Integer tipoDocumentoRegistrado;
    private String Observacion;
    private String numeroExpediente;
    private Integer idTipoTramite;
	
    private String usuario;
	private List<SolicitudTramiteRequisitoRequest> lsSolicitudTramiteRequisito;
}
