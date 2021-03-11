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
public class CargoRequest
{
	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,4}", maxLength = 4)
    private String 	codigoCargo;
	@Size(min = 1, max = 200)
	private String 	descripcion;
	@Size(min = 1, max = 1)
    private String 	estado;
	@Size(min = 1, max = 200)
    private String  descripcionEstado;
    @Size(min = 1, max = 20)
    private String  usuario;


}
