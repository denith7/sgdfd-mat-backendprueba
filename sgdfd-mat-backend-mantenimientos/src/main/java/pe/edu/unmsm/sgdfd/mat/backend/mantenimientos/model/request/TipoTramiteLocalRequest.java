package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.NotNull;
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
public class TipoTramiteLocalRequest
{
	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 )
    private String codigoLocal;
    private String siglaLocal;
    private String nombreLocal;
    @NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
    private Integer idTipoTramite;
    private Integer numeroOrden;
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
    @Size(min = 1, max = 4000)
    private String informacionAdicionalHtml;
    private Integer idGrupoLocal;    
    private String codigoEstado; 
    private String nombreEstado;  
    private String usuario;   
    private Integer codigoEscuela;
    private String nombreEscuela;
    private String siglaEscuela;   
    private String codigoCategoria;
    
    
}