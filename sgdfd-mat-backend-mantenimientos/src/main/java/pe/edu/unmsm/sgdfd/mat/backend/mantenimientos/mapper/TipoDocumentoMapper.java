package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoDocumentoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoDocumentoRequest;

@Mapper
public interface TipoDocumentoMapper extends MantenibleMapper<TipoDocumentoRequest, TipoDocumentoResponse>{

	public List<TipoDocumentoResponse> buscarTodos();
	
	public TipoDocumentoResponse buscarPorId(@Param("idTipoDocumento") String idTipoDocumento);
	
	public List<TipoDocumentoResponse> buscarPorIdTipoTramite(@Param("idTipoTramite") Integer idTipoTramite);
	
}
