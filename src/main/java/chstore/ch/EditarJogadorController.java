package chstore.ch;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import chstore.ch.entidade.Jogador;

@ManagedBean
@RequestScoped
public class EditarJogadorController {

    private Jogador jogador;
    @Inject
    private JogadorJPA jogadorJPA;

    @ManagedProperty(value = "#{param.id}")
    private int id;

    public EditarJogadorController() {
	jogador = new Jogador();
    }

    @PostConstruct
    public void inicializar() {
	buscarJogador();
    }

    public void buscarJogador() {
	jogador = jogadorJPA.buscarJogadorPorId(id);
    }

    public String editar() {
	jogadorJPA.atualizar(jogador);
	return "cadastro_jogador";
    }

    public Jogador getJogador() {
	return jogador;
    }

    public void setJogador(Jogador jogador) {
	this.jogador = jogador;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

}
