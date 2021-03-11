package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemitoTramitResponse {

	private String nombreArchivo;
	private String idTipoTramite;
	private String codigoLocalEmision;
	private DocumentEmiResponse documentoEmi;
	private RemitentEmiResponse remitenteEmi;
	private ExpedientEmiResponse expedienteEmi;
	private List<DestinatariosDeResponse>	lsDestinatarios;
}
