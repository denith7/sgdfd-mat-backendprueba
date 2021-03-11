package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.CronogramaResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.cronograma.CronogramaService;


/**
 * --
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Búsqueda de una lista de cronogramas por identificador de tipo trámite
 * 	<li>Búsqueda de una lista de cronogramas por identificador de tipo trámite y código local
 * </ul>
 * 
 * @author Miguel Moya
 * @see CronogramaResponse
 * @see CronogramaService
 */
@Validated
@RestController
@RequestMapping("/cronograma")
public class CronogramaRestController {

	private CronogramaService cronogramaService;
	
	public CronogramaRestController(CronogramaService cronogramaService) {
		this.cronogramaService =  cronogramaService;
	}
	
	/**
	 * Retorna una lista de cronogramas buscados por atributo:
	 * @param idTipoTramite
	 * 			el identificador de tipo tramite
	 * @param --
	 * @return	lista de cronogramas obtenido por búsqueda:
	 * 			{@link CronogramaResponse}
	 */
	@GetMapping("/tipo-tramite/{idTipoTramite}")
	@PreAuthorize("hasPermission('CON_CRONOGRAMA','101')")
    public List<CronogramaResponse> buscarPorIdTipoTramite(@PathVariable("idTipoTramite") Integer idTipoTramite)
    {
        return cronogramaService.buscarPorIdTipoTramite(idTipoTramite);
    }
	
	/**
	 * Retorna una lista de cronogramas buscados por atributos:
	 * @param idTipoTramite
	 * 			el identificador de tipo tramite
	 * * @param codigoLocal
	 * 			el código de local
	 * @param --
	 * @return	lista de cronogramas obtenido por búsqueda:
	 * 			{@link CronogramaResponse}
	 */
	@GetMapping("/tipo-tramite/{idTipoTramite}/local/{codigoLocal}")
	@PreAuthorize("hasPermission('CON_CRONOGRAMA','102')")
    public List<CronogramaResponse> buscarPorIdTipoTramiteYCodigoLocal(@PathVariable("idTipoTramite") Integer idTipoTramite, @PathVariable("codigoLocal") String codigoLocal)
    {
        return cronogramaService.buscarPorIdTipoTramiteYCodigoLocal(idTipoTramite,codigoLocal);
    }
}
