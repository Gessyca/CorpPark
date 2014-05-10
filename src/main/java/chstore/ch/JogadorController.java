package chstore.ch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import chstore.ch.entidade.Jogador;

/**
 * 
 * @author gessyca.lm
 */
@ManagedBean
@ViewScoped
public class JogadorController {

    @Inject
    private JogadorJPA jogadorJPA;
    private String dataString;
    private List<Jogador> jogadores;

    private Jogador jogador;

    @PostConstruct
    public void inicializar() {
	jogador = new Jogador();
	jogadores = jogadorJPA.buscarTodos();
    }

    public void salvar() {

	Date data;
	try {
	    data = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
	    jogador.setDataNascimento(data);
	} catch (ParseException e) {
	    e.printStackTrace();
	}

	jogadorJPA.salvar(jogador);
	inicializar();
	jogador = new Jogador();
	dataString = null;
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

}
