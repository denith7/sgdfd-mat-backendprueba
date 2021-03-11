package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoEmiRequest {
	
	private Integer numeroFolios;
	@PositiveOrZero(message = "Debe ser positivo")
	private String numeroDiasAtencionRemito;
}
