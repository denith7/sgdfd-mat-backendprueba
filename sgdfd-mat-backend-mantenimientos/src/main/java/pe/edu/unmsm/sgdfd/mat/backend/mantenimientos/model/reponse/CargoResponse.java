package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargoResponse
{
    private String 	codigoCargo;
    private String 	descripcion;
    private String 	estado;
    private String  descripcionEstado;
    private String  usuario;


}
