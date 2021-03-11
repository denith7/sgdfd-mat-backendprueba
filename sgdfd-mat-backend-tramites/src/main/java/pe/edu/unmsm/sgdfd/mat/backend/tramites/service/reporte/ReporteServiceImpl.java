package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.reporte;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.RemitoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.ReporteMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.FrecuenciaTramitesDerivadosFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.RankingTipoTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.SolicitudesPorEstadosFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.TiempoAtencionFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.ReporteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.FrecuenciaTramitesDerivadosResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.RankingTipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.RptSolicitudesPorEstadosResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.RptTiempoAtencionResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.remito.RemitoService;

/**
 * Ejecuta la lógica asociada a las operaciones para
 * la obtencion de informacion para la creacion de reportes sobre
 * las solicitudes realizadas en cada local
 * <p>
 *
 * @author Eric Robladillo
 */
@Service
@Transactional
public class ReporteServiceImpl extends MantenibleAuditadoService<ReporteRequest, RptTiempoAtencionResponse> implements ReporteService{
	
	private ReporteMapper reporteMapper;
	
	public ReporteServiceImpl (@Qualifier("reporteMapper") MantenibleMapper<ReporteRequest, RptTiempoAtencionResponse> mapper) {
		super(mapper);
		this.reporteMapper = (ReporteMapper) mapper;
	}
	
	
	@Override
	public List<RptTiempoAtencionResponse> tiempoAtencionFiltrado(TiempoAtencionFilter tiempoAtencionFilter) {
		return reporteMapper.tiempoAtencionFiltrado(tiempoAtencionFilter);
	}

	
	@Override
	public List<RptSolicitudesPorEstadosResponse> solicitudesPorEstadosFiltrado(SolicitudesPorEstadosFilter solicitudesPorEstadosFilter) {
		return reporteMapper.solicitudesPorEstadosFiltrado(solicitudesPorEstadosFilter);
	}


	@Override
	public List<FrecuenciaTramitesDerivadosResponse> frecuenciaTramitesDerivadosFiltrado(FrecuenciaTramitesDerivadosFilter frecuenciaTramitesDerivadosFilter) {
		return reporteMapper.frecuenciaTramitesDerivadosFiltrado(frecuenciaTramitesDerivadosFilter);
	}


	@Override
	public List<RankingTipoTramiteResponse> rankingTipoTramiteFiltrado(RankingTipoTramiteFilter rankingTipoTramiteFilter) {
		return reporteMapper.rankingTipoTramiteFiltrado(rankingTipoTramiteFilter);
	}



}
