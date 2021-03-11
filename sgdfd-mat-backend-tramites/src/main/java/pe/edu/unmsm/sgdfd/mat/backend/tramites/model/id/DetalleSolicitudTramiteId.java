package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleSolicitudTramiteId {
	private Integer idSolicitudTramite;
	private Integer idTipoTramite;
	private Integer idRequisito;
	private Integer idItem;
}
