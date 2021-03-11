package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormularioResponse {
		
	    private Integer idFormulario;
	    private String nombre;
	    private String titulo;
	    private String urlOrigenDatos;
	    private String urlDestinoDatos;

	    
}
