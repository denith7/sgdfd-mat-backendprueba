package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EtapaResponse {
	private Integer idCronograma;
	private Integer idEtapa;
	private String descripcion;
	
	private List<ActividadResponse> lsActividades;
}
