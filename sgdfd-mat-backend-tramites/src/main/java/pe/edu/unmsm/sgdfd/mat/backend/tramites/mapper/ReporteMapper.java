package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.FrecuenciaTramitesDerivadosFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.RankingTipoTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.SolicitudesPorEstadosFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.TiempoAtencionFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.ReporteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.FrecuenciaTramitesDerivadosResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.RankingTipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.RptSolicitudesPorEstadosResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.RptTiempoAtencionResponse;

@Mapper
public interface ReporteMapper extends MantenibleMapper<ReporteRequest, RptTiempoAtencionResponse>{
	

	public List<RptTiempoAtencionResponse> tiempoAtencionFiltrado(TiempoAtencionFilter tiempoAtencionFilter);
	 
	public List<RptSolicitudesPorEstadosResponse> solicitudesPorEstadosFiltrado(SolicitudesPorEstadosFilter solicitudesPorEstadosFilter ); 
	
	public List<FrecuenciaTramitesDerivadosResponse> frecuenciaTramitesDerivadosFiltrado(FrecuenciaTramitesDerivadosFilter frecuenciaTramitesDerivadosFilter ); 
	
	public List<RankingTipoTramiteResponse> rankingTipoTramiteFiltrado(RankingTipoTramiteFilter rankingTipoTramiteFilter); 
	
	
}
