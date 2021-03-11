package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PerfilLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PerfilLocalRequest;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PerfilLocalMapper extends MantenibleMapper<PerfilLocalRequest, PerfilLocalResponse> {
	
	
	public List<PerfilLocalResponse> buscarTodos();
	
	public PerfilLocalResponse buscarPorIdPerfilYCodigoLocal(@Param("idPerfil") Integer idPerfil,
															 @Param("codigoLocal") String codigoLocal);
	
	public List<PerfilLocalResponse> buscarPorIdPerfil(@Param("idPerfil") Integer idPerfil);
	
	public void mantener(String modo, PerfilLocalRequest objetoMantenido ,String usuario);

}
