package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTramiteRequisitoResponse
{
	private Integer idTipoTramite;
	private String nombreTipoTramite;
	private Integer idRequisito;
	private String nombreRequisito;
    private Boolean estado; 
    private Integer numeroOrden;
    
}
