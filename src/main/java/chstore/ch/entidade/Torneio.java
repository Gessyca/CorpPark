package chstore.ch.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "torneio")
public class Torneio {

	private final static int FORMATO_INDIVIDUAL = 1;
	private final static int FORMATO_DUPLA = 2;
	private final static int FORMATO_TIME = 3;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "data_torneio")
	private Date dataTorneio;
	private int formato;
	private String local;
	private String clan;
	@ManyToOne
	@JoinColumn(name = "vencedor_1_id")
	private Jogador vencedor1;
	@ManyToOne
	@JoinColumn(name = "vencedor_2_id")
	private Jogador vencedor2;
	@ManyToOne
	@JoinColumn(name = "vencedor_3_id")
	private Jogador vencedor3;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "jogador_torneio", joinColumns = { @JoinColumn(name = "torneio_id") }, inverseJoinColumns = { @JoinColumn(name = "jogador_id") })
	private List<Jogador> jogadores = new ArrayList<>();

	public Torneio() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataTorneio() {
		return dataTorneio;
	}

	public void setDataTorneio(Date dataTorneio) {
		this.dataTorneio = dataTorneio;
	}

	public int getFormato() {
		return formato;
	}

	public void setFormato(int formato) {
		this.formato = formato;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getClan() {
		return clan;
	}

	public void setClan(String clan) {
		this.clan = clan;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public String getTipoFormatado() {
		String formatoAux = "";
		if (formato == 1) {
			formatoAux = "Individual";
		}
		if (formato == 2) {
			formatoAux = "Dupla";
		}
		if (formato == 3) {
			formatoAux = "Time";

		}
		return formatoAux;
	}

	public Jogador getVencedor1() {
		return vencedor1;
	}

	public void setVencedor1(Jogador vencedor1) {
		this.vencedor1 = vencedor1;
	}

	public Jogador getVencedor2() {
		return vencedor2;
	}

	public void setVencedor2(Jogador vencedor2) {
		this.vencedor2 = vencedor2;
	}

	public Jogador getVencedor3() {
		return vencedor3;
	}

	public void setVencedor3(Jogador vencedor3) {
		this.vencedor3 = vencedor3;
	}

	@Override
	public String toString() {
		return "Torneio [id=" + id + ", dataTorneio=" + dataTorneio
				+ ", formato=" + formato + ", local=" + local + ", clan="
				+ clan + ", jogadores=" + jogadores + "]";
	}

}
