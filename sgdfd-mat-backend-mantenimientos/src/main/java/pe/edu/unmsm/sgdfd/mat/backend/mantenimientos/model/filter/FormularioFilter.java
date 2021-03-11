package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter;

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
public class FormularioFilter {
	
	@Size(min = 1, max = 10)
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
