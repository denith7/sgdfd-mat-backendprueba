package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.CaracterRequerido;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTramiteResponse {
	
//	@IdCadena(minLength = 1, maxLength = 8, regexpPattern = "[a-zA-Z]", groups = IRegistro.class)
	private Integer idTipoTramite;	
	private String 	nombre;	
	private String 	descripcion;	
	private String 	asunto;	
    private String  indicadorTupa;   
    private String	descripcionIndicadorTupa;    
    private Integer idGrupoLocal;    
    private String  codigoGrupoLocal;    
    private String	nombreGrupoLocal;       
    private String 	nombreUrl;    
    private String	codigoProcesoSgd;    
    private String	observacionTramiteSgd;
    private Integer	numeroDiasAtencionSgd;    
    private Integer indicadorExclusivo;    
    private String  indicadorCategoria;    
    private Integer indicadorMultiplicidad;
    private Integer indicadorEstandar;
    private Integer indicadorDestino;
    private String usuario;
	
}
