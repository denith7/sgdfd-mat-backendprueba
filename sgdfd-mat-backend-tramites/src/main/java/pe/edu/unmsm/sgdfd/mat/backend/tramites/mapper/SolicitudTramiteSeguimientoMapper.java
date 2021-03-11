package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteSeguimientoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.SolicitudTramiteSegNotifResponse;

@Mapper
public interface SolicitudTramiteSeguimientoMapper extends MantenibleMapper<SolicitudTramiteSeguimientoRequest, SolicitudTramiteSegNotifResponse> {

	public List<SolicitudTramiteSegNotifResponse> notificacionTramiteDerivadoObservado(@Param("numeroDocumento") String numeroDocumento);
	
	public void actualizarEstadoNotificacion(@Param("idTramiteSeguimiento") Integer idTramiteSeguimiento, @Param("estadoNotifLeido") Integer estadoNotifLeido);
	
	public SolicitudTramiteSegNotifResponse obtenerSeguimiento(@Param("idTramiteSeguimiento") Integer idTramiteSeguimiento);
	
	public List<SolicitudTramiteSegNotifResponse> seguimientoSolicitudCompleto(@Param("idSolicitudTramite") Integer idSolicitudTramite);
	
}
