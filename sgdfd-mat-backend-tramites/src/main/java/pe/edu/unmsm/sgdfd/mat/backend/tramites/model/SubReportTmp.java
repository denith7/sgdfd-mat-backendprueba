package pe.edu.unmsm.sgdfd.mat.backend.tramites.model;

import org.apache.commons.io.output.ByteArrayOutputStream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubReportTmp {
	private ByteArrayOutputStream bos; 
	private String fileName;
}
