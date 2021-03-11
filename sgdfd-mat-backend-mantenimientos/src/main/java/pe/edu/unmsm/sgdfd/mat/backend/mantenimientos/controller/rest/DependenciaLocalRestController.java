package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.commons.validation.validation.IdCadena;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.DependenciaLocalResponse;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.request.DependenciaLocalRequest;
import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.dependencialocal.DependenciaLocalService;

@Validated
@RestController
@RequestMapping("/dependencia-local")
public class DependenciaLocalRestController {

	private DependenciaLocalService dependenciaLocalService;
	
	public DependenciaLocalRestController(DependenciaLocalService dependenciaLocalService) {
		this.dependenciaLocalService = dependenciaLocalService;
	}
	
	@GetMapping("/")
	@PreAuthorize("hasPermission('MAN_DEPENDENCIA_LOCAL','101')")
	public List<DependenciaLocalResponse> buscarTodos() {
		return dependenciaLocalService.buscarTodos();
	}
	
	@GetMapping("/dependencia/{codigoDependencia}/local/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_DEPENDENCIA_LOCAL','102')")
	public DependenciaLocalResponse buscarPorCodigoDependenciaYCodigoLocal(
						@PathVariable("codigoDependencia") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoDependencia
					   ,@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,20}", maxLength = 20 ) String codigoLocal) {
		return dependenciaLocalService.buscarPorCodigoDependenciaYCodigoLocal(codigoDependencia, codigoLocal);
	}
	
	@PostMapping("/")
	@PreAuthorize("hasPermission('MAN_DEPENDENCIA_LOCAL','201')")
	public DependenciaLocalResponse registrarDependenciaLocal(@Valid @RequestBody DependenciaLocalRequest dependenciaLocalRequest) {
		return dependenciaLocalService.registrarDependenciaLocal(dependenciaLocalRequest);
	}
	
	@PutMapping("/dependencia/{codigoDependencia}/local/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_DEPENDENCIA_LOCAL','301')")
	public DependenciaLocalResponse actualizarDependenciaLocal(
							@PathVariable("codigoDependencia") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoDependencia
			  			   ,@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,20}", maxLength = 20 )	String codigoLocal
			  			   ,@Valid @RequestBody DependenciaLocalRequest dependenciaLocalRequest) {
		return dependenciaLocalService.actualizarDependenciaLocal(codigoDependencia, codigoLocal, dependenciaLocalRequest);
	}
	
	@DeleteMapping("/dependencia/{codigoDependencia}/local/{codigoLocal}")
	@PreAuthorize("hasPermission('MAN_DEPENDENCIA_LOCAL','401')")
	public void eliminarDependenciaLocal(
						@PathVariable("codigoDependencia") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,10}", maxLength = 10 ) String codigoDependencia
					   ,@PathVariable("codigoLocal") @IdCadena(regexpPattern = "[a-zA-Z0-9]{1,20}", maxLength = 20 ) String codigoLocal) {
		dependenciaLocalService.eliminarDependenciaLocal(DependenciaLocalRequest.builder()
															.codigoDependencia(codigoDependencia)
															.codigoLocal(codigoLocal).build());
	}
	
}
