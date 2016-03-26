package chstore.ch.entidade

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table

@Entity
@Table(name = "veiculo")
class Veiculo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id
	String modelo
	String tipo
	String marca
	String placa
	String cor
	@ManyToOne
	@JoinColumn(name='id_colaborador')
	Jogador jogador
}