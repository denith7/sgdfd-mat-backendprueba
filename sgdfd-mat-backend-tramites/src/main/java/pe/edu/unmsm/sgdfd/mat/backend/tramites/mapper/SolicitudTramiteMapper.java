package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.ReporteSolicitudCodigoDniFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.ReporteSolicitudTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta.ReporteSolicitudTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta.SolicitudTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.SolicitudTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteFilterRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.SolicitudTramiteEstadisticaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.SolicitudTramiteSegNotifResponse;


@Mapper
public interface SolicitudTramiteMapper extends MantenibleMapper<SolicitudTramiteRequest,SolicitudTramiteResponse> 
{
	public SolicitudTramiteResponse buscarPorId(@Param("idSolicitudTramite") Integer idSolicitudTramite);
	
	public SolicitudTramiteResponse  buscarPorIdYNumeroDocumento(@Param("idSolicitudTramite") Integer idSolicitudTramite,@Param("numeroDocumento") String numeroDocumento);
	
	public List<SolicitudTramiteResponse> buscarTodosSolicitudTramite();
	
	public List<SolicitudTramiteResponse> buscarPorNumeroDocumento(@Param("numeroDocumento") String numeroDocumento);
	
	public List<SolicitudTramiteResponse> buscarPorNumeroDocumentoTipoTramite(@Param("numeroDocumento") String numeroDocumento, @Param("idTipoTramite") Integer codigoTipo);
	
	public List<SolicitudTramiteResponse> buscarPorLocal(@Param("codigoLocal") String codigoLocal);
	
	public List<SolicitudTramiteResponse> buscarPorLocalEstado(@Param("codigoLocal") String codigoLocal);
	
	public List<SolicitudTramiteResponse> filtrarSolicitudTramite(SolicitudTramiteFilterRequest solicitudTramiteFilterRequest);

	public List<SolicitudTramiteResponse> buscarPorTipoTramiteYLocal(@Param("idTipoTramite") String idTipoTramite,@Param("codigoLocal") String codigoLocal);
	
	public ReporteSolicitudTramiteResponse buscarReporteSolicitudTramite(ReporteSolicitudTramiteFilter reporteSolicitudTramiteFilter);
	
	public ReporteSolicitudTramiteResponse buscarReportePorCodigoYDni(ReporteSolicitudCodigoDniFilter reporteSolicitudTramiteFilter);
	

	public SolicitudTramiteResponse buscarPorCriterio(SolicitudTramiteFilter solicitudTramiteFilter);
	
	public void mantener(String modo, SolicitudTramiteRequest objetoMantenido ,String usuario);
	
	public Integer totalSolicitudesAtendidas();
	
	public List<SolicitudTramiteEstadisticaResponse> solicitudesRealizadasEnLaUltimaSemana();
	
	public List<SolicitudTramiteSegNotifResponse> notificacionTramiteDerivadoObservado(@Param("numeroDocumento") String numeroDocumento);
	
	public void actualizarEstadoNotificacion(@Param("idTramiteSeguimiento") Integer idTramiteSeguimiento, @Param("estadoNotifLeido") Integer estadoNotifLeido);
	
	public SolicitudTramiteSegNotifResponse obtenerSeguimiento(@Param("idTramiteSeguimiento") Integer idTramiteSeguimiento);
	
}
