package chstore.ch.controller;

import java.io.Serializable;
import java.util.ArrayList;
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
public class RankingController implements Serializable{

    private List<Jogador> jogadores;
    private List<Torneio> qtdTotalTorneios;
    
    @Inject
    private GenericoJPA genericoJPA;

    @PostConstruct
    public void inicializar() {
	jogadores = new ArrayList<>();
	jogadores = genericoJPA.buscarJogadoresOrdemPontuacao();
	qtdTotalTorneios = genericoJPA.buscarTodosTorneios();
    }

    public List<Jogador> getJogadores() {
	return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
	this.jogadores = jogadores;
    }

    public List<Torneio> getQtdTotalTorneios() {
	return qtdTotalTorneios;
    }

    public void setQtdTotalTorneios(List<Torneio> qtdTotalTorneios) {
	this.qtdTotalTorneios = qtdTotalTorneios;
    }

}
