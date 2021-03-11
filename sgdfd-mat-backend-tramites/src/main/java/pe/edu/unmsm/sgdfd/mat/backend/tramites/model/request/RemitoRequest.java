package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemitoRequest {

	private String anioEmision;
    private String numeroEmision; 
    private Integer numeroCorrelativo;
    private String tipoEmision;
    private String anioExpediente;
    private String numeroExpediente;
    private String numeroSecuencialExpediente;
    private String tipoDocumentoSolicitante;
    private String numeroDocumentoSolicitante;
    private Integer idTipoTramite;
    private String asunto;
    private Integer numeroFolios;
    private Integer numeroDiasAtencion;
    private String codigoDependenciaEmision;
    private String codigoEmpleadoEmision;
    private String codigoEmpleadoResponsable;
    private String codigoDependenciaMp;
    private String codigoLocal;  
    private List<DestinoRequest> lsdestinatarios;
}
