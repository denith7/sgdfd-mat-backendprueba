package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request;


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
public class RequisitoRequest
{

    private Integer idRequisito;
	@Size(min = 1, max = 100)
    private String nombre;
    @Size(min = 1, max = 300)
    private String descripcion;
    @Size(min = 1, max = 10)
    private String tipo;
	@PositiveOrZero(message = "Debe ser positivo")
    private Integer numeroArchivos;
    @Size(min = 1, max = 40)
    private String abreviatura;
    @Size(min = 1, max = 50)
    private String formato ; 
    @PositiveOrZero(message = "Debe ser positivo")
    private Integer indicadorSgd;
    @PositiveOrZero(message = "Debe ser positivo")
    private Integer tamanioMaximoKb;
    @PositiveOrZero(message = "Debe ser positivo")
    private Integer indicadorObligatorio;
    //@Size(min = 1, max = 100)
    private String nombrePlantilla;
    private byte[] archivoPlantilla;
}
