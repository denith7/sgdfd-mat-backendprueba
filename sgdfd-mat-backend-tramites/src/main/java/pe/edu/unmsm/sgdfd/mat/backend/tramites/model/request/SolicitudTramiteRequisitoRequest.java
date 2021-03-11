package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudTramiteRequisitoRequest
{
	private Integer idSolicitudTramite;
	private Integer idTipoTramite;
	private Integer idRequisito;
	private Integer idItem;
    private byte[]  archivoAdjunto;
    private String  valor;
    private String  estado;
    private String  descripcionEstadoRequisito;
    private String  estadoSolicitud;
    private String  descripcionEstadoSolicitud;
    private String  observacion;
    private String  descripcionSeguimiento;
    private String  indicadorSgd;
    
    private String numeroDocumento;
    private String tipoDocumento;
    private String asunto;
    private String tipo;
    private Integer indicadorRae;
    private String tipoRequisito;
}
