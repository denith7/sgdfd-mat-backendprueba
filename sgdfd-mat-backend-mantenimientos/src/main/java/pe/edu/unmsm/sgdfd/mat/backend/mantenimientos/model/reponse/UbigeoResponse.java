package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UbigeoResponse {
	private String codigoUbigeo;
	private String codigoDepartamento;	
    private String codigoProvincia;
    private String codigoDistrito;
    private String nombre;
    private String usuario;
    	
}
