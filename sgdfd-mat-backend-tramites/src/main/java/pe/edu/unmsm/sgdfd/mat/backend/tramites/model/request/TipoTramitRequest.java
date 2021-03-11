package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTramitRequest {

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
    private String usuario;
}
