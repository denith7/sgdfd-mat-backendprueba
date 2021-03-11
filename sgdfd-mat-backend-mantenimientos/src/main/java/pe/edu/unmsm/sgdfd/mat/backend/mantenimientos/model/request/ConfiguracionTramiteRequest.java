package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.CronogramaVigenteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.DestinatariosResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteDestinatarioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalRequisitoResponse;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracionTramiteRequest {

	private Integer idTipoTramite;
	private String codigoLocal;
	private String estado;
	private String informacionAdicionalHtml;
	private List<TipoTramiteLocalRequisitoRequest> listaRequisitos;
	private List<CronogramaVigenteRequest> listaCronogramas;
	private List<TipoTramiteDestinatarioRequest> listaDestinatarios;
	private List<Integer> listaRequisitosEliminados;
	private List<Integer> listaCronogramasEliminados;
	private List<Integer> listaDestinatariosEliminados;
	private String usuario;
}
