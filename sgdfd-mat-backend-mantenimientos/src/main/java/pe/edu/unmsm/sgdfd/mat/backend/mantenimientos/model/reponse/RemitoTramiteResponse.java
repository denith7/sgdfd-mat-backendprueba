package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemitoTramiteResponse {
		
	private String nombreArchivo;
	private String idTipoTramite;
	private String codigoLocalEmision;
	private Integer indicadorEstandar; 
	private DocumentoEmiResponse documentoEmi;
	private RemitenteEmiResponse remitenteEmi;
	private ExpedienteEmiResponse expedienteEmi;
	private List<DestinatariosResponse>	lsDestinatarios;
}
