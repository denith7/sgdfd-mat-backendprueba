package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.IdCadena;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CronogramaVigenteRequest {
	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer idTipoTramite;
	@Size(min = 1, max = 100)
	private String nombreTramite;
	@NotNull(message = "Name cannot be null")
	@PositiveOrZero(message = "Debe ser positivo")
	private Integer idItem;
	@Size(min = 1, max = 40)
	private String periodo;
	@Size(min = 1, max = 80)
	private String descripcion;
	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 )
	private String codigoLocal;
	@Size(min = 1, max = 100)
	private String nombreLocal;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-mm-dd")
	private LocalDate periodoFecha;
	@Size(min = 1, max = 54)
	private String periodoFechaDescripcion;
	@Size(min = 1, max = 20)
	private String usuario;
}
