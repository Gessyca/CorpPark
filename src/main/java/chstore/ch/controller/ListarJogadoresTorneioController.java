package chstore.ch.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import chstore.ch.GenericoJPA;
import chstore.ch.entidade.Jogador;
import chstore.ch.entidade.Torneio;

@ManagedBean
@ViewScoped
public class ListarJogadoresTorneioController implements Serializable{

	/**
   * 
   */
  private static final long serialVersionUID = -8364688478856614352L;
  private List<Jogador> jogadores;
	private Torneio torneio;
	private String vencedor1;
	private String vencedor2;
	private String vencedor3;

	@Inject
	private GenericoJPA genericoJPA;

	@PostConstruct
	public void inicializar() {
		vencedor1 = "";
		vencedor2 = "";
		vencedor3 = "";
		jogadores = genericoJPA.buscarTodosJogadores();
		torneio = genericoJPA.ultimoTorneioSalvo();
	}

	public void adicionarJogadorNoTorneio() {
		Jogador novoJogador = new Jogador();
		torneio.getJogadores().add(novoJogador);
	}

	public String atualizar() {

		if (vencedor1.length() > 0) {
			torneio.setVencedor1(adicionarVencedor(vencedor1));
			torneio.getJogadores().add(torneio.getVencedor1());
		}
		if (vencedor2.length() > 0) {
			torneio.setVencedor2(adicionarVencedor(vencedor2));
			torneio.getJogadores().add(torneio.getVencedor2());
		}
		if (vencedor3.length() > 0) {
			torneio.setVencedor3(adicionarVencedor(vencedor3));
			torneio.getJogadores().add(torneio.getVencedor3());
		}

		genericoJPA.atualizar(torneio);
		return "torneios";
	}

	public Jogador buscarJogadorPorNome(String nome) {
		return genericoJPA.buscarJogadorPorNome(nome);
	}

	public Jogador adicionarVencedor(String vencedor) {
		Jogador novoJogador = buscarJogadorPorNome(vencedor);
		if (novoJogador != null) {
			atualizarPontuacaoJogador(novoJogador, 8);
			return novoJogador;
		} else {
			return null;
		}
	}

	public void atualizarPontuacaoJogador(Jogador jogador, int pont) {
		int pontuacao = jogador.getPontuacao() + pont;
		jogador.setPontuacao(pontuacao);
		jogador.getTorneios().add(torneio);
		genericoJPA.atualizar(jogador);
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

	public String getVencedor1() {
		return vencedor1;
	}

	public void setVencedor1(String vencedor1) {
		this.vencedor1 = vencedor1;
	}

	public String getVencedor2() {
		return vencedor2;
	}

	public void setVencedor2(String vencedor2) {
		this.vencedor2 = vencedor2;
	}

	public String getVencedor3() {
		return vencedor3;
	}

	public void setVencedor3(String vencedor3) {
		this.vencedor3 = vencedor3;
	}

}
