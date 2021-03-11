package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerfilLocalResponse {
	
	private Integer idPerfil;
    private String 	codigoLocal;
	private String 	nombrePerfil;
	private String 	nombreLocal;
	private String  indicadorVisualizacion;
	private String  descripIndiVisual;
	private String  usuario;

}
