package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.MultitabCabResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.MultitabCabRequest;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MultitabCabMapper extends MantenibleMapper<MultitabCabRequest, MultitabCabResponse> {
	
	
	public List<MultitabCabResponse> buscarTodos();
	
	public MultitabCabResponse buscarPorIdMultitabCab(@Param("idMultitabCab") Integer idMultitabCab);
	
	public void mantener(String modo, MultitabCabRequest objetoMantenido ,String usuario);
	

}
