package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest;


import java.util.List;

import javax.validation.groups.Default;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.IdNumerico;
import pe.edu.unmsm.commons.validation.validation.group.IActualizacion;
import pe.edu.unmsm.commons.validation.validation.group.IRegistro;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.consulta.SolicitudTramiteRequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.id.DetalleSolicitudTramiteId;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoEstadoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoObservarRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.request.SolicitudTramiteRequisitoValorRequest;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.solicitudtramiterequisito.SolicitudTramiteRequisitoService;

/**
 * --
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Buscar todos los requisitos de solicitudes de trámite
 * 	<li>Búsqueda de un requisito de solicitud de trámite por identificador de solicitud de trámite, identificador de tipo de trámite e identificador requisito
 * 	<li>Registro de un requisito de solicitud de trámite
 * 	<li>Actualización de requisito de solicitud de trámite
 * 	<li>Actualización de valor de un requisito de solicitud de trámite
 * 	<li>Actualización de requisito de solicitud de trámite
 * 	<li>Actualización de estado de un requisito de solicitud de trámite
 * </ul>
 * 
 * @author Miguel Moya
 * @see SolicitudTramiteRequisitoRequest
 * @see SolicitudTramiteRequisitoResponse
 * @see SolicitudTramiteRequisitoService
 */
@Validated
@RestController
@RequestMapping("/solicitud-tramite-requisitos")
public class SolicitudTramiteRequisitoRestController {
	
	private SolicitudTramiteRequisitoService solicitudTramiteRequisitoService;
	
	public SolicitudTramiteRequisitoRestController(SolicitudTramiteRequisitoService detalleSolicitudTramiteService) {
		this.solicitudTramiteRequisitoService =  detalleSolicitudTramiteService;
	}
	
	/**
	 * Muestra una lista de todos los requisito de solicitud de trámite  
	 * @param --
	 * 			
	 * @param --
	 * @return	lista de requisito de solicitud de trámite obtenidos por búsqueda son de tipo:
	 * 			{@link SolicitudTramiteRequisitoResponse}
	 */
	@GetMapping
	@PreAuthorize("hasPermission('MAN_SOLICITUD_TRAMITE_REQUISITO','101')")
    public List<SolicitudTramiteRequisitoResponse> buscarSolicitudTramite()
    {
        return solicitudTramiteRequisitoService.buscarTodos();
    }
	
	
	
	/**
	 * Retorna una lista de requisito de solicitud de trámite buscados por atributo:  
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param idRequisito
	 * 			el identificador de requisito
	 * @param --
	 * @return	requisito de solicitud de trámite obtenido por búsqueda:
	 * 			{@link TipoTramiteRequisitoResponse}
	 */
	@GetMapping("/{idSolicitudTramite}/tipo-tramite/{idTipoTramite}/requisitos/{idRequisitos}/idItem/{idItem}")
	@PreAuthorize("hasPermission('MAN_SOLICITUD_TRAMITE_REQUISITO','102')")
	public SolicitudTramiteRequisitoResponse buscarPorIdSolicitudTramiteYIdTipoTramiteYIdRequisitos(
    		  @IdNumerico(maxRange = 9999999999L)@PathVariable("idSolicitudTramite") Integer idSolicitudRequisito     		
    		, @IdNumerico(maxRange = 9999999999L)@PathVariable("idTipoTramite") Integer idTipoTramite
    		, @IdNumerico(maxRange = 9999999999L)@PathVariable("idRequisitos") Integer idRequisitos
    		, @IdNumerico(maxRange = 9999999999L)@PathVariable("idItem") Integer idItem)
    {
        return solicitudTramiteRequisitoService.buscarPorId(DetalleSolicitudTramiteId.builder()
        		.idRequisito(idRequisitos)
        		.idTipoTramite(idTipoTramite)
        		.idSolicitudTramite(idSolicitudRequisito)
        		.idItem(idItem)
        		.build());
    }
	
	
	/**
	 * Recibe petición de registro de requisito de solicitud de trámite
	 * @param solicitudTramiteRequisitoRequest
	 * 			el tipo trámite requisito a registrar
	 * @param --
	 * @return	requisito de solicitud de trámite registrado
	 * 			{@link --}
	 */
    @PostMapping
    @PreAuthorize("hasPermission('MAN_SOLICITUD_TRAMITE_REQUISITO','201')")
    public SolicitudTramiteRequisitoRequest registrarSolicitudTramite(
            @Validated({ IRegistro.class, Default.class }) @RequestBody SolicitudTramiteRequisitoRequest solicitudTramiteRequisitoRequest){
        return solicitudTramiteRequisitoService.registrarDetalleSolicitudTramite(solicitudTramiteRequisitoRequest);
    }

    
    
