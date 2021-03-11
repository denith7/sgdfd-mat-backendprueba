package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import java.util.List;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemitoTramiteRequest {
		
	@Size(min = 1, max = 400)
	private String nombreArchivo;
	@PositiveOrZero(message = "Debe ser positivo")
	private String idTipoTramite;
	private String codigoLocalEmision;
	private DocumentoEmiRequest documentoEmi;
	private RemitenteEmiRequest remitenteEmi;
	private ExpedienteEmiRequest expedienteEmi;
	private List<DestinatariosRequest>	lsDestinatarios;
}
