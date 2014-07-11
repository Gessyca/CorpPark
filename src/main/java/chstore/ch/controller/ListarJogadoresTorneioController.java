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

    @Inject
    private GenericoJPA genericoJPA;

    @PostConstruct
    public void inicializar() {
	jogadores = genericoJPA.buscarTodosJogadores();
	torneio = genericoJPA.ultimoTorneioSalvo();
	System.out.println(torneio.getLocal());
    }

    public void adicionarJogadorNoTorneio() {

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

}
