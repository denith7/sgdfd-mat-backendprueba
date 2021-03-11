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
public class UbigeoRequest {
	
	@IdCadena(regexpPattern = "[a-zA-Z0-9\\_]{1,10}", maxLength = 6)
	private String codigoUbigeo;
	@Size(min = 1, max = 2)
	private String codigoDepartamento;	
	@Size(min = 1, max = 2)
	private String codigoProvincia;
	@Size(min = 1, max = 2)
	private String codigoDistrito;
	@Size(min = 1, max = 50)
    private String nombre;
	@Size(min = 1, max = 20)
    private String usuario;
    	
}
