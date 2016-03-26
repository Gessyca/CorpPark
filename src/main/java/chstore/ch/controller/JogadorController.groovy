package chstore.ch.controller

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.List

import javax.annotation.PostConstruct
import javax.faces.bean.ManagedBean
import javax.faces.bean.ViewScoped
import javax.inject.Inject

import chstore.ch.GenericoJPA
import chstore.ch.entidade.Jogador

@ManagedBean
@ViewScoped
public class JogadorController {

	@Inject
	private GenericoJPA genericoJPA
	String dataString
	List<Jogador> jogadores
	Jogador jogadorSelecionado
	int idJogador

	Jogador jogador

	@PostConstruct
	public void inicializar() {
		jogador = new Jogador()
		jogadores = genericoJPA.buscarTodosJogadores()
	}

	public void salvar() {

		if (jogador.getId() > 0) {
			genericoJPA.atualizar(jogador)
		} else {
			genericoJPA.salvar(jogador)
		}

		inicializar()
		jogador = new Jogador()
		dataString = null
	}

	public void editar() {

		if (jogadorSelecionado.getId() > 0) {
			genericoJPA.atualizar(jogadorSelecionado)
		}
		inicializar()
	}

	public void remover() {
		genericoJPA.remover(jogadorSelecionado.getId(), Jogador.class)
		inicializar()
	}
}
