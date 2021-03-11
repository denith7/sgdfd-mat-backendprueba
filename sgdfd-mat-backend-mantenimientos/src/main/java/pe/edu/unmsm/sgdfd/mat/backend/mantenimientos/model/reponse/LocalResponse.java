package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalResponse
{
	private Integer idPerfil;
	private String  numeroDocumento;
    private String 	codigoLocal;
    private String 	nombre;
    private String 	descripcion;
    private Integer idGrupoLocal;
    private String 	nomGrupoLocal;
    private String 	siglaLocal;
    private String 	codigoLocalSgd;
    private String  usuario;


}
