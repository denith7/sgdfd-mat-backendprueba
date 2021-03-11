package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteDocumentoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteDocumentoRequest;


@Mapper
public interface TipoTramiteDocumentoMapper extends MantenibleMapper<TipoTramiteDocumentoRequest, TipoTramiteDocumentoResponse>{

	public List<TipoTramiteDocumentoResponse> buscarTodos();
	
	public TipoTramiteDocumentoResponse buscarPorIdTipoTramiteYIdTipoDocumento(@Param("idTipoTramite") Integer idTipoTramite, @Param("idTipoDocumento")String idTipoDocumento);
}
