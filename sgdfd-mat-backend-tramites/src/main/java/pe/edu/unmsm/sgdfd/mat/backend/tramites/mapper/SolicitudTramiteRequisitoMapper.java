package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta.SolicitudTramiteRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.SolicitudTramiteRequisitoFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.id.DetalleSolicitudTramiteId;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoRequest;


@Mapper
public interface SolicitudTramiteRequisitoMapper extends MantenibleMapper<SolicitudTramiteRequisitoRequest, SolicitudTramiteRequisitoResponse> 
{
	public SolicitudTramiteRequisitoResponse buscarPorId(DetalleSolicitudTramiteId id);
	
	public List<SolicitudTramiteRequisitoResponse> buscarPorCriterio(SolicitudTramiteRequisitoFilter criterioBusqueda);
	
	public List<SolicitudTramiteRequisitoResponse> buscarTodos();
	
	public void mantener(String modo, SolicitudTramiteRequisitoRequest objetoMantenido ,String usuario);
}
