package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTramiteLocalResponse
{
    private String codigoLocal;
    private String siglaLocal;
    private String nombreLocal;
    private String descripcionLocal;
    private Integer idTipoTramite;
    private String numeroOrden;
    private String estado;
	private String nombre;	
	private String descripcion;	
	private String asunto;	
    private String indicadorTupa;    
    private String descripcionIndicadorTupa;
    private String nombreUrl;    
    private String	codigoProcesoSgd;  
    private String	observacionTramiteSgd;
    private Integer	numeroDiasAtencionSgd;
    private String informacionAdicionalHtml;       
    private Integer idGrupoLocal;    
    private String codigoEstado;    
    private String nombreEstado;    
    private String usuario;   
    private String codigoEscuela;
    private String nombreEscuela;
    private String siglaEscuela;   
    private String codigoCategoria;
    
    
}