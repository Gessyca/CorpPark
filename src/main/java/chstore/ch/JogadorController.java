package chstore.ch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import chstore.ch.entidade.Jogador;

/**
 * 
 * @author gessyca.lm
 */
@ManagedBean
public class JogadorController {

    @Inject
    JogadorJPA jogadorJPA;
    private String dataString;

    private Jogador jogador = new Jogador();

    public String salvar() {

	Date data;
	try {
	    data = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
	    jogador.setDataNascimento(data);
	} catch (ParseException e) {
	    e.printStackTrace();
	}

	jogadorJPA.salvar(jogador);
	return "jogador";
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

}
