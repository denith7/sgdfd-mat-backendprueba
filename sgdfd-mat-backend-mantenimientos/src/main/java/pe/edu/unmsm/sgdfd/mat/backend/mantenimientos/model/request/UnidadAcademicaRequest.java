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
public class UnidadAcademicaRequest {

	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 )
	private String  codigoLocal;
	@Size(min = 1, max = 100)
	private String 	nombreLocal;
	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer codigoUnidadAcademica;
	@Size(min = 1, max = 100)
	private String  nombre;
	@Size(min = 1, max = 200)
	private String  descripcion;
	@Size(min = 1, max = 20)
	private String  sigla;
	@Size(min = 1, max = 20)
	private String  usuario;
	
}
