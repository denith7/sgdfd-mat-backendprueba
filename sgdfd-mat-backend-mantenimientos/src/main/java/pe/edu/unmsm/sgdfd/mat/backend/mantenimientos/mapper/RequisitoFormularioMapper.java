package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoFormularioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.RequisitoFormularioRequest;

@Mapper
public interface RequisitoFormularioMapper extends MantenibleMapper<RequisitoFormularioRequest, RequisitoFormularioResponse>{


	public List<RequisitoFormularioResponse> buscarTodos();
	
}
