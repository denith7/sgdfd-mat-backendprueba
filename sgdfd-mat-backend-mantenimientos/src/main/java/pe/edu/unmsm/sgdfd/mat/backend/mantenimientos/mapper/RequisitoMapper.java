package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.RequisitoRequest;


@Mapper
public interface RequisitoMapper extends MantenibleMapper<RequisitoRequest, RequisitoResponse> 
{
	public List<RequisitoResponse> buscarTodos();
	
	public RequisitoResponse buscarPorIdRequisito(@Param("idRequisito") Integer idRequisito);
	
	public List<RequisitoResponse> buscarPorIdTipoTramite(@Param("idTipoTramite")String idTipoTramite);

	public List<RequisitoResponse> buscarPorIdTipoTramiteYCodigoLocal(@Param("idTipoTramite")String idTipoTramite, @Param("codigoLocal")String codigoLocal);
}
