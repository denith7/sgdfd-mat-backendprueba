package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.MultitabDetResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.MultitabDetRequest;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface MultitabDetMapper extends MantenibleMapper<MultitabDetRequest, MultitabDetResponse> {

	List<MultitabDetResponse> buscarPorIdMultitabCab(@Param("idMultitabCab") int idMultitabCab);
	
	public List<MultitabDetResponse> buscarTodos();
	
	public MultitabDetResponse buscarPorIdMultitabCabYIdMultitabDet(@Param("idMultitabCab") Integer idMultitabCab,
								   @Param("idMultitabDet") String idMultitabDet);
	
	
	public void mantener(String modo, MultitabDetRequest objetoMantenido ,String usuario);
	
	
}
