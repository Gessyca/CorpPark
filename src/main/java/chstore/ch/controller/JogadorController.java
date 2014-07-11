package chstore.ch.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import chstore.ch.GenericoJPA;
import chstore.ch.entidade.Jogador;

/**
 * 
 * @author gessyca.lm
 */
@ManagedBean
@ViewScoped
public class JogadorController {

    @Inject
    private GenericoJPA genericoJPA;
    private String dataString;
    private List<Jogador> jogadores;

    private Jogador jogador;

    private String id;

    @PostConstruct
    public void inicializar() {
	jogador = new Jogador();
	jogadores = genericoJPA.buscarTodosJogadores();

	if (id != null) {
	    jogador = genericoJPA.buscarJogadorPorId(Integer.parseInt(id));
	}
	
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

    public void remover() {

	genericoJPA
		.remover(genericoJPA.buscarJogadorPorId(Integer.parseInt(id)));
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

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

}
