package chstore.ch.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import chstore.ch.GenericoJPA;
import chstore.ch.entidade.Jogador;

@ManagedBean
@ViewScoped
public class JogadorController {

	@Inject
	private GenericoJPA genericoJPA;
	private String dataString;
	private List<Jogador> jogadores;
	private Jogador jogadorSelecionado;
	private int idJogador;

	private Jogador jogador;

	@PostConstruct
	public void inicializar() {
		jogador = new Jogador();
		jogadores = genericoJPA.buscarTodosJogadores();
	}

	public void salvar() {

		Date data;
		try {
			data = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
			jogador.setDataNascimento(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (jogador.getId() > 0) {
			genericoJPA.atualizar(jogador);
		} else {
			genericoJPA.salvar(jogador);
		}

		inicializar();
		jogador = new Jogador();
		dataString = null;
	}

	public void editar() {

		if (jogadorSelecionado.getId() > 0) {
			genericoJPA.atualizar(jogadorSelecionado);
		}
		inicializar();

	}

	public void remover() {
		genericoJPA.remover(jogadorSelecionado.getId(), Jogador.class);
		inicializar();
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public String getDataString() {
		return dataString;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Jogador getJogadorSelecionado() {
		return jogadorSelecionado;
	}

	public void setJogadorSelecionado(Jogador jogadorSelecionado) {
		this.jogadorSelecionado = jogadorSelecionado;
	}

	public int getIdJogador() {
		return idJogador;
	}

	public void setIdJogador(int idJogador) {
		this.idJogador = idJogador;
	}

}
