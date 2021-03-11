package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.PerfilLocalTipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.PerfilLocalTipoTramiteRequest;


@Mapper
public interface PerfilLocalTipoTramiteMapper extends MantenibleMapper<PerfilLocalTipoTramiteRequest, PerfilLocalTipoTramiteResponse> {

	
	public List<PerfilLocalTipoTramiteResponse> buscarTodos();
	
	public PerfilLocalTipoTramiteResponse buscarPorId(@Param("idPerfil") Integer idPerfil, @Param("codigoLocal") String codigoLocal, @Param("idTipoTramite") Integer idTipoTramite);
	
	public PerfilLocalTipoTramiteResponse mantener(String modo, PerfilLocalTipoTramiteRequest objetoMantenido, String usuario);
}
