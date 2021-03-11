package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PerfilResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PerfilRequest;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PerfilMapper extends MantenibleMapper<PerfilRequest, PerfilResponse> {
	
	
	public List<PerfilResponse> buscarTodos();
	
	public PerfilResponse buscarPorIdPerfil(@Param("idPerfil") Integer idPerfil);
	
	public void mantener(String modo, PerfilRequest objetoMantenido ,String usuario);
	

}
