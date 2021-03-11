package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.CronogramaRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.CronogramaResponse;

@Mapper
public interface CronogramaMapper extends MantenibleMapper<CronogramaRequest, CronogramaResponse> 
{
	public List<CronogramaResponse> buscarPorIdTipoTramite(@Param("idTipoTramite") Integer codigoTipo);
	
	public List<CronogramaResponse> buscarPorIdTipoTramiteYCodigoLocal(@Param("idTipoTramite") Integer codigoTipo, @Param("codigoLocal") String codigoLocal);
}
