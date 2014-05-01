package chstore.ch;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import chstore.ch.entidade.Jogador;

@ManagedBean
public class ListarJogadoresController {

    private List<Jogador> jogadores;
    @ManagedProperty(value = "#{param.jogador}")
    private Jogador jogador;
    @Inject
    JogadorJPA jogadorJPA;

    @PostConstruct
    public void inicializar() {
	jogadores = jogadorJPA.buscarTodos();
    }

    public List<Jogador> getJogadores() {
	return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
	this.jogadores = jogadores;
    }

    public Jogador getJogador() {
	return jogador;
    }

    public void setJogador(Jogador jogador) {
	this.jogador = jogador;
    }

}
