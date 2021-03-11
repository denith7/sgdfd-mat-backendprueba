package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.exportacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.TipoTramiteResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tipotramite.TipoTramiteService;

@Validated
@Controller
public class TipoTramiteExportacionController {
	
	private final TipoTramiteService tipoTramiteService;
	
	public TipoTramiteExportacionController(TipoTramiteService tipoTramiteService) {
		this.tipoTramiteService = tipoTramiteService;
	}
	
	@GetMapping(value = "/tramites.xlsx")
	public ModelAndView exportarTramites(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<TipoTramiteResponse> lista = tipoTramiteService.buscarTodos();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "mantenimientos/tramite");
      model.addAttribute("name", "Reporte de Tipos de Trámite");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}
}
