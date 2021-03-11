package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CronogramaResponse {
	private Integer idTipoTramite;
	private Integer idItem;
	private String periodo;
	private String descripcion;
	private String codigoLocal;
}
