package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteLocalRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteLocalRequisitoRequest;


@Mapper
public interface TipoTramiteLocalRequisitoMapper extends MantenibleMapper<TipoTramiteLocalRequisitoRequest, TipoTramiteLocalRequisitoResponse> {

	public List<TipoTramiteLocalRequisitoResponse> buscarTodos();
	
	public List<TipoTramiteLocalRequisitoResponse> buscarPorIdTipoTramite(@Param("idTipoTramite")Integer idTipoTramite);
	
	public List<TipoTramiteLocalRequisitoResponse> buscarPorIdRequisito(@Param("idRequisito")Integer idRequisito);

	public TipoTramiteLocalRequisitoResponse buscarPorIdTipoTramiteYCodigoLocalYIdRequisito(@Param("idTipoTramite")Integer idTipoTramite, @Param("codigoLocal")String codigoLocal, @Param("idRequisito") Integer idRequisito);

}
