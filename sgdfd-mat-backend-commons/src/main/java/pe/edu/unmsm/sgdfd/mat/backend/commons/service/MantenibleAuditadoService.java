package pe.edu.unmsm.sgdfd.mat.backend.commons.service;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.commons.mantenimiento.service.MantenibleServiceImpl;
import pe.edu.unmsm.commons.seguridad.backend.util.UserUtil;

public class MantenibleAuditadoService<I,O> extends MantenibleServiceImpl<I,O> {

	public MantenibleAuditadoService() {
	
	}
	
	public MantenibleAuditadoService(MantenibleMapper<I,O> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	public void registrar(I objetoMantenido) {
		super.registrar(objetoMantenido, UserUtil.obtenerUsername());
	}
	
	@Override
	public void actualizar(I objetoMantenido) {
		super.actualizar(objetoMantenido, UserUtil.obtenerUsername());
	}
	
	@Override
	public void eliminar(I objetoMantenido) {
		super.eliminar(objetoMantenido, UserUtil.obtenerUsername());
	}
}
