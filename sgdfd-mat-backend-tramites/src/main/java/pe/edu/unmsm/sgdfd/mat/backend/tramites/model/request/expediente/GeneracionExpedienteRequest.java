package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.expediente;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.DestinatariosRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.DocumentoEmiRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.ExpedienteEmiRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.RemitenteEmiRequest;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneracionExpedienteRequest {
	
	private String operacion;
	private String operacionParametro;

    private String usuario;

    private byte[] archivo;
    private String nombreArchivo;
    private String tipoDocumentoArchivo;

    private String asunto;
    
    private Integer codigoSolicitud;
    private String numeroDocumentoSolicitud;

    private DocumentoEmiRequest documentoEmi;
    
    private RemitenteEmiRequest remitenteEmi;
    
    private ExpedienteEmiRequest expedienteEmi;
    
    private List<DestinatariosRequest> lsDestinatarios;
    
    private List<AnexoRequest> lsAnexos;
    
    private String token;
    
    
}
