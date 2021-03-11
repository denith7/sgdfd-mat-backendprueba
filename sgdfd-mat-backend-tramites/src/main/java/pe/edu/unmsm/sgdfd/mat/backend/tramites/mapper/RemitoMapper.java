package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.RemitoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.RemitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.RemitoTramitResponse;

@Mapper
public interface RemitoMapper extends MantenibleMapper<RemitoRequest,RemitoResponse>{

	public List<RemitoResponse> buscarTodos();
	
	public RemitoTramitResponse buscarTramitePorEmpleadoYTipo(@Param("numeroDni") String numeroDni, @Param("idTipoTramite") Integer idTipoTramite);
}
