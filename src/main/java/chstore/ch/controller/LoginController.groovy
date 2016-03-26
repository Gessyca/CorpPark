package chstore.ch.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import chstore.ch.entidade.Usuario;

@ManagedBean
@RequestScoped
public class LoginController {

	private Usuario usuario;

	public void logar() {

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
