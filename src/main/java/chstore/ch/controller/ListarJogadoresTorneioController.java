package chstore.ch.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import chstore.ch.GenericoJPA;
import chstore.ch.entidade.Jogador;
import chstore.ch.entidade.Torneio;

@ManagedBean
@ViewScoped
public class ListarJogadoresTorneioController {

	private List<Jogador> jogadores;
	private Torneio torneio;
	private Jogador vencedor1;
	private Jogador vencedor2;
	private Jogador vencedor3;

	@Inject
	private GenericoJPA genericoJPA;

	@PostConstruct
	public void inicializar() {
		vencedor1 = new Jogador();
		vencedor2 = new Jogador();
		vencedor3 = new Jogador();
		jogadores = genericoJPA.buscarTodosJogadores();
		torneio = genericoJPA.ultimoTorneioSalvo();
	}

	public void adicionarJogadorNoTorneio() {
		Jogador novoJogador = new Jogador();
		torneio.getJogadores().add(novoJogador);
	}

	public void finalizarTorneio() {
		genericoJPA.atualizar(torneio);
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Torneio getTorneio() {
		return torneio;
	}

	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
	}

	public Jogador getVencedor1() {
		return vencedor1;
	}

	public void setVencedor1(Jogador vencedor1) {
		this.vencedor1 = vencedor1;
	}

	public Jogador getVencedor2() {
		return vencedor2;
	}

	public void setVencedor2(Jogador vencedor2) {
		this.vencedor2 = vencedor2;
	}

	public Jogador getVencedor3() {
		return vencedor3;
	}

	public void setVencedor3(Jogador vencedor3) {
		this.vencedor3 = vencedor3;
	}

}
