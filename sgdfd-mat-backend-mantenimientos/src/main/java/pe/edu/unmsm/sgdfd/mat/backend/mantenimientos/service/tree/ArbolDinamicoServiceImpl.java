package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tree;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.ArbolDinamicoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.tree.ChildrenNode;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.tree.ParentNode;

@Service
@Transactional
public class ArbolDinamicoServiceImpl extends MantenibleAuditadoService<ParentNode, ParentNode> implements ArbolDinamicoService {

	@Autowired
	private ArbolDinamicoMapper arbolDinamicoMapper;
	
	public ArbolDinamicoServiceImpl(@Qualifier("arbolDinamicoMapper") MantenibleMapper<ParentNode, ParentNode> mapper) {
		super(mapper);
		this.arbolDinamicoMapper = (ArbolDinamicoMapper) mapper;
	}

	@Override
	public List<ChildrenNode> getData(Integer id) {
		return arbolDinamicoMapper.getData(id);
	}

	@Override
	public List<ParentNode> buildDynamicTree(Integer id) {
		
		List<ParentNode> result = new ArrayList<>();
		List<ChildrenNode> data = getData(id);
		for (ChildrenNode nodeInfo : data) {
			ParentNode node = ParentNode
							  .builder()
							  .id(nodeInfo.getId())
							  .descripcion(nodeInfo.getDescripcion())
							  .children(buildDynamicTree(nodeInfo.getId()))
							  .build();
			result.add(node);
		}
		
		return result;
	}
	
}
