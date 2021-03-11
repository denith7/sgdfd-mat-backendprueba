package pe.edu.unmsm.sgdfd.mat.backend.tramites.service.remito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper.RemitoMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.DestinoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.RemitoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.RemitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.RemitoTramitResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.destino.DestinoService;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento de remito
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link RemitoService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link RemitoMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 */
@Service
@Transactional
public class RemitoServiceImpl extends MantenibleAuditadoService<RemitoRequest, RemitoResponse> implements RemitoService{

	@Autowired
	private DestinoService destinoService;
	
	private RemitoMapper remitoMapper;
	
	/**
     * Instancia la interface {@link RemitoMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public RemitoServiceImpl(
			@Qualifier("remitoMapper") MantenibleMapper<RemitoRequest, RemitoResponse> mapper) {
		super(mapper);
		this.remitoMapper = (RemitoMapper) mapper;
	}
	
	@Override
	public List<RemitoResponse> buscarTodos(){
		return remitoMapper.buscarTodos();
	}

	@Override
	public RemitoRequest registrarRemito(RemitoRequest remitoRequest) {
		
		RemitoRequest remito = RemitoRequest.builder().anioEmision(remitoRequest.getAnioEmision())
				.numeroEmision(remitoRequest.getNumeroEmision())
				.numeroCorrelativo(remitoRequest.getNumeroCorrelativo())
				.tipoEmision(remitoRequest.getTipoEmision())
				.anioExpediente(remitoRequest.getAnioExpediente())
				.numeroExpediente(remitoRequest.getNumeroExpediente())
				.numeroSecuencialExpediente(remitoRequest.getNumeroSecuencialExpediente())
				.codigoLocal(remitoRequest.getCodigoLocal())
				.codigoDependenciaEmision(remitoRequest.getCodigoDependenciaEmision())
				.tipoDocumentoSolicitante(remitoRequest.getTipoDocumentoSolicitante())
				.numeroDocumentoSolicitante(remitoRequest.getNumeroDocumentoSolicitante())
				.codigoEmpleadoEmision(remitoRequest.getCodigoEmpleadoEmision())
				.codigoEmpleadoResponsable(remitoRequest.getCodigoEmpleadoResponsable())
				.asunto(remitoRequest.getAsunto())
				.numeroFolios(remitoRequest.getNumeroFolios())
				.numeroDiasAtencion(remitoRequest.getNumeroDiasAtencion())
				.codigoDependenciaMp(remitoRequest.getCodigoDependenciaMp())
				.idTipoTramite(remitoRequest.getIdTipoTramite()).build();
				
		registrar(remito);
		
		remitoRequest.getLsdestinatarios().forEach(str ->{
			destinoService.registrarDestino(
					DestinoRequest.builder().anio(remitoRequest.getAnioEmision()).numeroEmision(remitoRequest.getNumeroEmision())
					.codigoDependencia(str.getCodigoDependencia()).codigoEmpleado(str.getCodigoEmpleado()).codigoPrioridad(str.getCodigoPrioridad())
					.fechaDerivacion(str.getFechaDerivacion()).estado(str.getEstado()).build()
					);
			str.setAnio(remito.getAnioEmision());
			str.setNumeroEmision(remito.getNumeroEmision());
			
		});
		remitoRequest.setAnioEmision(remito.getAnioEmision());
		remitoRequest.setNumeroEmision(remito.getNumeroEmision());
		
		
		return remitoRequest;
	}
	

	@Override
	public RemitoTramitResponse buscarTramitePorEmpleadoYTipo(String numeroDni, Integer idTipoTramite) {
		return remitoMapper.buscarTramitePorEmpleadoYTipo(numeroDni,idTipoTramite);
	}
}
