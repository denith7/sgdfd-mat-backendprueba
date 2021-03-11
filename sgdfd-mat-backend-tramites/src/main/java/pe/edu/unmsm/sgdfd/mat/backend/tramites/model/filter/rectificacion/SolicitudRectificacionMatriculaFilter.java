package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.rectificacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudRectificacionMatriculaFilter {
	private Integer idSolicitudRectificacionMatricula;
	
	private String codigoAlumno;
	private Integer idProcesoRectificacion;
	
	private String codigoCurso;
	
	private Integer codigoFacultad;
	private String semestreAcademicoProceso;
	private Boolean ocultarCancelados;// toma valores 1 (mostrar cancelados) o 0 (no mostrar cancelados)
	
}
