package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTramiteDestinatarioResponse {
	
	private Integer idTipoTramite;
	private String nombreTramite;
	private String idLocal;
	private String nombreLocal;
	private Integer idItem;
	private String codigoDependencia;
	private String tituloDependencia;
	private String tipoDestino;
	private String destino;
	private String codigoEmpleado;
	private String nombreCompleto;
	private String codigoPrioridad;
	private String prioridad;
	private String indicaciones;
	private String codigoMotivo;
	private String motivo;
	private String tipoReceptor;
	private String usuario;
}
