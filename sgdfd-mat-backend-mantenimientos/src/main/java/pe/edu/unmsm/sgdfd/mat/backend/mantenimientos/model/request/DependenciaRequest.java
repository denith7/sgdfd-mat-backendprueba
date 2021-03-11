package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;


import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.commons.validation.validation.IdCadena;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DependenciaRequest {
	
	@IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 )
	private String codigoDependencia;
	@Size(min = 1, max = 10)
	private String codigoLocal;
	@Size(min = 1, max = 200)
	private String titulo;
	@Size(min = 1, max = 25)
	private String descripcionCorta;
	@Size(min = 1, max = 50)
	private String sigla;
	@Size(min = 1, max = 1)
	private String codigoNivel;
	@Size(min = 1, max = 10)
	private String codigoDependenciaPadre;
	@Size(min = 1, max = 5)
	private String codigoEmpleadoTitular;
	@Size(min = 1, max = 5)
	private String codigoCargo;
	@Size(min = 1, max = 200)
	private String descripcionCargoCompleto;
	@Size(min = 1, max = 20)
	private String codigoLocalSgd;
	@Size(min = 1, max = 200)
	private String tituloDependenciaPadre;
	@Size(min = 1, max = 163)
	private String nombreEmpleado;
	@Size(min = 1, max = 100)
	private String nombreLocal;
	@Size(min = 1, max = 20)
	private String usuario;
	
}
