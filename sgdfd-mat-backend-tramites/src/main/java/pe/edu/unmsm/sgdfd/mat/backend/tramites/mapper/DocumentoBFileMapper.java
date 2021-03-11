package pe.edu.unmsm.sgdfd.mat.backend.tramites.mapper;

import org.apache.ibatis.annotations.Mapper;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.DocumentoBFile;

@Mapper
public interface DocumentoBFileMapper extends MantenibleMapper<DocumentoBFile, DocumentoBFile> {

	public void mantener(String modo, DocumentoBFile objetoMantenido, String usuario);
	
}
