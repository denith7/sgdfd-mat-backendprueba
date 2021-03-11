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
public class TipoTramiteFilter {
	
	
	private String codigoLocal;
	@Size(min = 1, max = 1)
	private String indicadorTupa;
	@Size(min = 1, max = 200)
	private String nombreUrl;
}
