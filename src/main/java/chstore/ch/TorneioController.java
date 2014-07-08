package chstore.ch;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import chstore.ch.entidade.Torneio;

@ManagedBean
@ViewScoped
public class TorneioController {

    private Torneio torneio;
    private List<Torneio> torneios;
    private int id;

    @Inject
    private GenericoJPA genericoJPA;

    @PostConstruct
    public void inicializar() {
	torneio = new Torneio();
	torneios = new ArrayList<>();
    }

    public void salvar() {

	genericoJPA.salvar(torneio);
    }

    public void remover() {
	genericoJPA.remover(genericoJPA.buscarTorneioPorId(id));
    }

    public Torneio getTorneio() {
	return torneio;
    }

    public void setTorneio(Torneio torneio) {
	this.torneio = torneio;
    }

    public List<Torneio> getTorneios() {
	return torneios;
    }

    public void setTorneios(List<Torneio> torneios) {
	this.torneios = torneios;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

}
