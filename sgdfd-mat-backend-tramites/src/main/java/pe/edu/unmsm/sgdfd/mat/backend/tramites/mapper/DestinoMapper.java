package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.DestinoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.DestinoResponse;

@Mapper
public interface DestinoMapper extends MantenibleMapper<DestinoRequest,DestinoResponse>{

	public List<DestinoResponse> buscarTodos();
}
