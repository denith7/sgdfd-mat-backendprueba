package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.CargoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.CargoRequest;


@Mapper
public interface CargoMapper extends MantenibleMapper<CargoRequest, CargoResponse> 
{

	public List<CargoResponse> buscarTodos();
	
	public CargoResponse buscarPorCodigoCargo(@Param("codigoCargo") String codigoCargo);
	
	public void mantener(String modo, CargoRequest objetoMantenido ,String usuario);
}
