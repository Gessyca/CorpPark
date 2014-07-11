package chstore.ch.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private String nome;
    private int formato;
    private String local;
    @Column(name = "qtd_jogadores")
    private String cla;

    @OneToMany(mappedBy = "torneio", fetch = FetchType.EAGER)
    private List<Jogador> vencedores;

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

    public String getLocal() {
	return local;
    }

    public void setLocal(String local) {
	this.local = local;
    }

    public String getCla() {
	return cla;
    }

    public void setCla(String cla) {
	this.cla = cla;
    }
    

    public List<Jogador> getVencedores() {
        return vencedores;
    }

    public void setVencedores(List<Jogador> vencedores) {
        this.vencedores = vencedores;
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

}
