package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.UbigeoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.UbigeoRequest;


@Mapper
public interface UbigeoMapper extends MantenibleMapper<UbigeoRequest, UbigeoResponse> 
{
	public List<UbigeoResponse> buscarTodos();

	public List<UbigeoResponse> buscarTodosPorDepartamentos();
	
	public List<UbigeoResponse> obtenerProvincias(@Param("codigoDepartamento") String codigoDepartamento);
	
	public List<UbigeoResponse> obtenerDistritos(@Param("codigoDepartamento") String codigoDepartamento
			 								    ,@Param("codigoProvincia") String codigoProvincia);
	
	public UbigeoResponse buscarPorCodigoUbigeo(@Param("codigoUbigeo") String codigoUbigeo);
	
	public void mantener(String modo, UbigeoRequest objetoMantenido ,String usuario);
}
