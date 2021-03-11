package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.ConfiguracionTramiteFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.ConfiguracionTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.CronogramaVigenteRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteDestinatarioRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteLocalRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.TipoTramiteLocalRequisitoRequest;

@Mapper
public interface ConfiguracionTramiteMapper {

	public ConfiguracionTramiteResponse buscarPorIdTipoTramiteYCodigoLocal(@Param("idTipoTramite") Integer idTipoTramite, @Param("codigoLocal")String codigoLocal);
	
	public void prcConfiguracionLocal (TipoTramiteLocalRequest tipoTramiteLocalRequest);
	
	public void prcConfiguracionRequisito (TipoTramiteLocalRequisitoRequest tipoTramiteLocalRequisitoRequest);
	
	public void prcConfiguracionCronograma (CronogramaVigenteRequest cronogramaVigenteRequest);
	
	public void prcConfiguracionDestinatario (TipoTramiteDestinatarioRequest tipoTramiteDestinatarioRequest);
	
	public List<ConfiguracionTramiteFilter> filtrarTramites(ConfiguracionTramiteFilter configuracionTramiteFilter);
	
}
