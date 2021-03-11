package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoResponse
{   private String tablaOrigen;
    private String codigoEstado;
    private String nombreEstado;
    private String descripcionEstado;
    private String usuario;
}