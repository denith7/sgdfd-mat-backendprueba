package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudTramiteRequisitoResponse {
	
	private String idRequisito;
	private Integer idItem;
	private String nombreRequisito;
	private String estadoRequisito;
	private String descripcionEstadoRequisito;
	private String numeroOrdenRequisito;
	private String valorRequisito;
	private Integer numeroArchivosEsperado;
	private String observacion;
	private String indicadorSgd;
	
	private String estadoSolicitud;
	private String descripcionEstadoSolicitud;
	
	private String tipo;
	private String formato;
	private Integer numeroArchivos;
	private Integer tamanioMaximoKb;
	private byte[] archivoAdjuntoRequisito;
	
}
