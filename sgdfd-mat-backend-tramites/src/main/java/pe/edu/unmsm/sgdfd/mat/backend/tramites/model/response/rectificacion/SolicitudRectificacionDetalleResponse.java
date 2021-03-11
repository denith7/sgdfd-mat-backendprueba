package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.CaracterNoRequerido;
import pe.edu.unmsm.commons.validation.validation.IdNumerico;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudRectificacionDetalleResponse 
{
	private Integer idOperacion;
	@CaracterNoRequerido(maxLength = 10)
	private String tipoOperacion;
	@CaracterNoRequerido(maxLength = 8)
	private String codigoCurso;
	@CaracterNoRequerido(maxLength = 8)
	private String codigoCursoDestino;
	@CaracterNoRequerido(maxLength = 10)
	private String grupoIngreso;
	@CaracterNoRequerido(maxLength = 10)
	private String grupoRetiro;
	@CaracterNoRequerido(maxLength = 500)
	private String justificacion;
	@CaracterNoRequerido(maxLength = 10)
	private String codigoResultado;
	@CaracterNoRequerido(maxLength = 10)
	private String estadoEjecucion;

	private Integer idSolicitudRectiMatri;
	@CaracterNoRequerido(maxLength = 50)
	private String usuario;
	
	
	//atributos para el reporte de rectificaciones
	private String abreviaturaOperacion;
	private String descripcionOperacion;
	private String nombreCurso;
	private String nombreCursoDestino;
	private String abreviaturaCodigoResultado;
	private String descripcionCodigoResultado;
	private String nombreEstadoEjecucion;
	private String descripcionEstadoEjecucion;
}
