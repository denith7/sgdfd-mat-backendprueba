package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalFilter {	
	
	@NotNull(message = "Name cannot be null")
	private Integer idGrupoLocal;
	@NotNull(message = "Name cannot be null")
	private Integer codigoLocal;
}
