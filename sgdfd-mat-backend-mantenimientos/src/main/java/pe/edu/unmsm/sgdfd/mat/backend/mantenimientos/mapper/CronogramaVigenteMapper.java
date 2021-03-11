package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.CronogramaVigenteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.CronogramaVigenteRequest;

@Mapper
public interface CronogramaVigenteMapper extends MantenibleMapper<CronogramaVigenteRequest, CronogramaVigenteResponse> 
{
	public List<CronogramaVigenteResponse> buscarTodos();
	
	public List<CronogramaVigenteResponse> buscarPorIdTipoTramite(@Param("idTipoTramite") Integer codigoTipo);
	
	public List<CronogramaVigenteResponse> buscarPorIdTipoTramiteYCodigoLocal(@Param("idTipoTramite") Integer codigoTipo, @Param("codigoLocal") String codigoLocal);
	
	public CronogramaVigenteResponse buscarPorIdTipoTramiteYIdItemYCodigoLocal(@Param("idTipoTramite") Integer codigoTipo, @Param("idItem") Integer idItem, @Param("codigoLocal") String codigoLocal);
	
	public void mantener(String modo, CronogramaVigenteRequest objetoMantenido ,String usuario);
}
