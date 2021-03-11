package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.multitabdet;
import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleService;
import pe.edu.unmsm.sgdfd.mat.backend.commons.service.MantenibleAuditadoService;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper.MultitabDetMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.MultitabDetResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.MultitabDetRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Ejecuta la lógica asociada a las operaciones
 * de mantenimiento del detalle de las multitablas
 * <p>
 * Esta clase, al ser un servicio {@literal @Service} de mantenimiento,
 * extiende de {@link MantenibleService}, implementa la interface {@link MultitabDetService}
 * y delega la función de acceso a la base de datos a la interface 
 * {@link MultitabDetMapper} solo para operaciones de mantenimiento. 
 *
 * @author Miguel Moya
 * @author Ximena Politi
 */
@Service
@Transactional
public class MultitabDetServiceImpl extends MantenibleAuditadoService<MultitabDetRequest, MultitabDetResponse> implements MultitabDetService {
	
	private  MultitabDetMapper multitabDetMapper;
	
	/**
     * Instancia la interface {@link MultitabDetMapper} a partir de la interface 
     * genérica {@link MantenibleMapper}  
     * 
     * @param mapper
     * 			interface genérica para las interfaces mapper de mantenimiento
     */
	public MultitabDetServiceImpl(@Qualifier("multitabDetMapper") MantenibleMapper<MultitabDetRequest, MultitabDetResponse> mantenibleMapper) {
		super(mantenibleMapper);
		this.multitabDetMapper = (MultitabDetMapper) mantenibleMapper;
	}
	
	@Override
	public List<MultitabDetResponse> buscarTodos() {
		return multitabDetMapper.buscarTodos();
	}
	
	@Override
	public MultitabDetResponse buscarPorIdMultitabCabYIdMultitabDet(Integer idMultitabCab, String idMultitabDet) {
		return multitabDetMapper.buscarPorIdMultitabCabYIdMultitabDet(idMultitabCab, idMultitabDet);
	}
	
	@Override
	public MultitabDetResponse registrarMultitabDet( MultitabDetRequest multitabDetRequest) {
		multitabDetMapper.mantener("INSERT",multitabDetRequest , multitabDetRequest.getUsuario());
		return multitabDetMapper.buscarPorIdMultitabCabYIdMultitabDet(multitabDetRequest.getIdMultitabCab(), multitabDetRequest.getIdMultitabDet());
	}
	
	@Override
	public MultitabDetResponse actualizarMultitabDet(Integer idMultitabCab, String idMultitabDet, MultitabDetRequest multitabDetRequest) {
		multitabDetRequest.setIdMultitabCab(idMultitabCab);
		multitabDetRequest.setIdMultitabDet(idMultitabDet);
		multitabDetMapper.mantener("UPDATE",multitabDetRequest , multitabDetRequest.getUsuario());
		return multitabDetMapper.buscarPorIdMultitabCabYIdMultitabDet(multitabDetRequest.getIdMultitabCab(), multitabDetRequest.getIdMultitabDet());
	}
	
	@Override
	public void eliminarMultitabDet(MultitabDetRequest multitabDetRequest) {
		eliminar(multitabDetRequest);
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<MultitabDetResponse> buscarPorIdMultitabCab(int idMultitabCab) {
		System.out.println("Buscar multitab det por cab = " + idMultitabCab);
		return this.multitabDetMapper.buscarPorIdMultitabCab(idMultitabCab);
	}
}
