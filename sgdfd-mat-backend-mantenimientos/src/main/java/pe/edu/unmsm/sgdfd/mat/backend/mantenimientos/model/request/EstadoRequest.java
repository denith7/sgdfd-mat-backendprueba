package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

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
public class EstadoRequest

{   
	@IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,30}", maxLength = 30 )
	private String tablaOrigen;
	@IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,10}", maxLength = 10 )
    private String codigoEstado;
	@Size(min = 1, max = 100)
    private String nombreEstado;
	@Size(min = 1, max = 200)
	private String descripcionEstado;
    @Size(min = 1, max = 20)
    private String usuario;
}