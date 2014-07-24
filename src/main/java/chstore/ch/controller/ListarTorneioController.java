package chstore.ch.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import chstore.ch.GenericoJPA;
import chstore.ch.entidade.Torneio;

@ManagedBean
@ViewScoped
public class ListarTorneioController implements Serializable{

	/**
   * 
   */
  private static final long serialVersionUID = -6713627153575751162L;
  private Torneio novoTorneio;
	private List<Torneio> torneios;
	private String dataHoje = "";
	private String id;

	@Inject
	private GenericoJPA genericoJPA;

	@PostConstruct
	public void inicializar() {
		novoTorneio = new Torneio();
		dataHoje = new SimpleDateFormat("dd/MM/YYYY").format(new Date());
		torneios = genericoJPA.buscarTodosTorneios();
	}

	public String salvar() {
		try {
			novoTorneio.setDataTorneio(new SimpleDateFormat("dd/MM/yyyy")
					.parse(dataHoje));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		genericoJPA.salvar(novoTorneio);

		return "novo_torneio";
	}

	public void remover() {
		genericoJPA.remover(Integer.parseInt(id), Torneio.class);
	}

	public void visualizarJogadores() {
		novoTorneio = genericoJPA.buscarTorneioPorId(Integer.parseInt(id));
		System.out.println(novoTorneio);
	}

	public Torneio getNovoTorneio() {
		return novoTorneio;
	}

	public void setNovoTorneio(Torneio novoTorneio) {
		this.novoTorneio = novoTorneio;
	}

	public List<Torneio> getTorneios() {
		return torneios;
	}

	public void setTorneios(List<Torneio> torneios) {
		this.torneios = torneios;
	}

	public String getDataHoje() {
		return dataHoje;
	}

	public void setDataHoje(String dataHoje) {
		this.dataHoje = dataHoje;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
