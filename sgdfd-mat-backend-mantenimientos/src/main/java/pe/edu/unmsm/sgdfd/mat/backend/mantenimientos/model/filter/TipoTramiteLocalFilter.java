package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTramiteLocalFilter {	
	
	@NotNull(message = "Name cannot be null")
	private Integer idGrupoLocal;
	@Size(min = 1, max = 10)
	private String codigoLocal;
	@NotNull(message = "Name cannot be null")
	private Integer idTipoTramite;
}
