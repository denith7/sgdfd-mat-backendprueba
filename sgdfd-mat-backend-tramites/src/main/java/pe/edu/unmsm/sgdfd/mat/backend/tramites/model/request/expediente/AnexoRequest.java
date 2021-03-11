package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.expediente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnexoRequest {
	
	private String nombreArchivo;
    private byte[] archivo;

}
