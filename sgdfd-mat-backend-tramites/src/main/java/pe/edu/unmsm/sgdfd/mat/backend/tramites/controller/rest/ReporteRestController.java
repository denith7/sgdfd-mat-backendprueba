package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.LocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.FrecuenciaTramitesDerivadosFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.RankingTipoTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.SolicitudesPorEstadosFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.reporte.TiempoAtencionFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.FrecuenciaTramitesDerivadosResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.RankingTipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.RptSolicitudesPorEstadosResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.reporte.RptTiempoAtencionResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.reporte.ReporteService;

/**
 * Recibe las solicitudes relacionadas a obtencion de listas de tipo RptTiempoAtencionResponse y
 * RptSolicitudesPorEstadosResponse para su uso en reportes
 * <p>
 * Comprende las siguientes operaciones:
 * <ul>
 *  <li>Búsqueda de una lista de tipo RptTiempoAtencionResponse mediante filtros
 *  <li>Búsqueda de una lista de tipo RptSolicitudesPorEstadosResponse mediante filtros
 * </ul>
 * 
 * @author Eric Robladillo
 * @see RptTiempoAtencionResponse
 * @see RptSolicitudesPorEstadosResponse
 */

@Validated
@RestController
@RequestMapping("/reporte")
public class ReporteRestController {
	
	private ReporteService reporteService;
	
	public ReporteRestController (ReporteService reporteService) {
		this.reporteService = reporteService;
	}
	
	/**
	 * Retorna una lista de tipo RptTiempoAtencionResponse mediante el uso de un filtro de tipo TiempoAtencionFilter
	 * 
	 * @return lista obtenida por busqueda de tipo:
	 * 			{@link RptTiempoAtencionResponse} 
	 */
	@PostMapping("/tiempo-atencion/filtrar") 
	@PreAuthorize("hasPermission('REP_TRAMITE','101')")
	public List<RptTiempoAtencionResponse> tiempoAtencionFiltrado(@RequestBody TiempoAtencionFilter tiempoAtencionFilter ){
		return reporteService.tiempoAtencionFiltrado(tiempoAtencionFilter);
	}	
	
	/**
	 * Retorna una lista de tipo RptSolicitudesPorEstadosResponse mediante el uso de un filtro de tipo SolicitudesPorEstadosFilter
	 * 
	 * @return lista obtenida por busqueda de tipo:
	 * 			{@link RptSolicitudesPorEstadosResponse} 
	 */
	@PostMapping("/solicitudes-por-estados/filtrar")
	@PreAuthorize("hasPermission('REP_TRAMITE','102')")
	public List<RptSolicitudesPorEstadosResponse> solicitudesPorEstadosFiltrado(@RequestBody SolicitudesPorEstadosFilter solicitudesPorEstadosFilter){
		return reporteService.solicitudesPorEstadosFiltrado(solicitudesPorEstadosFilter);
	}
	
	/**
	 * Retorna una lista de tipo FrecuenciaTramiteDerivadosResponse mediante el uso de un filtro de tipo FrecuenciaTramiteDerivadosFilter
	 * 
	 * @return lista obtenida por busqueda de tipo:
	 * 			{@link FrecuenciaTramitesDerivadosResponse} 
	 */
	@PostMapping("/frecuencia-tramites-derivados/filtrar")
	@PreAuthorize("hasPermission('REP_TRAMITE','103')")
	public List<FrecuenciaTramitesDerivadosResponse> frecuenciaTramitesDerivadosFiltrado(@RequestBody FrecuenciaTramitesDerivadosFilter frecuenciaTramitesDerivadosFilter ){
		return reporteService.frecuenciaTramitesDerivadosFiltrado(frecuenciaTramitesDerivadosFilter);
	}
	
	/**
	 * Retorna una lista de tipo RankingTipoTramiteResponse mediante el uso de un filtro de tipo RankingTipoTramiteFilter
	 * 
	 * @return lista obtenida por busqueda de tipo:
	 * 			{@link RankingTipoTramiteResponse} 
	 */
	@PostMapping("/ranking-tipo-tramite/filtrar")
	@PreAuthorize("hasPermission('REP_TRAMITE','104')")
	public List<RankingTipoTramiteResponse> rankingTipoTramiteFiltrado(@RequestBody RankingTipoTramiteFilter rankingTipoTramiteFilter){
		return reporteService.rankingTipoTramiteFiltrado(rankingTipoTramiteFilter);
	}
}
