package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTramiteLocalRequisitoResponse {
	
	private Integer idTipoTramite;
	private String  nombre;
	private String  codigoLocal;
	private String  descripcion;
	private Integer idRequisito;
	private String  nombreRequisito;
	private Integer numeroOrden;
	private Integer  indicadorObligatorio;
//	private String  formaEnvio;
//	private String  descripFormaEnvio;
	private String  estado;
	private String usuario;
}