    /**
	 * Recibe petición de actualización de requisito de solicitud de trámite
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param idRequisito
	 * 			el identificador de requisito
	 * @param solicitudTramite
	 * 			requisito de solicitud de trámite a actualizar
	 * @param --
	 * @return	requisito de solicitud de trámite actualizado
	 * 			{@link --}
	 */
    @PutMapping("/{idSolicitudTramite}/tipo-tramite/{idTipoTramite}/requisitos/{idRequisito}")
    @PreAuthorize("hasPermission('MAN_SOLICITUD_TRAMITE_REQUISITO','301')")
    public SolicitudTramiteRequisitoRequest actualizarSolicitudTramite(@Validated({ IActualizacion.class,Default.class }) 
    		 @IdNumerico(maxRange = 9999999999L)@PathVariable("idSolicitudTramite") Integer idSolicitudTramite
    		,@IdNumerico(maxRange = 9999999999L)@PathVariable("idTipoTramite") Integer idTipoTramite
    		,@IdNumerico(maxRange = 9999999999L)@PathVariable("idRequisito") Integer idRequisito
    		,@RequestBody SolicitudTramiteRequisitoRequest solicitudTramite, Errors error)
    {
        solicitudTramite.setIdSolicitudTramite(idSolicitudTramite);
        solicitudTramite.setIdRequisito(idRequisito);
        solicitudTramite.setIdTipoTramite(idTipoTramite);
        
        return solicitudTramiteRequisitoService.actualizarDetalleSolicitudTramite(
        		DetalleSolicitudTramiteId.builder()
        			.idRequisito(idRequisito)
        			.idSolicitudTramite(idSolicitudTramite)
        			.idTipoTramite(idTipoTramite).build()
        		, solicitudTramite);
    }
    
    
    /**
	 * Recibe petición de actualización de valor de requisito de solicitud de trámite
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param idRequisito
	 * 			el identificador de requisito
	 * @param solicitudTramiteRequisitoEstadoRequest
	 * 			requisito de solicitud de trámite a actualizar
	 * @param --
	 * @return	requisito de solicitud de trámite actualizado
	 * 			{@link SolicitudTramiteRequisitoResponse}
	 */
    @PutMapping("/{idSolicitudTramite}/tipo-tramite/{idTipoTramite}/requisitos/{idRequisito}/item/{idItem}")
    @PreAuthorize("hasPermission('MAN_SOLICITUD_TRAMITE_REQUISITO','302')")
    public SolicitudTramiteRequisitoResponse actualizarValorRequisito(@Validated({ IActualizacion.class,Default.class }) 
    		 @IdNumerico(maxRange = 9999999999L)@PathVariable("idSolicitudTramite") Integer idSolicitudTramite
    		,@IdNumerico(maxRange = 9999999999L)@PathVariable("idTipoTramite") Integer idTipoTramite
    		,@IdNumerico(maxRange = 9999999999L)@PathVariable("idRequisito") Integer idRequisito
    		,@IdNumerico(maxRange = 9999999999L)@PathVariable("idItem") Integer idItem
    		,@RequestBody SolicitudTramiteRequisitoValorRequest solicitudTramite, Errors error)
    {
                
    	  return solicitudTramiteRequisitoService.actualizarValor(
          		DetalleSolicitudTramiteId.builder().idSolicitudTramite(idSolicitudTramite)
              	.idRequisito(idRequisito)
              	.idTipoTramite(idTipoTramite)
              	.idItem(idItem)
              	.build()
              	,
          		solicitudTramite);
    }
    

