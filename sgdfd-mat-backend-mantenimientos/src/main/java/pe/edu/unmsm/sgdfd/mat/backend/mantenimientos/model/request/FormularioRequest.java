package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormularioRequest {
		
		@NotNull(message = "Name cannot be null")
		@PositiveOrZero(message = "Debe ser positivo")
	    private Integer idFormulario;
		@Size(min = 1, max = 100)
	    private String nombre;
		@Size(min = 1, max = 100)
	    private String titulo;
		@Size(min = 1, max = 200)
	    private String urlOrigenDatos;
		@Size(min = 1, max = 200)
		private String urlDestinoDatos;

	    
}
