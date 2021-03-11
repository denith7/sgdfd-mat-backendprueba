package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteDestinatarioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteDestinatarioRequest;


@Mapper
public interface TipoTramiteDestinatarioMapper extends MantenibleMapper<TipoTramiteDestinatarioRequest, TipoTramiteDestinatarioResponse>{
	
	public List<TipoTramiteDestinatarioResponse> buscarTodos();
	
	public List<TipoTramiteDestinatarioResponse> buscarPorIdTipoTramite(@Param("idTipoTramite") Integer idTipoTramite);
	
	public List<TipoTramiteDestinatarioResponse> buscarPorIdLocal(@Param("idLocal")String idLocal);
	
	public TipoTramiteDestinatarioResponse buscarPorIdTipoTramiteYIdLocalYIdItem(@Param("idTipoTramite") Integer idTipoTramite, @Param("idLocal")String idLocal, @Param("idItem")Integer idItem);
}
