package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActividadRequest {
	private Integer idCronograma;
	private Integer idEtapa;
	private Integer idActividad;
	private Integer numeroOrden;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	private Integer idTipoProceso;
	private Integer idTipoActividad;
	
	private String nombreActividad;
	private String descripcionActividad;
	
}
