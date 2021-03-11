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
public class DependenciaLocalRequest {
	
	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,20}", maxLength = 10 )
	private String codigoLocal;
	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 )
	private String codigoDependencia;
	@Size(min = 1, max = 2)
	private String estado;
	@Size(min = 1, max = 20)
	private String usuario;
	
}
