package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tree;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.tree.ChildrenNode;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.tree.ParentNode;

public interface ArbolDinamicoService extends MantenibleService<ParentNode, ParentNode>{

	public List<ChildrenNode> getData(Integer id); //id del padre
	public List<ParentNode> buildDynamicTree(Integer id); //id padre (raiz del arbol)
	
}
