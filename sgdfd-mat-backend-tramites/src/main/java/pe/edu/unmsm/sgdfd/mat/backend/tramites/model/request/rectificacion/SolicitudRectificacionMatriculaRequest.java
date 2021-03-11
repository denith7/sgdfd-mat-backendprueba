package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rectificacion;


import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.CaracterNoRequerido;
import pe.edu.unmsm.commons.validation.validation.CaracterRequerido;
import pe.edu.unmsm.commons.validation.validation.IdCadena;
import pe.edu.unmsm.commons.validation.validation.IdNumerico;
import pe.edu.unmsm.commons.validation.validation.NumeroNoRequerido;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudRectificacionMatriculaRequest 
{
	@NumeroNoRequerido(maxRange = 9999999999L)
	private Integer idSolicitudRectiMatri;
	@CaracterNoRequerido(minLength = 1, maxLength = 10)
	private String codigoAlumno;
	@NumeroNoRequerido(maxRange = 99)
	private Integer codigoFacultad;
	@NumeroNoRequerido(maxRange = 999)
	private Integer codigoEscuela;
	@CaracterNoRequerido( maxLength = 10)
	private String codigoPlan;
	@CaracterNoRequerido(maxLength = 10)
	private String estado;
	@NumeroNoRequerido(maxRange = 9999999999L)
	private Integer idSolicitudTramite;
	@NumeroNoRequerido(maxRange = 9999999999L)
	private Integer idProcesoRectificacion;
	@CaracterRequerido(maxLength = 50)
	private String usuario;
	
	private List<SolicitudRectificacionDetalleRequest> lsOperaciones;
	
	//atributos para registrar solicitud tramite
	@CaracterNoRequerido(maxLength = 2)
	private String tipoDocumentoIdentidad;
	@CaracterNoRequerido(maxLength = 10)
	private String numerodocumentoIdentidad;
	@CaracterNoRequerido(maxLength = 10)
	private String codigoLocal;
	@NumeroNoRequerido(maxRange = 9999999999L)
	private Integer idTipoTramite;
	
	//atributos para el reporte de rectificaciones
	private String nombresAlumno;
	private String apellidoPaternoAlumno;
	private String apellidoMaternoAlumno;
	private String nombreFacultad;
	private String nombreEscuelaProfesional;
	private String nombrePlan;
	private String nombreEstadoSolicitud;
	private String descripcionEstadoSolicitud;
	private LocalDateTime fechaRegistro;
	private LocalDateTime fechaModificacion;
	
	private String semestreAcademicoProceso;
	
}
