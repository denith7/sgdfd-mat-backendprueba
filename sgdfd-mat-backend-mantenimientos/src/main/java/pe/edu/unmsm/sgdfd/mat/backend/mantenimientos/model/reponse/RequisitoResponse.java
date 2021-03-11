package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequisitoResponse
{
    private Integer idRequisito;
    private String nombre;
    private String descripcion;
    private String tipo;
    private Integer numeroArchivos;
    private String abreviatura;
    private String formato ; 
    private Integer indicadorSgd;
    private Integer tamanioMaximoKb;
    private Integer indicadorObligatorio;
    private String nombrePlantilla;
    private byte[] archivoPlantilla;
}
