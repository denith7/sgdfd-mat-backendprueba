package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.reporte;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.FrecuenciaTramitesDerivadosFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.RankingTipoTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.SolicitudesPorEstadosFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.TiempoAtencionFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.RemitoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.ReporteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.RemitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.FrecuenciaTramitesDerivadosResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.RankingTipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.RptSolicitudesPorEstadosResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.RptTiempoAtencionResponse;

/**
 * Define los métodos asociados a la obtencion de informacion para la creacion de reportes sobre
 * las solicitudes realizadas en cada local, los cuales deberán ser implementados.
 * <p>
 * 
 * @author Eric Robladillo
 */

public interface ReporteService extends MantenibleService<ReporteRequest, RptTiempoAtencionResponse>{


	/**
	 * Retorna una lista de tipo RptTiempoAtencionResponse, referente al tiempo de atencion
	 * brindado a las solicitudes de cada local
	 * 
	 * @param tiempoAtencionFilter
	 * 			Filtro para la busqueda
	 * @return
	 */
	public List<RptTiempoAtencionResponse> tiempoAtencionFiltrado(TiempoAtencionFilter tiempoAtencionFilter);

	/**
	 * Retorna una lista de tipo RptSolicitudesPorEstadosResponse, referente al estado de 
	 * las solicitudes de cada local
	 * 
	 * @param solicitudesPorEstadosFilter
	 * 			Filtro para la busqueda
	 * @return
	 */
	public List<RptSolicitudesPorEstadosResponse> solicitudesPorEstadosFiltrado(SolicitudesPorEstadosFilter solicitudesPorEstadosFilter );

	/**
	 * Retorna una lista de tipo FrecuenciaTramiteDerivadosResponse, referente 
	 * las solicitudes de cada local en estado derivado
	 * 
	 * @param frecuenciaTramitesDerivadosFilter
	 * 			Filtro para la busqueda
	 * @return
	 */
	public List<FrecuenciaTramitesDerivadosResponse> frecuenciaTramitesDerivadosFiltrado(FrecuenciaTramitesDerivadosFilter frecuenciaTramitesDerivadosFilter);

	/**
	 * Retorna una lista de tipo RankingTipoTramiteResponse, referente a
	 * cuantas solicitudes son derivadas y cuantas hay en total
	 * 
	 * @param rankingTipoTramiteFilter
	 * 			Filtro para la busqueda
	 * @return
	 */
	public List<RankingTipoTramiteResponse> rankingTipoTramiteFiltrado(RankingTipoTramiteFilter rankingTipoTramiteFilter);

	
}
