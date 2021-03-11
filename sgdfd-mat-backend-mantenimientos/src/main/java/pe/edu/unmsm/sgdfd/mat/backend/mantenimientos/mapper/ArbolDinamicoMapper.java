package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.tree.ChildrenNode;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.tree.ParentNode;

@Mapper
public interface ArbolDinamicoMapper extends MantenibleMapper<ParentNode, ParentNode>{

	public List<ChildrenNode> getData(Integer id); //id padre 
	public List<ParentNode> buildDynamicTree(Integer id); //id padre (raiz del arbol)
	
}
