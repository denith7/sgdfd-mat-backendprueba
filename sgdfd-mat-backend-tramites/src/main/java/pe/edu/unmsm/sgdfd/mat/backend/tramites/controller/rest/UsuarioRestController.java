package pe.edu.unmsm.sgdfd.mat.backend.tramites.controller.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.filter.UsuarioFilter;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.model.response.UsuarioResponse;
import pe.edu.unmsm.sgdfd.mat.backend.tramites.service.usuario.UsuarioService;

/**
 * --
 * <p>
 * Comprende las siguientes operaciones
 * <ul>
 * 	<li>Búsqueda de usuario por identificado de usuario
 * 	<li>Búsqueda de usuario por identificado de usuario y código
 * </ul>
 * 
 * @author Miguel Moya
 * @see UsuarioResponse
 * @see UsuarioService
 */
@Validated
@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Retorna un usuario buscado por atributo:
	 * @param idUsuario
	 * 			identificado de usuario
	 * @param --
	 * @return	usuario obtenido por búsqueda:
	 * 			{@link UsuarioResponse}
	 */
	 @GetMapping("/{idUsuario}")
	 @PreAuthorize("hasPermission('CON_USUARIO','101')")
	 public UsuarioResponse buscarPorIdUsuario(@PathVariable("idUsuario") String idUsuario){
	 	UsuarioFilter ud = UsuarioFilter.builder().idUsuario(idUsuario.toLowerCase()).build();
	 	List<UsuarioResponse> lsUsuarios = usuarioService.buscarPorCriterio(ud);
	 	if(lsUsuarios.isEmpty() || ud.getIdUsuario() == null) {
	 		return null;
	 	}
        return lsUsuarios.get(0);
    }
	 
	 	/**
		 * Retorna un usuario buscado por atributo:
		 * @param idUsuario
		 * 			identificado de usuario
		 * @param codigo
		 * 			--
		 * @param --
		 * @return	usuario obtenido por búsqueda:
		 * 			{@link UsuarioResponse}
		 */
	 @GetMapping("/{idUsuario}/{codigo}")
	 @PreAuthorize("hasPermission('CON_USUARIO','102')")
	 public UsuarioResponse buscarPorIdUsuarioYCodigo(@PathVariable("idUsuario") String idUsuario, @PathVariable("codigo") String codigo){
	 	UsuarioFilter ud = UsuarioFilter.builder().idUsuario(idUsuario.toLowerCase()).codigoAlumno(codigo).build();
	 	List<UsuarioResponse> lsUsuarios = usuarioService.buscarPorCriterio(ud);
	 	if(lsUsuarios.isEmpty() || ud.getIdUsuario() == null) {
	 		return null;
	 	}
        return lsUsuarios.get(0);
    }
	 
}
