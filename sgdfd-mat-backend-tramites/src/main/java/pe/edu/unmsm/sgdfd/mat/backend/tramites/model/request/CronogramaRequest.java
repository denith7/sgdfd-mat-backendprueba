package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CronogramaRequest {
	private Integer idTipoTramite;
	private Integer idItem;
	private String periodo;
	private String descripcion;
	private String codigoLocal;
}
