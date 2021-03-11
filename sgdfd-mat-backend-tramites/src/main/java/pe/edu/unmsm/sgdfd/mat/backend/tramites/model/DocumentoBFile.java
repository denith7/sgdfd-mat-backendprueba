package pe.edu.unmsm.sgdfd.mat.backend.tramites.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoBFile {
	
	private String docType;
	private byte[] inputBlob;
	private String filePath;
	private String fileName;
	
}
