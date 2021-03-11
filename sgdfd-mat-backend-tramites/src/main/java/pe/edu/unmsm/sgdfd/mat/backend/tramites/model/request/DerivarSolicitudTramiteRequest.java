package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DerivarSolicitudTramiteRequest
{
	private String mensaje;
	private String estado;
	private String numeroExpediente;
	private String usuario;
	
}
