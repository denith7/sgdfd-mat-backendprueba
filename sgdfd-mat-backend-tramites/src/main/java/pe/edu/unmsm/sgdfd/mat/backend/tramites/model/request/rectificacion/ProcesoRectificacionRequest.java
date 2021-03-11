package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion;

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
public class ProcesoRectificacionRequest {
	@IdNumerico(maxRange = 9999999999L)
	private Integer idProcesoRectificacion;
	@IdCadena(maxLength = 50)
	private String codigoLocal;
	@CaracterNoRequerido(maxLength = 20)
	private String semestreAcademico;
	@CaracterNoRequerido(maxLength = 100)
	private String nombre;
	@CaracterNoRequerido(maxLength = 200)
	private String descripcion;
	@CaracterNoRequerido(maxLength = 10)
	private String codigoEstado;
	@CaracterNoRequerido(maxLength = 100)
	private String descripcionEstado;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private LocalDateTime fechaSistema;

	@IdNumerico(maxRange = 9999999999L)
	private Integer idCronograma;
	@CaracterNoRequerido(maxLength = 100)
	private String nombreCronograma;
	@CaracterNoRequerido(maxLength = 200)
	private String descripcionCronograma;
	private List<EtapaRequest> lsEtapas;
	
}

