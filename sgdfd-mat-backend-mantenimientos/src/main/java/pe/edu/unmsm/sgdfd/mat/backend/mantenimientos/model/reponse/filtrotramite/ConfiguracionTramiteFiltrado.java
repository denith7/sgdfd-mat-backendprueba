package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.filtrotramite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracionTramiteFiltrado {

	private Integer idTipoTramite;
	private String nombreTramite;
	private String codigoLocal;
	private String nombreLocal;
	private String estado;
	private Integer cantidadRequisitos;
	private Integer cantidadCronogramas;
	private Integer cantidadDestinatarios;
	
}
