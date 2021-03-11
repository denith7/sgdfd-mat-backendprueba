package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.requisito;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.RequisitoRequest;


/**
 * Define los métodos asociados a las operaciones de mantenimiento de Requisitos
 * y busquedas que retornen listas de requisitos de acuerdo a diferentes atributos,
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Miguel Moya
 * @see MantenibleService
 * @see RequisitoRequest
 * @see RequisitoResponse
 */
public interface RequisitoService extends MantenibleService<RequisitoRequest, RequisitoResponse>
{	
	/**
	 * Retorna una lista de Requisitos 	
	 */
    public List<RequisitoResponse> buscarTodos();
    
    /**
	 * Retorna un requisito por:
	 * @param idRequisito
	 * 			el identificador del requisito	
	 */
    public RequisitoResponse buscarPorIdRequisito(Integer idRequisito);

    /**
	 * Registra un requisito 
	 * @param requisitoRequest
	 * 			el requisito a registrar	
	 */
	public RequisitoResponse registrarRequisito(RequisitoRequest requisitoRequest);
	
	/**
	 * Actualiza un requisito 
	 * @param idRequisito
	 * 			el identificador del requisito
	 * @param requisitoRequest
	 * 			el requisito a actualizar	
	 */
    public RequisitoResponse actualizarRequisito(Integer idRequisito, RequisitoRequest requisitoRequest);
    
    /**
	 * Elimina un requisito 
	 * @param requisitoRequest
	 * 		requisito a eliminar
	 */
    public void eliminarRequisito(RequisitoRequest requisitoRequest);
    
    /**
	 * Retorna una lista de requisitos por:
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite	
	 */
    public List<RequisitoResponse> buscarPorIdTipoTramite(String idTipoTramite);
    
    /**
	 * Retorna una lista de requisitos por:
	 * @param idTipoTramite
	 * 			el identificador del tipo de trámite
	 * @param codigoLocal
	 * 			el código del tipo de local	
	 */
    public List<RequisitoResponse> buscarPorIdTipoTramiteYCodigoLocal(String idTipoTramite, String codigoLocal);
}