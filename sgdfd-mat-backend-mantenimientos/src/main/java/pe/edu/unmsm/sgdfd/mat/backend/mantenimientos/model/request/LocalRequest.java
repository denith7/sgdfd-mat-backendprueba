package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
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
public class LocalRequest
{
	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 )
    private String 	codigoLocal;
	@Size(min = 1, max = 100)
    private String 	nombre;
	@Size(min = 1, max = 200)
    private String 	descripcion;
	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer idGrupoLocal;
    @Size(min = 1, max = 10)
    private String 	codigoLocalSgd;
    @Size(min = 1, max = 12)
    private String 	siglaLocal;
    @Size(min = 1, max = 20)
    private String  usuario;


}
