package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.FormularioCamposResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.FormularioCamposRequest;

@Mapper
public interface FormularioCamposMapper extends MantenibleMapper<FormularioCamposRequest, FormularioCamposResponse> {

	public List<FormularioCamposResponse> buscarTodos();
	
	public List<FormularioCamposResponse> buscarPorIdFormulario(@Param("idFormulario") Integer idFormulario);
}
