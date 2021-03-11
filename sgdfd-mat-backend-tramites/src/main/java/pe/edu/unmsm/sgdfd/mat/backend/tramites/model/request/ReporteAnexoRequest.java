package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReporteAnexoRequest {
	
	private Integer idSolicitud;
	private Integer idTipoTramite;
	private Integer idRequisito;
	private Integer idItem;

	private String url;
	private String nombreRequisitoFirmado;
}
