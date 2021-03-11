package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.tree;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.tree.ParentNode;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.tree.ArbolDinamicoService;

@Validated
@RestController
@RequestMapping("/arbol-dinamico")
public class ArbolDinamicoRestController {
	
	private ArbolDinamicoService arbolDinamicoService;
	
	public ArbolDinamicoRestController(ArbolDinamicoService arbolDinamicoService) {
		this.arbolDinamicoService = arbolDinamicoService;
	}
	
	@GetMapping("/{id}")
	public String arbolDinamicoJson(@PathVariable("id") Integer id) {
		List<ParentNode> data = arbolDinamicoService.buildDynamicTree(id);
		try {
			return new ObjectMapper().writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
