package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FrecuenciaTramitesDerivadosFilter {

	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private LocalDate fechaInicio;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private LocalDate fechaFin;
	private String codigoLocal;
}
