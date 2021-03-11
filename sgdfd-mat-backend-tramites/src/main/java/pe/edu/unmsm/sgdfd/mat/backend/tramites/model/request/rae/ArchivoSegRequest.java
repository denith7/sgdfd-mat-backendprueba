package pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.rae;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArchivoSegRequest {
	
	//MAE_PERSONA
	private String tipoDocumento;
	private String numeroDocumento;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	
	//MOV_REFERENCIA			//El id referencia debe generarse y guardarse acá
	private Integer idOrigen;
	private String	codigoReferencia;
	private String	referencia;
	
	//MOV_REFERENCIA_META_DATA   		//id referencia a insertar acá
	private List<ArchivoMetadataRequest> lsMetaData;
	
	//MOV_ARCHIVO //Aca tambien insertar el id referencia
	private String nombreArchivo;
	private byte[] archivo;
	private String formato;
	private Integer numeroPaginas;
	private String claveAcceso;
	
	private String usuario;
	
	
	
	
	
}
