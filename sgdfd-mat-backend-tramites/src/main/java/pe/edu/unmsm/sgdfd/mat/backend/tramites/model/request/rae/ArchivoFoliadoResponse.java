package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rae;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArchivoFoliadoResponse {
	
	private byte[] reporte;
		
}
