package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RptTiempoAtencionResponse {
	
	private String codigoLocal;
	private String nombreLocal;
	private float diasRecepcionPromedio;
	private float diasRecepcionMinimo;
	private float diasRecepcionMaximo;
	
}
