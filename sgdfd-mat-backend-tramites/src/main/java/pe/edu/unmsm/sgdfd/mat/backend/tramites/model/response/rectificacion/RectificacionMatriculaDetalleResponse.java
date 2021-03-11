package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.rectificacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RectificacionMatriculaDetalleResponse {
	private String codigoFacultad                    ;
	private String codigoEscuela                     ;
	private String idProcesoRectificacion           ;
	private String codigoPlan                        ;
	private String codigoAlumno                      ;
	private String alu                                ;
	private String prom                               ;
	private String situacionAcademica                ;
	private String anioCicloEstudio                 ;
	private String ultimaMatricula                   ;
	private String fecha                              ;
	private String hora                               ;
	private String idSolicitudRectiMatricula       ;
	private String idOperacion                       ;
	private String tipoOperacion                     ;
	private String abreviatura                        ;
	private String codigoCurso                       ;
	private String na1                                ;
	private String d1                                 ;
	private String dn1                                ;
	private String grupoRetiro                       ;
	private String grupoIngreso                      ;
	private String codigoCursoDestino               ;
	private String na2                                ;
	private String d2                                 ;
	private String dn2                                ;
	private String justificacion                      ;
	private String matriculados1                     ;
	private String matriculados2                     ;
	private String codigoResultado                   ;
	private String nombreCodigoResultado            ;
	private String estadoEjecucion                   ;
	private String nombreEstadoEjecucion			;
	private String o1                                 ;
	private String e1                                 ;
	private String o2                                 ;
	private String e2                                 ;
	
}
