package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;

import org.apache.ibatis.annotations.Param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoTramiteFiltroRequest {
	
	private String[] codigoCategoria; //Categoria
	private String[] idGrupoLocal; //Destino
	private String[] indicadorTupa; //Tipo trámite
	private String codigoLocal; //LocalRequest - Facultad
	
}
