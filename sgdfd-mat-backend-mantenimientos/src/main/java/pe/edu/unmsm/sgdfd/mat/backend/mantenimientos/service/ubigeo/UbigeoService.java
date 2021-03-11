package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.ubigeo;

import java.util.List;

import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.UbigeoResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.UbigeoRequest;

/**
 * Define los métodos asociados a las operaciones de mantenimiento de ubigeos,
 * ademas de incluir busquedas de todos los departamentos, provincias o distritos
 * los cuales deberán ser implementados.
 * applet and the classes an applet uses 
 * <p>
 * Esta interface extiende de {@link MantenibleService} para poder heredar 
 * los métodos comunes de mantenimiento.
 * 
 * @author Ximena Politi
 * @see MantenibleService
 * @see UbigeoRequest
 * @see UbigeoResponse
 */
public interface UbigeoService extends MantenibleService<UbigeoRequest, UbigeoResponse>
{	
	/**
	 * Retorna una lista con todos los ubigeos 	
	 */
	public List<UbigeoResponse> buscarTodos();
	
	/**
	 * Retorna una lista de ubigeos que muestra todos los departamentos.		
	 */
    public List<UbigeoResponse> buscarTodosPorDepartamentos();
    
    /**
     * Retorna una lista de ubigeos que muestra todas las provincias por departamento
	 * @param codigoDepartamento
	 * 			el código de departamento 	
	 */
    public List<UbigeoResponse> obtenerProvincias(String codigoDepartamento);
    
    /**
	 * Retorna una lista de ubigeos que muestra todos los distritos por provincia
	 * @param codigoDepartamento
	 * 			el código de departamento		
	 * @param codigoProvincia
	 * 			el código de provincia	
	 */
    public List<UbigeoResponse> obtenerDistritos(String codigoDepartamento, String codigoProvincia);
    
    /**
	 * Retorna un ubigeo por:  
	 * @param codigoUbigeo
	 * 			el código de ubigeo
	 */
    public UbigeoResponse buscarPorCodigoUbigeo(String codigoUbigeo);
    
    /**
	 * Registra un ubigeo 
	 * @param ubigeoRequest
	 * 			el ubigeo a registrar	
	 */
    public UbigeoResponse registrarUbigeo(UbigeoRequest ubigeoRequest);
	
    /**
	 * Actualiza un ubigeo 
	 * @param codigoUbigeo
	 * 			el código del ubigeo
	 * @param ubigeoRequest
	 * 			el ubigeo a actualizar	
	 */
	public UbigeoResponse actualizarUbigeo(String codigoUbigeo ,UbigeoRequest ubigeoRequest);
	
	/**
	 * Elimina un ubigeo 
	 * @param ubigeoRequest
	 * 		ubigeo a eliminar
	 */
	public void eliminarUbigeo(UbigeoRequest ubigeoRequest);
    
    
}