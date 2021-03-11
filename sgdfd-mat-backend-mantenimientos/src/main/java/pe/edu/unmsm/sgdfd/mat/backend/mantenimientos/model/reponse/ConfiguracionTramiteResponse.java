package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteLocalRequisitoRequest;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracionTramiteResponse {

	private Integer idTipoTramite;
	private String codigoLocal;
	private String estado;
	private String informacionAdicionalHtml;
	private List<TipoTramiteLocalRequisitoResponse> listaRequisitos;
	private List<CronogramaVigenteResponse> listaCronogramas;
	private List<TipoTramiteDestinatarioResponse> listaDestinatarios;
	private List<Integer> listaRequisitosEliminados;
	private List<Integer> listaCronogramasEliminados;
	private List<Integer> listaDestinatariosEliminados;
	private String usuario;
}
