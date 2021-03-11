package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.configuraciontramite;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.ConfiguracionTramiteMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.CronogramaVigenteMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.TipoTramiteDestinatarioMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.TipoTramiteLocalMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.TipoTramiteRequisitoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.ConfiguracionTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.ConfiguracionTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.ConfiguracionTramiteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.CronogramaVigenteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteDestinatarioRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteLocalRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteLocalRequisitoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.cronograma.CronogramaVigenteService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.destinatario.TipoTramiteDestinatarioService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.localrequisito.TipoTramiteLocalRequisitoService;


/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de tramite
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link ConfiguracionTramiteService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link ConfiguracionTramiteMapper} solo para operaciones de mantenimiento. 
 *
 * @author Eric Robladillo
 */
@Service
@Transactional
public class ConfiguracionTramiteServiceImpl 
				implements ConfiguracionTramiteService{
	
	@Autowired
	private TipoTramiteLocalRequisitoService tipoTramiteLocalRequisitoService;
	
	@Autowired
	private CronogramaVigenteService cronogramaVigenteService;
	
	@Autowired
	private TipoTramiteDestinatarioService tipoTramiteDestinatarioService;
	
	@Autowired
	private ConfiguracionTramiteMapper configuracionTramiteMapper;
	
	
	@Override
	public ConfiguracionTramiteResponse buscarPorIdTipoTramiteYCodigoLocal(Integer idTipoTramite,	String codigoLocal) {
		return configuracionTramiteMapper.buscarPorIdTipoTramiteYCodigoLocal(idTipoTramite, codigoLocal);
	}

	@Override
	public ConfiguracionTramiteResponse registrarConfiguracionTramite (ConfiguracionTramiteRequest config){
		
		//LOCAL
		TipoTramiteLocalRequest tipoTramiteLocalRequest = TipoTramiteLocalRequest.builder().codigoLocal(config.getCodigoLocal())
				.idTipoTramite(config.getIdTipoTramite()).estado(config.getEstado()).informacionAdicionalHtml(config.getInformacionAdicionalHtml()).usuario(config.getUsuario()).build();
		
		configuracionTramiteMapper.prcConfiguracionLocal(tipoTramiteLocalRequest);
		
		//REQUISITOS
		config.getListaRequisitos().forEach(requisito -> {			
			TipoTramiteLocalRequisitoRequest tipoTramiteLocalRequisitoRequest = TipoTramiteLocalRequisitoRequest.builder().idTipoTramite(config.getIdTipoTramite())
					.codigoLocal(config.getCodigoLocal()).idRequisito(requisito.getIdRequisito()).numeroOrden(requisito.getNumeroOrden()).indicadorObligatorio(requisito.getIndicadorObligatorio())
					.estado(requisito.getEstado()).usuario(config.getUsuario()).build();
			
			configuracionTramiteMapper.prcConfiguracionRequisito(tipoTramiteLocalRequisitoRequest);
		});
		
		config.getListaRequisitosEliminados().forEach(requisito -> {
			TipoTramiteLocalRequisitoRequest tipoTramiteLocalRequisitoRequest = TipoTramiteLocalRequisitoRequest.builder().idTipoTramite(config.getIdTipoTramite())
					.codigoLocal(config.getCodigoLocal()).idRequisito(requisito).build();
			
			tipoTramiteLocalRequisitoService.eliminar(tipoTramiteLocalRequisitoRequest);
		});
		
		//CRONOGRAMAS
		config.getListaCronogramas().forEach(cronograma -> {			
			CronogramaVigenteRequest cronogramaVigenteRequest = CronogramaVigenteRequest.builder().idTipoTramite(config.getIdTipoTramite())
					.codigoLocal(config.getCodigoLocal()).idItem(cronograma.getIdItem()).periodoFecha(cronograma.getPeriodoFecha())
					.descripcion(cronograma.getDescripcion()).usuario(config.getUsuario()).build();

			configuracionTramiteMapper.prcConfiguracionCronograma(cronogramaVigenteRequest);
		});
		
		config.getListaCronogramasEliminados().forEach(cronograma -> {
			CronogramaVigenteRequest cronogramaVigenteRequest = CronogramaVigenteRequest.builder().idTipoTramite(config.getIdTipoTramite())
					.codigoLocal(config.getCodigoLocal()).idItem(cronograma).build();
			
			cronogramaVigenteService.eliminar(cronogramaVigenteRequest);;
		});
		
		//DESTINATARIOS
		config.getListaDestinatarios().forEach(destinatario -> {			
			TipoTramiteDestinatarioRequest tipoTramiteDestinatarioRequest = TipoTramiteDestinatarioRequest.builder().idTipoTramite(config.getIdTipoTramite())
					.idLocal(config.getCodigoLocal()).idItem(destinatario.getIdItem()).tipoDestino(destinatario.getTipoDestino())
					.codigoDependencia(destinatario.getCodigoDependencia()).codigoEmpleado(destinatario.getCodigoEmpleado())
					.codigoPrioridad(destinatario.getCodigoPrioridad()).indicaciones(destinatario.getIndicaciones())
					.codigoMotivo(destinatario.getCodigoMotivo()).tipoReceptor(destinatario.getTipoReceptor()).usuario(config.getUsuario()).build();
			
			configuracionTramiteMapper.prcConfiguracionDestinatario(tipoTramiteDestinatarioRequest);
		});
		
		config.getListaDestinatariosEliminados().forEach(destinatario -> {
			TipoTramiteDestinatarioRequest tipoTramiteDestinatarioRequest = TipoTramiteDestinatarioRequest.builder().idTipoTramite(config.getIdTipoTramite())
					.idLocal(config.getCodigoLocal()).idItem(destinatario).build();
			
			tipoTramiteDestinatarioService.eliminar(tipoTramiteDestinatarioRequest);
		});
		
		

		return configuracionTramiteMapper.buscarPorIdTipoTramiteYCodigoLocal(config.getIdTipoTramite(), config.getCodigoLocal());
	}
	
	@Override
	public List<ConfiguracionTramiteFilter> filtrarTramites(ConfiguracionTramiteFilter configuracionTramiteFilter){
		
		return configuracionTramiteMapper.filtrarTramites(configuracionTramiteFilter);
	}
	
}
