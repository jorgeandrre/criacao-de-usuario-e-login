package com.jorge.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController()
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	// GET
	@RequestMapping("/usuarios")
	public String getAllusers(Model model) {
		List<Usuario> listUsuarios = usuarioService.getAllUsers();
		model.addAttribute("listaUsuarios", listUsuarios);
		return "listall";		
	}

	// GET
	@RequestMapping("/users/{id}")
	public Usuario getUser(@PathVariable Long id) {
		return usuarioService.getUser(id);
	}

	// DELETE
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void deleteuser(@PathVariable Long id) {
		usuarioService.deleteUser(id);

	}
}