    /**
	 * Recibe petición de actualización de requisito de solicitud de trámite
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param idRequisito
	 * 			el identificador de requisito
	 * @param idItem
	 * 			el identificador de item
	 * @param solicitudTramite
	 * 			requisito de solicitud de trámite a actualizar
	 * @param --
	 * @return	requisito de solicitud de trámite actualizado
	 * 			{@link --}
	 */
    @PutMapping("/{idSolicitudTramite}/tipo-tramite/{idTipoTramite}/requisitos/{idRequisito}/observar/{idItem}")
    @PreAuthorize("hasPermission('MAN_SOLICITUD_TRAMITE_REQUISITO','303')")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void actualizarSolicitudTramite(@Validated({ IActualizacion.class,Default.class }) 
    		 @IdNumerico(maxRange = 9999999999L)@PathVariable("idSolicitudTramite") Integer idSolicitudTramite
    		,@IdNumerico(maxRange = 9999999999L)@PathVariable("idTipoTramite") Integer idTipoTramite
    		,@IdNumerico(maxRange = 9999999999L)@PathVariable("idRequisito") Integer idRequisito
    		,@IdNumerico(maxRange = 9999999999L)@PathVariable("idItem") Integer idItem
    		,@RequestBody SolicitudTramiteRequisitoObservarRequest solicitudTramite, Errors error)
    {	

        
        solicitudTramiteRequisitoService.observar(idSolicitudTramite, idTipoTramite, idRequisito,idItem, solicitudTramite);
    }
    
    /**
	 * Recibe petición de actualización de estado de requisito de solicitud de trámite
	 * @param idSolicitudTramite
	 * 			el identificador de solicitud de trámite
	 * @param idTipoTramite
	 * 			el identificador de tipo de trámite
	 * @param idRequisito
	 * 			el identificador de requisito
	 * @param solicitudTramiteRequisitoEstadoRequest
	 * 			requisito de solicitud de trámite a actualizar
	 * @param --
	 */
    @PutMapping("/{idSolicitudTramite}/tipo-tramite/{idTipoTramite}/requisitos/{idRequisito}/actualizar-estado")
//    @PreAuthorize("hasPermission('MAN_SOLICITUD_TRAMITE_REQUISITO','304')")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void actualizarEstadoSolicitudTramite(@Validated({ IActualizacion.class,Default.class }) 
    		 @IdNumerico(maxRange = 9999999999L)@PathVariable("idSolicitudTramite") Integer idSolicitudTramite
    		,@IdNumerico(maxRange = 9999999999L)@PathVariable("idTipoTramite") Integer idTipoTramite
    		,@IdNumerico(maxRange = 9999999999L)@PathVariable("idRequisito") Integer idRequisito
    		,@RequestBody SolicitudTramiteRequisitoEstadoRequest solicitudTramiteRequisitoEstadoRequest, Errors error)
    {	

        
        solicitudTramiteRequisitoService.actualizarEstado(idSolicitudTramite, idTipoTramite, idRequisito, solicitudTramiteRequisitoEstadoRequest);
    }    
//    @PutMapping("/{idSolicitudTramite}/tipo-tramite/{idTipoTramite}/requisitos/{idRequisito}/proceso")
//    public SolicitudTramiteRequisito procesarSolicitudTramiteRequisito(@Validated({ IActualizacion.class,Default.class }) 
//    		  @IdNumerico(maxRange = 9999999999L)@PathVariable("idSolicitudTramite") Integer idSolicitudTramite
//    		, @IdNumerico(maxRange = 9999999999L)@PathVariable("idTipoTramite") Integer idTipoTramite
//    		, @IdNumerico(maxRange = 9999999999L)@PathVariable("idRequisito") Integer idRequisito
//    		, @RequestBody ProcesoSolicitudTramiteRequisitoRequest solicitudTramiteRequisitoRequest, Errors error)
//    {
//    	        
//        return null;
//    }
   
}
