package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.UnidadAcademicaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.UnidadAcademicaRequest;

@Mapper
public interface UnidadAcademicaMapper extends MantenibleMapper<UnidadAcademicaRequest, UnidadAcademicaResponse>{
	
	public List<UnidadAcademicaResponse> buscarTodos();
	
	public List<UnidadAcademicaResponse> buscarPorCodigoLocal(@Param("codigoLocal") String codigoLocal);
	
	public UnidadAcademicaResponse buscarPorCodigoLocalYCodigoUnidadAcademica(@Param("codigoLocal") String codigoLocal, @Param("codigoUnidadAcademica") Integer codigoUnidadAcademica);

	public void mantener(String modo, UnidadAcademicaRequest objetoMantenido ,String usuario);
	
}


