package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion;


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
public class SolicitudRectificacionMatriculaResponse 
{
	private Integer idSolicitudRectiMatri;
	private String codigoAlumno;
	private Integer codigoFacultad;
	private Integer codigoEscuela;
	private String codigoPlan;
	private String estado;
	private Integer idSolicitudTramite;
	private Integer idProcesoRectificacion;
	private String usuario;
	
	private List<SolicitudRectificacionDetalleResponse> lsOperaciones;
	
	//atributos para registrar solicitud tramite
	private String tipoDocumentoIdentidad;
	private String numerodocumentoIdentidad;
	private String codigoLocal;
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
