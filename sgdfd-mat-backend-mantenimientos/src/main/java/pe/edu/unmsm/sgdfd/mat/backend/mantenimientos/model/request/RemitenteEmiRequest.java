package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;


import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemitenteEmiRequest {

	@Size(min = 1, max = 2)
	private String tipoEmisor;// 03 ciudadano - 02 persona jurídica - 04 otros
	@Size(min = 1, max = 5)
	private String codigoLocalEmision;
	@Size(min = 1, max = 5)
	private String codigoDependenciaEmision;
	@Size(min = 1, max = 10)
	private String codigoEmpleadoEmision;
	@Size(min = 1, max = 10)
	private String codigoEmpleadoResponsable;
	@Size(min = 1, max = 5)
	private String codigoDependenciaMp;
	
	
	private String numeroDni;// ciudadano y persona jurídica
	private String numeroRuc;// persona jurídica
	private String numeroOtroDocumento;// otros
	
	private String apellidoPaterno;//ciudadano y otros
	private String apellidoMaterno;//ciudadano y otros
	private String nombres;//ciudadano y otros
	
	private String tipoDocumento;//otros

	private String direccion;//otros y persona jurídica
	private String razonSocial;//otros y persona jurídica
	
	private String telefono;//persona jurídica
}
