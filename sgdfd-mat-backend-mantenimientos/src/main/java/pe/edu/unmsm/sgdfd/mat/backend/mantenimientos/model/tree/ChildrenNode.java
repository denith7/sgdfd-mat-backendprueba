package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChildrenNode {
	
	private Integer id;
	private String	descripcion;
	
}
