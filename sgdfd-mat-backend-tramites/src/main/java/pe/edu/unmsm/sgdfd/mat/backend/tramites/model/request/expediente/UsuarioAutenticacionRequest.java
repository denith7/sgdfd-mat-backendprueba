package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.expediente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAutenticacionRequest {
	
	private String username;
	private String password;

    
    
}
