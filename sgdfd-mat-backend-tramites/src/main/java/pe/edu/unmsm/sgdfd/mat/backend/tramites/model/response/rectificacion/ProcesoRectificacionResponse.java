package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.CaracterNoRequerido;
import pe.edu.unmsm.commons.validation.validation.IdCadena;
import pe.edu.unmsm.commons.validation.validation.IdNumerico;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcesoRectificacionResponse {
	private Integer idProcesoRectificacion;
	private String codigoLocal;
	private String semestreAcademico;
	private String nombre;
	private String descripcion;
	private String codigoEstado;
	private String descripcionEstado;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private LocalDateTime fechaSistema;

	private Integer idCronograma;
	private String nombreCronograma;
	private String descripcionCronograma;
	private List<EtapaResponse> lsEtapas;
	
}

