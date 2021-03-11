package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.LocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.LocalRequest;


@Mapper
public interface LocalMapper extends MantenibleMapper<LocalRequest, LocalResponse> 
{

	public LocalResponse buscarPorId(@Param("codigoLocal") String codigoLocal);
	
	public List<LocalResponse> buscarTodos();
	
	public List<LocalResponse> buscarPorDocumento(@Param("numeroDocumento") String numeroDocumento);
	
	public List<LocalResponse> buscarPorGrupoLocal(@Param("idGrupoLocal") Integer idGrupoLocal);
	
	public void mantener(String modo, LocalRequest objetoMantenido ,String usuario);
}
