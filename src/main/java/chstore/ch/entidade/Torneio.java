package chstore.ch.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Torneio {

	private final static int FORMATO_INDIVIDUAL = 1;
	private final static int FORMATO_DUPLA = 2;
	private final static int FORMATO_TIME = 3;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date dataTorneio;
	private String nome;
	private int formato;
	

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getFormato() {
		return formato;
	}

	public void setFormato(int formato) {
		this.formato = formato;
	}

}
