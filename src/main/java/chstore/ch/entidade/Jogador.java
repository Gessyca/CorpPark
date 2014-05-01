package chstore.ch.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author gessyca.lm
 */
@Entity
public class Jogador {

    private static final int HOMEM = 1;
    private static final int MULHER = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private Date dataNascimento;
    private int sexo;

    public Jogador() {
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getTelefone() {
	return telefone;
    }

    public void setTelefone(String telefone) {
	this.telefone = telefone;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Date getDataNascimento() {
	return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
	this.dataNascimento = dataNascimento;
    }

    public int getSexo() {
	return sexo;
    }

    public void setSexo(int sexo) {
	this.sexo = sexo;
    }

    public String getSexoFormatado() {
	String sexoAux = "";
	if (sexo == 1) {
	    sexoAux = "HOMEM";

	} else {
	    sexoAux = "MULHER";

	}
	return sexoAux;
    }

}
