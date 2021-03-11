package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.IdCadena;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTramiteRequest {
	
//	@IdCadena(minLength = 1, maxLength = 8, regexpPattern = "[a-zA-Z]", groups = IRegistro.class)
	private Integer idTipoTramite;	
	@Size(min = 1, max = 100)
	private String 	nombre;	
	@Size(min = 1, max = 400)
	private String 	descripcion;
	@Size(min = 1, max = 200)
	private String 	asunto;	
	@Size(min = 1, max = 1)
    private String  indicadorTupa;   
    private String	descripcionIndicadorTupa;
    @PositiveOrZero(message = "Debe ser positivo")
    private Integer idGrupoLocal;    
    private String  codigoGrupoLocal;    
    private String	nombreGrupoLocal;
    @Size(min = 1, max = 200)
    private String 	nombreUrl;    
    @Size(min = 1, max = 4)
    private String	codigoProcesoSgd;  
    @Size(min = 0, max = 60)
    private String	observacionTramiteSgd;
    @PositiveOrZero(message = "Debe ser positivo")
    private Integer	numeroDiasAtencionSgd;    
    @PositiveOrZero(message = "Debe ser positivo")
    private Integer indicadorExclusivo; 
    @Size(min = 1, max = 10)
    private String  indicadorCategoria;    
    @PositiveOrZero(message = "Debe ser positivo")
    private Integer indicadorMultiplicidad;
    @PositiveOrZero(message = "Debe ser positivo")
    private Integer indicadorEstandar;
    @PositiveOrZero(message = "Debe ser positivo")
    private Integer indicadorDestino;
    
    @Size(min = 1, max = 20)
    private String usuario;
	
}
