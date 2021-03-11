package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

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
public class CronogramaVigenteResponse {
	private Integer idTipoTramite;
	private String nombreTramite;
	private Integer idItem;
	private String periodo;
	private String descripcion;
	private String codigoLocal;
	private String nombreLocal;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate periodoFecha;
	private String periodoFechaDescripcion;
	private String usuario;
}
