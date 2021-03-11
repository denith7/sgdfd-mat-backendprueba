package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pe.edu.unmsm.commons.mantenimiento.mapper.MantenibleMapper;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.filter.FormularioFilter;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.FormularioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.RequisitoFormularioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.FormularioRequest;

@Mapper
public interface FormularioMapper extends MantenibleMapper<FormularioRequest, FormularioResponse> {

	public FormularioResponse buscarPorIdFormuario(@Param("idFormulario") Integer idFormulario);

	public List<FormularioResponse> buscarPorCriterio(FormularioFilter criterioBusqueda);

	public List<FormularioResponse> buscarTodos();
	
	public List<RequisitoFormularioResponse> buscarPorRequisito(@Param("idRequisito")Integer idRequisito);
}
