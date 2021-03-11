package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import javax.validation.constraints.NotNull;
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
public class FormularioCamposRequest {
	
		@PositiveOrZero(message = "Debe ser positivo")
		private Integer idFormulario;
		@NotNull(message = "Name cannot be null")
		@PositiveOrZero(message = "Debe ser positivo")
		private Integer idCampo;
		@Size(min = 1, max = 100)
		private String nombreCampo;
		@Size(min = 1, max = 100)
		private String tipoDato;
		@Size(min = 1, max = 200)
		private String descripcion;
		@Size(min = 1, max = 50)
		private String descripcionCorta;
		@PositiveOrZero(message = "Debe ser positivo")
		private Integer longitud;
		@PositiveOrZero(message = "Debe ser positivo")
		private Integer precision;
		@PositiveOrZero(message = "Debe ser positivo")
		private Integer obligatorio;
		@Size(min = 1, max = 100)
		private String placeholder;
}
