package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalDetalleResponse {
	private String codigoLocal;
	private String codigoLocalSgd;	
    private String nombreLocal;
    private String descripcionLocal;
    private String siglaLocal;
    private String codigoEscuela;
    private String nombreEscuela;
    private String siglaEscuela;
    	
}
